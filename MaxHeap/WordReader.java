/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordReader {
	
	public static Word[] loadWords(){
		Word[] wordArray = new Word[10000];
		
		try{
			String currentDirectory = System.getProperty("user.dir") + "/";
			// System.out.println(currentDirectory);
			BufferedReader bf = new BufferedReader(new FileReader(currentDirectory + "words.csv"));
			int count = 0;
			while(count < wordArray.length){
				wordArray[count] = parseWord(bf.readLine());
				count++;
			}
			bf.close();
		}
		catch(IOException e){
			System.out.println("File 'words.csv' not found.");
		}
		
		return wordArray;
	}
	
	private static Word parseWord(String line){
		if(line == null)
			return null;
		
		String[] strPair = line.split(",");
		if(strPair.length == 2)
			return new Word(strPair[0], Integer.parseInt(strPair[1]));
		else
			return null;
	}
}
