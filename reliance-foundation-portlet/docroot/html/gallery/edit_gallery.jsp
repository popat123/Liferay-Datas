<%@include file="../init.jsp" %>


<portlet:renderURL var="backUrl" portletMode="view"></portlet:renderURL>
<liferay-ui:header title="Gallery" backURL="${backUrl}"></liferay-ui:header>



 <liferay-ui:search-container searchContainer="${gallerySearchContainer}">

       <liferay-ui:search-container-results results="${gallerySearchContainer.results}"  total="${gallerySearchContainer.total}" />

              <liferay-ui:search-container-row className="com.jio.portlet.gallery.model.Gallery" modelVar="gallery">

<%--                      <liferay-ui:search-container-column-text name="type" value="${gallery.type}" /> --%>
                     <liferay-ui:search-container-column-text name="title" value="${gallery.name}" />
                     <liferay-ui:search-container-column-text name="category" value="${gallery.mainCategory}" />
                     <liferay-ui:search-container-column-text name="videosImagPriority" value="${gallery.videosImagPriority}" />
                     <liferay-ui:search-container-column-text name="gallryImagPriority" value="${gallery.gallryImagPriority}" />
                     <liferay-ui:search-container-column-text name="isVideo" value="${gallery.isVideo}" />
                     <liferay-ui:search-container-column-text name="isIMG" value="${gallery.isIMG}" />
                     <liferay-ui:search-container-column-text>
                     
                     <portlet:renderURL var="editUrl">
                     	<portlet:param name="galleryId" value="${gallery.galleryId}"/>
                     	<portlet:param name="jspPage" value="/html/gallery/add_gallery.jsp"/>	
						<portlet:param name="cmd" value="update"/>
					 </portlet:renderURL>
					 
					 <portlet:actionURL var="deleteUrl" name="deleteGallery">
					 	<portlet:param name="galleryId" value="${gallery.galleryId}"/>
					 </portlet:actionURL>
                     
                     	<liferay-ui:icon image="edit" message="edit" url="${editUrl}"></liferay-ui:icon>
                     	<liferay-ui:icon image="delete" message="delete" url="${deleteUrl}"></liferay-ui:icon>
                     
<%--                      	<aui:button-row> --%>
<%--                      		<aui:button value="Update"></aui:button> --%>
<%--                      		<aui:button Value="Delete" name="delete"></aui:button> --%>
<%--                      	</aui:button-row> --%>
                     </liferay-ui:search-container-column-text>
                     
              </liferay-ui:search-container-row>
       <liferay-ui:search-iterator/>
</liferay-ui:search-container>