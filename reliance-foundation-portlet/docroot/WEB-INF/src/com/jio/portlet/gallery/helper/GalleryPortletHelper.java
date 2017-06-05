package com.jio.portlet.gallery.helper;

import com.jio.portlet.gallery.controller.GalleryPortlet;
import com.jio.portlet.gallery.model.Gallery;
import com.jio.portlet.gallery.model.impl.GalleryImpl;
import com.jio.portlet.gallery.service.GalleryLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.security.permission.ActionKeys;
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

public class GalleryPortletHelper {
	private static final Log LOGGER = LogFactoryUtil.getLog(GalleryPortlet.class);

	public static void viewRender(RenderRequest request, RenderResponse response) {
		LOGGER.info("calling edit render");
		long galleryId=ParamUtil.getLong(request, "galleryId");
		
		try {
			Gallery gallery=GalleryLocalServiceUtil.getGallery(galleryId);
			request.setAttribute("gallery", gallery);
			
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		} catch (SystemException e) {
			LOGGER.error(e.getMessage());
		}
		
	}
	
	
	public static void displayRender(RenderRequest request, RenderResponse response) {
		
	}
	
//	public static void displayGallery(RenderRequest request){
//		
//		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
//		int start = 0;
//		int end = 1;
//		try {
//			DDMStructure ddmStructure = DDMStructureLocalServiceUtil.getStructure(26894);
//			//LOGGER.info("DDm Structure==="+ddmStructure);
//			List<JournalArticle> journalArticles = JournalArticleServiceUtil.getArticlesByStructureId(themeDisplay.getScopeGroupId(), ddmStructure.getStructureKey(),
//					start, end, new ArticleModifiedDateComparator());
//			//LOGGER.info("journalArticles=="+journalArticles);
//			String journalArticle = JournalContentUtil.getContent(themeDisplay.getScopeGroupId(), journalArticles.get(0).getArticleId(),
//					null,  LanguageUtil.getLanguageId(request), themeDisplay);
//			//LOGGER.info("journalArticle=="+journalArticle);
//			request.setAttribute("journalArticle", journalArticle);
//		} catch (PortalException e) {
//			LOGGER.error(e.getMessage());
//		} catch (SystemException e) {
//			LOGGER.error(e.getMessage());
//		}
//		
//	}
	
	public static void gallerySearchContainer(RenderRequest request, RenderResponse response) {
        PortletURL iteratorURL = response.createRenderURL();
        iteratorURL = PortletURLUtil.getCurrent(request, response);
        SearchContainer<Gallery> searchContainer = new SearchContainer<Gallery>(request, null, null, SearchContainer.DEFAULT_CUR_PARAM, 5, iteratorURL, null, "there-are-no-gallery");
        searchContainer.setDeltaConfigurable(true);

		try {
			List<Gallery> galleries = GalleryLocalServiceUtil.getGalleries(searchContainer.getStart(), searchContainer.getEnd());
			searchContainer.setTotal(GalleryLocalServiceUtil.getGalleriesCount());
	        searchContainer.setResults(galleries);
		} catch (SystemException e) {
			LOGGER.error(e.getMessage());
		}
        
        request.setAttribute("gallerySearchContainer", searchContainer);
 }

