package com.jiogarden.business.service;

import com.liferay.portal.kernel.upload.UploadRequest;

import javax.portlet.PortletRequest;

public interface UploadService {

	/**
	 * 
	 * @param portletRequest
	 * @param uploadRequest
	 * @param fileInputName
	 *            - input name for fetching file
	 * @param description
	 *            - file description
	 * @param fileEntryId
	 *            - alredy existed fileEntryId
	 * @param fileEntryId
	 * @param FOLDER_NAME
	 *            - folder name which you want to upload the document
	 * @param FOLDER_DESCRIPTION
	 *            - if folder is not exist that time use this description
	 * 
	 * @return FileEntryId
	 */

	public long getFileEntryId(PortletRequest portletRequest,
			UploadRequest uploadRequest, String fileInputName,
			String description, long fileEntryId, String folderName,
			String folderDescription);

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
	public long getFileEntryId(PortletRequest portletRequest,
			UploadRequest uploadRequest, String fileInputName,
			String description, long fileEntryId);

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
	public long getFileEntryId(PortletRequest portletRequest,
			UploadRequest uploadRequest, String fileInputName,
			String description);

}
