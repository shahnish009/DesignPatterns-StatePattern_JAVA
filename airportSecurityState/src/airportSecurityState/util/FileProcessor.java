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
		sc = new Scanner(new File(inputFile));
	}

	/**
	 * method to read line from file line by line
	 * @return one line at a time from the input file
	 */
	public String readLine() {
		
		try {
			if(sc != null) {
				String ln;
				while(sc.hasNext()) {
				ln = sc.nextLine();
				return ln;
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
			System.exit(0);
		}
		return null;
	}

}
