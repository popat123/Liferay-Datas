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

package com.jio.portlet.gallery.service.persistence;

import com.jio.portlet.gallery.model.Gallery;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the gallery service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Reliance
 * @see GalleryPersistenceImpl
 * @see GalleryUtil
 * @generated
 */
public interface GalleryPersistence extends BasePersistence<Gallery> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GalleryUtil} to access the gallery persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the galleries where videosImagPriority = &#63;.
	*
	* @param videosImagPriority the videos imag priority
	* @return the matching galleries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jio.portlet.gallery.model.Gallery> findByVideoPriority(
		boolean videosImagPriority)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the galleries where videosImagPriority = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.jio.portlet.gallery.model.impl.GalleryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videosImagPriority the videos imag priority
	* @param start the lower bound of the range of galleries
	* @param end the upper bound of the range of galleries (not inclusive)
	* @return the range of matching galleries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jio.portlet.gallery.model.Gallery> findByVideoPriority(
		boolean videosImagPriority, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the galleries where videosImagPriority = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.jio.portlet.gallery.model.impl.GalleryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param videosImagPriority the videos imag priority
	* @param start the lower bound of the range of galleries
	* @param end the upper bound of the range of galleries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching galleries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jio.portlet.gallery.model.Gallery> findByVideoPriority(
		boolean videosImagPriority, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first gallery in the ordered set where videosImagPriority = &#63;.
	*
	* @param videosImagPriority the videos imag priority
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching gallery
	* @throws com.jio.portlet.gallery.NoSuchGalleryException if a matching gallery could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jio.portlet.gallery.model.Gallery findByVideoPriority_First(
		boolean videosImagPriority,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jio.portlet.gallery.NoSuchGalleryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first gallery in the ordered set where videosImagPriority = &#63;.
	*
	* @param videosImagPriority the videos imag priority
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching gallery, or <code>null</code> if a matching gallery could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jio.portlet.gallery.model.Gallery fetchByVideoPriority_First(
		boolean videosImagPriority,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last gallery in the ordered set where videosImagPriority = &#63;.
	*
	* @param videosImagPriority the videos imag priority
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching gallery
	* @throws com.jio.portlet.gallery.NoSuchGalleryException if a matching gallery could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jio.portlet.gallery.model.Gallery findByVideoPriority_Last(
		boolean videosImagPriority,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jio.portlet.gallery.NoSuchGalleryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last gallery in the ordered set where videosImagPriority = &#63;.
	*
	* @param videosImagPriority the videos imag priority
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching gallery, or <code>null</code> if a matching gallery could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jio.portlet.gallery.model.Gallery fetchByVideoPriority_Last(
		boolean videosImagPriority,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the galleries before and after the current gallery in the ordered set where videosImagPriority = &#63;.
	*
	* @param galleryId the primary key of the current gallery
	* @param videosImagPriority the videos imag priority
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next gallery
	* @throws com.jio.portlet.gallery.NoSuchGalleryException if a gallery with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jio.portlet.gallery.model.Gallery[] findByVideoPriority_PrevAndNext(
		long galleryId, boolean videosImagPriority,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jio.portlet.gallery.NoSuchGalleryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the galleries where videosImagPriority = &#63; from the database.
	*
	* @param videosImagPriority the videos imag priority
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVideoPriority(boolean videosImagPriority)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of galleries where videosImagPriority = &#63;.
	*
	* @param videosImagPriority the videos imag priority
	* @return the number of matching galleries
	* @throws SystemException if a system exception occurred
	*/
	public int countByVideoPriority(boolean videosImagPriority)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the galleries where gallryImagPriority = &#63;.
	*
	* @param gallryImagPriority the gallry imag priority
	* @return the matching galleries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jio.portlet.gallery.model.Gallery> findByImagePriority(
		boolean gallryImagPriority)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the galleries where gallryImagPriority = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.jio.portlet.gallery.model.impl.GalleryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param gallryImagPriority the gallry imag priority
	* @param start the lower bound of the range of galleries
	* @param end the upper bound of the range of galleries (not inclusive)
	* @return the range of matching galleries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jio.portlet.gallery.model.Gallery> findByImagePriority(
		boolean gallryImagPriority, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the galleries where gallryImagPriority = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.jio.portlet.gallery.model.impl.GalleryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param gallryImagPriority the gallry imag priority
	* @param start the lower bound of the range of galleries
	* @param end the upper bound of the range of galleries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching galleries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jio.portlet.gallery.model.Gallery> findByImagePriority(
		boolean gallryImagPriority, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first gallery in the ordered set where gallryImagPriority = &#63;.
	*
	* @param gallryImagPriority the gallry imag priority
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching gallery
	* @throws com.jio.portlet.gallery.NoSuchGalleryException if a matching gallery could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jio.portlet.gallery.model.Gallery findByImagePriority_First(
		boolean gallryImagPriority,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jio.portlet.gallery.NoSuchGalleryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first gallery in the ordered set where gallryImagPriority = &#63;.
	*
	* @param gallryImagPriority the gallry imag priority
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching gallery, or <code>null</code> if a matching gallery could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jio.portlet.gallery.model.Gallery fetchByImagePriority_First(
		boolean gallryImagPriority,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last gallery in the ordered set where gallryImagPriority = &#63;.
	*
	* @param gallryImagPriority the gallry imag priority
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching gallery
	* @throws com.jio.portlet.gallery.NoSuchGalleryException if a matching gallery could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jio.portlet.gallery.model.Gallery findByImagePriority_Last(
		boolean gallryImagPriority,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jio.portlet.gallery.NoSuchGalleryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last gallery in the ordered set where gallryImagPriority = &#63;.
	*
	* @param gallryImagPriority the gallry imag priority
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching gallery, or <code>null</code> if a matching gallery could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jio.portlet.gallery.model.Gallery fetchByImagePriority_Last(
		boolean gallryImagPriority,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the galleries before and after the current gallery in the ordered set where gallryImagPriority = &#63;.
	*
	* @param galleryId the primary key of the current gallery
	* @param gallryImagPriority the gallry imag priority
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next gallery
	* @throws com.jio.portlet.gallery.NoSuchGalleryException if a gallery with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jio.portlet.gallery.model.Gallery[] findByImagePriority_PrevAndNext(
		long galleryId, boolean gallryImagPriority,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jio.portlet.gallery.NoSuchGalleryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the galleries where gallryImagPriority = &#63; from the database.
	*
	* @param gallryImagPriority the gallry imag priority
	* @throws SystemException if a system exception occurred
	*/
	public void removeByImagePriority(boolean gallryImagPriority)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of galleries where gallryImagPriority = &#63;.
	*
	* @param gallryImagPriority the gallry imag priority
	* @return the number of matching galleries
	* @throws SystemException if a system exception occurred
	*/
	public int countByImagePriority(boolean gallryImagPriority)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the gallery in the entity cache if it is enabled.
	*
	* @param gallery the gallery
	*/
	public void cacheResult(com.jio.portlet.gallery.model.Gallery gallery);

	/**
	* Caches the galleries in the entity cache if it is enabled.
	*
	* @param galleries the galleries
	*/
	public void cacheResult(
		java.util.List<com.jio.portlet.gallery.model.Gallery> galleries);

	/**
	* Creates a new gallery with the primary key. Does not add the gallery to the database.
	*
	* @param galleryId the primary key for the new gallery
	* @return the new gallery
	*/
	public com.jio.portlet.gallery.model.Gallery create(long galleryId);

	/**
	* Removes the gallery with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param galleryId the primary key of the gallery
	* @return the gallery that was removed
	* @throws com.jio.portlet.gallery.NoSuchGalleryException if a gallery with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jio.portlet.gallery.model.Gallery remove(long galleryId)
		throws com.jio.portlet.gallery.NoSuchGalleryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.jio.portlet.gallery.model.Gallery updateImpl(
		com.jio.portlet.gallery.model.Gallery gallery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the gallery with the primary key or throws a {@link com.jio.portlet.gallery.NoSuchGalleryException} if it could not be found.
	*
	* @param galleryId the primary key of the gallery
	* @return the gallery
	* @throws com.jio.portlet.gallery.NoSuchGalleryException if a gallery with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jio.portlet.gallery.model.Gallery findByPrimaryKey(
		long galleryId)
		throws com.jio.portlet.gallery.NoSuchGalleryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the gallery with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param galleryId the primary key of the gallery
	* @return the gallery, or <code>null</code> if a gallery with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jio.portlet.gallery.model.Gallery fetchByPrimaryKey(
		long galleryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the galleries.
	*
	* @return the galleries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jio.portlet.gallery.model.Gallery> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.jio.portlet.gallery.model.Gallery> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the galleries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.jio.portlet.gallery.model.impl.GalleryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of galleries
	* @param end the upper bound of the range of galleries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of galleries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jio.portlet.gallery.model.Gallery> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the galleries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of galleries.
	*
	* @return the number of galleries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}