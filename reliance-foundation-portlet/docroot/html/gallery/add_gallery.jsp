<%@include file="../init.jsp" %>

<section class="fullwidth gallery clearfix">
<div class="wrap">
<portlet:renderURL var="backUrl" portletMode="view"></portlet:renderURL>
<liferay-ui:header title="Gallery" backURL="${backUrl}"></liferay-ui:header>

<portlet:actionURL var="formActionUrl" name="addGallery">	
</portlet:actionURL>

<liferay-ui:error key="select-photo" message="select photo"></liferay-ui:error>
<aui:model-context bean="${gallery}" model="<%= Gallery.class %>" />
<aui:form action="${formActionUrl}" method="POST" name="fm" enctype="multipart/form-data">
	
	
	<aui:input name="galleryId" type="hidden"></aui:input>
<%-- 	<aui:select name="type" label="lbl.type"> --%>
<%-- 		<aui:option value="" /> --%>
<%-- 		<c:forEach var="type" items="${types}"> --%>
<%-- 			<aui:option value="${type}">${type}</aui:option> --%>
<%-- 		</c:forEach> --%>
		
<%-- 	</aui:select> --%>
<%-- 	<aui:input name="type" label="lbl.type"></aui:input> --%>
<%-- 	<aui:input name="thumbnailName" label="lbl.thumbnailName"></aui:input> --%>
		<aui:input name="name" label="lbl.name">
			<aui:validator name="required"></aui:validator>
		</aui:input>
<%-- 	<aui:input name="mainCategory" label="lbl.mainCategory"></aui:input> --%>
	<aui:select name="mainCategory" label="lbl.mainCategory" required="true">
		<aui:option value="" label="select-category" />
		<c:forEach var="type" items="${types}">
			<aui:option value="${type}">${type}</aui:option>
		</c:forEach>
		
	</aui:select>
	
	<label><liferay-ui:message key="lbl.select-Video-And-Image"></liferay-ui:message></label>
	<aui:row>
	<aui:input type="checkbox" id="isVideo" name="isVideo" label="lbl.isVideo" value="${gallery.isVideo}" inlineField="true"></aui:input>
	<div id="isVideo" style="display:none">
		<aui:input type="file" id="videoImagesPath" name="videoImagesPath" label="lbl.videoImage"></aui:input>
		<aui:input type="checkbox" id="youTubeLink" name="youTubeLink" label="lbl.youTubeLink" value="${gallery.youTubeLink}"></aui:input>
		<div id="errYoutube" class="alert alert-error">This field is required.</div>
		<aui:input id="projectImagesPath" name="projectImagesPath" label="lbl.videoLink">
