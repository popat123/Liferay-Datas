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

package com.jio.portlet.mentors.model.impl;

import com.jio.portlet.mentors.model.Mentors;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Mentors in entity cache.
 *
 * @author Reliance
 * @see Mentors
 * @generated
 */
public class MentorsCacheModel implements CacheModel<Mentors>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{mentorsId=");
		sb.append(mentorsId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", companyName=");
		sb.append(companyName);
		sb.append(", category=");
		sb.append(category);
		sb.append(", mentorImage=");
		sb.append(mentorImage);
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
	public Mentors toEntityModel() {
		MentorsImpl mentorsImpl = new MentorsImpl();

		mentorsImpl.setMentorsId(mentorsId);

		if (name == null) {
			mentorsImpl.setName(StringPool.BLANK);
		}
		else {
			mentorsImpl.setName(name);
		}

		if (companyName == null) {
			mentorsImpl.setCompanyName(StringPool.BLANK);
		}
		else {
			mentorsImpl.setCompanyName(companyName);
		}

		if (category == null) {
			mentorsImpl.setCategory(StringPool.BLANK);
		}
		else {
			mentorsImpl.setCategory(category);
		}

		mentorsImpl.setMentorImage(mentorImage);

		if (shortDescription == null) {
			mentorsImpl.setShortDescription(StringPool.BLANK);
		}
		else {
			mentorsImpl.setShortDescription(shortDescription);
		}

		if (longDescription == null) {
			mentorsImpl.setLongDescription(StringPool.BLANK);
		}
		else {
			mentorsImpl.setLongDescription(longDescription);
		}

		mentorsImpl.setNumber(number);
		mentorsImpl.setGroupId(groupId);
		mentorsImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			mentorsImpl.setCreateDate(null);
		}
		else {
			mentorsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			mentorsImpl.setModifiedDate(null);
		}
		else {
			mentorsImpl.setModifiedDate(new Date(modifiedDate));
		}

		mentorsImpl.resetOriginalValues();

		return mentorsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mentorsId = objectInput.readLong();
		name = objectInput.readUTF();
		companyName = objectInput.readUTF();
		category = objectInput.readUTF();
		mentorImage = objectInput.readLong();
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
		objectOutput.writeLong(mentorsId);

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

		objectOutput.writeLong(mentorImage);

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

	public long mentorsId;
	public String name;
	public String companyName;
	public String category;
	public Long mentorImage;
	public String shortDescription;
	public String longDescription;
	public Long number;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
}