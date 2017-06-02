<%@page import="com.liferay.portal.model.Role"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.util.PortletKeys"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<jsp:include page="../init.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%
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
%>
<portlet:defineObjects />
<liferay-theme:defineObjects/>

<%
List<Role> roles = themeDisplay.getUser().getRoles();
boolean omniAdmin = permissionChecker.isOmniadmin();
boolean contentReviewer = permissionChecker.isContentReviewer(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId());
%>
<h3 class="submenuheader"><%= StringUtil.upperCaseFirstLetter(portletName) %> <span class="menu-header-plus-sign">+</span><span class="menu-header-minus-sign">-</span></h3>
<div class="submenu hide">
	<ul>
	<c:if test="<%=contentReviewer%>">
	<!-- <li><a href="/group/guest/admin">Admin</a> -->
	</c:if>
		<c:forEach items="${models}" var="model">
			<liferay-portlet:renderURL portletName="<%=PortletKeys.JOURNAL%>" var="addArticleURL" windowState="<%= LiferayWindowState.MAXIMIZED.toString() %>">
						<portlet:param name="struts_action" value="/journal/edit_article" />
						<portlet:param name="redirect" value="${currentURL}" />
						<portlet:param name="groupId" value="${groupId}" />
						<portlet:param name="folderId" value="${folderId}" />
						<portlet:param name="structureId" value="${model.structureKey}" />
			</liferay-portlet:renderURL>		
			<li><a href="<%= addArticleURL %>">${model.structureName}</a></li>
		
		</c:forEach>
	</ul>
</div>																	