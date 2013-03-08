(function () {
	var init = function () {
		var sliderHome = new slideMe({
			el:$('#slidePreview'),
			menu:$('#slidePreview-menu'),
			time:'1000',
			duration:'6000',
			slider:false
		});
	};
	init();
})();