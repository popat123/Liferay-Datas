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

<portlet:renderURL var="viewUrl">
	<portlet:param name="jspPage" value="/html/lepuserprofile/view.jsp"/>
</portlet:renderURL>

<liferay-portlet:actionURL var="editProfile">
</liferay-portlet:actionURL>
<div class="profile-edit-sec">
		<aui:form method="post" action="${editProfile}">
		<a href="${viewUrl }"> Back</a>
		<div class="row-fluid">
				
				
				<aui:fieldset cssClass="span2 profile-pic">
					<div>
						<%--  <c:if test="${lepUser.userId != themeDisplay.getUserId()}">
								<img alt="${lepUser.fullName}" src="${ImagePath}"/>
						</c:if> --%>
						<c:if test="${lepUser.userId == themeDisplay.getUserId()}">
							<%
					 			String editPortraitUrl = themeDisplay.getPortalURL()+"/group/control_panel/manage?p_p_id=2&p_p_state=pop_up&p_p_mode=view&_2_portrait_id=0&_2_p_u_i_d="+themeDisplay.getUserId()+"&_2_struts_action=%2Fmy_account%2Fedit_user_portrait";
					 		%>
							<liferay-ui:logo-selector
								currentLogoURL="<%= selUser.getPortraitURL(themeDisplay) %>"
								defaultLogoURL="<%= UserConstants.getPortraitURL(themeDisplay.getPathImage(), selUser.isMale(), 0) %>"	
								editLogoURL= "<%=editPortraitUrl%>"
								imageId="<%= selUser.getPortraitId() %>"
								logoDisplaySelector=".user-logo" />
						</c:if>
					</div>
				</aui:fieldset>
				
				<aui:fieldset cssClass="span10">
					<div class="row-fluid">
						<aui:fieldset cssClass="span6">
							<aui:input name="firstName" cssClass="custom-input" label=""  placeholder="First Name" value="${lepUser.firstName }"/>
						</aui:fieldset>
						<aui:fieldset cssClass="span6">
							<aui:input name="lastName" cssClass="custom-input" label="" placeholder="Last Name" value="${lepUser.lastName }"/>
						</aui:fieldset>	
					</div>
					
					<div class="row-fluid">
						<aui:fieldset cssClass="span6">
							<aui:input name="jobTitle" cssClass="custom-input" label="" placeholder="Position/Occupation" value="${lepUser.jobTitle }"/>
						</aui:fieldset>
						<aui:fieldset cssClass="span6">
							<aui:input name="site" cssClass="custom-input" label="" placeholder="Site/Function" value=""/>
							
						</aui:fieldset>
					</div>
					
					<div class="row-fluid">
						<aui:fieldset cssClass="span12">
							<aui:input type="textarea" cssClass="custom-input no-resize custom-textarea" label="" name="bioData" placeholder="Type your Bio" value=""/>
						</aui:fieldset>
						
						<aui:button-row>
							<aui:button type="submit" cssClass="edit-btn" value="SUBMIT PROFILE"> </aui:button>	
						</aui:button-row>
					</div>
				</aui:fieldset>
				
				
			
		</div>
		</aui:form>
</div>