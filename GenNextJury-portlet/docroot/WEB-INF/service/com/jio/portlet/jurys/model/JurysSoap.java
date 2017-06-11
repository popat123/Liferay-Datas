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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Reliance
 * @generated
 */
public class JurysSoap implements Serializable {
	public static JurysSoap toSoapModel(Jurys model) {
		JurysSoap soapModel = new JurysSoap();

		soapModel.setJurysId(model.getJurysId());
		soapModel.setName(model.getName());
		soapModel.setCompanyName(model.getCompanyName());
		soapModel.setCategory(model.getCategory());
		soapModel.setJuryImage(model.getJuryImage());
		soapModel.setShortDescription(model.getShortDescription());
		soapModel.setLongDescription(model.getLongDescription());
		soapModel.setNumber(model.getNumber());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static JurysSoap[] toSoapModels(Jurys[] models) {
		JurysSoap[] soapModels = new JurysSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static JurysSoap[][] toSoapModels(Jurys[][] models) {
		JurysSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new JurysSoap[models.length][models[0].length];
		}
		else {
			soapModels = new JurysSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static JurysSoap[] toSoapModels(List<Jurys> models) {
		List<JurysSoap> soapModels = new ArrayList<JurysSoap>(models.size());

		for (Jurys model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new JurysSoap[soapModels.size()]);
	}

	public JurysSoap() {
	}

	public long getPrimaryKey() {
		return _jurysId;
	}

	public void setPrimaryKey(long pk) {
		setJurysId(pk);
	}

	public long getJurysId() {
		return _jurysId;
	}

	public void setJurysId(long jurysId) {
		_jurysId = jurysId;
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

	public Long getJuryImage() {
		return _juryImage;
	}

	public void setJuryImage(Long juryImage) {
		_juryImage = juryImage;
	}

	public String getShortDescription() {
		return _shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		_shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return _longDescription;
	}

	public void setLongDescription(String longDescription) {
		_longDescription = longDescription;
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
}