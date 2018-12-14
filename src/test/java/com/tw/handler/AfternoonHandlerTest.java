package com.tw.handler;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tw.talk.Talk;
import com.tw.track.Track;


public class AfternoonHandlerTest {
	
	private Handler handler;
	
	@Before
	public void init() {
		Track track = new Track("track");
		handler = new AfternoonHandler(13 *60, 17 * 60, track);
	}
	
	@Test
	public void testNormalTalk() {
		Talk talk = new Talk("talk", 60);
		boolean result = handler.resolve(talk);
		Assert.assertTrue(result);
	}
	
	@Test
	public void testTooLongTalk() {
		Talk talk = new Talk("talk",  4 * 60 + 1);
		boolean result = handler.resolve(talk);
		Assert.assertFalse(result);
	}

}
