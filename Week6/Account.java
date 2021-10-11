import java.util.ArrayList;

public class Account {

	long id;
	String accountType;
	
	public static ArrayList<Account> createAccounts(int numAccounts)
	{	
		ArrayList<Account> acc = new ArrayList<Account>(numAccounts);
		for (int i = 0; i < numAccounts; i++) {
			if(i % 2 == 0) 
			{
			acc.add(new Account(i,"Saving"));
			}else {
				acc.add(new Account(i,"Checkings"));
				  }
		}
		return acc;

		}
//------------------------------------------------------------
	public Account(long id, String accountType) {
		super();
		this.id = id;
		this.accountType = accountType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountType=" + accountType + "]";
	};
	
	
}
