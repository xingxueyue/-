package tzc.blog.bean;

import java.util.Date;

public class User {
     private int id;
     private String username;
     private String password;
     private Date createDAT;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateDAT() {
		return createDAT;
	}
	public void setCreateDAT(Date createDAT) {
		this.createDAT = createDAT;
	}
}
