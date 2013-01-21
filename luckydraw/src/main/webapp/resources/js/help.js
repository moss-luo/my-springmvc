$(function(){
	$("#exportBtn").click(function(){
		window.location.href="help/export.do";
	});
	
	$("#resetBtn").click(function(){
		if(confirm("该操作将重置所有数据，确定重置吗？")){
			$.ajax({
				url:"help/reset.do",
				success:function(data){
					if(data.success)alert("重置数据成功");
					else alert("重置数据失败");
				}
			});
		}
	});
});