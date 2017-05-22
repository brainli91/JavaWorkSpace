package com.fdmgroup;

import java.util.HashMap;
import java.util.Map;

public class GenericClass<T, X> {

	private T t;
	private X x;
	
	Map<T, X> map = new HashMap<T, X>();
	
	
	
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	public X getX() {
		return x;
	}
	public void setX(X x) {
		this.x = x;
	}
	
	
	
	public Map<T, X> getMap() {
		return map;
	}
	public void setMap(Map<T, X> map) {
		this.map = map;
	}
	
	public boolean addNewElement(){
		if (map.containsKey(t)){
			return false;
		}
		else{
			map.put(t, x);
			return true;
		}
	}
	
	@Override
	public String toString() {
		return "GenericClass [t=" + t + ", x=" + x + ", map=" + map + "]";
	}
	
	
}
