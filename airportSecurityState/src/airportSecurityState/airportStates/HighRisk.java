package airportSecurityState.airportStates;

public class HighRisk implements AirportStateI {
	
	private SecurityFactors sf = null;

	public HighRisk(SecurityFactors sfI) {
		sf = sfI;
	}
	
	public void tightenOrLoosenSecurity() {
		
		System.out.println("currently in HIGH");
		System.out.println(sf.getAvgTraffic());
		System.out.println(sf.getAvgProhibited());
		
		if((sf.getAvgTraffic() >= 4 && sf.getAvgTraffic() < 8) && (sf.getAvgProhibited() >= 1 && sf.getAvgProhibited() < 2)) {
			sf.setAsi(sf.getModerateRisk());
			sf.setFlag(1);
			
			System.out.println("change to MOD");
		}
		
		else if((sf.getAvgTraffic() >= 0 && sf.getAvgTraffic() < 4) && (sf.getAvgProhibited() >= 1 && sf.getAvgProhibited() < 2)) {
			sf.setAsi(sf.getModerateRisk());
			sf.setFlag(1);
			
			System.out.println("change to MOD");
		}
		
		else if((sf.getAvgTraffic() >= 4 && sf.getAvgTraffic() < 8) && (sf.getAvgProhibited() >= 0 && sf.getAvgProhibited() < 1)) {
			sf.setAsi(sf.getModerateRisk());
			sf.setFlag(1);
			
			System.out.println("change to MOD");
		}
		
		
	}
}
