
//创建笔记本
function createBook(){
		var inputBookTitle = $('#input_notebook').val().trim();
		if(inputBookTitle==""){
			$("#book_title_span").html("笔记本名称不能为空");
			return;
		}
		var userId = getCookie("userId");
		$.ajax({
			url:path+"/book/add.do",
			type:"post",
			data:{"userId":userId,"inputBookTitle":inputBookTitle},
			dataType:"json",
			success:function(result){
				if(result.status == 0){
					alert(result.msg);
					$("#can").html("");
					$(".opacity_bg").hide();
					$("#book_ul").empty();
					loadUserBooks();
				}else{
					alert(result.msg);
				}
			},
			error:function(){
				alert("添加笔记本失败error");
				}
	});
	}

//加载所有Book
function loadUserBooks(){
	//获取userId
	var userId = getCookie("userId");
	//判断是否获取到有效userId
	if(userId==null){
		//location.href(path+"/log_in.html");
		/*
		 * 下面的格式可以在IE中正常执行，但是不能在Firefox和Chrome中执行：
      		window.location.href("http://stackoverflow.com");
			下面的格式可以以上三个浏览器中全部正常执行：
     		window.location.href = "http://stackoverflow.com";
		 */
		window.location.href="log_in.html";

	}else{//发送Ajax请求
		$.ajax({
			url:path+"/book/loadBook.do",
			type:"post",
			data:{"userId":userId},
			dataType:"json",
			success:function(result){
				//判断查询是否成功
				if (result.status==0) {
					//获取笔记本集合
					var books=result.data;
				for(var i=0;i<books.length;i++){
					var bookId=books[i].cn_notebook_id;
					var bookName=books[i].cn_notebook_name;
					//创建一个笔记本列表的li元素
					createBookLi(bookId,bookName);
					}
				}else{
					createBookLi(bookId,"默认笔记本");
				}
			},
			error:function(){
				alert("加载失败");
				}
			});
			
		}
	};
	
//创建一个笔记本li元素
function createBookLi(bookId,bookName){
	var sli="";
	sli+='<li class="online">';
	sli+='<a>';/*  class="checked"*/
	sli+='<i class="fa fa-book" title="online" rel="tooltip-bottom">';
	sli+='</i>'+bookName+'</a></li>';
	//将sli字符串转换成jQuery对象li元素
	var $li=$(sli);
	//将bookid值与jQuery对象绑定
	$li.data("bookId",bookId);
	//将li元素添加到笔记本ul列表区
	$("#book_ul").append($li);
	//alert($li.data("bookId"));
	}