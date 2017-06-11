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

import com.jio.portlet.jurys.NoSuchJurysException;
import com.jio.portlet.jurys.model.Jurys;
import com.jio.portlet.jurys.model.impl.JurysImpl;
import com.jio.portlet.jurys.model.impl.JurysModelImpl;
import com.jio.portlet.jurys.service.persistence.JurysPersistence;

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
 * The persistence implementation for the jurys service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Reliance
 * @see JurysPersistence
 * @see JurysUtil
 * @generated
 */
public class JurysPersistenceImpl extends BasePersistenceImpl<Jurys>
	implements JurysPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link JurysUtil} to access the jurys persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = JurysImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(JurysModelImpl.ENTITY_CACHE_ENABLED,
			JurysModelImpl.FINDER_CACHE_ENABLED, JurysImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(JurysModelImpl.ENTITY_CACHE_ENABLED,
			JurysModelImpl.FINDER_CACHE_ENABLED, JurysImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(JurysModelImpl.ENTITY_CACHE_ENABLED,
			JurysModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public JurysPersistenceImpl() {
		setModelClass(Jurys.class);
	}

	/**
	 * Caches the jurys in the entity cache if it is enabled.
	 *
	 * @param jurys the jurys
	 */
	@Override
	public void cacheResult(Jurys jurys) {
		EntityCacheUtil.putResult(JurysModelImpl.ENTITY_CACHE_ENABLED,
			JurysImpl.class, jurys.getPrimaryKey(), jurys);

		jurys.resetOriginalValues();
	}

	/**
	 * Caches the juryses in the entity cache if it is enabled.
	 *
	 * @param juryses the juryses
	 */
	@Override
	public void cacheResult(List<Jurys> juryses) {
		for (Jurys jurys : juryses) {
			if (EntityCacheUtil.getResult(JurysModelImpl.ENTITY_CACHE_ENABLED,
						JurysImpl.class, jurys.getPrimaryKey()) == null) {
				cacheResult(jurys);
			}
			else {
				jurys.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all juryses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(JurysImpl.class.getName());
		}

		EntityCacheUtil.clearCache(JurysImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the jurys.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Jurys jurys) {
		EntityCacheUtil.removeResult(JurysModelImpl.ENTITY_CACHE_ENABLED,
			JurysImpl.class, jurys.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Jurys> juryses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Jurys jurys : juryses) {
			EntityCacheUtil.removeResult(JurysModelImpl.ENTITY_CACHE_ENABLED,
				JurysImpl.class, jurys.getPrimaryKey());
		}
	}

	/**
	 * Creates a new jurys with the primary key. Does not add the jurys to the database.
	 *
	 * @param jurysId the primary key for the new jurys
	 * @return the new jurys
	 */
	@Override
	public Jurys create(long jurysId) {
		Jurys jurys = new JurysImpl();

		jurys.setNew(true);
		jurys.setPrimaryKey(jurysId);

		return jurys;
	}

	/**
	 * Removes the jurys with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jurysId the primary key of the jurys
	 * @return the jurys that was removed
	 * @throws com.jio.portlet.jurys.NoSuchJurysException if a jurys with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Jurys remove(long jurysId)
		throws NoSuchJurysException, SystemException {
		return remove((Serializable)jurysId);
	}

	/**
	 * Removes the jurys with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the jurys
	 * @return the jurys that was removed
	 * @throws com.jio.portlet.jurys.NoSuchJurysException if a jurys with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Jurys remove(Serializable primaryKey)
		throws NoSuchJurysException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Jurys jurys = (Jurys)session.get(JurysImpl.class, primaryKey);

			if (jurys == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJurysException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(jurys);
		}
		catch (NoSuchJurysException nsee) {
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
	protected Jurys removeImpl(Jurys jurys) throws SystemException {
		jurys = toUnwrappedModel(jurys);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(jurys)) {
				jurys = (Jurys)session.get(JurysImpl.class,
						jurys.getPrimaryKeyObj());
			}

			if (jurys != null) {
				session.delete(jurys);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (jurys != null) {
			clearCache(jurys);
		}

		return jurys;
	}

	@Override
	public Jurys updateImpl(com.jio.portlet.jurys.model.Jurys jurys)
		throws SystemException {
		jurys = toUnwrappedModel(jurys);

		boolean isNew = jurys.isNew();

		Session session = null;

		try {
			session = openSession();

			if (jurys.isNew()) {
				session.save(jurys);

				jurys.setNew(false);
			}
			else {
				session.merge(jurys);
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

		EntityCacheUtil.putResult(JurysModelImpl.ENTITY_CACHE_ENABLED,
			JurysImpl.class, jurys.getPrimaryKey(), jurys);

		return jurys;
	}

	protected Jurys toUnwrappedModel(Jurys jurys) {
		if (jurys instanceof JurysImpl) {
			return jurys;
		}

		JurysImpl jurysImpl = new JurysImpl();

		jurysImpl.setNew(jurys.isNew());
		jurysImpl.setPrimaryKey(jurys.getPrimaryKey());

		jurysImpl.setJurysId(jurys.getJurysId());
		jurysImpl.setName(jurys.getName());
		jurysImpl.setCompanyName(jurys.getCompanyName());
		jurysImpl.setCategory(jurys.getCategory());
		jurysImpl.setJuryImage(jurys.getJuryImage());
		jurysImpl.setShortDescription(jurys.getShortDescription());
		jurysImpl.setLongDescription(jurys.getLongDescription());
		jurysImpl.setNumber(jurys.getNumber());
		jurysImpl.setGroupId(jurys.getGroupId());
		jurysImpl.setCompanyId(jurys.getCompanyId());
		jurysImpl.setCreateDate(jurys.getCreateDate());
		jurysImpl.setModifiedDate(jurys.getModifiedDate());

		return jurysImpl;
	}

	/**
	 * Returns the jurys with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the jurys
	 * @return the jurys
	 * @throws com.jio.portlet.jurys.NoSuchJurysException if a jurys with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Jurys findByPrimaryKey(Serializable primaryKey)
		throws NoSuchJurysException, SystemException {
		Jurys jurys = fetchByPrimaryKey(primaryKey);

		if (jurys == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchJurysException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return jurys;
	}

	/**
	 * Returns the jurys with the primary key or throws a {@link com.jio.portlet.jurys.NoSuchJurysException} if it could not be found.
	 *
	 * @param jurysId the primary key of the jurys
	 * @return the jurys
	 * @throws com.jio.portlet.jurys.NoSuchJurysException if a jurys with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Jurys findByPrimaryKey(long jurysId)
		throws NoSuchJurysException, SystemException {
		return findByPrimaryKey((Serializable)jurysId);
	}

	/**
	 * Returns the jurys with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the jurys
	 * @return the jurys, or <code>null</code> if a jurys with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Jurys fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Jurys jurys = (Jurys)EntityCacheUtil.getResult(JurysModelImpl.ENTITY_CACHE_ENABLED,
				JurysImpl.class, primaryKey);

		if (jurys == _nullJurys) {
			return null;
		}

		if (jurys == null) {
			Session session = null;

			try {
				session = openSession();

				jurys = (Jurys)session.get(JurysImpl.class, primaryKey);

				if (jurys != null) {
					cacheResult(jurys);
				}
				else {
					EntityCacheUtil.putResult(JurysModelImpl.ENTITY_CACHE_ENABLED,
						JurysImpl.class, primaryKey, _nullJurys);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(JurysModelImpl.ENTITY_CACHE_ENABLED,
					JurysImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return jurys;
	}

	/**
	 * Returns the jurys with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jurysId the primary key of the jurys
	 * @return the jurys, or <code>null</code> if a jurys with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Jurys fetchByPrimaryKey(long jurysId) throws SystemException {
		return fetchByPrimaryKey((Serializable)jurysId);
	}

	/**
	 * Returns all the juryses.
	 *
	 * @return the juryses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Jurys> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Jurys> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Jurys> findAll(int start, int end,
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

		List<Jurys> list = (List<Jurys>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_JURYS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_JURYS;

				if (pagination) {
					sql = sql.concat(JurysModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Jurys>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Jurys>(list);
				}
				else {
					list = (List<Jurys>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the juryses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Jurys jurys : findAll()) {
			remove(jurys);
		}
	}

	/**
	 * Returns the number of juryses.
	 *
	 * @return the number of juryses
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

				Query q = session.createQuery(_SQL_COUNT_JURYS);

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
	 * Initializes the jurys persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.jio.portlet.jurys.model.Jurys")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Jurys>> listenersList = new ArrayList<ModelListener<Jurys>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Jurys>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(JurysImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_JURYS = "SELECT jurys FROM Jurys jurys";
	private static final String _SQL_COUNT_JURYS = "SELECT COUNT(jurys) FROM Jurys jurys";
	private static final String _ORDER_BY_ENTITY_ALIAS = "jurys.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Jurys exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(JurysPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"number"
			});
	private static Jurys _nullJurys = new JurysImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Jurys> toCacheModel() {
				return _nullJurysCacheModel;
			}
		};

	private static CacheModel<Jurys> _nullJurysCacheModel = new CacheModel<Jurys>() {
			@Override
			public Jurys toEntityModel() {
				return _nullJurys;
			}
		};
}