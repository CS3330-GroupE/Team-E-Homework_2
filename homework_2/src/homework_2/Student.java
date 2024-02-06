package homework_2;

//creates the Student class with attributes
public class Student {
	private int id;
	private String name;
	private double grade;

	//creates the default Student constructor
	public Student() {
		
	}
	
//creates the Student parameterized constructor	
	public Student(int id, String name, double grade) {
		this.id = id;
		this.name = name;
		this.grade = grade;
	}
	
//getter and setter methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	//Display student object information	
	public void displayStudent() {
		System.out.println (("Student Name"));
	}
	
	@Override
	public String toString() {
		return "Person [id = " + id + ", name = " + name + ", grade = " + grade + "]";
	}
	
}


