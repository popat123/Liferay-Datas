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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Mentors}.
 * </p>
 *
 * @author Reliance
 * @see Mentors
 * @generated
 */
public class MentorsWrapper implements Mentors, ModelWrapper<Mentors> {
	public MentorsWrapper(Mentors mentors) {
		_mentors = mentors;
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

	/**
	* Returns the primary key of this mentors.
	*
	* @return the primary key of this mentors
	*/
	@Override
	public long getPrimaryKey() {
		return _mentors.getPrimaryKey();
	}

	/**
	* Sets the primary key of this mentors.
	*
	* @param primaryKey the primary key of this mentors
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_mentors.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the mentors ID of this mentors.
	*
	* @return the mentors ID of this mentors
	*/
	@Override
	public long getMentorsId() {
		return _mentors.getMentorsId();
	}

	/**
	* Sets the mentors ID of this mentors.
	*
	* @param mentorsId the mentors ID of this mentors
	*/
	@Override
	public void setMentorsId(long mentorsId) {
		_mentors.setMentorsId(mentorsId);
	}

	/**
	* Returns the name of this mentors.
	*
	* @return the name of this mentors
	*/
	@Override
	public java.lang.String getName() {
		return _mentors.getName();
	}

	/**
	* Sets the name of this mentors.
	*
	* @param name the name of this mentors
	*/
	@Override
	public void setName(java.lang.String name) {
		_mentors.setName(name);
	}

	/**
	* Returns the company name of this mentors.
	*
	* @return the company name of this mentors
	*/
	@Override
	public java.lang.String getCompanyName() {
		return _mentors.getCompanyName();
	}

	/**
	* Sets the company name of this mentors.
	*
	* @param companyName the company name of this mentors
	*/
	@Override
	public void setCompanyName(java.lang.String companyName) {
		_mentors.setCompanyName(companyName);
	}

	/**
	* Returns the category of this mentors.
	*
	* @return the category of this mentors
	*/
	@Override
	public java.lang.String getCategory() {
		return _mentors.getCategory();
	}

	/**
	* Sets the category of this mentors.
	*
	* @param category the category of this mentors
	*/
	@Override
	public void setCategory(java.lang.String category) {
		_mentors.setCategory(category);
	}

	/**
	* Returns the mentor image of this mentors.
	*
	* @return the mentor image of this mentors
	*/
	@Override
	public java.lang.Long getMentorImage() {
		return _mentors.getMentorImage();
	}

	/**
	* Sets the mentor image of this mentors.
	*
	* @param mentorImage the mentor image of this mentors
	*/
	@Override
	public void setMentorImage(java.lang.Long mentorImage) {
		_mentors.setMentorImage(mentorImage);
	}

	/**
	* Returns the short description of this mentors.
	*
	* @return the short description of this mentors
	*/
	@Override
	public java.lang.String getShortDescription() {
		return _mentors.getShortDescription();
	}

	/**
	* Sets the short description of this mentors.
	*
	* @param shortDescription the short description of this mentors
	*/
	@Override
	public void setShortDescription(java.lang.String shortDescription) {
		_mentors.setShortDescription(shortDescription);
	}

	/**
	* Returns the long description of this mentors.
	*
	* @return the long description of this mentors
	*/
	@Override
	public java.lang.String getLongDescription() {
		return _mentors.getLongDescription();
	}

	/**
	* Sets the long description of this mentors.
	*
	* @param longDescription the long description of this mentors
	*/
	@Override
	public void setLongDescription(java.lang.String longDescription) {
		_mentors.setLongDescription(longDescription);
	}

	/**
	* Returns the number of this mentors.
	*
	* @return the number of this mentors
	*/
	@Override
	public java.lang.Long getNumber() {
		return _mentors.getNumber();
	}

	/**
	* Sets the number of this mentors.
	*
	* @param number the number of this mentors
	*/
	@Override
	public void setNumber(java.lang.Long number) {
		_mentors.setNumber(number);
	}

	/**
	* Returns the group ID of this mentors.
	*
	* @return the group ID of this mentors
	*/
	@Override
	public long getGroupId() {
		return _mentors.getGroupId();
	}

	/**
	* Sets the group ID of this mentors.
	*
	* @param groupId the group ID of this mentors
	*/
	@Override
	public void setGroupId(long groupId) {
		_mentors.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this mentors.
	*
	* @return the company ID of this mentors
	*/
	@Override
	public long getCompanyId() {
		return _mentors.getCompanyId();
	}

	/**
	* Sets the company ID of this mentors.
	*
	* @param companyId the company ID of this mentors
	*/
	@Override
	public void setCompanyId(long companyId) {
		_mentors.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this mentors.
	*
	* @return the create date of this mentors
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _mentors.getCreateDate();
	}

	/**
	* Sets the create date of this mentors.
	*
	* @param createDate the create date of this mentors
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_mentors.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this mentors.
	*
	* @return the modified date of this mentors
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _mentors.getModifiedDate();
	}

	/**
	* Sets the modified date of this mentors.
	*
	* @param modifiedDate the modified date of this mentors
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_mentors.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _mentors.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_mentors.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _mentors.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_mentors.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _mentors.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _mentors.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_mentors.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _mentors.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_mentors.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_mentors.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_mentors.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MentorsWrapper((Mentors)_mentors.clone());
	}

	@Override
	public int compareTo(com.jio.portlet.mentors.model.Mentors mentors) {
		return _mentors.compareTo(mentors);
	}

	@Override
	public int hashCode() {
		return _mentors.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.jio.portlet.mentors.model.Mentors> toCacheModel() {
		return _mentors.toCacheModel();
	}

	@Override
	public com.jio.portlet.mentors.model.Mentors toEscapedModel() {
		return new MentorsWrapper(_mentors.toEscapedModel());
	}

	@Override
	public com.jio.portlet.mentors.model.Mentors toUnescapedModel() {
		return new MentorsWrapper(_mentors.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _mentors.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _mentors.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_mentors.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MentorsWrapper)) {
			return false;
		}

		MentorsWrapper mentorsWrapper = (MentorsWrapper)obj;

		if (Validator.equals(_mentors, mentorsWrapper._mentors)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Mentors getWrappedMentors() {
		return _mentors;
	}

	@Override
	public Mentors getWrappedModel() {
		return _mentors;
	}

	@Override
	public void resetOriginalValues() {
		_mentors.resetOriginalValues();
	}

	private Mentors _mentors;
}