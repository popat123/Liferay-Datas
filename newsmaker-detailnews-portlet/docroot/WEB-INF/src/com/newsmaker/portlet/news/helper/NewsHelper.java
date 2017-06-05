package com.newsmaker.portlet.news.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleServiceUtil;
import com.liferay.portlet.journal.util.comparator.ArticleModifiedDateComparator;
import com.liferay.portlet.journalcontent.util.JournalContentUtil;

public class NewsHelper {
	private static final Log LOGGER = LogFactoryUtil.getLog(NewsHelper.class);
	
	public static void getNews(RenderRequest request,RenderResponse response,ThemeDisplay themeDisplay) {
		try {
			final String NEWSMAKER_QUIZ_STR = PropsUtil.get("structure.newsmaker");
			List<DDMStructure> ddmStructures = DDMStructureServiceUtil.getStructures(PortalUtil.getSiteAndCompanyGroupIds(themeDisplay), PortalUtil.getClassNameId(JournalArticle.class));
			PortletPreferences pref  = request.getPreferences();
			long structureId = GetterUtil.getLong(pref.getValue("structureId", null));
			request.setAttribute("ddmStructures", ddmStructures);
			int nextContentNo = ParamUtil.getInteger(request, "nextContentNo");
			int previousContentNo = ParamUtil.getInteger(request, "previousContentNo");
			if(Validator.isNotNull(structureId)){
				int start = 0;
				int end = 1;
				boolean lastRecord = false;
				
				if(nextContentNo != 0){
					start = nextContentNo;
					end = nextContentNo + 1;
				}else if(previousContentNo != 0){
					start = previousContentNo -1;
					end = previousContentNo;
				}
				DDMStructure ddmStructure = DDMStructureLocalServiceUtil.getStructure(structureId);
//				DDMStructure ddmStructure = DDMStructureServiceUtil.getStructure(structureId);
				int count = JournalArticleServiceUtil.getArticlesCountByStructureId(themeDisplay.getScopeGroupId(), ddmStructure.getStructureKey());
				
				if(end>=count){
					end = count;
					lastRecord = true;
				}
				boolean isQuizStructure = false;
				if(ddmStructure.getNameCurrentValue().equalsIgnoreCase(NEWSMAKER_QUIZ_STR)){
					isQuizStructure = true;
				}
				
				List<JournalArticle> journalArticles = JournalArticleServiceUtil.getArticlesByStructureId(themeDisplay.getScopeGroupId(), ddmStructure.getStructureKey(),
						start, end, new ArticleModifiedDateComparator());
				if(Validator.isNotNull(journalArticles) && journalArticles.size()>0){

					AssetEntry entry = AssetEntryLocalServiceUtil.getEntry(JournalArticle.class.getName(), journalArticles.get(0).getResourcePrimKey());
					AssetRenderer assetRenderer = entry.getAssetRenderer();
					Date date = entry.getCreateDate();
					DateFormat df = new SimpleDateFormat("MMMM dd, yyyy");
					String createdDate = df.format(date);
					String discussionPath = assetRenderer.getDiscussionPath();
					String className = entry.getClassName();
					long classPK = entry.getClassPK();
					String currentUrl = PortalUtil.getCurrentURL(request);
					long userId = assetRenderer.getUserId();
					
					request.setAttribute("isQuizStructure", isQuizStructure);
					request.setAttribute("createdDate", createdDate);
					request.setAttribute("title", journalArticles.get(0).getTitleCurrentValue());
					request.setAttribute("entry", entry);
					request.setAttribute("discussionPath", discussionPath);
					request.setAttribute("userId", userId);
					request.setAttribute("currentUrl", currentUrl);
					request.setAttribute("className", className);
					request.setAttribute("classPK", classPK);
					request.setAttribute("assetRenderer", assetRenderer);
					request.setAttribute("previous", start);
					request.setAttribute("next", end);
					request.setAttribute("lastRecord", lastRecord);
					
					
					
					String journalArticle = JournalContentUtil.getContent(themeDisplay.getScopeGroupId(), journalArticles.get(0).getArticleId(),
							null,  LanguageUtil.getLanguageId(request), themeDisplay);
					request.setAttribute("journalArticle",journalArticle);
					
				}else{
					request.setAttribute("journalArticle", "");
				}
			}else{
				request.setAttribute("journalArticle", "");
			}
		} catch (SystemException e) {
			LOGGER.error("SystemException :"+e.getMessage());
		} catch (PortalException e) {
			LOGGER.error("PortalException :"+e.getMessage());
		}
	}
}
