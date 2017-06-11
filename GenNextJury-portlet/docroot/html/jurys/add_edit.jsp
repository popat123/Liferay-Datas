<%@include file="../init.jsp" %>


<section id="the-team">
	<div class="container">

<portlet:renderURL var="backUrl" portletMode="view"></portlet:renderURL>
<liferay-ui:header title="Jurys" backURL="${backUrl}"></liferay-ui:header>

<portlet:actionURL var="actionURL" name="addJurys">
</portlet:actionURL>

<aui:model-context bean="${jurys}" model="<%=Jurys.class %>" />
<aui:form action="${actionURL}" name="fm" enctype="multipart/form-data">

	<aui:input name="jurysId" type="hidden">
	</aui:input>
	<aui:input name="name">
		<aui:validator name="required"></aui:validator>
		<aui:validator name="alpha"/>
	</aui:input>
	<aui:input name="companyName" label="lbl.companyName">
		<aui:validator name="required"></aui:validator>
	</aui:input>
	<aui:input name="category" type="hidden">
		<%-- <aui:validator name="required"></aui:validator> --%>
	</aui:input>
	<aui:input type="file" name="juryImage" label="lbl.juryImage">
		<c:if test="${empty jurys}">
			<aui:validator name="required"></aui:validator>
			<aui:validator name="acceptFiles">'jpeg,jpg,png'</aui:validator>
			<aui:validator name="custom" errorMessage="Please enter a file with a valid file size no larger than-100KB">
		    function(val, fieldNode, ruleValue) {
		     
			     var uploadedFile  = document.getElementById('<portlet:namespace/>juryImage');
			     var fileSize = uploadedFile.files[0].size; 
			      var result = true;
			      if(fileSize > 102400) 
                   {
                     result=false;
					}					
			        return result;
		           }
		      </aui:validator>
		</c:if>
	</aui:input>
	<aui:input name="shortDescription">
		<aui:validator name="required"></aui:validator>
	</aui:input>
	<aui:input type="textarea" name="longDescription">
		<aui:validator name="required"></aui:validator>
	</aui:input>
	<aui:input type="text" name="number">
		<aui:validator name="required"></aui:validator>
		<aui:validator name="number"></aui:validator>
	</aui:input> 
	
	<aui:row>
		<aui:button type="submit"></aui:button>
		<aui:button type="reset"></aui:button>
	</aui:row>
</aui:form>
</div>
</section>