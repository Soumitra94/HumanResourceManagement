package com.hrm.genericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility 
{


		Connection con = null;
		
		
		public void connectToDB() throws SQLException
		{
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(IPathconstants.dbURL, IPathconstants.dbUsername, IPathconstants.dbPassword);
		
		}
		
		
		public String executeQueryAndGetData(String query, int columnNo, String ExpData) throws SQLException
		{
			
			ResultSet result = con.createStatement().executeQuery(query);
			boolean flag = false;
			while(result.next())
			{
				String data = result.getString(columnNo);
				if(data.equalsIgnoreCase(ExpData))
				{
					flag =true;
					break;
				}
			}
			if(flag==true)
			{
				System.out.println("-- Data is Varified");
				return ExpData;
			}
			else
			{
				System.out.println("-- Data is not present");
				return "";
			} 
			
		}
		
		
		public void closeDB() throws SQLException
		{
			con.close();
		}
		
		
	}


