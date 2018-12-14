package com.tw.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tw.talk.Talk;

public class TalkParser {

	public TalkParser() {
		// TODO Auto-generated constructor stub
	}
	
	public static Talk parse(String strTalk) {

        long interval = -1L;
		if (strTalk.endsWith("min")) {
			Pattern patten = Pattern.compile("[0-9]{1,2}[a-z]{3}");
	        Matcher matcher = patten.matcher(strTalk);
	        
	        while (matcher.find()) {
	        	interval = Long.parseLong(strTalk.substring(matcher.start(), strTalk.length() - 3));
	        	
	        	return new Talk(strTalk, interval);
	        }
	        
	        return null;
		}
		else if (strTalk.endsWith("lightning")) {
			interval = 5L;
			
			return new Talk(strTalk, interval);
		}
		else {
//			System.out.println("input is invalid:" + strTalk);
			return null;
		}
	}

}
