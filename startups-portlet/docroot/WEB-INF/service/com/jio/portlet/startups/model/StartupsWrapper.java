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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Startups}.
 * </p>
 *
 * @author rajnikant.donga
 * @see Startups
 * @generated
 */
public class StartupsWrapper implements Startups, ModelWrapper<Startups> {
	public StartupsWrapper(Startups startups) {
		_startups = startups;
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

	/**
	* Returns the primary key of this startups.
	*
	* @return the primary key of this startups
	*/
	@Override
	public long getPrimaryKey() {
		return _startups.getPrimaryKey();
	}

	/**
	* Sets the primary key of this startups.
	*
	* @param primaryKey the primary key of this startups
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_startups.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the startups ID of this startups.
	*
	* @return the startups ID of this startups
	*/
	@Override
	public long getStartupsId() {
		return _startups.getStartupsId();
	}

	/**
	* Sets the startups ID of this startups.
	*
	* @param startupsId the startups ID of this startups
	*/
	@Override
	public void setStartupsId(long startupsId) {
		_startups.setStartupsId(startupsId);
	}

	/**
	* Returns the name of this startups.
	*
	* @return the name of this startups
	*/
	@Override
	public java.lang.String getName() {
		return _startups.getName();
	}

	/**
	* Sets the name of this startups.
	*
	* @param name the name of this startups
	*/
	@Override
	public void setName(java.lang.String name) {
		_startups.setName(name);
	}

	/**
	* Returns the company name of this startups.
	*
	* @return the company name of this startups
	*/
	@Override
	public java.lang.String getCompanyName() {
		return _startups.getCompanyName();
	}

	/**
	* Sets the company name of this startups.
	*
	* @param companyName the company name of this startups
	*/
	@Override
	public void setCompanyName(java.lang.String companyName) {
		_startups.setCompanyName(companyName);
	}

	/**
	* Returns the category of this startups.
	*
	* @return the category of this startups
	*/
	@Override
	public java.lang.String getCategory() {
		return _startups.getCategory();
	}

	/**
	* Sets the category of this startups.
	*
	* @param category the category of this startups
	*/
	@Override
	public void setCategory(java.lang.String category) {
		_startups.setCategory(category);
	}

	/**
	* Returns the startup image of this startups.
	*
	* @return the startup image of this startups
	*/
	@Override
	public java.lang.Long getStartupImage() {
		return _startups.getStartupImage();
	}

	/**
	* Sets the startup image of this startups.
	*
	* @param startupImage the startup image of this startups
	*/
	@Override
	public void setStartupImage(java.lang.Long startupImage) {
		_startups.setStartupImage(startupImage);
	}

	/**
	* Returns the youtube images of this startups.
	*
	* @return the youtube images of this startups
	*/
	@Override
	public java.lang.Long getYoutubeImages() {
		return _startups.getYoutubeImages();
	}

	/**
	* Sets the youtube images of this startups.
	*
	* @param youtubeImages the youtube images of this startups
	*/
	@Override
	public void setYoutubeImages(java.lang.Long youtubeImages) {
		_startups.setYoutubeImages(youtubeImages);
	}

	/**
	* Returns the youtube link of this startups.
	*
	* @return the youtube link of this startups
	*/
	@Override
	public java.lang.String getYoutubeLink() {
		return _startups.getYoutubeLink();
	}

	/**
	* Sets the youtube link of this startups.
	*
	* @param youtubeLink the youtube link of this startups
	*/
	@Override
	public void setYoutubeLink(java.lang.String youtubeLink) {
		_startups.setYoutubeLink(youtubeLink);
	}

	/**
	* Returns the short description of this startups.
	*
	* @return the short description of this startups
	*/
	@Override
	public java.lang.String getShortDescription() {
		return _startups.getShortDescription();
	}

	/**
	* Sets the short description of this startups.
	*
	* @param shortDescription the short description of this startups
	*/
	@Override
	public void setShortDescription(java.lang.String shortDescription) {
		_startups.setShortDescription(shortDescription);
	}

	/**
	* Returns the startup desc of this startups.
	*
	* @return the startup desc of this startups
	*/
	@Override
	public java.lang.String getStartupDesc() {
		return _startups.getStartupDesc();
	}

	/**
	* Sets the startup desc of this startups.
	*
	* @param startupDesc the startup desc of this startups
	*/
	@Override
	public void setStartupDesc(java.lang.String startupDesc) {
		_startups.setStartupDesc(startupDesc);
	}

	/**
	* Returns the long description of this startups.
	*
	* @return the long description of this startups
	*/
	@Override
	public java.lang.String getLongDescription() {
		return _startups.getLongDescription();
	}

	/**
	* Sets the long description of this startups.
	*
	* @param longDescription the long description of this startups
	*/
	@Override
	public void setLongDescription(java.lang.String longDescription) {
		_startups.setLongDescription(longDescription);
	}

	/**
	* Returns the twitter of this startups.
	*
	* @return the twitter of this startups
	*/
	@Override
	public java.lang.String getTwitter() {
		return _startups.getTwitter();
	}

	/**
	* Sets the twitter of this startups.
	*
	* @param twitter the twitter of this startups
	*/
	@Override
	public void setTwitter(java.lang.String twitter) {
		_startups.setTwitter(twitter);
	}

	/**
	* Returns the linked in of this startups.
	*
	* @return the linked in of this startups
	*/
	@Override
	public java.lang.String getLinkedIn() {
		return _startups.getLinkedIn();
	}

	/**
	* Sets the linked in of this startups.
	*
	* @param linkedIn the linked in of this startups
	*/
	@Override
	public void setLinkedIn(java.lang.String linkedIn) {
		_startups.setLinkedIn(linkedIn);
	}

	/**
	* Returns the you tube of this startups.
	*
	* @return the you tube of this startups
	*/
	@Override
	public java.lang.String getYouTube() {
		return _startups.getYouTube();
	}

	/**
	* Sets the you tube of this startups.
	*
	* @param youTube the you tube of this startups
	*/
	@Override
	public void setYouTube(java.lang.String youTube) {
		_startups.setYouTube(youTube);
	}

	/**
	* Returns the number of this startups.
	*
	* @return the number of this startups
	*/
	@Override
	public java.lang.Long getNumber() {
		return _startups.getNumber();
	}

	/**
	* Sets the number of this startups.
	*
	* @param number the number of this startups
	*/
	@Override
	public void setNumber(java.lang.Long number) {
		_startups.setNumber(number);
	}

	/**
	* Returns the group ID of this startups.
	*
	* @return the group ID of this startups
	*/
	@Override
	public long getGroupId() {
		return _startups.getGroupId();
	}

	/**
	* Sets the group ID of this startups.
	*
	* @param groupId the group ID of this startups
	*/
	@Override
	public void setGroupId(long groupId) {
		_startups.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this startups.
	*
	* @return the company ID of this startups
	*/
	@Override
	public long getCompanyId() {
		return _startups.getCompanyId();
	}

	/**
	* Sets the company ID of this startups.
	*
	* @param companyId the company ID of this startups
	*/
	@Override
	public void setCompanyId(long companyId) {
		_startups.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this startups.
	*
	* @return the create date of this startups
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _startups.getCreateDate();
	}

	/**
	* Sets the create date of this startups.
	*
	* @param createDate the create date of this startups
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_startups.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this startups.
	*
	* @return the modified date of this startups
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _startups.getModifiedDate();
	}

	/**
	* Sets the modified date of this startups.
	*
	* @param modifiedDate the modified date of this startups
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_startups.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _startups.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_startups.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _startups.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_startups.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _startups.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _startups.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_startups.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _startups.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_startups.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_startups.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_startups.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StartupsWrapper((Startups)_startups.clone());
	}

	@Override
	public int compareTo(com.jio.portlet.startups.model.Startups startups) {
		return _startups.compareTo(startups);
	}

	@Override
	public int hashCode() {
		return _startups.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.jio.portlet.startups.model.Startups> toCacheModel() {
		return _startups.toCacheModel();
	}

	@Override
	public com.jio.portlet.startups.model.Startups toEscapedModel() {
		return new StartupsWrapper(_startups.toEscapedModel());
	}

	@Override
	public com.jio.portlet.startups.model.Startups toUnescapedModel() {
		return new StartupsWrapper(_startups.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _startups.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _startups.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_startups.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StartupsWrapper)) {
			return false;
		}

		StartupsWrapper startupsWrapper = (StartupsWrapper)obj;

		if (Validator.equals(_startups, startupsWrapper._startups)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Startups getWrappedStartups() {
		return _startups;
	}

	@Override
	public Startups getWrappedModel() {
		return _startups;
	}

	@Override
	public void resetOriginalValues() {
		_startups.resetOriginalValues();
	}

	private Startups _startups;
}