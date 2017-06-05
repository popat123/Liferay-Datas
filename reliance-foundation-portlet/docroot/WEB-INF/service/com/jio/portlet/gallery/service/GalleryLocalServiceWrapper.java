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

package com.jio.portlet.gallery.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GalleryLocalService}.
 *
 * @author Reliance
 * @see GalleryLocalService
 * @generated
 */
public class GalleryLocalServiceWrapper implements GalleryLocalService,
	ServiceWrapper<GalleryLocalService> {
	public GalleryLocalServiceWrapper(GalleryLocalService galleryLocalService) {
		_galleryLocalService = galleryLocalService;
	}

	/**
	* Adds the gallery to the database. Also notifies the appropriate model listeners.
	*
	* @param gallery the gallery
	* @return the gallery that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.jio.portlet.gallery.model.Gallery addGallery(
		com.jio.portlet.gallery.model.Gallery gallery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _galleryLocalService.addGallery(gallery);
	}

	/**
	* Creates a new gallery with the primary key. Does not add the gallery to the database.
	*
	* @param galleryId the primary key for the new gallery
	* @return the new gallery
	*/
	@Override
	public com.jio.portlet.gallery.model.Gallery createGallery(long galleryId) {
		return _galleryLocalService.createGallery(galleryId);
	}

	/**
	* Deletes the gallery with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param galleryId the primary key of the gallery
	* @return the gallery that was removed
	* @throws PortalException if a gallery with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.jio.portlet.gallery.model.Gallery deleteGallery(long galleryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _galleryLocalService.deleteGallery(galleryId);
	}

	/**
	* Deletes the gallery from the database. Also notifies the appropriate model listeners.
	*
	* @param gallery the gallery
	* @return the gallery that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.jio.portlet.gallery.model.Gallery deleteGallery(
		com.jio.portlet.gallery.model.Gallery gallery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _galleryLocalService.deleteGallery(gallery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _galleryLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _galleryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.jio.portlet.gallery.model.impl.GalleryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _galleryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.jio.portlet.gallery.model.impl.GalleryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _galleryLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _galleryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _galleryLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.jio.portlet.gallery.model.Gallery fetchGallery(long galleryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _galleryLocalService.fetchGallery(galleryId);
	}

	/**
	* Returns the gallery with the primary key.
	*
	* @param galleryId the primary key of the gallery
	* @return the gallery
	* @throws PortalException if a gallery with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.jio.portlet.gallery.model.Gallery getGallery(long galleryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _galleryLocalService.getGallery(galleryId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _galleryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the galleries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.jio.portlet.gallery.model.impl.GalleryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of galleries
	* @param end the upper bound of the range of galleries (not inclusive)
	* @return the range of galleries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.jio.portlet.gallery.model.Gallery> getGalleries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _galleryLocalService.getGalleries(start, end);
	}

	/**
	* Returns the number of galleries.
	*
	* @return the number of galleries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getGalleriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _galleryLocalService.getGalleriesCount();
	}

	/**
	* Updates the gallery in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param gallery the gallery
	* @return the gallery that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.jio.portlet.gallery.model.Gallery updateGallery(
		com.jio.portlet.gallery.model.Gallery gallery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _galleryLocalService.updateGallery(gallery);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _galleryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_galleryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _galleryLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.jio.portlet.gallery.model.Gallery addGallery(
		java.lang.String type, java.lang.String thumbnailName,
		java.lang.String name, java.lang.String mainCategory,
		java.lang.String projectImagesPath, boolean isVideo, boolean isIMG,
		boolean youTubeLink, boolean videosImagPriority,
		boolean gallryImagPriority, java.lang.String demoLink,
		java.lang.String liveLink, long number, long videoImageId,
		long bigImageId, long thumbnailImageId) {
		return _galleryLocalService.addGallery(type, thumbnailName, name,
			mainCategory, projectImagesPath, isVideo, isIMG, youTubeLink,
			videosImagPriority, gallryImagPriority, demoLink, liveLink, number,
			videoImageId, bigImageId, thumbnailImageId);
	}

	@Override
	public java.util.List<com.jio.portlet.gallery.model.Gallery> getVideosPriority(
		boolean videosImagPriority)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return _galleryLocalService.getVideosPriority(videosImagPriority);
	}

	@Override
	public java.util.List<com.jio.portlet.gallery.model.Gallery> getImagePriority(
		boolean gallryImagPriority)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return _galleryLocalService.getImagePriority(gallryImagPriority);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GalleryLocalService getWrappedGalleryLocalService() {
		return _galleryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGalleryLocalService(
		GalleryLocalService galleryLocalService) {
		_galleryLocalService = galleryLocalService;
	}

	@Override
	public GalleryLocalService getWrappedService() {
		return _galleryLocalService;
	}

	@Override
	public void setWrappedService(GalleryLocalService galleryLocalService) {
		_galleryLocalService = galleryLocalService;
	}

	private GalleryLocalService _galleryLocalService;
}