	public static void addEditGallery(ActionRequest request,
			ActionResponse response){
		LOGGER.info("===call gallery Method===");
		//ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadPortletRequest=PortalUtil.getUploadPortletRequest(request);
		
		
		String type=ParamUtil.getString(uploadPortletRequest, GalleryPortletConstants.TYPE);
		String thumbnailName=ParamUtil.getString(uploadPortletRequest, GalleryPortletConstants.THUMBNAIL_NAME);
		String name=ParamUtil.getString(uploadPortletRequest, GalleryPortletConstants.NAME);
		String mainCategory=ParamUtil.getString(uploadPortletRequest, GalleryPortletConstants.MAIN_CATEGORY);
		String projectImagesPath=ParamUtil.getString(uploadPortletRequest, GalleryPortletConstants.PROJECT_IMAGES_PATH);
		boolean isVideo=ParamUtil.getBoolean(uploadPortletRequest, GalleryPortletConstants.IS_VIDEO);
		boolean isIMG=ParamUtil.getBoolean(uploadPortletRequest, GalleryPortletConstants.IS_IMG);
		boolean youTubeLink=ParamUtil.getBoolean(uploadPortletRequest, GalleryPortletConstants.YOUTUBE_LINK);
		String demoLink=ParamUtil.getString(uploadPortletRequest, GalleryPortletConstants.DEMO_LINK);
		boolean videosImagPriority=ParamUtil.getBoolean(uploadPortletRequest, GalleryPortletConstants.VIDEO_IMG_PRIORITY);
		boolean gallryImagPriority=ParamUtil.getBoolean(uploadPortletRequest, GalleryPortletConstants.GALLARY_IMG_PRIORITY);
		String liveLink=ParamUtil.getString(uploadPortletRequest, GalleryPortletConstants.LIVE_LINK);
		long number=ParamUtil.getLong(uploadPortletRequest, GalleryPortletConstants.NUMBER);
	    LOGGER.info("videosImagPriority==="+videosImagPriority);
	    LOGGER.info("gallryImagPriority"+gallryImagPriority);
		long galleryId=ParamUtil.getLong(request, "galleryId");
		
		Gallery gallery =new GalleryImpl();
		try {
			if(galleryId != 0){
				gallery = GalleryLocalServiceUtil.getGallery(galleryId);
			}
			
		} catch (PortalException e1) {
			LOGGER.error(e1.getMessage());
		} catch (SystemException e1) {
			LOGGER.error(e1.getMessage());
		}
		long videoImageId=0;
		long bigImageId=0;
		long thumbnailImageId=0;
		FileEntry fileEntry=null;
		if(isVideo == true){
			fileEntry = getVideoImage(request, response, uploadPortletRequest, GalleryPortletConstants.VIDEO_IMAGES_PATH, PortletProps.get(GalleryPortletConstants.VIDEO_IMAGE_FOLDER),galleryId);
			if(Validator.isNotNull(fileEntry)){
				long VideoFileEntryId = fileEntry.getFileEntryId(); 
				if(Validator.isNotNull(VideoFileEntryId)){
					gallery.setVideoImagesId(VideoFileEntryId);
				}
				videoImageId=gallery.getVideoImagesId();
				
			}else{
				videoImageId=gallery.getVideoImagesId();
				
			}
		}
		
		if(isIMG == true){
			fileEntry= getVideoImage(request, response, uploadPortletRequest,GalleryPortletConstants.GALLERY_IMAGES_PATH, PortletProps.get(GalleryPortletConstants.BIG_IMAGE_FOLDER),galleryId );
			if(Validator.isNotNull(fileEntry)){
				long bigImageFileEntryId = fileEntry.getFileEntryId();
				if(Validator.isNotNull(bigImageFileEntryId)){
					 gallery.setGalleryImagesId(bigImageFileEntryId);
				 }
				bigImageId=gallery.getGalleryImagesId();
				
			}else{
				bigImageId=gallery.getGalleryImagesId();
				
			}
			
			
			fileEntry = getVideoImage(request, response, uploadPortletRequest,GalleryPortletConstants.THUMBNAIL_IMAGES_PATH, PortletProps.get(GalleryPortletConstants.THUMBNAIL_IMAGE_FOLDER),galleryId);
			if(Validator.isNotNull(fileEntry)){
				long thumbnailImageFileEntryId =fileEntry.getFileEntryId();
				if(Validator.isNotNull(thumbnailImageFileEntryId)){
					 gallery.setThumbnailImagesId(thumbnailImageFileEntryId);
				 }
				thumbnailImageId=gallery.getThumbnailImagesId();
				
			}else{
				thumbnailImageId=gallery.getThumbnailImagesId();
				
			}
			
		}
		
		
		if(Validator.isNotNull(galleryId)){
			LOGGER.info("====== calling update gallery =======");
			gallery.setGalleryId(galleryId);
			gallery.setType(type);
			gallery.setThumbnailName(thumbnailName);
			gallery.setName(name);
			gallery.setMainCategory(mainCategory);
			gallery.setProjectImagesPath(projectImagesPath);
			gallery.setIsVideo(isVideo);
			gallery.setIsIMG(isIMG);
			gallery.setYouTubeLink(youTubeLink);
			gallery.setGallryImagPriority(gallryImagPriority);
			gallery.setVideosImagPriority(videosImagPriority);
			gallery.setDemoLink(demoLink);
			gallery.setLiveLink(liveLink);
			gallery.setNumber(number);
			gallery.setGalleryImagesId(bigImageId);
			gallery.setThumbnailImagesId(thumbnailImageId);
			gallery.setVideoImagesId(videoImageId);
						
			try {
				GalleryLocalServiceUtil.updateGallery(gallery);
			} catch (SystemException e) {
				LOGGER.error(e.getMessage());
			}
		}else{
			GalleryLocalServiceUtil.addGallery(type, thumbnailName, name, mainCategory, projectImagesPath, isVideo, isIMG, youTubeLink,videosImagPriority, gallryImagPriority, demoLink, liveLink, number, videoImageId, bigImageId, thumbnailImageId);
		}
		
	}
	
	
	public static void deleteGalleryRecord(ActionRequest request,ActionResponse response) {
		LOGGER.info("=====delete Gallery===");
		
		long galleryId=ParamUtil.getLong(request, "galleryId");
		LOGGER.debug("galleryd==="+galleryId);
		
		try {
			Gallery gallery=GalleryLocalServiceUtil.deleteGallery(galleryId);
			long videoImageId=gallery.getVideoImagesId();
			long galleryImageId=gallery.getGalleryImagesId();
			long thumnailImageId=gallery.getThumbnailImagesId();
			
			if(videoImageId !=0){
				DLAppLocalServiceUtil.deleteFileEntry(videoImageId);
			}
			if(galleryImageId !=0){
				DLAppLocalServiceUtil.deleteFileEntry(galleryImageId);
			}
			if(thumnailImageId !=0){
				DLAppLocalServiceUtil.deleteFileEntry(thumnailImageId);
			}
			
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		} catch (SystemException e) {
			LOGGER.error(e.getMessage());
		}
	}
	
	private static FileEntry getVideoImage(ActionRequest request,ActionResponse response, UploadPortletRequest uploadRequest,String imagePath, String imageFolderName,long galleryId){
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		 long groupId=themeDisplay.getLayout().getGroupId();
		 long parentFolderId=DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		 
		 File file=uploadRequest.getFile(imagePath);
		 //LOGGER.info("file"+file);
		 String imageName= uploadRequest.getFileName(imagePath);
		 //String imageFolderName = PortletProps.get(folderName);
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
					ServiceContext serviceContext=ServiceContextFactory.getInstance(DLFileShortcut.class.getName(), request);
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
				 fileEntry = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(), folder.getRepositoryId(), folder.getFolderId(), imageName, MimeTypesUtil.getContentType(file), date.getTime()+imageName, StringPool.BLANK, StringPool.BLANK, file, new ServiceContext());
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
