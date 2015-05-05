


public class CollPolicy implements PolicyProducer {
    public AutoInsurance getInsurObj() {
        return new Collision();
    }
}
