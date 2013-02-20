(function($){
	
	$.fn.hilight = function(options) {    
		  var opts = $.extend({}, $.fn.hilight.defaults, options); 
		  
		  return this.each(function(){
			  var $this  = $(this);
			  var markup = $this.html();
			  markup = $.fn.hilight.format(markup);
			  $this.html(markup);
		  });    
	}; 
	
	$.fn.hilight.format=function(txt){
		return '<strong>' + txt + '</strong>'; 
	}
	
	$.fn.hilight.defaults = {    
		foreground: 'red',    
		background: 'yellow'    
	}; 
})(jQuery)