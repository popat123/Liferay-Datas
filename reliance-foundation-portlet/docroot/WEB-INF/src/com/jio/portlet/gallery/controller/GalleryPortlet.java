package com.jio.portlet.gallery.controller;

import com.jio.portlet.gallery.helper.GalleryPortletHelper;	
import com.jio.portlet.gallery.model.Gallery;
import com.jio.portlet.gallery.service.GalleryLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.portlet.PortletProps;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

/**
 * Portlet implementation class GalleryPortlet
 */
public class GalleryPortlet extends MVCPortlet {
	private static final Log LOGGER = LogFactoryUtil.getLog(GalleryPortlet.class);
	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		//GalleryPortletHelper.displayGallery(request);
		GalleryPortletHelper.gallerySearchContainer(request, response);
		String cmd=ParamUtil.getString(request, Constants.CMD);

		if(cmd.equals(Constants.UPDATE)){
			GalleryPortletHelper.viewRender(request, response);
		}

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		boolean isSignedIn = themeDisplay.isSignedIn();
		request.setAttribute("isSignedIn", isSignedIn);

		String currentPage = themeDisplay.getLayout().getName(themeDisplay.getLocale());
		String displayPage=PortletProps.get("displayPage");
		//LOGGER.info("Page Name==="+currentPage);
		if(currentPage.equals(displayPage)){
			viewTemplate="/html/gallery/view.jsp";
		}else{
			viewTemplate="/html/gallery/view_all.jsp";
		}
		
		String[] types=PortletProps.getArray("types");
		request.setAttribute("types", types);
		
		
		try {

			List<Gallery> galleriesvideos = GalleryLocalServiceUtil.getVideosPriority(true);
			List<Gallery> galleriesimage = GalleryLocalServiceUtil.getImagePriority(true);

			boolean flag=false;
			if(galleriesvideos.size() <= 3){
				flag= true;
				request.setAttribute("videoFlag", flag);
			}

			if(galleriesimage.size() <= 3){
				flag= true;
				request.setAttribute("imageFlag", flag);					
			}

		} catch (SystemException e) {
			e.printStackTrace();
		}
		super.render(request, response);

	}

	public void addGallery(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		GalleryPortletHelper.addEditGallery(actionRequest, actionResponse);
	}


	public void deleteGallery(ActionRequest actionRequest,ActionResponse actionResponse){
		GalleryPortletHelper.deleteGalleryRecord(actionRequest, actionResponse);
	}

	
