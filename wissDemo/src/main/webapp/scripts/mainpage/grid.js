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
        rownumbers:true
        }
    );
     

    $("#pageloading").hide();
   
});
