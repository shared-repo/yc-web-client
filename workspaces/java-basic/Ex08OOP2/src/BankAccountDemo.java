
class BankAccount {
	int accountNo;
	String owner;
	double balance;
	
	void deposit() {
		System.out.println("예금");
	}
	void withdraw() {
		System.out.println("인출");
	}
}

class GeneralAccount extends BankAccount {
	double interestRate;
	double depositAmount;
}
class SavingsAccount extends BankAccount { // 적금
	boolean salaryAccount;
}
class MinusAccount extends BankAccount {
	double interestRate;
	double limit;
}


public class BankAccountDemo {

	public static void main(String[] args) {

	}

}














