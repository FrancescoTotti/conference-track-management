package com.tw.utils;

import org.junit.Assert;
import org.junit.Test;

import com.tw.talk.Talk;


public class TalkParserTest {
	
	@Test
	public void testEndWithMin() {
		Talk talk = TalkParser.parse("aa 60min");
		Assert.assertNotNull(talk);
	}
	
	@Test
	public void testEndWithLightning() {
		Talk talk = TalkParser.parse("aa lightning");
		Assert.assertNotNull(talk);
	}
	
	@Test
	public void testInvalidEnd() {
		Talk talk = TalkParser.parse("aa aaa");
		Assert.assertNull(talk);
	}
	
	@Test
	public void testNoNumber() {
		Talk talk = TalkParser.parse("aa bmin");
		Assert.assertNull(talk);
	}

}
