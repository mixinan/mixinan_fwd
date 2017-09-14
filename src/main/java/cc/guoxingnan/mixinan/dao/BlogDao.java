package cc.guoxingnan.mixinan.dao;

import java.util.List;
import java.util.Map;

import cc.guoxingnan.mixinan.entity.Blog;

public interface BlogDao {
	public List<Blog> getBlogsAll();
	
	//根据 页数、条数，查找blog列表
	public List<Blog> getBlogsByPage(Map<String,Integer> map);
	
	//根据userId查找blogs
	public List<Blog> getBlogsByUserId(int userId);
	
	//查询blog总数
	public int getBlogsCount();
	public void addBlog(Blog blog);
	public Blog getBlogByBlogId(int blogId);
	public int deleteBlog(int id);
	//修改blog：修改内容，修改时间
	public int updateBlog(Blog blog);
	public List<Blog> searchBlogs(String keyword);
	
	//点赞+1
	public int like(int blogId);
}
