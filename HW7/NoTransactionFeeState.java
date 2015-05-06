/*========================================*/
/* A concrete state in the state pattern  */
/*========================================*/

public class NoTransactionFeeState extends State{

   private boolean overDrawnLismitFlag = false;

   public NoTransactionFeeState(){
	  state = NOFEESTATE;
   }
   public void deposit(double amount){
      balance = context.getBalance() + amount;
      context.updateBalance(balance);
      changeState();
   }
   public void withdraw(double amount){
	  if ((context.getBalance() - amount) > BankContext.OVERDRAW_LIMIT){
	     balance = context.getBalance()  - amount;
	     context.updateBalance(balance);
	     changeState();
      }
      else {
		 overDrawnLismitFlag = true;
      }
   }
	public boolean isOverDrawnLimitReached(){
	   return overDrawnLismitFlag;
	}
}

