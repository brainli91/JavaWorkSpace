package overriding;
//Subclass is inheriting all the variables and methods defined in the Base 
public class Subclass extends Base{
	public static void main(String[] args) {
		Subclass s = new Subclass();
		
	}
	
	public Subclass() {
		sayHello();// We are calling the sayHello method defined in in Base
		
	}
	
	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		super.sayHello();
		System.out.println("Hi");
	}


}
