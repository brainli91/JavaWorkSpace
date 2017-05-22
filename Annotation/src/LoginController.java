
@Controller(path = "/loginController")

public class LoginController {
	@Size(min=5, max = 40)
	private String username;
	
	@Size(min=4, max = 8)
	private String password;
	
	public LoginController(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
	
	@Runner
	public boolean login(){
		if (username.equals("albert") && password.equals(1234)){
			return true;
		}
		else{
			
			return false;
		}
	}
		
}
