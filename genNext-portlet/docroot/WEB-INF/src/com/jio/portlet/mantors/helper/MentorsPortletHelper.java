	package com.jio.portlet.mantors.helper;
	
	import com.jio.portlet.mentors.model.Mentors;
import com.jio.portlet.mentors.model.impl.MentorsImpl;
import com.jio.portlet.mentors.service.MentorsLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
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
import java.io.IOException;
import java.util.Date;
import java.util.List;
	



	import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletURL;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;
	
	public class MentorsPortletHelper {
		private static final Log LOGGER = LogFactoryUtil.getLog(MentorsPortletHelper.class);
		
		public static void permissionChecker(RenderRequest renderRequest) {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
					.getAttribute(WebKeys.THEME_DISPLAY);
	
			PermissionChecker permissionChecker = themeDisplay
					.getPermissionChecker();
			
			renderRequest.setAttribute("permissionCheck", (permissionChecker
					.isOmniadmin() || permissionChecker.isGroupAdmin(themeDisplay
					.getScopeGroupId())));
		}
		
		
		public static void displayMentors(RenderRequest request,RenderResponse response) {
			
			LOGGER.info("===== call Display Mentors Method =======");
			String[] categories = PortletProps.getArray("category");
			request.setAttribute("categories", categories);
			
			long mentorsId=ParamUtil.getLong(request, "mentorsId");
			
			Mentors mentor;
			try {
				if(mentorsId != 0){
					mentor = MentorsLocalServiceUtil.getMentors(mentorsId);
					request.setAttribute("mentors", mentor);
				}
				
			} catch (PortalException e) {
				LOGGER.error(e.getMessage());
			} catch (SystemException e) {
				LOGGER.error(e.getMessage());
			}
			
			
			PortletURL iteratorURL = response.createRenderURL();
	        iteratorURL = PortletURLUtil.getCurrent(request, response);
	        SearchContainer<Mentors> searchContainer = new SearchContainer<Mentors>(request, null, null, SearchContainer.DEFAULT_CUR_PARAM, 5, iteratorURL, null, "there-are-no-mentor");
	        searchContainer.setDeltaConfigurable(true);
	
			try {
				List<Mentors> mentors = MentorsLocalServiceUtil.getMentorses(searchContainer.getStart(), searchContainer.getEnd());
				searchContainer.setTotal(MentorsLocalServiceUtil.getMentorsesCount());
		        searchContainer.setResults(mentors);
			} catch (SystemException e) {
				LOGGER.error(e.getMessage());
			}
	        
	        request.setAttribute("mentorsSearchContainer", searchContainer);
	
		}
		public static void addEditMentors(ActionRequest request,
				ActionResponse response){
			LOGGER.info("===== call add/Edit Mentors =====");
			
			UploadPortletRequest uploadPortletRequest=PortalUtil.getUploadPortletRequest(request);
			String name=ParamUtil.getString(uploadPortletRequest, MentorsPortletConstants.Name);
			String companyName=ParamUtil.getString(uploadPortletRequest, MentorsPortletConstants.Company_Name);
			String category=ParamUtil.getString(uploadPortletRequest, MentorsPortletConstants.Category);
			String shortDescription=ParamUtil.getString(uploadPortletRequest, MentorsPortletConstants.Short_Description);
			String longDescription=ParamUtil.getString(uploadPortletRequest, MentorsPortletConstants.Long_Description);
			long number=ParamUtil.getLong(uploadPortletRequest, MentorsPortletConstants.Number);
			long mentorsId=ParamUtil.getLong(uploadPortletRequest, MentorsPortletConstants.MentorsId);
				
				Mentors mentors = null;
				long fileEntryId = 0;
				try {
					
					if(mentorsId != 0){
						mentors = MentorsLocalServiceUtil.getMentors(mentorsId);
						fileEntryId = mentors.getMentorImage();
					}
					/* mentors = MentorsLocalServiceUtil.getMentors(mentorsId);*/
				} catch (PortalException e) {
					LOGGER.error(e.getMessage());
				} catch (SystemException e) {
					LOGGER.error(e.getMessage());
				}
				
			FileEntry fileEntry = getMentorsImage(request, response, uploadPortletRequest, MentorsPortletConstants.Mentor_Images, PortletProps.get(MentorsPortletConstants.Mentor_Image_Folder), fileEntryId);
			
			if(Validator.isNotNull(fileEntry)){
				fileEntryId =fileEntry.getFileEntryId();
			}else{
				fileEntryId = mentors.getMentorImage();
			}
			
			if(Validator.isNotNull(mentorsId)){
				updateMentors(mentorsId,name, companyName, category, shortDescription, longDescription, fileEntryId,number);
			}else{
				addMentors(name,companyName,category,shortDescription,longDescription,fileEntryId,number);
			}
			
		}
		
	/*	private static void setPreference(ActionRequest request,ActionResponse response,String category){
			
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
		     		
		}*/
		
		private static Mentors addMentors(String name,String companyName,String category,String shortDescription,String longDescription,long mentorImageId,long number){
			
			LOGGER.info("=== Call add Mentors method===");
			Mentors mentors = null;
			try {
				mentors = MentorsLocalServiceUtil.createMentors(CounterLocalServiceUtil.increment(Mentors.class.getName()));
				
				mentors.setName(name);
				mentors.setCompanyName(companyName);
				mentors.setCategory(category);
				mentors.setShortDescription(shortDescription);
				mentors.setLongDescription(longDescription);
				mentors.setNumber(number);
				mentors.setMentorImage(mentorImageId);
				
				MentorsLocalServiceUtil.addMentors(mentors);
			}catch(Exception e){
				LOGGER.error(e.getMessage());
			}
				
			
			return mentors;
			
		}
		
		private static Mentors updateMentors(long mentorsId,String name,String companyName,String category,String shortDescription,String longDescription,long mentorImageId,long number){
			
			LOGGER.info("=== call update Mentors method===");
			Mentors mentors =new MentorsImpl();
			try {
				mentors.setMentorsId(mentorsId);
				mentors.setName(name);
				mentors.setCompanyName(companyName);
				mentors.setCategory(category);
				mentors.setShortDescription(shortDescription);
				mentors.setLongDescription(longDescription);
				mentors.setNumber(number);
				mentors.setMentorImage(mentorImageId);
				
				MentorsLocalServiceUtil.updateMentors(mentors);
			}catch(Exception e){
				LOGGER.error(e.getMessage());
			}
					
			return mentors;
			
			
		}
			
		public static void deleteMentorRecord(ActionRequest request,ActionResponse response){
			LOGGER.info("==== Call delete Mentor Method =====");
			
			long mentorsId= ParamUtil.getLong(request, "mentorsId");
			
			try {
				Mentors mentors = MentorsLocalServiceUtil.deleteMentors(mentorsId);
				long mentorImageId = mentors.getMentorImage();
				
				if(mentorImageId != 0){
					DLAppLocalServiceUtil.deleteFileEntry(mentorImageId);
				}
			} catch (PortalException e) {
				LOGGER.error(e.getMessage());
			} catch (SystemException e) {
				LOGGER.error(e.getMessage());
			}
			
		}
		
		private static FileEntry getMentorsImage(ActionRequest request,ActionResponse response, UploadPortletRequest uploadRequest,String imagePath, String imageFolderName, long fileEntryId){
			
			 ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			 long groupId=themeDisplay.getLayout().getGroupId();
			 long parentFolderId=DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
			
			 File file=uploadRequest.getFile(imagePath);
			 ServiceContext serviceContext = null;
			 LOGGER.info("=========Mentors file=====:"+file);
			 String imageName= uploadRequest.getFileName(imagePath);
			 LOGGER.info("=====Mentors Image Folder Name === :"+imageFolderName);
			 FileEntry fileEntry=null;
			 if(imageName != StringPool.BLANK){
				 
				 DLFolder dir=null;
				 try{
					 dir=DLFolderLocalServiceUtil.getFolder(groupId, parentFolderId, imageFolderName);
				 }catch(Exception e){
					 LOGGER.error("Error while getting folder ::> "+e.getMessage());
				 }
				 String[] viewAccess = {ActionKeys.VIEW};
				 if(dir == null){
					 long repositoryId=themeDisplay.getScopeGroupId();
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
					 serviceContext = ServiceContextFactory.getInstance(DLFileShortcut.class.getName(), request);
					 Folder folder = DLAppLocalServiceUtil.getFolder(dir.getFolderId());
					 
					 LOGGER.info("=======Checking entry file ID Of Mentors in Document Media====="+fileEntryId);
					 if (Validator.isNotNull(fileEntryId) && fileEntryId > 0) {
							// update
						 LOGGER.info("Call Update FileEntry");
						 
						  fileEntry = DLAppLocalServiceUtil.updateFileEntry(themeDisplay.getUserId(), fileEntryId, imageName, MimeTypesUtil.getContentType(file), imageName, StringPool.BLANK, StringPool.BLANK, false, file, serviceContext);
								  
						  LOGGER.info("=====Mentors fileEntry ID=====++++"+fileEntry.getFileEntryId());
						  LOGGER.info("=====FileEntry======"+fileEntry);
						  
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
