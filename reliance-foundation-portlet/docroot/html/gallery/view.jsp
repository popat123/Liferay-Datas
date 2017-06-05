<%@include file="../init.jsp" %>
<%--  <script src="<%=request.getContextPath()%>/js/Gallery.js"></script>  --%>


<portlet:renderURL var="addGalleryURL">
	<portlet:param name="mvcPath" value="/html/gallery/add_gallery.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="viewGalleryURL">
	<portlet:param name="mvcPath" value="/html/gallery/edit_gallery.jsp"/>
</portlet:renderURL>

<c:if test="${isSignedIn}">
<aui:button-row>
	<aui:button type="button" value="Add Gallery" onClick="${addGalleryURL}"></aui:button>
	<aui:button type="button" value="view Gallery" onClick="${viewGalleryURL}"></aui:button>
</aui:button-row>
</c:if>


<section class="fullwidth padd gallery clearfix">
    <div class="wrap"> 
    <h3 class="common-title" href="javascript:;">Gallery</h3>
      <ul class="unstyled clearfix gallery-categories-list">
            <!-- <li class="filter" data-filter="all">All</li> -->
            <li id="videos" class="filter active" data-filter="video">Videos</li>
            <li id="photos" class="filter" data-filter="image">Photos</li>
      </ul>
      
<!--       Select box End -->
<!--       <ul class="unstyled clearfix navigation" id="navigation"> -->
<!--         <li class="main-category rfevent"> <a class="link all" href="javascript:void(0);" data-filter=".rfevent" id="rfevent">RF EVENT</a> </li> -->
<!--         <li class="main-category ruraltrasformation"> <a class="link web" href="javascript:void(0);" data-filter=".ruraltrasformation" id="ruraltrasformation">RURAL TRANSFORMATION</a> </li> -->
<!--         <li class="main-category health"> <a class="link mobile" href="javascript:void(0);" data-filter=".health" id="health">HEALTH</a> </li> -->
<!--         <li class="main-category sport"> <a class="link digital" href="javascript:void(0);" data-filter=".sport" id="sport">SPORT</a> </li> -->
<!--         <li class="main-category education"> <a class="link print" href="javascript:void(0);" data-filter=".education" id="education">EDUCATION</a> </li> -->
<!--       </ul> -->
      
      <!-- Video POP_up -->
<!--       <div class="popup"> -->
<!--         <div class="video-wrap"> -->
<!--           <video controls id="video"> -->
<!--             <source src="" type="video/mp4" id="givenVideo"> -->
<!--             <source type="video/youtube" src="http://www.youtube.com/watch?v=nOEw9iiopwI" />  -->
<!--           </video> -->
<!--           <a id="closeVideoPop" href="javascript:void(0);"></a> </div> -->
<!--       </div> -->
      <!-- Endof Video POP_up --> 
      
      <!-- Related work Pop up  -->
<!--       <div class="backdrop"></div> -->
<!--       <div class="related-popup hidden"> -->
<!--         <div class="work clearfix"> <span class="close-work"></span> -->
<!--           <div class="current"> <img alt="" class="current-img wow fadeInUp animated" src=""> -->
<!--             <h1 class="current-title clearfix"> <span></span> -->
<!--               <div class="about-project clear"> -->
<!--                 <p class="mainCategory"></p> -->
<!--               </div> -->
<!--             </h1> -->
<!--           </div> -->
<!--         </div> -->
<!--       </div> -->
      <!-- Endof Related work Pop up  --> 
      <!-- Main HTML -->
      <div id="update" class="shiftdown">
        <ul class ="unstyled isotope clearfix" id="galleryContainer">
        </ul>
      </div>
      
      <!-- Endof Main HTML --> 
      
      <div class="cl"></div>
      <br>
      <div class="lalign"><a href="/gallery" class="link btn read-more rippley">View All</a></div>
    </div>
  </section>
