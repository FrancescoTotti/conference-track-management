package com.tw.handler;

import com.tw.talk.Talk;
import com.tw.track.Track;

public class AfternoonHandler extends Handler {

	public AfternoonHandler(long startTime, long endTime, Track track) {
		super(startTime, endTime, track);
	}

	@Override
	protected boolean resolve(Talk talk) {
		if (this.nextStartTime + talk.getInterval() <= this.endTime) {
			return true;
		}
		return false;
	}

}
