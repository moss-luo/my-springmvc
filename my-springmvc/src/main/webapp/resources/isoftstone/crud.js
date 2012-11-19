/**
 * @author luoting 
 * @version 1.0.0
 */

(function($){
	var options={
		formInitUrl:'',//表单初始化地址
		saveUrl:"",//新增url
		updateUrl:"",//修改url
		removeUrl:"",//删除url
		uploadUrl:"",//上传url	
		
		grid:{
			addable:true,							//是否可新增
			updateable:true,						//是否可修改
			deleteable:true,						//是否可删除
			bulkDeleteable:true,					//是否可以批量删除
			idField:null,							//主键列
			render:null,							//单元格渲染
			
	        title: null,							//标题
	        width: 'auto',                          //宽度值
	        height: 'auto',                         //宽度值
	        dataUrl: false,                         //ajax url
	        pagination: true,                       //是否分页
	        pageSize: 10,                           //每页默认的结果数
	        pageList: [10, 20, 30, 40, 50],  		//可选择设定的每页结果数
	        checkbox: false,                        //是否显示复选框
	        singleSelect:false,						//是否单选模式 
	        
	        toolbars: null,                          		//工具条,参数同 ligerToolbar的
	        validateDelete:function(){return true;}			 //删除校验，默认校验通过
	     	},
		search:{
			inputWidth: 170, 
			labelWidth: 50, 
			space: 20,
			field:[],//field:[{ display: "类别 ", name: "CategoryID", newline: true, type: "select", comboboxName: "CategoryName", options: { valueFieldID: "CategoryID" }, width: 240 }]
			buttons:[],
			beforeSubmit:function(){return true;}},
		fields:[]
	};
	
	$.fn.crud = function(){
		var render = new Render(this);
		var handle = new Handle(this);
		if(arguments.length == 1 && typeof arguments[0] == "object"){
			this.setting = $.extend(true,options,arguments[0]);
		}else if(arguments.length>=1 || typeof arguments[0] == "string"){
			var methodName = arguments[0];
			return !!eval(methodName)?eval(methodName).call(this,render,handle,arguments):this;
		}
		
		
		this.init = function(){
			render.createDatagrid();
			render.createSearch();
		}
		//对外接口，返回datagrid
		function getDatagrid(render,handle,args){
			return options.globalDatagrid;
		}
		
		this.getRender = function(){
			return render;
		}
		this.getHandle = function(){
			return handle;
		}
		this.init();
		return this;
	}
	
	/**
	 * 页面构造器,创建页面上各种组件
	 */
	function Render(plugin){
		this.plugin = plugin;
	}
	
	Render.prototype.createDatagrid=function(){
		columns = $([]),frozenColumns = $([]),$this = this,selectObj=null,buttons=null;
		if(this.plugin.setting.grid.toolbars!=null){
			buttons = $(this.plugin.setting.grid.toolbars.items);
		}else{
			buttons = $([]);
		}
		//判断是否可以进行删除操作
		if(options.grid.deleteable){
			buttons = buttons.add({
				id:'btnDelete',
				text:'删除',
				icon:'delete',
				click:$this.plugin.getHandle().remove
			});
		}
		
		//判断是否可以进行修改操作
		if(options.grid.updateable){
			buttons = buttons.add({
				id:'btnModify',
				text:'修改',
				icon:'modify',
				click:$this.plugin.getHandle().modify
			});
		}
		
		
		//fields:[{name:'First Name',field:'firstName',class:'',show:true,frozen:false,type:'input',required,validateType:'',sortable:true}]  show:是否在grid里显示,frozen:是否在grid里冻结
		$.each(options.fields,function(i,f){
			var c = $.extend({display:f.title,name:f.field,width:"",checkbox:false},f);
			if(f.frozen == true){ 
				frozenColumns = frozenColumns.add(c);
			}else if(f.gridShow != false){
				columns = columns.add(c);				
			}
			
		});
		
		options.globalDatagrid = $(this.plugin.selector).ligerGrid({
			title:options.grid.title,
			url:options.grid.dataUrl,
			pageSize: options.grid.pageSize, 
			pageSizeOptions:options.grid.pageList,
            width: options.grid.width,
            height: options.grid.height, 
            checkbox: options.grid.checkbox,
            columns:columns,
            usePager: options.grid.pagination,
            render:options.grid.render,
            
            pageParmName: 'page',               //页索引参数名，(提交给服务器)
	        pagesizeParmName: 'rows',        	//页记录数参数名，(提交给服务器)
	        sortnameParmName: 'sort',        	//页排序列名(提交给服务器)
	        sortorderParmName: 'order',     	//页排序方向(提交给服务器)
	        root: 'rows',                       //数据源字段名
	        record: 'total',                    //数据源记录数字段名
	        
	        onCheckRow: function(checked, rowdata, rowindex) {
	        	if(options.grid.singleSelect){
	        		if(selectObj==rowindex && !checked){
	        			this.unselect(rowindex);
	        		}else{
	        			for (var rowid in this.records)
	        				this.unselect(rowid);
	        			this.select(rowindex);
	        			selectObj = rowindex;
	        		}
	        	}
            },
            onSelectRow:function(rowdata, rowindex, rowDomElement){
            	if(options.globalDatagrid.getSelectedRows().length==options.globalDatagrid.recordNumber){
            		if(!$(".l-grid-hd-row").hasClass('l-checked')) $(".l-grid-hd-row").addClass('l-checked');
            	}
            	$this.plugin.getHandle().selectHandle();
            	
            },
            onUnSelectRow:function(rowdata, rowindex, rowDomElement){
            	if(options.globalDatagrid.getSelectedRows().length<options.globalDatagrid.recordNumber){
            		if($(".l-grid-hd-row").hasClass('l-checked')) $(".l-grid-hd-row").removeClass('l-checked');
            	}
            	$this.plugin.getHandle().selectHandle();
            },
            toolbar:{items:buttons}
		});
		
		if(options.grid.singleSelect){
			$(".l-grid-hd-cell-btn-checkbox").css("display", "none");　//隐藏checkAll
		}
		$("#pageloading").hide();
		
		$(".l-icon.l-icon-delete").removeClass('l-icon-delete').toggleClass('l-icon-undelete');
		$("[toolbarid='btnDelete']").unbind('mouseenter mouseleave click');  
		
		$(".l-icon.l-icon-modify").removeClass('l-icon-modify').toggleClass('l-icon-unmodify');
		$("[toolbarid='btnModify']").unbind('mouseenter mouseleave click'); 
		
	}
	
	/**
	 * 创建查询
	 */
	Render.prototype.createSearch = function(){
		if(options.search.field.length==0)return;
		
		$(document.createElement("div"))
			.attr({'class':'l-clear'})
			.prependTo($(this.plugin.selector).parent());
		var searchPanel= $(document.createElement("form"))
							.attr({'ligerForm':'search-form'})
							.prependTo($(this.plugin.selector).parent()),
			$this = this,searchForm;
		
		//构造form查询表单
		if(options.search.field.length>0){
			searchPanel.ligerForm({
				inputWidth: options.search.inputWidth, 
				labelWidth: options.search.labelWidth, 
				space: options.search.space,
				fields:options.search.field
			});
			//自定义按钮(随机ID遗留)
			if(options.search.buttons.length>0){
				$.each(options.search.buttons,function(i,n){
					searchPanel.append("<li style='width:100px;text-align:left;'>" +
							"<input type='button' value='"+n.text+"' " +
							"id='"+n.id+"' style=' margin-top: 0px;' class='l-button'/></li> ");
					$("#"+n.id).click(n.handle);
				});
			}
			//默认按钮：查询、重置
			searchPanel.append("<li style='width:100px;text-align:left;'>" +
				"<input type='button' value='查  询' id='lbtn-query' style=' margin-top: 0px;' class='l-button'/></li> ");
			searchPanel.append("<li style='width:100px;text-align:left;'>" +
				"<input type='reset' value='重  置' id='lbtn-reset' style=' margin-top: 0px;' class='l-button'/></li> ");
			
			
			$("#lbtn-query").click(function(){
				if(options.search.beforeSubmit){
					if(options.search.beforeSubmit.call(this.searchPanel)){
						var data= $([]);
						data = $.map(options.search.field,function(n,i){
							var temp = {name:null,value:null};
							temp.name = n.name;
							temp.value = $("#"+n.name).val();
							return temp;
						});
						console.log(data);
						options.globalDatagrid.setOptions({params:data});
						options.globalDatagrid.loadData(true);
					}
				}
			});
		}
		
		options.globalSearchform = searchPanel;
	}
	
	/**
	 * 页面处理器,处理页面的操作
	 */
	function Handle(plugin){
		this.plugin = plugin;
	}
	
	/**
	 * 删除选中行
	 */
	Handle.prototype.remove=function(){
		var rows = options.globalDatagrid.getSelectedRows(),$this = this;
		if(!options.grid.validateDelete()){
	  		var tip = $.ligerDialog.tip({ title: '提示信息',timeout:1200, content: '自定义删除校验不通过!'});
	  	    tip.show();
	  	    setTimeout(function (){
	  	    		tip.hide();
	  	    	},1500);
	  	    return ;
		}
		
		if(rows.length>0){
			$.ligerDialog.confirm('确定删除选中的数据吗?', 
				function (yes){
		            if(yes){
						$.ajax({
							url:options.removeUrl,
							data:{ids:$.map(rows,function(n){return n[options.grid.idField];}).join(',')},
							success: function(data){
								if(typeof data == "string") data = eval('(' + data + ')');
							  	if(data.success){
							  		var tip = $.ligerDialog.tip({ title: '提示信息',timeout:1200, content: data.msg });
							  	    tip.show();
							  	    setTimeout(function (){
							  	    		tip.hide();
							  	    		options.globalDatagrid.loadData(true);
							  	    	},1500);
								}else{
							  		var tip = $.ligerDialog.tip({ title: '提示信息',timeout:1200, content: data.msg });
							  	    tip.show();
							  	    setTimeout(function (){
							  	    		tip.hide();
							  	    	},1500);
								}
							 }
						});
		            }
		        });	
		}else{
			var tip = $.ligerDialog.tip({ title: '提示信息',timeout:1200, content: '请选择您要删除的选项' });
	  	    tip.show();
	  	    setTimeout(function (){
	  	    		tip.hide();
	  	    	},1500);
		}
	}
	//生成随机数
	Render.prototype.getRandom = function(){
		var guid = new Date().getTime(), i;

		for (i = 0; i < 5; i++) {
			guid += Math.floor(Math.random() * 65535);
		}
		
		return  guid ;

	}
	/**
	 * 修改处理函数
	 */
	Handle.prototype.modify=function(){
		$this.plugin.getHandle().createDialog();
	}
	/**
	 * 处理选中checkbox
	 */
	Handle.prototype.selectHandle=function(){
		var removeable = false;
		if(options.grid.bulkDeleteable){
			removeable = options.globalDatagrid.getSelectedRows().length>0;
		}else{
			removeable = options.globalDatagrid.getSelectedRows().length==1;
		}
		
		if(removeable){
			$("[toolbarid='btnDelete']").bind('click',$this.plugin.getHandle().remove);
    		$("[toolbarid='btnDelete']").hover(function(){$(this).addClass('l-panel-btn-over');}
    											,function(){$(this).removeClass('l-panel-btn-over');});
    		$(".l-icon.l-icon-undelete").removeClass('l-icon-undelete').toggleClass('l-icon-delete');
    	}else{
    		$(".l-icon.l-icon-delete").removeClass('l-icon-delete').toggleClass('l-icon-undelete');
    		$("[toolbarid='btnDelete']").unbind('mouseenter mouseleave click');  
    	}
		
		if(options.globalDatagrid.getSelectedRows().length==1){
			$("[toolbarid='btnModify']").bind('click',$this.plugin.getHandle().modify);
    		$("[toolbarid='btnModify']").hover(function(){$(this).addClass('l-panel-btn-over');}
    											,function(){$(this).removeClass('l-panel-btn-over');});
    		$(".l-icon.l-icon-unmodify").removeClass('l-icon-unmodify').toggleClass('l-icon-modify');
		}else{
			$(".l-icon.l-icon-modify").removeClass('l-icon-modify').toggleClass('l-icon-unmodify');
    		$("[toolbarid='btnModify']").unbind('mouseenter mouseleave click'); 
		}
	}
	
	Handle.prototype.createDialog=function(title,data){
		options._dialog = $.ligerDialog.open({
			
			title:title,
			buttons:[{text:'保存'},
			         {text:'取消'}
			         ]
		});
	}
	
})(jQuery);