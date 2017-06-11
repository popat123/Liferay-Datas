package com.jio.portlet.jurys.controller;


import com.jio.portlet.jurys.helper.JurysPortletHelper;
import com.jio.portlet.jurys.model.Jurys;
import com.jio.portlet.jurys.service.JurysLocalServiceUtil;
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
 * Portlet implementation class NewPortlet
 */
public class JuryPortlet extends MVCPortlet {
	
private static final Log LOGGER = LogFactoryUtil.getLog(JuryPortlet.class);
	
	
	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		
		JurysPortletHelper.displayJurys(renderRequest, renderResponse);	
		JurysPortletHelper.permissionChecker(renderRequest); 
		super.render(renderRequest, renderResponse);
	}


	public void addJurys(ActionRequest request,
			ActionResponse response) throws IOException, PortletException {
		LOGGER.info("====Calling Add Jurys=====");
		JurysPortletHelper.addEditMentors(request, response);
		
	}
	
	public void deleteJury(ActionRequest request,ActionResponse response){
		JurysPortletHelper.deleteJuryRecord(request, response);
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		LOGGER.info("=== call serveResource Method ===");
		
		try {
			List<Jurys> jurys = JurysLocalServiceUtil.getJuryses(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
			
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			
			for (Jurys jury: jurys) {
				
				String name=jury.getName();
				String companyName=jury.getCompanyName();
				String category=jury.getCategory();
				long juryImage=jury.getJuryImage();
				String shortDescription=jury.getShortDescription();
				String longDescription=jury.getLongDescription();
				long number=jury.getNumber();
				
				FileEntry juryImages=DLAppLocalServiceUtil.getFileEntry(juryImage);
				String projectImagesPath ="/documents/" + themeDisplay.getScopeGroupId() + "/" + juryImages.getFolderId() +  "/" +juryImages.getTitle();
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
			obj.put("juryImage", jsonArray);
			resourceResponse.setContentType("application/json");
			resourceResponse.getWriter().write(obj.toString());
		} catch (SystemException e) {
			LOGGER.error(e.getMessage());
		}catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}
		
	}
 

}
