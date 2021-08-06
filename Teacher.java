package workshopW1;

import java.util.Arrays;

public class Teacher extends Person {
	
	private String[] courses;
	private int numCourses;
	
	public Teacher(String name, String adress) {
		super(name, adress);
	}
	
	public String toString() {
		return super.toString() + " Courses: " + Arrays.toString(this.courses) + "No. of Courses: " + this.numCourses;
	}
	
	public boolean addCourse(String course) {
		boolean addSuccess = false;
		int c = 0;
		for (String str : this.courses) {
			if (str.equals(null)) {
				courses[c] = course;
				addSuccess = true;
				break;
			}
			c++;
		}
		return addSuccess;
	}
	
	
	public void removeCourse(String course) {
		int c = 0;
		for (String str : this.courses) {
			if (str.equals(course)) {
				courses[c] = null;
			}
			c++;
		}
	}
}
