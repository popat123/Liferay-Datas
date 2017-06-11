package com.jio.portlet.startups.helper;

import com.jio.portlet.startups.model.Startups;
import com.jio.portlet.startups.model.impl.StartupsImpl;
import com.jio.portlet.startups.service.StartupsLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
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
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.liferay.util.portlet.PortletProps;
import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletURL;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;

import org.hsqldb.SessionManager;

public class StartupsHelper {
	private static final Log LOGGER = LogFactoryUtil.getLog(StartupsHelper.class);
	
	public static void permissionChecker(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		PermissionChecker permissionChecker = themeDisplay
				.getPermissionChecker();
		
		renderRequest.setAttribute("permissionCheck", (permissionChecker
				.isOmniadmin() || permissionChecker.isGroupAdmin(themeDisplay
				.getScopeGroupId())));
	}
	
	
public static void displayStartups(RenderRequest request,RenderResponse response) {
		
		LOGGER.info("===== call Display Startups Method =======");
		
//		String[] categories = PortletProps.getArray(StartupsConstants.Category);
//		request.setAttribute("categories", categories);
		
		PortletPreferences prefs=request.getPreferences();
		String str = prefs.getValue("category", "");
		request.setAttribute("categories", StringUtil.split(str));
		
		String cmd=ParamUtil.getString(request, Constants.CMD);
		//LOGGER.info("CMD==="+cmd);
		if(Validator.isNotNull(cmd)){
			
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			long startupsId=ParamUtil.getLong(request, StartupsConstants.StartupsId);
			long startupImageId=ParamUtil.getLong(request, StartupsConstants.Startup_Images);
			long youtubeImageId=ParamUtil.getLong(request, StartupsConstants.Youtube_Images);
			FileEntry startupImages;
			FileEntry youtubeImages;
			try {
				if(startupImageId != 0){
					startupImages = DLAppLocalServiceUtil.getFileEntry(startupImageId);
					String startupURL=DLUtil.getPreviewURL(startupImages, startupImages.getFileVersion(), themeDisplay, StringPool.BLANK);
	//				LOGGER.info("startupURL==="+startupURL);
					request.setAttribute("startupURL", startupURL);
				}
				if(youtubeImageId != 0){
					youtubeImages = DLAppLocalServiceUtil.getFileEntry(youtubeImageId);
					String youtubeURL=DLUtil.getPreviewURL(youtubeImages, youtubeImages.getFileVersion(), themeDisplay, StringPool.BLANK);
	//				LOGGER.info("youtubeURL==="+youtubeURL);
					request.setAttribute("youtubeURL", youtubeURL);
				}
				
			} catch (PortalException e1) {
				e1.printStackTrace();
			} catch (SystemException e1) {
				e1.printStackTrace();
			}
			
			Startups startups;
			try {
				if(startupsId != 0){
					startups = StartupsLocalServiceUtil.getStartups(startupsId);
					request.setAttribute("startups", startups);
				}
				
			} catch (PortalException e) {
				LOGGER.error(e.getMessage());
			} catch (SystemException e) {
				LOGGER.error(e.getMessage());
			}
			
		if(cmd.equals(StartupsConstants.Display_Startups)){
			
		
			PortletURL iteratorURL = response.createRenderURL();
	        iteratorURL = PortletURLUtil.getCurrent(request, response);
	        SearchContainer<Startups> searchContainer = new SearchContainer<Startups>(request, null, null, SearchContainer.DEFAULT_CUR_PARAM, 5, iteratorURL, null, "there-are-no-starups-records");
	        searchContainer.setDeltaConfigurable(true);
	
			try {
				List<Startups> startup = StartupsLocalServiceUtil.getStartupses(searchContainer.getStart(), searchContainer.getEnd());
				searchContainer.setTotal(StartupsLocalServiceUtil.getStartupsesCount());
		        searchContainer.setResults(startup);
			} catch (SystemException e) {
				LOGGER.error(e.getMessage());
			}
	        
	        request.setAttribute("startupsSearchContainer", searchContainer);
		}    
	      
		}

	}
	

