var page =1;
function sureSearchShare(event){
	var code=event.keyCode;
	if(code==13){
		var keys = $("#search_note").val();
		//发送ajax请求
		page =1;
		loadPageShare(keys,page);
	}
}
function lessSearchShare(){
	var keyword=$("#search_note").val().trim();
	if(page ==1 ){
		alert("当前为第一页!");
		return;
	}
	page=page-1;
	//发送Ajax请求加载列表
	loadPageShare(keyword,page);
}

function moreSearchShare(){
	//获取参数
	var keyword=$("#search_note").val().trim();
	page=page+1;
	//发送Ajax请求加载列表
	loadPageShare(keyword,page);
}
function loadShareNote(){
	$("#share_ul a").removeClass("checked")
	$(this).find("a").addClass("checked");
	var shareId = $(this).data("shareId");
	$.ajax({
		url:path+"/share/load.do",
		type:"post",
		data:{"shareId":shareId},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				var title = result.data.cn_share_title;
				var body = result.data.cn_share_body;
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
			}
	});
}

function loadPageShare(keyword,page){
	$.ajax({
		url:path+"/share/search.do",
		type:"post",
		data:{"keys":keyword,"page":page},
		dataType:"json",
		success:function(result){
			if(result.status == 0){
				var datas = result.data;
				$("#share_ul").empty();
				for(var i=0;i<datas.length;i++){
					var shareId = datas[i].cn_share_id;
					var shareTitle = datas[i].cn_share_title;
					createShareLi(shareId,shareTitle);
				}
				$("#pc_part_2").hide();
				$("#pc_part_4").hide();
				$("#pc_part_6").show();
				$("#pc_part_7").hide();
				$("#pc_part_8").hide();
			}else{
				alert("没有更多搜索结果了!");
			}
		},
		error:function(){
			alert("查询分享笔记本失败error");
			}
	});
}
function btnSlideDownShare(){
	$("#share_ul div").hide();
	var note_menu=$(this).parents("li").find("div");
	note_menu.slideDown(500);
	//return false阻止冒泡
	return false;
}
function createShareLi(shareId,shareTitle){
	var sli="";
	sli+='<li class="online">';
	sli+='<a>';/*  class="checked"*/
	sli+='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom">';
	sli+='</i>'+shareTitle;
	sli+='<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
	sli+='</a>';
	sli+='<div class="note_menu" tabindex="-1">';
	sli+='<dl>';
	sli+='<dt><button type="button" class="btn btn-default btn-xs btn_like" title="收藏"><i class="fa fa-star"></i></button></dt>';
	sli+='</dl>';
	sli+='</div>';
	sli+='</li>';
	var $li=$(sli);
	$li.data("shareId",shareId);
	$("#share_ul").append($li);
}