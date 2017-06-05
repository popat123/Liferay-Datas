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

import com.jio.portlet.gallery.service.ClpSerializer;
import com.jio.portlet.gallery.service.GalleryLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Reliance
 */
public class GalleryClp extends BaseModelImpl<Gallery> implements Gallery {
	public GalleryClp() {
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
	public long getPrimaryKey() {
		return _galleryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGalleryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _galleryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getGalleryId() {
		return _galleryId;
	}

	@Override
	public void setGalleryId(long galleryId) {
		_galleryId = galleryId;

		if (_galleryRemoteModel != null) {
			try {
				Class<?> clazz = _galleryRemoteModel.getClass();

				Method method = clazz.getMethod("setGalleryId", long.class);

				method.invoke(_galleryRemoteModel, galleryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getType() {
		return _type;
	}

	@Override
	public void setType(String type) {
		_type = type;

		if (_galleryRemoteModel != null) {
			try {
				Class<?> clazz = _galleryRemoteModel.getClass();

				Method method = clazz.getMethod("setType", String.class);

				method.invoke(_galleryRemoteModel, type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getThumbnailName() {
		return _thumbnailName;
	}

	@Override
	public void setThumbnailName(String thumbnailName) {
		_thumbnailName = thumbnailName;

		if (_galleryRemoteModel != null) {
			try {
				Class<?> clazz = _galleryRemoteModel.getClass();

				Method method = clazz.getMethod("setThumbnailName", String.class);

				method.invoke(_galleryRemoteModel, thumbnailName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_galleryRemoteModel != null) {
			try {
				Class<?> clazz = _galleryRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_galleryRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMainCategory() {
		return _mainCategory;
	}

	@Override
	public void setMainCategory(String mainCategory) {
		_mainCategory = mainCategory;

		if (_galleryRemoteModel != null) {
			try {
				Class<?> clazz = _galleryRemoteModel.getClass();

				Method method = clazz.getMethod("setMainCategory", String.class);

				method.invoke(_galleryRemoteModel, mainCategory);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProjectImagesPath() {
		return _projectImagesPath;
	}

	@Override
	public void setProjectImagesPath(String projectImagesPath) {
		_projectImagesPath = projectImagesPath;

		if (_galleryRemoteModel != null) {
			try {
				Class<?> clazz = _galleryRemoteModel.getClass();

				Method method = clazz.getMethod("setProjectImagesPath",
						String.class);

				method.invoke(_galleryRemoteModel, projectImagesPath);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Long getGalleryImagesId() {
		return _galleryImagesId;
	}

	@Override
	public void setGalleryImagesId(Long galleryImagesId) {
		_galleryImagesId = galleryImagesId;

		if (_galleryRemoteModel != null) {
			try {
				Class<?> clazz = _galleryRemoteModel.getClass();

				Method method = clazz.getMethod("setGalleryImagesId", Long.class);

				method.invoke(_galleryRemoteModel, galleryImagesId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Long getVideoImagesId() {
		return _VideoImagesId;
	}

	@Override
	public void setVideoImagesId(Long VideoImagesId) {
		_VideoImagesId = VideoImagesId;

		if (_galleryRemoteModel != null) {
			try {
				Class<?> clazz = _galleryRemoteModel.getClass();

				Method method = clazz.getMethod("setVideoImagesId", Long.class);

				method.invoke(_galleryRemoteModel, VideoImagesId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Long getThumbnailImagesId() {
		return _thumbnailImagesId;
	}

	@Override
	public void setThumbnailImagesId(Long thumbnailImagesId) {
		_thumbnailImagesId = thumbnailImagesId;

		if (_galleryRemoteModel != null) {
			try {
				Class<?> clazz = _galleryRemoteModel.getClass();

				Method method = clazz.getMethod("setThumbnailImagesId",
						Long.class);

				method.invoke(_galleryRemoteModel, thumbnailImagesId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsVideo() {
		return _isVideo;
	}

	@Override
	public boolean isIsVideo() {
		return _isVideo;
	}

	@Override
	public void setIsVideo(boolean isVideo) {
		_isVideo = isVideo;

		if (_galleryRemoteModel != null) {
			try {
				Class<?> clazz = _galleryRemoteModel.getClass();

				Method method = clazz.getMethod("setIsVideo", boolean.class);

				method.invoke(_galleryRemoteModel, isVideo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsIMG() {
		return _isIMG;
	}

	@Override
	public boolean isIsIMG() {
		return _isIMG;
	}

	@Override
	public void setIsIMG(boolean isIMG) {
		_isIMG = isIMG;

		if (_galleryRemoteModel != null) {
			try {
				Class<?> clazz = _galleryRemoteModel.getClass();

				Method method = clazz.getMethod("setIsIMG", boolean.class);

				method.invoke(_galleryRemoteModel, isIMG);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getYouTubeLink() {
		return _youTubeLink;
	}

	@Override
	public boolean isYouTubeLink() {
		return _youTubeLink;
	}

	@Override
	public void setYouTubeLink(boolean youTubeLink) {
		_youTubeLink = youTubeLink;

		if (_galleryRemoteModel != null) {
			try {
				Class<?> clazz = _galleryRemoteModel.getClass();

				Method method = clazz.getMethod("setYouTubeLink", boolean.class);

				method.invoke(_galleryRemoteModel, youTubeLink);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getVideosImagPriority() {
		return _videosImagPriority;
	}

	@Override
	public boolean isVideosImagPriority() {
		return _videosImagPriority;
	}

	@Override
	public void setVideosImagPriority(boolean videosImagPriority) {
		_videosImagPriority = videosImagPriority;

		if (_galleryRemoteModel != null) {
			try {
				Class<?> clazz = _galleryRemoteModel.getClass();

				Method method = clazz.getMethod("setVideosImagPriority",
						boolean.class);

				method.invoke(_galleryRemoteModel, videosImagPriority);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getGallryImagPriority() {
		return _gallryImagPriority;
	}

	@Override
	public boolean isGallryImagPriority() {
		return _gallryImagPriority;
	}

	@Override
	public void setGallryImagPriority(boolean gallryImagPriority) {
		_gallryImagPriority = gallryImagPriority;

		if (_galleryRemoteModel != null) {
			try {
				Class<?> clazz = _galleryRemoteModel.getClass();

				Method method = clazz.getMethod("setGallryImagPriority",
						boolean.class);

				method.invoke(_galleryRemoteModel, gallryImagPriority);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDemoLink() {
		return _demoLink;
	}

	@Override
	public void setDemoLink(String demoLink) {
		_demoLink = demoLink;

		if (_galleryRemoteModel != null) {
			try {
				Class<?> clazz = _galleryRemoteModel.getClass();

				Method method = clazz.getMethod("setDemoLink", String.class);

				method.invoke(_galleryRemoteModel, demoLink);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLiveLink() {
		return _liveLink;
	}

	@Override
	public void setLiveLink(String liveLink) {
		_liveLink = liveLink;

		if (_galleryRemoteModel != null) {
			try {
				Class<?> clazz = _galleryRemoteModel.getClass();

				Method method = clazz.getMethod("setLiveLink", String.class);

				method.invoke(_galleryRemoteModel, liveLink);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNumber() {
		return _number;
	}

	@Override
	public void setNumber(long number) {
		_number = number;

		if (_galleryRemoteModel != null) {
			try {
				Class<?> clazz = _galleryRemoteModel.getClass();

				Method method = clazz.getMethod("setNumber", long.class);

				method.invoke(_galleryRemoteModel, number);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_galleryRemoteModel != null) {
			try {
				Class<?> clazz = _galleryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_galleryRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_galleryRemoteModel != null) {
			try {
				Class<?> clazz = _galleryRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_galleryRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGalleryRemoteModel() {
		return _galleryRemoteModel;
	}

	public void setGalleryRemoteModel(BaseModel<?> galleryRemoteModel) {
		_galleryRemoteModel = galleryRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _galleryRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_galleryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GalleryLocalServiceUtil.addGallery(this);
		}
		else {
			GalleryLocalServiceUtil.updateGallery(this);
		}
	}

	@Override
	public Gallery toEscapedModel() {
		return (Gallery)ProxyUtil.newProxyInstance(Gallery.class.getClassLoader(),
			new Class[] { Gallery.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GalleryClp clone = new GalleryClp();

		clone.setGalleryId(getGalleryId());
		clone.setType(getType());
		clone.setThumbnailName(getThumbnailName());
		clone.setName(getName());
		clone.setMainCategory(getMainCategory());
		clone.setProjectImagesPath(getProjectImagesPath());
		clone.setGalleryImagesId(getGalleryImagesId());
		clone.setVideoImagesId(getVideoImagesId());
		clone.setThumbnailImagesId(getThumbnailImagesId());
		clone.setIsVideo(getIsVideo());
		clone.setIsIMG(getIsIMG());
		clone.setYouTubeLink(getYouTubeLink());
		clone.setVideosImagPriority(getVideosImagPriority());
		clone.setGallryImagPriority(getGallryImagPriority());
		clone.setDemoLink(getDemoLink());
		clone.setLiveLink(getLiveLink());
		clone.setNumber(getNumber());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(Gallery gallery) {
		int value = 0;

		if (getNumber() < gallery.getNumber()) {
			value = -1;
		}
		else if (getNumber() > gallery.getNumber()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GalleryClp)) {
			return false;
		}

		GalleryClp gallery = (GalleryClp)obj;

		long primaryKey = gallery.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{galleryId=");
		sb.append(getGalleryId());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", thumbnailName=");
		sb.append(getThumbnailName());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", mainCategory=");
		sb.append(getMainCategory());
		sb.append(", projectImagesPath=");
		sb.append(getProjectImagesPath());
		sb.append(", galleryImagesId=");
		sb.append(getGalleryImagesId());
		sb.append(", VideoImagesId=");
		sb.append(getVideoImagesId());
		sb.append(", thumbnailImagesId=");
		sb.append(getThumbnailImagesId());
		sb.append(", isVideo=");
		sb.append(getIsVideo());
		sb.append(", isIMG=");
		sb.append(getIsIMG());
		sb.append(", youTubeLink=");
		sb.append(getYouTubeLink());
		sb.append(", videosImagPriority=");
		sb.append(getVideosImagPriority());
		sb.append(", gallryImagPriority=");
		sb.append(getGallryImagPriority());
		sb.append(", demoLink=");
		sb.append(getDemoLink());
		sb.append(", liveLink=");
		sb.append(getLiveLink());
		sb.append(", number=");
		sb.append(getNumber());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.jio.portlet.gallery.model.Gallery");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>galleryId</column-name><column-value><![CDATA[");
		sb.append(getGalleryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thumbnailName</column-name><column-value><![CDATA[");
		sb.append(getThumbnailName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mainCategory</column-name><column-value><![CDATA[");
		sb.append(getMainCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectImagesPath</column-name><column-value><![CDATA[");
		sb.append(getProjectImagesPath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>galleryImagesId</column-name><column-value><![CDATA[");
		sb.append(getGalleryImagesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>VideoImagesId</column-name><column-value><![CDATA[");
		sb.append(getVideoImagesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thumbnailImagesId</column-name><column-value><![CDATA[");
		sb.append(getThumbnailImagesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isVideo</column-name><column-value><![CDATA[");
		sb.append(getIsVideo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isIMG</column-name><column-value><![CDATA[");
		sb.append(getIsIMG());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>youTubeLink</column-name><column-value><![CDATA[");
		sb.append(getYouTubeLink());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videosImagPriority</column-name><column-value><![CDATA[");
		sb.append(getVideosImagPriority());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gallryImagPriority</column-name><column-value><![CDATA[");
		sb.append(getGallryImagPriority());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>demoLink</column-name><column-value><![CDATA[");
		sb.append(getDemoLink());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>liveLink</column-name><column-value><![CDATA[");
		sb.append(getLiveLink());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>number</column-name><column-value><![CDATA[");
		sb.append(getNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _galleryRemoteModel;
	private Class<?> _clpSerializerClass = com.jio.portlet.gallery.service.ClpSerializer.class;
}