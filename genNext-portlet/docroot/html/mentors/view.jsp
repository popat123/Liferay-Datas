<%@include file="../init.jsp" %>

<portlet:renderURL var="addMentorsURL">
	<portlet:param name="mvcPath" value="/html/mentors/add_edit.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="viewMentorsURL">
	<portlet:param name="mvcPath" value="/html/mentors/display_mentor.jsp"/>
</portlet:renderURL>

<%-- <portlet:renderURL var="viewCategoryURL">
	<portlet:param name="mvcPath" value="/html/mentors/view_category.jsp" />
</portlet:renderURL> --%>



<section id="mentors">
	<c:if test="${permissionCheck}">
		<aui:button type="button" value="Add" onClick="${addMentorsURL}"></aui:button>
		<aui:button type="button" value="View" onClick="${viewMentorsURL}"></aui:button>
		<%-- <aui:button type="button" value="view-category" onClick="${viewCategoryURL}"></aui:button> --%>
	</c:if>
       <div id="top" class="callbacks_container">
           <div class="container">
               <div class="row">
                   <div class="col-sm-offset-4 col-sm-4">
                       <h2><img src="/genNext-theme/images/img/a-bg.png" alt="">Mentors</h2>
                   </div>
                   <div class="col-sm-offset-1 col-sm-3">
                       <select class="leadership">
							<c:forEach var="category" items="${categories}">
								<option value="${category}">${category}</option>
							</c:forEach>                       	
                       </select>
                   </div>
               </div>
			<div class="row">
               <ul class="unstyled isotope no-transition clearfix" id="galleryContainer">
                                                                                                                                                                              
               </ul>                
           	</div>
           </div>
       </div>
</section>

<div class="modal fade startup-modal" id="popup" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	        <button type="button" class="close top-fix" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <!-- Startup Row -->
	        <div class="row startup-row">
	            <div class="col-xs-3 text-center">
	                <img src="">
	            </div>
	            <div class="col-xs-9 mentors top-padding">
	                <h3></h3>
	                <p id="shortDesc"></p>
	                <p id="expertise"></p>
	            </div>
	        </div>
	        <!-- Startup Desc -->
	        <div class="startup-desc">
	            <p id="longDesc"></p>
	        </div>
	    </div>
	</div>
</div>


<script>

