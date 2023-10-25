
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class forCustomer {

	private String name, dateofBirth, socialSecurityNum, address;
	private int age;
	private List<Account> accounts;
	
	public forCustomer(String name, String dateofBirth, String socialSecurityNum, String address, int age,
			List<Account> accounts) {
		this.name = name;
		this.dateofBirth = dateofBirth;
		this.socialSecurityNum = socialSecurityNum;
		this.address = address;
		this.age = age;
		this.accounts = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(String dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	public String getSocialSecurityNum() {
		return socialSecurityNum;
	}

	public void setSocialSecurityNum(String socialSecurityNum) {
		this.socialSecurityNum = socialSecurityNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public void openAccount(Account account) {
		accounts.add(account);
		
	}
	public void closeAccount(Account account) {
		accounts.remove(account);
	}
	
//	public boolean checkEligibility(Account account) {
//		
//	}
	
	class Account {
		private String accountNum, accountType;
		private double balance; 
		private List<Transaction> transactions;
		
		public Account(String accountNum, String accountType, double balance, List<Transaction> transactions) {
			this.accountNum = accountNum;
			this.accountType = accountType;
			this.balance = balance;
			this.transactions = transactions;
		}

		public String getAccountNum() {
			return accountNum;
		}

		public void setAccountNum(String accountNum) {
			this.accountNum = accountNum;
		}

		public String getAccountType() {
			return accountType;
		}

		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}

		public List<Transaction> getTransactions() {
			return transactions;
		}

		public void setTransactions(List<Transaction> transactions) {
			this.transactions = transactions;
		}
		public void depositing(double amount) {
			if (amount <=0.0) {
				System.out.println("This amount cannot be deposited into your account. Try again.");
			}
			else {
				balance += amount;
			}
		}
		public void withdraw(double amount) {
			if (amount <= 0.0) {
				System.out.println("This amount cannot be deposited into your account. Try again.");
				
			}
		}
		
		
	}
}
