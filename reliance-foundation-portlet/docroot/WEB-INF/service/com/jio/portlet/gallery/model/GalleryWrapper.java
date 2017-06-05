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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Gallery}.
 * </p>
 *
 * @author Reliance
 * @see Gallery
 * @generated
 */
public class GalleryWrapper implements Gallery, ModelWrapper<Gallery> {
	public GalleryWrapper(Gallery gallery) {
		_gallery = gallery;
	}

	@Override
	public Class<?> getModelClass() {
		return Gallery.class;
	}

	@Override
	public String getModelClassName() {
		return Gallery.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("galleryId", getGalleryId());
		attributes.put("type", getType());
		attributes.put("thumbnailName", getThumbnailName());
		attributes.put("name", getName());
		attributes.put("mainCategory", getMainCategory());
		attributes.put("projectImagesPath", getProjectImagesPath());
		attributes.put("galleryImagesId", getGalleryImagesId());
		attributes.put("VideoImagesId", getVideoImagesId());
		attributes.put("thumbnailImagesId", getThumbnailImagesId());
		attributes.put("isVideo", getIsVideo());
		attributes.put("isIMG", getIsIMG());
		attributes.put("youTubeLink", getYouTubeLink());
		attributes.put("videosImagPriority", getVideosImagPriority());
		attributes.put("gallryImagPriority", getGallryImagPriority());
		attributes.put("demoLink", getDemoLink());
		attributes.put("liveLink", getLiveLink());
		attributes.put("number", getNumber());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long galleryId = (Long)attributes.get("galleryId");

		if (galleryId != null) {
			setGalleryId(galleryId);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String thumbnailName = (String)attributes.get("thumbnailName");

		if (thumbnailName != null) {
			setThumbnailName(thumbnailName);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String mainCategory = (String)attributes.get("mainCategory");

		if (mainCategory != null) {
			setMainCategory(mainCategory);
		}

		String projectImagesPath = (String)attributes.get("projectImagesPath");

		if (projectImagesPath != null) {
			setProjectImagesPath(projectImagesPath);
		}

		Long galleryImagesId = (Long)attributes.get("galleryImagesId");

		if (galleryImagesId != null) {
			setGalleryImagesId(galleryImagesId);
		}

		Long VideoImagesId = (Long)attributes.get("VideoImagesId");

		if (VideoImagesId != null) {
			setVideoImagesId(VideoImagesId);
		}

		Long thumbnailImagesId = (Long)attributes.get("thumbnailImagesId");

		if (thumbnailImagesId != null) {
			setThumbnailImagesId(thumbnailImagesId);
		}

		Boolean isVideo = (Boolean)attributes.get("isVideo");

		if (isVideo != null) {
			setIsVideo(isVideo);
		}

		Boolean isIMG = (Boolean)attributes.get("isIMG");

		if (isIMG != null) {
			setIsIMG(isIMG);
		}

		Boolean youTubeLink = (Boolean)attributes.get("youTubeLink");

		if (youTubeLink != null) {
			setYouTubeLink(youTubeLink);
		}

		Boolean videosImagPriority = (Boolean)attributes.get(
				"videosImagPriority");

		if (videosImagPriority != null) {
			setVideosImagPriority(videosImagPriority);
		}

		Boolean gallryImagPriority = (Boolean)attributes.get(
				"gallryImagPriority");

		if (gallryImagPriority != null) {
			setGallryImagPriority(gallryImagPriority);
		}

		String demoLink = (String)attributes.get("demoLink");

		if (demoLink != null) {
			setDemoLink(demoLink);
		}

		String liveLink = (String)attributes.get("liveLink");

		if (liveLink != null) {
			setLiveLink(liveLink);
		}

		Long number = (Long)attributes.get("number");

		if (number != null) {
			setNumber(number);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	* Returns the primary key of this gallery.
	*
	* @return the primary key of this gallery
	*/
	@Override
	public long getPrimaryKey() {
		return _gallery.getPrimaryKey();
	}

	/**
	* Sets the primary key of this gallery.
	*
	* @param primaryKey the primary key of this gallery
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_gallery.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the gallery ID of this gallery.
	*
	* @return the gallery ID of this gallery
	*/
	@Override
	public long getGalleryId() {
		return _gallery.getGalleryId();
	}

	/**
	* Sets the gallery ID of this gallery.
	*
	* @param galleryId the gallery ID of this gallery
	*/
	@Override
	public void setGalleryId(long galleryId) {
		_gallery.setGalleryId(galleryId);
	}

	/**
	* Returns the type of this gallery.
	*
	* @return the type of this gallery
	*/
	@Override
	public java.lang.String getType() {
		return _gallery.getType();
	}

	/**
	* Sets the type of this gallery.
	*
	* @param type the type of this gallery
	*/
	@Override
	public void setType(java.lang.String type) {
		_gallery.setType(type);
	}

	/**
	* Returns the thumbnail name of this gallery.
	*
	* @return the thumbnail name of this gallery
	*/
	@Override
	public java.lang.String getThumbnailName() {
		return _gallery.getThumbnailName();
	}

	/**
	* Sets the thumbnail name of this gallery.
	*
	* @param thumbnailName the thumbnail name of this gallery
	*/
	@Override
	public void setThumbnailName(java.lang.String thumbnailName) {
		_gallery.setThumbnailName(thumbnailName);
	}

	/**
	* Returns the name of this gallery.
	*
	* @return the name of this gallery
	*/
	@Override
	public java.lang.String getName() {
		return _gallery.getName();
	}

	/**
	* Sets the name of this gallery.
	*
	* @param name the name of this gallery
	*/
	@Override
	public void setName(java.lang.String name) {
		_gallery.setName(name);
	}

	/**
	* Returns the main category of this gallery.
	*
	* @return the main category of this gallery
	*/
	@Override
	public java.lang.String getMainCategory() {
		return _gallery.getMainCategory();
	}

	/**
	* Sets the main category of this gallery.
	*
	* @param mainCategory the main category of this gallery
	*/
	@Override
	public void setMainCategory(java.lang.String mainCategory) {
		_gallery.setMainCategory(mainCategory);
	}

	/**
	* Returns the project images path of this gallery.
	*
	* @return the project images path of this gallery
	*/
	@Override
	public java.lang.String getProjectImagesPath() {
		return _gallery.getProjectImagesPath();
	}

	/**
	* Sets the project images path of this gallery.
	*
	* @param projectImagesPath the project images path of this gallery
	*/
	@Override
	public void setProjectImagesPath(java.lang.String projectImagesPath) {
		_gallery.setProjectImagesPath(projectImagesPath);
	}

	/**
	* Returns the gallery images ID of this gallery.
	*
	* @return the gallery images ID of this gallery
	*/
	@Override
	public java.lang.Long getGalleryImagesId() {
		return _gallery.getGalleryImagesId();
	}

	/**
	* Sets the gallery images ID of this gallery.
	*
	* @param galleryImagesId the gallery images ID of this gallery
	*/
	@Override
	public void setGalleryImagesId(java.lang.Long galleryImagesId) {
		_gallery.setGalleryImagesId(galleryImagesId);
	}

	/**
	* Returns the video images ID of this gallery.
	*
	* @return the video images ID of this gallery
	*/
	@Override
	public java.lang.Long getVideoImagesId() {
		return _gallery.getVideoImagesId();
	}

	/**
	* Sets the video images ID of this gallery.
	*
	* @param VideoImagesId the video images ID of this gallery
	*/
	@Override
	public void setVideoImagesId(java.lang.Long VideoImagesId) {
		_gallery.setVideoImagesId(VideoImagesId);
	}

	/**
	* Returns the thumbnail images ID of this gallery.
	*
	* @return the thumbnail images ID of this gallery
	*/
	@Override
	public java.lang.Long getThumbnailImagesId() {
		return _gallery.getThumbnailImagesId();
	}

	/**
	* Sets the thumbnail images ID of this gallery.
	*
	* @param thumbnailImagesId the thumbnail images ID of this gallery
	*/
	@Override
	public void setThumbnailImagesId(java.lang.Long thumbnailImagesId) {
		_gallery.setThumbnailImagesId(thumbnailImagesId);
	}

	/**
	* Returns the is video of this gallery.
	*
	* @return the is video of this gallery
	*/
	@Override
	public boolean getIsVideo() {
		return _gallery.getIsVideo();
	}

	/**
	* Returns <code>true</code> if this gallery is is video.
	*
	* @return <code>true</code> if this gallery is is video; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsVideo() {
		return _gallery.isIsVideo();
	}

	/**
	* Sets whether this gallery is is video.
	*
	* @param isVideo the is video of this gallery
	*/
	@Override
	public void setIsVideo(boolean isVideo) {
		_gallery.setIsVideo(isVideo);
	}

	/**
	* Returns the is i m g of this gallery.
	*
	* @return the is i m g of this gallery
	*/
	@Override
	public boolean getIsIMG() {
		return _gallery.getIsIMG();
	}

	/**
	* Returns <code>true</code> if this gallery is is i m g.
	*
	* @return <code>true</code> if this gallery is is i m g; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsIMG() {
		return _gallery.isIsIMG();
	}

	/**
	* Sets whether this gallery is is i m g.
	*
	* @param isIMG the is i m g of this gallery
	*/
	@Override
	public void setIsIMG(boolean isIMG) {
		_gallery.setIsIMG(isIMG);
	}

	/**
	* Returns the you tube link of this gallery.
	*
	* @return the you tube link of this gallery
	*/
	@Override
	public boolean getYouTubeLink() {
		return _gallery.getYouTubeLink();
	}

	/**
	* Returns <code>true</code> if this gallery is you tube link.
	*
	* @return <code>true</code> if this gallery is you tube link; <code>false</code> otherwise
	*/
	@Override
	public boolean isYouTubeLink() {
		return _gallery.isYouTubeLink();
	}

	/**
	* Sets whether this gallery is you tube link.
	*
	* @param youTubeLink the you tube link of this gallery
	*/
	@Override
	public void setYouTubeLink(boolean youTubeLink) {
		_gallery.setYouTubeLink(youTubeLink);
	}

	/**
	* Returns the videos imag priority of this gallery.
	*
	* @return the videos imag priority of this gallery
	*/
	@Override
	public boolean getVideosImagPriority() {
		return _gallery.getVideosImagPriority();
	}

	/**
	* Returns <code>true</code> if this gallery is videos imag priority.
	*
	* @return <code>true</code> if this gallery is videos imag priority; <code>false</code> otherwise
	*/
	@Override
	public boolean isVideosImagPriority() {
		return _gallery.isVideosImagPriority();
	}

	/**
	* Sets whether this gallery is videos imag priority.
	*
	* @param videosImagPriority the videos imag priority of this gallery
	*/
	@Override
	public void setVideosImagPriority(boolean videosImagPriority) {
		_gallery.setVideosImagPriority(videosImagPriority);
	}

	/**
	* Returns the gallry imag priority of this gallery.
	*
	* @return the gallry imag priority of this gallery
	*/
	@Override
	public boolean getGallryImagPriority() {
		return _gallery.getGallryImagPriority();
	}

	/**
	* Returns <code>true</code> if this gallery is gallry imag priority.
	*
	* @return <code>true</code> if this gallery is gallry imag priority; <code>false</code> otherwise
	*/
	@Override
	public boolean isGallryImagPriority() {
		return _gallery.isGallryImagPriority();
	}

	/**
	* Sets whether this gallery is gallry imag priority.
	*
	* @param gallryImagPriority the gallry imag priority of this gallery
	*/
	@Override
	public void setGallryImagPriority(boolean gallryImagPriority) {
		_gallery.setGallryImagPriority(gallryImagPriority);
	}

	/**
	* Returns the demo link of this gallery.
	*
	* @return the demo link of this gallery
	*/
	@Override
	public java.lang.String getDemoLink() {
		return _gallery.getDemoLink();
	}

	/**
	* Sets the demo link of this gallery.
	*
	* @param demoLink the demo link of this gallery
	*/
	@Override
	public void setDemoLink(java.lang.String demoLink) {
		_gallery.setDemoLink(demoLink);
	}

	/**
	* Returns the live link of this gallery.
	*
	* @return the live link of this gallery
	*/
	@Override
	public java.lang.String getLiveLink() {
		return _gallery.getLiveLink();
	}

	/**
	* Sets the live link of this gallery.
	*
	* @param liveLink the live link of this gallery
	*/
	@Override
	public void setLiveLink(java.lang.String liveLink) {
		_gallery.setLiveLink(liveLink);
	}

	/**
	* Returns the number of this gallery.
	*
	* @return the number of this gallery
	*/
	@Override
	public long getNumber() {
		return _gallery.getNumber();
	}

	/**
	* Sets the number of this gallery.
	*
	* @param number the number of this gallery
	*/
	@Override
	public void setNumber(long number) {
		_gallery.setNumber(number);
	}

	/**
	* Returns the create date of this gallery.
	*
	* @return the create date of this gallery
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _gallery.getCreateDate();
	}

	/**
	* Sets the create date of this gallery.
	*
	* @param createDate the create date of this gallery
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_gallery.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this gallery.
	*
	* @return the modified date of this gallery
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _gallery.getModifiedDate();
	}

	/**
	* Sets the modified date of this gallery.
	*
	* @param modifiedDate the modified date of this gallery
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_gallery.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _gallery.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_gallery.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _gallery.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_gallery.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _gallery.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _gallery.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_gallery.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _gallery.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_gallery.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_gallery.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_gallery.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GalleryWrapper((Gallery)_gallery.clone());
	}

	@Override
	public int compareTo(com.jio.portlet.gallery.model.Gallery gallery) {
		return _gallery.compareTo(gallery);
	}

	@Override
	public int hashCode() {
		return _gallery.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.jio.portlet.gallery.model.Gallery> toCacheModel() {
		return _gallery.toCacheModel();
	}

	@Override
	public com.jio.portlet.gallery.model.Gallery toEscapedModel() {
		return new GalleryWrapper(_gallery.toEscapedModel());
	}

	@Override
	public com.jio.portlet.gallery.model.Gallery toUnescapedModel() {
		return new GalleryWrapper(_gallery.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _gallery.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _gallery.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_gallery.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GalleryWrapper)) {
			return false;
		}

		GalleryWrapper galleryWrapper = (GalleryWrapper)obj;

		if (Validator.equals(_gallery, galleryWrapper._gallery)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Gallery getWrappedGallery() {
		return _gallery;
	}

	@Override
	public Gallery getWrappedModel() {
		return _gallery;
	}

	@Override
	public void resetOriginalValues() {
		_gallery.resetOriginalValues();
	}

	private Gallery _gallery;
}