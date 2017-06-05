package com.newsmaker.portlet.detailnews.helper;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.NoSuchStructureException;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleServiceUtil;
import com.liferay.portlet.journalcontent.util.JournalContentUtil;
import com.newsmaker.service.NewsDetailLocalServiceUtil;

public class DetailNewsHelper {
	private static final Log LOGGER = LogFactoryUtil.getLog(DetailNewsHelper.class);
	private static final String NEWSMAKER_QUIZ_STR = PropsUtil.get("structure.newsmaker");
	private static final String NEWSMAKER_UTILITIES_STR = PropsUtil.get("structure.newsmaker.utilities");
	public static void detailNewsHelper(RenderRequest request,RenderResponse response) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		String articleId  =ParamUtil.getString(request, "articleId");
		String site = ParamUtil.getString(request, "siteId");
		
		if(Validator.isNotNull(site)){
			long siteId = Long.parseLong(site);
			String languageId = LanguageUtil.getLanguageId(request);
			
			try {
				
				JournalArticle article = JournalArticleServiceUtil.getArticle(siteId, articleId);
				
				JournalArticle[] journalArticleArray = NewsDetailLocalServiceUtil.getPreviousNextJournalArticle(article);
				AssetEntry entry = AssetEntryLocalServiceUtil.getEntry(JournalArticle.class.getName(), article.getResourcePrimKey());
				
				String portletTitle = ParamUtil.getString(request, "title");
				request.setAttribute("portletTitle", portletTitle);
				AssetRenderer assetRenderer = entry.getAssetRenderer();
				boolean isQueryStructure = false;
				boolean isQuizStructure = false;
				
				try { 
					DDMStructure structure = DDMStructureLocalServiceUtil.getStructure(article.getGroupId(), ClassNameLocalServiceUtil.getClassNameId(JournalArticle.class.getName()), article.getStructureId());
					if (structure.getNameCurrentValue().equalsIgnoreCase(NEWSMAKER_QUIZ_STR) || structure.getNameCurrentValue().equalsIgnoreCase(NEWSMAKER_UTILITIES_STR)) {
						isQueryStructure = true;
						
					}
					if(structure.getNameCurrentValue().equalsIgnoreCase(NEWSMAKER_QUIZ_STR)){
						isQuizStructure = true;
					}
					
					
				} catch (NoSuchStructureException ne) { // if not search on Global
					LOGGER.error("NoSuchStructureException :"+ne.getMessage());
				}catch (PortalException e) {
					LOGGER.error("PortalException:"+e.getMessage());
				} catch (SystemException e) {
					LOGGER.error("SystemException:"+e.getMessage());
				}
				request.setAttribute("isQuizStructure", isQuizStructure);
				request.setAttribute("isQueryStructure", isQueryStructure);
				String discussionPath = assetRenderer.getDiscussionPath();
				String className = entry.getClassName();
				long classPK = entry.getClassPK();
				String currentUrl = PortalUtil.getCurrentURL(request);
				long userId = assetRenderer.getUserId();
				
				request.setAttribute("portletTitle", portletTitle);
				request.setAttribute("title", article.getTitleCurrentValue());
				request.setAttribute("entry", entry);
				request.setAttribute("discussionPath", discussionPath);
				request.setAttribute("userId", userId);
				request.setAttribute("currentUrl", currentUrl);
				request.setAttribute("className", className);
				request.setAttribute("classPK", classPK);
				request.setAttribute("assetRenderer", assetRenderer);
				request.setAttribute("resourcePrimKey", article.getResourcePrimKey());
				request.setAttribute("previousArticle", journalArticleArray[0]);
				request.setAttribute("nextArticle", journalArticleArray[2]);
			} catch (PortalException e) {
				LOGGER.error("PortalException:"+e.getMessage());
			} catch (SystemException e) {
				LOGGER.error("SystemException:"+e.getMessage());
			}
		
			String journalArticle = JournalContentUtil.getContent(siteId, articleId, null, languageId, themeDisplay);
			
			request.setAttribute("journalArticle", journalArticle);
		}else{
			request.setAttribute("journalArticle", "");
		}
	}
	
}
