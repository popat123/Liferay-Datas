<%@include file="../init.jsp" %>


<portlet:renderURL var="backUrl" portletMode="view"></portlet:renderURL>
<liferay-ui:header title="Jurys" backURL="${backUrl}"></liferay-ui:header>

<liferay-ui:search-container searchContainer="${jurysSearchContainer}">

       <liferay-ui:search-container-results results="${jurysSearchContainer.results}"  total="${jurysSearchContainer.total}" />

              <liferay-ui:search-container-row className="com.jio.portlet.jurys.model.Jurys" modelVar="jurys">

                     <liferay-ui:search-container-column-text name="name" value="${jurys.name}" />
                     <liferay-ui:search-container-column-text name="companyName" value="${jurys.companyName}" />
                     <%-- <liferay-ui:search-container-column-text name="category" value="${jurys.category}" /> --%>
                    
                     <portlet:renderURL var="editUrl">
                     	<portlet:param name="jurysId" value="${jurys.jurysId}"/>
                     	<portlet:param name="jspPage" value="/html/jurys/add_edit.jsp"/>	
						<portlet:param name="cmd" value="update"/>
					 </portlet:renderURL>
                    
                     <portlet:actionURL var="deleteUrl" name="deleteJury">
					 	 <portlet:param name="jurysId" value="${jurys.jurysId}"/>
					 </portlet:actionURL>
					 
                     <liferay-ui:search-container-column-text>
                     
                     	<liferay-ui:icon image="edit" message="edit" url="${editUrl}"></liferay-ui:icon>
                     	<liferay-ui:icon image="delete" message="delete" url="${deleteUrl}"></liferay-ui:icon>
                     	
                     
                     
                     </liferay-ui:search-container-column-text>
                     
              </liferay-ui:search-container-row>
       <liferay-ui:search-iterator/>
</liferay-ui:search-container>