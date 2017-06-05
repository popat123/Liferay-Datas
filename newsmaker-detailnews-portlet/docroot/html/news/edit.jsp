<%@include file="../init.jsp" %>


<portlet:actionURL name="addPreference" var="setStructure" />

<aui:form action="${setStructure}"  method="post" name="fm">

<aui:select name="structureId" label="lbl.select.structure">
			<aui:option value="" selected="true" label=""/>
			<c:forEach items="${ddmStructures}" var="structure">
				<aui:option value="${structure.structureId}">${structure.nameCurrentValue}</aui:option>
			</c:forEach>
</aui:select>
<aui:button-row>
    	<aui:button type="submit" value="Save"/>
</aui:button-row>
</aui:form>