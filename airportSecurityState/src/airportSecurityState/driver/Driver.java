package airportSecurityState.driver;

import java.lang.NumberFormatException;
import java.lang.RuntimeException;
import java.util.ArrayList;
import java.util.Arrays;
import airportSecurityState.airportStates.SecurityFactors;
import airportSecurityState.util.Results;
import airportSecurityState.util.FileProcessor;
import java.util.InputMismatchException;
import java.io.FileNotFoundException;

public class Driver {
	
	private enum prohibitedItems {
		gun,
		nailcutter,
		blade,
		knife
	}

	public static void main(String[] args) {

		String ipFile = null;
		String opFile = null;
		String ip = null;
		double travellers = 0;
		double days = 0;
		double prohibited = 0;
		String[] info = null;
		String[] values = null;
		FileProcessor fileP = null;
		
		try {
			if(args.length == 2) {
       	        ipFile = args[0];
	            opFile = args[1];
			}
			else {
				throw new RuntimeException("Invalid number of arguments. Please enter 2 arguments");
			}
		}
		catch (Exception e) {
			System.err.println(e + " occurred while parsing arguments");
			e.printStackTrace();
			System.exit(1);
		}

		try {
			fileP = new FileProcessor(ipFile);
		}
		catch(FileNotFoundException e) {
			System.err.println(e + " input file not found.");
			e.printStackTrace();
			System.exit(1);
		}
	
		SecurityFactors secFac = new SecurityFactors(0,0);

		while((ip = fileP.readLine()) != null) {

			try {
				info = ip.split(";");
				values = info[0].split(":");
				days = Double.parseDouble(values[1]);
				values = null;
				values = info[3].split(":");
				for(prohibitedItems pi : prohibitedItems.values()) {
					if(pi.name().equalsIgnoreCase(values[1])) {
						prohibited+=1;
					}
				}
				travellers+=1;
				
				secFac.setAvgTraffic(travellers / days);
				secFac.setAvgProhibited(prohibited / days);
				secFac.tightenOrLoosenSecurity();
			}
			catch(Exception e) {
				System.err.println(e + "\nInput file nor formatted properly");
				e.printStackTrace();
				System.exit(1);
			}
		
			try {
				Results r1 = new Results(opFile);
				r1.writeToFile();
			}
			catch(FileNotFoundException e) {
				System.err.println("Output file cannot be generated");
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
}
