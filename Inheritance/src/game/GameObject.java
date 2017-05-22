package game;

public abstract class GameObject {
	
	public abstract void draw ();
	
	public static void main(String[] args) {
		GameObject player = new Player();
		
		player.draw();
		
		GameObject menu = new Menu();
		menu.draw();
		
		GameObject[] gameObject = new GameObject[2];
		gameObject[0] =player;
		gameObject[1] =menu;
		
		for(GameObject obj: gameObject){
			obj.draw();
			
		}
		
		//GameObject myObject = new GameObject();
		//Abstract classes are used to be extended and they can not be instantaited
	}
}
