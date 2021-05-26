package assigment2;

public class simTest {
		
		private static final String DEPARTMENT_INPUT = "input1.csv";
		private static final String STUDENT_INPUT = "input2.csv";
		private static final String OUTPUT_FILE = "output_file";
		
	
	
	public static void main(String[] args) {
	electionSim eSim = new electionSim(DEPARTMENT_INPUT,STUDENT_INPUT,OUTPUT_FILE);
		
	eSim.runSimulation();
	}
}


