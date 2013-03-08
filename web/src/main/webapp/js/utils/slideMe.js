;var slideMe = function(options){
	var opt = $.extend({
		el:'',
		menu:'',
		time:'250',
		duration:'4750',
		auto:'false',
		slider:true
	},options),
	li = opt.el.find('>li'),
	liL = li.length,
	btn,
	i,
	current = 0,
	autoTimer,
	template;
	
	opt.duration = Number(opt.duration)+Number(opt.time );
	template = '<div style="position:relative;';
	if(opt.menu){
		template += 'padding-bottom:20px;';
	}
	template += 'overflow:hidden;height:'+$(opt.el).height()+'px"/>';
	$(opt.el).wrap(template);
	
	if(opt.slider){
		for(i=0; i < liL;i+=1){
			$(li[i]).css({'position':'absolute','width':$(opt.el).width(),'left':$(li[i]).index()*($(li[0]).width() ),'display':'block'  });
		}
		$(opt.el).css({'position':'absolute'});
	}

	if( opt.menu ){
		btn = opt.menu.find('>li');
		$(btn[0]).addClass('active');

		btn.bind('click',function(e){
			var that = $(this);
			if( !that.hasClass('active') ){
				current = that.index();
				btn.removeClass('active');
				that.addClass('active');
				
				if(opt.slider){
					var left = $(li.get( that.index() )).offset().left - opt.el.offset().left;
					$(opt.el).animate({'left':-left},opt.time*2);
				}else{
					li.css({'display':'none'});
					$(li.get( that.index() )).fadeIn(opt.time);
				}
				
				if(opt.auto){
					clearTimeout( autoTimer );
					current += 1;
					if( current >= liL ){
						current = 0;
					}
					autoTimer = setTimeout(function(){
						$(btn[current]).trigger('click');
					} ,opt.duration);
				}
			}
		});	
		if(opt.auto){
			autoTimer = setTimeout(function(){
						$(btn[current+1]).trigger('click');
					} ,opt.duration);
		}
		
	}
	if( !opt.menu ){
		autoTimer = setTimeout(function(){
						animSlider( );
					} ,opt.duration);
	}
	var animSlider = function( type, config ){
		if(opt.slider){
			current += 1;
			if( current >= liL ){
				current = 0;
			}
			var left = $(li.get( current )).offset().left - opt.el.offset().left;
			$(opt.el).animate({'left':-left},opt.time*2);
		}else{
			li.css({'display':'none'});
			$(li.get( current )).fadeIn(opt.time);
		}
		autoTimer = setTimeout(function(){
						animSlider( );
					} ,opt.duration);
	}
	
};