<script type="text/javascript">
    var pageName = "Home";
    var filterToApply = "video"; 
  </script>
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
				imageArr = [],
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
				lastMenuClick,
				isVideoPopUpClosed = false,
				popupCaption,
				backDrop = $('div.backdrop'),
				$demoLiveLinkDuplicate,
				current_scroll_top = 0,
				filters,
				$container,
				sidrID = '#',
				sidrClass = '.'
				$mainNav = $(sidrClass+'main-category'),
				$subNav = $(sidrClass+'sub-category-list');				
				

	  backDrop.hide();
	  
	  //-------------------------------------------------------------------------------------------//
	// Fancy Box initiated
	//-------------------------------------------------------------------------------------------//		
	
	$('.fancybox-thumbs').fancybox({
		
		openEffect	: 'elastic',
		closeEffect	: 'fade',

		closeBtn  : true,
		arrows    : true,
		nextClick : true,
		autoSize: false,		
		autoWidth: true,
		fitToView: true,
		width     : 'auto',
		height    : 'auto',
		autoCenter: true,
		padding : 2,
		scrolling : 'no',
		
		
		oncomplete   : function( links, index)
		{
  			$.fancybox.reposition();
  		},
		helpers : {
			thumbs : {
				width  : 80,
				height : 80				
			},
			title	: {
				type: 'inside'
			}
		},
		 afterLoad : function() 
		{
		   var tmpStr;
		   var shareimg;
		   tmpStr = '<span>Image ' + (this.index + 1) + ' of ' + this.group.length + '</span> <br>';
		    tmpStr += '<span>' + this.title + '</span>';
			
			shareimg = "http://www.reliancefoundation.org/"+ $(this.element).attr('data-url');
		   tmpStr += '<script src="<%=request.getContextPath()%>/js/social-sharrre.js" /><span class="shareme" style="float:right; margin-top:-20px;" data-url="'+ shareimg +'" data-text="' + this.title + ', #RelianceFoundation" data-title="Facebook"></span>';  

		   this.title = tmpStr
		},
		
		'titlePosition'  : 'over'
		
	});
	  
	  
	  

	  var $container = $('#galleryContainer').isotope({
		itemSelector: '.project',
		
		getSortData: {		 
		  number: '.number parseInt',		  
		}
	  });
	
// Select Picker
	$(".selectpicker").change( getVals );
  


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
			
