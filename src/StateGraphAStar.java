import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class StateGraphAStar extends StateGraph {

	
	private List<State> openList;
	
	public StateGraphAStar(State state) {
		super(state);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		setNull();
		openList=new LinkedList<State>();
		openList.add(startState);
		isSuccessful=false;
		
		while (!openList.isEmpty()) {
			State q=openList.remove(getMinIndexFromOpenList());
			Set<State> getNeighbours=q.getNextStepForBFS();
			
			
			for(State st:getNeighbours) {
				st.setFather(q);
				
				if (st.isDestinity()) {
					isSuccessful=true;
					lastState=st;
					return;
				}
				
				st.setAllCost(q.getAllCost()+q.getDistance(st));
				
				State fromOpenList=getFromOpenList(st);
				if (allStates.contains(st)) continue;
				if (fromOpenList!=null) {
					if (st.getF()>=fromOpenList.getF()) continue;
					State st2=new State(fromOpenList);
					openList.remove(fromOpenList);
					openList.add(st2);
				} else {
					openList.add(st);
				}
				
				
			}
			
			allStates.add(q);
		}
		
	}
	
	
	private int getMinIndexFromOpenList() {
		int min=openList.get(0).getF();
		int out=0;
		for(int i=1;i<openList.size();++i) {
			if (openList.get(i).getF()<min) {
				min=openList.get(i).getF();
				out=i;
			}
		}
		return out;
	}
	
	
	private State getFromOpenList(State in) {
		for(State st: openList) {
			if (in.equals(st)) {
				return st;
			}
		}
		return null;
	}
	

}
