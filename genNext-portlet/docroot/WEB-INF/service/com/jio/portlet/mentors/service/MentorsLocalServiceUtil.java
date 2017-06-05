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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Mentors. This utility wraps
 * {@link com.jio.portlet.mentors.service.impl.MentorsLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Reliance
 * @see MentorsLocalService
 * @see com.jio.portlet.mentors.service.base.MentorsLocalServiceBaseImpl
 * @see com.jio.portlet.mentors.service.impl.MentorsLocalServiceImpl
 * @generated
 */
public class MentorsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.jio.portlet.mentors.service.impl.MentorsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the mentors to the database. Also notifies the appropriate model listeners.
	*
	* @param mentors the mentors
	* @return the mentors that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.jio.portlet.mentors.model.Mentors addMentors(
		com.jio.portlet.mentors.model.Mentors mentors)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addMentors(mentors);
	}

	/**
	* Creates a new mentors with the primary key. Does not add the mentors to the database.
	*
	* @param mentorsId the primary key for the new mentors
	* @return the new mentors
	*/
	public static com.jio.portlet.mentors.model.Mentors createMentors(
		long mentorsId) {
		return getService().createMentors(mentorsId);
	}

	/**
	* Deletes the mentors with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param mentorsId the primary key of the mentors
	* @return the mentors that was removed
	* @throws PortalException if a mentors with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jio.portlet.mentors.model.Mentors deleteMentors(
		long mentorsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMentors(mentorsId);
	}

	/**
	* Deletes the mentors from the database. Also notifies the appropriate model listeners.
	*
	* @param mentors the mentors
	* @return the mentors that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.jio.portlet.mentors.model.Mentors deleteMentors(
		com.jio.portlet.mentors.model.Mentors mentors)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMentors(mentors);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.jio.portlet.mentors.model.Mentors fetchMentors(
		long mentorsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchMentors(mentorsId);
	}

	/**
	* Returns the mentors with the primary key.
	*
	* @param mentorsId the primary key of the mentors
	* @return the mentors
	* @throws PortalException if a mentors with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jio.portlet.mentors.model.Mentors getMentors(
		long mentorsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getMentors(mentorsId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.jio.portlet.mentors.model.Mentors> getMentorses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMentorses(start, end);
	}

	/**
	* Returns the number of mentorses.
	*
	* @return the number of mentorses
	* @throws SystemException if a system exception occurred
	*/
	public static int getMentorsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMentorsesCount();
	}

	/**
	* Updates the mentors in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param mentors the mentors
	* @return the mentors that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.jio.portlet.mentors.model.Mentors updateMentors(
		com.jio.portlet.mentors.model.Mentors mentors)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMentors(mentors);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearService() {
		_service = null;
	}

	public static MentorsLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					MentorsLocalService.class.getName());

			if (invokableLocalService instanceof MentorsLocalService) {
				_service = (MentorsLocalService)invokableLocalService;
			}
			else {
				_service = new MentorsLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(MentorsLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(MentorsLocalService service) {
	}

	private static MentorsLocalService _service;
}