package cc.guoxingnan.mixinan.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.guoxingnan.mixinan.entity.Pic;
import cc.guoxingnan.mixinan.service.PicService;
import cc.guoxingnan.mixinan.util.MixiResult;

@Controller
@RequestMapping("/pic")
public class PicController {
	
	@Resource
	PicService service;
	
	
	@RequestMapping("/add.do")
	@ResponseBody
	public MixiResult<Pic> addPic(
			String url,
			String name,
			String desc){
		
		Pic pic = new Pic();
		
		pic.setMi_pic_url(url);
		pic.setMi_pic_name(name.equals("")?"ÍòÂëÇ§¾û":name);
		pic.setMi_pic_desc(desc);
		
		MixiResult<Pic> res = service.addPic(pic);
		return res;
	}
	
	
	
	@RequestMapping("/getAll.do")
	@ResponseBody
	public MixiResult<List<Pic>> getPics(){
		MixiResult<List<Pic>> res = service.getAllPics();
		return res;
	}
	
	
	@RequestMapping("/getLastPic.do")
	@ResponseBody
	public MixiResult<Pic> getPicById(){
		MixiResult<Pic> res = service.getLastPic();
		return res;
	}
	
	
}
