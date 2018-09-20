import java.util.Set;
import java.util.TreeSet;

public class State implements Comparable{

	private int x,y;
	private static int A, B, D;
	private State father;
	private int allCost;
	//private Set<State> currentStates;
	
	public int getAllCost() {
		return allCost;
	}
	
	public void inicializeCost() {
		allCost=0;
	}
	
	public void setAllCost(int i) {
		allCost=i;
	}
	
	public int getF() {
		return allCost+getHeuristics();
	}
	
	public int getHeuristics() {
		return Math.abs(x-D);
	}
	
	public static void setBoundaries(int A2, int B2, int D2) {
		A=A2;
		B=B2;
		D=D2;
	}
	
	public State(State copy) {
		x=copy.x;
		y=copy.y;
		father=copy.father;
		allCost=copy.allCost;
		
	}
	
	public State(int x, int y) {
		this.x=x;
		this.y=y;
		allCost=0;
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		State s=(State) arg0;
		Integer i=x;
		Integer j=y;
		if (i.compareTo(s.x)==0) return j.compareTo(s.y);
		return i.compareTo(s.x);
	}
	
	public Set<State> getNextStepForBFS() {
		Set<State> out=new TreeSet<State>();
		//get empty
		out.add(new State(x,0));
		out.add(new State(0,y));
		out.add(new State(A,y));
		out.add(new State(x,B));
		if (x<=B-y) out.add(new State(0,x+y));
		else out.add(new State(x-B+y,B));
		if (y<=A-x) out.add(new State(x+y,0));
		else out.add(new State(A,y-A+x));
		return out;
		
	}
	
	public int getValue() {
		return Math.abs(x-D);
	}
	
	public boolean isDestinity() {
		return x==D;
	}

	public State getFather() {
		return father;
	}

	public void setFather(State father) {
		this.father = father;
	}
	
	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
	
	public int getDistance(State st) {
		return Math.abs(st.x-x)+Math.abs(st.y-y);
	}
	
	@Override
	public boolean equals(Object state) {
		State st=(State) state;
		return (st.x==x && st.y==y);
	}
}
