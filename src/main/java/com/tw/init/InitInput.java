package com.tw.init;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InitInput {
	
	public static List<String> getInputTalks(){
		List<String> strTalks = new ArrayList<String>();
		FileInputStream inputStream = null;
		BufferedReader bufferedReader = null;
		try {
			inputStream = new FileInputStream(System.getProperty("user.dir") + File.separator + "config" + File.separator + "input.txt");
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String str = null;
			while((str = bufferedReader.readLine()) != null) {
				strTalks.add(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				bufferedReader.close();
				inputStream.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return strTalks;
	}



}
