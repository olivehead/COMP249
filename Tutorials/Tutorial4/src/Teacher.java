
public class Teacher extends Person {
	private int numCourses = 0;
	private String[] courses;

	public Teacher(String name, String address) {
		super(name, address);
	}

	public String toString() {
		return "Teacher: " + super.toString();
	}

	public boolean addCourse(String course) {

		for (int i = 0; i < courses.length; i++) {
			if (courses[i] == course)
				return false;
		}
		return true;
	}
}
