package com.newsmaker.service.events;

import java.util.List;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

public class NewsMakerArticleModelListener extends BaseModelListener<JournalArticle>{

	@Override
	public void onAfterUpdate(JournalArticle model) throws ModelListenerException {
		// TODO Auto-generated method stub
		try {
			 JournalArticle latestArticle = JournalArticleLocalServiceUtil.getLatestArticle(model.getResourcePrimKey());
			 List<JournalArticle> articles = JournalArticleLocalServiceUtil.getArticles(model.getGroupId(), model.getArticleId());
			 for(JournalArticle article : articles){
				 if(article.isApproved() && !article.equals(latestArticle)){
 					 JournalArticleLocalServiceUtil.deleteArticle(article);
				 }
			 }
		} catch (SystemException e) {
			LOGGER.error("Error getting article",e);
		}catch (PortalException e) {
			LOGGER.error("Error getting article",e);
		}
		super.onAfterUpdate(model);
		
	}

	private static Log LOGGER = LogFactoryUtil.getLog(NewsMakerArticleModelListener.class);
	
}
