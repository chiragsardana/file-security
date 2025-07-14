package com.ncu.validators;
import com.ncu.exceptions.*;
import com.ncu.processors.*;
import java.io.*;
import java.util.*;
public class KeyValidator
{
	public boolean keyValidator(int key)throws Exception//it receives key as string and we validates if key is correct or not
	{
		int myKey=3;//it is the fixed key

		Properties prop = new Properties();//object of properties class to read properties file
		FileInputStream input=null;//object of FileInputStream to open the file
		try
		{

			input = new FileInputStream("..\\File Security System\\configs\\constants\\exceptions.properties");//here we are specifing the path of .properties file
			prop.load(input);//to load properties file
			if(myKey==key)
			{

			}
			else
			{
				throw new SecurityAlgorithmKeyException("Security Algorithm Key Exception");//exception throws if key is not equal
			}
		}	
		catch(SecurityAlgorithmKeyException e)
		{
			String s=prop.getProperty("SecurityAlgorithmKeyExceptionMessage");//Searches for the property with the specified key in the property list.
			System.out.println(s);
			return false;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		return true;	
	}
}