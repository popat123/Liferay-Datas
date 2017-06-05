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

package com.jio.portlet.mentors.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MentorsLocalService}.
 *
 * @author Reliance
 * @see MentorsLocalService
 * @generated
 */
public class MentorsLocalServiceWrapper implements MentorsLocalService,
	ServiceWrapper<MentorsLocalService> {
	public MentorsLocalServiceWrapper(MentorsLocalService mentorsLocalService) {
		_mentorsLocalService = mentorsLocalService;
	}

	/**
	* Adds the mentors to the database. Also notifies the appropriate model listeners.
	*
	* @param mentors the mentors
	* @return the mentors that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.jio.portlet.mentors.model.Mentors addMentors(
		com.jio.portlet.mentors.model.Mentors mentors)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mentorsLocalService.addMentors(mentors);
	}

	/**
	* Creates a new mentors with the primary key. Does not add the mentors to the database.
	*
	* @param mentorsId the primary key for the new mentors
	* @return the new mentors
	*/
	@Override
	public com.jio.portlet.mentors.model.Mentors createMentors(long mentorsId) {
		return _mentorsLocalService.createMentors(mentorsId);
	}

	/**
	* Deletes the mentors with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mentorsId the primary key of the mentors
	* @return the mentors that was removed
	* @throws PortalException if a mentors with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.jio.portlet.mentors.model.Mentors deleteMentors(long mentorsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mentorsLocalService.deleteMentors(mentorsId);
	}

	/**
	* Deletes the mentors from the database. Also notifies the appropriate model listeners.
	*
	* @param mentors the mentors
	* @return the mentors that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.jio.portlet.mentors.model.Mentors deleteMentors(
		com.jio.portlet.mentors.model.Mentors mentors)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mentorsLocalService.deleteMentors(mentors);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _mentorsLocalService.dynamicQuery();
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
		return _mentorsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.jio.portlet.mentors.model.impl.MentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _mentorsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.jio.portlet.mentors.model.impl.MentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _mentorsLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _mentorsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _mentorsLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.jio.portlet.mentors.model.Mentors fetchMentors(long mentorsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mentorsLocalService.fetchMentors(mentorsId);
	}

	/**
	* Returns the mentors with the primary key.
	*
	* @param mentorsId the primary key of the mentors
	* @return the mentors
	* @throws PortalException if a mentors with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.jio.portlet.mentors.model.Mentors getMentors(long mentorsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mentorsLocalService.getMentors(mentorsId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mentorsLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.jio.portlet.mentors.model.Mentors> getMentorses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mentorsLocalService.getMentorses(start, end);
	}

	/**
	* Returns the number of mentorses.
	*
	* @return the number of mentorses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMentorsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mentorsLocalService.getMentorsesCount();
	}

	/**
	* Updates the mentors in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param mentors the mentors
	* @return the mentors that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.jio.portlet.mentors.model.Mentors updateMentors(
		com.jio.portlet.mentors.model.Mentors mentors)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mentorsLocalService.updateMentors(mentors);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _mentorsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_mentorsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _mentorsLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MentorsLocalService getWrappedMentorsLocalService() {
		return _mentorsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMentorsLocalService(
		MentorsLocalService mentorsLocalService) {
		_mentorsLocalService = mentorsLocalService;
	}

	@Override
	public MentorsLocalService getWrappedService() {
		return _mentorsLocalService;
	}

	@Override
	public void setWrappedService(MentorsLocalService mentorsLocalService) {
		_mentorsLocalService = mentorsLocalService;
	}

	private MentorsLocalService _mentorsLocalService;
}