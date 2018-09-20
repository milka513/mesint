import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class StateGraphBFS extends StateGraph {

	public StateGraphBFS(State state) {
		super(state);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		setNull();
		Queue<State> Q=new LinkedList<State>();
		Q.add(startState);
		isSuccessful=false;
		while (!Q.isEmpty()) {
			
			State u=Q.remove();
			Set<State> neighbours=u.getNextStepForBFS();
			for(State st: neighbours) {
				if (!allStates.contains(st)) {
					st.setFather(u);
					allStates.add(st);
					Q.add(st);
					lastState=st;
					if (st.isDestinity()) {
						isSuccessful=true;
						return;
					}
				}
			}
		}
		
	}
	

}
