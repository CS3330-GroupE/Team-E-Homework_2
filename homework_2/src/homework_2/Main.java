package homework_2;


public class Main {
	public static void main(String[] args) {
		
		// Instantiate StudentManager, perform operations based on the requirements.
		StudentManager studentManager = new StudentManager();
		
		// Read student data from a file and initialize Student objects.
		boolean fileReadStatus = studentManager.readFromFile("homework_2/files/studentData.txt");
				if(fileReadStatus == true) {
					System.out.println("Reading the file and initializing Student objects successful. ");
				}
		// Display all students.
		studentManager.displayStudents();
		
		// Search for a student by ID.
		boolean studentFound = studentManager.searchStudentById(101);
		
		
		// Update the grade of a student by ID.
		boolean studentGradeUpdateStatus = studentManager.updateStudentGradeById(102, 95);

		// Display all students after the update.
		studentManager.displayStudents(); 
		}
}
