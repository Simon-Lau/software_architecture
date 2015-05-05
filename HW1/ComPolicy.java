

public class ComPolicy implements PolicyProducer {

    public AutoInsurance getInsurObj() {
        return new ComCover();
    }
}
