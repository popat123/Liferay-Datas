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

package com.jio.portlet.jurys.service.persistence;

import com.jio.portlet.jurys.model.Jurys;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the jurys service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Reliance
 * @see JurysPersistenceImpl
 * @see JurysUtil
 * @generated
 */
public interface JurysPersistence extends BasePersistence<Jurys> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JurysUtil} to access the jurys persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the jurys in the entity cache if it is enabled.
	*
	* @param jurys the jurys
	*/
	public void cacheResult(com.jio.portlet.jurys.model.Jurys jurys);

	/**
	* Caches the juryses in the entity cache if it is enabled.
	*
	* @param juryses the juryses
	*/
	public void cacheResult(
		java.util.List<com.jio.portlet.jurys.model.Jurys> juryses);

	/**
	* Creates a new jurys with the primary key. Does not add the jurys to the database.
	*
	* @param jurysId the primary key for the new jurys
	* @return the new jurys
	*/
	public com.jio.portlet.jurys.model.Jurys create(long jurysId);

	/**
	* Removes the jurys with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jurysId the primary key of the jurys
	* @return the jurys that was removed
	* @throws com.jio.portlet.jurys.NoSuchJurysException if a jurys with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jio.portlet.jurys.model.Jurys remove(long jurysId)
		throws com.jio.portlet.jurys.NoSuchJurysException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.jio.portlet.jurys.model.Jurys updateImpl(
		com.jio.portlet.jurys.model.Jurys jurys)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the jurys with the primary key or throws a {@link com.jio.portlet.jurys.NoSuchJurysException} if it could not be found.
	*
	* @param jurysId the primary key of the jurys
	* @return the jurys
	* @throws com.jio.portlet.jurys.NoSuchJurysException if a jurys with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jio.portlet.jurys.model.Jurys findByPrimaryKey(long jurysId)
		throws com.jio.portlet.jurys.NoSuchJurysException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the jurys with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param jurysId the primary key of the jurys
	* @return the jurys, or <code>null</code> if a jurys with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jio.portlet.jurys.model.Jurys fetchByPrimaryKey(long jurysId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the juryses.
	*
	* @return the juryses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jio.portlet.jurys.model.Jurys> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the juryses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.jio.portlet.jurys.model.impl.JurysModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of juryses
	* @param end the upper bound of the range of juryses (not inclusive)
	* @return the range of juryses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jio.portlet.jurys.model.Jurys> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the juryses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.jio.portlet.jurys.model.impl.JurysModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of juryses
	* @param end the upper bound of the range of juryses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of juryses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jio.portlet.jurys.model.Jurys> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the juryses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of juryses.
	*
	* @return the number of juryses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}