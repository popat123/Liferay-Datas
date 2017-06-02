<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.xml.Node"%>
<%@page import="com.liferay.portal.kernel.xml.Document"%>
<%@page import="com.liferay.portal.kernel.xml.SAXReaderUtil"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortletKeys"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<liferay-theme:defineObjects/>

 <liferay-ui:search-container searchContainer="${searchContainer}">
	<liferay-ui:search-container-results
		results="${searchContainer.results}" 
		total="${searchContainer.total}"
	/>
	<liferay-ui:search-container-row
		className="com.liferay.portlet.journal.model.JournalArticle"
		modelVar="journalArticle">
		
		<liferay-ui:search-container-column-text property="titleCurrentValue" name="Related Articles" 
		href="${themeDisplay.getPathFriendlyURLPrivateGroup()}${themeDisplay.getParentGroup().getFriendlyURL()}/detailed-article/-/news_content/${journalArticle.getGroupId()}/${journalArticle.getArticleId()}/"/>
		<% 
		String xmlContent = journalArticle.getContent();
		Document document = SAXReaderUtil.read(xmlContent);
		Node xPathContributedBy = document.selectSingleNode("/root/dynamic-element[@name='contributed_by']/dynamic-content");
		Node xPathShortDescr = document.selectSingleNode("/root/dynamic-element[@name='Short_Description']/dynamic-content");
		String contributedBy ="";
		String shortDescr = "";
		if(Validator.isNotNull(xPathContributedBy)){
			contributedBy = xPathContributedBy.getText();
		}
		String[] queryTerms = (String[]) request.getAttribute("queryTerms"); 
		if(Validator.isNotNull(xPathShortDescr)){
			shortDescr = xPathShortDescr.getText();
			shortDescr = StringUtil.highlight(shortDescr, queryTerms);
		}
		
		%>
		
		<liferay-ui:search-container-column-text name="Short Description" ><%=shortDescr%></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Contributed By" ><%=contributedBy%></liferay-ui:search-container-column-text>
		
		<%-- <liferay-ui:search-container-column-text property="userName" name="Created By"/> --%>
		
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator />
</liferay-ui:search-container>	

