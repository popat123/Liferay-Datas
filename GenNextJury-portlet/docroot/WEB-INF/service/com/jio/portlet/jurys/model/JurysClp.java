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

package com.jio.portlet.jurys.model;

import com.jio.portlet.jurys.service.ClpSerializer;
import com.jio.portlet.jurys.service.JurysLocalServiceUtil;

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
public class JurysClp extends BaseModelImpl<Jurys> implements Jurys {
	public JurysClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Jurys.class;
	}

	@Override
	public String getModelClassName() {
		return Jurys.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _jurysId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setJurysId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _jurysId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jurysId", getJurysId());
		attributes.put("name", getName());
		attributes.put("companyName", getCompanyName());
		attributes.put("category", getCategory());
		attributes.put("juryImage", getJuryImage());
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
		Long jurysId = (Long)attributes.get("jurysId");

		if (jurysId != null) {
			setJurysId(jurysId);
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

		Long juryImage = (Long)attributes.get("juryImage");

		if (juryImage != null) {
			setJuryImage(juryImage);
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
	public long getJurysId() {
		return _jurysId;
	}

	@Override
	public void setJurysId(long jurysId) {
		_jurysId = jurysId;

		if (_jurysRemoteModel != null) {
			try {
				Class<?> clazz = _jurysRemoteModel.getClass();

				Method method = clazz.getMethod("setJurysId", long.class);

				method.invoke(_jurysRemoteModel, jurysId);
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

		if (_jurysRemoteModel != null) {
			try {
				Class<?> clazz = _jurysRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_jurysRemoteModel, name);
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

		if (_jurysRemoteModel != null) {
			try {
				Class<?> clazz = _jurysRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyName", String.class);

				method.invoke(_jurysRemoteModel, companyName);
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

		if (_jurysRemoteModel != null) {
			try {
				Class<?> clazz = _jurysRemoteModel.getClass();

				Method method = clazz.getMethod("setCategory", String.class);

				method.invoke(_jurysRemoteModel, category);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Long getJuryImage() {
		return _juryImage;
	}

	@Override
	public void setJuryImage(Long juryImage) {
		_juryImage = juryImage;

		if (_jurysRemoteModel != null) {
			try {
				Class<?> clazz = _jurysRemoteModel.getClass();

				Method method = clazz.getMethod("setJuryImage", Long.class);

				method.invoke(_jurysRemoteModel, juryImage);
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

		if (_jurysRemoteModel != null) {
			try {
				Class<?> clazz = _jurysRemoteModel.getClass();

				Method method = clazz.getMethod("setShortDescription",
						String.class);

				method.invoke(_jurysRemoteModel, shortDescription);
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

		if (_jurysRemoteModel != null) {
			try {
				Class<?> clazz = _jurysRemoteModel.getClass();

				Method method = clazz.getMethod("setLongDescription",
						String.class);

				method.invoke(_jurysRemoteModel, longDescription);
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

		if (_jurysRemoteModel != null) {
			try {
				Class<?> clazz = _jurysRemoteModel.getClass();

				Method method = clazz.getMethod("setNumber", Long.class);

				method.invoke(_jurysRemoteModel, number);
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

		if (_jurysRemoteModel != null) {
			try {
				Class<?> clazz = _jurysRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_jurysRemoteModel, groupId);
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

		if (_jurysRemoteModel != null) {
			try {
				Class<?> clazz = _jurysRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_jurysRemoteModel, companyId);
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

		if (_jurysRemoteModel != null) {
			try {
				Class<?> clazz = _jurysRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_jurysRemoteModel, createDate);
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

		if (_jurysRemoteModel != null) {
			try {
				Class<?> clazz = _jurysRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_jurysRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getJurysRemoteModel() {
		return _jurysRemoteModel;
	}

	public void setJurysRemoteModel(BaseModel<?> jurysRemoteModel) {
		_jurysRemoteModel = jurysRemoteModel;
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

		Class<?> remoteModelClass = _jurysRemoteModel.getClass();

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

		Object returnValue = method.invoke(_jurysRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			JurysLocalServiceUtil.addJurys(this);
		}
		else {
			JurysLocalServiceUtil.updateJurys(this);
		}
	}

	@Override
	public Jurys toEscapedModel() {
		return (Jurys)ProxyUtil.newProxyInstance(Jurys.class.getClassLoader(),
			new Class[] { Jurys.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		JurysClp clone = new JurysClp();

		clone.setJurysId(getJurysId());
		clone.setName(getName());
		clone.setCompanyName(getCompanyName());
		clone.setCategory(getCategory());
		clone.setJuryImage(getJuryImage());
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
	public int compareTo(Jurys jurys) {
		long primaryKey = jurys.getPrimaryKey();

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

		if (!(obj instanceof JurysClp)) {
			return false;
		}

		JurysClp jurys = (JurysClp)obj;

		long primaryKey = jurys.getPrimaryKey();

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

		sb.append("{jurysId=");
		sb.append(getJurysId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", companyName=");
		sb.append(getCompanyName());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append(", juryImage=");
		sb.append(getJuryImage());
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
		sb.append("com.jio.portlet.jurys.model.Jurys");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>jurysId</column-name><column-value><![CDATA[");
		sb.append(getJurysId());
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
			"<column><column-name>juryImage</column-name><column-value><![CDATA[");
		sb.append(getJuryImage());
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

	private long _jurysId;
	private String _name;
	private String _companyName;
	private String _category;
	private Long _juryImage;
	private String _shortDescription;
	private String _longDescription;
	private Long _number;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _jurysRemoteModel;
	private Class<?> _clpSerializerClass = com.jio.portlet.jurys.service.ClpSerializer.class;
}