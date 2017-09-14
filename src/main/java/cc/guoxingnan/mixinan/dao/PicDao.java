package cc.guoxingnan.mixinan.dao;

import java.util.List;

import cc.guoxingnan.mixinan.entity.Pic;

public interface PicDao {
	/**
	 * ��ȡ���е�ͼƬ�б�
	 * @return
	 */
	public List<Pic> getPics();
	
	
	/**
	 * ��ȡ���һ��ͼƬ����
	 * @return
	 */
	public Pic getLastPic();  
	
	
	/**
	 * ���һ��ͼƬ����
	 * @param pic
	 * @return
	 */
	public int addPic(Pic pic); 
}
