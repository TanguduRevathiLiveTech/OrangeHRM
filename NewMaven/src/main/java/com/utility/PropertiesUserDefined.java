package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUserDefined {

	public static String getproperty(String FileName,String Proeprty) throws IOException {
	FileInputStream PropertiesFile=new FileInputStream(FileName);
    Properties ElementProperties=new Properties();
    ElementProperties.load(PropertiesFile);
   String variable=ElementProperties.getProperty(Proeprty);
   return variable;
	}
}
