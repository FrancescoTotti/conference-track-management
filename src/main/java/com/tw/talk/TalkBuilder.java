package com.tw.talk;

import java.util.ArrayList;
import java.util.List;

import com.tw.init.InitInput;
import com.tw.utils.TalkParser;

public class TalkBuilder {

	public TalkBuilder() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Talk> build(){
		List<Talk> talks = new ArrayList<Talk>();
		List<String> talkStrs = InitInput.getInputTalks();
		if (null == talkStrs || talkStrs.isEmpty()) {
			System.out.println("init input failed.");
			return talks;
		}
		
		Talk talk = null;
		for (String str : talkStrs) {
			talk = TalkParser.parse(str);
			if (null == talk) {
				return null;
			}
			
			talks.add(talk);
		}
		
		return talks;
	}

}
