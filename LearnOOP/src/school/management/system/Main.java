package school.management.system;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Voiceless Words
 *
 */
public class Main {
	public static void main(String[] args)
	{
		Teacher lizzy = new Teacher(1, "Lizzy", 500);
		Teacher mellisa = new Teacher(2, "Mellisa", 700);
		Teacher vanderhorn = new Teacher(3, "Vanderhorn", 600);
		
		List<Teacher> teacherList = new ArrayList<>();
		teacherList.add(lizzy);
		teacherList.add(mellisa);
		teacherList.add(vanderhorn);
		
		Student piet = new Student(1, "Piet", 4);
		Student thabiso = new Student(2, "Thabiso", 12);
		Student molatelo = new Student(3, "Molatelo", 5);
		
		List<Student> studentList = new ArrayList<>();
		studentList.add(piet);
		studentList.add(thabiso);
		studentList.add(molatelo);
		
		School school = new School(teacherList, studentList);
		
		Teacher megan = new Teacher(6, "Megan", 900);
		school.addTeacher(megan);
		thabiso.payFees(6000);
		piet.payFees(5000);
		System.out.println("School has earned " + school.getTotalMoneyEarned());
		
		System.out.println("Making the school pay salary");
		
		lizzy.receiveSalary(lizzy.getSalary());
		System.out.println("School has spent for salary to " + lizzy.getName() + " and now has " + school.getTotalMoneyEarned());
		vanderhorn.receiveSalary(vanderhorn.getSalary());
		System.out.println("School has spent for salary to " + vanderhorn.getName() + " and now has " + school.getTotalMoneyEarned());
		System.out.println(thabiso);
		System.out.println(lizzy);
	}

}
