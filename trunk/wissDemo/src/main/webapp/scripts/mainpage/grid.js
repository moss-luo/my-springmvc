var grid,manager;
$(function ()
{
    $("#txtName").ligerTextBox();
    
	manager = grid = $("#maingrid").ligerGrid({
        columns: [
            { display: '设备编号', name: 'id',width:220},
            { display: '姓名', name: 'name',width:220},
            { display: '所持卡号', name: 'age',width:210},
            { display: '使用时间', name: 'address',width:250},
            { display: '使用类型（出/进）', name: 'company',width:250}
                 ], 
        url:'info.do',  
        pageSize:15 ,
        width : '100%',
        rownumbers:true
        }
    );
     

    $("#pageloading").hide();
   
});
