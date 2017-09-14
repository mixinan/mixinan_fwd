/*
 * 打开首页时，加载所有blog，并显示在ul里
 * */
var getAllBlogs = function(){
		
	$.ajax({
		type:"get",
		url:path+"/blog/getallblogs.do",
		dataType:"json",
		success:function(result){
			var list = result.data;
			var listSize = list.length;
			console.log("从服务器获取到 "+listSize+" 条数据");
			
			//遍历结果集，显示在ul里
			for (var i = 0;i<listSize;i++) {
				var blog = list[i];
				var userId = blog.mi_user_id;
				var nickname = getUserById(userId);
				var blogText = blog.mi_blog_text;
				var $li = $("<li>"+nickname+"：<br>"+decodeURI(blogText)+"<br>"+blog.mi_blog_create_time+"</li><br>");
				
				//给li绑定 blogId
				$li.data("blogId",blog.mi_blog_id);
				
				$("#blog_list").prepend($li);
			}
		},
		error:function(result){
			console.log(result.msg);
		}
	});
}


/*
 * 根据 每页条数(默认10)，得到所有blog的页数
 * */
var getPages = function(){
	var blogno = arguments[0] ? arguments[0] : 10;
	$.ajax({
		type:"get",
		url:path+"/blog/getPages.do",
		data:{"blogno":blogno},
		dataType:"json",
		success:function(res){
			var pages = res.data;
			//console.log("总页数："+pages);
			$page_parent = $("ul.pager");
			var html="";
			for(var i=1;i<=pages;i++){
				html += "<li><a href='#'>"+i+"</a></li>";
			}
			$("ul.pager").html(html);
		},
		error:function(){
			console.log("得到页数失败！");
		}
		
	});
	
}









/*
 * 根据页数查找blogs
 * */
function getBlogsByPage(){
	var pageno = arguments[0]? arguments[0]:1;
	var blogno = arguments[1]? arguments[1]:10;
	$.ajax({
		type:"post",
		url:path+"/blog/getblogsbypage.do",
		data:{
			"pageno":pageno,
			"blogno":blogno
			 },
		dataType:"json",
		success:function(res){
			var list = res.data;
			//console.log(list);
			for(var i=0;i<list.length;i++){
				var blog = list[i];
				var nickname = getUserById(blog.mi_user_id);
				
				$li=$("<li>"+nickname+"：<br>"+decodeURI(blog.mi_blog_text)+"<br>"+blog.mi_blog_create_time+"</li><br>");
				
				//绑定数据到$li
				$li.data("blogId",blog.mi_blog_id);
				$li.data("userId",blog.mi_user_id);
				
				$("#blog_list").append($li);
			}
		},
		error:function(){
			
		}
	});
}









/*
 * 增加一条Blog
 * addBlog
 * */
var addBlog = function(){
	var $input = $("#blogText");
	var blogText = $input.val().trim();
	console.log(blogText);
	var userId = getCookie("userId");
	var $list=$("#blog_list");
	
	if (blogText=="") {
		$input.attr('placeholder','不能为空')
		return;
	}
	
	$.ajax({
		type:"post",
		url:path+"/blog/addblog.do",
		data:{"userId":userId,"blogText":blogText},
		dataType:"json",
		success:function(result){
			//发送完毕后，清空输入框内容
			$input.val("");
			$input.attr("placeholder","请输入内容");
			//清空ul，重新从服务器获取第一页blog列表
			$list.html("");
			//重新加载第一页
			getBlogsByPage(1);
		},
		error:function(){
			console.log(result.status);
			console.log(result.msg);
			console.log(result.data);
		}
	});
	
}