$( function()
{
	var $window = $(window),
				$document = $(document),
				allObjectArr = [],
				mainCategoryFilter = 'all',
				currentClickFilter = 'all',
				currentActiveArr = [],
				videoArr = [],
				mentorImageArr = [],
				theTeamImageArr = [],
				noOfImgTOLoad = 0,
				output,
				loadImgCounter = 0,
				jasonObj,
				$clickedImg,
				tilePopupBigImage,
				imageListPath,
				isVideo,
				isYouTubeLink = false,
				isSWF,
				imageListArr,
				isVideoPopUpClosed = false,
				popupCaption,
				backDrop = $('div.backdrop'),
				$demoLiveLinkDuplicate,
				current_scroll_top = 0,
				filters,
				$container
	  
	  /*console.log("Main page filter: "+ pageName +" --- "+ filterToApply);*/	  

	  var $container = $('#galleryContainer').isotope({
		itemSelector: '.project',
		
		getSortData: {		 
		  number: '.number parseInt',		  
		},
		animationEngine: 'css'
		/* transitionDuration: 0, */
	  });
	
  /* Select Picker */
	$(".leadership").change( getVals );
  


/*  3.1  Fetching Data from JSON
	For mainOffice Icon position */
	  $.ajax({
		'url' : '<portlet:resourceURL/>',
		'type' : 'GET',
		'data': 'values',
		'async': 'true',
		'cache': 'false',
		'dataType': 'json',
		'success' : function(data) {
			
			 /* For Random Images */
			$.each(data["mentorImage"], function() {	
				
				jasonObj = {					
					thumbnailName:this.thumbnailName,
					name:this.name,
					CompanyName:this.CompanyName,
					category: this.Category,
					projectImagesPath:this.projectImagesPath,
					shortDescription:this.shortDescription,
					longDescription:this.longDescription,
					number: this.number
				}				
				mentorImageArr.push(jasonObj);
			});			
			
			currentActiveArr = mentorImageArr;
			
			changeCurrentArr();
			
			/*var $items = getItems();
		    $container.isotopeImagesReveal( $items );*/
			
			console.log("Data: "+data);
			
		},
		'error' : function(request,error)
		{
		  console.log("Request: "+JSON.stringify(error));
		}
	});
	
	$.fn.isotopeImagesReveal = function( $items ) {
	  var iso = this.data('isotope');
	  
	  var itemSelector = iso.options.itemSelector;
	  /*  hide by default */
	  $items.hide();
	  /*  append to container */
	  $container.append( $items );
	  $items.imagesLoaded().progress( function( imgLoad, image ) {
		 /* get item
		    image is imagesLoaded class, not <img>, <img> is image.img */
		var $item = $( image.img ).parents( itemSelector );
		/*  un-hide item */
		$item.show();
		/*  isotope does its thing */
		( $item ).appendTo('ul.isotope');
		
		iso.appended( $item );
		
		/* $container.isotope({ filter: ('.all'), sortBy : 'number', sortAscending : false }); */		
		$container.isotope({ filter: ('.All'), sortBy : 'number', sortAscending : false});		
		
		 /*  Trace on which tile is clicked */				 
		 $('div.vidtile').off('click').bind('click', function(e)
		 {	
			 debugger;
			e.preventDefault();			
			
			imageListPath = $(this).parent().attr('data-url');

			$clickedImg = $(this);
			
			 /* console.log("img path: " + $clickedImg.find("p#longDescCont").text()+" --- "+$clickedImg.find('img').attr('src')+" --- "+$clickedImg.find('p.mainCategory').text()); */ 

			popupCaption = $clickedImg.parent().find('h3').text();
			
			$('#popup').find('img').attr('src', $clickedImg.find('img').attr('src'));
			$('#popup').find('h3').html($clickedImg.find('h3').text());
			$('#popup').find('p#shortDesc').html($clickedImg.find('p.mainCategory').text());
			$('#popup').find('p#longDesc').html($clickedImg.find("p#longDescCont").text());
			$('#popup').find('p#expertise').html("Expertise : " + $clickedImg.find("p.category").text());
			
			 /* showPOP_UP(); */ 			
		});
		
	  });
	  
	  return this;
	};
	
	function getItem(elementObj) 
	{	  
        var item;
		var tmpCategoryStr = (elementObj.category).replace(/ /g, '').replace(/,/g, ' ').replace(/&/g, '');
		
		console.log("tmpCategoryStr: "+tmpCategoryStr);
		
		/* item = '<li class= "project all" data-url="' + elementObj.projectImagesPath + '">'; */
		item = '<li class= "project All no-transition ' + tmpCategoryStr + '" data-url="' + elementObj.projectImagesPath + '">';
		item += '<div class="vidtile">';		
		item += '<a href="#popup" data-toggle="modal">';
		item += '<img src="'+elementObj.projectImagesPath+'" alt="'+ elementObj.name +'" class="imgLoaded"/></a>';
		item += '<p class="number hiddens">' + parseInt(elementObj.number) +'</p>';
		item += '<p id="longDescCont" class="hiddens">' + elementObj.longDescription +'</p>';
		item += '<h3>' + elementObj.name + '</h3>';
		item += '<div class="about-project clear">';
		item += '<p class="companyName">' + elementObj.CompanyName +'</p>';
		item += '<p class="mainCategory hiddens">' + elementObj.shortDescription +'</p>';
		item += '<p class="category hiddens">' + elementObj.category +'</p>';
		item += '</div></div>';
		item += '</li>';
		  
	    return item;
	}
	
	function getItems() {
	  var items = '';
	  for ( var i=0; i < noOfImgTOLoad; i++ ) {
		items += getItem(currentActiveArr[i]);
	  }
	  /*  return jQuery object */
	  return $( items );
	}
	
	
/*  Change selection as per dropdown */	
	function getVals()
	{
		/* currentClickFilter = $(".leadership").val().replace(/ /g, '').toLowerCase(); */
		
		currentClickFilter = $(".leadership").val().replace(/ /g, '').replace(/&/g, '');
		
		console.log("currentClickFilter: "+currentClickFilter);
				
		/* $container.isotope({ filter: ('.'+currentClickFilter), sortBy : 'number', sortAscending : false }); */		
		$container.isotope({ filter: ('.'+currentClickFilter), sortBy : 'number', sortAscending : false });
	}	
	
	

		
		$('#videos').click(function()
		{	
			/* console.log("Video tab clicked!!!"); */
			
			filterToApply = $(this).attr('data-filter');
			
			$(this).addClass('active');
			$('#photos').removeClass('active');
			
			changeCurrentArr();
		});
		
		$('#photos').click(function()
		{	
			/* console.log("Photos tab clicked!!!"); */
			filterToApply = $(this).attr('data-filter');
			
			$(this).addClass('active');
			$('#videos').removeClass('active');
			
			changeCurrentArr();
		});
		
		function changeCurrentArr()
		{
			noOfImgTOLoad = currentActiveArr.length;
			
			$container.isotope( 'remove', $('.project'));
			
			var $items = getItems();
		    $container.isotopeImagesReveal( $items );
		}
});

</script>