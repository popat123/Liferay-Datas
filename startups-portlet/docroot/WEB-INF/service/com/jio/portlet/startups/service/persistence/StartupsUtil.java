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

package com.jio.portlet.startups.service.persistence;

import com.jio.portlet.startups.model.Startups;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the startups service. This utility wraps {@link StartupsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rajnikant.donga
 * @see StartupsPersistence
 * @see StartupsPersistenceImpl
 * @generated
 */
public class StartupsUtil {
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
	public static void clearCache(Startups startups) {
		getPersistence().clearCache(startups);
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
	public static List<Startups> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Startups> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Startups> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Startups update(Startups startups) throws SystemException {
		return getPersistence().update(startups);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Startups update(Startups startups,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(startups, serviceContext);
	}

	/**
	* Caches the startups in the entity cache if it is enabled.
	*
	* @param startups the startups
	*/
	public static void cacheResult(
		com.jio.portlet.startups.model.Startups startups) {
		getPersistence().cacheResult(startups);
	}

	/**
	* Caches the startupses in the entity cache if it is enabled.
	*
	* @param startupses the startupses
	*/
	public static void cacheResult(
		java.util.List<com.jio.portlet.startups.model.Startups> startupses) {
		getPersistence().cacheResult(startupses);
	}

	/**
	* Creates a new startups with the primary key. Does not add the startups to the database.
	*
	* @param startupsId the primary key for the new startups
	* @return the new startups
	*/
	public static com.jio.portlet.startups.model.Startups create(
		long startupsId) {
		return getPersistence().create(startupsId);
	}

	/**
	* Removes the startups with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param startupsId the primary key of the startups
	* @return the startups that was removed
	* @throws com.jio.portlet.startups.NoSuchStartupsException if a startups with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jio.portlet.startups.model.Startups remove(
		long startupsId)
		throws com.jio.portlet.startups.NoSuchStartupsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(startupsId);
	}

	public static com.jio.portlet.startups.model.Startups updateImpl(
		com.jio.portlet.startups.model.Startups startups)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(startups);
	}

	/**
	* Returns the startups with the primary key or throws a {@link com.jio.portlet.startups.NoSuchStartupsException} if it could not be found.
	*
	* @param startupsId the primary key of the startups
	* @return the startups
	* @throws com.jio.portlet.startups.NoSuchStartupsException if a startups with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jio.portlet.startups.model.Startups findByPrimaryKey(
		long startupsId)
		throws com.jio.portlet.startups.NoSuchStartupsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(startupsId);
	}

	/**
	* Returns the startups with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param startupsId the primary key of the startups
	* @return the startups, or <code>null</code> if a startups with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jio.portlet.startups.model.Startups fetchByPrimaryKey(
		long startupsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(startupsId);
	}

	/**
	* Returns all the startupses.
	*
	* @return the startupses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jio.portlet.startups.model.Startups> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the startupses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.jio.portlet.startups.model.impl.StartupsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of startupses
	* @param end the upper bound of the range of startupses (not inclusive)
	* @return the range of startupses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jio.portlet.startups.model.Startups> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the startupses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.jio.portlet.startups.model.impl.StartupsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of startupses
	* @param end the upper bound of the range of startupses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of startupses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jio.portlet.startups.model.Startups> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the startupses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of startupses.
	*
	* @return the number of startupses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StartupsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StartupsPersistence)PortletBeanLocatorUtil.locate(com.jio.portlet.startups.service.ClpSerializer.getServletContextName(),
					StartupsPersistence.class.getName());

			ReferenceRegistry.registerReference(StartupsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(StartupsPersistence persistence) {
	}

	private static StartupsPersistence _persistence;
}