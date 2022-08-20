import java.text.DecimalFormat;

public class Convert {
	
	private String userValue;
	private double tokenValue;
	
	String response;
	String simbol;		
		
	DecimalFormat decimal = new DecimalFormat("#.##");
	
	public String valueToToken () {
		double convertString = Double.parseDouble(userValue);
		double calc = convertString / this.tokenValue;
		
		return this.response = String.valueOf(simbol + " " + decimal.format(calc));
	}
	
	public String tokenToValue () {			
		double convertString = Double.parseDouble(userValue);
		double calc = convertString * this.tokenValue;
		
		return this.response = String.valueOf("R$ " + decimal.format(calc));
	}
	
	
	public double getTokenValue() {
		return this.tokenValue;
	}
	
	public void setTokenValue(double token, String simbol) {		
		this.tokenValue = token;
		this.simbol = simbol;
	}
	
	public String getUserValue() {
		return this.userValue;
	}
	
	public void setUserValue(String userValue) {
		this.userValue = userValue;
	}

}
