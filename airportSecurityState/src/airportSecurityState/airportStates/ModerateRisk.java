package airportSecurityState.airportStates;

public class ModerateRisk implements AirportStateI {
	
	private SecurityFactors sf = null;

	public ModerateRisk(SecurityFactors sfI) {
		sf = sfI;
	}
	
	public void tightenOrLoosenSecurity() {
		if((sf.getAvgTraffic() >= 8) || (sf.getAvgProhibited() >= 2)) {
			sf.setAsi(sf.getHighRisk());
			
			System.out.println("HIGH");
		}
		
		else if((sf.getAvgTraffic() >= 0 && sf.getAvgTraffic() < 4) && (sf.getAvgProhibited() >= 0 && sf.getAvgProhibited() < 1)) {
			sf.setAsi(sf.getLowRisk());
			
			System.out.println("LOW");
		}
	}
}
