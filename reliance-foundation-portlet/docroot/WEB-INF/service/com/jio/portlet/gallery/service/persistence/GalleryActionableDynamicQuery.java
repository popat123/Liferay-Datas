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

package com.jio.portlet.gallery.service.persistence;

import com.jio.portlet.gallery.model.Gallery;
import com.jio.portlet.gallery.service.GalleryLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Reliance
 * @generated
 */
public abstract class GalleryActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public GalleryActionableDynamicQuery() throws SystemException {
		setBaseLocalService(GalleryLocalServiceUtil.getService());
		setClass(Gallery.class);

		setClassLoader(com.jio.portlet.gallery.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("galleryId");
	}
}