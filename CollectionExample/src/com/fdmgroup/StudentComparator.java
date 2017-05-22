package com.fdmgroup;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getGrade() - o2.getGrade();
	}
	
	public static Comparator<Student> sortStudentByGradeDesc = new Comparator<Student>(){
		@Override
		public int compare(Student s1, Student s2) {
			return s2.getGrade() - s1.getGrade();
		}
	};
	
	public static Comparator<Student> sortStudentByAgeAsc = new Comparator<Student>(){
		
	
		@Override
		public int compare(Student s1, Student s2) {
			return s2.getAge() - s1.getAge();
		}
	};
		
}


