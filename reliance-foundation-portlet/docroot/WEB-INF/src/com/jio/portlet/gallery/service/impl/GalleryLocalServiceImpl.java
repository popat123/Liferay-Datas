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

import com.jio.portlet.gallery.controller.GalleryPortlet;
import com.jio.portlet.gallery.model.Gallery;
import com.jio.portlet.gallery.model.impl.GalleryImpl;
import com.jio.portlet.gallery.service.GalleryLocalServiceUtil;
import com.jio.portlet.gallery.service.base.GalleryLocalServiceBaseImpl;
import com.jio.portlet.gallery.service.persistence.GalleryUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderServiceUtil;
import com.liferay.util.portlet.PortletProps;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * The implementation of the gallery local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.jio.portlet.gallery.service.GalleryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Reliance
 * @see com.jio.portlet.gallery.service.base.GalleryLocalServiceBaseImpl
 * @see com.jio.portlet.gallery.service.GalleryLocalServiceUtil
 */
public class GalleryLocalServiceImpl extends GalleryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.jio.portlet.gallery.service.GalleryLocalServiceUtil} to access the gallery local service.
	 */
	private static final Log LOGGER = LogFactoryUtil.getLog(GalleryLocalServiceImpl.class);
	public Gallery addGallery(String type,String thumbnailName,String name,String mainCategory,String projectImagesPath, boolean isVideo,boolean isIMG,boolean youTubeLink,boolean videosImagPriority,boolean gallryImagPriority,String demoLink, String liveLink, long number,long videoImageId,long bigImageId,long thumbnailImageId) {
		
		

		 Gallery gallery = null;
		try {
			 gallery = GalleryLocalServiceUtil.createGallery(CounterLocalServiceUtil.increment(Gallery.class.getName()));
			 
			 gallery.setType(type);
			 gallery.setThumbnailName(thumbnailName);
			 gallery.setName(name);
			 gallery.setMainCategory(mainCategory);
			 gallery.setIsVideo(isVideo);
			 gallery.setProjectImagesPath(projectImagesPath);
			 gallery.setIsIMG(isIMG);
			 gallery.setYouTubeLink(youTubeLink);
			 gallery.setGallryImagPriority(gallryImagPriority);
			 gallery.setVideosImagPriority(videosImagPriority);
			 gallery.setDemoLink(demoLink);
			 gallery.setLiveLink(liveLink);
			 gallery.setNumber(number);
			 gallery.setVideoImagesId(videoImageId);
			 gallery.setGalleryImagesId(bigImageId);
			 gallery.setThumbnailImagesId(thumbnailImageId);
			 
			 GalleryLocalServiceUtil.addGallery(gallery);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		 return gallery;
	}
	
	
public List<Gallery> getVideosPriority(boolean videosImagPriority) throws SystemException,IOException{
		
		List<Gallery> galleries = null;
		
		try {
			galleries = GalleryUtil.findByVideoPriority(videosImagPriority);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return galleries;		
	}
	

public List<Gallery> getImagePriority(boolean gallryImagPriority) throws SystemException,IOException{
	
	List<Gallery> galleries = null;
	
	try {
		galleries = GalleryUtil.findByImagePriority(gallryImagPriority);
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return galleries;
	
	
}
		
		
}