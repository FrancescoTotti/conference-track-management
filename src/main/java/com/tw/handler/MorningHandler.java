package com.tw.handler;

import com.tw.talk.Talk;
import com.tw.track.Track;

public class MorningHandler extends Handler {

	public MorningHandler(long startTime, long endTime, Track track) {
		super(startTime, endTime, track);
	}

	@Override
	protected boolean resolve(Talk talk) {
		if (this.endTime - this.nextStartTime >= talk.getInterval()) {
			return true;
		}
		
		return false;
	}

}
