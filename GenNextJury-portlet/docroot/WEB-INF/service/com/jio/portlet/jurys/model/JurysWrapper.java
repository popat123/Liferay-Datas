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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Jurys}.
 * </p>
 *
 * @author Reliance
 * @see Jurys
 * @generated
 */
public class JurysWrapper implements Jurys, ModelWrapper<Jurys> {
	public JurysWrapper(Jurys jurys) {
		_jurys = jurys;
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

	/**
	* Returns the primary key of this jurys.
	*
	* @return the primary key of this jurys
	*/
	@Override
	public long getPrimaryKey() {
		return _jurys.getPrimaryKey();
	}

	/**
	* Sets the primary key of this jurys.
	*
	* @param primaryKey the primary key of this jurys
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_jurys.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the jurys ID of this jurys.
	*
	* @return the jurys ID of this jurys
	*/
	@Override
	public long getJurysId() {
		return _jurys.getJurysId();
	}

	/**
	* Sets the jurys ID of this jurys.
	*
	* @param jurysId the jurys ID of this jurys
	*/
	@Override
	public void setJurysId(long jurysId) {
		_jurys.setJurysId(jurysId);
	}

	/**
	* Returns the name of this jurys.
	*
	* @return the name of this jurys
	*/
	@Override
	public java.lang.String getName() {
		return _jurys.getName();
	}

	/**
	* Sets the name of this jurys.
	*
	* @param name the name of this jurys
	*/
	@Override
	public void setName(java.lang.String name) {
		_jurys.setName(name);
	}

	/**
	* Returns the company name of this jurys.
	*
	* @return the company name of this jurys
	*/
	@Override
	public java.lang.String getCompanyName() {
		return _jurys.getCompanyName();
	}

	/**
	* Sets the company name of this jurys.
	*
	* @param companyName the company name of this jurys
	*/
	@Override
	public void setCompanyName(java.lang.String companyName) {
		_jurys.setCompanyName(companyName);
	}

	/**
	* Returns the category of this jurys.
	*
	* @return the category of this jurys
	*/
	@Override
	public java.lang.String getCategory() {
		return _jurys.getCategory();
	}

	/**
	* Sets the category of this jurys.
	*
	* @param category the category of this jurys
	*/
	@Override
	public void setCategory(java.lang.String category) {
		_jurys.setCategory(category);
	}

	/**
	* Returns the jury image of this jurys.
	*
	* @return the jury image of this jurys
	*/
	@Override
	public java.lang.Long getJuryImage() {
		return _jurys.getJuryImage();
	}

	/**
	* Sets the jury image of this jurys.
	*
	* @param juryImage the jury image of this jurys
	*/
	@Override
	public void setJuryImage(java.lang.Long juryImage) {
		_jurys.setJuryImage(juryImage);
	}

	/**
	* Returns the short description of this jurys.
	*
	* @return the short description of this jurys
	*/
	@Override
	public java.lang.String getShortDescription() {
		return _jurys.getShortDescription();
	}

	/**
	* Sets the short description of this jurys.
	*
	* @param shortDescription the short description of this jurys
	*/
	@Override
	public void setShortDescription(java.lang.String shortDescription) {
		_jurys.setShortDescription(shortDescription);
	}

	/**
	* Returns the long description of this jurys.
	*
	* @return the long description of this jurys
	*/
	@Override
	public java.lang.String getLongDescription() {
		return _jurys.getLongDescription();
	}

	/**
	* Sets the long description of this jurys.
	*
	* @param longDescription the long description of this jurys
	*/
	@Override
	public void setLongDescription(java.lang.String longDescription) {
		_jurys.setLongDescription(longDescription);
	}

	/**
	* Returns the number of this jurys.
	*
	* @return the number of this jurys
	*/
	@Override
	public java.lang.Long getNumber() {
		return _jurys.getNumber();
	}

	/**
	* Sets the number of this jurys.
	*
	* @param number the number of this jurys
	*/
	@Override
	public void setNumber(java.lang.Long number) {
		_jurys.setNumber(number);
	}

	/**
	* Returns the group ID of this jurys.
	*
	* @return the group ID of this jurys
	*/
	@Override
	public long getGroupId() {
		return _jurys.getGroupId();
	}

	/**
	* Sets the group ID of this jurys.
	*
	* @param groupId the group ID of this jurys
	*/
	@Override
	public void setGroupId(long groupId) {
		_jurys.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this jurys.
	*
	* @return the company ID of this jurys
	*/
	@Override
	public long getCompanyId() {
		return _jurys.getCompanyId();
	}

	/**
	* Sets the company ID of this jurys.
	*
	* @param companyId the company ID of this jurys
	*/
	@Override
	public void setCompanyId(long companyId) {
		_jurys.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this jurys.
	*
	* @return the create date of this jurys
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _jurys.getCreateDate();
	}

	/**
	* Sets the create date of this jurys.
	*
	* @param createDate the create date of this jurys
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_jurys.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this jurys.
	*
	* @return the modified date of this jurys
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _jurys.getModifiedDate();
	}

	/**
	* Sets the modified date of this jurys.
	*
	* @param modifiedDate the modified date of this jurys
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_jurys.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _jurys.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_jurys.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _jurys.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_jurys.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _jurys.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _jurys.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_jurys.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _jurys.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_jurys.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_jurys.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_jurys.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new JurysWrapper((Jurys)_jurys.clone());
	}

	@Override
	public int compareTo(com.jio.portlet.jurys.model.Jurys jurys) {
		return _jurys.compareTo(jurys);
	}

	@Override
	public int hashCode() {
		return _jurys.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.jio.portlet.jurys.model.Jurys> toCacheModel() {
		return _jurys.toCacheModel();
	}

	@Override
	public com.jio.portlet.jurys.model.Jurys toEscapedModel() {
		return new JurysWrapper(_jurys.toEscapedModel());
	}

	@Override
	public com.jio.portlet.jurys.model.Jurys toUnescapedModel() {
		return new JurysWrapper(_jurys.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _jurys.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _jurys.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_jurys.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JurysWrapper)) {
			return false;
		}

		JurysWrapper jurysWrapper = (JurysWrapper)obj;

		if (Validator.equals(_jurys, jurysWrapper._jurys)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Jurys getWrappedJurys() {
		return _jurys;
	}

	@Override
	public Jurys getWrappedModel() {
		return _jurys;
	}

	@Override
	public void resetOriginalValues() {
		_jurys.resetOriginalValues();
	}

	private Jurys _jurys;
}