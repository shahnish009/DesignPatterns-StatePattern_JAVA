package airportSecurityState.driver;

import java.lang.NumberFormatException;
import java.lang.RuntimeException;
import java.util.ArrayList;
import java.util.Arrays;
import airportSecurityState.airportStates.SecurityFactors;
import airportSecurityState.util.Results;
import airportSecurityState.util.MyLogger;
import airportSecurityState.util.FileProcessor;
import java.util.InputMismatchException;
import java.io.FileNotFoundException;

public class Driver {
	
	private static enum prohibitedItems {
		gun,
		nailcutter,
		blade,
		knife
	}
	
	private String opRes(SecurityFactors sf, ArrayList<Integer> al) {
		if(0 == sf.getFlag()) {
			return al.get(0) + " " + al.get(2) + " " + al.get(4) + " " + al.get(6) + " " + al.get(8); 
		}
		else if(1 == sf.getFlag()) {
			return al.get(1) + " " + al.get(2) + " " + al.get(4) + " " + al.get(7) + " " + al.get(8); 
		}
		else if(2 == sf.getFlag()) {
			return al.get(1) + " " + al.get(3) + " " + al.get(5) + " " + al.get(7) + " " + al.get(9); 
		}
		
		return null;
	}

	public static void main(String[] args) {

		String ipFile = null;
		String opFile = null;
		String ip = null;
		double travellers = 0;
		double days = 0;
		double prohibited = 0;
		int debugValueSetter = -1;
		String[] info = null;
		String[] values = null;
		FileProcessor fileP = null;
		ArrayList<Integer> opID = null;
		
		try {
			if(args.length == 3) {
       	        ipFile = args[0];
	            opFile = args[1];
	            debugValueSetter = Integer.parseInt(args[2]);
	            if(!(debugValueSetter >= 0 && debugValueSetter <= 4)) {
	            	throw new RuntimeException("Debug value must be integers between 0 and 4 inclusive");
	            }
	            MyLogger.setDebugValue(debugValueSetter);
			}
			else {
				throw new RuntimeException("Invalid number of arguments. Please enter 3 arguments");
			}
		}
		catch (Exception e) {
			System.err.println("exception occurred while parsing arguments");
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
		
		opID = new ArrayList<Integer>();
		for(int i = 1; i <= 10; i++) {
			opID.add(i);
		}
	
		SecurityFactors secFac = new SecurityFactors(0,0);
		Results r = new Results(opFile);
		Driver d = new Driver();

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
				System.out.println("Day: " + days + "Travellers: " + travellers);
				secFac.setAvgTraffic(travellers / days);
				secFac.setAvgProhibited(prohibited / days);
				secFac.tightenOrLoosenSecurity();
				r.storeNewResult(d.opRes(secFac, opID));
			}
			catch(Exception e) {
				System.err.println(e + "\nInput file nor formatted properly");
				e.printStackTrace();
				System.exit(1);
			}
		
			try {
				r.writeToFile();
			}
			catch(FileNotFoundException e) {
				System.err.println("Output file cannot be generated");
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
}
