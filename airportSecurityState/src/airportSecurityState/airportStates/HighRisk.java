package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;

public class HighRisk implements AirportStateI {
	
	private SecurityFactors sf = null;

	public HighRisk(SecurityFactors sfI) {
		MyLogger.writeMessage("HighRisk constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
		sf = sfI;
	}
	
	public void tightenOrLoosenSecurity() {
		
		if((sf.getAvgTraffic() >= 4 && sf.getAvgTraffic() < 8) && (sf.getAvgProhibited() >= 1 && sf.getAvgProhibited() < 2)) {
			sf.setAsi(sf.getModerateRisk());
			sf.setFlag(1);
			
			MyLogger.writeMessage("State changed to ModerateRisk", MyLogger.DebugLevel.IN_RUN);
		}
		
		else if((sf.getAvgTraffic() >= 0 && sf.getAvgTraffic() < 4) && (sf.getAvgProhibited() >= 1 && sf.getAvgProhibited() < 2)) {
			sf.setAsi(sf.getModerateRisk());
			sf.setFlag(1);
			
			MyLogger.writeMessage("State changed to ModerateRisk", MyLogger.DebugLevel.IN_RUN);
		}
		
		else if((sf.getAvgTraffic() >= 4 && sf.getAvgTraffic() < 8) && (sf.getAvgProhibited() >= 0 && sf.getAvgProhibited() < 1)) {
			sf.setAsi(sf.getModerateRisk());
			sf.setFlag(1);
			
			MyLogger.writeMessage("State changed to ModerateRisk", MyLogger.DebugLevel.IN_RUN);
		}
	}
}
