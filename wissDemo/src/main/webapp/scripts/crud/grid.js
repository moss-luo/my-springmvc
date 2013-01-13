$(function(){
	var options = {
		removeUrl : '../person/delete.do',
		saveUrl : '../person/add.do',
		updateUrl : '../person/modify.do',
		grid:{
			dataUrl : '../person/query.do',
			idField : 'id',
			pageSize : 10,
			checkbox : true,
		},
		fields:[{
			title:"姓名",
			field:"name",
		},{
			title:"年龄",
			field:"age"
		},{
			title:"性别",
			field:"sex",
		},{
			title:"联系电话",
			field:"phone",
		},{
			title:"住址",
			field:"curr_address",
			
		},{
			title:"公司名称",
			field:"company_name"
		}],
		search:{
			field:[
			       {display:'用户名',name:'name', newline: false},
			       {display: "公司名称 ", name: "company", newline: false, type: "date"},
			]
	 	},
	 	dialog : {
			labelWidth : 80,
			height : 350,
			width : 350,
		}
	};
	
	$("#maingrid").crud(options);
	var grid = $("#maingrid").crud("getDatagrid");
});