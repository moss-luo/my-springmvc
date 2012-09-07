var grid,manager;
$(function ()
{
    $("#txtName").ligerTextBox();
    
	manager = grid = $("#maingrid").ligerGrid({
        columns: [
            { display: '序号', name: 'id',width:220},
            { display: '姓名', name: 'name',width:220},
            { display: '年龄', name: 'age',width:210},
            { display: '籍贯', name: 'address',width:250},
            { display: '所属公司', name: 'company',width:250}
                 ], 
        url:'../user/query.do',  
        pageSize:15 ,
        width : '100%',
        rownumbers:true,
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
