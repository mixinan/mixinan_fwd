package cc.guoxingnan.mixinan.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cc.guoxingnan.mixinan.dao.PicDao;
import cc.guoxingnan.mixinan.entity.Pic;
import cc.guoxingnan.mixinan.util.MixiResult;

@Service("picService")
public class PicServiceImpl implements PicService {
	
	@Resource
	PicDao dao;

	/**
	 * ����һ��ͼƬ
	 */
	public MixiResult<Pic> addPic(Pic pic) {
		int rows = dao.addPic(pic);
		MixiResult<Pic> res = new MixiResult<Pic>();
		if (rows==1) {
			res.setStatus(0);
			res.setMsg("ok");
			res.setData(pic);
		}else{
			res.setStatus(1);
			res.setMsg("fail");
		}
		return res;
	}

	
	/**
	 * ��ȡ����ͼƬ
	 */
	public MixiResult<List<Pic>> getAllPics() {
		List<Pic> pics = dao.getPics();
		
		MixiResult<List<Pic>> res = new MixiResult<List<Pic>>();
		if (pics==null) {
			res.setStatus(1);
			res.setMsg("fail");
		}else{
			res.setStatus(0);
			res.setMsg("ok");
			res.setData(pics);
		}
		
		return res;
	}

	
	/**
	 * ��ȡ����һ��ͼƬ
	 */
	public MixiResult<Pic> getLastPic() {
		Pic pic = dao.getLastPic();
		MixiResult<Pic> res = new MixiResult<Pic>();
		if (pic==null) {
			res.setStatus(1);
			res.setMsg("fail");
		}else{
			res.setStatus(0);
			res.setMsg("ok");
			res.setData(pic);
		}
		return res;
	}

	
	/**
	 * ͨ��id��ͼƬ
	 */
	public MixiResult<Pic> getPicByPicId(int picId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * ͨ��ҳ����ͼƬ
	 */
	public MixiResult<List<Pic>> getPicsByPage(int currentPage, int picsNumber) {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * ����ͼƬ
	 */
	public MixiResult<List<Pic>> searchPics(String kw) {
		// TODO Auto-generated method stub
		return null;
	}

}
