package com.privalia.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class FileManager {

//	private static final 
	
	public static boolean create(String content) 
	{
		String FILENAME = "/Users/raul.vallez/filename.txt";
				
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
			//String content = "This is the content to write into file\n";
			bw.write(content);
			// no need to close it.
			//bw.close();
			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		return true;
	}
	
	public static String read() 
	{
		String FILENAME = "/Users/raul.vallez/filename.txt";
		String line = "";
		
		//Creates the Buffered file reader / writer.  
        try {
        	File f = new File( FILENAME);
            FileReader fr = new FileReader(f);
            BufferedReader br  = new BufferedReader(fr);
            
//            while (Strint pp = br.readLine() != null) {
            	
            line = br.readLine();
              	System.out.println(line);
//            }
            br.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        return line;
	}
}
