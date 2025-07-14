package com.ncu.processors;
public class EncryptionDecryptionProcossors
{
 
    public static String encrypt(String plainText)//it receives the normal text 
    {
        int shiftKey=3;//it is the key by which every character ascii value is increased
        String encryptedText = "";
        for (int i = 0; i < plainText.length(); i++)//loops occurs till the lenght of the  string
        {
            int charPosition = plainText.charAt(i);//it gives the ascii value of character
            int keyVal = (shiftKey + charPosition);//here we are increasing the ascii value of every character by shiftKey i.e., 3
            encryptedText +=(char)(keyVal);//here we are converting ascii value to character and appends into a string
        }
        return encryptedText;//here we are returning the encrypted text
    }
 
    public static String decrypt(String encryptedText)//it receives the encrypted text
    {
        int shiftKey=3;//it is the key by which every character ascii value is decreased
        String plainText = "";
        for (int i = 0; i < encryptedText.length(); i++)//loops occurs till the lenght of the  string
        {
            int charPosition =encryptedText.charAt(i);//it gives the ascii value of character
            int keyVal = (charPosition - shiftKey);//here we are decreasing the ascii value of every character by shiftKey i.e., 3
            plainText += (char)(keyVal);//here we are converting ascii value to character and appends into a string
        }
        return plainText;//here we are returning the decrypted text
    }
}