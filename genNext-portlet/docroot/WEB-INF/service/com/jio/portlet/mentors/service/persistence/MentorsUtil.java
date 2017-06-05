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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the mentors service. This utility wraps {@link MentorsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Reliance
 * @see MentorsPersistence
 * @see MentorsPersistenceImpl
 * @generated
 */
public class MentorsUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Mentors mentors) {
		getPersistence().clearCache(mentors);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Mentors> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Mentors> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Mentors> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Mentors update(Mentors mentors) throws SystemException {
		return getPersistence().update(mentors);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Mentors update(Mentors mentors, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(mentors, serviceContext);
	}

	/**
	* Caches the mentors in the entity cache if it is enabled.
	*
	* @param mentors the mentors
	*/
	public static void cacheResult(
		com.jio.portlet.mentors.model.Mentors mentors) {
		getPersistence().cacheResult(mentors);
	}

	/**
	* Caches the mentorses in the entity cache if it is enabled.
	*
	* @param mentorses the mentorses
	*/
	public static void cacheResult(
		java.util.List<com.jio.portlet.mentors.model.Mentors> mentorses) {
		getPersistence().cacheResult(mentorses);
	}

	/**
	* Creates a new mentors with the primary key. Does not add the mentors to the database.
	*
	* @param mentorsId the primary key for the new mentors
	* @return the new mentors
	*/
	public static com.jio.portlet.mentors.model.Mentors create(long mentorsId) {
		return getPersistence().create(mentorsId);
	}

	/**
	* Removes the mentors with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mentorsId the primary key of the mentors
	* @return the mentors that was removed
	* @throws com.jio.portlet.mentors.NoSuchMentorsException if a mentors with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jio.portlet.mentors.model.Mentors remove(long mentorsId)
		throws com.jio.portlet.mentors.NoSuchMentorsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(mentorsId);
	}

	public static com.jio.portlet.mentors.model.Mentors updateImpl(
		com.jio.portlet.mentors.model.Mentors mentors)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(mentors);
	}

	/**
	* Returns the mentors with the primary key or throws a {@link com.jio.portlet.mentors.NoSuchMentorsException} if it could not be found.
	*
	* @param mentorsId the primary key of the mentors
	* @return the mentors
	* @throws com.jio.portlet.mentors.NoSuchMentorsException if a mentors with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jio.portlet.mentors.model.Mentors findByPrimaryKey(
		long mentorsId)
		throws com.jio.portlet.mentors.NoSuchMentorsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(mentorsId);
	}

	/**
	* Returns the mentors with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param mentorsId the primary key of the mentors
	* @return the mentors, or <code>null</code> if a mentors with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jio.portlet.mentors.model.Mentors fetchByPrimaryKey(
		long mentorsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(mentorsId);
	}

	/**
	* Returns all the mentorses.
	*
	* @return the mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jio.portlet.mentors.model.Mentors> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.jio.portlet.mentors.model.Mentors> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.jio.portlet.mentors.model.Mentors> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the mentorses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of mentorses.
	*
	* @return the number of mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MentorsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MentorsPersistence)PortletBeanLocatorUtil.locate(com.jio.portlet.mentors.service.ClpSerializer.getServletContextName(),
					MentorsPersistence.class.getName());

			ReferenceRegistry.registerReference(MentorsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(MentorsPersistence persistence) {
	}

	private static MentorsPersistence _persistence;
}