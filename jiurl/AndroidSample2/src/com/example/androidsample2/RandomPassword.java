package com.example.androidsample2;

import java.util.Random;

public class RandomPassword{
	private String strRandomPassword;
	private int nRandomPasswordLength;
	
	private final static char caAlphabet[] = 
		{
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
		'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
		};
	
	public RandomPassword( int nRandomPasswordLength ){
		this.nRandomPasswordLength = nRandomPasswordLength;
		this.strRandomPassword = CreateRandomPassword( nRandomPasswordLength );
	}
	
	private String CreateRandomPassword( int nRandomPasswordLength ){
		int i;
		
		Random rnd = new Random();
		rnd.setSeed(System.nanoTime());
			
		StringBuilder strBuilder = new StringBuilder("");
			
		int x;
		x = Math.abs(rnd.nextInt())%26;
			
		strBuilder.append(RandomPassword.caAlphabet[x]);
		for(i=1;i<nRandomPasswordLength;i++)
		{
			x = Math.abs(rnd.nextInt())%36;
			strBuilder.append(RandomPassword.caAlphabet[x]);
		}
			
		strRandomPassword = strBuilder.toString();
			
		return this.strRandomPassword;
	}
	
	public String GetRandomPassword(){
		return strRandomPassword;
	}
}
