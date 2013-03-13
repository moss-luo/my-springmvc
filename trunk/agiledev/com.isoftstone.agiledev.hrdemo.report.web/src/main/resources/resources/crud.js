(function($){
	var options={
		formInitUrl:'',//表单初始化地址
		saveUrl:"",//新增url
		updateUrl:"",//修改url
		removeUrl:"",//删除url
		uploadUrl:"",	
		
		grid:{
	        title: null,
	        width: 'auto',                          //宽度值
	        height: 'auto',                          //宽度值
	        columnWidth: null,                      //默认列宽度
	        resizable: true,                        //table是否可伸缩
	        url: false,                             //ajax url
	        usePager: true,                         //是否分页
	        page: 1,                                //默认当前页 
	        pageSize: 10,                           //每页默认的结果数
	        pageSizeOptions: [10, 20, 30, 40, 50],  //可选择设定的每页结果数
	        parms: [],                         //提交到服务器的参数
	        columns: [],                          //数据源
	        minColToggle: 1,                        //最小显示的列
	        dataType: 'server',                     //数据源：本地(local)或(server),本地是将读取p.data。不需要配置，取决于设置了data或是url
	        dataAction: 'server',                    //提交数据的方式：本地(local)或(server),选择本地方式时将在客服端分页、排序。 
	        showTableToggleBtn: false,              //是否显示'显示隐藏Grid'按钮 
	        switchPageSizeApplyComboBox: false,     //切换每页记录数是否应用ligerComboBox
	        allowAdjustColWidth: true,              //是否允许调整列宽     
	        checkbox: false,                         //是否显示复选框
	        allowHideColumn: true,                 //是否显示'切换列层'按钮
	        enabledEdit: false,                      //是否允许编辑
	        isScroll: true,                         //是否滚动
	        onDragCol: null,                       //拖动列事件
	        onToggleCol: null,                     //切换列事件
	        onChangeSort: null,                    //改变排序事件
	        onSuccess: null,                       //成功获取服务器数据的事件
	        onDblClickRow: null,                     //双击行事件
	        onSelectRow: null,                    //选择行事件
	        onUnSelectRow: null,                   //取消选择行事件
	        onBeforeCheckRow: null,                 //选择前事件，可以通过return false阻止操作(复选框)
	        onCheckRow: null,                    //选择事件(复选框) 
	        onBeforeCheckAllRow: null,              //选择前事件，可以通过return false阻止操作(复选框 全选/全不选)
	        onCheckAllRow: null,                    //选择事件(复选框 全选/全不选)
	        onBeforeShowData: null,                  //显示数据前事件，可以通过reutrn false阻止操作
	        onAfterShowData: null,                 //显示完数据事件
	        onError: null,                         //错误事件
	        onSubmit: null,                         //提交前事件
	        dateFormat: 'yyyy-MM-dd',              //默认时间显示格式
	        InWindow: true,                        //是否以窗口的高度为准 height设置为百分比时可用
	        statusName: '__status',                    //状态名
	        method: 'post',                         //提交方式
	        async: true,
	        fixedCellHeight: true,                       //是否固定单元格的高度
	        heightDiff: 0,                         //高度补差,当设置height:100%时，可能会有高度的误差，可以通过这个属性调整
	        cssClass: null,                    //类名
	        root: 'Rows',                       //数据源字段名
	        record: 'Total',                     //数据源记录数字段名
	        pageParmName: 'page',               //页索引参数名，(提交给服务器)
	        pagesizeParmName: 'pagesize',        //页记录数参数名，(提交给服务器)
	        sortnameParmName: 'sortname',        //页排序列名(提交给服务器)
	        sortorderParmName: 'sortorder',      //页排序方向(提交给服务器)
	        onReload: null,                    //刷新事件，可以通过return false来阻止操作
	        onToFirst: null,                     //第一页，可以通过return false来阻止操作
	        onToPrev: null,                      //上一页，可以通过return false来阻止操作
	        onToNext: null,                      //下一页，可以通过return false来阻止操作
	        onToLast: null,                      //最后一页，可以通过return false来阻止操作
	        allowUnSelectRow: false,           //是否允许反选行 
	        alternatingRow: true,           //奇偶行效果
	        mouseoverRowCssClass: 'l-grid-row-over',
	        enabledSort: true,                      //是否允许排序
	        rowAttrRender: null,                  //行自定义属性渲染器(包括style，也可以定义)
	        groupColumnName: null,                 //分组 - 列名
	        groupColumnDisplay: '分组',             //分组 - 列显示名字
	        groupRender: null,                     //分组 - 渲染器
	        totalRender: null,                       //统计行(全部数据)
	        delayLoad: false,                        //初始化时是否不加载
	        where: null,                           //数据过滤查询函数,(参数一 data item，参数二 data item index)
	        selectRowButtonOnly: false,            //复选框模式时，是否只允许点击复选框才能选择行
	        onAfterAddRow: null,                     //增加行后事件
	        onBeforeEdit: null,                      //编辑前事件
	        onBeforeSubmitEdit: null,               //验证编辑器结果是否通过
	        onAfterEdit: null,                       //结束编辑后事件
	        onLoading: null,                        //加载时函数
	        onLoaded: null,                          //加载完函数
	        onContextmenu: null,                   //右击事件
	        whenRClickToSelect: false,                //右击行时是否选中
	        contentType: null,                     //Ajax contentType参数
	        checkboxColWidth: 27,                  //复选框列宽度
	        detailColWidth: 29,                     //明细列宽度
	        clickToEdit: true,                      //是否点击单元格的时候就编辑
	        detailToEdit: false,                     //是否点击明细的时候进入编辑
	        onEndEdit: null,
	        minColumnWidth: 80,
	        tree: null,                            //treeGrid模式
	        isChecked: null,                       //复选框 初始化函数
	        frozen: true,                          //是否固定列
	        frozenDetail: false,                    //明细按钮是否在固定列中
	        frozenCheckbox: true,                  //复选框按钮是否在固定列中
	        detailHeight: 260,
	        rownumbers: false,                         //是否显示行序号
	        frozenRownumbers: true,                  //行序号是否在固定列中
	        rownumbersColWidth: 26,
	        colDraggable: false,                       //是否允许表头拖拽
	        rowDraggable: false,                         //是否允许行拖拽
	        rowDraggingRender: null,
	        autoCheckChildren: true,                  //是否自动选中子节点
	        onRowDragDrop: null,                    //行拖拽事件
	        rowHeight: 22,                           //行默认的高度
	        headerRowHeight: 23,                    //表头行的高度
	        toolbar: null,                           //工具条,参数同 ligerToolbar的
	        headerImg: null                        //表格头部图标
		},
		fields:[]
	};
	
	$.fn.crud = function(){
		var render = new Render(this);
		
		if(arguments.length == 1 && typeof arguments[0] == "object"){
			this.setting = $.extend(true,options,arguments[0]);
		}
		
		this.init = function(){
			render.createDatagrid();
			render.createSearch();
		}
	}
	
	/**
	 * 页面构造器,创建页面上各种组件
	 */
	function Render(plugin){
		this.plugin = plugin;
	}
	
	Render.prototype.createDatagrid=function(){
		
	}
	
	
})(jQuery);