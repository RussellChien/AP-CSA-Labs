public class Bank{
	private String name;
	private double balance;
	private int pin;
	private boolean access;
	public Bank(String n, double b, int p){
		name = n;
		balance = b;
		pin = p;
		access = false;

	}
	public String getName(){
		if (access == true){
			return name;
		}
		else {
			return "no access";
		}
	}

	public double getBalance(){
		if( access == true){
		return balance;
		}
		else{
			return 0.0;
		}
	}

	public void disableAccess(){
		access = false;
	}

	public boolean getAccess(){
		return access;
	}

	public void checkPin(int input){

		if (input == pin){
			access = true;
		}
		else {
			access = false;
		}
	}

	public void withdraw(double input){
	if (balance - input < 0){

	}
	else {
		balance = balance - input;
	}
		getBalance();
	}

	public void deposit(double input){
		balance = balance + input;
		getBalance();
	}

	public void updateName(String input){
		name = input;
		getName();
	}

}
