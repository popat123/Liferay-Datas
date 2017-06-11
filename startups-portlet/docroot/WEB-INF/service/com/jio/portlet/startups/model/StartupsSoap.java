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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.jio.portlet.startups.service.http.StartupsServiceSoap}.
 *
 * @author rajnikant.donga
 * @see com.jio.portlet.startups.service.http.StartupsServiceSoap
 * @generated
 */
public class StartupsSoap implements Serializable {
	public static StartupsSoap toSoapModel(Startups model) {
		StartupsSoap soapModel = new StartupsSoap();

		soapModel.setStartupsId(model.getStartupsId());
		soapModel.setName(model.getName());
		soapModel.setCompanyName(model.getCompanyName());
		soapModel.setCategory(model.getCategory());
		soapModel.setStartupImage(model.getStartupImage());
		soapModel.setYoutubeImages(model.getYoutubeImages());
		soapModel.setYoutubeLink(model.getYoutubeLink());
		soapModel.setShortDescription(model.getShortDescription());
		soapModel.setStartupDesc(model.getStartupDesc());
		soapModel.setLongDescription(model.getLongDescription());
		soapModel.setTwitter(model.getTwitter());
		soapModel.setLinkedIn(model.getLinkedIn());
		soapModel.setYouTube(model.getYouTube());
		soapModel.setNumber(model.getNumber());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static StartupsSoap[] toSoapModels(Startups[] models) {
		StartupsSoap[] soapModels = new StartupsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StartupsSoap[][] toSoapModels(Startups[][] models) {
		StartupsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StartupsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StartupsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StartupsSoap[] toSoapModels(List<Startups> models) {
		List<StartupsSoap> soapModels = new ArrayList<StartupsSoap>(models.size());

		for (Startups model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StartupsSoap[soapModels.size()]);
	}

	public StartupsSoap() {
	}

	public long getPrimaryKey() {
		return _startupsId;
	}

	public void setPrimaryKey(long pk) {
		setStartupsId(pk);
	}

	public long getStartupsId() {
		return _startupsId;
	}

	public void setStartupsId(long startupsId) {
		_startupsId = startupsId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getCompanyName() {
		return _companyName;
	}

	public void setCompanyName(String companyName) {
		_companyName = companyName;
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;
	}

	public Long getStartupImage() {
		return _startupImage;
	}

	public void setStartupImage(Long startupImage) {
		_startupImage = startupImage;
	}

	public Long getYoutubeImages() {
		return _youtubeImages;
	}

	public void setYoutubeImages(Long youtubeImages) {
		_youtubeImages = youtubeImages;
	}

	public String getYoutubeLink() {
		return _youtubeLink;
	}

	public void setYoutubeLink(String youtubeLink) {
		_youtubeLink = youtubeLink;
	}

	public String getShortDescription() {
		return _shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		_shortDescription = shortDescription;
	}

	public String getStartupDesc() {
		return _startupDesc;
	}

	public void setStartupDesc(String startupDesc) {
		_startupDesc = startupDesc;
	}

	public String getLongDescription() {
		return _longDescription;
	}

	public void setLongDescription(String longDescription) {
		_longDescription = longDescription;
	}

	public String getTwitter() {
		return _twitter;
	}

	public void setTwitter(String twitter) {
		_twitter = twitter;
	}

	public String getLinkedIn() {
		return _linkedIn;
	}

	public void setLinkedIn(String linkedIn) {
		_linkedIn = linkedIn;
	}

	public String getYouTube() {
		return _youTube;
	}

	public void setYouTube(String youTube) {
		_youTube = youTube;
	}

	public Long getNumber() {
		return _number;
	}

	public void setNumber(Long number) {
		_number = number;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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
}