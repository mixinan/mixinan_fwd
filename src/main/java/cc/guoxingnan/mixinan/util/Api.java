package cc.guoxingnan.mixinan.util;

public class Api {
	
	//����û�
	String checkUser = "http://47.93.3.163:8080/mixinan/user/login.do?name=123&password=123";
	//ע���û�
	String registUser = "http://47.93.3.163:8080/mixinan/user/regist.do?name=125&password=125&gender=1";
	//ͨ��userId�ҵ�user
	String getUserById = "http://47.93.3.163:8080/mixinan/user/getUserById.do?id=11";
	//�鿴 name ��û�б�ռ��
	String checkNameUsed = "http://47.93.3.163:8080/mixinan/user/checkNameUsed.do?name=mixinan";
	
	
	//����blogId��ȡ blog��Ϣ �Լ� user��Ϣ
	String getWeibo = "http://47.93.3.163:8080/mixinan/blog/item.do?blogId=10";
	
	//���� ҳ��������������blog�б�
	String getBlogsByPage = "http://47.93.3.163:8080/mixinan/blog/getblogsbypage.do?pageno=1&blogno=16";
	
	//���� ҳ��������������weibo(����blog��user��Ϣ)�б�
	String getWeiboByPage = "http://47.93.3.163:8080/mixinan/blog/getWeiboByPage.do?pageno=1&blogno=16";
	
	//���� blogId,����+1
	String like = "http://47.93.3.163:8080/mixinan/blog/like.do?blogId=150";
	
	//����blogId����blog
	String getBlogByBlogId = "http://47.93.3.163:8080/mixinan/blog/getblog.do?id=3";
	
	//��ȡ���е�blog
	String getAllBlogs = "http://47.93.3.163:8080/mixinan/blog/getallblogs.do";
	
	//���� ÿҳ��������ȡblog��ҳ�������û���������Ĭ�ϰ�10��
	String getPages = "http://47.93.3.163:8080/mixinan/blog/getPages.do?blogno=8";
	
	//���һ��blog
	String addBlog = "http://47.93.3.163:8080/mixinan/blog/addblog.do?userId=3&blogText=blogtext";
	//����blog
	String searchBlogs = "http://47.93.3.163:8080/mixinan/blog/blogsearch.do?kw=no";
	//ͨ��blogIdɾ��blog
	String deleteBlog = "http://47.93.3.163:8080/mixinan/blog/delete.do?blogId=30";
	//����userId���Ҹ��û�����blog
	String getBlogsByUserId = "http://47.93.3.163:8080/mixinan/blog/getByUserId.do?userId=3";
	//����blogId �޸�blog
	String updateBlog = "http://47.93.3.163:8080/mixinan/blog/update.do?blogId=35&blogText=sleep";

	
	//���ͼƬ
	String addPic = "http://47.93.3.163:8080/mixinan/pic/add.do?url=test&desc=hi";
	//��ȡ����ͼƬ
	String getPics = "http://47.93.3.163:8080/mixinan/pic/getAll.do";
	//��ȡ���һ��ͼƬ
	String getLastPic = "http://47.93.3.163:8080/mixinan/pic/getLastPic.do";
	
}
