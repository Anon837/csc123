package ForFinal;
import java.util.Scanner; 
import java.util.ArrayList;

class Customer {
	String firstName, lastName, ssn, dateofBirth;
	int age;

	Customer(String firstName, String lastName, String ssn, String dateofBirth, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.dateofBirth = dateofBirth;
		this.age = age;
	}
}
class Account {
	static int accountNumCounter = 1000;
	
	int accountNum; 
	Customer customer; 
	double balance;
	String accountType;
	boolean isOpen;
	
	Account(Customer customer, String accountType) {
		this.accountNum = ++accountNumCounter;
		this.customer = customer;
		this.accountType = accountType;
		this.isOpen = true;
	}

	public void deposit(double amount) {
		if (isOpen) {
			balance += amount;
			System.out.println("Your Deposit is successful, new balance is: " + balance);	
		}
		else {
			System.out.println("Your Deposit failed, the account is closed.");
		}
	}
	public void withdraw(double amount, double overDraftLimit) {
		if (isOpen && (balance - amount >= -overDraftLimit)) {
			balance -= amount;
			System.out.println("Your Withdrawal was successful, the new balance is: " + balance);
		}
		else {
			System.out.println("Your Withdrawal failed");
		}
	}
	public void closeAccount() {
		if (isOpen) {
			isOpen = false;
			System.out.println("Your Account is closed, current balance is: " + balance);
		}
		else {
			System.out.println("This Account is not found");
		}
	}
	public void printStatement() {
		if (isOpen) {
			System.out.println("This is the Account Statement for inputed Account Number " + accountNum);
			System.out.println("Balance Statement: " + balance);
		}
		else {
			System.out.println("This Account is not Found.");
		}
	}
}
	class Bank {
		ArrayList<Account> accounts;
		
		Bank() {
			this.accounts = new ArrayList<>();
		}
		
		public void openCheckingAccount(Customer customer, double overDraftLimit) {
			if (customer.age >= 16) {
				Account checkingAccount = new Account(customer, "Checking");
				checkingAccount.deposit(0);
				accounts.add(checkingAccount);
				System.out.println("Your account number is: " + checkingAccount.accountNum);
			}
			else {
				System.out.println("Checking accounts can only be open by customers 16 and older.");
			}
		}
		public void openSavingAccount(Customer customer) {
			if (customer.age >= 5) {
				Account savingAccount = new Account(customer, "Saving");
				savingAccount.deposit(0);
				accounts.add(savingAccount);
				System.out.println("Thank you for opening an Account with us, your Account number is: " + savingAccount.accountNum);
			}
			else {
				System.out.println("Could not open Saving Account only opened by customers aged 5 and above.");
			}
		}
		public void listAccounts() {
			System.out.println("List of Accounts currently available: ");
			for (Account account : accounts) {
				System.out.println(account.accountNum + "(" + account.accountType + "): " + account.customer.firstName + " : " + account.customer.lastName + " : " + account.customer.ssn + " : " + account.balance + " : " + (account.isOpen ? "Account Open" : "Account Closed"));
			}
		}
		public static void main(String[] args) {
			Bank bank = new Bank();
			Scanner input = new Scanner(System.in);
			int choice;
			
			do {
				System.out.println("1 - Open a Checking Account");
				System.out.println("2 - Open a Savings Account");
				System.out.println("3 - List Accounts");
				System.out.println("4 - Account Statement");
				System.out.println("5 - Deposit funds");
				System.out.println("6 - Withdraw funds");
				System.out.println("7 - Close an Account ");
				System.out.println("8 - Exit");
				System.out.println("Please enter a number 1-8");
				
				choice = input.nextInt();
				input.nextLine();
				
				switch (choice) {
					case 1:
						System.out.println("Enter First Name: ");
						String firstName = input.nextLine(); 
						System.out.println("Enter Last Name: ");
						String lastName = input.nextLine();
						System.out.println("Enter Social Security Number: ");
						String ssn = input.nextLine();
						System.out.println("Enter Date of Birth: ");
						String dateofBirth = input.nextLine();
						System.out.println("Enter Your Age: ");
						int age  = input.nextInt();
						System.out.println("Enter overdraft limit: ");
						double overDraftLimit = input.nextDouble();
						bank.openCheckingAccount(new Customer(firstName, lastName, ssn, dateofBirth, age), overDraftLimit);
						input.nextLine();
						break;
						
					case 2:
						System.out.println("Enter First Name: ");
						String savingFirstName = input.nextLine(); 
						System.out.println("Enter Last Name: ");
						String savingLastName = input.nextLine();
						System.out.println("Enter Social Security Number: ");
						String savingSsn = input.nextLine();
						System.out.println("Enter Date of Birth: ");
						String savingDateofBirth = input.nextLine();
						System.out.println("Enter your age: ");
						int savingAge = input.nextInt();
						bank.openSavingAccount(new Customer(savingFirstName, savingLastName, savingSsn, savingDateofBirth, savingAge));
						input.nextLine();
						break;
						
					case 3:
						bank.listAccounts();
						break;
						
					case 4:
						System.out.println("Enter Your Account Number: ");
						int accountNum = input.nextInt();
						bank.accounts.stream()
								.filter(account -> account.accountNum == accountNum)
								.findFirst()
								.ifPresent(Account::printStatement);
						break;
						
					case 5:
						System.out.println("Enter Your Account Number: ");
						int depositAccountNum = input.nextInt();
						System.out.println("Enter the amount to deposit: ");
						double depositAmount = input.nextDouble();
						bank.accounts.stream()
								.filter(account -> account.accountNum == depositAccountNum)
								.findFirst()
								.ifPresent(account -> account.deposit(depositAmount));
						break;
						
					case 6:
						System.out.println("Enter Your Account Number: ");
						int withdrawAccountNum = input.nextInt();
						System.out.println("Enter the amount to Withdraw: ");
						double withdrawAmount = input.nextDouble();
						bank.accounts.stream()
								.filter(account -> account.accountNum == withdrawAccountNum)
								.findFirst()
								.ifPresent(account -> account.withdraw(withdrawAmount, 1000)); //1000 is overdraft
						break;
						
					case 7:
						System.out.println("Enter Account Number you want to Close: ");
						int closeAccountNum = input.nextInt();
						bank.accounts.removeIf(account -> account.accountNum == closeAccountNum);
						break;
						
					case 8: 
						System.out.println("Exit the Banking Menu.");
						break;
						
					default:
						System.out.println("Try Again. Please enter a Number between 1 through 8 ");
				
				}
			}
			while (choice != 8);
			
			input.close(); 
		}

		
			
	}
