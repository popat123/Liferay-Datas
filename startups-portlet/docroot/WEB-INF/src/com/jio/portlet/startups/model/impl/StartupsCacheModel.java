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

package com.jio.portlet.startups.model.impl;

import com.jio.portlet.startups.model.Startups;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Startups in entity cache.
 *
 * @author rajnikant.donga
 * @see Startups
 * @generated
 */
public class StartupsCacheModel implements CacheModel<Startups>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{startupsId=");
		sb.append(startupsId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", companyName=");
		sb.append(companyName);
		sb.append(", category=");
		sb.append(category);
		sb.append(", startupImage=");
		sb.append(startupImage);
		sb.append(", youtubeImages=");
		sb.append(youtubeImages);
		sb.append(", youtubeLink=");
		sb.append(youtubeLink);
		sb.append(", shortDescription=");
		sb.append(shortDescription);
		sb.append(", startupDesc=");
		sb.append(startupDesc);
		sb.append(", longDescription=");
		sb.append(longDescription);
		sb.append(", twitter=");
		sb.append(twitter);
		sb.append(", linkedIn=");
		sb.append(linkedIn);
		sb.append(", youTube=");
		sb.append(youTube);
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
	public Startups toEntityModel() {
		StartupsImpl startupsImpl = new StartupsImpl();

		startupsImpl.setStartupsId(startupsId);

		if (name == null) {
			startupsImpl.setName(StringPool.BLANK);
		}
		else {
			startupsImpl.setName(name);
		}

		if (companyName == null) {
			startupsImpl.setCompanyName(StringPool.BLANK);
		}
		else {
			startupsImpl.setCompanyName(companyName);
		}

		if (category == null) {
			startupsImpl.setCategory(StringPool.BLANK);
		}
		else {
			startupsImpl.setCategory(category);
		}

		startupsImpl.setStartupImage(startupImage);
		startupsImpl.setYoutubeImages(youtubeImages);

		if (youtubeLink == null) {
			startupsImpl.setYoutubeLink(StringPool.BLANK);
		}
		else {
			startupsImpl.setYoutubeLink(youtubeLink);
		}

		if (shortDescription == null) {
			startupsImpl.setShortDescription(StringPool.BLANK);
		}
		else {
			startupsImpl.setShortDescription(shortDescription);
		}

		if (startupDesc == null) {
			startupsImpl.setStartupDesc(StringPool.BLANK);
		}
		else {
			startupsImpl.setStartupDesc(startupDesc);
		}

		if (longDescription == null) {
			startupsImpl.setLongDescription(StringPool.BLANK);
		}
		else {
			startupsImpl.setLongDescription(longDescription);
		}

		if (twitter == null) {
			startupsImpl.setTwitter(StringPool.BLANK);
		}
		else {
			startupsImpl.setTwitter(twitter);
		}

		if (linkedIn == null) {
			startupsImpl.setLinkedIn(StringPool.BLANK);
		}
		else {
			startupsImpl.setLinkedIn(linkedIn);
		}

		if (youTube == null) {
			startupsImpl.setYouTube(StringPool.BLANK);
		}
		else {
			startupsImpl.setYouTube(youTube);
		}

		startupsImpl.setNumber(number);
		startupsImpl.setGroupId(groupId);
		startupsImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			startupsImpl.setCreateDate(null);
		}
		else {
			startupsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			startupsImpl.setModifiedDate(null);
		}
		else {
			startupsImpl.setModifiedDate(new Date(modifiedDate));
		}

		startupsImpl.resetOriginalValues();

		return startupsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		startupsId = objectInput.readLong();
		name = objectInput.readUTF();
		companyName = objectInput.readUTF();
		category = objectInput.readUTF();
		startupImage = objectInput.readLong();
		youtubeImages = objectInput.readLong();
		youtubeLink = objectInput.readUTF();
		shortDescription = objectInput.readUTF();
		startupDesc = objectInput.readUTF();
		longDescription = objectInput.readUTF();
		twitter = objectInput.readUTF();
		linkedIn = objectInput.readUTF();
		youTube = objectInput.readUTF();
		number = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(startupsId);

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

		objectOutput.writeLong(startupImage);
		objectOutput.writeLong(youtubeImages);

		if (youtubeLink == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(youtubeLink);
		}

		if (shortDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shortDescription);
		}

		if (startupDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(startupDesc);
		}

		if (longDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(longDescription);
		}

		if (twitter == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(twitter);
		}

		if (linkedIn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(linkedIn);
		}

		if (youTube == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(youTube);
		}

		objectOutput.writeLong(number);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long startupsId;
	public String name;
	public String companyName;
	public String category;
	public Long startupImage;
	public Long youtubeImages;
	public String youtubeLink;
	public String shortDescription;
	public String startupDesc;
	public String longDescription;
	public String twitter;
	public String linkedIn;
	public String youTube;
	public Long number;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
}