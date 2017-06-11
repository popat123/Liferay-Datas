<%@include file="../init.jsp" %>

<section id="the-team">
	<div class="container">

<portlet:renderURL var="backUrl" portletMode="view" ></portlet:renderURL>
<liferay-ui:header title="Startups" backURL="${backUrl}"></liferay-ui:header>

<portlet:actionURL var="actionURL" name="addStartups" />

<aui:model-context bean="${startups}" model="<%= Startups.class %>" />
<aui:form action="${actionURL}" name="fm" enctype="multipart/form-data">

	<aui:input name="startupsId" type="hidden" />
	
	<aui:input name="name" />

	<aui:input name="companyName" label="lbl.companyName" />
		
	<aui:select name="category" label="category-title" required="true">
		<aui:option label="other" value="other"/>
		<c:forEach var="category" items="${categories}">
			<option value="${category}">${category}</option>
		</c:forEach>
	</aui:select>

	<div id='<portlet:namespace/>categoryOther'>
		<aui:input name="newCategory" type="text">
			<aui:validator name="custom" errorMessage="category-required">
				function(val, fieldNode, ruleValue) { 
					var category = document.getElementById('<portlet:namespace/>category');
					var otherCategory = category.value; 
					if(otherCategory == "other" && val.length == 0){
						return false;
					}else{	
						return true;
					}
						
				}
			</aui:validator>
		</aui:input>
	</div>	
		
<%-- 	<aui:input name="category"> --%>
<%-- 		<aui:validator name="required"></aui:validator> --%>
<%-- 	</aui:input> --%>
	<aui:row>
		<aui:col span="4">
			<aui:input type="file" name="startupImage" label="lbl.startupImage">
				<c:if test="${empty startups}">
				    <aui:validator name="required"></aui:validator>
					<aui:validator name="acceptFiles">'jpeg,jpg,png'</aui:validator>
					<aui:validator name="custom" errorMessage="Please enter a file with a valid file size no larger than-100KB">
		               function(val, fieldNode, ruleValue) {
		     
			              var uploadedFile  = document.getElementById('<portlet:namespace/>startupImage');
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
		</aui:col>
	
		<aui:col span="4">
			<c:if test="${not empty startups}">
			 	<img name="startupimg" src="${startupURL}"/>
			 </c:if>
		</aui:col>
	</aui:row>
	
	<aui:row>
		<aui:col span="4">
			<aui:input type="file" name="youtubeImages" id="youtubeImages" label="lbl.youtubeImages">
			<aui:validator name="acceptFiles">'jpeg,jpg,png'</aui:validator>
			<aui:validator name="custom" errorMessage="Please enter a file with a valid file size no larger than-100KB">
		     function(val, fieldNode, ruleValue) {
		     
			     var uploadedFile  = document.getElementById('<portlet:namespace/>youtubeImages');
			     var fileSize = uploadedFile.files[0].size; 
			      var result = true;
			      if(fileSize > 102400) 
                   {
                     result=false;
					}					
			        return result;
		           }
		      </aui:validator>
		    </aui:input>  
		</aui:col>
		<aui:col span="4">
			<c:if test="${not empty startups}">
			 	<img name="youtubeimg" src="${youtubeURL}"/>
			 </c:if>
		</aui:col>
	</aui:row>
	
	
	<aui:input name="youtubeLink" id="youtubeLink" label="lbl.youtubeLink">
		<aui:validator name="custom" errorMessage="youtube-link-required">
		function(val, fieldNode, ruleValue) { 
			var youtubeImage = document.getElementById('<portlet:namespace/>youtubeImages');
			var youtube = youtubeImage.value; 
			
				if(youtube.length != 0){
					var regExpYoutube = /^.*((youtu.be\/)|(v\/)|(\/u\/\w\/)|(embed\/)|(watch\/)|(\?v=|\&v=))([^#\&\?]*).*/;                   	
					if(val.length != 0 && val.match(regExpYoutube)){
						return true;
					}else{
						return false;
					}
				
				}else{
					return true;
				}
		}
		</aui:validator>
	</aui:input>
	<aui:input name="shortDescription" />
	<aui:input type="textarea" name="startupDesc" label="lbl.startupDesc"/>
		
	<%-- <aui:input type="textarea" name="longDescription" /> --%>
	
	<aui:input name="twitter" />
	<aui:input name="linkedIn" label="lbl.linkedIn" />
	<aui:input name="youTube" label="lbl.youTube" >
		<aui:validator name="custom" errorMessage="youtube-link-required">
		function(val, fieldNode, ruleValue) { 
			var youtubeImage = document.getElementById('<portlet:namespace/>youtubeImages');
			var youtube = youtubeImage.value; 
			
				if(youtube.length != 0){
					var regExpYoutube = /^.*((youtu.be\/)|(v\/)|(\/u\/\w\/)|(embed\/)|(watch\/)|(\?v=|\&v=))([^#\&\?]*).*/;                   	
					if(val.length != 0 && val.match(regExpYoutube)){
						return true;
					}else{
						return false;
					}
				
				}else{
					return true;
				}
		}
		</aui:validator>
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


<script>

$("#<portlet:namespace/>categoryOther").hide();
	
if($("#<portlet:namespace/>category").val() == "other"){	
	$("#<portlet:namespace/>categoryOther").show();
}else{
	$("#<portlet:namespace/>categoryOther").hide();
}

$("#<portlet:namespace/>category").change(function(){
	if($(this).val() == "other"){	
		$("#<portlet:namespace/>categoryOther").show();
		
	}else{
		$("#<portlet:namespace/>categoryOther").hide();
		$("#<portlet:namespace/>newCategory").val("");
	}
});


</script>