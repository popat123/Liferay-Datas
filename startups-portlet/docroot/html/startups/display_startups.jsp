<%@include file="../init.jsp" %>

<portlet:renderURL var="backUrl" portletMode="view"></portlet:renderURL>
<liferay-ui:header title="Startups" backURL="${backUrl}"></liferay-ui:header>


<liferay-ui:search-container searchContainer="${startupsSearchContainer}">

       <liferay-ui:search-container-results results="${startupsSearchContainer.results}"  total="${startupsSearchContainer.total}" />

              <liferay-ui:search-container-row className="com.jio.portlet.startups.model.Startups" modelVar="startups">

                     <liferay-ui:search-container-column-text name="name" value="${startups.name}" />
                     <liferay-ui:search-container-column-text name="companyName" value="${startups.companyName}" />
                     <liferay-ui:search-container-column-text name="category" value="${startups.category}" />
                    
                     <portlet:renderURL var="editUrl">
                     	<portlet:param name="startupsId" value="${startups.startupsId}"/>
                     	<portlet:param name="startupImage" value="${startups.startupImage}"/>
                     	<portlet:param name="youtubeImages" value="${startups.youtubeImages}"/>
                     	<portlet:param name="jspPage" value="/html/startups/add_edit.jsp"/>	
						<portlet:param name="cmd" value="update"/>
					 </portlet:renderURL>
                    
                     <portlet:actionURL var="deleteUrl" name="deleteStartups">
					 	 <portlet:param name="startupsId" value="${startups.startupsId}"/>
					 </portlet:actionURL>
					 
                     <liferay-ui:search-container-column-text>
                     
                     	<liferay-ui:icon image="edit" message="edit" url="${editUrl}"></liferay-ui:icon>
                     	<liferay-ui:icon image="delete" message="delete" url="${deleteUrl}"></liferay-ui:icon>
                     
                     </liferay-ui:search-container-column-text>
                     
              </liferay-ui:search-container-row>
       <liferay-ui:search-iterator/>
</liferay-ui:search-container>