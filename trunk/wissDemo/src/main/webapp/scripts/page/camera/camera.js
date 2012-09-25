var grid,manager;
$(function ()
{
    $("#txtName").ligerTextBox();
    
	manager = grid = $("#camera").ligerGrid({
        columns: [
          // { display: '序号', name: 'id',width:220},
            { display: '摄像头名称', name: 'cname',width:220},
            { display: '摄像头型号', name: 'ctype',width:237},
            { display: '数量',  name: 'count',width:237},
            { display: '编辑',  name: 'count',width:237},
                 ], 
        url:'../../camera/query.do',  
        pageSize:15 ,
        width : '99.8%',
        rownumbers:true,
        checkbox :true,
      //  showTitle : true,
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
