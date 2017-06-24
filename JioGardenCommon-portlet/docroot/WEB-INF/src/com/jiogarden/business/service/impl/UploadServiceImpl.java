package com.jiogarden.business.service.impl;

import com.jiogarden.business.service.UploadService;
import com.jiogarden.log.Logger;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.upload.UploadRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.portlet.PortletRequest;

public class UploadServiceImpl implements UploadService {

	private static final long PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
	private static final String FOLDER_NAME = "Common";
	private static final String FOLDER_DESCRIPTION = "Common Images";

	static Logger log = Logger.getInstance();

	@Override
	public long getFileEntryId(PortletRequest portletRequest,
			UploadRequest uploadRequest, String fileInputName,
			String description, long fileEntryId, String folderName,
			String folderDescription) {
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		File file = uploadRequest.getFile(fileInputName);
		if (Validator.isNotNull(file.length())) {
			Folder folder = getFolder(portletRequest, themeDisplay, folderName,
					folderDescription);
			if (Validator.isNotNull(folder)) {
				FileEntry fileEntry = uploadFile(portletRequest, themeDisplay,
						folder, file, description, fileEntryId);
				if (Validator.isNotNull(fileEntry)) {
					fileEntryId = fileEntry.getFileEntryId();
				}
			}
		}

		return fileEntryId;
	}

	/**
	 * Get File Entry after uploading in file in folder, if folder not exist
	 * then it create and then upload, if file already exist then update the
	 * fileEntry
	 * 
	 * @param portletRequest
	 * @param uploadRequest
	 * @param fileInputName
	 *            - input name for fetching file
	 * @param description
	 *            - file description
	 * @param fileEntryId
	 *            - alredy existed fileEntryId
	 * 
	 * @return FileEntryId
	 */
	@Override
	public long getFileEntryId(PortletRequest portletRequest,
			UploadRequest uploadRequest, String fileInputName,
			String description, long fileEntryId) {
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		File file = uploadRequest.getFile(fileInputName);
		if (Validator.isNotNull(file.length())) {
			Folder folder = getFolder(portletRequest, themeDisplay,
					FOLDER_NAME, FOLDER_DESCRIPTION);
			if (Validator.isNotNull(folder)) {
				FileEntry fileEntry = uploadFile(portletRequest, themeDisplay,
						folder, file, description, fileEntryId);
				if (Validator.isNotNull(fileEntry)) {
					fileEntryId = fileEntry.getFileEntryId();
				}
			}
		}

		return fileEntryId;
	}

	/**
	 * 
	 * Get File Entry after uploading in file in folder, if folder not exist
	 * then it create and then upload
	 * 
	 * @param portletRequest
	 * @param uploadRequest
	 * @param fileInputName
	 *            - input name for fetching file
	 * @param description
	 *            - file description
	 * @return
	 */
	@Deprecated
	@Override
	public long getFileEntryId(PortletRequest portletRequest,
			UploadRequest uploadRequest, String fileInputName,
			String description) {
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Folder folder = getFolder(portletRequest, themeDisplay, FOLDER_NAME,
				FOLDER_DESCRIPTION);
		File file = uploadRequest.getFile(fileInputName);
		long fileEntryId = GetterUtil.DEFAULT_LONG;
		if (Validator.isNotNull(file.length()) && Validator.isNotNull(folder)) {
			FileEntry fileEntry = uploadFile(portletRequest, themeDisplay,
					folder, file, description);
			if (Validator.isNotNull(fileEntry)) {
				fileEntryId = fileEntry.getFileEntryId();
			}
		}
		return fileEntryId;
	}

	/**
	 * 
	 * @param portletRequest
	 * @param themeDisplay
	 * @param name
	 *            - folder name
	 * @param description
	 *            - folder description
	 * @return
	 */
	private static Folder getFolder(PortletRequest portletRequest,
			ThemeDisplay themeDisplay, String name, String description) {
		long repositoryId = themeDisplay.getScopeGroupId();
		Folder folder = null;
		try {
			folder = DLAppServiceUtil.getFolder(repositoryId, PARENT_FOLDER_ID,
					name);
			log.info(UploadServiceImpl.class, "Folder is exist");
		} catch (Exception e) {
			log.info(UploadServiceImpl.class, "Folder not exist");
			folder = createFolder(portletRequest, themeDisplay, name,
					description);
			log.info(UploadServiceImpl.class, "Folder is created");

		}

		return folder;
	}

