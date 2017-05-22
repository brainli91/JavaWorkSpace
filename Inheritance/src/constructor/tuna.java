package constructor;

public class tuna {
	private String girlName;

	
	public tuna(String girlName) {
		super();
		this.girlName = girlName;
	}

	public String getGirlName() {
		return girlName;
	}

	public void setGirlName(String girlName) {
		this.girlName = girlName;
	}
	
	public void saying(){
		System.out.printf("Your first df was %s\n", getGirlName());
	}
	
	

}
