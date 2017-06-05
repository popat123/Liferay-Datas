/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.newsmaker.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.journal.NoSuchArticleException;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.util.comparator.ArticleCreateDateComparator;
import com.newsmaker.service.base.NewsDetailLocalServiceBaseImpl;

/**
 * The implementation of the news detail local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.newsmaker.service.NewsDetailLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author sandeep.nair
 * @see com.newsmaker.service.base.NewsDetailLocalServiceBaseImpl
 * @see com.newsmaker.service.NewsDetailLocalServiceUtil
 */
public class NewsDetailLocalServiceImpl extends NewsDetailLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.newsmaker.service.NewsDetailLocalServiceUtil} to access the news detail local service.
	 */
	
	public JournalArticle[] getPreviousNextJournalArticle(JournalArticle currentArticle){
		JournalArticle[] array = null;
		try {
			array = journalArticlePersistence.findByStructureId_PrevAndNext(currentArticle.getId(), currentArticle.getStructureId(), new ArticleCreateDateComparator());
			
		} catch (NoSuchArticleException e) {
			
		} catch (SystemException e) {
			
		}
		return array;
	}
}