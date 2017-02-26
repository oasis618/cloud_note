function deleteNote(){
		var $li=$("#note_ul a.checked").parent();
		var noteId = $li.data("noteId");
		$.ajax({
			url:path+"/note/delete.do",
			type:"post",
			data:{"noteId":noteId},
			dataType:"json",
			success:function(result){
				if(result.status == 0){
					autoLoadNotes();
					alert(result.msg);
					$("#can").html("");
					$(".opacity_bg").hide();
				}else{
					alert(result.msg);
				}
			},
			error:function(){
				alert("删除笔记本失败error");
				}
		});
	}
function noteShare(){
	var $li=$("#note_ul a.checked").parent();
	var noteId = $li.data("noteId");
	var noteTitle = $('#input_note_title').val().trim();
	var noteBody = um.getContent();
	if(noteId == null){
		alert("分享笔记失败!");
		return;
	}
	$.ajax({
		url:path+"/share/add.do",
		type:"post",
		data:{"noteId":noteId,"noteTitle":noteTitle,"noteBody":noteBody},
		dataType:"json",
		success:function(result){
			if(result.status == 0){
				var noteTitle=$li.text();
				var sli="";
				sli+='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'; 
				sli+= noteTitle;
				sli+='<i class="fa fa-sitemap"></i>';
				sli+='<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
				//将笔记li元素的<a>标记内容替换
				$li.find("a").html(sli);
				alert(result.msg);
			}else{
				alert(result.msg);
			}
		},
		error:function(){
			alert("分享笔记本失败error");
			}
	});
}

function btnSlideDown(){
		$("#note_ul div").hide();
		var note_menu=$(this).parents("li").find("div");
		note_menu.slideDown(500);
		//return false阻止冒泡
		return false;
	}

function createNote(){
	var noteTitle = $("#input_note").val().trim();
	var userId = getCookie("userId");
	var $li=$("#book_ul a.checked").parent();
	var bookId = $li.data("bookId");
	var ok=true;
	if(noteTitle==""){
		$("#note_title_span").html("笔记名称不能为空");
		ok=false;
	}
	//防止cookie消失取不到值判断
	if(userId == null){
		ok=false;
		window.location.href="log_in.html";
	}
	if(ok){
	$.ajax({
		url:path+"/note/add.do",
		type:"post",
		data:{"userId":userId,"noteTitle":noteTitle,"bookId":bookId},
		dataType:"json",
		success:function(result){
			if(result.status == 0){
				$("#can").html("");
				$(".opacity_bg").hide();
				$("#note_ul").empty();
				/* var id = result.data.cn_note_id;
				var title = result.data.cn_note_title;
				添加节点返回的result.data为一个Note对象
				createNoteLi(id,title); */
				autoLoadNotes();
				alert(result.msg);
				//重新加载noteLi
			}else{
				alert(result.msg);
			}
		},
		error:function(){
			alert("添加笔记失败error");
			}
});
		
	}
	
}


function autoLoadNotes(){
	var $li=$("#book_ul a.checked").parent();
	var bookId = $li.data("bookId");
	$.ajax({
		url:path+"/note/loadNotes.do",
		type:"post",
		data:{"bookId":bookId},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				var notes=result.data;
				$("#note_ul").empty();
				for(var i=0;i<notes.length;i++){
					var noteName = notes[i].cn_note_title;
					var noteId = notes[i].cn_note_id;
					createNoteLi(noteId,noteName);
				}
			}else{
				$("#note_ul").empty();
				createNoteLi("默认笔记");
			}
		},
		error:function(){
			alert("加载失败");
			}
		});
}
function loadNotes(){
	//设置选中效果
	$("#book_ul a").removeClass("checked")
	$(this).find("a").addClass("checked");
	//获取参数
	bookId = $(this).data("bookId");
	//发送请求
	$.ajax({
		url:path+"/note/loadNotes.do",
		type:"post",
		data:{"bookId":bookId},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				var notes=result.data;
				$("#note_ul").empty();
				$("#pc_part_2").show();
				$("#pc_part_4").hide();
				$("#pc_part_6").hide();
				$("#pc_part_7").hide();
				$("#pc_part_8").hide();
				for(var i=0;i<notes.length;i++){
					var noteName = notes[i].cn_note_title;
					var noteId = notes[i].cn_note_id;
					createNoteLi(noteId,noteName);
				}
			}else{
				$("#note_ul").empty();
				createNoteLi("默认笔记");
			}
		},
		error:function(){
			alert("加载失败");
			}
		});
}
function createNoteLi(noteId,noteName){
	var sli="";
	sli+='<li class="online">';
	sli+='<a>';/* class='checked'先注释 */
	sli+='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
	sli+=noteName;
	sli+='<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
	sli+='</a>';
	sli+='<div class="note_menu" tabindex="-1">';
	sli+='<dl>';
	sli+='<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>';
	sli+='<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
	sli+='<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>';
	sli+='<dt><button type="button" class="btn btn-default btn-xs btn_like" title="收藏"><i class="fa fa-star"></i></button></dt>';
	sli+='</dl>';
	sli+='</div>';
	sli+='</li>';
	var $noteli=$(sli);
	$noteli.data("noteId",noteId);
	$("#note_ul").append($noteli);
	/* alert($noteli.data("noteId")); */
}