package cc.guoxingnan.mixinan.dao;

import java.util.List;

import cc.guoxingnan.mixinan.entity.Pic;

public interface PicDao {
	/**
	 * 获取所有的图片列表
	 * @return
	 */
	public List<Pic> getPics();
	
	
	/**
	 * 获取最后一个图片对象
	 * @return
	 */
	public Pic getLastPic();  
	
	
	/**
	 * 添加一个图片对象
	 * @param pic
	 * @return
	 */
	public int addPic(Pic pic); 
}
