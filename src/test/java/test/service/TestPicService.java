package test.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cc.guoxingnan.mixinan.entity.Pic;
import cc.guoxingnan.mixinan.service.PicService;
import cc.guoxingnan.mixinan.util.MixiResult;
import test.TestCase;


public class TestPicService extends TestCase{
	
	PicService service;

	@Before
	public void init() {
		service = super.getContext().getBean("picService", PicService.class);
	}
	
	@Test
	public void add(){
		Pic pic = new Pic();
		pic.setMi_pic_url("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=107946162,202223891&fm=27&gp=0.jpg");
		pic.setMi_pic_name("¹«Ô°");
		pic.setMi_pic_desc("¾²Ú×µÄ¹«Ô°");
		MixiResult<Pic>  res= service.addPic(pic);
		System.out.println(res.getMsg());
	}
	
	
	@Test
	public void getPics(){
		MixiResult<List<Pic>> res= service.getAllPics();
		System.out.println(res.getStatus());
		System.out.println(res.getMsg());
		System.out.println(res.getData());
	}
	
	
	@Test
	public void getLastPic(){
		MixiResult<Pic> res= service.getLastPic();
		System.out.println(res.getStatus());
		System.out.println(res.getMsg());
		System.out.println(res.getData());
	}
	
}
