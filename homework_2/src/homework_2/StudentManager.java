package homework_2;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class StudentManager{
	
	public StudentManager() {
		
	}

//empty array for Student objects with a default value of 5 spaces
	Student[] students = new Student[6];

	
//reads text from student data file and creates objects and stores them in students array
	public boolean readFromFile(String filePath) {
		try {
			//checks if the file exists
			File file = new File(filePath);
			
			//creates a counter
			int counter = 0;
			
			//checks if file exists
			//(Hatfield reference): file.exists from https://stackoverflow.com/questions/1816673/how-do-i-check-if-a-file-exists-in-java
			if (file.exists()) {
				
				//Starts to read file
				Scanner fileIn = new Scanner(new FileInputStream(filePath));
				
				//Reads file as long as there are lines and lines do not exceed number of students
				while (fileIn.hasNext() && counter < 6) {
					int studentID = fileIn.nextInt();
					String studentName = fileIn.next() + " " + fileIn.next();
					double studentGrade = fileIn.nextDouble();
					students[counter++] = new Student(studentID,studentName,studentGrade);
				}
			}
		}	
		//file handling
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
//create getter for student array
	public Student[] getStudents() {
		return students;
	}

//displays students
	public void displayStudents() {
		//Student[] students = getStudents();
		//System.out.println(students);
		
		//checks if array starts with a null and displays message if empty
		if(students[0] == null) {
			System.out.println ("Error: The array is empty.");
		}
		
		//for each loop to check all array elements and skips null entries
		for (Student studentElements : students) {
			if(studentElements == null) {
				continue;
			}
			
		System.out.println(studentElements);
		
		}
		
	}
	

//searches students by id
	//method signature
	public boolean searchStudentById(int id){
		//for loop iterating through students array
		for (Student searchStudent : students) {
			//throws false if input value doesn't exist in array
			if (searchStudent == null) {
				System.out.println("\n" + "Student not found");
				return false;
			}
			//(Bluhm reference) https://stackoverflow.com/questions/3661413/how-to-cast-an-object-to-an-int
			//casts searchStudent .getId output to int, compares output to input
			else if (Integer.valueOf(searchStudent.getId()).equals(id)) {
				System.out.println("\n" + searchStudent.toString());
				return true;
			}
			//iterates through rest of array if not found (I'll test this more after class and remove this if its unnecessary)
			else {
				continue;
			}
		}
	return false;
	}
	
	
	//searches by ID and updates student grade
	//returns true if student was found and updated successfully
	//returns false if student ID was not found
	public boolean updateStudentGradeById(int id, double grade) {
		//checking if student id exists
		System.out.println("\nSearching for Student ID " + id + ":");
		if(searchStudentById(id) == false) {
			//student id not found returns false
			return false;
		}
		System.out.println("Student ID " + id + " found! Changing grade to " + grade + ":\n");
		
		//iterating through array of students to find id
		for (int i = 0; i < students.length; i++) {
			
			//if any element in the array is null, skip it
			if(students[i] == null) {
				continue;
			}
			
			//if student id's match, set grade and return true
			if(students[i].getId() == id) {
				students[i].setGrade(grade);
				return true;
			}
		}
		
		//error catch
		return false;
	}
}


