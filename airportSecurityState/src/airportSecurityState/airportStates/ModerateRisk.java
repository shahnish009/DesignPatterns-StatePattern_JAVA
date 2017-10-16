package airportSecurityState.airportStates;

public class ModerateRisk implements AirportStateI {
	
	private SecurityFactors sf = null;

	public ModerateRisk(SecurityFactors sfI) {
		sf = sfI;
	}
	
	public void tightenOrLoosenSecurity() {
		
		System.out.println("currently in MOD");
		System.out.println(sf.getAvgTraffic());
		System.out.println(sf.getAvgProhibited());
		if((sf.getAvgTraffic() >= 8) || (sf.getAvgProhibited() >= 2)) {
			sf.setAsi(sf.getHighRisk());
			sf.setFlag(2);
			
			System.out.println("change to HIGH");
		}
		
		else if((sf.getAvgTraffic() >= 0 && sf.getAvgTraffic() < 4) && (sf.getAvgProhibited() >= 0 && sf.getAvgProhibited() < 1)) {
			sf.setAsi(sf.getLowRisk());
			sf.setFlag(0);
			
			System.out.println("change to LOW");
		}
	}
}
