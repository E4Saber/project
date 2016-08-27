package players.beans;


/**
 * player bean
 */
public class Player {

	private String name;
	private String password;
	private String tt;
	public Player(){
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	

	public String getTt() {
		return tt;
	}

	public void setTt(String tt) {
		this.tt = tt;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", password=" + password + ", tt=" + tt
				+ "]";
	}
	
	
}
