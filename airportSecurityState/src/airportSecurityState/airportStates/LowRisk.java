package airportSecurityState.airportStates;

public class LowRisk implements AirportStateI {
	
	private SecurityFactors sf = null;

	public LowRisk(SecurityFactors sfI) {
		sf = sfI;
	}
	
	public void tightenOrLoosenSecurity() {
		
		System.out.println("currently in LOW");
		System.out.println(sf.getAvgTraffic());
		System.out.println(sf.getAvgProhibited());
		if((sf.getAvgTraffic() >= 4 && sf.getAvgTraffic() < 8) || (sf.getAvgProhibited() >= 1 && sf.getAvgProhibited() < 2)) {
			sf.setAsi(sf.getModerateRisk());
			sf.setFlag(1);
			System.out.println("change to MOD");
		}
	}
}
