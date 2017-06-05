<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@include file="../init.jsp" %>

<%@ page import="com.liferay.portlet.asset.model.AssetEntry" %>


<%
AssetEntry entry = (AssetEntry) request.getAttribute("entry");
if(Validator.isNotNull(entry)){
%>


<div class="detailnews">
<c:if test="${!isQuizStructure}">
	<h2>${title}</h2>
</c:if>
${journalArticle}
</div>



<liferay-portlet:renderURL var="previousURL">
	<liferay-portlet:param name="previousContentNo" value='${previous}' />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="nextURL">
	<liferay-portlet:param name="nextContentNo" value='${next}' />
</liferay-portlet:renderURL>
<div class="detailnewspagination">
    <div class="row-fluid">
        <div class="span4" align="left"></div>
        <div class="span4" align="center">
        	<c:if test="${previous ne 0}">
	        	<a href="${previousURL}"> < Previous </a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
	        </c:if>
	        <c:if test="${not lastRecord}">
	        	<a href="${nextURL}">  Next > </a>
	        </c:if>
        </div>
        
    </div>
</div>

<liferay-portlet:actionURL var="discussionURL" name="addDiscussion">
				<liferay-portlet:param name="struts_action" value='<%= "/asset_publisher/" + entry.getAssetRenderer().getDiscussionPath() %>' />
</liferay-portlet:actionURL>

<c:if test="${!isQuizStructure}">
<div class="asset-content">
		<c:if test="${not empty discussionPath}">
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
<%
}else{
%>
<div class="alert">
<liferay-ui:message key="there-are-no-article"></liferay-ui:message>
</div>
<%
}
%>





