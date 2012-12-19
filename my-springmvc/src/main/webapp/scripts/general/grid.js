$(function() {
	var options = {
		removeUrl : 'delete.do',
		saveUrl : 'add.do',
		updateUrl : 'modify.do',
		grid : {
			dataUrl : 'grid.do',
			idField : 'id',
			pageSize : 10,
			checkbox : true,
		},
		fields : [ {
			display : '主键',//display或者title都行
			name : 'id',		//name或者field都行
			gridWidth:'25%',
			type : 'select',
			options:{
				textField:"text",
				valueField:"id",
				url:'select.do'
			}
				
		}, {
			title : '名字',
			gridWidth:'25%',
			field : 'username'
			
		}, {
			title : '年龄',
			gridWidth:'23%',
			field : 'age',
		}, {
			title : '英文名',
			gridWidth:'25%',
			field : 'enName',
			updateable:false
		}, {
			title : '描述信息',
			field : 'descrition',
			gridShow:false,
			type:'textarea',
		}, {
			title : '测试上传',
			field : 'testUpload',
			gridShow : false,
			type:'file',
			upload:{
				uploadBrowseId:'upload_button',
				uploadSubmitId:'submit_button',
				action:'upload.do',
				autoSubmit:true,
				name:'file',
				onChange:function(file, extension){
					console.log(extension.toLowerCase());
				},
				onComplete:function(data,ex){
					console.log(ex);
					console.log(data);
				},
				beforeSubmit:function(){
					console.log("ok");
				}
				
			}
		}
	],
		search:{
			field:[
			       {display:'用户名',name:'username', newline: false,type:'select',options:{
			    	   	textField:'text',
			    	   	valueFieldID :'id',
						url:'select.do'
					}},
			       {display: "日期 ", name: "createdate", newline: false, type: "date"},
			],
			buttons:[{text:'测试',id:'test',handle:function(){alert("test");}}],
	 	},
	 	dialog : {
			labelWidth : 80,
			height : 350,
			width : 350,
		},
		
	}
	$("#maingrid").crud(options);
	var grid = $("#maingrid").crud("getDatagrid");
	
});

function addItem(item){
	alert(item);
}