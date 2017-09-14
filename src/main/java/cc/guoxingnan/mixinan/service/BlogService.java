package cc.guoxingnan.mixinan.service;

import java.util.List;
import java.util.Map;

import cc.guoxingnan.mixinan.entity.Blog;
import cc.guoxingnan.mixinan.util.MixiResult;

public interface BlogService {
	public MixiResult<Blog> getBlogByBlogId(int blogId);
	public MixiResult<List<Blog>> getBlogsAll();
	
	//根据 每页条数，获取 总页数（默认10条/页）
	public MixiResult<Integer> getPages(int blogno);
	//根据 页数、条数，查找blog列表
	public MixiResult<List<Blog>> getBlogsByPage(int pageno,int blogno);
	//根据 页数、条数，查找weibo（包含blog、user信息）列表
	public MixiResult<Object> getWeiboByPage(int pageno,int blogno);
		
	public MixiResult<Blog> addBlog(int userId,String blogText);
	public MixiResult<List<Blog>> searchBlogs(String kw);
	public MixiResult<String> deleteBlog(int id);
	public MixiResult<List<Blog>> getBlogsByUserId(int userId);
	public MixiResult<String> updateBlog(Blog blog);
	
	//获取要在客户端显示的 微博信息（包含user信息及blog信息）
	public MixiResult<Map<String,Object>> getWeibo(int blogId);
	
	//点赞+1
	public MixiResult<Integer> like(int blogId);
}
