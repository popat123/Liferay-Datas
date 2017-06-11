package com.jio.portlet.jurys.helper;

import com.jio.portlet.jurys.helper.JurysPortletConstants;
import com.jio.portlet.jurys.helper.JurysPortletHelper;
import com.jio.portlet.jurys.model.Jurys;
import com.jio.portlet.jurys.model.impl.JurysImpl;
import com.jio.portlet.jurys.service.JurysLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropertiesUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileShortcut;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderServiceUtil;
import com.liferay.util.portlet.PortletProps;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class JurysPortletHelper {
	
private static final Log LOGGER = LogFactoryUtil.getLog(JurysPortletHelper.class);

	public static void permissionChecker(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
	
		PermissionChecker permissionChecker = themeDisplay
				.getPermissionChecker();
		
		renderRequest.setAttribute("permissionCheck", (permissionChecker
				.isOmniadmin() || permissionChecker.isGroupAdmin(themeDisplay
				.getScopeGroupId())));
	}

	
	public static void displayJurys(RenderRequest request,RenderResponse response) {
		
		LOGGER.info("===== call Display Jurys Method =======");
		String[] categories = PortletProps.getArray("category");
		request.setAttribute("categories", categories);
		
		long jurysId = ParamUtil.getLong(request, "jurysId");
		
		Jurys jury;
		try {
			if(jurysId != 0){
				jury = JurysLocalServiceUtil.getJurys(jurysId);
				request.setAttribute("jurys", jury);
			}
			
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		} catch (SystemException e) {
			LOGGER.error(e.getMessage());
		}
		
		
		PortletURL iteratorURL = response.createRenderURL();
        iteratorURL = PortletURLUtil.getCurrent(request, response);
        SearchContainer<Jurys> searchContainer = new SearchContainer<Jurys>(request, null, null, SearchContainer.DEFAULT_CUR_PARAM, 5, iteratorURL, null, "there-are-no-jury");
        searchContainer.setDeltaConfigurable(true);

		try {
			List<Jurys> jurys = JurysLocalServiceUtil.getJuryses(searchContainer.getStart(), searchContainer.getEnd());
			searchContainer.setTotal(JurysLocalServiceUtil.getJurysesCount());
	        searchContainer.setResults(jurys);
		} catch (SystemException e) {
			LOGGER.error(e.getMessage());
		}
        
        request.setAttribute("jurysSearchContainer", searchContainer);

	}
	public static void addEditMentors(ActionRequest request,
			ActionResponse response){
		LOGGER.info("=====Call add/Edit Jurys =====");
		
		UploadPortletRequest uploadPortletRequest=PortalUtil.getUploadPortletRequest(request);
		String name=ParamUtil.getString(uploadPortletRequest, JurysPortletConstants.Name);
		String companyName=ParamUtil.getString(uploadPortletRequest, JurysPortletConstants.Company_Name);
		String category=ParamUtil.getString(uploadPortletRequest, JurysPortletConstants.Category);
		String shortDescription=ParamUtil.getString(uploadPortletRequest, JurysPortletConstants.Short_Description);
		String longDescription=ParamUtil.getString(uploadPortletRequest, JurysPortletConstants.Long_Description);
		long number=ParamUtil.getLong(uploadPortletRequest, JurysPortletConstants.Number);
		long jurysId=ParamUtil.getLong(uploadPortletRequest, JurysPortletConstants.JurysId);
		
		
		Jurys jurys = null;
		long fileEntryId = 0;
		try {
			if(jurysId != 0){
				jurys = JurysLocalServiceUtil.getJurys(jurysId);
				fileEntryId = jurys.getJuryImage();
			}
						
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		} catch (SystemException e) {
			LOGGER.error(e.getMessage());
		}
				
		FileEntry  fileEntry = getJurysImage(request, response, uploadPortletRequest, JurysPortletConstants.Jury_Images, PortletProps.get(JurysPortletConstants.Jury_Image_Folder),fileEntryId);				
				
		
		if(Validator.isNotNull(fileEntry)){
			fileEntryId = fileEntry.getFileEntryId();
		}else{
			fileEntryId = jurys.getJuryImage();
		}
		
		if(Validator.isNotNull(jurysId)){
			updateJurys(jurysId,name, companyName,category, shortDescription, longDescription, fileEntryId,number);
		}else{
			addJurys(name,companyName,category, shortDescription,longDescription,fileEntryId,number);
		}
		
	}
	
	private static Jurys addJurys(String name,String companyName,String category,String shortDescription,String longDescription,long juryImageId,long number){
		
		LOGGER.info("=== call add Jurys method===");
		
		
		
		Jurys jurys = null;
		try {
			
			
			jurys = JurysLocalServiceUtil.createJurys(CounterLocalServiceUtil.increment(Jurys.class.getName()));
			
			jurys.setName(name);
			jurys.setCompanyName(companyName);
			jurys.setCategory(category);
			jurys.setShortDescription(shortDescription);
			jurys.setLongDescription(longDescription);
			jurys.setNumber(number);
			jurys.setJuryImage(juryImageId);
			
			
			JurysLocalServiceUtil.addJurys(jurys);
		}catch(Exception e){
			LOGGER.error(e.getMessage());
		}
					
		return jurys;
		
	}
	
	private static Jurys updateJurys(long jurysId,String name,String companyName,String category,String shortDescription,String longDescription,long juryImageId,long number){
		
		LOGGER.info("=== call update Jurys method===");
		Jurys jurys = new JurysImpl();
		try {
			jurys.setJurysId(jurysId);
			jurys.setName(name);
			jurys.setCompanyName(companyName);
			jurys.setCategory(category);
			jurys.setShortDescription(shortDescription);
			jurys.setLongDescription(longDescription);
			jurys.setNumber(number);
			jurys.setJuryImage(juryImageId);
			
			JurysLocalServiceUtil.updateJurys(jurys);
		}catch(Exception e){
			LOGGER.error(e.getMessage());
		}
			
		
		return jurys;	
	}
		
	public static void deleteJuryRecord(ActionRequest request,ActionResponse response){
		LOGGER.info("==== Call delete Jury Method =====");
		
		long jurysId= ParamUtil.getLong(request, "jurysId");
		
		try {
			Jurys jurys = JurysLocalServiceUtil.deleteJurys(jurysId);
			long juryImageId = jurys.getJuryImage();
			
			if(juryImageId != 0){
				DLAppLocalServiceUtil.deleteFileEntry(juryImageId);
			}
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		} catch (SystemException e) {
			LOGGER.error(e.getMessage());
		}
		
	}
	
	private static FileEntry getJurysImage(ActionRequest request,ActionResponse response, UploadPortletRequest uploadRequest, String imagePath, String imageFolderName,long fileEntryId){
		 
		 ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		 long groupId=themeDisplay.getLayout().getGroupId();
		 long parentFolderId=DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		 
		 File file=uploadRequest.getFile(imagePath);
		 ServiceContext serviceContext = null;
		  
		 LOGGER.info("file"+file);
		 String imageName= uploadRequest.getFileName(imagePath);
		 LOGGER.info("folder Name"+imageFolderName);
		 FileEntry fileEntry = null;		
		 if(imageName != StringPool.BLANK){	
			 
			 DLFolder dir=null;
			 try{
				 dir=DLFolderLocalServiceUtil.getFolder(groupId, parentFolderId, imageFolderName);
			 }catch(Exception e){
				 LOGGER.error("Error while getting folder ::> "+e.getMessage());
			 }
			 String[] viewAccess = {ActionKeys.VIEW};
			 if(dir == null){
				 long repositoryId = themeDisplay.getScopeGroupId();
				 try {
					serviceContext = ServiceContextFactory.getInstance(DLFileShortcut.class.getName(), request);
					dir=DLFolderServiceUtil.addFolder(groupId, repositoryId, false, parentFolderId, imageFolderName, null, serviceContext);
					
					ResourcePermissionLocalServiceUtil.setResourcePermissions(themeDisplay.getCompanyId(), DLFolder.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,""+dir.getFolderId(), RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(),"Guest").getRoleId(), viewAccess);
				} catch (PortalException e) {
					LOGGER.error("Error while adding folder ::> "+e.getMessage());
				} catch (SystemException e) {	
					LOGGER.error("Error while adding folder ::> "+e.getMessage());
				}
			 }
			 			 
			 try {
				 Date date= new Date();
				 Folder folder = DLAppLocalServiceUtil.getFolder(dir.getFolderId());
				 serviceContext = ServiceContextFactory.getInstance(DLFileShortcut.class.getName(), request);
				
				     LOGGER.info("=======Checking entry file ID while updated in Document Media===== "+fileEntryId);
				 if (Validator.isNotNull(fileEntryId) && fileEntryId > 0) {
						// update
					 LOGGER.info("++++Call Update Mentors FileEntry++++");
					  fileEntry = DLAppLocalServiceUtil.updateFileEntry(themeDisplay.getUserId(), fileEntryId, imageName, MimeTypesUtil.getContentType(file), imageName, StringPool.BLANK, StringPool.BLANK, false, file, serviceContext);
							  
					  LOGGER.info("++++++++ Mentors fileEntry ID++++: "+fileEntry.getFileEntryId() );
					  LOGGER.info("FileEntry======"+fileEntry);
					  
					} else {
						
						 fileEntry = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(), folder.getRepositoryId(), folder.getFolderId(), imageName, MimeTypesUtil.getContentType(file), date.getTime()+imageName, StringPool.BLANK, StringPool.BLANK, file, new ServiceContext());

					}
					 				 
				 ResourcePermissionLocalServiceUtil.setResourcePermissions(themeDisplay.getCompanyId(), DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,""+fileEntry.getFileEntryId(), RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(),"Guest").getRoleId(), viewAccess);
				 
			 } catch (PortalException e) {
					LOGGER.error("Error while adding fileEntry ::> "+e.getMessage());
			 } catch (SystemException e) {
					LOGGER.error("Error while adding fileEntry ::> "+e.getMessage());
			 } catch (Exception e) {
				 	LOGGER.error(e.getMessage());
			 }
		 }
		 
		return fileEntry;
	}
	

}