	/**
	 * 
	 * @param portletRequest
	 * @param themeDisplay
	 * @param name
	 *            - folder name
	 * @param description
	 *            - folder description
	 * @return
	 */
	private static Folder createFolder(PortletRequest portletRequest,
			ThemeDisplay themeDisplay, String name, String description) {
		long repositoryId = themeDisplay.getScopeGroupId();
		long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		Folder folder = null;
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					DLFolder.class.getName(), portletRequest);
			serviceContext.setAddGuestPermissions(true);
			folder = DLAppServiceUtil.addFolder(repositoryId, parentFolderId,
					name, description, serviceContext);
		} catch (Exception e) {
			log.error(UploadServiceImpl.class, e.toString());
			log.info(UploadServiceImpl.class, "Folder not creating");
		}
		return folder;
	}

	/**
	 * 
	 * @param portletRequest
	 * @param themeDisplay
	 * @param folder
	 * @param file
	 * @param description
	 *            - file description
	 * @return
	 */
	@Deprecated
	private static FileEntry uploadFile(PortletRequest portletRequest,
			ThemeDisplay themeDisplay, Folder folder, File file,
			String description) {
		long repositoryId = themeDisplay.getScopeGroupId();
		String mimeType = MimeTypesUtil.getContentType(file);
		String title = file.getName();
		String changeLog = "Client image upload for client speak details";
		FileEntry fileEntry = null;
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					DLFileEntry.class.getName(), portletRequest);
			serviceContext.setAddGuestPermissions(true);
			InputStream is = new FileInputStream(file);
			fileEntry = DLAppServiceUtil.addFileEntry(repositoryId,
					folder.getFolderId(), file.getName(), mimeType, title,
					description, changeLog, is, file.length(), serviceContext);
			log.info(UploadServiceImpl.class, "FileEntry is added");
		} catch (Exception e) {
			log.error(UploadServiceImpl.class, e.toString());
			log.info(UploadServiceImpl.class, "FileEntry not creating");
		}

		return fileEntry;
	}

	/**
	 * 
	 * 
	 * @param portletRequest
	 * @param themeDisplay
	 * @param folder
	 * @param file
	 * @param description
	 * @param fileEntryId
	 *            - alredy existed fileEntryId
	 * @return
	 */
	private static FileEntry uploadFile(PortletRequest portletRequest,
			ThemeDisplay themeDisplay, Folder folder, File file,
			String description, long fileEntryId) {
		long repositoryId = themeDisplay.getScopeGroupId();
		String mimeType = MimeTypesUtil.getContentType(file);
		String title = file.getName();
		String changeLog = "document upload programtically";
		FileEntry fileEntry = null;
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					DLFileEntry.class.getName(), portletRequest);
			serviceContext.setAddGuestPermissions(true);
			InputStream is = new FileInputStream(file);

			if (Validator.isNotNull(fileEntryId) && fileEntryId > 0) {
				// update
				fileEntry = DLAppServiceUtil.updateFileEntry(fileEntryId,
						file.getName(), mimeType, title, description,
						changeLog, true, is, file.length(), serviceContext);
				log.info(UploadServiceImpl.class, "FileEntry is updated");
			} else {
				// add
				fileEntry = DLAppServiceUtil.addFileEntry(repositoryId,
						folder.getFolderId(), file.getName(), mimeType, title,
						description, changeLog, is, file.length(),
						serviceContext);
				log.info(UploadServiceImpl.class, "FileEntry is added");
			}

		} catch (Exception e) {
			log.error(UploadServiceImpl.class, e.toString());
			log.info(UploadServiceImpl.class, "FileEntry not creating");
		}

		return fileEntry;
	}

}
