// JavaScript Document

	$('.pie_progress').asPieProgress({
		namespace: 'pie_progress'
	});
	
	//$('.pie_progress--slow').hide();
	
	// Example with grater loading time - loads longer
	$('.pie_progress--slow').asPieProgress({
		namespace: 'pie_progress',
		goal: 100,
		min: 0,
		max: 100,
		speed: 100,
		easing: 'linear'
	});
	
	var player;
	 
	function onPlayerReady(event) {
		$.fancybox.hideLoading();
		event.target.playVideo();
	}
	
	function onPlayerStateChange(event) {
		if (event.data === 0) {
		
			$('.overlay_bg').show();
			$('.pie_progress--slow').asPieProgress({
				namespace: 'pie_progress',
				goal: 100,
				min: 0,
				max: 100,
				speed: 100,
				easing: 'linear'
			});
			$('.pie_progress').asPieProgress('reset');
			//$('.pie_progress--slow').show();
			$('.pie_progress').asPieProgress('start');
			
		
			//$('.fancybox-inner').append(' ');
			//	$('.pie_progress').asPieProgress('reset');
			//	$('.pie_progress--slow').show();
			//	$('.pie_progress').asPieProgress('start');
			
			setTimeout(function(){
			//	$('.fancybox-inner')(' <div class="pie_progress--slow" role="progressbar" style="width:78px; height:78px; z-index:8060;"> <span><i class="fa fa-play-circle fa-5x"></i></span> </div>');
				//$('.pie_progress--slow').hide();
			//	$.fancybox.showLoading();		
				$.fancybox.next();
			}, 10000);			
		}
	}
	
	function onYouTubePlayerAPIReady() {
		
	} // youtube API ready
	
	$(document).ready(function () {

			$('.fancybox-media').attr('rel', 'media-gallery').fancybox({
				
				openEffect	: 'elastic',
				closeEffect	: 'fade',
				padding : 2,
				helpers: {
					media: {
						youtube: {
							params: {
								autoplay: 1,
								rel: 1,
								controls: 1,
								showinfo: 1,
								autohide: 1
							}
						}
					},
					buttons: {}
				},
				
				
				beforeShow: function () {
					var id = $.fancybox.inner.find('iframe').attr('id');					
					player = new YT.Player(id, {
						events: {
							'onReady': onPlayerReady,
							'onStateChange': onPlayerStateChange							
						}
					});
				}
			}); // fancybox
		}); // ready
	