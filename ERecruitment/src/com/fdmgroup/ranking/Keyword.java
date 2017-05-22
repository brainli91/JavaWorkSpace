package com.fdmgroup.ranking;

public class Keyword implements Comparable<Keyword> {
	
	private String name;
	private double weight;
	
	public Keyword() {
		super();
	}
	
	public Keyword(String name) {
		super();
		this.name = name;
	}

	public Keyword(String name, double weight) {
		super();
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Keyword [name=" + name + ", weight=" + weight + "]";
	}

	@Override
	public int compareTo(Keyword o) {
		return (int) ((weight * 100) - (o.getWeight() * 100));
	}
}
