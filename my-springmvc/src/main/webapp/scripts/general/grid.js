$(function() {
	var options = {
		removeUrl : 'delete.do',
		saveUrl : 'add.do',
		updateUrl : 'modify.do',
		grid : {
			dataUrl : 'grid.do',
			idField : 'id',
			pageSize : 10,
			width : '99.9%',
			height : '95%',
			checkbox : true,
			validateDelete : function() {
				var grid = $("#maingrid").crud("getDatagrid").getSelectedRows();
				//if(grid.length>1)return false;
				
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
			field : 'id',
//			newline :false
				
		}, {
			title : '名字',
			field : 'username',
			newline :false
		}, {
			title : '年龄',
			field : 'age',
			type:'date'
		}, {
			title : '英文名',
			field : 'enName',
			newline :false
		} ],
		search:{
			field:[
			       {display:'用户名',name:'username1', newline: false,type:'text'},
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