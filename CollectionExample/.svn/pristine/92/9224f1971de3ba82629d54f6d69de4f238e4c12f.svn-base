package com.fdmgroup;

public class Student implements Comparable<Student>{
	private int id;
	private String nbaem;
	private int age;
	private int grade;
	
	public Student() {


		
	}
	
	







	public Student(int id, String nbaem, int age, int grade) {
		this.id = id;
		this.nbaem = nbaem;
		this.age = age;
		this.grade = grade;
	}






	public int getId() {
		return id;
	}	



	public void setId(int id) {
		this.id = id;
	}

	public String getNbaem() {
		return nbaem;
	}

	public void setNbaem(String nbaem) {
		this.nbaem = nbaem;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", nbaem=" + nbaem + ", age=" + age
				+ ", grade=" + grade + ", getId()=" + getId() + ", getNbaem()="
				+ getNbaem() + ", getAge()=" + getAge() + ", getGrade()="
				+ getGrade() + "]";
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		/*result = prime * result + age;
		result = prime * result + grade;
		result = prime * result + id;*/
		result = prime * result + ((nbaem == null) ? 0 : nbaem.toLowerCase().hashCode());//.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (grade != other.grade)
			return false;
		if (id != other.id)
			return false;
		if (nbaem == null) {
			if (other.nbaem != null)
				return false;
		} else if (!nbaem.equalsIgnoreCase(other.nbaem))
			return false;
		return true;
	}
	
	









//	@Override
//	public int compareTo(Student o) {
//		//Ascending Sort
///*		return this.age - o.age;*/
//		//Descending
//		return o.age - this.age;
//		
//	}

	@Override
	public int compareTo(Student o) {
		//Ascending Sort
/*		return this.age - o.age;*/
		//Descending
		return o.nbaem.compareTo( this.nbaem);
		
	}

}
