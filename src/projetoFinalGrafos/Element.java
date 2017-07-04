package projetoFinalGrafos;

import java.util.List;

public class Element {
	public Integer id;
	private List<Double> atributos;
	
	public Element(Integer id, List<Double> atributos){
		this.id = id;
		this.atributos = atributos;
	}
	
	public Double GetAtributos(Integer number){
		return atributos.get(number);
	}
	
	public Integer GetNumberAtributos(){
		return atributos.size();
	}
}
