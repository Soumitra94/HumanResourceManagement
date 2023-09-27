package com.hrm.genericUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility 
{
	public String getPropertyKeyValue(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IPathconstants.propertyFilePath);
		Properties p=new Properties();
		p.load(fis);
		return p.getProperty(key);
	}

}
