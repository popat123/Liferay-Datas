<%@include file="../init.jsp" %>
<%@page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.util.PortletKeys"%>
<%@page import="javax.portlet.WindowState"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="liferay-portlet" uri="http://liferay.com/tld/portlet" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>



 
<liferay-ui:search-container  searchContainer="${searchContainer}" >
	<liferay-ui:search-container-results results="${searchContainer.results}" total="${searchContainer.total}"/>
	<liferay-ui:search-container-row className="com.liferay.portlet.journal.model.JournalArticle" modelVar="content">
		<liferay-ui:search-container-column-text name="content.title" value="<%=content.getTitleCurrentValue() %>"/>
		<liferay-ui:search-container-column-text name="content.version" value="<%=String.valueOf(content.getVersion()) %>"/>
		<liferay-ui:search-container-column-jsp path="/html/webcontentmanagement/action.jsp"></liferay-ui:search-container-column-jsp>
	</liferay-ui:search-container-row>
<liferay-ui:search-iterator/>
</liferay-ui:search-container> 


