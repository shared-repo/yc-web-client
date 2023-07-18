
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

		// 계좌 10개 ( minus 3개, 입출금 4개, 적금 3개 )
		// minus, savings, general 클래스의 부모 클래스인 BankAccount 클래스의 배열을 만들면 
		// minus, savings, general 클래스의 인스턴스를 저장할 수 있습니다.
		BankAccount[] accounts = new BankAccount[10];
		
		for (int i = 0; i < 10; i++) {
			if (i % 3 == 0) {
				accounts[i] = new GeneralAccount();
			} else if (i % 3 == 1) {
				accounts[i] = new SavingsAccount();
			} else {
				accounts[i] = new MinusAccount();
			}
		}
	}

}














