package com.tyan.ba.entity.audio;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.tyan.ba.dao.AudioDao;
import com.tyan.ba.dao.CategoryDao;
import com.tyan.ba.entity.category.CategoryService;
import com.tyan.ba.vo.AudioUK;

public class AudioServiceAlpha implements AudioService {
	@Autowired
	private AudioDao audioDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private AudioTool audioTool;
	
	
	public AudioServiceAlpha() {
		// TODO Auto-generated constructor stub
	}
	@Override	
	public String findAudioListByCategory(int categoryId, String name) {
		String audioListText = "专辑·" + name + " 的听力列表：\n";
		List<Audio> audios = audioDao.findAudioByCategory(categoryId);
		for(Audio audio : audios){
			audioListText += audio.getName();
			audioListText += "\n";
		}
		audioListText = audioListText.substring(0, audioListText.length()-1);
		return audioListText;
	}

	@Override
	public String findAudioUrl(int categoryId, String name) {
		AudioUK auk = new AudioUK(name, categoryId);
		Audio audio = audioDao.findOne(auk);
		String dirPath = categoryDao.findPathById(categoryId);
		return null;
	}

	@Override
	public Audio findOne(AudioUK audioUK) {
		return audioDao.findOne(audioUK);
	}

	@Override
	public boolean saveAudio(String name, int categoryId, String description, MultipartFile audioFile) {
		String basePath = categoryDao.findPathById(categoryId);
		String filename = audioFile.getOriginalFilename();
		File mp3File = new File(basePath + "/" + filename);

		//以后封装一个异常吧，方便上层判断什么出错
		try {
			audioFile.transferTo(mp3File);
			//mp3File.createNewFile();
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		int playtime = audioTool.getMp3TrackLength(mp3File);
		int bitrate = audioTool.getMp3TrackBitRate(mp3File);
		
		Audio audio = new Audio(name, filename, categoryId, playtime, bitrate, new Date(), new Date(), description, 0);
		if(audioDao.save(audio)<=0)
			return false;
		return true;
	}

	public AudioDao getAudioDao() {
		return audioDao;
	}

	public void setAudioDao(AudioDao audioDao) {
		this.audioDao = audioDao;
	}

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public AudioTool getAudioTool() {
		return audioTool;
	}

	public void setAudioTool(AudioTool audioTool) {
		this.audioTool = audioTool;
	}


}
