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

import com.jio.portlet.startups.NoSuchStartupsException;
import com.jio.portlet.startups.model.Startups;
import com.jio.portlet.startups.model.impl.StartupsImpl;
import com.jio.portlet.startups.model.impl.StartupsModelImpl;
import com.jio.portlet.startups.service.persistence.StartupsPersistence;

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
 * The persistence implementation for the startups service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rajnikant.donga
 * @see StartupsPersistence
 * @see StartupsUtil
 * @generated
 */
public class StartupsPersistenceImpl extends BasePersistenceImpl<Startups>
	implements StartupsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StartupsUtil} to access the startups persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StartupsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StartupsModelImpl.ENTITY_CACHE_ENABLED,
			StartupsModelImpl.FINDER_CACHE_ENABLED, StartupsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StartupsModelImpl.ENTITY_CACHE_ENABLED,
			StartupsModelImpl.FINDER_CACHE_ENABLED, StartupsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StartupsModelImpl.ENTITY_CACHE_ENABLED,
			StartupsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public StartupsPersistenceImpl() {
		setModelClass(Startups.class);
	}

	/**
	 * Caches the startups in the entity cache if it is enabled.
	 *
	 * @param startups the startups
	 */
	@Override
	public void cacheResult(Startups startups) {
		EntityCacheUtil.putResult(StartupsModelImpl.ENTITY_CACHE_ENABLED,
			StartupsImpl.class, startups.getPrimaryKey(), startups);

		startups.resetOriginalValues();
	}

	/**
	 * Caches the startupses in the entity cache if it is enabled.
	 *
	 * @param startupses the startupses
	 */
	@Override
	public void cacheResult(List<Startups> startupses) {
		for (Startups startups : startupses) {
			if (EntityCacheUtil.getResult(
						StartupsModelImpl.ENTITY_CACHE_ENABLED,
						StartupsImpl.class, startups.getPrimaryKey()) == null) {
				cacheResult(startups);
			}
			else {
				startups.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all startupses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StartupsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StartupsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the startups.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Startups startups) {
		EntityCacheUtil.removeResult(StartupsModelImpl.ENTITY_CACHE_ENABLED,
			StartupsImpl.class, startups.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Startups> startupses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Startups startups : startupses) {
			EntityCacheUtil.removeResult(StartupsModelImpl.ENTITY_CACHE_ENABLED,
				StartupsImpl.class, startups.getPrimaryKey());
		}
	}

	/**
	 * Creates a new startups with the primary key. Does not add the startups to the database.
	 *
	 * @param startupsId the primary key for the new startups
	 * @return the new startups
	 */
	@Override
	public Startups create(long startupsId) {
		Startups startups = new StartupsImpl();

		startups.setNew(true);
		startups.setPrimaryKey(startupsId);

		return startups;
	}

	/**
	 * Removes the startups with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param startupsId the primary key of the startups
	 * @return the startups that was removed
	 * @throws com.jio.portlet.startups.NoSuchStartupsException if a startups with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Startups remove(long startupsId)
		throws NoSuchStartupsException, SystemException {
		return remove((Serializable)startupsId);
	}

	/**
	 * Removes the startups with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the startups
	 * @return the startups that was removed
	 * @throws com.jio.portlet.startups.NoSuchStartupsException if a startups with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Startups remove(Serializable primaryKey)
		throws NoSuchStartupsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Startups startups = (Startups)session.get(StartupsImpl.class,
					primaryKey);

			if (startups == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStartupsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(startups);
		}
		catch (NoSuchStartupsException nsee) {
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
	protected Startups removeImpl(Startups startups) throws SystemException {
		startups = toUnwrappedModel(startups);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(startups)) {
				startups = (Startups)session.get(StartupsImpl.class,
						startups.getPrimaryKeyObj());
			}

			if (startups != null) {
				session.delete(startups);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (startups != null) {
			clearCache(startups);
		}

		return startups;
	}

	@Override
	public Startups updateImpl(com.jio.portlet.startups.model.Startups startups)
		throws SystemException {
		startups = toUnwrappedModel(startups);

		boolean isNew = startups.isNew();

		Session session = null;

		try {
			session = openSession();

			if (startups.isNew()) {
				session.save(startups);

				startups.setNew(false);
			}
			else {
				session.merge(startups);
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

		EntityCacheUtil.putResult(StartupsModelImpl.ENTITY_CACHE_ENABLED,
			StartupsImpl.class, startups.getPrimaryKey(), startups);

		return startups;
	}

	protected Startups toUnwrappedModel(Startups startups) {
		if (startups instanceof StartupsImpl) {
			return startups;
		}

		StartupsImpl startupsImpl = new StartupsImpl();

		startupsImpl.setNew(startups.isNew());
		startupsImpl.setPrimaryKey(startups.getPrimaryKey());

		startupsImpl.setStartupsId(startups.getStartupsId());
		startupsImpl.setName(startups.getName());
		startupsImpl.setCompanyName(startups.getCompanyName());
		startupsImpl.setCategory(startups.getCategory());
		startupsImpl.setStartupImage(startups.getStartupImage());
		startupsImpl.setYoutubeImages(startups.getYoutubeImages());
		startupsImpl.setYoutubeLink(startups.getYoutubeLink());
		startupsImpl.setShortDescription(startups.getShortDescription());
		startupsImpl.setStartupDesc(startups.getStartupDesc());
		startupsImpl.setLongDescription(startups.getLongDescription());
		startupsImpl.setTwitter(startups.getTwitter());
		startupsImpl.setLinkedIn(startups.getLinkedIn());
		startupsImpl.setYouTube(startups.getYouTube());
		startupsImpl.setNumber(startups.getNumber());
		startupsImpl.setGroupId(startups.getGroupId());
		startupsImpl.setCompanyId(startups.getCompanyId());
		startupsImpl.setCreateDate(startups.getCreateDate());
		startupsImpl.setModifiedDate(startups.getModifiedDate());

		return startupsImpl;
	}

	/**
	 * Returns the startups with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the startups
	 * @return the startups
	 * @throws com.jio.portlet.startups.NoSuchStartupsException if a startups with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Startups findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStartupsException, SystemException {
		Startups startups = fetchByPrimaryKey(primaryKey);

		if (startups == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStartupsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return startups;
	}

	/**
	 * Returns the startups with the primary key or throws a {@link com.jio.portlet.startups.NoSuchStartupsException} if it could not be found.
	 *
	 * @param startupsId the primary key of the startups
	 * @return the startups
	 * @throws com.jio.portlet.startups.NoSuchStartupsException if a startups with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Startups findByPrimaryKey(long startupsId)
		throws NoSuchStartupsException, SystemException {
		return findByPrimaryKey((Serializable)startupsId);
	}

	/**
	 * Returns the startups with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the startups
	 * @return the startups, or <code>null</code> if a startups with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Startups fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Startups startups = (Startups)EntityCacheUtil.getResult(StartupsModelImpl.ENTITY_CACHE_ENABLED,
				StartupsImpl.class, primaryKey);

		if (startups == _nullStartups) {
			return null;
		}

		if (startups == null) {
			Session session = null;

			try {
				session = openSession();

				startups = (Startups)session.get(StartupsImpl.class, primaryKey);

				if (startups != null) {
					cacheResult(startups);
				}
				else {
					EntityCacheUtil.putResult(StartupsModelImpl.ENTITY_CACHE_ENABLED,
						StartupsImpl.class, primaryKey, _nullStartups);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StartupsModelImpl.ENTITY_CACHE_ENABLED,
					StartupsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return startups;
	}

	/**
	 * Returns the startups with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param startupsId the primary key of the startups
	 * @return the startups, or <code>null</code> if a startups with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Startups fetchByPrimaryKey(long startupsId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)startupsId);
	}

	/**
	 * Returns all the startupses.
	 *
	 * @return the startupses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Startups> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Startups> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Startups> findAll(int start, int end,
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

		List<Startups> list = (List<Startups>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STARTUPS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STARTUPS;

				if (pagination) {
					sql = sql.concat(StartupsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Startups>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Startups>(list);
				}
				else {
					list = (List<Startups>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the startupses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Startups startups : findAll()) {
			remove(startups);
		}
	}

	/**
	 * Returns the number of startupses.
	 *
	 * @return the number of startupses
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

				Query q = session.createQuery(_SQL_COUNT_STARTUPS);

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
	 * Initializes the startups persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.jio.portlet.startups.model.Startups")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Startups>> listenersList = new ArrayList<ModelListener<Startups>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Startups>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StartupsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STARTUPS = "SELECT startups FROM Startups startups";
	private static final String _SQL_COUNT_STARTUPS = "SELECT COUNT(startups) FROM Startups startups";
	private static final String _ORDER_BY_ENTITY_ALIAS = "startups.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Startups exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StartupsPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"number"
			});
	private static Startups _nullStartups = new StartupsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Startups> toCacheModel() {
				return _nullStartupsCacheModel;
			}
		};

	private static CacheModel<Startups> _nullStartupsCacheModel = new CacheModel<Startups>() {
			@Override
			public Startups toEntityModel() {
				return _nullStartups;
			}
		};
}