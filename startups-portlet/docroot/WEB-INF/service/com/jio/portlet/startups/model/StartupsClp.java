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

package com.jio.portlet.startups.model;

import com.jio.portlet.startups.service.ClpSerializer;
import com.jio.portlet.startups.service.StartupsLocalServiceUtil;

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
 * @author rajnikant.donga
 */
public class StartupsClp extends BaseModelImpl<Startups> implements Startups {
	public StartupsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Startups.class;
	}

	@Override
	public String getModelClassName() {
		return Startups.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _startupsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStartupsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _startupsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("startupsId", getStartupsId());
		attributes.put("name", getName());
		attributes.put("companyName", getCompanyName());
		attributes.put("category", getCategory());
		attributes.put("startupImage", getStartupImage());
		attributes.put("youtubeImages", getYoutubeImages());
		attributes.put("youtubeLink", getYoutubeLink());
		attributes.put("shortDescription", getShortDescription());
		attributes.put("startupDesc", getStartupDesc());
		attributes.put("longDescription", getLongDescription());
		attributes.put("twitter", getTwitter());
		attributes.put("linkedIn", getLinkedIn());
		attributes.put("youTube", getYouTube());
		attributes.put("number", getNumber());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long startupsId = (Long)attributes.get("startupsId");

		if (startupsId != null) {
			setStartupsId(startupsId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String companyName = (String)attributes.get("companyName");

		if (companyName != null) {
			setCompanyName(companyName);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		Long startupImage = (Long)attributes.get("startupImage");

		if (startupImage != null) {
			setStartupImage(startupImage);
		}

		Long youtubeImages = (Long)attributes.get("youtubeImages");

		if (youtubeImages != null) {
			setYoutubeImages(youtubeImages);
		}

		String youtubeLink = (String)attributes.get("youtubeLink");

		if (youtubeLink != null) {
			setYoutubeLink(youtubeLink);
		}

		String shortDescription = (String)attributes.get("shortDescription");

		if (shortDescription != null) {
			setShortDescription(shortDescription);
		}

		String startupDesc = (String)attributes.get("startupDesc");

		if (startupDesc != null) {
			setStartupDesc(startupDesc);
		}

		String longDescription = (String)attributes.get("longDescription");

		if (longDescription != null) {
			setLongDescription(longDescription);
		}

		String twitter = (String)attributes.get("twitter");

		if (twitter != null) {
			setTwitter(twitter);
		}

		String linkedIn = (String)attributes.get("linkedIn");

		if (linkedIn != null) {
			setLinkedIn(linkedIn);
		}

		String youTube = (String)attributes.get("youTube");

		if (youTube != null) {
			setYouTube(youTube);
		}

		Long number = (Long)attributes.get("number");

		if (number != null) {
			setNumber(number);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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
	public long getStartupsId() {
		return _startupsId;
	}

	@Override
	public void setStartupsId(long startupsId) {
		_startupsId = startupsId;

		if (_startupsRemoteModel != null) {
			try {
				Class<?> clazz = _startupsRemoteModel.getClass();

				Method method = clazz.getMethod("setStartupsId", long.class);

				method.invoke(_startupsRemoteModel, startupsId);
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

		if (_startupsRemoteModel != null) {
			try {
				Class<?> clazz = _startupsRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_startupsRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCompanyName() {
		return _companyName;
	}

	@Override
	public void setCompanyName(String companyName) {
		_companyName = companyName;

		if (_startupsRemoteModel != null) {
			try {
				Class<?> clazz = _startupsRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyName", String.class);

				method.invoke(_startupsRemoteModel, companyName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCategory() {
		return _category;
	}

	@Override
	public void setCategory(String category) {
		_category = category;

		if (_startupsRemoteModel != null) {
			try {
				Class<?> clazz = _startupsRemoteModel.getClass();

				Method method = clazz.getMethod("setCategory", String.class);

				method.invoke(_startupsRemoteModel, category);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Long getStartupImage() {
		return _startupImage;
	}

	@Override
	public void setStartupImage(Long startupImage) {
		_startupImage = startupImage;

		if (_startupsRemoteModel != null) {
			try {
				Class<?> clazz = _startupsRemoteModel.getClass();

				Method method = clazz.getMethod("setStartupImage", Long.class);

				method.invoke(_startupsRemoteModel, startupImage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Long getYoutubeImages() {
		return _youtubeImages;
	}

	@Override
	public void setYoutubeImages(Long youtubeImages) {
		_youtubeImages = youtubeImages;

		if (_startupsRemoteModel != null) {
			try {
				Class<?> clazz = _startupsRemoteModel.getClass();

				Method method = clazz.getMethod("setYoutubeImages", Long.class);

				method.invoke(_startupsRemoteModel, youtubeImages);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getYoutubeLink() {
		return _youtubeLink;
	}

	@Override
	public void setYoutubeLink(String youtubeLink) {
		_youtubeLink = youtubeLink;

		if (_startupsRemoteModel != null) {
			try {
				Class<?> clazz = _startupsRemoteModel.getClass();

				Method method = clazz.getMethod("setYoutubeLink", String.class);

				method.invoke(_startupsRemoteModel, youtubeLink);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShortDescription() {
		return _shortDescription;
	}

	@Override
	public void setShortDescription(String shortDescription) {
		_shortDescription = shortDescription;

		if (_startupsRemoteModel != null) {
			try {
				Class<?> clazz = _startupsRemoteModel.getClass();

				Method method = clazz.getMethod("setShortDescription",
						String.class);

				method.invoke(_startupsRemoteModel, shortDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStartupDesc() {
		return _startupDesc;
	}

	@Override
	public void setStartupDesc(String startupDesc) {
		_startupDesc = startupDesc;

		if (_startupsRemoteModel != null) {
			try {
				Class<?> clazz = _startupsRemoteModel.getClass();

				Method method = clazz.getMethod("setStartupDesc", String.class);

				method.invoke(_startupsRemoteModel, startupDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLongDescription() {
		return _longDescription;
	}

	@Override
	public void setLongDescription(String longDescription) {
		_longDescription = longDescription;

		if (_startupsRemoteModel != null) {
			try {
				Class<?> clazz = _startupsRemoteModel.getClass();

				Method method = clazz.getMethod("setLongDescription",
						String.class);

				method.invoke(_startupsRemoteModel, longDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTwitter() {
		return _twitter;
	}

	@Override
	public void setTwitter(String twitter) {
		_twitter = twitter;

		if (_startupsRemoteModel != null) {
			try {
				Class<?> clazz = _startupsRemoteModel.getClass();

				Method method = clazz.getMethod("setTwitter", String.class);

				method.invoke(_startupsRemoteModel, twitter);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLinkedIn() {
		return _linkedIn;
	}

	@Override
	public void setLinkedIn(String linkedIn) {
		_linkedIn = linkedIn;

		if (_startupsRemoteModel != null) {
			try {
				Class<?> clazz = _startupsRemoteModel.getClass();

				Method method = clazz.getMethod("setLinkedIn", String.class);

				method.invoke(_startupsRemoteModel, linkedIn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getYouTube() {
		return _youTube;
	}

	@Override
	public void setYouTube(String youTube) {
		_youTube = youTube;

		if (_startupsRemoteModel != null) {
			try {
				Class<?> clazz = _startupsRemoteModel.getClass();

				Method method = clazz.getMethod("setYouTube", String.class);

				method.invoke(_startupsRemoteModel, youTube);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Long getNumber() {
		return _number;
	}

	@Override
	public void setNumber(Long number) {
		_number = number;

		if (_startupsRemoteModel != null) {
			try {
				Class<?> clazz = _startupsRemoteModel.getClass();

				Method method = clazz.getMethod("setNumber", Long.class);

				method.invoke(_startupsRemoteModel, number);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_startupsRemoteModel != null) {
			try {
				Class<?> clazz = _startupsRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_startupsRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_startupsRemoteModel != null) {
			try {
				Class<?> clazz = _startupsRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_startupsRemoteModel, companyId);
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

		if (_startupsRemoteModel != null) {
			try {
				Class<?> clazz = _startupsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_startupsRemoteModel, createDate);
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

		if (_startupsRemoteModel != null) {
			try {
				Class<?> clazz = _startupsRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_startupsRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getStartupsRemoteModel() {
		return _startupsRemoteModel;
	}

	public void setStartupsRemoteModel(BaseModel<?> startupsRemoteModel) {
		_startupsRemoteModel = startupsRemoteModel;
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

		Class<?> remoteModelClass = _startupsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_startupsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StartupsLocalServiceUtil.addStartups(this);
		}
		else {
			StartupsLocalServiceUtil.updateStartups(this);
		}
	}

	@Override
	public Startups toEscapedModel() {
		return (Startups)ProxyUtil.newProxyInstance(Startups.class.getClassLoader(),
			new Class[] { Startups.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StartupsClp clone = new StartupsClp();

		clone.setStartupsId(getStartupsId());
		clone.setName(getName());
		clone.setCompanyName(getCompanyName());
		clone.setCategory(getCategory());
		clone.setStartupImage(getStartupImage());
		clone.setYoutubeImages(getYoutubeImages());
		clone.setYoutubeLink(getYoutubeLink());
		clone.setShortDescription(getShortDescription());
		clone.setStartupDesc(getStartupDesc());
		clone.setLongDescription(getLongDescription());
		clone.setTwitter(getTwitter());
		clone.setLinkedIn(getLinkedIn());
		clone.setYouTube(getYouTube());
		clone.setNumber(getNumber());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(Startups startups) {
		long primaryKey = startups.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StartupsClp)) {
			return false;
		}

		StartupsClp startups = (StartupsClp)obj;

		long primaryKey = startups.getPrimaryKey();

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
		StringBundler sb = new StringBundler(37);

		sb.append("{startupsId=");
		sb.append(getStartupsId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", companyName=");
		sb.append(getCompanyName());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append(", startupImage=");
		sb.append(getStartupImage());
		sb.append(", youtubeImages=");
		sb.append(getYoutubeImages());
		sb.append(", youtubeLink=");
		sb.append(getYoutubeLink());
		sb.append(", shortDescription=");
		sb.append(getShortDescription());
		sb.append(", startupDesc=");
		sb.append(getStartupDesc());
		sb.append(", longDescription=");
		sb.append(getLongDescription());
		sb.append(", twitter=");
		sb.append(getTwitter());
		sb.append(", linkedIn=");
		sb.append(getLinkedIn());
		sb.append(", youTube=");
		sb.append(getYouTube());
		sb.append(", number=");
		sb.append(getNumber());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.jio.portlet.startups.model.Startups");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>startupsId</column-name><column-value><![CDATA[");
		sb.append(getStartupsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyName</column-name><column-value><![CDATA[");
		sb.append(getCompanyName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>category</column-name><column-value><![CDATA[");
		sb.append(getCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startupImage</column-name><column-value><![CDATA[");
		sb.append(getStartupImage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>youtubeImages</column-name><column-value><![CDATA[");
		sb.append(getYoutubeImages());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>youtubeLink</column-name><column-value><![CDATA[");
		sb.append(getYoutubeLink());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shortDescription</column-name><column-value><![CDATA[");
		sb.append(getShortDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startupDesc</column-name><column-value><![CDATA[");
		sb.append(getStartupDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>longDescription</column-name><column-value><![CDATA[");
		sb.append(getLongDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>twitter</column-name><column-value><![CDATA[");
		sb.append(getTwitter());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>linkedIn</column-name><column-value><![CDATA[");
		sb.append(getLinkedIn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>youTube</column-name><column-value><![CDATA[");
		sb.append(getYouTube());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>number</column-name><column-value><![CDATA[");
		sb.append(getNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
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

	private long _startupsId;
	private String _name;
	private String _companyName;
	private String _category;
	private Long _startupImage;
	private Long _youtubeImages;
	private String _youtubeLink;
	private String _shortDescription;
	private String _startupDesc;
	private String _longDescription;
	private String _twitter;
	private String _linkedIn;
	private String _youTube;
	private Long _number;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _startupsRemoteModel;
	private Class<?> _clpSerializerClass = com.jio.portlet.startups.service.ClpSerializer.class;
}