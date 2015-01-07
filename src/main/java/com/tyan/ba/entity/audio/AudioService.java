package com.tyan.ba.entity.audio;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

import com.tyan.ba.vo.AudioUK;

public interface AudioService {
	public String findAudioListByCategory(int categoryId, String name);
	public String findAudioUrl(int categoryId, String name);
	public Audio findOne(AudioUK audioUK);
	public boolean saveAudio(String name, int categoryId, String description, MultipartFile audioFile);
}
