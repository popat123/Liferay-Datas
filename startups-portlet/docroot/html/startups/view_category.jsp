<%@include file="../init.jsp" %>

<section id="the-team">
	<div class="container">

<portlet:renderURL var="backUrl" portletMode="view" ></portlet:renderURL>
<liferay-ui:header title="Startups" backURL="${backUrl}"></liferay-ui:header>




	<c:forEach varStatus="cat" var="category" items="${categories}">
	
		<table border="1">
			<tr id="row${cat.index}">
				<td id="cat${cat.index}">${category}</td>
				
				<td id="action${cat.index}"> 
					<div id="update${cat.index}" style="    display: none;" >
						<liferay-ui:icon image="add" message="Update" url="javascript:updateCat(${cat.index})"></liferay-ui:icon>
					</div>
					<div id="edit${cat.index}">
						<liferay-ui:icon image="edit" message="edit"  url="javascript:editCat(${cat.index}, '${category}')"></liferay-ui:icon>
					</div>
					
	            	<liferay-ui:icon image="delete" message="delete" url="javascript:deleteCat(${cat.index})"></liferay-ui:icon>
	            	
				</td>
			</tr>
		</table>
	</c:forEach>
</div>
</section>

<script type="text/javascript">
	function editCat(id, name){
		$('#cat'+id).html('<input type="text" id="txt'+id+'" value='+name+' name="cat'+id+'" />')
		$('#update'+id).show();
		$('#edit'+id).hide();
	}
	
	function deleteCat(id){

		$.ajax({
			'url' : '<portlet:resourceURL/>',
			'type' : 'GET',
			'data': {
				'<portlet:namespace/>cmd':'delete',
				'<portlet:namespace/>id':id
			},
			'async': 'true',
			'cache': 'false',
			'dataType': 'json',
			'success' : function() {            
				$('#row'+id).remove();
			}
		});
		
		
	}
	function updateCat(id){
		var name = $("#txt"+id).val();
		alert(name);

		$.ajax({
			'url' : '<portlet:resourceURL/>',
			'type' : 'GET',
			'data': {
				'<portlet:namespace/>cmd':'update',
				'<portlet:namespace/>name':name,
				'<portlet:namespace/>id':id
			},
			'async': 'true',
			'cache': 'false',
			'dataType': 'json',
			'success' : function() {            
				$('#cat'+id).html(name);
				$('#update'+id).hide();
				$('#edit'+id).show();
			}
		});
		
		
		
		
	
	}
</script>
