package com.tyan.ba.http;

import javax.servlet.http.HttpServletResponse;

public class HttpServletResponseChineseCharset implements
		HttpServletResponseCharset {

	@Override
	public  void CharsetAdjust(HttpServletResponse response) {
		 response.setCharacterEncoding("UTF_8");
		 response.setHeader("Content-type","text/html;charset=UTF-8");
	}

}
