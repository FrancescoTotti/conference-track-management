package com.tw.handler;

import com.tw.talk.Talk;
import com.tw.talk.TalkArrangement;
import com.tw.track.Track;

public class LunchHandler extends Handler {

	public LunchHandler(long startTime, long endTime, Track track) {
		super(startTime, endTime, track);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean resolve(Talk talk) {
		
		if (this.nextStartTime < this.endTime) {
			Talk lunch = new Talk("Lunch", 60);
			TalkArrangement ta = new TalkArrangement();
			ta.setTalk(lunch);
			ta.setStartTime(12 * 60);
			this.getTrack().addTalkArrangement(ta);
			this.nextStartTime = this.endTime;
		}
		return false;
	}

}
