<%@include file="../init.jsp" %>

<section class="fullwidth padd gallerybox clearfix">
  <div class="wrap" > <h2 class="common-title" href="javascript:;">Gallery</h2>
<select class="selectpicker">
      <option>All</option>
      <option>Image</option>
      <option>Video</option>
    </select>

    <!-- Main HTML -->
    <div id="update" class="shiftdown">
      <ul class ="unstyled isotope clearfix" id="galleryContainer">
      </ul>
    </div>
    
    <!-- Endof Main HTML --> 
  </div>
</section>

<%-- <script src="<%=request.getContextPath()%>/js/Gallery.js"></script> --%>
<script type="text/javascript">

var pageName = "Gallery";
var filterToApply = "None";

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
		/*prevEffect : 'elastic',
		nextEffect : 'elastic',*/
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
		autoCenter: true,
		padding : 2,
		scrolling : 'no',
		/*'transitionIn'	: 'elastic',
		'transitionOut'	: 'elastic',
		'easingIn'      : 'easeOutBack',
		'easingOut'     : 'easeInBack',*/
		
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
		    tmpStr += '<span class="titlename">' + this.title + '</span>';
			//console.log("thumbnail----"+this.thumbnailName+"-----href----"+$(this.element).attr('data-url'));
			shareimg = "http://www.reliancefoundation.org/"+ $(this.element).attr('data-url');
		   tmpStr += '<script src="<%=request.getContextPath()%>/js/social-sharrre.js" /><span class="shareme" style="float:right; margin-top:-20px;" data-url="'+ shareimg +'" data-text="' + this.title + ', #RelianceFoundation" data-title="Facebook"></span>';  

		   this.title = tmpStr
		},
		
		'titlePosition'  : 'over'
		
	});
	  
	  /*console.log("Main page filter: "+ pageName +" --- "+ filterToApply);*/
	  

	  var $container = $('#galleryContainer').isotope({
		itemSelector: '.project',
		/*cellsByRow: {
			columnWidth: 240,
			rowHeight: 500
		},*/
		/*layoutMode: 'fitRows',
		masonry: {
		  columnWidth: 285  
		},*/
		getSortData: {		 
		  number: '.number parseInt',		  
		}
	  });
	
/* Select Picker */
	$(".selectpicker").change( getVals );
  


