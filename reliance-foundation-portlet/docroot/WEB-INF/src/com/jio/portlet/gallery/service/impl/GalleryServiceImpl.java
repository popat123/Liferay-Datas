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

package com.jio.portlet.gallery.service.impl;

import com.jio.portlet.gallery.service.base.GalleryServiceBaseImpl;

/**
 * The implementation of the gallery remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.jio.portlet.gallery.service.GalleryService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Reliance
 * @see com.jio.portlet.gallery.service.base.GalleryServiceBaseImpl
 * @see com.jio.portlet.gallery.service.GalleryServiceUtil
 */
public class GalleryServiceImpl extends GalleryServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.jio.portlet.gallery.service.GalleryServiceUtil} to access the gallery remote service.
	 */
	public String getURL(String name){
		System.out.println("called");
		name = "rajni";
		return name;
	}
}