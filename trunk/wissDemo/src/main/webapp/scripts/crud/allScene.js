$(function(){
	var sexData=[{id:"0",text:"女"},{id:"1",text:"男"}];
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
			field:"id",
			type:"hidden",
			gridShow:false,
			initData:0
		},
		{
			title:"姓名",
			field:"name",
			gridWidth:"15%",
			render:function(row){
				return '<a class="command" href="#" onclick=viewItem(\''+row.id+'\')>'+row.name+'</a>';
			}
		},{
			title:"年龄",
			field:"age",
			newline: false,
			type:"digits",
			initData:"1",
			gridWidth:"10%"
		},{
			title:"性别",
			field:"sex",
			gridWidth:"7%",
			type:"select",
			options: {initValue:"0",data:sexData},
			render: function (row){
				if(row.sex==="1")return "男";
				else return "女";
			},
		},{
			title:"联系电话",
			field:"phone",
			newline: false,
			gridWidth:"15%"
		},{
			title:"身份证号码",
			field:"identity_card_num",
			gridShow:false
		},{
			title:"公司名称",
			newline: false,
			field:"company_name",
			gridWidth:"15%"
		},{
			title:"住址",
			field:"curr_address",
			fieldWidth:440,
			gridWidth:"15%"
		},{
			title:"备注",
			field:"remarks",
			gridWidth:"20%",
			fieldWidth:440,
			type:"textarea"
		}],
		search:{
			labelWidth:70,
			field:[
			       {display:'姓名',name:'name', newline: false},
			       {display:'公司名称',name:'company_name', newline: false},
			       {display: "性别",name: "sex", newline: false,type:"select",options: { initValue:0,data:sexData}},
			],
			buttons:[{text:'自定义按钮',id:'diySearchButton',handle:function(){alert("test");}}]
	 	},
	 	dialog : {
			labelWidth : 80,
			height : 300,
			width : 580,
		}
	};
	
	$("#maingrid").crud(options);
	var grid = $("#maingrid").crud("getDatagrid");
});

function viewItem(id){
	alert(id);
}