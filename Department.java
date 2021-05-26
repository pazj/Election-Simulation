package assigment2;
import java.util.ArrayList;

public class Department {
	
		
		private String departmentName;
		ArrayList <candidate> cand = new ArrayList <candidate>();
		ArrayList <student> st = new ArrayList<student>();
		
		
		public Department(String dept) {
			departmentName = dept;
		}

		public String getdepartmentName() {
			return departmentName;
		}
		
		public candidate mostVote() {
			int i;
			candidate max = cand.get(0);
			for(i=1; i<cand.size(); i++) {
				candidate compare = cand.get(i);
				
				if(compare.getVotes() > max.getVotes()) {
					max = compare;
				}
			}
			return max;
		}	
		
		
	}