	public static void addEditStartups(ActionRequest request,
			ActionResponse response) {
		LOGGER.info("===== call add/Edit Startups =====");
		
		UploadPortletRequest uploadPortletRequest=PortalUtil.getUploadPortletRequest(request);
		String name=ParamUtil.getString(uploadPortletRequest, StartupsConstants.Name);
		String companyName=ParamUtil.getString(uploadPortletRequest, StartupsConstants.Company_Name);
		String category=ParamUtil.getString(uploadPortletRequest, StartupsConstants.Category);
		String startupDesc=ParamUtil.getString(uploadPortletRequest, StartupsConstants.StartupDesc);
		String shortDescription=ParamUtil.getString(uploadPortletRequest, StartupsConstants.Short_Description);
		String longDescription=ParamUtil.getString(uploadPortletRequest, StartupsConstants.Long_Description);
		String twitter=ParamUtil.getString(uploadPortletRequest, StartupsConstants.Twitter);
		String linkedIn=ParamUtil.getString(uploadPortletRequest, StartupsConstants.LinkedIn);
		String youTube=ParamUtil.getString(uploadPortletRequest, StartupsConstants.YouTube);
		String youtubeLink=ParamUtil.getString(uploadPortletRequest, StartupsConstants.Youtube_Links);
		long number=ParamUtil.getLong(uploadPortletRequest, StartupsConstants.Number);
		long startupsId=ParamUtil.getLong(uploadPortletRequest, StartupsConstants.StartupsId);
		
		
		if(category.equalsIgnoreCase("other")){
			String newCategory=ParamUtil.getString(uploadPortletRequest, "newCategory");
			//LOGGER.info("newCategory======"+newCategory);
			if(Validator.isNotNull(newCategory)){
				setPreference(request, response, newCategory);
				category=newCategory;
			}
		}
		//LOGGER.info("Category==="+category);
		
		
		long startupImageId=0;
		long youtubeImageId=0;
		Startups startups = null;
		try {
			if(startupsId !=0){
				startups = StartupsLocalServiceUtil.getStartups(startupsId);
				startupImageId = startups.getStartupImage();
				youtubeImageId = startups.getYoutubeImages();
			}
			
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		} catch (SystemException e) {
			LOGGER.error(e.getMessage());
		}
		
//		LOGGER.info("StartupsImageId======"+startups.getStartupImage());
		FileEntry fileEntry = getStartupsImage(request, response, uploadPortletRequest, StartupsConstants.Startup_Images, PortletProps.get(StartupsConstants.Startup_Image_Folder),startupImageId);
		
		if(Validator.isNotNull(fileEntry)){
			startupImageId=fileEntry.getFileEntryId();
		}else{
			startupImageId = startups.getStartupImage();
		}
		
		FileEntry VideofileEntry = getStartupsImage(request, response, uploadPortletRequest, StartupsConstants.Youtube_Images, PortletProps.get(StartupsConstants.Youtube_Image_Folder),youtubeImageId);
		if(Validator.isNotNull(VideofileEntry)){
			youtubeImageId=VideofileEntry.getFileEntryId();
		}else if(startupsId != 0){
			youtubeImageId = startups.getYoutubeImages();
		}
		
		if(Validator.isNotNull(startupsId)){
			updateStartups(startupsId,name, companyName, category,startupDesc, shortDescription, longDescription, startupImageId,youtubeImageId, twitter, linkedIn, youTube, youtubeLink,number);
			SessionMessages.add(request, "Startups-updated");
			
		}else{
			addStartups(name, companyName, category, startupDesc, shortDescription, longDescription, startupImageId, youtubeImageId, twitter, linkedIn, youTube, youtubeLink, number);
			SessionMessages.add(request, "Startups-added");
		}
		
	}
	
