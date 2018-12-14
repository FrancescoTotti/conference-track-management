package com.tw.handler;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tw.talk.Talk;
import com.tw.track.Track;

public class LunchHandlerTest {
	
	private Handler handler;
	
	@Before
	public void init() {
		Track track = new Track("track");
		handler = new LunchHandler(12 * 60, 13 * 60, track);
	}
	
	@Test
	public void testFirstRun() {
		
		Assert.assertTrue(handler.getNextStartTime() == handler.getStartTime());
		Talk talk = new Talk();
		boolean result = handler.resolve(talk);
		
		Assert.assertFalse(result);
		Assert.assertFalse(handler.getNextStartTime() == handler.getStartTime());
		Assert.assertTrue(handler.getTrack().getTalkArrangements().size() == 1);
	}
	
	@Test
	public void testSecondRun() {
		Assert.assertTrue(handler.getNextStartTime() == handler.getStartTime());
		Talk talk = new Talk();
		boolean result1 = handler.resolve(talk);
		
		Assert.assertFalse(result1);
		Assert.assertFalse(handler.getNextStartTime() == handler.getStartTime());
		
		boolean result2 = handler.resolve(talk);
		Assert.assertFalse(result2);
		Assert.assertTrue(handler.getTrack().getTalkArrangements().size() == 1);
	}

}
