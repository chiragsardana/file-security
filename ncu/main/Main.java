package com.ncu.main;
import com.ncu.exceptions.*;//in this package all exceptions are present
import com.ncu.validators.*;//int this package all validator class are present
import com.ncu.processors.*;//in this package all processors class are present
import java.util.Scanner;//scanner class
import java.io.*;//input output classes
public class Main
{
	static Scanner input=new Scanner(System.in);//scanner is created to scan int, char & string
	public static void main(String[] args)throws Exception//main interface
	{	
		clrscr();//clear screen function
		int selection=0;
		while(selection!=1||selection!=2||selection!=3)//while loop is created to show main interface again and again until user enter value from the main interface
		{	
			
			System.out.println("\n=======================  WELCOME TO INTERFACE  =======================\n ");
			System.out.println(" \n                      \t1. To Encrypt Text File ");
			System.out.println(" \n                      \t2. To Decrypt Text File ");
			System.out.println(" \n                      \t3. To Exit Program ");
			System.out.print("\n\nEnter Your Option : ");
			selection=input.nextInt();
			clrscr();
			switch(selection)
			{
   			case 1 :
    	  	Encrypt();//it calls encrypt method 
			break;
   			case 2 :
   			Decrypt();//it calls decrypt method
    	 	break;
    	 	case 3:
    	 	System.exit(1);//to exit the program or to break the program
    	 	break;
    	 	default : 
    	  	System.out.println("\n=========== You Entered Incorrect Choice, Please Try Again ===========\n");//if you entered no. other than 1,2 & 3 this statement shows
			}
		}
	}
	static String getFileName()//to scan the name of file 
	{
		String filename=null;
		try
		{
			filename = input.nextLine();
			System.out.println();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return filename;
	}
	static void Encrypt()throws Exception//in this method we are converting normal text file into encrypted text file
	{
		String txtFilename;
		boolean b;
		System.out.print("\nEnter Text File Name : ");
		input.nextLine();
		txtFilename = getFileName();//here it taking file name from user
		NameValidator txtObject = new NameValidator();
		b = txtObject.nameValidator(txtFilename);//it validates the text file name which user enters
		boolean b1=false;
		String txtFilename1="..\\File Security System\\text file\\"+txtFilename;
		if(b==true)//this statement happens when file name is true else not
		{	
			b1=txtObject.fileExist(txtFilename1);//its validates that the text file exist or not
		}
		if(b1==true)//intially b1=false, if file name is correct and file exist, b1 becomes true and this statement occurs else not
			System.out.println("Text File is OK..\n");
		else
		{
			exitOrmain();//it calls the exitOrmain() method which show many options like to exit or go to main interface	
		}

		String encryptedFilename;
		System.out.print("Enter Encrypt Text File name : ");//now enters the encrypt file name
		encryptedFilename =getFileName();//here it taking name from user
		boolean b2=false;//to check whether the name of encrypted text file is correct or not
		b2= txtObject.nameValidator(encryptedFilename);//here we are checking the file name is correct or not
		if(b2==true)
			System.out.println("Name of Encrypted Text File is OK..\n");
		else
			exitOrmain();//it calls the exitOrmain() method which show many options like to exit or go to main interface	
 
		ProcessTxtEncryption obj1=new ProcessTxtEncryption();//here we are creating object of ProcessTxtEncryption class which is used to encrypt the text file
		boolean b3=false;//to check the procces of encryption done or not
		b3=obj1.processTxtEncryption(txtFilename,encryptedFilename);//here we are passing the name of text file and enrypted text file 

		if(b3==true)//intially b3 is false if text file encrypted b3 becomes true and this statement occurs
			System.out.println("\t\t...Converted...");

			System.out.println("\n1. To View Encrypted Text File ");
			System.out.println("2. To Exit Program");
			System.out.println("Any Number To go back to Main Interface\n");
			System.out.print("Enter Your Option : ");
			int no=input.nextInt();
			switch(no)
				{
					case 1 :
					String encryptedFilename1="..\\File Security System\\securited file\\"+encryptedFilename;
					showFile(encryptedFilename1);//here we are passing the entire path as it required to show the text in the file
					break;
					case 2 :
					clrscr();//clear screen
					System.exit(1);//to exit
					break;
					default :
					clrscr();//clear screen and after these the main interface
				}
	}

	static void Decrypt()throws Exception//in this we are converting encrypted text file to decrypted text file
	{
		String txtFilename;
		boolean b=false,b1=false,b2=false;
		System.out.print("\nEnter Text File Name : ");
		input.nextLine();
		txtFilename = getFileName();//to take name of file form user
		NameValidator txtObject = new NameValidator();
		b = txtObject.nameValidator(txtFilename);//here we are checking the name of the text file is ok or not 
		
		if(b==true)// intially b is false if name of text file is correct the b becomes true and this statement takes place else not
		{
			String txtFilename1="..\\File Security System\\securited file\\"+txtFilename;
			b1=txtObject.fileExist(txtFilename1);//here we are sending the entire path to check whether file exist or not
		}
		if(b1==true)//if both name of the text file and text file exist then b1 is true
			System.out.println("Text File is OK..");
		else
			exitOrmain();//it happens when b1 is false,it shows various options like go to main interface or to exit the program		
		

		String decryptedFilename;
		System.out.print("\nEnter Decrypt Text File name : ");
		decryptedFilename = getFileName();//here it takes decrypted file name from user

		b2= txtObject.nameValidator(decryptedFilename);//here we are sending the entire path with the help of string
		if(b2==true)//intially b2 is false if the name of the file is ok, b2 becomes true and this statement executes
			System.out.println("Name of Decrypted Text File is OK..\n");
		else
			exitOrmain();//it happens when b2 is false,it shows various options like go to main interface or to exit the program

		System.out.print("Enter the Security Key Algorithm : ");
		int myKey=input.nextInt();//take key input from user
		System.out.println();
		KeyValidator keychecker=new KeyValidator();//for key validation checking
		boolean keym=keychecker.keyValidator(myKey);//it checks whether the key is coorect or not which was entered by user
		if(keym==true)
		{

		}
		else
		{
			exitOrmain();//if you enter wrong key, it shows various options like go to main interface or to exit the program
		}

		System.out.print("Enter the Password : ");
		input.nextLine();
		String myPassword=input.nextLine();//password
		System.out.println();
		PasswordValidator passwordchecker=new PasswordValidator();//for password validation checking
		boolean pass=passwordchecker.passwordValidator(myPassword);//it checks whether the password is coorect or not which was entered by user
		if(pass==true)
		{

		}
		else
		{
			exitOrmain();//if you enter wrong password, it shows various options like go to main interface or to exit the program
		}


 
		ProcessTxtDecryption obj1=new ProcessTxtDecryption();//it the class which decrypt the encrypt text
		boolean check1=false;
		if(pass==true&&keym==true)//it happens only if both password and key is true
		{
			check1=obj1.processTxtDecryption(txtFilename,decryptedFilename);//here we are converting the encrypted file into decrypted
		}
		if(check1==true)//it happens only if the file convert succesfully
		{
			System.out.println("\t\t...Converted...");
			System.out.println("\n1. To View Decrypted Text File ");
			System.out.println("2. To Exit Program");
			System.out.println("Any Number To go back to Main Interface\n");
			System.out.print("Enter Your Option : ");
			int no=input.nextInt();
			switch(no)
				{
					case 1 :
					String decryptedFilename1="..\\File Security System\\text file\\"+decryptedFilename;//path where decrypted file stored 
					showFile(decryptedFilename1);
					break;
					case 2 :
					clrscr();//clear screen
					System.exit(1);//to exit the program
					break;
					default :
					clrscr();//clear screen
				}
		}		

	}
	static void clrscr()//for clear screen
	{
		try 
		{
        	if (System.getProperty("os.name").contains("Windows"))
        	{
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        	}

        else
        	{
            Runtime.getRuntime().exec("clear");
        	}
    	} 
    	catch (IOException | InterruptedException ex) 
    	{

    	}

	}
	static void exitOrmain()throws Exception//to exit or to go main interface
	{
		String arr[] = {"team", "1", "project"};//here we just creating an array to just call main method
		System.out.print("\nPress\n1. To go to Main Interface\n2. To Exit Program\n\nEnter Your Option : ");
		int num=input.nextInt();//input from user
		switch(num)
		{
			case 1 :
			main(arr);
			break;
			case 2 : 
			clrscr();
			System.exit(1);
			break;
			default :
			clrscr();
			System.out.println("You Entered Invalid Choice Please Try Again");
			exitOrmain();
			break;
		}
	}
	static void showFile(String path)throws Exception//it show the data in the text file
	{
		clrscr();//clear screen
		System.out.println("The Data in the file is : ");
		FileReader fr=new FileReader(path);//FileReader is a class that helps to read data from a file
		BufferedReader br = new BufferedReader(fr);//BufferedReader reads characters from another Reader.


		String line;
    	while ((line = br.readLine()) != null) 
    	{
    		System.out.println(line);
   		}
   		System.out.println("===============End================");
		exitOrmain();//to call exit main method which shows various option like exit or go to main interface...
	}
}