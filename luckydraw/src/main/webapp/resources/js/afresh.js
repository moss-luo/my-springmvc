$(function(){
	$("#allName td").contextmenu({
		items : [{
			text :'重新抽取',
			icon :'resources/contextmenu/icons/sync.png',
			action: function(target){
				if(target.textContent==="-"){
					return false;
				}
				alert('重新抽取，暂未实现');
			}
		}]
	});
})