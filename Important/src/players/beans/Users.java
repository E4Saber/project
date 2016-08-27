package players.beans;

/**
 * 
 * @author Administrator
 * �û�����ڵ�bean
 */
public class Users {

	public String id;
	public String name;
	public String password;
	public String details;
	//0 ��   1  Ů
	public String gender;
	public String role;
	//0 ����  1����
	public String department;
	//0 ����Ա  1��ʦ  2 ҳ�����Ա
	
	public Users() {
		
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", password=" + password
				+ ", details=" + details + ", gender=" + gender + ", role="
				+ role + ", department=" + department + "]";
	}

	
	
	
}
