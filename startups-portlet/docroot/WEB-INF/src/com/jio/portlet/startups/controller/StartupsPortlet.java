package com.jio.portlet.startups.controller;

import com.jio.portlet.startups.helper.StartupsHelper;
import com.jio.portlet.startups.model.Startups;
import com.jio.portlet.startups.service.StartupsLocalServiceUtil;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sun.corba.se.impl.orbutil.closure.Constant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.lang.StringUtils;

/**
 * Portlet implementation class Startups
 */
public class StartupsPortlet extends MVCPortlet {
	private static final Log LOGGER = LogFactoryUtil.getLog(StartupsPortlet.class);
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		
		StartupsHelper.permissionChecker(renderRequest);
		
		super.doView(renderRequest, renderResponse);
	}
	
	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse)throws PortletException, IOException {
		
			
		
			StartupsHelper.displayStartups(renderRequest, renderResponse);
			
			
		
		super.render(renderRequest, renderResponse);
	}
	
	public void addStartups(ActionRequest request,
			ActionResponse response) throws IOException, PortletException {
		StartupsHelper.addEditStartups(request, response);
		
	}
	
	public void deleteStartups(ActionRequest request,ActionResponse response){
		StartupsHelper.deleteStartupsRecord(request, response);
	}

	
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		
		LOGGER.info("=== call serveResource Method ===");
		
		String cmd=ParamUtil.getString(resourceRequest, "cmd");
		int id=ParamUtil.getInteger(resourceRequest, "id");
		String catName=ParamUtil.getString(resourceRequest, "name");
		
		
		if(cmd.equals("update")){
			PortletPreferences prefs=resourceRequest.getPreferences();
			String category= prefs.getValue("category", StringPool.BLANK);
			
			String[] cat=StringUtil.split(category);
			if(id <= cat.length){
				cat[id]=catName;
			}
			String strCategory = "";
			for(int i=0; i <cat.length;i++ ){
				strCategory = StringUtil.add(strCategory, cat[i]);
			}
			if(strCategory.endsWith(StringPool.COMMA)){
				strCategory = strCategory.substring(0, strCategory.length()-1); 
			}
			prefs.setValue("category", strCategory);
			prefs.store();
		}
		
		if(cmd.equals("delete")){
			PortletPreferences prefs=resourceRequest.getPreferences();
			String category= prefs.getValue("category", StringPool.BLANK);
			
			String[] cat=StringUtil.split(category);
			
			List<String> list =  new ArrayList<String>();
		    Collections.addAll(list, cat); 
		    list.remove(id);
		     
		    cat = list.toArray(new String[list.size()]);
		    String strCategory = "";
			for(int i=0; i <cat.length;i++ ){
				strCategory = StringUtil.add(strCategory, cat[i]);
			}
			if(strCategory.endsWith(StringPool.COMMA)){
				strCategory = strCategory.substring(0, strCategory.length()-1); 
			}
		    prefs.setValue("category", strCategory);
		    prefs.store();
		    
		    
		   
		}
		
		try {
			List<Startups> startups= StartupsLocalServiceUtil.getStartupses(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
			
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			
			for (Startups startup : startups) {
				
				String name=startup.getName();
				String companyName=startup.getCompanyName();
				String category=startup.getCategory();
				long startupImage=startup.getStartupImage();
				long youtubeImage=startup.getYoutubeImages();
				String youtubeLink=startup.getYoutubeLink();
				String shortDescription=startup.getShortDescription();
				String startupDesc=startup.getStartupDesc();
				String longDescription=startup.getLongDescription();
				String twitter=startup.getTwitter();
				String linkedIn=startup.getLinkedIn();
				String youTube=startup.getYouTube();
				long number=startup.getNumber();
				
				FileEntry startupImages=DLAppLocalServiceUtil.getFileEntry(startupImage);
//				String projectImagesPath ="/documents/" + themeDisplay.getScopeGroupId() + "/" + startupImages.getFolderId() +  "/" +startupImages.getTitle();
				String projectImagesPath =DLUtil.getPreviewURL(startupImages, startupImages.getFileVersion(), themeDisplay, StringPool.BLANK);
//				LOGGER.info("Startups Image URl==="+projectImagesPath);
				
				String youtubeImagesPath=StringPool.BLANK;
				
				if(youtubeImage != 0){
					FileEntry youtubeImages=DLAppLocalServiceUtil.getFileEntry(youtubeImage);
//				    youtubeImagesPath ="/documents/" + themeDisplay.getScopeGroupId() + "/" + youtubeImages.getFolderId() +  "/" +youtubeImages.getTitle();
//					LOGGER.info("Youtube Image URl==="+youtubeImagesPath);
					
				    youtubeImagesPath=DLUtil.getPreviewURL(youtubeImages, youtubeImages.getFileVersion(), themeDisplay, StringPool.BLANK);
//					LOGGER.info("YoutubeURL==="+youtubeImagesPath);
				}
				
				JSONObject jsonObjIMG = JSONFactoryUtil.createJSONObject();
				jsonObjIMG.put("name", name);
				jsonObjIMG.put("CompanyName", companyName);
				jsonObjIMG.put("Category", category);
				jsonObjIMG.put("shortDescription", shortDescription);
				jsonObjIMG.put("startupDesc", startupDesc);
				jsonObjIMG.put("longDescription", longDescription);
				jsonObjIMG.put("number", number);
				jsonObjIMG.put("projectImagesPath", projectImagesPath);
				jsonObjIMG.put("youtubeImagesPath", youtubeImagesPath);
				jsonObjIMG.put("youtubeLink", youtubeLink);
				jsonObjIMG.put("twitter", twitter);
				jsonObjIMG.put("linkedIn", linkedIn);
				jsonObjIMG.put("youTube", youTube);
				
				jsonArray.put(jsonObjIMG);
				
			}
			obj.put("mentorImage", jsonArray);
			resourceResponse.setContentType("application/json");
			resourceResponse.getWriter().write(obj.toString());
			
			
		} catch (SystemException e) {
			
			e.printStackTrace();
		}catch (PortalException e) {
			
			e.printStackTrace();
		} 
	}	
	
}