// This is for index page
			
			// For Random Images
			$.each(data["image"], function() {	
				jasonObj = {
					type: this.type,
					bigImageUrl : this.bigImageUrl,
					thumbnilImageUrl:this.thumbnilImageUrl,
					thumbnailName:this.thumbnailName,
					name:this.name,
					mainCategory: this.mainCategory,
					projectImagesPath:this.projectImagesPath,
					isVideo: this.isVideo,
					gallryImagPriority:this.gallryImagPriority,
					demoLink: this.demoLink,
					number: this.number
				}				
				imageArr.push(jasonObj);
				
			});
			
			// For Random Videos
			$.each(data["video"], function() {	
				
				jasonObj = {
					type: this.type,
					videoImageUrl:this.videoImageUrl,
					thumbnailName:this.thumbnailName,
					name:this.name,
					mainCategory: this.mainCategory,
					projectImagesPath:this.projectImagesPath,
					isVideo: this.isVideo,
					videosImagPriority:this.videosImagPriority,
					demoLink: this.demoLink,
					number: this.number
				}				
				videoArr.push(jasonObj);
			});
			
			currentActiveArr = allObjectArr;			
			
			//console.log("filterToApply: "+filterToApply);			
		
			changeCurrentArr();
			
			
			
		},
		'error' : function(request,error)
		{
		  //console.log("Request: "+JSON.stringify(request));
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
		
		
		
		$container.isotope({ filter: ('.all')});
		
		
		 // Trace on which tile is clicked				 
		 $('.tile > img').off('click').bind('click', function(e)
		 {
			e.preventDefault();			 
			
			tilePopupBigImage = $(this).attr('data-bigImgName');
			imageListPath = $(this).parent().parent().attr('data-url');
			isVideo = $(this).attr('data-isVideo');
			isSWF = $(this).attr('data-isSWF'); 

			$clickedImg = $(this);

			popupCaption = $clickedImg.parent().find('h3').text();
			
			$demoLiveLinkDuplicate = $(this).parent().find('.demo-live-links');
			
			//showPOP_UP();			
		});
		
	  });
	  
	  return this;
	};
	
	function getItem(elementObj) {
	  
	  var item;
		
			    item = '<li class= "project all '+ (elementObj.isVideo == true ? 'video' : 'image') + '"' +' data-url="' + elementObj.projectImagesPath + '">';
	 			
				//console.log("Priority==="+elementObj.isPriority);
				if(elementObj.isVideo == true && elementObj.videosImagPriority == true)
				{
					item += '<div class="vidtile">';
					item += '<a href="' + elementObj.projectImagesPath + '" class="fancybox-media fancybox.iframe" data-fancybox-group="media">';
					item += '<img data-bigImgName ='+ elementObj.thumbnailName + ' data-isVideo ='+ elementObj.isVideo +' src="' + elementObj.videoImageUrl + '" alt="'+ elementObj.name +'" class="imgLoaded fancybox-media fancybox.iframe" data-fancybox-group="iframe"/></a>';
				}  
				else if(elementObj.isVideo == false && elementObj.gallryImagPriority == true) 
				{					
					item += '<div class="imgtile">';
					item += '<a href="'+ elementObj.bigImageUrl +'" class="fancybox-thumbs" data-fancybox-group="thumbs" data-url="'+elementObj.bigImageUrl+'" title='+ elementObj.name +'>';
					item += '<img data-bigImgName ='+ elementObj.thumbnailName + ' data-isVideo ='+ elementObj.isVideo +' src="'+ elementObj.thumbnilImageUrl +'" alt="'+ elementObj.name +'" class="imgLoaded" class="fancybox-thumbs" data-fancybox-group="thumbs"/></a>';
				}				
				
				item += '<p class="number hidden">' + parseInt(elementObj.number) +'</p>';
				item += '<h3>' + elementObj.name + '</h3>';
				item += '<div class="about-project clear"> <i class="galleryicon ' + (elementObj.isVideo == true ? 'video' : 'image') +'"></i>';
				item += '<p class="mainCategory">' + elementObj.mainCategory +'</p>';					
				item += '</div></div>';
				item += '</li>';	  
		  
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
		currentClickFilter = $(".selectpicker").val().toLowerCase();

		$container.isotope({ filter: ('.'+currentClickFilter)});
	}	
	
		$('#videos').click(function()
		{	
			console.log("Video tab clicked!!!");
			
			filterToApply = $(this).attr('data-filter');
			
			$(this).addClass('active');
			$('#photos').removeClass('active');
			
			changeCurrentArr();
		});
		
		$('#photos').click(function()
		{	
			console.log("Photos tab clicked!!!");
			filterToApply = $(this).attr('data-filter');
			
			$(this).addClass('active');
			$('#videos').removeClass('active');
			
			changeCurrentArr();
		});
		
		function changeCurrentArr()
		{
			if(pageName == "Home")
		  	{
				if(filterToApply == "image")
				{					
					currentActiveArr = imageArr;
				}
				else 
				{
					currentActiveArr = videoArr;
				}
				
				noOfImgTOLoad = currentActiveArr.length;
				
		 	} else 
			{
			    noOfImgTOLoad = currentActiveArr.length;
				
				currentActiveArr = allObjectArr;
		 	}
			
			$container.isotope( 'remove', $('.project'));
			
			var $items = getItems();
		    $container.isotopeImagesReveal( $items );
		}
});
 

 </script> 
 