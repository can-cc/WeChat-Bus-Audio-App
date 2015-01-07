package com.tyan.ba.wechat;

import java.util.Arrays;


public final class ValidateTool {

	public static String validate(ValidateModel vmodel, final String token){
		String signature = vmodel.getSignature(); // 微信加密签名  
        String timestamp = vmodel.getTimestamp(); // 时间戳  
        String nonce = vmodel.getNonce();// 随机数  
        String echostr = vmodel.getEchostr();// 随机字符串  
        
        if(signature!=null&&timestamp!=null&nonce!=null) {
            String[] str = {token, timestamp+"", nonce+""};
            Arrays.sort(str); // 字典序排序
            String bigStr = str[0] + str[1] + str[2];
            // SHA1加密    
            String digest = EncoderHandler.encode("SHA1", bigStr).toLowerCase();
            // 确认请求来至微信
            if (digest.equals(signature)) {
                //最好此处将echostr存起来，以后每次校验消息来源都需要用到
                return echostr;
            }
        }
        return "error";
	}
}
