package cc.guoxingnan.mixinan.service;

import java.util.List;

import cc.guoxingnan.mixinan.entity.Pic;
import cc.guoxingnan.mixinan.util.MixiResult;

public interface PicService {
	public MixiResult<Pic> addPic(Pic pic);
	public MixiResult<List<Pic>> getAllPics();
	public MixiResult<Pic> getLastPic();
	public MixiResult<Pic> getPicByPicId(int picId);
	public MixiResult<List<Pic>> getPicsByPage(int currentPage,int picsNumber);
	public MixiResult<List<Pic>> searchPics(String kw);
}
