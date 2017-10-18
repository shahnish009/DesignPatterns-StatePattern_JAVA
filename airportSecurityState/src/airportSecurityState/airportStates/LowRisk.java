package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;

public class LowRisk implements AirportStateI {
	
	private SecurityFactors sf = null;

	public LowRisk(SecurityFactors sfI) {
		MyLogger.writeMessage("LowRisk constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
		sf = sfI;
	}
	
	public void tightenOrLoosenSecurity() {
		
		if((sf.getAvgTraffic() >= 4 && sf.getAvgTraffic() < 8) || (sf.getAvgProhibited() >= 1 && sf.getAvgProhibited() < 2)) {
			sf.setAsi(sf.getModerateRisk());
			sf.setFlag(1);

			MyLogger.writeMessage("State changed to ModerateRisk", MyLogger.DebugLevel.IN_RUN);
		}
	}
}
