package entities;

// Palavra "final" evita que a classe seja herdada (ex.: public final class SavingsAccount
public class SavingsAccount extends Account{
	
	private Double interestRate;

	public SavingsAccount() {
		super();
	}

	public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
		super(number, holder, balance);
		this.interestRate = interestRate;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	
	public void updateBalance() {
		balance += balance * interestRate;
	}
	
	@Override // Palava "final" evita que o método seja sobreposto na classe herdeira
	public final void withdraw(double amount) {
		balance -= amount;
	}
}
