<%
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
%>
<%@include file="/html/init.jsp" %>

<portlet:actionURL var="searchSiteUrl" name="searchSite" />

         <%--    <form name="searchForm" class="searchbox" method="post" action="<%=searchSiteUrl%>">
                <input type="search" placeholder="Search" name="<portlet:namespace/>searchText" id="searchText" class="searchbox-input" onkeyup="buttonUp();" required>
                <input type="submit" class="searchbox-submit" value="GO">
                <span class="searchbox-icon"></span>
            </form> --%>

<%-- <liferay-portlet:renderURL portletName="_lepsearch_WAR_lepsearchportlet" var="searchSiteUrl" plid="<%=themeDisplay.getPlid()%>" >
</liferay-portlet:renderURL> --%>
<h2></h2>
<form class="custom-search-form" method="post" action="${searchSiteUrl}">
	<fieldset class="fieldset">
		<div class="">
			<div class="control-group control-group-inline input-text-wrapper">
				<input class="field" id="keyword" name="<portlet:namespace/>keyword" placeholder="Search" title="Search" type="text"
					value="" size="30">
			</div>
			<div class="control-group control-group-inline input-text-wrapper">
				<input alt="Search" class="field" id="search" name="search"
					title="Search" type="image" src="<%=themeDisplay.getPathThemeImages() %>/common/search.png">
			</div>
		</div>
	</fieldset>
</form>