$(function(){
	var options = {
		removeUrl : '../person/delete.do',
		saveUrl : '../person/add.do',
		updateUrl : '../person/modify.do',
		grid:{
			dataUrl : '../person/query.do',
			idField : 'id',
			pageSize : 15,
			pageList: [10, 15, 20, 25, 30],
			checkbox : true,
		},
		fields:[{
			title:"姓名",
			field:"name",
			gridWidth:"15%"
		},{
			title:"年龄",
			field:"age",
			gridWidth:"10%"
		},{
			title:"性别",
			field:"sex",
			gridWidth:"7%",
			render: function (row){
				if(row.sex==1)return "男";
				else return "女";
			},
		},{
			title:"联系电话",
			field:"phone",
			gridWidth:"15%"
		},{
			title:"住址",
			field:"curr_address",
			gridWidth:"15%"
		},{
			title:"公司名称",
			field:"company_name",
			gridWidth:"15%"
		},{
			title:"备注",
			field:"remarks",
			gridWidth:"20%"
		}],
		search:{
			labelWidth:70,
			field:[
			       {display:'用户名',name:'name', newline: false},
			       {display: "公司名称",name: "company", newline: false},
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