$(function() {
	var options = {
		removeUrl : 'delete.do',
		grid : {
			dataUrl : 'grid.do',
			idField : 'id',
			pageSize : 10,
			width : '99.9%',
			height : '95%',
			checkbox : true,
			validateDelete : function() {
				var grid = $("#maingrid").crud("getDatagrid").getSelectedRows();
				if(grid.length>1)return false;
				
				return true;
			},
			toolbars:{items:{
				id:'test',
				icon:'add',
				text:'测试',
				click:addItem
			}}
		},
		fields : [ {
			title : '主键',
			field : 'id'
		}, {
			title : '名字',
			field : 'username'
		}, {
			title : '年龄',
			field : 'age'
		}, {
			title : '英文名',
			field : 'enName'
		} ],
		search:{
			field:[
			       {display:'用户名',name:'username', newline: false,type:'text'},
			       {display: "日期 ", name: "createdate", newline: false, type: "date"},
			],
			buttons:[{text:'测试',id:'test',handle:function(){alert("OK");}}],
			beforeSubmit:function(){
				return true;
			}
	 	}
		
	}
	$("#maingrid").crud(options);
	var grid = $("#maingrid").crud("getDatagrid");

});

function addItem(item){
	alert(item);
}