	private static void setPreference(ActionRequest request,ActionResponse response,String category){
		
		PortletPreferences prefs=request.getPreferences();
	      try {
	    	  String str = prefs.getValue("category", "");
	    	  str = StringUtil.add(str, category);
	    	  
	    	  prefs.setValue("category", str);
	    	  prefs.store();
			
		} catch (ReadOnlyException e) {
			e.printStackTrace();
		}catch (ValidatorException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	     		
	}
	
	
	private static Startups addStartups(String name,String companyName,String category,String startupDesc,String shortDescription,String longDescription,long startupImageId,long youtubeImageId,String twitter,String linkedIn,String youTube,String youtubeLink,long number){
		
		LOGGER.info("=== call add Startups method===");
		Startups startups = null;
		try {
			startups = StartupsLocalServiceUtil.createStartups(CounterLocalServiceUtil.increment(Startups.class.getName()));
			
			startups.setName(name);
			startups.setCompanyName(companyName);
			startups.setCategory(category);
			startups.setYoutubeLink(youtubeLink);
			startups.setYoutubeImages(youtubeImageId);
			startups.setStartupDesc(startupDesc);
			startups.setShortDescription(shortDescription);
			startups.setLongDescription(longDescription);
			startups.setTwitter(twitter);
			startups.setLinkedIn(linkedIn);
			startups.setYouTube(youTube);
			startups.setNumber(number);
			startups.setStartupImage(startupImageId);
			
			StartupsLocalServiceUtil.addStartups(startups);	
		}catch(Exception e){
			LOGGER.error(e.getMessage());
		}
			
		
		return startups;
		
	}
	
private static Startups updateStartups(long startupsId,String name,String companyName,String category,String startupDesc,String shortDescription,String longDescription,long startupImageId,long youtubeImageId,String twitter,String linkedIn,String youTube,String youtubeLink,long number){
		
		LOGGER.info("=== call update Startups method===");
		Startups startups =new StartupsImpl();
		try {
			startups.setStartupsId(startupsId);
			startups.setName(name);
			startups.setCompanyName(companyName);
			startups.setCategory(category);
			startups.setYoutubeLink(youtubeLink);
			startups.setYoutubeImages(youtubeImageId);
			startups.setStartupDesc(startupDesc);
			startups.setShortDescription(shortDescription);
			startups.setLongDescription(longDescription);
			startups.setTwitter(twitter);
			startups.setLinkedIn(linkedIn);
			startups.setYouTube(youTube);
			startups.setNumber(number);
			startups.setStartupImage(startupImageId);
			
			StartupsLocalServiceUtil.updateStartups(startups);
		}catch(Exception e){
			LOGGER.error(e.getMessage());
		}
			
		
		return startups;
		
		
	}

	public static void deleteStartupsRecord(ActionRequest request,
			ActionResponse response) {
		LOGGER.info("==== Call delete Startups Method =====");
		
		long startupsId= ParamUtil.getLong(request, StartupsConstants.StartupsId);
		
		try {
			Startups mentors = StartupsLocalServiceUtil.deleteStartups(startupsId);
			if(Validator.isNotNull(mentors)){
				SessionMessages.add(request, "startups-deleted");
			}else{
				SessionErrors.add(request, "error-startups-deleted");
			}
			
			long startupsImageId = mentors.getStartupImage();
			long youtubeImageId=mentors.getYoutubeImages();
			
			if(startupsImageId != 0){
				DLAppLocalServiceUtil.deleteFileEntry(startupsImageId);
			}
			if(youtubeImageId != 0){
				DLAppLocalServiceUtil.deleteFileEntry(youtubeImageId);
			}
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		} catch (SystemException e) {
			LOGGER.error(e.getMessage());
		}
		
	}
	
	
	private static FileEntry getStartupsImage(ActionRequest request,ActionResponse response, UploadPortletRequest uploadRequest,String imagePath, String imageFolderName,long fileEntryId){
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		 long groupId=themeDisplay.getLayout().getGroupId();
		 long parentFolderId=DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		 
		 
//		 Startups startups = null;
//			try {
//				startups = StartupsLocalServiceUtil.getStartups(startupsId);
//			} catch (PortalException e) {
//				LOGGER.error(e.getMessage());
//			} catch (SystemException e) {
//				LOGGER.error(e.getMessage());
//			}
		 
		 File file=uploadRequest.getFile(imagePath);
		 LOGGER.info("file=="+file);
		 String imageName= uploadRequest.getFileName(imagePath);
		 LOGGER.info("folder Name==="+imageFolderName);
		 FileEntry fileEntry=null;
		 if(imageName != StringPool.BLANK){
			 
			 DLFolder dir=null;
			 try{
				 dir=DLFolderLocalServiceUtil.getFolder(groupId, parentFolderId, imageFolderName);
			 }catch(Exception e){
				 LOGGER.error("Error while getting folder ::> "+e.getMessage());
			 }
//			 String[] viewAccess = {ActionKeys.VIEW};
			 if(dir == null){
				 long repositoryId=themeDisplay.getScopeGroupId();
				 try {
					ServiceContext serviceContext=ServiceContextFactory.getInstance(DLFileShortcut.class.getName(), request);
					serviceContext.setAddGuestPermissions(true);
					dir=DLFolderServiceUtil.addFolder(groupId, repositoryId, false, parentFolderId, imageFolderName, null, serviceContext);
					
//					ResourcePermissionLocalServiceUtil.setResourcePermissions(themeDisplay.getCompanyId(), DLFolder.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,""+dir.getFolderId(), RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(),"Guest").getRoleId(), viewAccess);
				} catch (PortalException e) {
					LOGGER.error("Error while adding folder ::> "+e.getMessage());
				} catch (SystemException e) {	
					LOGGER.error("Error while adding folder ::> "+e.getMessage());
				}
			 }
			 
			 
			 try {
				 Date date= new Date();
				 ServiceContext serviceContext=ServiceContextFactory.getInstance(DLFileShortcut.class.getName(), request);
				 serviceContext.setAddGuestPermissions(true);
				 Folder folder = DLAppLocalServiceUtil.getFolder(dir.getFolderId());
				 if (Validator.isNotNull(fileEntryId) && fileEntryId > 0) {
					 fileEntry=DLAppLocalServiceUtil.updateFileEntry(themeDisplay.getUserId(), fileEntryId, imageName, MimeTypesUtil.getContentType(file), date.getTime()+imageName, StringPool.BLANK, StringPool.BLANK, false, file, new ServiceContext()); 
				 }else{
					 fileEntry = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(), folder.getRepositoryId(), folder.getFolderId(), imageName, MimeTypesUtil.getContentType(file), date.getTime()+imageName, StringPool.BLANK, StringPool.BLANK, file, serviceContext);
				 }
				 
				 
//				 ResourcePermissionLocalServiceUtil.setResourcePermissions(themeDisplay.getCompanyId(), DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,""+fileEntry.getFileEntryId(), RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(),"Guest").getRoleId(), viewAccess);
				 
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
