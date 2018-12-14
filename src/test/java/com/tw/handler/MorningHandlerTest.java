package com.tw.handler;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tw.talk.Talk;
import com.tw.track.Track;


public class MorningHandlerTest {
	
	private Handler handler;

	@Before
	public void init() {
		Track track = new Track("track1");
		handler = new MorningHandler(9 * 60, 12 * 60, track);
	}
	
	@Test
	public void testNormalTalk() {
		Talk talk = new Talk("talk", 60);
		boolean result = handler.resolve(talk);
		Assert.assertTrue(result);
	}
	
	@Test
	public void testTooLongTalk() {
		Talk talk = new Talk("talk", 4 * 60);
		boolean result = handler.resolve(talk);
		Assert.assertFalse(result);
		
	}
}
