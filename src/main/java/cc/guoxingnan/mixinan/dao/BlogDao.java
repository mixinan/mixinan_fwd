package cc.guoxingnan.mixinan.dao;

import java.util.List;
import java.util.Map;

import cc.guoxingnan.mixinan.entity.Blog;

public interface BlogDao {
	public List<Blog> getBlogsAll();
	
	//���� ҳ��������������blog�б�
	public List<Blog> getBlogsByPage(Map<String,Integer> map);
	
	//����userId����blogs
	public List<Blog> getBlogsByUserId(int userId);
	
	//��ѯblog����
	public int getBlogsCount();
	public void addBlog(Blog blog);
	public Blog getBlogByBlogId(int blogId);
	public int deleteBlog(int id);
	//�޸�blog���޸����ݣ��޸�ʱ��
	public int updateBlog(Blog blog);
	public List<Blog> searchBlogs(String keyword);
	
	//����+1
	public int like(int blogId);
}
