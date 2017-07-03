package projetoFinalGrafos;

import java.util.List;

public class Element {
	public String name;
	private List<String> states;
	
	public Element(String n, List<String> s){
		name = n;
		states = s;
	}
	
	public String GetState(int number){
		return states.get(number);
	}
}
