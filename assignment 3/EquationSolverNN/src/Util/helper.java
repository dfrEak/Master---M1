/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

/**
 * helper functions
 * @author d_frEak
 */
public class helper {

    /**
     * load the file
     * @param file the file input
     * @return file's teks
     */
    public static String load(File file)
    {
        StringBuilder retval=new StringBuilder();
		try {
			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream(file);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			int i = 0, j = 0;
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				retval.append(strLine);
                                retval.append("\n");
			}
			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
            return retval.toString();
	}

    /**
     * save the text to file file
     * @param file the file output
     * @param text the text input
     */
    public static void save(File file, String text)
    {
          int n=0;
          try
          {
              // Create file
              FileWriter fstream = new FileWriter(file.getAbsolutePath());
              BufferedWriter out = new BufferedWriter(fstream);
              out.write(text);
              //Close the output stream
              out.close();
          }
          catch (Exception e)
          {//Catch exception if any
              System.err.println("Error: " + e.getMessage());
          }
    }


}
