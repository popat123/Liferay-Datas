<%@include file="../init.jsp" %>

<liferay-ui:success key="Startups-updated" message="Startups-updated" />
<liferay-ui:success key="Startups-added" message="Startups-added" />
<liferay-ui:success key="startups-deleted" message="startups-deleted" />
<liferay-ui:success key="error-startups-deleted" message="error-startups-deleted" />

<portlet:renderURL var="addStartupsURL">
	<portlet:param name="mvcPath" value="/html/startups/add_edit.jsp"/>
	<portlet:param name="cmd" value="/html/startups/add_edit.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="viewStartupsURL">
	<portlet:param name="mvcPath" value="/html/startups/display_startups.jsp"/>
	<portlet:param name="cmd" value="/html/startups/display_startups.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="viewCategoryURL">
	<portlet:param name="mvcPath" value="/html/startups/view_category.jsp" />
</portlet:renderURL>


<section id="mentors">
	<c:if test="${permissionCheck}">
		<aui:button type="button" value="Add" onClick="${addStartupsURL}"></aui:button>
		<aui:button type="button" value="View" onClick="${viewStartupsURL}"></aui:button>
		<aui:button type="button" value="view-category" onClick="${viewCategoryURL}"></aui:button>
	</c:if>
        <div id="top" class="callbacks_container">
           <div class="container">
               <div class="row">
                   	<div class="col-sm-offset-4 col-sm-4">
                    	<h2><img src="/genNext-theme/images/img/a-bg.png" alt="">START UPS</h2>
                   	</div>
                   	<div class="col-sm-offset-1 col-sm-3">
                       <select class="leadership">
                       		<option>All</option>
                           <c:forEach var="category" items="${categories}">
								<option value="${category}">${category}</option>
							</c:forEach>
                       </select>
                   	</div>
               	</div>
			   	<div class="row">
	                <ul class="unstyled isotope no-transition clearfix" id="startupcontainer">
		
					</ul>  
	                <div id="partners"> </div>         
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
                    <div class="col-xs-6">
                        <img class="mainImg img-responsive" src="" >
                    </div>
                    <div class="col-xs-6 text-right">
                        <a href="" target="_blank" id="youTubelink">
                            <img class="ytimg img-responsive" alt="" src="" id="ytimg1" />
                        </a> 
                        
                    </div>
                </div>
                <!-- Startup Desc -->
                <div class="startupdesc">
                    <p id="startupDesc"></p>
                </div>
                <div class="startup-icons">
                    <a href="" target="_blank" id="linkedInlink"><i class="fa fa-link"></i></a>
                    <a href="" target="_blank" id="twitterlink"><i class="fa fa-twitter"></i></a>
                    <!--<a href="" target="_blank" id="youTubelink"><i class="fa fa-youtube-play"></i></a>-->
                </div>
            </div>
        </div>
    </div>



<script>

//JavaScript Document

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
				startupImageArr = [],
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
	  
	  //console.log("Main page filter: "+ pageName +" --- "+ filterToApply);	  

	  var $container = $('#startupcontainer').isotope({
		itemSelector: '.project',
		/*cellsByRow: {
			//columnWidth: 240,
			rowHeight: 500
		},*/
		/*layoutMode: 'fitRows',
		masonry: {
		  columnWidth: 285  
		},*/
		getSortData: {		 
		  number: '.number parseInt',		  
		},
		animationEngine: 'css',
		//transitionDuration: 0,
	  });
	
// Select Picker
	$(".leadership").change( getVals );
  


