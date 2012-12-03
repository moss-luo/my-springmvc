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
		},
		fields : [ {
			display : '主键',//display或者title都行
			name : 'id'		//name或者field都行
		}, {
			title : '名字',
			field : 'username'
			
		}, {
			title : '年龄',
			field : 'age',
		}, {
			title : '英文名',
			field : 'enName',
			updateable:false
		} ,{
			title : '测试上传',
			field : 'testUpload',
			type:'file',
			upload:{
				uploadBrowseId:'upload_button',
				uploadSubmitId:'submit_button',
				action:'upload.do',
				autoSubmit:false,
				name:'file',
//				onChange:function(file, extension){
//					console.log(extension.toLowerCase());
//				},
				onComplete:function(data,ex){
					console.log(ex);
					console.log(data);
				},
				beforeSubmit:function(){
					console.log("ok");
				}
				
			}
		} ],
		search:{
			field:[
			       {display:'用户名',name:'username1', newline: false,type:'text'},
			       {display: "日期 ", name: "createdate", newline: false, type: "date"},
			],
			buttons:[{text:'测试',id:'test',handle:function(){alert("test");}}],
	 	},
	 	dialog : {
			labelWidth : 80,
			height : 300,
			width : 400,
		},
		
	}
	$("#maingrid").crud(options);
	var grid = $("#maingrid").crud("getDatagrid");

});

function addItem(item){
	alert(item);
}