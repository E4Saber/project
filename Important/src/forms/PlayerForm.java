package forms;


/**
 * 
 * @author Administrator
 * 对应页面出来的表单数据 
 */
public class PlayerForm {

	private String name;
	private String password;
	
	public PlayerForm(){
		
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

	@Override
	public String toString() {
		return "PlayerForm [name=" + name + ", password=" + password + "]";
	}
	
	
}
