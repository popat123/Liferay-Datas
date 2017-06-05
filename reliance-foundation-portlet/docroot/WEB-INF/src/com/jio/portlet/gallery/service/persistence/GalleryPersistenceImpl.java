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

import com.jio.portlet.gallery.NoSuchGalleryException;
import com.jio.portlet.gallery.model.Gallery;
import com.jio.portlet.gallery.model.impl.GalleryImpl;
import com.jio.portlet.gallery.model.impl.GalleryModelImpl;
import com.jio.portlet.gallery.service.persistence.GalleryPersistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
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
 * The persistence implementation for the gallery service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Reliance
 * @see GalleryPersistence
 * @see GalleryUtil
 * @generated
 */
public class GalleryPersistenceImpl extends BasePersistenceImpl<Gallery>
	implements GalleryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GalleryUtil} to access the gallery persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GalleryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GalleryModelImpl.ENTITY_CACHE_ENABLED,
			GalleryModelImpl.FINDER_CACHE_ENABLED, GalleryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GalleryModelImpl.ENTITY_CACHE_ENABLED,
			GalleryModelImpl.FINDER_CACHE_ENABLED, GalleryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GalleryModelImpl.ENTITY_CACHE_ENABLED,
			GalleryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEOPRIORITY =
		new FinderPath(GalleryModelImpl.ENTITY_CACHE_ENABLED,
			GalleryModelImpl.FINDER_CACHE_ENABLED, GalleryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVideoPriority",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOPRIORITY =
		new FinderPath(GalleryModelImpl.ENTITY_CACHE_ENABLED,
			GalleryModelImpl.FINDER_CACHE_ENABLED, GalleryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVideoPriority",
			new String[] { Boolean.class.getName() },
			GalleryModelImpl.VIDEOSIMAGPRIORITY_COLUMN_BITMASK |
			GalleryModelImpl.NUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEOPRIORITY = new FinderPath(GalleryModelImpl.ENTITY_CACHE_ENABLED,
			GalleryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideoPriority",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the galleries where videosImagPriority = &#63;.
	 *
	 * @param videosImagPriority the videos imag priority
	 * @return the matching galleries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Gallery> findByVideoPriority(boolean videosImagPriority)
		throws SystemException {
		return findByVideoPriority(videosImagPriority, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Gallery> findByVideoPriority(boolean videosImagPriority,
		int start, int end) throws SystemException {
		return findByVideoPriority(videosImagPriority, start, end, null);
	}

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
	@Override
	public List<Gallery> findByVideoPriority(boolean videosImagPriority,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOPRIORITY;
			finderArgs = new Object[] { videosImagPriority };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEOPRIORITY;
			finderArgs = new Object[] {
					videosImagPriority,
					
					start, end, orderByComparator
				};
		}

		List<Gallery> list = (List<Gallery>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Gallery gallery : list) {
				if ((videosImagPriority != gallery.getVideosImagPriority())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_GALLERY_WHERE);

			query.append(_FINDER_COLUMN_VIDEOPRIORITY_VIDEOSIMAGPRIORITY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GalleryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videosImagPriority);

				if (!pagination) {
					list = (List<Gallery>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Gallery>(list);
				}
				else {
					list = (List<Gallery>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first gallery in the ordered set where videosImagPriority = &#63;.
	 *
	 * @param videosImagPriority the videos imag priority
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gallery
	 * @throws com.jio.portlet.gallery.NoSuchGalleryException if a matching gallery could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Gallery findByVideoPriority_First(boolean videosImagPriority,
		OrderByComparator orderByComparator)
		throws NoSuchGalleryException, SystemException {
		Gallery gallery = fetchByVideoPriority_First(videosImagPriority,
				orderByComparator);

		if (gallery != null) {
			return gallery;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videosImagPriority=");
		msg.append(videosImagPriority);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGalleryException(msg.toString());
	}

	/**
	 * Returns the first gallery in the ordered set where videosImagPriority = &#63;.
	 *
	 * @param videosImagPriority the videos imag priority
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gallery, or <code>null</code> if a matching gallery could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Gallery fetchByVideoPriority_First(boolean videosImagPriority,
		OrderByComparator orderByComparator) throws SystemException {
		List<Gallery> list = findByVideoPriority(videosImagPriority, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last gallery in the ordered set where videosImagPriority = &#63;.
	 *
	 * @param videosImagPriority the videos imag priority
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gallery
	 * @throws com.jio.portlet.gallery.NoSuchGalleryException if a matching gallery could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Gallery findByVideoPriority_Last(boolean videosImagPriority,
		OrderByComparator orderByComparator)
		throws NoSuchGalleryException, SystemException {
		Gallery gallery = fetchByVideoPriority_Last(videosImagPriority,
				orderByComparator);

		if (gallery != null) {
			return gallery;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videosImagPriority=");
		msg.append(videosImagPriority);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGalleryException(msg.toString());
	}

	/**
	 * Returns the last gallery in the ordered set where videosImagPriority = &#63;.
	 *
	 * @param videosImagPriority the videos imag priority
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gallery, or <code>null</code> if a matching gallery could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Gallery fetchByVideoPriority_Last(boolean videosImagPriority,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByVideoPriority(videosImagPriority);

		if (count == 0) {
			return null;
		}

		List<Gallery> list = findByVideoPriority(videosImagPriority, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Gallery[] findByVideoPriority_PrevAndNext(long galleryId,
		boolean videosImagPriority, OrderByComparator orderByComparator)
		throws NoSuchGalleryException, SystemException {
		Gallery gallery = findByPrimaryKey(galleryId);

		Session session = null;

		try {
			session = openSession();

			Gallery[] array = new GalleryImpl[3];

			array[0] = getByVideoPriority_PrevAndNext(session, gallery,
					videosImagPriority, orderByComparator, true);

			array[1] = gallery;

			array[2] = getByVideoPriority_PrevAndNext(session, gallery,
					videosImagPriority, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Gallery getByVideoPriority_PrevAndNext(Session session,
		Gallery gallery, boolean videosImagPriority,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GALLERY_WHERE);

		query.append(_FINDER_COLUMN_VIDEOPRIORITY_VIDEOSIMAGPRIORITY_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(GalleryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(videosImagPriority);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(gallery);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Gallery> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the galleries where videosImagPriority = &#63; from the database.
	 *
	 * @param videosImagPriority the videos imag priority
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVideoPriority(boolean videosImagPriority)
		throws SystemException {
		for (Gallery gallery : findByVideoPriority(videosImagPriority,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(gallery);
		}
	}

	/**
	 * Returns the number of galleries where videosImagPriority = &#63;.
	 *
	 * @param videosImagPriority the videos imag priority
	 * @return the number of matching galleries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByVideoPriority(boolean videosImagPriority)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VIDEOPRIORITY;

		Object[] finderArgs = new Object[] { videosImagPriority };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GALLERY_WHERE);

			query.append(_FINDER_COLUMN_VIDEOPRIORITY_VIDEOSIMAGPRIORITY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videosImagPriority);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_VIDEOPRIORITY_VIDEOSIMAGPRIORITY_2 =
		"gallery.videosImagPriority = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IMAGEPRIORITY =
		new FinderPath(GalleryModelImpl.ENTITY_CACHE_ENABLED,
			GalleryModelImpl.FINDER_CACHE_ENABLED, GalleryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByImagePriority",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMAGEPRIORITY =
		new FinderPath(GalleryModelImpl.ENTITY_CACHE_ENABLED,
			GalleryModelImpl.FINDER_CACHE_ENABLED, GalleryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByImagePriority",
			new String[] { Boolean.class.getName() },
			GalleryModelImpl.GALLRYIMAGPRIORITY_COLUMN_BITMASK |
			GalleryModelImpl.NUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IMAGEPRIORITY = new FinderPath(GalleryModelImpl.ENTITY_CACHE_ENABLED,
			GalleryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByImagePriority",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the galleries where gallryImagPriority = &#63;.
	 *
	 * @param gallryImagPriority the gallry imag priority
	 * @return the matching galleries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Gallery> findByImagePriority(boolean gallryImagPriority)
		throws SystemException {
		return findByImagePriority(gallryImagPriority, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Gallery> findByImagePriority(boolean gallryImagPriority,
		int start, int end) throws SystemException {
		return findByImagePriority(gallryImagPriority, start, end, null);
	}

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
	@Override
	public List<Gallery> findByImagePriority(boolean gallryImagPriority,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMAGEPRIORITY;
			finderArgs = new Object[] { gallryImagPriority };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_IMAGEPRIORITY;
			finderArgs = new Object[] {
					gallryImagPriority,
					
					start, end, orderByComparator
				};
		}

		List<Gallery> list = (List<Gallery>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Gallery gallery : list) {
				if ((gallryImagPriority != gallery.getGallryImagPriority())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_GALLERY_WHERE);

			query.append(_FINDER_COLUMN_IMAGEPRIORITY_GALLRYIMAGPRIORITY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GalleryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(gallryImagPriority);

				if (!pagination) {
					list = (List<Gallery>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Gallery>(list);
				}
				else {
					list = (List<Gallery>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first gallery in the ordered set where gallryImagPriority = &#63;.
	 *
	 * @param gallryImagPriority the gallry imag priority
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gallery
	 * @throws com.jio.portlet.gallery.NoSuchGalleryException if a matching gallery could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Gallery findByImagePriority_First(boolean gallryImagPriority,
		OrderByComparator orderByComparator)
		throws NoSuchGalleryException, SystemException {
		Gallery gallery = fetchByImagePriority_First(gallryImagPriority,
				orderByComparator);

		if (gallery != null) {
			return gallery;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("gallryImagPriority=");
		msg.append(gallryImagPriority);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGalleryException(msg.toString());
	}

	/**
	 * Returns the first gallery in the ordered set where gallryImagPriority = &#63;.
	 *
	 * @param gallryImagPriority the gallry imag priority
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching gallery, or <code>null</code> if a matching gallery could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Gallery fetchByImagePriority_First(boolean gallryImagPriority,
		OrderByComparator orderByComparator) throws SystemException {
		List<Gallery> list = findByImagePriority(gallryImagPriority, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last gallery in the ordered set where gallryImagPriority = &#63;.
	 *
	 * @param gallryImagPriority the gallry imag priority
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gallery
	 * @throws com.jio.portlet.gallery.NoSuchGalleryException if a matching gallery could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Gallery findByImagePriority_Last(boolean gallryImagPriority,
		OrderByComparator orderByComparator)
		throws NoSuchGalleryException, SystemException {
		Gallery gallery = fetchByImagePriority_Last(gallryImagPriority,
				orderByComparator);

		if (gallery != null) {
			return gallery;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("gallryImagPriority=");
		msg.append(gallryImagPriority);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGalleryException(msg.toString());
	}

	/**
	 * Returns the last gallery in the ordered set where gallryImagPriority = &#63;.
	 *
	 * @param gallryImagPriority the gallry imag priority
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching gallery, or <code>null</code> if a matching gallery could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Gallery fetchByImagePriority_Last(boolean gallryImagPriority,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByImagePriority(gallryImagPriority);

		if (count == 0) {
			return null;
		}

		List<Gallery> list = findByImagePriority(gallryImagPriority, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Gallery[] findByImagePriority_PrevAndNext(long galleryId,
		boolean gallryImagPriority, OrderByComparator orderByComparator)
		throws NoSuchGalleryException, SystemException {
		Gallery gallery = findByPrimaryKey(galleryId);

		Session session = null;

		try {
			session = openSession();

			Gallery[] array = new GalleryImpl[3];

			array[0] = getByImagePriority_PrevAndNext(session, gallery,
					gallryImagPriority, orderByComparator, true);

			array[1] = gallery;

			array[2] = getByImagePriority_PrevAndNext(session, gallery,
					gallryImagPriority, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Gallery getByImagePriority_PrevAndNext(Session session,
		Gallery gallery, boolean gallryImagPriority,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GALLERY_WHERE);

		query.append(_FINDER_COLUMN_IMAGEPRIORITY_GALLRYIMAGPRIORITY_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(GalleryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(gallryImagPriority);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(gallery);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Gallery> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the galleries where gallryImagPriority = &#63; from the database.
	 *
	 * @param gallryImagPriority the gallry imag priority
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByImagePriority(boolean gallryImagPriority)
		throws SystemException {
		for (Gallery gallery : findByImagePriority(gallryImagPriority,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(gallery);
		}
	}

	/**
	 * Returns the number of galleries where gallryImagPriority = &#63;.
	 *
	 * @param gallryImagPriority the gallry imag priority
	 * @return the number of matching galleries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByImagePriority(boolean gallryImagPriority)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IMAGEPRIORITY;

		Object[] finderArgs = new Object[] { gallryImagPriority };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GALLERY_WHERE);

			query.append(_FINDER_COLUMN_IMAGEPRIORITY_GALLRYIMAGPRIORITY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(gallryImagPriority);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_IMAGEPRIORITY_GALLRYIMAGPRIORITY_2 =
		"gallery.gallryImagPriority = ?";

	public GalleryPersistenceImpl() {
		setModelClass(Gallery.class);
	}

	/**
	 * Caches the gallery in the entity cache if it is enabled.
	 *
	 * @param gallery the gallery
	 */
	@Override
	public void cacheResult(Gallery gallery) {
		EntityCacheUtil.putResult(GalleryModelImpl.ENTITY_CACHE_ENABLED,
			GalleryImpl.class, gallery.getPrimaryKey(), gallery);

		gallery.resetOriginalValues();
	}

	/**
	 * Caches the galleries in the entity cache if it is enabled.
	 *
	 * @param galleries the galleries
	 */
	@Override
	public void cacheResult(List<Gallery> galleries) {
		for (Gallery gallery : galleries) {
			if (EntityCacheUtil.getResult(
						GalleryModelImpl.ENTITY_CACHE_ENABLED,
						GalleryImpl.class, gallery.getPrimaryKey()) == null) {
				cacheResult(gallery);
			}
			else {
				gallery.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all galleries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GalleryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GalleryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the gallery.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Gallery gallery) {
		EntityCacheUtil.removeResult(GalleryModelImpl.ENTITY_CACHE_ENABLED,
			GalleryImpl.class, gallery.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Gallery> galleries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Gallery gallery : galleries) {
			EntityCacheUtil.removeResult(GalleryModelImpl.ENTITY_CACHE_ENABLED,
				GalleryImpl.class, gallery.getPrimaryKey());
		}
	}

	/**
	 * Creates a new gallery with the primary key. Does not add the gallery to the database.
	 *
	 * @param galleryId the primary key for the new gallery
	 * @return the new gallery
	 */
	@Override
	public Gallery create(long galleryId) {
		Gallery gallery = new GalleryImpl();

		gallery.setNew(true);
		gallery.setPrimaryKey(galleryId);

		return gallery;
	}

	/**
	 * Removes the gallery with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param galleryId the primary key of the gallery
	 * @return the gallery that was removed
	 * @throws com.jio.portlet.gallery.NoSuchGalleryException if a gallery with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Gallery remove(long galleryId)
		throws NoSuchGalleryException, SystemException {
		return remove((Serializable)galleryId);
	}

	/**
	 * Removes the gallery with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the gallery
	 * @return the gallery that was removed
	 * @throws com.jio.portlet.gallery.NoSuchGalleryException if a gallery with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Gallery remove(Serializable primaryKey)
		throws NoSuchGalleryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Gallery gallery = (Gallery)session.get(GalleryImpl.class, primaryKey);

			if (gallery == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGalleryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gallery);
		}
		catch (NoSuchGalleryException nsee) {
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
	protected Gallery removeImpl(Gallery gallery) throws SystemException {
		gallery = toUnwrappedModel(gallery);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gallery)) {
				gallery = (Gallery)session.get(GalleryImpl.class,
						gallery.getPrimaryKeyObj());
			}

			if (gallery != null) {
				session.delete(gallery);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (gallery != null) {
			clearCache(gallery);
		}

		return gallery;
	}

	@Override
	public Gallery updateImpl(com.jio.portlet.gallery.model.Gallery gallery)
		throws SystemException {
		gallery = toUnwrappedModel(gallery);

		boolean isNew = gallery.isNew();

		GalleryModelImpl galleryModelImpl = (GalleryModelImpl)gallery;

		Session session = null;

		try {
			session = openSession();

			if (gallery.isNew()) {
				session.save(gallery);

				gallery.setNew(false);
			}
			else {
				session.merge(gallery);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GalleryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((galleryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOPRIORITY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						galleryModelImpl.getOriginalVideosImagPriority()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEOPRIORITY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOPRIORITY,
					args);

				args = new Object[] { galleryModelImpl.getVideosImagPriority() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEOPRIORITY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOPRIORITY,
					args);
			}

			if ((galleryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMAGEPRIORITY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						galleryModelImpl.getOriginalGallryImagPriority()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IMAGEPRIORITY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMAGEPRIORITY,
					args);

				args = new Object[] { galleryModelImpl.getGallryImagPriority() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IMAGEPRIORITY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMAGEPRIORITY,
					args);
			}
		}

		EntityCacheUtil.putResult(GalleryModelImpl.ENTITY_CACHE_ENABLED,
			GalleryImpl.class, gallery.getPrimaryKey(), gallery);

		return gallery;
	}

	protected Gallery toUnwrappedModel(Gallery gallery) {
		if (gallery instanceof GalleryImpl) {
			return gallery;
		}

		GalleryImpl galleryImpl = new GalleryImpl();

		galleryImpl.setNew(gallery.isNew());
		galleryImpl.setPrimaryKey(gallery.getPrimaryKey());

		galleryImpl.setGalleryId(gallery.getGalleryId());
		galleryImpl.setType(gallery.getType());
		galleryImpl.setThumbnailName(gallery.getThumbnailName());
		galleryImpl.setName(gallery.getName());
		galleryImpl.setMainCategory(gallery.getMainCategory());
		galleryImpl.setProjectImagesPath(gallery.getProjectImagesPath());
		galleryImpl.setGalleryImagesId(gallery.getGalleryImagesId());
		galleryImpl.setVideoImagesId(gallery.getVideoImagesId());
		galleryImpl.setThumbnailImagesId(gallery.getThumbnailImagesId());
		galleryImpl.setIsVideo(gallery.isIsVideo());
		galleryImpl.setIsIMG(gallery.isIsIMG());
		galleryImpl.setYouTubeLink(gallery.isYouTubeLink());
		galleryImpl.setVideosImagPriority(gallery.isVideosImagPriority());
		galleryImpl.setGallryImagPriority(gallery.isGallryImagPriority());
		galleryImpl.setDemoLink(gallery.getDemoLink());
		galleryImpl.setLiveLink(gallery.getLiveLink());
		galleryImpl.setNumber(gallery.getNumber());
		galleryImpl.setCreateDate(gallery.getCreateDate());
		galleryImpl.setModifiedDate(gallery.getModifiedDate());

		return galleryImpl;
	}

	/**
	 * Returns the gallery with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the gallery
	 * @return the gallery
	 * @throws com.jio.portlet.gallery.NoSuchGalleryException if a gallery with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Gallery findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGalleryException, SystemException {
		Gallery gallery = fetchByPrimaryKey(primaryKey);

		if (gallery == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGalleryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return gallery;
	}

	/**
	 * Returns the gallery with the primary key or throws a {@link com.jio.portlet.gallery.NoSuchGalleryException} if it could not be found.
	 *
	 * @param galleryId the primary key of the gallery
	 * @return the gallery
	 * @throws com.jio.portlet.gallery.NoSuchGalleryException if a gallery with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Gallery findByPrimaryKey(long galleryId)
		throws NoSuchGalleryException, SystemException {
		return findByPrimaryKey((Serializable)galleryId);
	}

	/**
	 * Returns the gallery with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the gallery
	 * @return the gallery, or <code>null</code> if a gallery with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Gallery fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Gallery gallery = (Gallery)EntityCacheUtil.getResult(GalleryModelImpl.ENTITY_CACHE_ENABLED,
				GalleryImpl.class, primaryKey);

		if (gallery == _nullGallery) {
			return null;
		}

		if (gallery == null) {
			Session session = null;

			try {
				session = openSession();

				gallery = (Gallery)session.get(GalleryImpl.class, primaryKey);

				if (gallery != null) {
					cacheResult(gallery);
				}
				else {
					EntityCacheUtil.putResult(GalleryModelImpl.ENTITY_CACHE_ENABLED,
						GalleryImpl.class, primaryKey, _nullGallery);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GalleryModelImpl.ENTITY_CACHE_ENABLED,
					GalleryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return gallery;
	}

	/**
	 * Returns the gallery with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param galleryId the primary key of the gallery
	 * @return the gallery, or <code>null</code> if a gallery with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Gallery fetchByPrimaryKey(long galleryId) throws SystemException {
		return fetchByPrimaryKey((Serializable)galleryId);
	}

	/**
	 * Returns all the galleries.
	 *
	 * @return the galleries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Gallery> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Gallery> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Gallery> findAll(int start, int end,
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

		List<Gallery> list = (List<Gallery>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GALLERY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GALLERY;

				if (pagination) {
					sql = sql.concat(GalleryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Gallery>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Gallery>(list);
				}
				else {
					list = (List<Gallery>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the galleries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Gallery gallery : findAll()) {
			remove(gallery);
		}
	}

	/**
	 * Returns the number of galleries.
	 *
	 * @return the number of galleries
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

				Query q = session.createQuery(_SQL_COUNT_GALLERY);

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
	 * Initializes the gallery persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.jio.portlet.gallery.model.Gallery")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Gallery>> listenersList = new ArrayList<ModelListener<Gallery>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Gallery>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GalleryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GALLERY = "SELECT gallery FROM Gallery gallery";
	private static final String _SQL_SELECT_GALLERY_WHERE = "SELECT gallery FROM Gallery gallery WHERE ";
	private static final String _SQL_COUNT_GALLERY = "SELECT COUNT(gallery) FROM Gallery gallery";
	private static final String _SQL_COUNT_GALLERY_WHERE = "SELECT COUNT(gallery) FROM Gallery gallery WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gallery.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Gallery exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Gallery exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GalleryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type", "number"
			});
	private static Gallery _nullGallery = new GalleryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Gallery> toCacheModel() {
				return _nullGalleryCacheModel;
			}
		};

	private static CacheModel<Gallery> _nullGalleryCacheModel = new CacheModel<Gallery>() {
			@Override
			public Gallery toEntityModel() {
				return _nullGallery;
			}
		};
}