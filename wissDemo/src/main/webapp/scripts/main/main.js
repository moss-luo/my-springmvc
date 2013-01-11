var tab = null;
var accordion = null;
var tree = null;
var formID=null;
$(function() {

	//布局
	$("#layout1").ligerLayout({
		leftWidth : 190,
		height : '100%',
		heightDiff : -24,
		space : 4,
		onHeightChanged : f_heightChanged
	});

	var height = $(".l-layout-center").height();

	//Tab
	$("#framecenter").ligerTab({
		height : height
	});
	
	var myaccount = 'resources/ligerui/skins/icons/myaccount.gif';
    var memeber = 'resources/ligerui/skins/icons/memeber.gif';
    var archives = 'resources/ligerui/skins/icons/archives.gif';


	//面板
	$("#accordion1").ligerAccordion({
		height : height - 24,
		speed : null
	});

	$(".l-link").hover(function() {
		$(this).addClass("l-link-over");
	}, function() {
		$(this).removeClass("l-link-over");
	});
	tab = $("#framecenter").ligerGetTabManager();
	accordion = $("#accordion1").ligerGetAccordionManager();
	$("#pageloading").hide();
	

});
function f_heightChanged(options) {
	if (tab)
		tab.addHeight(options.diff);
	if (accordion && options.middleHeight - 24 > 0)
		accordion.setHeight(options.middleHeight - 24);
}
function f_addTab(tabid, text, url) {
	tab.addTabItem({
		tabid : tabid,
		text : text,
		url : url
	});
}
function f_updateTabText(tabid,text){
	$("a",$("[tabid='"+tabid+"']")).html(text);
}


