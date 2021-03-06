
/*==========================================================*/
/* This is the Context class in the State pattern. This  class together
/* with the state class hierarchy are so organized that the BankContext
/* uses the state class hierarchy but the state class hierarchy will not call
/* the Context class BankContext
/*==========================================================*/
public class BankContext {

  private State objState;
  private String accountNumber;
  private double balance;
  public static final double MIN_BALANCE = 2000.00;
  public static final double OVERDRAW_LIMIT = -1000.00;
  public static final double TRANS_FEE_NORMAL = 2.00;
  public static final double TRANS_FEE_OVERDRAW = 5.00;
  public static final double TAX_STATE_LIMIT = 100000;
  public static final String ERR_OVER_LIMIT = "Overdraw limit exceeded.";

  public BankContext(State st, String accountNum){
      objState = st;
  }
  public String getState()  {
    return objState.getState();
  }
  public void setStateObj(State objState)  {
       this.objState = objState;
  }
  // use a concrete state class to do deposit
  public void deposit(double amount)  {
	objState.setContext(this);
    objState.deposit(amount);
  }
  // use a concrete state class to do withdraw
  public void withdraw(double amount)  {
	objState.setContext(this);
    objState.withdraw(amount);
  }
  public double getBalance()  {
	  return balance;
  }
  public void updateBalance(double balance)  {
  	  this.balance = balance;
  }
  public boolean isOverDrawnLimitHit(){
	  return objState.isOverDrawnLimitReached();
  }
}
