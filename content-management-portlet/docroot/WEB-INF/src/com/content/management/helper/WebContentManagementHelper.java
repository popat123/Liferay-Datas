package com.content.management.helper;

import java.util.List;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

public class WebContentManagementHelper {
	private static final Log LOGGER = LogFactoryUtil.getLog(WebContentManagementHelper.class);
	public static void getAllContent(RenderRequest request, RenderResponse response){
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			long groupId = themeDisplay.getScopeGroupId();

			List<JournalArticle> allWebContent = JournalArticleLocalServiceUtil.search(groupId, 0, WorkflowConstants.STATUS_ANY, -1, -1);
//			List<JournalArticle> allWebContent = JournalArticleLocalServiceUtil.getJournalArticles(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
//			List<JournalArticle> allWebContent = JournalArticleLocalServiceUtil.getArticles(groupId);
			PortletURL iteratorURL=response.createRenderURL();
			iteratorURL = PortletURLUtil.getCurrent(request, response);
			SearchContainer<JournalArticle> searchContainer = new SearchContainer<JournalArticle>(request, null, null, SearchContainer.DEFAULT_CUR_PARAM, 30, iteratorURL, null, "there-are-no-article");
			searchContainer.setTotal(allWebContent.size());
			List<JournalArticle> subList = ListUtil.subList(allWebContent, searchContainer.getStart(), searchContainer.getEnd());
			searchContainer.setResults(subList);
			request.setAttribute("searchContainer", searchContainer);
		} catch (SystemException e) {
			LOGGER.error("SystemException :"+e.getMessage());
		}
	
	}
}