/*  3.1  Fetching Data from JSON */
/* For mainOffice Icon position */
	  $.ajax({
		'url' : '<portlet:resourceURL/>',
		'type' : 'GET',
		'data': 'values',
		'async': 'true',
		'cache': 'false',
		'dataType': 'json',
		'success' : function(data) {
			              
			
			/*  For Random Images*/
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
					demoLink: this.demoLink,
					number: this.number
				};
				
				imageArr.push(jasonObj);
				
			});
			
			/* For Random Videos */
			$.each(data["video"], function() {	
				
				jasonObj = {
					type: this.type,
					videoImageUrl:this.videoImageUrl,
					thumbnailName:this.thumbnailName,
					name:this.name,
					mainCategory: this.mainCategory,
					projectImagesPath:this.projectImagesPath,
					isVideo: this.isVideo,
					demoLink: this.demoLink,
					number: this.number
				};				
				videoArr.push(jasonObj);
			});
			
			currentActiveArr = imageArr.concat(videoArr);
			console.log("array"+currentActiveArr);
			
			
			
			/* console.log("filterToApply: "+filterToApply); */			
		
			changeCurrentArr();
			
			/*var $items = getItems();
		    $container.isotopeImagesReveal( $items );*/
			
		},
		'error' : function(request,error)
		{
		  /* console.log("Request: "+JSON.stringify(request)); */
		}
	});
	
	$.fn.isotopeImagesReveal = function( $items ) {
	  var iso = this.data('isotope');
	  
	  var itemSelector = iso.options.itemSelector;
	  
	  $items.hide();
	  
	  $container.append( $items );
	  $items.imagesLoaded().progress( function( imgLoad, image ) {
		
		var $item = $( image.img ).parents( itemSelector );
		$item.show();
		( $item ).appendTo('ul.isotope');
		
		iso.appended( $item );
		
		
		$container.isotope({ filter: ('.all'), sortBy : 'number', sortAscending : false});
		
		
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
			
		});
		
	  });
	  
	  return this;
	};
	
	function getItem(elementObj) {
	  
	  var item;
		
			    item = '<li class= "project all '+ (elementObj.isVideo == true ? 'video' : 'image') + '"' +' data-url="' + elementObj.projectImagesPath + '">';
				
				if(pageName == "Index")
		  		{
					if(elementObj.isVideo == true)
					{
						
						item += '<div class="vidtile">';			
						
						console.log("elementObj.projectImagesPath: "+elementObj.projectImagesPath);
						
						item += '<a href="' + elementObj.projectImagesPath + '" class="fancybox-media fancybox.iframe" data-fancybox-group="media">';
						item += '<img data-bigImgName ='+ elementObj.thumbnailName + ' data-isVideo ='+ elementObj.isVideo +' src="' + elementObj.videoImageUrl + '" alt="'+ elementObj.name +'" class="imgLoaded fancybox-media fancybox.iframe" data-fancybox-group="iframe"/></a>';
					}  
					else if(elementObj.isVideo == false) 
					{					
						
						
						item += '<div class="imgtile">';
						
						item += '<a href='+ elementObj.bigImageUrl +' class="fancybox-thumbs" data-fancybox-group="thumbs" data-url='+ elementObj.bigImageUrl +' title="'+ elementObj.name +'">';
						item += '<img data-bigImgName ='+ elementObj.thumbnailName + ' data-isVideo ='+ elementObj.isVideo +' src='+ elementObj.thumbnilImageUrl +' alt="'+ elementObj.name +'" class="imgLoaded" class="fancybox-thumbs" data-fancybox-group="thumbs"/></a>';
					}
					
				} else 
				{
					if(elementObj.isVideo == true)
					{
						
						item += '<div class="tile">';			
						
						console.log("elementObj.projectImagesPath: "+elementObj.projectImagesPath);
						
						item += '<a href="' + elementObj.projectImagesPath + '" class="fancybox-media fancybox.iframe" data-fancybox-group="media">';
						item += '<img data-bigImgName ='+ elementObj.thumbnailName + ' data-isVideo ='+ elementObj.isVideo +' src="' + elementObj.videoImageUrl + '" alt="'+ elementObj.name +'" class="imgLoaded fancybox-media fancybox.iframe" data-fancybox-group="iframe"/></a>';
					}  
					else if(elementObj.isVideo == false) 
					{					
						
						item += '<div class="tile">';
						
						item += '<a href='+elementObj.bigImageUrl+' class="fancybox-thumbs" data-fancybox-group="thumbs" data-url='+elementObj.bigImageUrl+' title="'+ elementObj.name +'">';
						item += '<img data-bigImgName ='+ elementObj.thumbnailName + ' data-isVideo ='+ elementObj.isVideo +' src='+ elementObj.thumbnilImageUrl +' alt="'+ elementObj.name +'" class="imgLoaded" class="fancybox-thumbs" data-fancybox-group="thumbs"/></a>';
					}					
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
	  return $( items );
	}
	
	
	function getVals()
	{
		currentClickFilter = $(".selectpicker").val().toLowerCase();
		
		$container.isotope({ filter: ('.'+currentClickFilter)});
	}	
	
	

		
		$('#videos').click(function()
		{	
			
			filterToApply = $(this).attr('data-filter');
			
			$(this).addClass('active');
			$('#photos').removeClass('active');
			
			changeCurrentArr();
		});
		
		$('#photos').click(function()
		{	
			filterToApply = $(this).attr('data-filter');
			
			$(this).addClass('active');
			$('#videos').removeClass('active');
			
			changeCurrentArr();
		});
		
		function changeCurrentArr()
		{
			if(pageName == "Index")
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
				debugger;
				currentActiveArr = imageArr.concat(videoArr);
				
				console.log("array==="+currentActiveArr);
		 	}
			
			$container.isotope( 'remove', $('.project'));
			
			var $items = getItems();
		    $container.isotopeImagesReveal( $items );
		}
});
 

 </script> 