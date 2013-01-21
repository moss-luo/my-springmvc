// global variables
var timer,allName,luckyTd,randnumArray=new Array(),cellnum = 0,persons = new Array();
$(function(){
	allName = $("#allName td").toArray();
	allName.removeEleAt(0);
	luckyTd = $("#luckyList td").toArray();
	luckyTd.removeEleAt(0);
	init();
	getNewPersons();
});
function start() {
	timer = setInterval("getRandNum();", 20);
	$("#start").attr("disabled","disabled");
	$("#end").removeAttr("disabled");
	
}
function stop() {
	clearInterval(timer);
	setValues();
	if(cellnum<50)$("#start").removeAttr("disabled");
	$("#end").attr("disabled","disabled");
}
//产生10个不同的随机数
function getRandomArray(){
	var n = 0;
	while (n < 10) {
		randnumArray[n] = parseInt(Math.random() * persons.length);
		if (n >= 1) {
			var i = 0;
			while (i < n) {
				if (randnumArray[i] == randnumArray[n])
					break;// 如果相同，外层循环再执行一次，此时n的值不变
				i++;
			}
			if (i == n)
				n++;
		} else
			n++;
	}
}
//更改抽奖表单的值，滚动刷新
function getRandNum() {
	getRandomArray();
	$.each(allName,function(i,n){
		n.innerHTML=persons[randnumArray[i]].name;
	});
}
//修改已经获奖人员的状态
function modifyLuckyPersonStatus(n) {
	$.ajax({
		url:"person/modify.do",
		async: false,
		data:{names:$.map(allName,function(n){return n.textContent;}).join(',')},
		success:function(msg){
					if(!msg.success)alert("出错了……");
				}
	});
}
//获取新的名单
function getNewPersons(){
	$.ajax({
		url:"person/list.do",
		async: false,
		success:function(msg){
			persons=msg;
		}
	});
}
//初始化，查询已中奖的名单
function init(){
	$.ajax({
		url:"person/init.do",
		async: false,
		success:function(data){
			for ( var i = 0; i < data.length; i++) {
				luckyTd[cellnum].innerHTML=data[i].name;
				cellnum++;
			}
			if(cellnum>49)$("#start").attr("disabled","disabled");
		}
	});
}
//为Array添加一个方法，移除某个位置的数据
Array.prototype.removeEleAt = function(dx) {
	if (isNaN(dx) || dx > this.length) {
		return false;
	}
	this.splice(dx, 1);
}
//将获奖结果设置到中奖名单表格中
function setValues() {
	if(cellnum>49)return false;	
	
	modifyLuckyPersonStatus();
	for ( var i = 0; i < 10; i++) {
		luckyTd[cellnum].innerHTML=allName[i].textContent;
		cellnum++;
	}
	getNewPersons();
}