package workshopW1;

import java.util.Arrays;

public class Student extends Person{
	
	private String[] courses;
	private int numCourses;
	private int[] grades;
	
	public Student(String name, String adress) {
		super(name, adress);
	}
	
	public String toString() {
		return super.toString() + " Courses: " + Arrays.toString(this.courses) + "No. of Courses: " + this.numCourses + " Grades: " + Arrays.toString(grades);
	}
	
	public boolean addCourseGrade(String course, int grade) {
		int c = 0;int d = 0;int e = 0;
		for (String str : this.courses) {
			if (str.equals(null)) {
				courses[d] = course;
				c++;
				break;
			}
			d++;
		}
		for (int val : this.grades) {
			if (val == 0) {
				grades[e] = grade;
				c++;
				break;
			}
			e++;
		}
		return c == 2;
	}
	
	public void printGrades() {
		System.out.println("Grades: " + Arrays.toString(grades));
	}
	
	public double getAverageGrade() {
		int sum = 0;
		for (int val : this.grades) {
			sum += val;
		}
		return sum / grades.length;
	}
}
