package airportSecurityState.util;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class FileProcessor {
	
	private Scanner sc = null;

	/**
	 * constructor for FileProcessor
	 * @param inputFile - file to be processed
	 * @throws FileNotFoundException
	 */
	public FileProcessor(String inputFile) throws FileNotFoundException{
		MyLogger.writeMessage("FileProcessor constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
		sc = new Scanner(new File(inputFile));
	}

	/**
	 * method to read line from file line by line
	 * @return one line at a time from the input file
	 */
	public String readLine() {
		
		try {
			if(sc != null) {
				while(sc.hasNext()) {
					return sc.nextLine();
				}
			}
			else {
				throw new RuntimeException("unable to open file");
			}
			
			if(sc != null) {
				sc.close();
				sc = null;
			}
			return null;
		}
		catch(Exception e) {
			System.err.println(e + " occurred during readLine");
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}
