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

import com.jio.portlet.mentors.NoSuchMentorsException;
import com.jio.portlet.mentors.model.Mentors;
import com.jio.portlet.mentors.model.impl.MentorsImpl;
import com.jio.portlet.mentors.model.impl.MentorsModelImpl;
import com.jio.portlet.mentors.service.persistence.MentorsPersistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the mentors service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Reliance
 * @see MentorsPersistence
 * @see MentorsUtil
 * @generated
 */
public class MentorsPersistenceImpl extends BasePersistenceImpl<Mentors>
	implements MentorsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MentorsUtil} to access the mentors persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MentorsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MentorsModelImpl.ENTITY_CACHE_ENABLED,
			MentorsModelImpl.FINDER_CACHE_ENABLED, MentorsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MentorsModelImpl.ENTITY_CACHE_ENABLED,
			MentorsModelImpl.FINDER_CACHE_ENABLED, MentorsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MentorsModelImpl.ENTITY_CACHE_ENABLED,
			MentorsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public MentorsPersistenceImpl() {
		setModelClass(Mentors.class);
	}

	/**
	 * Caches the mentors in the entity cache if it is enabled.
	 *
	 * @param mentors the mentors
	 */
	@Override
	public void cacheResult(Mentors mentors) {
		EntityCacheUtil.putResult(MentorsModelImpl.ENTITY_CACHE_ENABLED,
			MentorsImpl.class, mentors.getPrimaryKey(), mentors);

		mentors.resetOriginalValues();
	}

	/**
	 * Caches the mentorses in the entity cache if it is enabled.
	 *
	 * @param mentorses the mentorses
	 */
	@Override
	public void cacheResult(List<Mentors> mentorses) {
		for (Mentors mentors : mentorses) {
			if (EntityCacheUtil.getResult(
						MentorsModelImpl.ENTITY_CACHE_ENABLED,
						MentorsImpl.class, mentors.getPrimaryKey()) == null) {
				cacheResult(mentors);
			}
			else {
				mentors.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all mentorses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MentorsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MentorsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the mentors.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Mentors mentors) {
		EntityCacheUtil.removeResult(MentorsModelImpl.ENTITY_CACHE_ENABLED,
			MentorsImpl.class, mentors.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Mentors> mentorses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Mentors mentors : mentorses) {
			EntityCacheUtil.removeResult(MentorsModelImpl.ENTITY_CACHE_ENABLED,
				MentorsImpl.class, mentors.getPrimaryKey());
		}
	}

	/**
	 * Creates a new mentors with the primary key. Does not add the mentors to the database.
	 *
	 * @param mentorsId the primary key for the new mentors
	 * @return the new mentors
	 */
	@Override
	public Mentors create(long mentorsId) {
		Mentors mentors = new MentorsImpl();

		mentors.setNew(true);
		mentors.setPrimaryKey(mentorsId);

		return mentors;
	}

	/**
	 * Removes the mentors with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mentorsId the primary key of the mentors
	 * @return the mentors that was removed
	 * @throws com.jio.portlet.mentors.NoSuchMentorsException if a mentors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Mentors remove(long mentorsId)
		throws NoSuchMentorsException, SystemException {
		return remove((Serializable)mentorsId);
	}

	/**
	 * Removes the mentors with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the mentors
	 * @return the mentors that was removed
	 * @throws com.jio.portlet.mentors.NoSuchMentorsException if a mentors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Mentors remove(Serializable primaryKey)
		throws NoSuchMentorsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Mentors mentors = (Mentors)session.get(MentorsImpl.class, primaryKey);

			if (mentors == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMentorsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(mentors);
		}
		catch (NoSuchMentorsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Mentors removeImpl(Mentors mentors) throws SystemException {
		mentors = toUnwrappedModel(mentors);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(mentors)) {
				mentors = (Mentors)session.get(MentorsImpl.class,
						mentors.getPrimaryKeyObj());
			}

			if (mentors != null) {
				session.delete(mentors);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (mentors != null) {
			clearCache(mentors);
		}

		return mentors;
	}

	@Override
	public Mentors updateImpl(com.jio.portlet.mentors.model.Mentors mentors)
		throws SystemException {
		mentors = toUnwrappedModel(mentors);

		boolean isNew = mentors.isNew();

		Session session = null;

		try {
			session = openSession();

			if (mentors.isNew()) {
				session.save(mentors);

				mentors.setNew(false);
			}
			else {
				session.merge(mentors);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(MentorsModelImpl.ENTITY_CACHE_ENABLED,
			MentorsImpl.class, mentors.getPrimaryKey(), mentors);

		return mentors;
	}

	protected Mentors toUnwrappedModel(Mentors mentors) {
		if (mentors instanceof MentorsImpl) {
			return mentors;
		}

		MentorsImpl mentorsImpl = new MentorsImpl();

		mentorsImpl.setNew(mentors.isNew());
		mentorsImpl.setPrimaryKey(mentors.getPrimaryKey());

		mentorsImpl.setMentorsId(mentors.getMentorsId());
		mentorsImpl.setName(mentors.getName());
		mentorsImpl.setCompanyName(mentors.getCompanyName());
		mentorsImpl.setCategory(mentors.getCategory());
		mentorsImpl.setMentorImage(mentors.getMentorImage());
		mentorsImpl.setShortDescription(mentors.getShortDescription());
		mentorsImpl.setLongDescription(mentors.getLongDescription());
		mentorsImpl.setNumber(mentors.getNumber());
		mentorsImpl.setGroupId(mentors.getGroupId());
		mentorsImpl.setCompanyId(mentors.getCompanyId());
		mentorsImpl.setCreateDate(mentors.getCreateDate());
		mentorsImpl.setModifiedDate(mentors.getModifiedDate());

		return mentorsImpl;
	}

	/**
	 * Returns the mentors with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the mentors
	 * @return the mentors
	 * @throws com.jio.portlet.mentors.NoSuchMentorsException if a mentors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Mentors findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMentorsException, SystemException {
		Mentors mentors = fetchByPrimaryKey(primaryKey);

		if (mentors == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMentorsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return mentors;
	}

	/**
	 * Returns the mentors with the primary key or throws a {@link com.jio.portlet.mentors.NoSuchMentorsException} if it could not be found.
	 *
	 * @param mentorsId the primary key of the mentors
	 * @return the mentors
	 * @throws com.jio.portlet.mentors.NoSuchMentorsException if a mentors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Mentors findByPrimaryKey(long mentorsId)
		throws NoSuchMentorsException, SystemException {
		return findByPrimaryKey((Serializable)mentorsId);
	}

	/**
	 * Returns the mentors with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the mentors
	 * @return the mentors, or <code>null</code> if a mentors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Mentors fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Mentors mentors = (Mentors)EntityCacheUtil.getResult(MentorsModelImpl.ENTITY_CACHE_ENABLED,
				MentorsImpl.class, primaryKey);

		if (mentors == _nullMentors) {
			return null;
		}

		if (mentors == null) {
			Session session = null;

			try {
				session = openSession();

				mentors = (Mentors)session.get(MentorsImpl.class, primaryKey);

				if (mentors != null) {
					cacheResult(mentors);
				}
				else {
					EntityCacheUtil.putResult(MentorsModelImpl.ENTITY_CACHE_ENABLED,
						MentorsImpl.class, primaryKey, _nullMentors);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MentorsModelImpl.ENTITY_CACHE_ENABLED,
					MentorsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return mentors;
	}

	/**
	 * Returns the mentors with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mentorsId the primary key of the mentors
	 * @return the mentors, or <code>null</code> if a mentors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Mentors fetchByPrimaryKey(long mentorsId) throws SystemException {
		return fetchByPrimaryKey((Serializable)mentorsId);
	}

	/**
	 * Returns all the mentorses.
	 *
	 * @return the mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Mentors> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Mentors> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Mentors> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Mentors> list = (List<Mentors>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MENTORS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MENTORS;

				if (pagination) {
					sql = sql.concat(MentorsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Mentors>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Mentors>(list);
				}
				else {
					list = (List<Mentors>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the mentorses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Mentors mentors : findAll()) {
			remove(mentors);
		}
	}

	/**
	 * Returns the number of mentorses.
	 *
	 * @return the number of mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MENTORS);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the mentors persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.jio.portlet.mentors.model.Mentors")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Mentors>> listenersList = new ArrayList<ModelListener<Mentors>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Mentors>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(MentorsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MENTORS = "SELECT mentors FROM Mentors mentors";
	private static final String _SQL_COUNT_MENTORS = "SELECT COUNT(mentors) FROM Mentors mentors";
	private static final String _ORDER_BY_ENTITY_ALIAS = "mentors.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Mentors exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MentorsPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"number"
			});
	private static Mentors _nullMentors = new MentorsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Mentors> toCacheModel() {
				return _nullMentorsCacheModel;
			}
		};

	private static CacheModel<Mentors> _nullMentorsCacheModel = new CacheModel<Mentors>() {
			@Override
			public Mentors toEntityModel() {
				return _nullMentors;
			}
		};
}