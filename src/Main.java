
public class Main {

	static StateGraph sg;
	public static void main(String[] str) {
		State.setBoundaries(99, 97, 98);
		sg=new StateGraphAStar(new State(0,0));
		sg.run();
		sg.printRoute();
	}
}
