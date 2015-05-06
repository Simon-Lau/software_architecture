
public class TaxState extends State {
	  private boolean overDrawnLismitFlag = false;

	   public TaxState(){
		  state = TAXSTATE;
	   }
	   public void deposit(double amount){
	      balance = context.getBalance() - Math.ceil(amount*0.05);
	      balance = balance + amount;
	      context.updateBalance(balance);
          if(balance >= BankContext.TAX_STATE_LIMIT){
	    	  changeState();
	      }
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



