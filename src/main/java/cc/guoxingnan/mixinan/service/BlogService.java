package cc.guoxingnan.mixinan.service;

import java.util.List;
import java.util.Map;

import cc.guoxingnan.mixinan.entity.Blog;
import cc.guoxingnan.mixinan.util.MixiResult;

public interface BlogService {
	public MixiResult<Blog> getBlogByBlogId(int blogId);
	public MixiResult<List<Blog>> getBlogsAll();
	
	//���� ÿҳ��������ȡ ��ҳ����Ĭ��10��/ҳ��
	public MixiResult<Integer> getPages(int blogno);
	//���� ҳ��������������blog�б�
	public MixiResult<List<Blog>> getBlogsByPage(int pageno,int blogno);
	//���� ҳ��������������weibo������blog��user��Ϣ���б�
	public MixiResult<Object> getWeiboByPage(int pageno,int blogno);
		
	public MixiResult<Blog> addBlog(int userId,String blogText);
	public MixiResult<List<Blog>> searchBlogs(String kw);
	public MixiResult<String> deleteBlog(int id);
	public MixiResult<List<Blog>> getBlogsByUserId(int userId);
	public MixiResult<String> updateBlog(Blog blog);
	
	//��ȡҪ�ڿͻ�����ʾ�� ΢����Ϣ������user��Ϣ��blog��Ϣ��
	public MixiResult<Map<String,Object>> getWeibo(int blogId);
	
	//����+1
	public MixiResult<Integer> like(int blogId);
}
