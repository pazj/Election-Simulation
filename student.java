package assigment2;

public class student implements voter {
	
   private String studentName;
   private int studentNumber;
   private int studentGrade;
   Department department;
   private boolean candid;
   
   public student(String name, int number, int grade, Department dept, boolean candid ) {
	   
	   studentNumber = number;
	   studentGrade = grade;
	   department = dept;
	   this.studentName = name;
	   this.candid = candid;
   }
	
	public int getnumber() {
		return studentNumber;
	}
	public boolean getcandid() {
		return candid;
	}

	
	@Override
	public void vote() {
		int index =(int)(Math.random()*((department.cand.size()))) + 0;
		candidate moreVote = department.cand.get(index);
		moreVote.increaseVote();
		
	}
	
	public int getStudentGrade() {
		return studentGrade;
	}
	public Department getDepar() {
		return department;
	}
	
	public String studentName() {
		return studentName;
	}


	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

