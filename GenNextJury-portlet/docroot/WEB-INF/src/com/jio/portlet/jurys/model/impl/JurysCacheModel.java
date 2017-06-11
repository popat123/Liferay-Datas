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

package com.jio.portlet.jurys.model.impl;

import com.jio.portlet.jurys.model.Jurys;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Jurys in entity cache.
 *
 * @author Reliance
 * @see Jurys
 * @generated
 */
public class JurysCacheModel implements CacheModel<Jurys>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{jurysId=");
		sb.append(jurysId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", companyName=");
		sb.append(companyName);
		sb.append(", category=");
		sb.append(category);
		sb.append(", juryImage=");
		sb.append(juryImage);
		sb.append(", shortDescription=");
		sb.append(shortDescription);
		sb.append(", longDescription=");
		sb.append(longDescription);
		sb.append(", number=");
		sb.append(number);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Jurys toEntityModel() {
		JurysImpl jurysImpl = new JurysImpl();

		jurysImpl.setJurysId(jurysId);

		if (name == null) {
			jurysImpl.setName(StringPool.BLANK);
		}
		else {
			jurysImpl.setName(name);
		}

		if (companyName == null) {
			jurysImpl.setCompanyName(StringPool.BLANK);
		}
		else {
			jurysImpl.setCompanyName(companyName);
		}

		if (category == null) {
			jurysImpl.setCategory(StringPool.BLANK);
		}
		else {
			jurysImpl.setCategory(category);
		}

		jurysImpl.setJuryImage(juryImage);

		if (shortDescription == null) {
			jurysImpl.setShortDescription(StringPool.BLANK);
		}
		else {
			jurysImpl.setShortDescription(shortDescription);
		}

		if (longDescription == null) {
			jurysImpl.setLongDescription(StringPool.BLANK);
		}
		else {
			jurysImpl.setLongDescription(longDescription);
		}

		jurysImpl.setNumber(number);
		jurysImpl.setGroupId(groupId);
		jurysImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			jurysImpl.setCreateDate(null);
		}
		else {
			jurysImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			jurysImpl.setModifiedDate(null);
		}
		else {
			jurysImpl.setModifiedDate(new Date(modifiedDate));
		}

		jurysImpl.resetOriginalValues();

		return jurysImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		jurysId = objectInput.readLong();
		name = objectInput.readUTF();
		companyName = objectInput.readUTF();
		category = objectInput.readUTF();
		juryImage = objectInput.readLong();
		shortDescription = objectInput.readUTF();
		longDescription = objectInput.readUTF();
		number = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(jurysId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (companyName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(companyName);
		}

		if (category == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(category);
		}

		objectOutput.writeLong(juryImage);

		if (shortDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shortDescription);
		}

		if (longDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(longDescription);
		}

		objectOutput.writeLong(number);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long jurysId;
	public String name;
	public String companyName;
	public String category;
	public Long juryImage;
	public String shortDescription;
	public String longDescription;
	public Long number;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
}