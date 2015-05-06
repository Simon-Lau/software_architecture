/*===============================*/
/* A concrete state in the state pattern  */
/*===============================*/

  public class OverDrawnState extends State{

    private boolean overDrawnLismitFlag = false;

	 public OverDrawnState( ){
	   state = OVERDRAWNSTATE;
    }
    public void deposit(double amount){
       balance = context.getBalance()  - BankContext.TRANS_FEE_OVERDRAW;
       balance = balance + amount;
       context.updateBalance(balance);
       changeState();
    }
    public void withdraw(double amount){
       if ((context.getBalance() - BankContext.TRANS_FEE_OVERDRAW - amount) > BankContext.OVERDRAW_LIMIT){
          balance = context.getBalance() -BankContext.TRANS_FEE_OVERDRAW;
          balance = balance - amount;
          context.updateBalance(balance);
          changeState();
       }
       else{
	      overDrawnLismitFlag = true;
       }
    }
    public boolean isOverDrawnLimitReached(){
		return overDrawnLismitFlag;
	}
    public void sendMailToAccountHolder(){
        System.out.println ("Attention: Your Account is Overdrawn");
    }
}
