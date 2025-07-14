package com.ncu.validators;
import com.ncu.exceptions.*;
import com.ncu.processors.*;
import java.io.*;
import java.util.*;
public class PasswordValidator
{
	public static boolean passwordValidator(String password)throws Exception //it receives password as string and we validates if password is correct or not
	{
		String myPassword="Team1";//it is the fixed password

		Properties prop = new Properties();//object of properties class to read properties file
		FileInputStream input=null;//object of FileInputStream to open the file
		try
		{	
			input = new FileInputStream("..\\File Security System\\configs\\constants\\exceptions.properties");//here we are specifing the path of .properties file
			prop.load(input);//to load properties file
			int k=0;//integer created to check the password is equal or not
			if(password.equals(myPassword))//if password is correct value of k is incremented by 1
			{
				k++;//k become 1
			}
			if(k==0)//testpassword!=myPassword
			{
				throw new PasswordValidatorException("Password Validator Exception");

			}			
		}
		catch(PasswordValidatorException e)
		{
			String s=prop.getProperty("PasswordValidatorExceptionMessage");
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