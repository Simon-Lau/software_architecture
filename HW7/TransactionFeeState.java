/*========================================*/
/* A concrete state in the state pattern  */
/*========================================*/

public class TransactionFeeState extends State{
    private boolean overDrawnLismitFlag = false;

	public TransactionFeeState(){
	     state = FEESTATE;
    }
    public void deposit(double amount){
         balance = context.getBalance()  - BankContext.TRANS_FEE_NORMAL;
         balance = balance + amount;
         context.updateBalance(balance);
         changeState();
    }
    public void withdraw(double amount){
     if ((context.getBalance() - BankContext.TRANS_FEE_NORMAL - amount) > BankContext.OVERDRAW_LIMIT) {
        balance = context.getBalance()  - BankContext.TRANS_FEE_NORMAL;
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
}
