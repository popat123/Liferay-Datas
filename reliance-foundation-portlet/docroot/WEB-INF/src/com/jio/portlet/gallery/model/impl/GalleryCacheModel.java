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

package com.jio.portlet.gallery.model.impl;

import com.jio.portlet.gallery.model.Gallery;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Gallery in entity cache.
 *
 * @author Reliance
 * @see Gallery
 * @generated
 */
public class GalleryCacheModel implements CacheModel<Gallery>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{galleryId=");
		sb.append(galleryId);
		sb.append(", type=");
		sb.append(type);
		sb.append(", thumbnailName=");
		sb.append(thumbnailName);
		sb.append(", name=");
		sb.append(name);
		sb.append(", mainCategory=");
		sb.append(mainCategory);
		sb.append(", projectImagesPath=");
		sb.append(projectImagesPath);
		sb.append(", galleryImagesId=");
		sb.append(galleryImagesId);
		sb.append(", VideoImagesId=");
		sb.append(VideoImagesId);
		sb.append(", thumbnailImagesId=");
		sb.append(thumbnailImagesId);
		sb.append(", isVideo=");
		sb.append(isVideo);
		sb.append(", isIMG=");
		sb.append(isIMG);
		sb.append(", youTubeLink=");
		sb.append(youTubeLink);
		sb.append(", videosImagPriority=");
		sb.append(videosImagPriority);
		sb.append(", gallryImagPriority=");
		sb.append(gallryImagPriority);
		sb.append(", demoLink=");
		sb.append(demoLink);
		sb.append(", liveLink=");
		sb.append(liveLink);
		sb.append(", number=");
		sb.append(number);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Gallery toEntityModel() {
		GalleryImpl galleryImpl = new GalleryImpl();

		galleryImpl.setGalleryId(galleryId);

		if (type == null) {
			galleryImpl.setType(StringPool.BLANK);
		}
		else {
			galleryImpl.setType(type);
		}

		if (thumbnailName == null) {
			galleryImpl.setThumbnailName(StringPool.BLANK);
		}
		else {
			galleryImpl.setThumbnailName(thumbnailName);
		}

		if (name == null) {
			galleryImpl.setName(StringPool.BLANK);
		}
		else {
			galleryImpl.setName(name);
		}

		if (mainCategory == null) {
			galleryImpl.setMainCategory(StringPool.BLANK);
		}
		else {
			galleryImpl.setMainCategory(mainCategory);
		}

		if (projectImagesPath == null) {
			galleryImpl.setProjectImagesPath(StringPool.BLANK);
		}
		else {
			galleryImpl.setProjectImagesPath(projectImagesPath);
		}

		galleryImpl.setGalleryImagesId(galleryImagesId);
		galleryImpl.setVideoImagesId(VideoImagesId);
		galleryImpl.setThumbnailImagesId(thumbnailImagesId);
		galleryImpl.setIsVideo(isVideo);
		galleryImpl.setIsIMG(isIMG);
		galleryImpl.setYouTubeLink(youTubeLink);
		galleryImpl.setVideosImagPriority(videosImagPriority);
		galleryImpl.setGallryImagPriority(gallryImagPriority);

		if (demoLink == null) {
			galleryImpl.setDemoLink(StringPool.BLANK);
		}
		else {
			galleryImpl.setDemoLink(demoLink);
		}

		if (liveLink == null) {
			galleryImpl.setLiveLink(StringPool.BLANK);
		}
		else {
			galleryImpl.setLiveLink(liveLink);
		}

		galleryImpl.setNumber(number);

		if (createDate == Long.MIN_VALUE) {
			galleryImpl.setCreateDate(null);
		}
		else {
			galleryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			galleryImpl.setModifiedDate(null);
		}
		else {
			galleryImpl.setModifiedDate(new Date(modifiedDate));
		}

		galleryImpl.resetOriginalValues();

		return galleryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		galleryId = objectInput.readLong();
		type = objectInput.readUTF();
		thumbnailName = objectInput.readUTF();
		name = objectInput.readUTF();
		mainCategory = objectInput.readUTF();
		projectImagesPath = objectInput.readUTF();
		galleryImagesId = objectInput.readLong();
		VideoImagesId = objectInput.readLong();
		thumbnailImagesId = objectInput.readLong();
		isVideo = objectInput.readBoolean();
		isIMG = objectInput.readBoolean();
		youTubeLink = objectInput.readBoolean();
		videosImagPriority = objectInput.readBoolean();
		gallryImagPriority = objectInput.readBoolean();
		demoLink = objectInput.readUTF();
		liveLink = objectInput.readUTF();
		number = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(galleryId);

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (thumbnailName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(thumbnailName);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (mainCategory == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mainCategory);
		}

		if (projectImagesPath == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(projectImagesPath);
		}

		objectOutput.writeLong(galleryImagesId);
		objectOutput.writeLong(VideoImagesId);
		objectOutput.writeLong(thumbnailImagesId);
		objectOutput.writeBoolean(isVideo);
		objectOutput.writeBoolean(isIMG);
		objectOutput.writeBoolean(youTubeLink);
		objectOutput.writeBoolean(videosImagPriority);
		objectOutput.writeBoolean(gallryImagPriority);

		if (demoLink == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(demoLink);
		}

		if (liveLink == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(liveLink);
		}

		objectOutput.writeLong(number);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long galleryId;
	public String type;
	public String thumbnailName;
	public String name;
	public String mainCategory;
	public String projectImagesPath;
	public Long galleryImagesId;
	public Long VideoImagesId;
	public Long thumbnailImagesId;
	public boolean isVideo;
	public boolean isIMG;
	public boolean youTubeLink;
	public boolean videosImagPriority;
	public boolean gallryImagPriority;
	public String demoLink;
	public String liveLink;
	public long number;
	public long createDate;
	public long modifiedDate;
}