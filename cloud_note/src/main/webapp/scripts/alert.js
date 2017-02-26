function alertLikeNoteWindow(){
		var $li=$("#note_ul a.checked").parent();
		var noteId = $li.data("noteId");
		//alert(noteId);
		if(noteId == null){
			alert("请先选定笔记!")
		}else{
			//弹出新建笔记对话框
			$("#can").load("alert/alert_like.html");
			//显示背景
			$(".opacity_bg").show();
		}
	}
function alertMoveNoteWindow(){
	var $li=$("#note_ul a.checked").parent();
	var noteId = $li.data("noteId");
	//alert(noteId);
	if(noteId == null){
		alert("请先选定笔记!")
	}else{
		$("#can").load("alert/alert_move.html");
		var userId = getCookie("userId");
		if(userId==null){
			window.location.href="log_in.html";
		}else{//发送Ajax请求
			$.ajax({
				url:path+"/book/loadBook.do",
				type:"post",
				data:{"userId":userId},
				dataType:"json",
				success:function(result){
					if (result.status==0) {
						$("#moveSelect").empty();
						var books=result.data;
					for(var i=0;i<books.length;i++){
						var bookId=books[i].cn_notebook_id;
						var bookName=books[i].cn_notebook_name;
						loadBookLi(bookId,bookName);
						}
					}else{
						loadBookLi(bookId,"默认笔记本");
					}
				},
				error:function(){
					alert("笔记本列表加载失败");
					}
				});
				
			}
		$(".opacity_bg").show();
	}
}
function loadBookLi(bookId,bookName){
	var sli="";
	sli+='<option value='+bookId+'>'+bookName+'</option>';
	var $option=$(sli);
	$option.data("bookId",bookId);
	$("#moveSelect").append($option);
	}

function alertReplayWindow(){
	var $li=$("#rollback_ul a.checked").parent();
	var noteId = $li.data("rollbackId");
	if(noteId == null){
		alert("请先选定笔记!")
	}else{
		$("#can").load("alert/alert_replay.html");
		var userId = getCookie("userId");
		if(userId==null){
			window.location.href="log_in.html";
		}else{//发送Ajax请求
			$.ajax({
				url:path+"/book/loadBook.do",
				type:"post",
				data:{"userId":userId},
				dataType:"json",
				success:function(result){
					if (result.status==0) {
						$("#replaySelect").empty();
						var books=result.data;
					for(var i=0;i<books.length;i++){
						var bookId=books[i].cn_notebook_id;
						var bookName=books[i].cn_notebook_name;
						replayLoadBookLi(bookId,bookName);
						}
					}else{
						replayLoadBookLi(bookId,"默认笔记本");
					}
				},
				error:function(){
					alert("笔记本列表加载失败");
					}
				});
				
			}
		$(".opacity_bg").show();
	}
}
function replayLoadBookLi(bookId,bookName){
	var sli="";
	sli+='<option value='+bookId+'>'+bookName+'</option>';
	var $option=$(sli);
	$option.data("bookId",bookId);
	$("#replaySelect").append($option);
	}

function alertRollbackNoteWindow(){
		var $li=$("#rollback_ul a.checked").parent();
		var noteId = $li.data("rollbackId");
		//alert(noteId);
		if(noteId == null){
			alert("请先选定笔记!")
		}else{
			//弹出新建笔记对话框
			$("#can").load("alert/alert_delete_rollback.html");
			//显示背景
			$(".opacity_bg").show();
		}
	}

function alertDeleteNoteWindow(){
		var $li=$("#note_ul a.checked").parent();
		var noteId = $li.data("noteId");
		//alert(noteId);
		if(noteId == null){
			alert("请先选定笔记!")
		}else{
			//弹出新建笔记对话框
			$("#can").load("alert/alert_delete_note.html");
			//显示背景
			$(".opacity_bg").show();
		}
	}

function alertAddNoteWindow(){
	var $li=$("#book_ul a.checked").parent();
	var bookId = $li.data("bookId");
	//alert(noteId);
	if(bookId == null){
		alert("请先选定笔记本!")
	}else{
		//弹出新建笔记对话框
		$("#can").load("alert/alert_note.html");
		//显示背景
		$(".opacity_bg").show();
	}
}

function alertAddBookWindow(){
	//弹出新建笔记本对话框
	$("#can").load("alert/alert_notebook.html");
	//显示背景
	$(".opacity_bg").show();
}
function closeAlertWindow(){
	//清空div内容
	$("#can").html("");
	//$("#can").empty();
	//隐藏背景
	$(".opacity_bg").hide();
}