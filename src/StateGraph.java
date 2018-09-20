import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public abstract class StateGraph {

	protected Set<State> allStates;
	protected State startState;
	protected boolean isSuccessful;
	protected State lastState;
	
	protected void setNull() {
		for(State st: allStates) {
			st.setFather(null);
			st.inicializeCost();
		}
	}
	
	public StateGraph(State state) {
		allStates=new TreeSet<State>();
		startState=state;
		allStates.add(state);
		isSuccessful=false;
	}
	public boolean isContains(State s) {
		return allStates.contains(s);
	}
	
	public State getBestStateByValue(Set<State> s) {
		int m=100000000;
		State out=new State(0,0);
		for(State st: s) {
			 if (m>st.getValue()) {
				 out=st;
				 m=st.getValue();
			 }
		}
		
		return out;
		
	}
	public boolean isDestinityContains(Set<State> states) {
		for(State st: allStates) {
			if (st.isDestinity()) return true;
		}
		return false;
	}
	
	public void printRoute() {
		if (!isSuccessful) {
			System.out.println("Sorry! No route found.");
			return;
		}
		Stack<State> states=new Stack<State>();
		State st2=lastState;
		State st=new State(st2);
		states.push(st2);
		while (st.getFather()!=null) {
			State st3=new State(st.getFather());
			states.push(st3);
			st=st.getFather();
		}
		State k=states.pop();
		System.out.print(k);
		while(!states.isEmpty()) {
			State st3=states.pop();
			System.out.print("->"+st3);
		}
		System.out.println();
		
	}
	
	
	
	
	public abstract void run();
	
}
