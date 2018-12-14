package com.tw.handler;

import com.tw.talk.Talk;
import com.tw.talk.TalkArrangement;
import com.tw.track.Track;

public abstract class Handler {
	
	protected long startTime;
	
	protected long nextStartTime;
	
	protected long endTime;
	
	protected Handler next;
	
	private Track track;
	
	public Handler(long startTime, long endTime, Track track) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.nextStartTime = startTime;
		this.track = track;
	}

	public Handler getNext() {
		return next;
	}

	public Handler setNext(Handler next) {
		this.next = next;
		return next;
	}
	
	/**
	 * @return the startTime
	 */
	public long getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the nextStartTime
	 */
	public long getNextStartTime() {
		return nextStartTime;
	}

	/**
	 * @param nextStartTime the nextStartTime to set
	 */
	public void setNextStartTime(long nextStartTime) {
		this.nextStartTime = nextStartTime;
	}

	/**
	 * @return the endTime
	 */
	public long getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the track
	 */
	public Track getTrack() {
		return track;
	}

	/**
	 * @param track the track to set
	 */
	public void setTrack(Track track) {
		this.track = track;
	}

	protected abstract boolean resolve(Talk talk);
	
	public final void process(Talk talk) {
		if (resolve(talk)) {
			done(talk);
		}
		else if (next != null) {
			next.process(talk);
		}
		else {
			fail(talk);
		}
	}
	
	protected void done(Talk talk) {
		TalkArrangement ta = new TalkArrangement();
		ta.setTalk(talk);
		ta.setStartTime(nextStartTime);
		
		this.track.addTalkArrangement(ta);
		
		nextStartTime += talk.getInterval();
	}
	
	protected void fail(Talk talk) {
		this.track.addNotArrangedTalks(talk);
	}

}
