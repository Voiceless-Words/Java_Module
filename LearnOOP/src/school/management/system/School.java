package school.management.system;

import java.util.List;

/**
 * Many teachers, many students
 * Implements teachers and student using ArrayLists
 * @author Voiceless Words
 *
 */
public class School {
	
	private List<Teacher> teachers;
	private List<Student> students;
	private static int totalMoneyEarned;
	private static int totalMoneySpent;
	
	/**
	 * new school object created
	 * @param teacher list of teachers in the school
	 * @param student list of the students in the school
	 */
	public School(List<Teacher> teacher, List<Student> student) {
		this.teachers = teacher;
		this.students = student;
		this.totalMoneyEarned = 0;
		this.totalMoneySpent = 0;
	}

	/**
	 * 
	 * @return list of teaches
	 */
	public List<Teacher> getTeacher() {
		return teachers;
	}

	/**
	 * adds a new teacher to the school
	 * @param teacher the teacher to be added
	 */
	public void addTeacher(Teacher teacher) {
		teachers.add(teacher);
	}

	/**
	 * 
	 * @return returns the student
	 */
	public List<Student> getStudent() {
		return students;
	}

	/**
	 * 
	 * @param student adds a new student to the students list
	 */
	public void addStudent(Student student) {
		students.add(student);
	}

	/**
	 * 
	 * @return returns total money earned
	 */
	public int getTotalMoneyEarned() {
		return totalMoneyEarned;
	}

	/**
	 * 
	 * @param totalMoneyEarned
	 */
	public static void updateTotalMoneyEarned(int fees) {
		totalMoneyEarned += fees;
	}

	/**
	 * 
	 * @return the total money Spent by the school
	 */
	public int getTotalMoneySpent() {
		return totalMoneySpent;
	}

	/**
	 * update the money that is spent by the school which is the salary of the teachers
	 * @param totalMoneySpent
	 */
	public static void updateTotalMoneySpent(int totalMoneySpent) {
		totalMoneyEarned -= totalMoneySpent;
	}
	
	

}
