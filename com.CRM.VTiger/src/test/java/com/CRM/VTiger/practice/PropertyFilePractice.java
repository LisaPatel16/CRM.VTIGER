package com.CRM.VTiger.practice;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String Browser = pobj.getProperty("browser");
		System.out.println(Browser);
		String url = pobj.getProperty("url");
		System.out.println(url);
	}

}
