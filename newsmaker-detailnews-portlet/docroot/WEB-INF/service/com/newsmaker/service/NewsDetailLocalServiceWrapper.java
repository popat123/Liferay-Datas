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

package com.newsmaker.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link NewsDetailLocalService}.
 *
 * @author sandeep.nair
 * @see NewsDetailLocalService
 * @generated
 */
public class NewsDetailLocalServiceWrapper implements NewsDetailLocalService,
	ServiceWrapper<NewsDetailLocalService> {
	public NewsDetailLocalServiceWrapper(
		NewsDetailLocalService newsDetailLocalService) {
		_newsDetailLocalService = newsDetailLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _newsDetailLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_newsDetailLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _newsDetailLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.portlet.journal.model.JournalArticle[] getPreviousNextJournalArticle(
		com.liferay.portlet.journal.model.JournalArticle currentArticle) {
		return _newsDetailLocalService.getPreviousNextJournalArticle(currentArticle);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public NewsDetailLocalService getWrappedNewsDetailLocalService() {
		return _newsDetailLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedNewsDetailLocalService(
		NewsDetailLocalService newsDetailLocalService) {
		_newsDetailLocalService = newsDetailLocalService;
	}

	@Override
	public NewsDetailLocalService getWrappedService() {
		return _newsDetailLocalService;
	}

	@Override
	public void setWrappedService(NewsDetailLocalService newsDetailLocalService) {
		_newsDetailLocalService = newsDetailLocalService;
	}

	private NewsDetailLocalService _newsDetailLocalService;
}