package com.ncu.processors;
import java.io.*;
import java.util.*;
public class ProcessTxtEncryption
{
	public boolean processTxtEncryption(String txtFilename,String encryptedFilename)//it receives the both text file name
	{
		try
		{
			String txtFilename1="..\\File Security System\\text file\\"+txtFilename;
			FileReader fr=new FileReader(txtFilename1);//Here we are creating a object of reader to read normal text file
			BufferedReader br = new BufferedReader(fr);
			
			String encryptedFilename1="..\\File Security System\\securited file\\"+encryptedFilename;
			FileWriter fw = new FileWriter(encryptedFilename1);//here we are created a object of writter class to
   			BufferedWriter bw = new BufferedWriter(fw);//write the text which we recevied after encrypting on an another text file
    		String line;
    		while ((line = br.readLine()) != null) 
    		{
    			line=EncryptionDecryptionProcossors.encrypt(line);//here we are encrypting line by line
    			bw.write(line);//and writing on the another text file
    			bw.newLine();//to enter a next line
    		}

    		bw.close();// to close file writter and save the text which is written in the file
		}
		catch(Exception e)
		{
			System.out.println(e);
			return (false);
		}

		return (true);
	}
}			