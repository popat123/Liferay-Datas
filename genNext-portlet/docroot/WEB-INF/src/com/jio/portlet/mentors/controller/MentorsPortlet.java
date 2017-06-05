package com.jio.portlet.mentors.controller;

import com.jio.portlet.mantors.helper.MentorsPortletHelper;
import com.jio.portlet.mentors.model.Mentors;
import com.jio.portlet.mentors.service.MentorsLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

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
 * Portlet implementation class mentors
 */
public class MentorsPortlet extends MVCPortlet {
	private static final Log LOGGER = LogFactoryUtil.getLog(MentorsPortlet.class);
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		
		MentorsPortletHelper.permissionChecker(renderRequest);
		
		super.doView(renderRequest, renderResponse);
	}
	
	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		
		MentorsPortletHelper.displayMentors(renderRequest, renderResponse);
		MentorsPortletHelper.permissionChecker(renderRequest);
		
		super.render(renderRequest, renderResponse);
	}



	public void addMentors(ActionRequest request,
			ActionResponse response) throws IOException, PortletException {
		MentorsPortletHelper.addEditMentors(request, response);
		
	}
	
	public void deleteMentor(ActionRequest request,ActionResponse response){
		MentorsPortletHelper.deleteMentorRecord(request, response);
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		LOGGER.info("=== call serveResource Method ===");
		
		try {
			List<Mentors> mentors=MentorsLocalServiceUtil.getMentorses(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
			
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			
			for (Mentors mentor : mentors) {
				
				String name=mentor.getName();
				String companyName=mentor.getCompanyName();
				String category=mentor.getCategory();
				long mentorImage=mentor.getMentorImage();
				String shortDescription=mentor.getShortDescription();
				String longDescription=mentor.getLongDescription();
				long number=mentor.getNumber();
				
				FileEntry mentorImages=DLAppLocalServiceUtil.getFileEntry(mentorImage);
				String projectImagesPath ="/documents/" + themeDisplay.getScopeGroupId() + "/" + mentorImages.getFolderId() +  "/" +mentorImages.getTitle();
				LOGGER.info("Image URl==="+projectImagesPath);
				
				JSONObject jsonObjIMG = JSONFactoryUtil.createJSONObject();
				jsonObjIMG.put("name", name);
				jsonObjIMG.put("CompanyName", companyName);
				jsonObjIMG.put("Category", category);
				jsonObjIMG.put("shortDescription", shortDescription);
				jsonObjIMG.put("longDescription", longDescription);
				jsonObjIMG.put("number", number);
				jsonObjIMG.put("projectImagesPath", projectImagesPath);
				
				jsonArray.put(jsonObjIMG);
				
			}
			obj.put("mentorImage", jsonArray);
			resourceResponse.setContentType("application/json");
			resourceResponse.getWriter().write(obj.toString());
		} catch (SystemException e) {
			LOGGER.error(e.getMessage());
		}catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}
		
	}
}
