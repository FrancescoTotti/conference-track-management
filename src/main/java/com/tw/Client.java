package com.tw;

import java.util.List;

import com.tw.exception.CommonException;
import com.tw.handler.AfternoonHandler;
import com.tw.handler.Handler;
import com.tw.handler.LunchHandler;
import com.tw.handler.MorningHandler;
import com.tw.talk.Talk;
import com.tw.talk.TalkBuilder;
import com.tw.track.Track;
import com.tw.utils.Constants;

public class Client {
	
	/**
	 *  network event start time
	 */
	private long networkEventTime;
	
	public Client(long networkEventTime) {
		if (networkEventTime < 16 * 60 || networkEventTime > 17 * 60) {
			System.out.println("network event start time exceeded limit");
			System.exit(1);
		}
		this.networkEventTime = networkEventTime;
	}

	public void run() {

		List<Talk> talks = new TalkBuilder().build();
		
		if (null == talks || talks.isEmpty()) {
			System.out.println("build talks failed");
			System.exit(1);
		}
		

		Track track1 = new Track("Track1");
		Handler morning1 = new MorningHandler(Constants.MORNING_STARTTIME, 
				Constants.MORNING_ENDTIME, track1);
		Handler lunch1 = new LunchHandler(Constants.LUNCH_STARTTIME, Constants.LUNCH_ENDTIME, track1);
		Handler afternoon1 = new AfternoonHandler(Constants.AFTERNOON_STARTTIME, 
				this.networkEventTime, track1);
		morning1.setNext(lunch1).setNext(afternoon1);
		for (Talk talk : talks) {
			morning1.process(talk);
		}
		
		track1.addNetworkEvent(afternoon1.getEndTime());
		
		Track track2 = new Track("Track2");
		Handler morning2 = new MorningHandler(Constants.MORNING_STARTTIME, 
				Constants.MORNING_ENDTIME, track2);
		Handler lunch2 = new LunchHandler(Constants.LUNCH_STARTTIME, Constants.LUNCH_ENDTIME, track2);
		Handler afternoon2 = new AfternoonHandler(Constants.AFTERNOON_STARTTIME, 
				this.networkEventTime, track2);
		morning2.setNext(lunch2).setNext(afternoon2);
		for (Talk talk : track1.getNotArrangedTalks()) {
			morning2.process(talk);
		}
		
		track2.addNetworkEvent(afternoon2.getEndTime());
		
		if (!track2.getNotArrangedTalks().isEmpty()) {
			System.out.println("some talks has not been arranged:");
			System.out.println(track2.getNotArrangedTalks());
			System.exit(1);
		}
		
		try {
			track1.display();
			track2.display();
		} catch (CommonException e) {
			System.out.println(e.getMessage());
		}
	}
}
