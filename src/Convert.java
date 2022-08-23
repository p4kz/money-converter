import java.text.DecimalFormat;

public class Convert {
	
	private double tokenValue;
	private String userValue;
	private String simbol;		
	
	String response;
		
	DecimalFormat decimal = new DecimalFormat("#.##");
	
	public Convert (double tokenValue, String simbol, String userValue) {
		this.tokenValue = tokenValue;
		this.simbol = simbol;
		this.userValue = userValue;
	}
	
	public String valueToToken () {
		double string = Double.parseDouble(userValue);
		double calc = string / this.tokenValue;
		
		return this.response = String.valueOf(simbol + " " + decimal.format(calc));
	}
	
	public String tokenToValue () {			
		double string = Double.parseDouble(userValue);
		double calc = string * this.tokenValue;
		
		return this.response = String.valueOf("R$ " + decimal.format(calc));
	}

}