package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;

public class ModerateRisk implements AirportStateI {
	
	private SecurityFactors sf = null;

	public ModerateRisk(SecurityFactors sfI) {
		MyLogger.writeMessage("ModerateRisk constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
		sf = sfI;
	}
	
	public void tightenOrLoosenSecurity() {
		
		if((sf.getAvgTraffic() >= 8) || (sf.getAvgProhibited() >= 2)) {
			sf.setAsi(sf.getHighRisk());
			sf.setFlag(2);
			
			MyLogger.writeMessage("State changed to HighRisk", MyLogger.DebugLevel.IN_RUN);
		}
		
		else if((sf.getAvgTraffic() >= 0 && sf.getAvgTraffic() < 4) && (sf.getAvgProhibited() >= 0 && sf.getAvgProhibited() < 1)) {
			sf.setAsi(sf.getLowRisk());
			sf.setFlag(0);
			
			MyLogger.writeMessage("State changed to LowRisk", MyLogger.DebugLevel.IN_RUN);
		}
	}
}
