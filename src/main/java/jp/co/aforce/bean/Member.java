package jp.co.aforce.bean;

public class Member {
	private String name;
	private String gender;
	private String phone;
	private String email;
	private String password;
	
	public String getName(){
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		if (gender.length() != 1) {
		    throw new IllegalArgumentException("Gender must be a single character.");
		}
        
		this.gender=gender ;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		 if (phone.length() > 11) {
		        throw new IllegalArgumentException("Phone number must be 11 digits or less.");
		    }
		this.phone=phone ;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email ;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password ;
	}

	

}
