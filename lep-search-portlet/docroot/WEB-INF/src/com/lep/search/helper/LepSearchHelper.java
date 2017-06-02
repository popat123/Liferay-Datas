package com.lep.search.helper;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.QueryConfig;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

public class LepSearchHelper {

	public static void getJournalSearchResults(RenderRequest request,
			RenderResponse response){
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest originalRequest = PortalUtil.getHttpServletRequest(request);
		String keywords = ParamUtil.getString(request, "keywords");
		
		PortletURL portletURL = response.createRenderURL();
		Indexer indexer = IndexerRegistryUtil.getIndexer(JournalArticle.class);
		SearchContainer searchContainer = new SearchContainer(request, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, 
				portletURL, null, LanguageUtil.format(themeDisplay.getLocale(), "no-pages-were-found-that-matched-the-keywords-x", "<strong>" + HtmlUtil.escape(keywords) + "</strong>"));

		SearchContext searchContext = SearchContextFactory.getInstance(originalRequest);

		//searchContext.setAttribute("articleType", type);
		searchContext.setGroupIds(null);
		searchContext.setKeywords(keywords);

		QueryConfig queryConfig = new QueryConfig();

		queryConfig.setHighlightEnabled(true);

		searchContext.setQueryConfig(queryConfig);

		Hits hits = null;
		String[] queryTerms = null;
		try {
			hits = indexer.search(searchContext);
			queryTerms = hits.getQueryTerms();
			int total = hits.getLength();
			searchContainer.setTotal(total);
		} catch (SearchException e) {
			e.printStackTrace();
		}

		List<Document> results = ListUtil.toList(hits.getDocs());
		
		List<JournalArticle> journals = new ArrayList<>();
		
		for (int i = 0; i < results.size(); i++) {
			Document doc = results.get(i);
			long articleGroupId = GetterUtil.getLong(doc.get(Field.GROUP_ID));
			String articleId = doc.get("articleId");
			try {
				JournalArticle journalArticle = JournalArticleLocalServiceUtil.getLatestArticle(articleGroupId, articleId);
				journals.add(journalArticle);
				
			} catch (PortalException | SystemException e) {
				
				e.printStackTrace();
			}
		}
		
		searchContext.setStart(searchContainer.getStart());
		searchContext.setEnd(searchContainer.getEnd());
		searchContainer.setResults(journals);
		
		request.setAttribute("searchContainer", searchContainer);
		request.setAttribute("queryTerms", queryTerms);
	}

}
