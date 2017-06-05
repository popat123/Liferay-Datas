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

package com.jio.portlet.gallery.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.jio.portlet.gallery.service.http.GalleryServiceSoap}.
 *
 * @author Reliance
 * @see com.jio.portlet.gallery.service.http.GalleryServiceSoap
 * @generated
 */
public class GallerySoap implements Serializable {
	public static GallerySoap toSoapModel(Gallery model) {
		GallerySoap soapModel = new GallerySoap();

		soapModel.setGalleryId(model.getGalleryId());
		soapModel.setType(model.getType());
		soapModel.setThumbnailName(model.getThumbnailName());
		soapModel.setName(model.getName());
		soapModel.setMainCategory(model.getMainCategory());
		soapModel.setProjectImagesPath(model.getProjectImagesPath());
		soapModel.setGalleryImagesId(model.getGalleryImagesId());
		soapModel.setVideoImagesId(model.getVideoImagesId());
		soapModel.setThumbnailImagesId(model.getThumbnailImagesId());
		soapModel.setIsVideo(model.getIsVideo());
		soapModel.setIsIMG(model.getIsIMG());
		soapModel.setYouTubeLink(model.getYouTubeLink());
		soapModel.setVideosImagPriority(model.getVideosImagPriority());
		soapModel.setGallryImagPriority(model.getGallryImagPriority());
		soapModel.setDemoLink(model.getDemoLink());
		soapModel.setLiveLink(model.getLiveLink());
		soapModel.setNumber(model.getNumber());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static GallerySoap[] toSoapModels(Gallery[] models) {
		GallerySoap[] soapModels = new GallerySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GallerySoap[][] toSoapModels(Gallery[][] models) {
		GallerySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GallerySoap[models.length][models[0].length];
		}
		else {
			soapModels = new GallerySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GallerySoap[] toSoapModels(List<Gallery> models) {
		List<GallerySoap> soapModels = new ArrayList<GallerySoap>(models.size());

		for (Gallery model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GallerySoap[soapModels.size()]);
	}

	public GallerySoap() {
	}

	public long getPrimaryKey() {
		return _galleryId;
	}

	public void setPrimaryKey(long pk) {
		setGalleryId(pk);
	}

	public long getGalleryId() {
		return _galleryId;
	}

	public void setGalleryId(long galleryId) {
		_galleryId = galleryId;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getThumbnailName() {
		return _thumbnailName;
	}

	public void setThumbnailName(String thumbnailName) {
		_thumbnailName = thumbnailName;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getMainCategory() {
		return _mainCategory;
	}

	public void setMainCategory(String mainCategory) {
		_mainCategory = mainCategory;
	}

	public String getProjectImagesPath() {
		return _projectImagesPath;
	}

	public void setProjectImagesPath(String projectImagesPath) {
		_projectImagesPath = projectImagesPath;
	}

	public Long getGalleryImagesId() {
		return _galleryImagesId;
	}

	public void setGalleryImagesId(Long galleryImagesId) {
		_galleryImagesId = galleryImagesId;
	}

	public Long getVideoImagesId() {
		return _VideoImagesId;
	}

	public void setVideoImagesId(Long VideoImagesId) {
		_VideoImagesId = VideoImagesId;
	}

	public Long getThumbnailImagesId() {
		return _thumbnailImagesId;
	}

	public void setThumbnailImagesId(Long thumbnailImagesId) {
		_thumbnailImagesId = thumbnailImagesId;
	}

	public boolean getIsVideo() {
		return _isVideo;
	}

	public boolean isIsVideo() {
		return _isVideo;
	}

	public void setIsVideo(boolean isVideo) {
		_isVideo = isVideo;
	}

	public boolean getIsIMG() {
		return _isIMG;
	}

	public boolean isIsIMG() {
		return _isIMG;
	}

	public void setIsIMG(boolean isIMG) {
		_isIMG = isIMG;
	}

	public boolean getYouTubeLink() {
		return _youTubeLink;
	}

	public boolean isYouTubeLink() {
		return _youTubeLink;
	}

	public void setYouTubeLink(boolean youTubeLink) {
		_youTubeLink = youTubeLink;
	}

	public boolean getVideosImagPriority() {
		return _videosImagPriority;
	}

	public boolean isVideosImagPriority() {
		return _videosImagPriority;
	}

	public void setVideosImagPriority(boolean videosImagPriority) {
		_videosImagPriority = videosImagPriority;
	}

	public boolean getGallryImagPriority() {
		return _gallryImagPriority;
	}

	public boolean isGallryImagPriority() {
		return _gallryImagPriority;
	}

	public void setGallryImagPriority(boolean gallryImagPriority) {
		_gallryImagPriority = gallryImagPriority;
	}

	public String getDemoLink() {
		return _demoLink;
	}

	public void setDemoLink(String demoLink) {
		_demoLink = demoLink;
	}

	public String getLiveLink() {
		return _liveLink;
	}

	public void setLiveLink(String liveLink) {
		_liveLink = liveLink;
	}

	public long getNumber() {
		return _number;
	}

	public void setNumber(long number) {
		_number = number;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _galleryId;
	private String _type;
	private String _thumbnailName;
	private String _name;
	private String _mainCategory;
	private String _projectImagesPath;
	private Long _galleryImagesId;
	private Long _VideoImagesId;
	private Long _thumbnailImagesId;
	private boolean _isVideo;
	private boolean _isIMG;
	private boolean _youTubeLink;
	private boolean _videosImagPriority;
	private boolean _gallryImagPriority;
	private String _demoLink;
	private String _liveLink;
	private long _number;
	private Date _createDate;
	private Date _modifiedDate;
}