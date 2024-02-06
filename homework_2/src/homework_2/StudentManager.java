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

	
//reads text from studentdata file and creates objects and stores them in students array
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
}

