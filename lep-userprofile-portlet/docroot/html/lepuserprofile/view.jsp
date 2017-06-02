<%@page import="com.liferay.portal.model.UserConstants"%>
<%@include file="/html/init.jsp" %>

<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portlet.usersadmin.util.UsersAdminUtil"%>
<%@page import="com.liferay.portal.model.User"%>
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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />
<%User selUser = (User)request.getAttribute("lepUser"); %>

<liferay-portlet:renderURL var="editProfileUrl">
	<portlet:param name="jspPage" value="/html/lepuserprofile/edit.jsp"/>
</liferay-portlet:renderURL>
<br/>
<div class="container-fluid">
	<div class="profile-sec-container">
		<div class="row">
			<div class="span2">
				<div class="profile-container">
					<c:if test="${lepUser.userId != themeDisplay.getUserId()}">
							<img alt="${lepUser.fullName}" src="${ImagePath}"/>
					</c:if>
					<h4 class="title detail-title">
						${lepUser.jobTitle }
					</h4>
					<div class="details">
						<p>Dummy Author</p>
						<p>Dummy (Mumbai, India)</p>
					</div>
				</div>
			</div>
			<div class="span10 margin-left-0">
				<h4 class="title detail-title">
					Know about me
					<a class="btn btn-mini pull-right edit-btn" href="${editProfileUrl}"><i class="icon-pencil"></i> Edit</a>
				</h4>
				<p>In the paragraph below, the image will float to the right. A dotted black border is added to the image. 
					We have also added margins to the image to push the text away from the image:
					0 px margin on the top and right side, 15 px margin on the bottom, and 20 px margin on the left side of the image.
				</p>
			</div>
		</div>
	</div>
</div>

<!-- <div class="row-fluid">
	
	<aui:fieldset cssClass="span2">
		<div>
			<c:if test="${lepUser.userId != themeDisplay.getUserId()}">
					<img alt="${lepUser.fullName}" src="${ImagePath}"/>
			</c:if>
			<p>${lepUser.jobTitle }</p>
		</div>
	</aui:fieldset>
	<aui:fieldset cssClass="span2">
		<a href="${editProfileUrl}">Edit</a>
	</aui:fieldset>
	<aui:fieldset cssClass="span5">
			<h4>Know about me</h4>
				<p>Reliance Retail is the retail initiative of the group and an epicenter of our consumer facing businesses. It has in a short time forged strong and enduring bonds with millions of consumers by providing them unlimited choice, outstanding value proposition, superior quality and unmatched experience across all its retail stores. 
Reliance Retail has adopted a multi-format strategy and operates convenience stores, supermarkets, hypermarkets, wholesale cash & carry stores and specialty stores and has democratized access to all types of products and services across all segments for all Indian consumers.</p>
		</aui:fieldset>
		
</div> -->