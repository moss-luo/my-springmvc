var grid,manager;
$(function ()
{
    $("#txtName").ligerTextBox();
    
	manager = grid = $("#maingrid").ligerGrid({
        columns: [
            { display: '序号', name: 'id'},
            { display: '姓名', name: 'name'},
            { display: '年龄', name: 'age'},
            { display: '籍贯', name: 'address'},
            { display: '所属公司', name: 'company'}
                 ], 
        url:'query.do',  
        pageSize:15 ,
        checkbox:true,
        width : '99%',
        rownumbers:true,
        clickToEdit:true, 
        toolbar: { items: [
                { text: '增加', click: addItem, icon: 'add' },
                { line: true },
                { text: '修改', click: modifyCategory, icon: 'modify' },
                { line: true },
                { text: '删除', click: deleteItem, icon: 'delete' }
                
        	]
        }
    });
     

    $("#pageloading").hide();
    
    $("#queryBtn").click(function(){
    	alert("未实现！！！");
    });
});
function addItem(item){
	warning("未实现！！！");
}

function deleteItem(item){
	alert("未实现！！！");
}


function modifyCategory() { 
	warning("未实现！！！");
}


function successHandle(data){
	var content = data.msg;
	if(data.success){
		grid.loadData();
	}
	var tip = $.ligerDialog.tip({ title: '提示信息',timeout:1200, content: content });
    tip.show();
    setTimeout(function (){tip.hide();},2000);
}
function warning(content){
	var tip = $.ligerDialog.tip({ title: '提示信息',timeout:1200, content: content });
    tip.show();
    setTimeout(function (){tip.hide();},2000);
}
