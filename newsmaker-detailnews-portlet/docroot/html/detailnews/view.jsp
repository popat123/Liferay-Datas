<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="com.liferay.portlet.ratings.model.RatingsEntry"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portlet.ratings.service.RatingsEntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortletKeys"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<%@ page import="com.liferay.portlet.asset.model.AssetEntry" %>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<liferay-theme:defineObjects/>

<%
	AssetEntry entry = (AssetEntry) request.getAttribute("entry");
%>

<header class="portlet-topper">
	 <h1 class="portlet-title">
		 ${portletTitle}
	 </h1>
 </header>

	<div class="detailnews">
	<c:if test="${!isQuizStructure}">
		<h2>${title}</h2>
	</c:if>
		${journalArticle}
		
	</div>
	

	<div class="detailnewspagination">
	
	
	    <div class="row-fluid">
 	        <div class="span4" align="left">
 	           <liferay-ui:ratings 
				className="<%=com.liferay.portlet.journal.model.JournalArticle.class.getName()%>"
    			classPK="${resourcePrimKey}" 
    			type="thumbs" 
/>
 	        </div>
	        <div class="span4" align="center">
	        	<c:if test="${not empty previousArticle}">
	        		<a href="${themeDisplay.pathFriendlyURLPrivateGroup}${themeDisplay.scopeGroup.friendlyURL}/detailed-article/-/news_content/${themeDisplay.scopeGroup.groupId}/${previousArticle.articleId}/${portletTitle}">< Previous </a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
	        	</c:if>
	        	<c:if test="${not empty nextArticle}">
	        		<a href="${themeDisplay.pathFriendlyURLPrivateGroup}${themeDisplay.scopeGroup.friendlyURL}/detailed-article/-/news_content/${themeDisplay.scopeGroup.groupId}/${nextArticle.articleId}/${portletTitle}"> Next > </a>  
	        	</c:if>
	        </div>
	     
	        <div class="span4" align="right"></div> 
	        
	    </div>
	</div>
	
	

<c:if test="${!isQueryStructure}">
	<div class="asset-content">
		<c:if test="${not empty discussionPath}">
			<liferay-portlet:actionURL var="discussionURL" name="addDiscussion">
				<liferay-portlet:param name="struts_action" value='<%= "/asset_publisher/" + entry.getAssetRenderer().getDiscussionPath() %>' />
			</liferay-portlet:actionURL>
			<liferay-ui:discussion
				className="${className}"
			 	classPK="${classPK}"
			 	formAction="${discussionURL}" 
			 	formName= '<%= "fm" + entry.getClassPK() %>' 
				ratingsEnabled="false" 
			 	redirect="${currentUrl}" 
				userId="${userId}">
			 </liferay-ui:discussion> 
		</c:if>
	</div>
</c:if>



