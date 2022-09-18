package com.sample.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertiesUtil {

	/* Program to write data to Properties file */
	@Test
	public void writeProperties() {
		Properties prop = new Properties();
		OutputStream outputStream = null;

		try {
			outputStream = new FileOutputStream("config.properties");
			prop.setProperty("URL", "https://www.appurltest.com");
			prop.setProperty("userName", "testUser");
			prop.setProperty("password", "testPwd");
			prop.store(outputStream, "Data Written to properties file.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (outputStream != null)
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	/* Program to read data to Properties file */
	@Test
	public void readProperties() {
		Properties prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("config.properties");
			prop.load(fis);
			System.out.println(prop.getProperty("URL"));
			System.out.println(prop.getProperty("userName"));
			System.out.println(prop.getProperty("password"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}
