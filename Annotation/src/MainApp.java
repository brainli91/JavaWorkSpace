import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class MainApp {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		
		LoginController lc = new LoginController("albert", "1234");
		Class<LoginController> object = (Class<LoginController>) lc.getClass();
		
		if (object.isAnnotationPresent(Controller.class)){
			
			Method[] methods = object.getDeclaredMethods();
			for (Method method : methods){
				if (method.isAnnotationPresent(Runner.class)){
					//method.setAccessible(true);
					boolean result = (Boolean) method.invoke(lc);
					
					if (result){
						System.out.println("Login successful.");
						
					}
					else{
						System.out.println("Error: Login not successful.");						
					}
					
					
				}
			}
			
			Field[] fields = object.getDeclaredFields();
			for (Field field : fields) {
				if (field.isAnnotationPresent(Size.class)){
					Size size = field.getAnnotation(Size.class);
					field.setAccessible(true);
					String val = (String) field.get(lc);
					if (val.length() >= size.min() && val.length() <= size.max()){
						System.out.println(field.getName() + ": Correct number of characters");
						
					}
					else{
						System.out.println(field.getName() + ": Incorrect number of characters");
					}
				}
			}
			
		}
	}

}