





public class PersonPolicy implements PolicyProducer {

   public AutoInsurance getInsurObj() {
      return new PersonInjur();
   }
}
