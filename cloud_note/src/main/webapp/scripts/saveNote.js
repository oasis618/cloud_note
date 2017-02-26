function saveNote(){
	var $li=$("#note_ul a.checked").parent();
	var mNoteId = $li.data("noteId");
	var mTitle = $('#input_note_title').val().trim();
	var mBody = um.getContent();
	//alert(mNoteId+"-->"+mTitle+"-->"+mBody);
	$.ajax({
		url:path+"/note/updateNote.do",
		type:"post",
		data:{"mNoteId":mNoteId,"mTitle":mTitle,"mBody":mBody},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				var str = "";
				str+='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
				str+=mTitle;
				str+='<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
				$li.find("a").html(str);
				alert(result.msg);
			}else{
				alert("保存笔记失败");
				$('#input_note_title').val("");
				um.setContent("");
			}
		},
		error:function(){
			alert("保存笔记失败error");
			$('#input_note_title').val("");
			um.setContent("");
		}
	});
}