package com.lep.contribute.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.lep.contribute.model.ContributionModel;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class ContributionPortlet extends MVCPortlet{
	
	private static final Log LOGGER = LogFactoryUtil.getLog(ContributionPortlet.class);
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			long groupId = themeDisplay.getScopeGroupId();
			String currentURL = themeDisplay.getURLCurrent();
			
			List<DDMStructure> ddmStructures = DDMStructureServiceUtil.getStructures(PortalUtil.getSiteAndCompanyGroupIds(themeDisplay), PortalUtil.getClassNameId(JournalArticle.class));
			List<ContributionModel> listModels = new ArrayList<ContributionModel>();
			for (DDMStructure ddmStructure : ddmStructures) {
				ContributionModel model = new ContributionModel();
				
				model.setStructureKey(ddmStructure.getStructureKey());
				model.setStructureName(HtmlUtil.escape(ddmStructure.getName(themeDisplay.getLocale())));
				listModels.add(model);
			}
			
			renderRequest.setAttribute("models", listModels);
			renderRequest.setAttribute("groupId", groupId);
			renderRequest.setAttribute("folderId", 0);
			renderRequest.setAttribute("currentURL", currentURL);
			
		} catch (SystemException e) {
			LOGGER.error("System Exception : "+e.getMessage());
		} catch (PortalException e) {
			LOGGER.error("Portal Exception : "+e.getMessage());
		}
		super.render(renderRequest, renderResponse);
	}

}
