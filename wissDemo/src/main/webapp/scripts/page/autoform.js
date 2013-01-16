var groupicon = "../resources/ligerUI/skins/icons/communication.gif";
$(function (){
	data=[{id:1,text:"测试数据1"},{id:2,text:"测试数据2"},{id:3,text:"测试数据3"},{id:4,text:"测试数据4"}];
	
    $("form").ligerForm({
    	inputWidth: 170, labelWidth: 90, space: 40,
    	fields: [{ name: "ProductID", type: "hidden" },
    	         { display: "产品名称", name: "ProductName", newline: true, type: "text" , group: "基础信息", groupicon: groupicon}, 
    	         { display: "供应商", name: "SupplierID", newline: false, type: "select", comboboxName: "CompanyName", options: { initValue:1,data:data } },
    	         { display: "类别 ", name: "CategoryID", newline: true, type: "select", comboboxName: "CategoryName", options: { valueFieldID: "CategoryID" }},
    	         { display: "单价", name: "UnitPrice", newline: false,  type: "number" },
    	         { display: "日期 ", name: "AddTime", newline: true, type: "date"  },
    	         { display: "折扣", name: "QuantityPerUnit", newline: false, type: "number" },
    	         { display: "库存量", name: "UnitsInStock", newline: true, type: "digits", group: "库存", groupicon: groupicon },
    	         { display: "订购量", name: "UnitsOnOrder", newline: false, type: "digits" },
    	         { display: "备注", name: "Remark", newline: true, type: "textarea" ,width:470 }]
    }); 
});  
