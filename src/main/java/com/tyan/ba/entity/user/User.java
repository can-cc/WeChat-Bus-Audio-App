package com.tyan.ba.entity.user;

import java.util.Date;
import java.util.UUID;

public class User {
	private UUID uuid;
	private long userId;
	private int type;// Dictionary Date
	private int passwordType;// Dictionary Date
	private String password;
	private String passwordSalt;
	private String userName;
	private String nickName;
	private int loginCount;
	private Date createDate;
	private Date infoModifiedDate;
	private Date lastLoginTime;
	private int role;//Dictionary Date
	private boolean locked;

}
