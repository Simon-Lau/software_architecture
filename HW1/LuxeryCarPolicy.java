
public class LuxeryCarPolicy implements PolicyProducer{
	 public AutoInsurance getInsurObj() {
	       return new LuxeryCarInsurance();
	    }
}
