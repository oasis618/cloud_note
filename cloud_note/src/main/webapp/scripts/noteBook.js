//收藏笔记
function likeNote(){
	var $li=$("#note_ul a.checked").parent();
	var noteId = $li.data("noteId");
	var userId = getCookie("userId");
	var title = $('#input_note_title').val().trim();
	var body = um.getContent();
	$.ajax({
		url:path+"/like/add.do",
		type:"post",
		data:{"noteId":noteId,"userId":userId,"title":title,"body":body},
		dataType:"json",
		success:function(result){
			if(result.status == 0){
				alert(result.msg);
				$("#can").html("");
				$(".opacity_bg").hide();
			}else{
				alert(result.msg);
			}
		},
		error:function(){
			alert("收藏笔记本失败error");
			}
	});
}
//笔记移动
function moveNote(){
	var bookId=$("#moveSelect").val();
	var $li=$("#note_ul a.checked").parent();
	var noteId = $li.data("noteId");
	$.ajax({
		url:path+"/note/moveNote.do",
		type:"post",
		data:{"bookId":bookId,"noteId":noteId},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				$li.remove();
				$("#can").html("");
				$(".opacity_bg").hide();
				alert(result.msg);
			}else{
				alert(result.msg);
			}
		},
		error:function(){
			alert("笔记移动失败");
			}
		});
}

function loadNoteBook(){
		//设置选中效果
		$("#note_ul a").removeClass("checked");
		$(this).find("a").addClass("checked");
		//获取请求参数
		var noteId = $(this).data("noteId");
		//发送ajax请求
		$.ajax({
			url:path+"/note/loadNoteBook.do",
			type:"post",
			data:{"noteId":noteId},
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
				alert("加载笔记内容失败!")
			}
		});
}