<%-- 			  <aui:validator name="url" /> --%>
			 <%-- <aui:validator name="required" /> --%>
			 
			  <aui:validator name="custom"  errorMessage="enter-valid-youtube-url" >
              	function (val, fieldNode, ruleValue) {
					debugger;
		   		    var result = true;
		   		    var A = AUI();
	                if(A.one('#<portlet:namespace/>'+'youTubeLinkCheckbox').get("checked")){
	                                         
	                	if (val!="") {
	                	    var regExpYoutube = /^.*((youtu.be\/)|(v\/)|(\/u\/\w\/)|(embed\/)|(watch\/)|(\?v=|\&v=))([^#\&\?]*).*/;                   	
		   		    		var match = val.match(regExpYoutube);	    	
							if(match && match[8].length == 11){
								result = true;							
							} else{						 
								result =false;							
							}   			       
					   	}else{
					   		result =false;
					   	}
	            	 }
	            	 return result;
	            }
             </aui:validator>
              <aui:validator name="custom"  errorMessage="please-enter-a-valid-url">
                function (val, fieldNode, ruleValue){
           
                       debugger;
                       var result = true;
                        var A = new AUI();
                            if(A.one('#<portlet:namespace/>'+'isVideoCheckbox').get("checked")){

                                  if(A.one('#<portlet:namespace/>'+'youTubeLinkCheckbox').get("checked") == false){
                                                                                                                                                                             var pattern = /^(ftp|http|https):\/\/[^ "]+$/;
                                          var pattern = /^(ftp|http|https):\/\/[^ "]+$/;
                                          
                                          if(pattern.test(val)){
                                             	result = true;                                                                                                                    result = true;
                                           }else{
                                             	result = false;
                                           }
                               	   }
                           	}                                                                                                                                                                             
                            return result;            
              	}
        </aui:validator> 
<%--         <aui:validator name="required" />     --%>
		</aui:input>		
		<c:if test="${videoFlag or gallery.videosImagPriority == true}">
		<aui:input type="checkbox" id="videosImagPriority" name="videosImagPriority" label="lbl.videosImagPriority" value="${gallery.videosImagPriority}"></aui:input>
		</c:if>		
	</div>
	
	<aui:input type="checkbox" id="isIMG" name="isIMG" label="lbl.isIMG" value="${gallery.isIMG}" inlineField="true"></aui:input>
	<div id="isImage" style="display:none">
		<aui:input type="file" name="galleryImagesPath" label="lbl.galleryImage"></aui:input>
		<aui:input type="file" name="thumbnailImagesPath" label="lbl.thumbnailImage"></aui:input>
		<c:if test="${imageFlag or gallery.gallryImagPriority == true}">
		<aui:input type="checkbox" id="gallryImagPriority" name="gallryImagPriority" label="lbl.gallryImagPriority" value="${gallery.gallryImagPriority}"></aui:input>
		</c:if>
	</div>
	</aui:row>
	
	<aui:button-row>
		<aui:button type="submit" value="Submit"></aui:button>
		<aui:button type="reset"></aui:button>
	</aui:button-row>
</aui:form>
</div>
</section>
<script>
$(function(){
	$('#errYoutube').hide();
	/* isVideo show in onChange */
	$('#<portlet:namespace/>'+'isVideoCheckbox').change(function(){
		$('#<portlet:namespace/>'+'isVideo').val($('#<portlet:namespace/>'+'isVideoCheckbox').is(":checked"));
		if($('#<portlet:namespace/>'+'isVideoCheckbox').is(":checked")){
			$("#isVideo").show();
			$('#<portlet:namespace/>'+'isIMGCheckbox').parent().hide();
			<c:if test='${empty gallery}' >
				$('#<portlet:namespace/>'+"videoImagesPath").attr("required","true");
			</c:if>
		}else {
            $("#isVideo").hide();
            $('#<portlet:namespace/>'+'isIMGCheckbox').parent().show();
            $('#<portlet:namespace/>'+"videoImagesPath").removeAttr("required");
        }
		
	});
	/* isVideo show in pageload */
	if($('#<portlet:namespace/>'+'isVideoCheckbox').is(":checked")){
		$("#isVideo").show();
		$('#<portlet:namespace/>'+'isIMGCheckbox').parent().hide();
		<c:if test='${empty gallery}' >
			$('#<portlet:namespace/>'+"videoImagesPath").attr("required","true");
		</c:if>
	}
	/* isImage show in onChange */
	$('#<portlet:namespace/>'+'isIMGCheckbox').change(function(){
		$('#<portlet:namespace/>'+'isIMG').val($('#<portlet:namespace/>'+'isIMGCheckbox').is(":checked"));
		if($('#<portlet:namespace/>'+'isIMGCheckbox').is(":checked")){
			$("#isImage").show();
			$('#<portlet:namespace/>'+'isVideoCheckbox').parent().hide();
			<c:if test='${empty gallery}' >
				$('#<portlet:namespace/>'+"galleryImagesPath").attr("required","true");
				$('#<portlet:namespace/>'+"thumbnailImagesPath").attr("required","true");
			</c:if>
		}else {
            $("#isImage").hide();
            $('#<portlet:namespace/>'+'isVideoCheckbox').parent().show();
            $('#<portlet:namespace/>'+"galleryImagesPath").removeAttr("required");
			$('#<portlet:namespace/>'+"thumbnailImagesPath").removeAttr("required");
        }
	});
	/* isImage show in pageload */
	if($('#<portlet:namespace/>'+'isIMGCheckbox').is(":checked")){
		$("#isImage").show();
		$('#<portlet:namespace/>'+'isVideoCheckbox').parent().hide();
		<c:if test='${empty gallery}' >
			$('#<portlet:namespace/>'+"galleryImagesPath").attr("required","true");
			$('#<portlet:namespace/>'+"thumbnailImagesPath").attr("required","true");
		</c:if>
	}
	
	$('#<portlet:namespace/>'+'youTubeLinkCheckbox').change(function(){
		$('#<portlet:namespace/>'+'youTubeLink').val($('#<portlet:namespace/>'+'youTubeLinkCheckbox').is(":checked"));
		
	});
	
	$('#<portlet:namespace/>'+'videosImagPriorityCheckbox').change(function(){
		$('#<portlet:namespace/>'+'videosImagPriority').val($('#<portlet:namespace/>'+'videosImagPriorityCheckbox').is(":checked"));
	});
	
	
	$('#<portlet:namespace/>'+'gallryImagPriorityCheckbox').change(function(){
		$('#<portlet:namespace/>'+'gallryImagPriority').val($('#<portlet:namespace/>'+'gallryImagPriorityCheckbox').is(":checked"));
	});
});
</script>

