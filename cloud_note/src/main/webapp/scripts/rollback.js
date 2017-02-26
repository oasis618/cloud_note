function rollbackNote(){
	var $li=$("#rollback_ul a.checked").parent();
	var rollbackId = $li.data("rollbackId");
	var bookId=$("#replaySelect").val();
	$.ajax({
		url:path+"/note/replay.do",
		type:"post",
		data:{"rollbackId":rollbackId,"bookId":bookId},
		dataType:"json",
		success:function(result){
			if(result.status == 0){
				$li.remove();
				alert(result.msg);
				$("#can").html("");
				$(".opacity_bg").hide();
			}else{
				alert(result.msg);
			}
		},
		error:function(){
			alert("恢复笔记失败error");
			}
	});
}
function aDeleteNote(){
		var $li=$("#rollback_ul a.checked").parent();
		var rollbackId = $li.data("rollbackId");
		$.ajax({
			url:path+"/note/aDelete.do",
			type:"post",
			data:{"rollbackId":rollbackId},
			dataType:"json",
			success:function(result){
				if(result.status == 0){
					$li.remove();
					alert(result.msg);
					$("#can").html("");
					$(".opacity_bg").hide();
				}else{
					alert(result.msg);
				}
			},
			error:function(){
				alert("彻底删除笔记本失败error");
				}
		});
	}
function loadRollbackNote(){
		//设置选中效果
		$("#rollback_ul a").removeClass("checked");
		$(this).find("a").addClass("checked");
		//获取请求参数
		var rollbackId = $(this).data("rollbackId");
		//发送ajax请求
		$.ajax({
			url:path+"/rollback/loadNote.do",
			type:"post",
			data:{"rollbackId":rollbackId},
			dataType:"json",
			success:function(result){
				if(result.status==0){
					var title = result.data.cn_note_title;
					var body = result.data.cn_note_body;
				//设置笔记标题
					$('#input_note_title').val(title);
				//设置笔记内容
					if(body==null){
						um.setContent("");
					}else{
						um.setContent(body);
					}
				}
			},
			error:function(){
				alert("加载回收站笔记内容失败!")
			}
		});
}

function loadRollback(){
	$("#pc_part_2").hide();
	$("#pc_part_6").hide();
	$("#pc_part_7").hide();
	$("#pc_part_8").hide();
	$("#pc_part_4").show();
	var userId = getCookie("userId");
	$.ajax({
		url:path+"/rollback/load.do",
		type:"post",
		data:{"userId":userId},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				$("#rollback_ul").empty();
				var notes = result.data;
				for(var i=0;i<notes.length;i++){
					var noteTitle = notes[i].cn_note_title;
					var noteId = notes[i].cn_note_id;
					createRollNotes(noteTitle,noteId);
				}
			}else{
				alert(result.msg);
			}
		},
		error:function(){
			alert("回收站error");
			}
	});
}
function createRollNotes(noteTitle,noteId){
		//虚假回收站笔记
		var lis="";
		lis+='<li class="disable">';
		lis+='<a >';
		lis+='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
		lis+=noteTitle;
		lis+='<button type="button" class="btn btn-default btn-xs btn_position btn_delete">';
		lis+='<i class="fa fa-times"></i>';
		lis+='</button>';
		lis+='<button type="button" class="btn btn-default btn-xs btn_position_2 btn_replay">';
		lis+='<i class="fa fa-reply"></i>';
		lis+='</button>';
		lis+='</a>';
		lis+='</li>';
		var $noteli=$(lis);
		$noteli.data("rollbackId",noteId);
		$("#rollback_ul").append($noteli);
	}