package com.tw.talk;

public class TalkArrangement {
	
	private Talk talk;
	
	private long startTime;

	public TalkArrangement() {
	}

	/**
	 * @return the talk
	 */
	public Talk getTalk() {
		return talk;
	}

	/**
	 * @param talk the talk to set
	 */
	public void setTalk(Talk talk) {
		this.talk = talk;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TalkArrangement [talk=" + talk + ", startTime=" + startTime + "]";
	}

}
