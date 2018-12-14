package com.tw.track;

import java.util.ArrayList;
import java.util.List;

import com.tw.exception.CommonException;
import com.tw.talk.Talk;
import com.tw.talk.TalkArrangement;
import com.tw.utils.TimeUtils;

public class Track {
	
	private String name;
	
	private List<TalkArrangement> talkArrangements = new ArrayList<TalkArrangement>();
	
	private List<Talk> notArrangedTalks = new ArrayList<Talk>();

	public Track(String name) {
		this.name = name;
	}

	/**
	 * @return the talkArrangements
	 */
	public List<TalkArrangement> getTalkArrangements() {
		return talkArrangements;
	}

	/**
	 * @param talkArrangements the talkArrangements to set
	 */
	public void setTalkArrangements(List<TalkArrangement> talkArrangements) {
		this.talkArrangements = talkArrangements;
	}
	
	public void addTalkArrangement(TalkArrangement ta) {
		this.talkArrangements.add(ta);
	}
	
	public void addNotArrangedTalks(Talk talk) {
		this.notArrangedTalks.add(talk);
	}

	/**
	 * @return the notArrangedTalks
	 */
	public List<Talk> getNotArrangedTalks() {
		return notArrangedTalks;
	}

	/**
	 * @param notArrangedTalks the notArrangedTalks to set
	 */
	public void setNotArrangedTalks(List<Talk> notArrangedTalks) {
		this.notArrangedTalks = notArrangedTalks;
	}
	
	public void addNetworkEvent(long startTime) {
		Talk talk = new Talk("Network Event", 0L);
		TalkArrangement ta = new TalkArrangement();
		ta.setTalk(talk);
		ta.setStartTime(startTime);
		
		this.talkArrangements.add(ta);
	}
	
	public void display() throws CommonException {
		StringBuilder content = new StringBuilder();
		content.append(this.name).append(":\n");
		
		for (TalkArrangement ta : this.talkArrangements) {
			content.append(TimeUtils.getTimeStr(ta.getStartTime())).append(" ").append(ta.getTalk().getName()).append("\n");
		}
		
		System.out.print(content.toString() + "\n");
	}

}
