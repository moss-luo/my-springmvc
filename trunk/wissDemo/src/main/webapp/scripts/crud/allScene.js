var groupicon = "../resources/ligerUI/skins/icons/communication.gif";
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
			toolbars:{items:[{id:'diyAdd',text:'自定义新增',icon:'add',click:diyAddHandle}]}
		},
		fields:[{
			field:"id",
			type:"hidden",
			gridShow:false,
			initData:0
		},{
			title:"姓名",
			field:"name",
			gridWidth:"15%",
			render:function(row){
				return '<a class="command" href="#" onclick=viewItem(\''+row.id+'\')>'+row.name+'</a>';
			},
			group: "基本信息", 
			groupicon: groupicon
		},{
			title:"年龄",
			field:"age",
			newline: false,
			type:"digits",
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
			gridWidth:"15%",
			group: "其他信息", 
			groupicon: groupicon
		},{
			title : '上传头像',
			field : 'uploadImage',
			newline:false,
			fieldWidth:120,
			gridShow : false,
			type:'file',
			upload:{
				action:'../person/upload.do',
				autoSubmit:true,
				name:'file',
				onChange:function(file, extension){
				extension = extension.toLowerCase();
		           if (extension && /^(jpg|png|gif)$/.test(extension)) {
		        	   $("#uploadImage").val(file);
		        	   return true;
		           }else {
		        	   tip("文件格式不对,请重新上传");
		        	   return false;
		            }
				},
				onComplete:function(file,response){
					tip(file+response);
				}
			}
		},{
			title:"备注",
			field:"remarks",
			gridWidth:"20%",
			fieldWidth:485,
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
			labelWidth : 90,
			inputWidth: 177,
			height : 300,
			width : 650,
			height:400,
		},
		validate:{
			rules:{
				name:{required:true,rangelength:[ 5, 12 ]},
				age:{required:true,min:18,max:120},
				phone:{required:true,maxlength:12},
				identity_card_num:{required:true,maxlength:18},
				company_name:{required:true,maxlength:255},
				curr_address:{required:true,maxlength:255},
				uploadImage:{required:true},
				remarks:{required:true,maxlength:255}
			},
			messages:{
				name:{required : "请输入用户名！",rangelength:"用户名长度为 {0} 和 {1} 位字符之间"},
				age:{required : "请输入年龄！",min:"年龄必须不能小于 {0}",max:"年龄不能大于 {0}"},
				phone:{required:"请输入联系电话！",max:"联系电话长度不能大于 {0}位字符"},
				identity_card_num:{required:"请输入身份证号！",max:"身份证号长度不能大于 {0}位字符"},
				company_name:{required:"请输入公司名！",max:"公司名长度不能大于 {0}位字符"},
				curr_address:{required:"请输入住址！",max:"住址长度不能大于 {0}位字符"},
				uploadImage:{required:"请上传您的头像！"},
				remarks:{required:"请输入备注信息！",max:"备注信息长度不能大于 {0}位字符"}
			}
		}

	};
	
	$("#maingrid").crud(options);
	var grid = $("#maingrid").crud("getDatagrid");
	initDiyForm();
});

function viewItem(id){
	var personData;
	$.ajax({
		type: "POST",
		   url:'../person/viewPerson.do',
		   dataType:'json',
		   data:{id:id},
		   success: function(data){
			   personData = data;
		   }
	});
	
	
}

function tip(msg){
	var tip = $.ligerDialog.tip({ title: '提示信息',timeout:1500, content: msg });
    tip.show();
    setTimeout(function (){tip.hide();},3000);
}