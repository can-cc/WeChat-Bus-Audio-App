package com.tyan.ba.entity.audio;

import java.io.File;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;

public class AudioTool {
	
	public int getMp3TrackBitRate(File mp3File){
		try {  
            MP3File f = (MP3File)AudioFileIO.read(mp3File);  
            MP3AudioHeader audioHeader = (MP3AudioHeader)f.getAudioHeader();  
            return (int)audioHeader.getBitRateAsNumber();   
        } catch(Exception e) {  
            return -1;  
        }  
	}
	
	
    public  int getMp3TrackLength(File mp3File) {  
        try {  
            MP3File f = (MP3File)AudioFileIO.read(mp3File);  
            MP3AudioHeader audioHeader = (MP3AudioHeader)f.getAudioHeader();  
            return audioHeader.getTrackLength();      
        } catch(Exception e) {  
            return -1;  
        }  
    }  
    
    public static void main(String[] args) {
		File file = new File("/home/tyan/storage/人间.mp3");
	//	System.out.println(getMp3TrackBitRate(file));
	}
	

}
