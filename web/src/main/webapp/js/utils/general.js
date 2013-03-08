(function () {
	var holder = [],
	init = function () {
		placeHolders();	
	},
	placeHolders = function(){
		var item = $('input[type=text], textarea'),
			length = item.length,
			i = 0;

		for( i=0; i < length; i = i+1 ){
			holder[ $(item[i]).attr('name') ] = $(item[i]).attr('value');
		}
		item.bind('focus', function(e){
			var that = $(this);
			if( that.val() === holder[ that.attr('name') ] || that.val().replace('/\s*/g','').length === 0 ){
				that.val('');
			}
		});
		item.bind('focusout', function(e){
			var that = $(this);
			if( that.val().length === 0  || that.val().replace(/\s*/g,'').length === 0 ){
				that.val( holder[ that.attr('name') ] );
			}
		});
	}
	init();
})();