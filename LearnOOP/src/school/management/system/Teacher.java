package school.management.system;

/**
 * 
 * @author Voiceless Words
 * This class is responsible for keeping teachers name, id and salary
 */
public class Teacher {
	
	private int id;
	private String name;
	private int salary;
	private int salaryEarned;
	
	/**
	 * creates a new teacher object
	 * @param id id of the teacher
	 * @param name name of the teacher
	 * @param salary salary of the teacher
	 */
	public Teacher(int id, String name, int salary)
	{
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.salaryEarned = 0;
	}

	/**
	 * returns the id of the teacher
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * gets the name of the Teacher
	 * @return
	 */
	public String getName() {
		return name;
	}

	 /**
	  * return the salary of the teacher
	  * @return
	  */
	public int getSalary() {
		return salary;
	}

	/**
	 * set the salary of the teacher
	 * @param salary
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	/**
	 * adds to salary
	 * removes from the total money 
	 * @param salary
	 */
	public void receiveSalary(int salary)
	{
		salaryEarned += salary;
		School.updateTotalMoneySpent(salary);
	}
	
	@Override
	public String toString()
	{
		return "Name of the teacher: " + name + "Total Salary " + salaryEarned;
	}
	

}
