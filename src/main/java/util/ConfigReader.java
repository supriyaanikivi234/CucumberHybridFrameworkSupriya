package util;

import java.util.*;
import java.io.*;

public class ConfigReader {

	public Properties intializeProperties()
	{
		Properties prop=new Properties();
		File proFile=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.properties");
		try
		{
		FileInputStream fis=new FileInputStream(proFile);
		prop.load(fis);
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
		
		return prop;
	}
}
