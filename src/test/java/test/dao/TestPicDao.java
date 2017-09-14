package test.dao;

import java.util.List;

import org.junit.Test;

import cc.guoxingnan.mixinan.dao.PicDao;
import cc.guoxingnan.mixinan.entity.Pic;
import test.TestCase;

public class TestPicDao extends TestCase{
	PicDao dao = super.getContext().getBean("picDao", PicDao.class);
	
	@Test
	public void addPic(){
		Pic pic = new Pic();
		pic.setMi_pic_url("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2779846714,153214591&fm=27&gp=0.jpg");
		pic.setMi_pic_name("测试");
		pic.setMi_pic_desc("测试一下域名配置情况");
		int rows = dao.addPic(pic);
		
		System.out.println("影响了 "+rows+" 条数据");
	}
	
	
	@Test
	public void getPics(){
		List<Pic> pics = dao.getPics();
		
		System.out.println(pics);
	}
	
	
	@Test
	public void getLastPic(){
		Pic pic = dao.getLastPic();
		
		System.out.println(pic);
	}
}
