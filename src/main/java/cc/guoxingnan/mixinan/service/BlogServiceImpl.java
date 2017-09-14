package cc.guoxingnan.mixinan.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cc.guoxingnan.mixinan.dao.BlogDao;
import cc.guoxingnan.mixinan.dao.UserDao;
import cc.guoxingnan.mixinan.entity.Blog;
import cc.guoxingnan.mixinan.entity.User;
import cc.guoxingnan.mixinan.util.MixiResult;
import cc.guoxingnan.mixinan.util.Util;

@Service("blogService")
public class BlogServiceImpl implements BlogService{
	
	@Resource
	BlogDao blogDao;
	
	@Resource
	UserDao userDao;

	public MixiResult<Blog> getBlogByBlogId(int blogId) {
		Blog blog = blogDao.getBlogByBlogId(blogId);
		
		MixiResult<Blog> result = new MixiResult<Blog>();
		if (blog==null) {
			result.setStatus(1);
			result.setMsg("查询失败！");
		}else{
			result.setStatus(0);
			result.setMsg("查询成功！");
			result.setData(blog);
		}
		
		return result;
	}
	
	
	
	/**
	 * 根据 页数，条数，获取blog列表
	 * @param pageno
	 * @param blogno
	 * @return
	 */
	public MixiResult<List<Blog>> getBlogsByPage(int pageno,int blogno) {
		Map<String,Integer> map=new HashMap<String, Integer>();
		map.put("pageno", pageno);
		map.put("blogno", blogno);
		List<Blog> blogs = blogDao.getBlogsByPage(map);
		
		MixiResult<List<Blog>> res = new MixiResult<List<Blog>>();
		if (blogs==null) {
			res.setStatus(1);
			res.setMsg("failer");
		}else{
			res.setStatus(0);
			res.setMsg("ok");
			res.setData(blogs);
		}
		return res;
	}
	
	
	
	
	/**
	 * 根据 页数，条数，获取weibo(包含blog、user信息)列表
	 * @param pageno
	 * @param blogno
	 * @return
	 */
	public MixiResult<Object> getWeiboByPage(int pageno,int blogno) {
		Map<String,Integer> map=new HashMap<String, Integer>();
		map.put("pageno", pageno);
		map.put("blogno", blogno);
		List<Blog> blogs = blogDao.getBlogsByPage(map);
		
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		
		for (Blog blog : blogs) {
			User user = userDao.getUserById(blog.getMi_user_id());
			Map<String,Object> weiboMap = new HashMap<String, Object>();
			weiboMap.put("blog", blog);
			weiboMap.put("user", user);
			list.add(weiboMap);
		}
		
		MixiResult<Object> res = new MixiResult<Object>();
		res.setStatus(0);
		res.setMsg("ok");
		res.setData(list);
		
		return res;
	}

	

	public MixiResult<Blog> addBlog(int userId, String blogText) {
		Blog blog = new Blog();
		blog.setMi_user_id(userId);
		try {
			blog.setMi_blog_text(URLEncoder.encode(blogText, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		blog.setMi_blog_create_time(Util.getCurrentTime());
		blogDao.addBlog(blog);
		
		MixiResult<Blog> res = new MixiResult<Blog>();
		res.setStatus(0);
		res.setMsg("blog添加成功！");
		
		return res;
	}
	
	
	public MixiResult<List<Blog>> getBlogsByUserId(int userId) {
		List<Blog> blogs = blogDao.getBlogsByUserId(userId);
		MixiResult<List<Blog>> res = new MixiResult<List<Blog>>();
		if (blogs==null) {
			res.setStatus(1);
			res.setMsg("fail");
		}else{
			res.setStatus(0);
			res.setMsg("ok");
			res.setData(blogs);
		}
		return res;
	}



	public MixiResult<List<Blog>> getBlogsAll() {
		List<Blog> allBlogs = blogDao.getBlogsAll();
		
		MixiResult<List<Blog>> res = new MixiResult<List<Blog>>();
		if (allBlogs.size()>0) {
			res.setStatus(0);
			res.setMsg("查询成功!");
			res.setData(allBlogs);
		}else{
			res.setStatus(1);
			res.setMsg("没有查询到数据!");
		}
		
		
		return res;
	}



	public MixiResult<List<Blog>> searchBlogs(String kw) {
		String search = "%"+kw+"%";
		List<Blog> blogs = blogDao.searchBlogs(search);
		
		MixiResult<List<Blog>> res = new MixiResult<List<Blog>>();
		
		if (blogs==null) {
			res.setStatus(1);
			res.setMsg("没有相关blog，或查询失败");
		}else{
			res.setStatus(0);
			res.setMsg("ok");
			res.setData(blogs);
		}
		
		return res;
	}



	/**
	 * 获取所有 页数
	 * 默认每页 10 条
	 */
	public MixiResult<Integer> getPages(int blogno) {
		int blogsCount = blogDao.getBlogsCount();
		int pages = blogsCount%blogno==0 ? blogsCount/blogno : blogsCount/blogno+1;
		
		MixiResult<Integer> res = new MixiResult<Integer>();
		if (blogsCount==0) {
			res.setStatus(1);
			res.setMsg("fail");
		}else{
			res.setStatus(0);
			res.setMsg("ok");
			res.setData(pages);
		}
		
		return res;
	}



	public MixiResult<String> deleteBlog(int id) {
		int rows = blogDao.deleteBlog(id);
		MixiResult<String> res = new MixiResult<String>();
		if (rows==1) {
			res.setStatus(0);
			res.setMsg("ok");
		}else{
			res.setStatus(1);
			res.setMsg("fail");
		}
		return res;
	}



	public MixiResult<String> updateBlog(Blog blog) {
		int rows = blogDao.updateBlog(blog);
		MixiResult<String> res = new MixiResult<String>();
		if (rows==1) {
			res.setStatus(0);
			res.setMsg("ok");
		}else{
			res.setStatus(1);
			res.setMsg("fail");
		}
		return res;
	}



	/**
	 * 根据blogId 查找 user信息 和 blog信息
	 */
	public MixiResult<Map<String,Object>> getWeibo(int blogId) {
		Blog blog = blogDao.getBlogByBlogId(blogId);
		
		int userId = blog.getMi_user_id();
		User user = userDao.getUserById(userId);
		
		MixiResult<Map<String,Object>> res = new MixiResult<Map<String,Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", user);
		map.put("blog", blog);
		
		res.setStatus(0);
		res.setMsg("ok");
		res.setData(map);
		
		return res;
	}


	/**
	 * 点赞+1
	 */
	public MixiResult<Integer> like(int blogId) {
		int rows = blogDao.like(blogId);
		MixiResult<Integer> res = new MixiResult<Integer>();
		if (rows==1) {
			Blog blog = blogDao.getBlogByBlogId(blogId);
			int likeTimes = blog.getMi_blog_like_times();
			res.setStatus(0);
			res.setMsg("ok");
			res.setData(likeTimes);
		}else{
			res.setStatus(1);
			res.setMsg("fail");
		}
		return res;
	}

}
