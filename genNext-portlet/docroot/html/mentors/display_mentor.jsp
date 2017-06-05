<%@include file="../init.jsp" %>


<portlet:renderURL var="backUrl" portletMode="view"></portlet:renderURL>
<liferay-ui:header title="Mentors" backURL="${backUrl}"></liferay-ui:header>

<liferay-ui:search-container searchContainer="${mentorsSearchContainer}">

       <liferay-ui:search-container-results results="${mentorsSearchContainer.results}"  total="${mentorsSearchContainer.total}" />

              <liferay-ui:search-container-row className="com.jio.portlet.mentors.model.Mentors" modelVar="mentors">

                     <liferay-ui:search-container-column-text name="name" value="${mentors.name}" />
                     <liferay-ui:search-container-column-text name="companyName" value="${mentors.companyName}" />
                     <liferay-ui:search-container-column-text name="category" value="${mentors.category}" />
                    
                     <portlet:renderURL var="editUrl">
                     	<portlet:param name="mentorsId" value="${mentors.mentorsId}"/>
                     	<portlet:param name="jspPage" value="/html/mentors/add_edit.jsp"/>	
						<portlet:param name="cmd" value="update"/>
					 </portlet:renderURL>
                    
                     <portlet:actionURL var="deleteUrl" name="deleteMentor">
					 	 <portlet:param name="mentorsId" value="${mentors.mentorsId}"/>
					 </portlet:actionURL>
					 
                     <liferay-ui:search-container-column-text>
                     
                     	<liferay-ui:icon image="edit" message="edit" url="${editUrl}"></liferay-ui:icon>
                     	<liferay-ui:icon image="delete" message="delete" url="${deleteUrl}"></liferay-ui:icon>
                     
                     </liferay-ui:search-container-column-text>
                     
              </liferay-ui:search-container-row>
       <liferay-ui:search-iterator/>
</liferay-ui:search-container>