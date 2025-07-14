package com.ncu.processors;
import java.io.*;
import java.util.*;
public class ProcessTxtDecryption
{
	public boolean processTxtDecryption(String txtFilename,String decryptedFilename)//it receives the both text file name
	{
		try
		{
			String txtFilename1="..\\File Security System\\securited file\\"+txtFilename;//path of encrypted text file
			FileReader fr=new FileReader(txtFilename1);//Here we are creating a object of reader to read encrypted file
			BufferedReader br = new BufferedReader(fr);//

			String decryptedFilename1="..\\File Security System\\text file\\"+decryptedFilename;
			FileWriter fw = new FileWriter(decryptedFilename1);//here we are created a object of writter class to
   			BufferedWriter bw = new BufferedWriter(fw); //write the text which we recevied after decrypting on an another text file

   			String line;
    		while ((line = br.readLine()) != null) 
    		{
    			line=EncryptionDecryptionProcossors.decrypt(line);//here we are decrypting line by line
    			bw.write(line);//and writing on the another text file
    			bw.newLine();//to enter a next line
    		}
    		bw.close();// to close file writter and save the text which is written in the file
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		return true;	
	}

}