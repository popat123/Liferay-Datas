<%@page import="com.liferay.portal.util.PortletKeys"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="/html/init.jsp" %>
<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
    JournalArticle article = (JournalArticle) row.getObject();
%>
<portlet:actionURL var="deleteURL" name="deleteContent">
	<portlet:param name="articleId" value="<%=String.valueOf(article.getId())%>"/>
</portlet:actionURL>
<liferay-portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>" var="editURL" portletName="<%= PortletKeys.JOURNAL %>">
        <portlet:param name="struts_action" value="/journal/edit_article" />
        <portlet:param name="redirect" value="<%= PortalUtil.getCurrentURL(renderRequest) %>" />
        <portlet:param name="originalRedirect" value="<%= PortalUtil.getCurrentURL(renderRequest) %>" />
        <portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId)%>" />
        <portlet:param name="articleId" value="<%=article.getArticleId()%>" />
        <portlet:param name="version" value="<%=String.valueOf(article.getVersion())%>" />
 </liferay-portlet:renderURL>

<liferay-ui:icon-menu>
            	<liferay-ui:icon message="edit.content" url="${editURL}" image="edit"/>
            	<liferay-ui:icon message="delete.content" url="${deleteURL}" image="delete"/>
</liferay-ui:icon-menu>