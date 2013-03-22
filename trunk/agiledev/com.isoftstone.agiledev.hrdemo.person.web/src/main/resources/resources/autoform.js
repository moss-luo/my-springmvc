function diyAddHandle(){
	 $.ligerDialog.open({
			target:$("#diyAddForm"),
			title: "自定义新增（未实现提交）", 
			name:'diyAddFrame',
			width:600,
	 		height:400,
			buttons:[{text:'保存' ,onclick: function (i, d) {  alert("暂未实现");$("input").ligerHideTip(); d.hide();}},
			         {text:'取消' , onclick: function (i, d) { $("input").ligerHideTip(); d.hide();}}]
	});
}

function initDiyForm(){
	data=[{id:1,text:"测试数据1"},{id:2,text:"测试数据2"},{id:3,text:"测试数据3"},{id:4,text:"测试数据4"}];
	
    $("#diyAddForm").ligerForm({
    	inputWidth: 170, labelWidth: 90, space: 40,
    	fields: [{ name: "productID", type: "hidden" },
    	         { display: "产品名称", name: "productName", newline: true, type: "text" , group: "基础信息", groupicon: groupicon}, 
    	         { display: "单价", name: "unitPrice", newline: false,  type: "number" },
    	         { display: "日期 ", name: "addTime", newline: true, type: "date"  },
    	         { display: "折扣", name: "quantityPerUnit", newline: false, type: "number" },
    	         { display: "库存量", name: "unitsInStock", newline: true, type: "digits", group: "库存", groupicon: groupicon },
    	         { display: "订购量", name: "unitsOnOrder", newline: false, type: "digits" },
    	         { display: "备注", name: "remark", newline: true, type: "textarea" ,width:470 }]
    }); 
}

