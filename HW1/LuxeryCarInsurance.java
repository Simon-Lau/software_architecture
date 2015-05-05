
public class LuxeryCarInsurance implements AutoInsurance{
	private String description;
	
	public String getInfo(){
		description = "Luxery Car Liability:\n\n Luxery car damage coverage pays for car repairing";
		
		return description;
	}
}