//	public void addPreference(ActionRequest request, ActionResponse response) throws IOException, PortalException, SystemException, PortletException
//	  {
//	   
//		  String homeDisplayVideo = request.getParameter("homeDisplayStyle");
//		  String galleryDisplayVideo = request.getParameter("galleryDisplayStyle");
//		  LOGGER.info("Home Display Video=="+homeDisplayVideo);
//		  LOGGER.info("Gallery Display Video=="+galleryDisplayVideo);
//		 
//	      PortletPreferences prefs=request.getPreferences();
//	      prefs.setValue("homeDisplayVideo", homeDisplayVideo);
//	      prefs.setValue("galleryDisplayVideo", galleryDisplayVideo);
//	      prefs.store();
//	      response.setPortletMode(PortletMode.VIEW);
//	  }
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		//LOGGER.info("Calling Serve Resource Method");


		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);


		try {
			List<Gallery> galleries = GalleryLocalServiceUtil.getGalleries(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
			JSONArray jsonArrayImage=JSONFactoryUtil.createJSONArray();
			JSONArray jsonArrayVideo=JSONFactoryUtil.createJSONArray();
			JSONObject jsonObjectIMG=null;
			JSONObject jsonObjectVideo=null;
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			for (Gallery gallery : galleries) {

				String type=gallery.getType();
				//LOGGER.info("type=="+type);
				String thumbnailName=gallery.getThumbnailName();
				String name=gallery.getName();
				String mainCategory=gallery.getMainCategory();
				String projectImagesPath=gallery.getProjectImagesPath();
				boolean isVideo=gallery.getIsVideo();
				boolean isIMG=gallery.getIsIMG();
				boolean youTubeLink=gallery.getYouTubeLink();
				boolean videosImagPriority=gallery.getVideosImagPriority();
				boolean gallryImagPriority =gallery.getGallryImagPriority();
				String demoLink=gallery.getDemoLink();
				String liveLink=gallery.getLiveLink();
				long number=gallery.getNumber();


				if(gallery.getIsIMG() == true){

					FileEntry bigImageFile = DLAppLocalServiceUtil.getFileEntry(gallery.getGalleryImagesId());
					String bigImageUrl ="/documents/" + themeDisplay.getScopeGroupId() + "/" + bigImageFile.getFolderId() +  "/" +bigImageFile.getTitle() ;
					//LOGGER.info("Big IMG URL=="+bigImageUrl);

					FileEntry thumbnailImageFile = DLAppLocalServiceUtil.getFileEntry(gallery.getThumbnailImagesId());
					String thumbnilImageUrl ="/documents/" + themeDisplay.getScopeGroupId() + "/" + thumbnailImageFile.getFolderId() +  "/" +thumbnailImageFile.getTitle() ;
					//LOGGER.info("Thumbnail IMG URL=="+thumbnilImageUrl);

					jsonObjectIMG = JSONFactoryUtil.createJSONObject();
					jsonObjectIMG.put("type", type);
					jsonObjectIMG.put("bigImageUrl", bigImageUrl);
					jsonObjectIMG.put("thumbnilImageUrl", thumbnilImageUrl);
					jsonObjectIMG.put("thumbnailName", thumbnailName);
					jsonObjectIMG.put("name", name);
					jsonObjectIMG.put("mainCategory", mainCategory);
					jsonObjectIMG.put("projectImagePath", projectImagesPath);
					jsonObjectIMG.put("isVideo", isVideo);
					jsonObjectIMG.put("isIMG", isIMG);
					jsonObjectIMG.put("youTubeLink", youTubeLink);
					jsonObjectIMG.put("gallryImagPriority", gallryImagPriority);
					jsonObjectIMG.put("demoLink", demoLink);
					jsonObjectIMG.put("liveLink", liveLink);
					jsonObjectIMG.put("number", number);

					jsonArrayImage.put(jsonObjectIMG);
				}

				if(gallery.getIsVideo()==true){

					jsonObjectVideo = JSONFactoryUtil.createJSONObject();

					//LOGGER.info("Gallery image id==="+gallery.getVideoImagesId());
					FileEntry videoImageFile = DLAppLocalServiceUtil.getFileEntry(gallery.getVideoImagesId());
					String videoImageUrl ="/documents/" + themeDisplay.getScopeGroupId() + "/" + videoImageFile.getFolderId() +  "/" +videoImageFile.getTitle() ;
					//LOGGER.info("videoImageUrl==="+videoImageUrl);

					jsonObjectVideo.put("type", type);
					jsonObjectVideo.put("videoImageUrl", videoImageUrl);
					jsonObjectVideo.put("thumbnailName", thumbnailName);
					jsonObjectVideo.put("name", name);
					jsonObjectVideo.put("mainCategory", mainCategory);
					jsonObjectVideo.put("projectImagesPath", projectImagesPath);
					jsonObjectVideo.put("isVideo", isVideo);
					jsonObjectVideo.put("isIMG", isIMG);
					jsonObjectVideo.put("youTubeLink", youTubeLink);
					jsonObjectVideo.put("videosImagPriority", videosImagPriority);
					jsonObjectVideo.put("demoLink", demoLink);
					jsonObjectVideo.put("liveLink", liveLink);
					jsonObjectVideo.put("number", number);

					jsonArrayVideo.put(jsonObjectVideo);
				}
			}
			obj.put("image", jsonArrayImage);
			obj.put("video", jsonArrayVideo);	

			resourceResponse.setContentType("application/json");
			resourceResponse.getWriter().write(obj.toString());
		} catch (SystemException e) {
			e.printStackTrace();
		}catch (PortalException e) {
			e.printStackTrace();
		}

		//		super.serveResource(resourceRequest, resourceResponse);
	}

}
