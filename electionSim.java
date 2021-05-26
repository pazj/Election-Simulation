package assigment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class electionSim{
	ArrayList<Department> dep = new ArrayList<Department>();
	ArrayList<candidate> can = new ArrayList<candidate>();
	
	public electionSim(String department,String student, String output) {
			Scanner inputStream = null;
			PrintWriter out = null;
			try {
				out = new PrintWriter(new FileOutputStream(output));
					out.close();
					inputStream = new Scanner (new FileInputStream(department));
					
					String line = inputStream.nextLine();
					while(inputStream.hasNextLine()) {
						
						String depar = inputStream.nextLine();
						String depTrue = depar.substring(dep.indexOf(",") + 1,depar.length());
						Department dept = new Department(depTrue);
							dep.add(dept);
					}
					
					inputStream = new Scanner (new FileInputStream(student));
					
					String line2 = inputStream.nextLine();
					while(inputStream.hasNextLine()) {
						String data = inputStream.nextLine();
						StringTokenizer st = new StringTokenizer(data);
						while(st.hasMoreTokens()) {
							String number, dept, name, candid;
							number = st.nextToken(",");
							dept = st.nextToken(",");
							name = st.nextToken(",");
							candid = st.nextToken();
							
							int numberTrue = Integer.parseInt(number);
							int deptTrue = Integer.parseInt(dept);
							boolean candidTrue = Boolean.parseBoolean(candid);
							student stu = new student (name,numberTrue,deptTrue,dep.get(deptTrue-1), candidTrue);
							Department ment = dep.get(deptTrue-1);
							ment.st.add(stu);
							if(candidTrue) {
								candidate c = new candidate(name, numberTrue, deptTrue, dep.get(deptTrue-1), candidTrue);
								can.add(c);
								ment.cand.add(c);
								
							}
							
							
						}
					}
					
			} catch(FileNotFoundException e) {
				System.out.println("File" + department + "could not be opened");
				System.exit(0);
			}
	}
	public void runSimulation() {
		ArrayList<candidate> election = new ArrayList<candidate>();
		//voting
		for(Department d : dep) {
 			Iterator itr = d.st.iterator();
			while(itr.hasNext()) {
				student d2 = (student) itr.next();
				d2.vote();
				
			}
		}
		//to elect our candidate
		for(Department d : dep) {
			candidate elected = d.cand.get(d.cand.size() -1);
			election.add(elected);
			Collections.sort(d.cand);
			
		}
		
		saveData(election);
		
	}
	public void saveData(ArrayList<candidate> ca) {
		PrintWriter out = null;
		try {
			out = new PrintWriter("output_file");
		}
		catch(FileNotFoundException e) {
			System.out.println("file to make it");
		}
		for(candidate c: ca) {
			String grade = c.getDepar().getdepartmentName();
			String studentName = c.studentName();
			int number = c.getnumber();
			int vote = c.getVotes();
			
			out.println("======== Elected Candidate ========");
			out.println("Department name: "+ grade);
			out.println("name : " + studentName);
			out.println("Student_id : " + number);
			out.println("Votes: " + vote);
			out.println("====================================");
			
		}
		out.close();
	}
	
}