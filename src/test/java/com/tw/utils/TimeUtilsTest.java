package com.tw.utils;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import com.tw.exception.CommonException;


public class TimeUtilsTest {
	
	@Test
	public void test9am(){
		String s;
		try {
			s = TimeUtils.getTimeStr(9 * 60);
			Assert.assertEquals("09:00AM", s);
		} catch (CommonException e) {
			fail("expected no exception to be thrown");
		}
	}
	
	@Test
	public void test30Past9am(){
		String s;
		try {
			s = TimeUtils.getTimeStr((long)(9.5 * 60));
			Assert.assertEquals("09:30AM", s);
		} catch (CommonException e) {
			fail("expected no exception to be thrown");
		}
	}
	
	@Test
	public void test12pm(){
		String s;
		try {
			s = TimeUtils.getTimeStr(12 * 60);
			Assert.assertEquals("12:00PM", s);
		} catch (CommonException e) {
			fail("expected no exception to be thrown");
		}
	}
	
	@Test
	public void test3pm(){
		String s;
		try {
			s = TimeUtils.getTimeStr(15 * 60);
			Assert.assertEquals("03:00PM", s);
		} catch (CommonException e) {
			fail("expected no exception to be thrown");
		}
	}
	
	@Test
	public void test8am() {
		try {
			TimeUtils.getTimeStr(8 * 60);
			fail("Expected an CommonException to be thrown");
			
		} catch (CommonException e) {
		}
	}
	
	@Test
	public void test6pm() {
		try {
			TimeUtils.getTimeStr(18 * 60);
			fail("Expected an CommonException to be thrown");
			
		} catch (CommonException e) {
		}
	}
	
}
