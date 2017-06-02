package com.content.management.controller;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.content.management.helper.WebContentManagementHelper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import net.sourceforge.jtds.util.Logger;

/**
 * Portlet implementation class WebContentManagementPortlet
 */
public class WebContentManagementPortlet extends MVCPortlet {
 
	@Override
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		WebContentManagementHelper.getAllContent(request, response);
		super.render(request, response);
	}
	
	public void deleteContent(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		long articleId = ParamUtil.getLong(actionRequest, "articleId");
		try {
			JournalArticle article = JournalArticleLocalServiceUtil.getJournalArticle(articleId);
			JournalArticleLocalServiceUtil.deleteArticle(article);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
	}
}
