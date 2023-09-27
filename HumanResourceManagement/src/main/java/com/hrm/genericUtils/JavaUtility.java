package com.hrm.genericUtils;

import java.util.Date;
import java.util.Random;

public class JavaUtility 
{
	public int getRandomNumber()
	{
		Random ran=new Random();
		int randNum=ran.nextInt(1000);
		return randNum;
	}

	public String getSystemDate()
	{
		Date d=new Date();
		
		return d.toString();
	}
	public void systemDateFormat()
	{
		Date DT=new Date(0);
		String[] d=DT.toString().split(" ");
		String day=d[0];
		String month=d[1];
		String date=d[2];
		String year=d[3];
		String finalFormat=day+" "+month+" "+date+" "+year+" ";
		
	}

}

