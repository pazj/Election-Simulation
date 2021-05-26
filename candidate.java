package assigment2;

public class candidate extends student{
	
	private int numberOfVotes = 0;

	public candidate(String name, int number, int grade, Department dept, boolean candid) {
		super(name, number, grade, dept, candid);
		
	}

	public int getVotes() {
		return numberOfVotes;
	}
	
	@Override
	public int compareTo(Object temp) {
		if(this.numberOfVotes == ((candidate)temp).numberOfVotes)
			return 0;
		else if(this.numberOfVotes > ((candidate)temp).numberOfVotes)
			return 1;
		else return -1;
		
			
	}
	public void increaseVote() {
		numberOfVotes++;
	}
	

}
