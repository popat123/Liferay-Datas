<%@include file="../init.jsp" %>

<portlet:actionURL name="addPreference" var="displayVideo" />

<aui:form action="${displayVideo}" method="post" name="fm">
	<aui:input name="homeDisplayStyle" label="lbl.home.display"></aui:input>
	<aui:input name="galleryDisplayStyle" label="lbl.gallery.display"></aui:input>
	<aui:button type="submit" value="Save"></aui:button>
</aui:form>
