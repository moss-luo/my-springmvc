$(function() {
	var options = {
		removeUrl : 'delete.do',
		grid : {
			dataUrl : 'grid.do',
			idField : 'id',
			pageSize : 10,
			width : '100%',
			height : '99%',
			checkbox : true,
			validateDelete : function() {
				var grid = $("#maingrid4").crud("getDatagrid").getSelectedRows();
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
				{title:'用户名',id:'s_userId',field:'name'}
			]
	 	}
		
	}
	$("#maingrid4").crud(options);
	var grid = $("#maingrid4").crud("getDatagrid");

});

function addItem(item){
	alert(item);
}