//  3.1  Fetching Data from JSON
// For mainOffice Icon position
	  $.ajax({
		'url' : '<portlet:resourceURL/>',
		'type' : 'GET',
		'data': 'values',
		'async': 'true',
		'cache': 'false',
		'dataType': 'json',
		'success' : function(data) {
			
			// For Random Images
			$.each(data["mentorImage"], function() {	
				
				jasonObj = {					
					thumbnailName:this.thumbnailName,
					name:this.name,
					CompanyName:this.CompanyName,
					category: this.Category,
					projectImagesPath:this.projectImagesPath,
					youtubeImagesPath:this.youtubeImagesPath,
					youtubeLink:this.youtubeLink,
					shortDescription:this.shortDescription,
					startupDesc:this.startupDesc,
					longDescription:this.longDescription,
					twitter:this.twitter,
					linkedIn:this.linkedIn,
					youTube:this.youTube,
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
	  // hide by default
	  $items.hide();
	  // append to container
	  $container.append( $items );
	  $items.imagesLoaded().progress( function( imgLoad, image ) {
		// get item
		// image is imagesLoaded class, not <img>, <img> is image.img
		var $item = $( image.img ).parents( itemSelector );
		// un-hide item
		$item.show();
		// isotope does its thing
		( $item ).appendTo('ul.isotope');
		
		iso.appended( $item );
		
		//$container.isotope({ filter: ('.all'), sortBy : 'number', sortAscending : false });		
		$container.isotope({ filter: ('.All'), sortBy : 'number', sortAscending : false});		
		
		 // Trace on which tile is clicked				 
		 $('div.vidtile').off('click').bind('click', function(e)
		 {			
			e.preventDefault();			
			
			imageListPath = $(this).parent().attr('data-url');

			$clickedImg = $(this);
			var linked = $clickedImg.find(".linked").attr('href');
			var twit = $clickedImg.find(".twit").attr('href');
			var youtube = $clickedImg.find(".youtube").attr('href');
			//var youtubeImagesPath = $clickedImg.find('#youtubeImgPath').attr('src');
			
			//console.log("img path: " + $clickedImg.find("p#longDescCont").text()+" --- "+$clickedImg.find('img').attr('src')+" --- "+$clickedImg.find('p.mainCategory').text());

			popupCaption = $clickedImg.parent().find('h3').text();
			
			$('#popup').find('.mainImg').attr('src', $clickedImg.find('img').attr('src'));
			$('#popup').find('#ytimg1').attr('src', $clickedImg.find('p#youtubeImgPath').text());
			$('#popup').find('h3').html($clickedImg.find('h3').text());
			$('#popup').find('p#shortDesc').html($clickedImg.find('p.mainCategory').text());
			$('#popup').find('p#startupDesc').html($clickedImg.find("p#startupDesc").text());
			$('#popup').find('p#longDesc').html($clickedImg.find("p#longDescCont").text());
			$('#popup').find('p#expertise').html("Expertise : " + $clickedImg.find("p.category").text());
			$('#popup').find('#twitterlink').attr('href', twit);
			$('#popup').find('#linkedInlink').attr('href', linked);	
			$('#popup').find('#youTubelink').attr('href', youtube);	
			//$('#popup').find('#youTubelink').attr('href', $clickedImg.find('.ytlink').attr('href'));
			
			console.log("$clickedImg.find('#youtubeImgPath').attr('src') "+$clickedImg.find('#youtubeImgPath').attr('src'));
					
			
			if(twit.length == 0){
				$('#twitterlink').hide();
			} else {
				$('#twitterlink').show();
				$('#popup').find('#twitterlink').attr('href', twit);
			}

			if(linked.length == 0){
				$('#linkedInlink').hide();
			} else {
				$('#linkedInlink').show();
				$('#popup').find('#linkedInlink').attr('href', linked);
			}
			
			
			if(youtube.length == 0){
				$('#youTubelink').hide();
			} else {
				$('#youTubelink').show();
				$('#popup').find('#youTubelink').attr('href', youtube);
			}
			
			//Sachin
			/*if(youtubeImagesPath.length == 0){
				$('#youtubeImagesPath').hide();
			} else {
				$('#youtubeImagesPath').show();
				$('#popup').find('#youtubeImagesPath').attr('href', ytimg);
			}
			*/
			
			//showPOP_UP();			
		});
		
	  });
	  
	  return this;
	};
	
	function getItem(elementObj) 
	{	  
        var item;
		
		var tmpCategoryStr = (elementObj.category).replace(/ /g, '').replace(/,/g, ' ').replace(/&/g, '');
		
		
		console.log("tmpCategoryStr: "+tmpCategoryStr);
		var twit = elementObj.twitter;
		
		//item = '<li class= "project all" data-url="' + elementObj.projectImagesPath + '">';
		item = '<li class= "project All no-transition ' + tmpCategoryStr + '" data-url="' + elementObj.projectImagesPath + '">';
		item += '<div class="vidtile">';		
		item += '<a href="#popup" data-toggle="modal">';
		item += '<img src="'+elementObj.projectImagesPath+'" alt="'+ elementObj.name +'" class="imgLoaded"/></a>';
		item += '<p class="number hiddens">' + parseInt(elementObj.number) +'</p>';
		item += '<p id="startupDesc" class="hiddens">' + elementObj.startupDesc +'</p>';
		item += '<p id="longDescCont" class="hiddens">' + elementObj.longDescription +'</p>';
		item += '<h3>' + elementObj.name + '</h3>';
		item += '<div class="about-project clear">';
		item += '<p class="companyName">' + elementObj.CompanyName +'</p>';
		item += '<p class="mainCategory hiddens">' + elementObj.shortDescription +'</p>';
		item += '<p class="category hiddens">' + elementObj.category +'</p>';
		item += '<a href="' + elementObj.twitter +'" class="twit hiddens"></a>';
		item += '<a href="' + elementObj.linkedIn + '" class="linked hiddens"></a>';
		item += '<a href="' + elementObj.youTube + '" class="youtube hiddens"></a>';
		item += '<p id="youtubeImgPath" class="hiddens">' + elementObj.youtubeImagesPath +'</p>';
		//item += '<img src="' + elementObj.youtubeImagesPath + '" class="hiddens" id="youtubeImgPath" />';	
		item += '</div></div>';
		item += '</li>';
		
		console.log("item: "+ item);
		  
	    return item;
	}
	
	function getItems() {
	  var items = '';
	  for ( var i=0; i < noOfImgTOLoad; i++ ) {
		items += getItem(currentActiveArr[i]);
	  }
	  // return jQuery object
	  return $( items );
	}
	
	
// Change selection as per dropdown	
	function getVals()
	{
		//currentClickFilter = $(".leadership").val().replace(/ /g, '').toLowerCase();
		
		currentClickFilter = $(".leadership").val().replace(/ /g, '').replace(/&/g, '');
		
		console.log("currentClickFilter: "+currentClickFilter);
				
		//$container.isotope({ filter: ('.'+currentClickFilter), sortBy : 'number', sortAscending : false });		
		$container.isotope({ filter: ('.'+currentClickFilter), sortBy : 'number', sortAscending : false });
	}	
	
	

		
		$('#videos').click(function()
		{	
			//console.log("Video tab clicked!!!");
			
			filterToApply = $(this).attr('data-filter');
			
			$(this).addClass('active');
			$('#photos').removeClass('active');
			
			changeCurrentArr();
		});
		
		$('#photos').click(function()
		{	
			//console.log("Photos tab clicked!!!");
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
