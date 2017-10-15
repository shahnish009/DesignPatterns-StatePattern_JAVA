package airportSecurityState.airportStates;

public class HighRisk implements AirportStateI {
	
	private SecurityFactors sf = null;

	public HighRisk(SecurityFactors sfI) {
		sf = sfI;
	}
	
	public void tightenOrLoosenSecurity() {
		if((sf.getAvgTraffic() >= 4 && sf.getAvgTraffic() < 8) && (sf.getAvgProhibited() >= 1 && sf.getAvgProhibited() < 2)) {
			sf.setAsi(sf.getModerateRisk());
			
			System.out.println("MOD");
		}
	}
}
