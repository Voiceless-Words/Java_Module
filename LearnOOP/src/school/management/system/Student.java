package school.management.system;

/**
 * 
 * @author Voiceless Words
 * This class is responsible for keeping track of students fees, name , grade and fees
 *
 */

public class Student {
	
	private int id;
	private String name;
	private int grade;
	private int feesPaid;
	private int feesTotal;
	
	/**
	 * To create a new student by initializing
	 * @param id this is unique
	 * @param name name of the student
	 * @param grade grade of the student
	 * @param feesPaid the money the student paid
	 * @param feesTotal the total money for the whole course
	 */
	public Student(int id, String name, int grade)
	{
		this.feesPaid =0;
		this.feesTotal = 30000;
		this.id = id;
		this.name = name;
		this.grade = grade;
	}
	
	/**
	 * Used to update the student's grade
	 * @param grade new grade of the student
	 */
	public void setGrade(int grade)
	{
		this.grade = grade;		
	}
	
	/**
	 * Keep adding the fees to fees paid field
	 * Add the fees to the fees paid
	 * The school is going to receive a funds
	 * @param fees the amount that the student is paying this time
	 */
	public void payFees(int fees)
	{
		this.feesPaid += fees;
		School.updateTotalMoneyEarned(feesPaid);
	}

	/**
	 * gets the id of the student
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * gets the name of the student
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * gets the fees paid of the student
	 * @return
	 */
	public int getFeesPaid() {
		return feesPaid;
	}

	/**
	 * gets the fees total of the student
	 * @return
	 */
	public int getFeesTotal() {
		return feesTotal;
	}

	/**
	 * gets the grade of the student
	 * @return
	 */
	public int getGrade() {
		return grade;
	}
	
	public int getRemainingFees()
	{
		return (feesTotal - feesPaid);
	}
	
	@Override
	public String toString()
	{
		return "Student's name: "+name+"Total Fees Paid so far $"+feesPaid;
	}
}
