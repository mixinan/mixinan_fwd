/*
 * 根据userId找到User
 * */
var getUserById = function(userId){
	var nickname="";
	$.ajax({
		type:"post",
		url:path+"/user/getUserById.do",
		data:{"id":userId},
		dataType:"json",
		async:false,
		success:function(result){
			var user = result.data;
			
			//console.log(user.mi_user_nickname);
			nickname = user.mi_user_nickname;
		},
		error:function(result){
			console.log(result.msg);
		}
	});
	
	return nickname;
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
			console.log(result.status);
			console.log(result.msg);
			//console.log(result.data);
			//发送完毕后，清空输入框内容
			$input.val("");
			$input.attr("placeholder","请输入内容");
			//清空ul，重新从服务器获取blog列表
			$list.html("");
			getAllBlogs();
//			$list.prepend($("<li>"+userId+"："+blogText+"</li>"));
		},
		error:function(result){
			console.log(result.status);
			console.log(result.msg);
			console.log(result.data);
		}
	});
	
}



