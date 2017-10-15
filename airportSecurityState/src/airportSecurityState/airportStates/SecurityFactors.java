package airportSecurityState.airportStates;

public class SecurityFactors {

	private AirportStateI lowRisk;
	private AirportStateI moderateRisk;
	private AirportStateI highRisk;
	
	private AirportStateI asi = null;;
	private double avgTraffic = 0;
	private double avgProhibited = 0;
	
	public SecurityFactors(double avgTrafficI, double avgProhibitedI) {
		lowRisk = new LowRisk(this);
		moderateRisk = new ModerateRisk(this);
		highRisk = new HighRisk(this);
		asi = lowRisk;
		
		avgTraffic = avgTrafficI;
		avgProhibited = avgProhibitedI;
	}
	
	public void tightenOrLoosenSecurity() {
		asi.tightenOrLoosenSecurity();
	}
	
	public void setAsi(AirportStateI asiI) {
		asi = asiI;
	}
	
	public AirportStateI getAsi() {
		return asi;
	}
	
	public void setAvgTraffic(double d) {
		avgTraffic = d;
	}
	
	public double getAvgTraffic() {
		return avgTraffic;
	}
	
	public void setAvgProhibited(double d) {
		avgProhibited = d;
	}
	
	public double getAvgProhibited() {
		return avgProhibited;
	}
	
	public AirportStateI getLowRisk() {
		return lowRisk;
	}
	
	public AirportStateI getModerateRisk() {
		return moderateRisk;
	}
	
	public AirportStateI getHighRisk() {
		return highRisk;
	}
}
