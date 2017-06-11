<%@include file="../init.jsp" %>

<liferay-ui:success key="calendarPreferences-added-successfully" message="calendarPreferences-added-successfully" />
<portlet:actionURL name="addPrefernce" var="statusURL" />

<aui:form action='<%= statusURL %>' method="post" name="fm">

	<aui:select name="statusPreference" label="calendarView" inlineLabel="left">
		<c:choose>
			<c:when test='${statusPreference == "currentSite" }'>
				<aui:option value="currentSite" selected="true"><liferay-ui:message key="currentsite" /></aui:option>
				<aui:option value="everything" ><liferay-ui:message key="everyThing" /></aui:option>
			</c:when>
			<c:when test='${statusPreference == "everything" }'>
				<aui:option value="currentSite" ><liferay-ui:message key="currentsite" /></aui:option>
				<aui:option value="everything" selected="true"><liferay-ui:message key="everyThing" /></aui:option>
			</c:when>
			<c:otherwise>
				<aui:option value="currentSite" ><liferay-ui:message key="currentsite" /></aui:option>
				<aui:option value="everything" ><liferay-ui:message key="everyThing" /></aui:option>
			</c:otherwise>
		</c:choose>
	</aui:select><br />

	<aui:button-row>
       <aui:button type="submit" />
    </aui:button-row>
</aui:form>