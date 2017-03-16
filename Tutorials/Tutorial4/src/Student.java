
public class Student extends Person {
	private int numCourses = 0;
	private String[] courses;
	private int[] grades;

	public Student(String name, String address) {
		super(name, address);
	}

	public String toString() {
		return "Student: " + super.toString();
	}
	
	public void addCourseGrade(String course, int grade) {
		numCourses++;
		String[] courses = new String[numCourses];
		int[] grades = new int[numCourses];
		courses[numCourses -1] = course;
		grades[numCourses -1] = grade;
		
	}
}
