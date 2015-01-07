package com.tyan.ba.wechat.msg.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.sina.sae.memcached.SaeMemcache;
import com.tyan.ba.entity.audio.Audio;
import com.tyan.ba.entity.audio.AudioService;
import com.tyan.ba.entity.category.CategoryService;
import com.tyan.ba.vo.AudioUK;

public class EnglishAudioReflector implements TextReflector {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private AudioService audioService;
	
	
	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public AudioService getAudioService() {
		return audioService;
	}

	public void setAudioService(AudioService audioService) {
		this.audioService = audioService;
	}

	//初始化SaeMemcache
	private static SaeMemcache mc;
	static {
		mc = new SaeMemcache();
		mc.init();
	}
	
	@Override
	public String reflect(String input, String userId) {
		
		//全部专辑
		if (input.equals("专辑")) {
			mc.set(userId, -1, 3*60);
			return categoryService.findAllCategoryList();
		}
		if (input.equals("专辑&")) {
			mc.set(userId, -1, 3*60);
			return categoryService.findAllCategoryAndDesList();
		}
		
		
		//查找专辑
		//ever has a bug 某一个专辑与任意音频同名就出现错误
		if (mc.get(userId) != null) {
			int precached = mc.get(userId);
			if (precached >= 0) {
				AudioUK preaudioUK = new AudioUK(input, precached);
				Audio preaudio = audioService.findOne(preaudioUK);
				if (preaudio == null) {
					//想要更智能，就得牺牲一定的效率
					
					
					int cid = categoryService.findIdByName(input);
					if (cid != -1) {
						String audiosText = audioService
								.findAudioListByCategory(cid, input);
						mc.set(userId, cid, 3 * 60); // 替代缓存 菜单记录
						return audiosText;
					}
				}
			}
		}
		
		int cid = categoryService.findIdByName(input);
		if (cid != -1) {
			String audiosText = audioService
					.findAudioListByCategory(cid, input);
			mc.set(userId, cid, 3 * 60); // 替代缓存 菜单记录
			return audiosText;
			}
		
		if (mc.get(userId) != null) {
			int cached = mc.get(userId);
			if(cached >= 0){
				AudioUK audioUK = new AudioUK(input, cached);
				Audio audio = audioService.findOne(audioUK);
				if(audio == null)
					return null;
				String dirPath = categoryService.findOne(cached).getDirPath();
				String audioPath = dirPath + "/" + audio.getFilename();
				return audioPath;
			}
		}
		
		
		return null;
	}
	

/*	@Override
	public String reflect(String input, String userId) {
		if (mc.get(userId) != null) {       
			
		//已经查看了专辑类表了
			if (mc.get(userId).equals("专辑")) { 
				if (input.equals("返回") || input.equals("exit")) {
					mc.delete(userId);//直接删除mencached记录 有待改进
					return null;
				}
				int cid = categoryService.findIdByName(input);
				if (cid != -1) {
					String audiosText = audioService.findAudioListByCategory(
							cid, input);
					mc.replace(userId, "音频", 3*60); //替代缓存 菜单记录
					return audiosText;
				} else {
					return "没有找到这个专辑哦，请重新输入，或输入返回或exit返回";
				}
			}
			
		//已经查看专辑的音频列表了
			if (mc.get(userId).equals("音频")) { 
				if (input.equals("返回") || input.equals("exit")) {
					mc.replace(userId, "专辑");//直接删除mencached记录 有待改进
					return null;     //是否返回null，是否返回提示相应， 还是在这里处理，有待改进
				}
				
				int categoryId = 
				
				
			}
			
		} else {
			if (input.equals("听力专辑")) {
				return categoryService.findAllCategoryList();
			}
			if (input.equals("听力专辑&描述")) {
				return categoryService.findAllCategoryAndDesList();
			}
		}// else if (input.equals("")){}
		return null;
	}*/

}
