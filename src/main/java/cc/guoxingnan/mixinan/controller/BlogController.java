package cc.guoxingnan.mixinan.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.guoxingnan.mixinan.entity.Blog;
import cc.guoxingnan.mixinan.service.BlogService;
import cc.guoxingnan.mixinan.util.MixiResult;

@Controller
@RequestMapping("/blog")
public class BlogController {
	
	@Resource
	BlogService service;
	
	@RequestMapping("/getblogsbypage.do")
	@ResponseBody
	public MixiResult<List<Blog>> getBlogsByPage(
			@RequestParam(value="pageno", defaultValue="1")int pageno,
			@RequestParam(value="blogno",defaultValue="10")int blogno){
		int page = (pageno-1) * blogno;
		MixiResult<List<Blog>> result = service.getBlogsByPage(page,blogno);
		return result;
	}
	
	
	
	@RequestMapping("/getWeiboByPage.do")
	@ResponseBody
	public MixiResult<Object> getWeiboByPage(
			@RequestParam(value="pageno", defaultValue="1")int pageno,
			@RequestParam(value="blogno",defaultValue="10")int blogno){
		int page = (pageno-1) * blogno;
		MixiResult<Object> result = service.getWeiboByPage(page, blogno);
		return result;
	}
	
	
	/**
	 * 点赞+1
	 * @param blogId
	 * @return
	 */
	@RequestMapping("/like.do")
	@ResponseBody
	public MixiResult<Integer> like(int blogId){
		MixiResult<Integer> res = service.like(blogId);
		return res;
	}
	
	
	
	/**
	 * 默认参数，如果没输，则用它
	 * @param blogno
	 * @return
	 */
	@RequestMapping("/getPages.do")
	@ResponseBody
	public MixiResult<Integer> getPages(@RequestParam(value="blogno", defaultValue="10")int blogno){
		if (blogno==0) {
			blogno=10;
		}
		MixiResult<Integer> res = service.getPages(blogno);
		return res;
	}
	
	
	
	@RequestMapping("/addblog.do")
	@ResponseBody
	public MixiResult<Blog> addBlog(int userId,String blogText){
		MixiResult<Blog> result = service.addBlog(userId, blogText);
		return result;
	}
	
	
	
	@RequestMapping("/getblog.do")
	@ResponseBody
	public MixiResult<Blog> getBlogById(int id){
		MixiResult<Blog> result = service.getBlogByBlogId(id);
		return result;
	}
	
	
	
	@RequestMapping("/getallblogs.do")
	@ResponseBody
	public MixiResult<List<Blog>> getAllBlogs(){
		MixiResult<List<Blog>> result = service.getBlogsAll();
		return result;
	}
	
	
	/**
	 * 搜索关键字
	 * 默认参数 “口碑”
	 * @param kw
	 * @return
	 */
	@RequestMapping("/search.do")
	@ResponseBody
	public MixiResult<List<Blog>> searchBlogs(
			@RequestParam(value="kw",defaultValue="口碑")String kw){
		MixiResult<List<Blog>> result = service.searchBlogs(kw);
		return result;
	}

	
	@RequestMapping("/delete.do")
	@ResponseBody
	public MixiResult<String> deleteBlog(int blogId){
		MixiResult<String> result = service.deleteBlog(blogId);
		return result;
	}
	
	
	@RequestMapping("/getByUserId.do")
	@ResponseBody
	public MixiResult<List<Blog>> getBlogsByUserId(int userId){
		MixiResult<List<Blog>> result = service.getBlogsByUserId(userId);
		return result;
	}
	
	
	
	@RequestMapping("/update.do")
	@ResponseBody
	public MixiResult<String> updateBlog(int blogId,String blogText){
		Blog blog = getBlogById(blogId).getData();
		blog.setMi_blog_text(blogText);
		MixiResult<String> result = service.updateBlog(blog);
		return result;
	}
	
	
	@RequestMapping("/item.do")
	@ResponseBody
	public MixiResult<Map<String,Object>> getWeibo(int blogId){
		MixiResult<Map<String, Object>> res = service.getWeibo(blogId);
		return res;
	}
}
