package com.tyan.ba.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.tyan.ba.entity.audio.Audio;
import com.tyan.ba.vo.AudioUK;

/**
 * @author tyan
 *
 */
public class AudioDao {
	private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insertAudio;
	

    public AudioDao(BasicDataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.insertAudio = new SimpleJdbcInsert(dataSource).withTableName("audio");
	}
    
    public void delete(Audio audio){
    	String name = audio.getName();
    	int categoryId = audio.getCategoryId();
    	this.jdbcTemplate.update("delete from  audio where name = ? and categoryId = ?", 
    			name, 
    			categoryId);
    }
    
    /*Returns:
        the number of rows affected as returned by the JDBC driver*/
	public int save(Audio audio){
		SqlParameterSource parameters = new BeanPropertySqlParameterSource(audio);
		return insertAudio.execute(parameters);
	}
	
	public void update(Audio audio){
		String name = audio.getName();
		String filename = audio.getFilename();
		int categoryId = audio.getCategoryId();
		int playtime = audio.getPlaytime();
		int bitrate = audio.getBitrate();
		Date modifiedDate = audio.getModifiedDate();
		Date createDate = audio.getCreateDate();
		String description = audio.getDescription();
		int authority = audio.getAuthority();
		this.jdbcTemplate.update(
		        "update audio set name = ?,"
		        + "filename = ?,"
		        + "categoryId = ?,"
		        + "playtime = ?,"
		        + "bitrate = ?,"
		        + "modifiedDate = ?,"
		        + "createDate = ?,"
		        + "description = ?,"
		        + "authority = ?  where name = ?",
		        name, filename, categoryId, playtime, bitrate, modifiedDate, createDate, description, authority,
		        name);
	}

	public Audio findOne(AudioUK audioUK) {
		String name = audioUK.getName();
		int categoryId = audioUK.getCategoryId();
		try {
			return this.jdbcTemplate.queryForObject("select " + "name, "
					+ "filename, " + "categoryId, " + "playtime, "
					+ "bitrate, " + "modifiedDate, " + "createDate, "
					+ "description, "
					+ "authority from audio where name = ? and categoryId= ?",
					new Object[] { name, categoryId }, new AudioMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public List<Audio> findAllAudio(){
		return this.jdbcTemplate.query( "select "
				+ "name, "
				+ "filename, "
				+ "categoryId, "
				+ "playtime, "
				+ "bitrate, "
				+ "modifiedDate, "
				+ "createDate, "
				+ "description, "
				+ "authority from audio", new AudioMapper());
	}
	
	public List<Audio> findAudioByCategory(int categoryId){
		return this.jdbcTemplate.query( "select "
				+ "name, "
				+ "filename, "
				+ "categoryId, "
				+ "playtime, "
				+ "bitrate, "
				+ "modifiedDate, "
				+ "createDate, "
				+ "description, "
				+ "authority from audio where categoryId = " + categoryId, new AudioMapper());
	}
	

	private static final class AudioMapper implements RowMapper<Audio> {
		@Override
		public Audio mapRow(java.sql.ResultSet arg0, int arg1)
				throws SQLException {
			Audio audio = new Audio();
			audio.setName(arg0.getString("name"));
			audio.setCategoryId(arg0.getInt("categoryId"));
			audio.setFilename(arg0.getString("filename"));
			audio.setPlaytime(arg0.getInt("playtime"));
			audio.setBitrate(arg0.getInt("bitrate"));
			audio.setCreateDate(arg0.getDate("createDate"));
			audio.setModifiedDate(arg0.getDate("modifiedDate"));
			audio.setDescription(arg0.getString("description"));
			audio.setAuthority(arg0.getInt("authority"));
			return audio;
		}

	}

}
