$('.shareme').sharrre({
  share: {
    facebook: true,
    pinterest: true,
    googlePlus: false,
    twitter: false
  },

  template: '<a href="#" class="facebook"><img src="/reliance-foundation-theme/images/img/social/facebook.png" /></a><a href="#" class="pinterest"><img src="/reliance-foundation-theme/images/img/social/pinterest.png" /></a><a href="#" class="twitter"><img src="/reliance-foundation-theme/images/img/social/twitter.png" /></a><a href="#" class="googleplus"><img src="/reliance-foundation-theme/images/img/social/googleplus.png" /></a>',


  //alert('test'),
  enableHover: false,
  enableTracking: true,
  render: function(api, options){
  
  $(api.element).on('click', '.facebook', function(e) {
    //alert('FB');
    e.preventDefault();
    api.openPopup('facebook');
  });
  $(api.element).on('click', '.pinterest', function() {
    //alert('PI');
    api.openPopup('pinterest');
  });
  $(api.element).on('click', '.twitter', function(e) {
    //alert('TW');
    e.preventDefault();
    api.openPopup('twitter');
  });
  $(api.element).on('click', '.googleplus', function() {
    //alert('GP');
    api.openPopup('googlePlus');
  });
  // $(api.element).on('click', '.linkedin', function() {
  //   api.openPopup('linkedIn');
  // });
  
}
});