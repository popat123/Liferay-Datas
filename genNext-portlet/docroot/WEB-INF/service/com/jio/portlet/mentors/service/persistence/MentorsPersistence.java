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

package com.jio.portlet.mentors.service.persistence;

import com.jio.portlet.mentors.model.Mentors;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the mentors service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Reliance
 * @see MentorsPersistenceImpl
 * @see MentorsUtil
 * @generated
 */
public interface MentorsPersistence extends BasePersistence<Mentors> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MentorsUtil} to access the mentors persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the mentors in the entity cache if it is enabled.
	*
	* @param mentors the mentors
	*/
	public void cacheResult(com.jio.portlet.mentors.model.Mentors mentors);

	/**
	* Caches the mentorses in the entity cache if it is enabled.
	*
	* @param mentorses the mentorses
	*/
	public void cacheResult(
		java.util.List<com.jio.portlet.mentors.model.Mentors> mentorses);

	/**
	* Creates a new mentors with the primary key. Does not add the mentors to the database.
	*
	* @param mentorsId the primary key for the new mentors
	* @return the new mentors
	*/
	public com.jio.portlet.mentors.model.Mentors create(long mentorsId);

	/**
	* Removes the mentors with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mentorsId the primary key of the mentors
	* @return the mentors that was removed
	* @throws com.jio.portlet.mentors.NoSuchMentorsException if a mentors with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jio.portlet.mentors.model.Mentors remove(long mentorsId)
		throws com.jio.portlet.mentors.NoSuchMentorsException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.jio.portlet.mentors.model.Mentors updateImpl(
		com.jio.portlet.mentors.model.Mentors mentors)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the mentors with the primary key or throws a {@link com.jio.portlet.mentors.NoSuchMentorsException} if it could not be found.
	*
	* @param mentorsId the primary key of the mentors
	* @return the mentors
	* @throws com.jio.portlet.mentors.NoSuchMentorsException if a mentors with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jio.portlet.mentors.model.Mentors findByPrimaryKey(
		long mentorsId)
		throws com.jio.portlet.mentors.NoSuchMentorsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the mentors with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param mentorsId the primary key of the mentors
	* @return the mentors, or <code>null</code> if a mentors with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jio.portlet.mentors.model.Mentors fetchByPrimaryKey(
		long mentorsId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the mentorses.
	*
	* @return the mentorses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jio.portlet.mentors.model.Mentors> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the mentorses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.jio.portlet.mentors.model.impl.MentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of mentorses
	* @param end the upper bound of the range of mentorses (not inclusive)
	* @return the range of mentorses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jio.portlet.mentors.model.Mentors> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the mentorses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.jio.portlet.mentors.model.impl.MentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of mentorses
	* @param end the upper bound of the range of mentorses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of mentorses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jio.portlet.mentors.model.Mentors> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the mentorses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of mentorses.
	*
	* @return the number of mentorses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}