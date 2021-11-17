package revature.project.banking.models;

public class CurrentUser {

	private static  int Cuser_id;

	public CurrentUser(int cuser_id) {
		super();
		Cuser_id = cuser_id;
	}

	public static int getCuser_id() {
		return Cuser_id;
	}

	public void setCuser_id(int cuser_id) {
		Cuser_id = cuser_id;
	}

	@Override
	public String toString() {
		return "CurrentUser [Cuser_id=" + Cuser_id + "]";
	}
	
}
