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

package com.jio.portlet.mentors.model;

import com.jio.portlet.mentors.service.ClpSerializer;
import com.jio.portlet.mentors.service.MentorsLocalServiceUtil;

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
public class MentorsClp extends BaseModelImpl<Mentors> implements Mentors {
	public MentorsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Mentors.class;
	}

	@Override
	public String getModelClassName() {
		return Mentors.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _mentorsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMentorsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _mentorsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mentorsId", getMentorsId());
		attributes.put("name", getName());
		attributes.put("companyName", getCompanyName());
		attributes.put("category", getCategory());
		attributes.put("mentorImage", getMentorImage());
		attributes.put("shortDescription", getShortDescription());
		attributes.put("longDescription", getLongDescription());
		attributes.put("number", getNumber());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mentorsId = (Long)attributes.get("mentorsId");

		if (mentorsId != null) {
			setMentorsId(mentorsId);
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

		Long mentorImage = (Long)attributes.get("mentorImage");

		if (mentorImage != null) {
			setMentorImage(mentorImage);
		}

		String shortDescription = (String)attributes.get("shortDescription");

		if (shortDescription != null) {
			setShortDescription(shortDescription);
		}

		String longDescription = (String)attributes.get("longDescription");

		if (longDescription != null) {
			setLongDescription(longDescription);
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
	public long getMentorsId() {
		return _mentorsId;
	}

	@Override
	public void setMentorsId(long mentorsId) {
		_mentorsId = mentorsId;

		if (_mentorsRemoteModel != null) {
			try {
				Class<?> clazz = _mentorsRemoteModel.getClass();

				Method method = clazz.getMethod("setMentorsId", long.class);

				method.invoke(_mentorsRemoteModel, mentorsId);
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

		if (_mentorsRemoteModel != null) {
			try {
				Class<?> clazz = _mentorsRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_mentorsRemoteModel, name);
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

		if (_mentorsRemoteModel != null) {
			try {
				Class<?> clazz = _mentorsRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyName", String.class);

				method.invoke(_mentorsRemoteModel, companyName);
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

		if (_mentorsRemoteModel != null) {
			try {
				Class<?> clazz = _mentorsRemoteModel.getClass();

				Method method = clazz.getMethod("setCategory", String.class);

				method.invoke(_mentorsRemoteModel, category);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Long getMentorImage() {
		return _mentorImage;
	}

	@Override
	public void setMentorImage(Long mentorImage) {
		_mentorImage = mentorImage;

		if (_mentorsRemoteModel != null) {
			try {
				Class<?> clazz = _mentorsRemoteModel.getClass();

				Method method = clazz.getMethod("setMentorImage", Long.class);

				method.invoke(_mentorsRemoteModel, mentorImage);
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

		if (_mentorsRemoteModel != null) {
			try {
				Class<?> clazz = _mentorsRemoteModel.getClass();

				Method method = clazz.getMethod("setShortDescription",
						String.class);

				method.invoke(_mentorsRemoteModel, shortDescription);
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

		if (_mentorsRemoteModel != null) {
			try {
				Class<?> clazz = _mentorsRemoteModel.getClass();

				Method method = clazz.getMethod("setLongDescription",
						String.class);

				method.invoke(_mentorsRemoteModel, longDescription);
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

		if (_mentorsRemoteModel != null) {
			try {
				Class<?> clazz = _mentorsRemoteModel.getClass();

				Method method = clazz.getMethod("setNumber", Long.class);

				method.invoke(_mentorsRemoteModel, number);
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

		if (_mentorsRemoteModel != null) {
			try {
				Class<?> clazz = _mentorsRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_mentorsRemoteModel, groupId);
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

		if (_mentorsRemoteModel != null) {
			try {
				Class<?> clazz = _mentorsRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_mentorsRemoteModel, companyId);
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

		if (_mentorsRemoteModel != null) {
			try {
				Class<?> clazz = _mentorsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_mentorsRemoteModel, createDate);
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

		if (_mentorsRemoteModel != null) {
			try {
				Class<?> clazz = _mentorsRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_mentorsRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMentorsRemoteModel() {
		return _mentorsRemoteModel;
	}

	public void setMentorsRemoteModel(BaseModel<?> mentorsRemoteModel) {
		_mentorsRemoteModel = mentorsRemoteModel;
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

		Class<?> remoteModelClass = _mentorsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_mentorsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MentorsLocalServiceUtil.addMentors(this);
		}
		else {
			MentorsLocalServiceUtil.updateMentors(this);
		}
	}

	@Override
	public Mentors toEscapedModel() {
		return (Mentors)ProxyUtil.newProxyInstance(Mentors.class.getClassLoader(),
			new Class[] { Mentors.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MentorsClp clone = new MentorsClp();

		clone.setMentorsId(getMentorsId());
		clone.setName(getName());
		clone.setCompanyName(getCompanyName());
		clone.setCategory(getCategory());
		clone.setMentorImage(getMentorImage());
		clone.setShortDescription(getShortDescription());
		clone.setLongDescription(getLongDescription());
		clone.setNumber(getNumber());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(Mentors mentors) {
		long primaryKey = mentors.getPrimaryKey();

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

		if (!(obj instanceof MentorsClp)) {
			return false;
		}

		MentorsClp mentors = (MentorsClp)obj;

		long primaryKey = mentors.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{mentorsId=");
		sb.append(getMentorsId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", companyName=");
		sb.append(getCompanyName());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append(", mentorImage=");
		sb.append(getMentorImage());
		sb.append(", shortDescription=");
		sb.append(getShortDescription());
		sb.append(", longDescription=");
		sb.append(getLongDescription());
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
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.jio.portlet.mentors.model.Mentors");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>mentorsId</column-name><column-value><![CDATA[");
		sb.append(getMentorsId());
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
			"<column><column-name>mentorImage</column-name><column-value><![CDATA[");
		sb.append(getMentorImage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shortDescription</column-name><column-value><![CDATA[");
		sb.append(getShortDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>longDescription</column-name><column-value><![CDATA[");
		sb.append(getLongDescription());
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

	private long _mentorsId;
	private String _name;
	private String _companyName;
	private String _category;
	private Long _mentorImage;
	private String _shortDescription;
	private String _longDescription;
	private Long _number;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _mentorsRemoteModel;
	private Class<?> _clpSerializerClass = com.jio.portlet.mentors.service.ClpSerializer.class;
}