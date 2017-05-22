package com.fdmgroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainApp {
	public static void main(String[] args) {
		Student s1 = new Student(1,"David",54,79);
		Student s2 = new Student(2,"david",18,50);
		Student s3 = new Student(3,"Henry",25,90);
		Student s4 = new Student(4,"George",7,100);
		
		List<Student> students= new ArrayList<Student>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
				
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());

		String st1 =new String ("David");
		String st2 =new String ("DAVID");
		System.out.println(st1.hashCode());
		System.out.println(st2.hashCode());
		
		if (s1.compareTo(s2) ==0)
			System.out.println("Equals age");
	

	System.out.println("------------------------------------");
	
	
	Collections.sort(students, StudentComparator.sortStudentByAgeAsc);

	
	for (Student student:students){
		System.out.println(student);
	}
	
	int[] array ={ 14,0,-5,47,-3,17,8};
	Arrays.sort(array);
	System.out.println(Arrays.toString(array));
	}
	
}
