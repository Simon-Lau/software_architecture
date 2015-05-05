

public class BodyPolicy implements PolicyProducer {
    public AutoInsurance getInsurObj() {
       return new BodyInjur();
    }
}
