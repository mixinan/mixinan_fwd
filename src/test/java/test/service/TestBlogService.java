package test.service;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import cc.guoxingnan.mixinan.entity.Blog;
import cc.guoxingnan.mixinan.service.BlogService;
import cc.guoxingnan.mixinan.util.MixiResult;
import test.TestCase;

public class TestBlogService extends TestCase{
	BlogService service;
	
	@Before
	public void init(){
		service = super.getContext().getBean("blogService", BlogService.class);
	}
	
	@Test
	public void getBlogById(){
		MixiResult<Blog> result = service.getBlogByBlogId(29);
		System.out.println(result.getStatus());
		System.out.println(result.getMsg());
		System.out.println(result.getData());
	}
	
	@Test
	public void addBlog(){
		MixiResult<Blog> result = service.addBlog(3, "ÄãºÃ");
		System.out.println(result.getMsg());
		System.out.println(result.getData());
	}
	
	/**
	 * µãÔÞ+1
	 */
	@Test
	public void like(){
		MixiResult<Integer> result = service.like(151);
		System.out.println(result.getMsg());
		System.out.println(result.getData());
	}
	
	@Test
	public void test3(){
		MixiResult<List<Blog>> res = service.getBlogsAll();
		System.out.println(res.getMsg());
		System.out.println(res.getData().size());
	}
	
	
	@Test
	public void testsearch(){
		MixiResult<List<Blog>> res = service.searchBlogs("no");
		System.out.println(res.getMsg());
		System.out.println(res.getData());
	}
	
	
	@Test
	public void getBlogByPage(){
		MixiResult<List<Blog>> res = service.getBlogsByPage(1,6);
		System.out.println(res.getMsg());
		System.out.println(res.getData());
	}
	
	@Test
	public void getWeiboByPage(){
		MixiResult<Object> res = service.getWeiboByPage(1, 3);
		System.out.println(res.getMsg());
		System.out.println(res.getData());
	}
	
	
	@Test
	public void getPages(){
		MixiResult<Integer> res = service.getPages(5);
		System.out.println(res.getMsg());
		System.out.println(res.getData());
	}
	
	
	@Test
	public void deleteBlog(){
		MixiResult<String> res = service.deleteBlog(29);
		System.out.println(res);
	}
	
	
	
	@Test
	public void getBlogsByUserId(){
		MixiResult<List<Blog>> res = service.getBlogsByUserId(5);
		System.out.println(res);
	}
	
	
	
	@Test
	public void updateBlog(){
		Blog blog = service.getBlogByBlogId(35).getData();
		blog.setMi_blog_text("ºÇºÇ¹þ¹þ");
		MixiResult<String> res = service.updateBlog(blog);
		System.out.println(res);
	}
	
	@Test
	public void getWeibo(){
		MixiResult<Map<String, Object>> res = service.getWeibo(57);
		Map<String, Object> data = res.getData();
		System.out.println(data.get("user"));
		System.out.println(data.get("blog"));
	}
	
	
}
