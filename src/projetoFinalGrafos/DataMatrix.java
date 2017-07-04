package projetoFinalGrafos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataMatrix {
	private static final String FILENAME = "leaf.csv";
	private static final Double MIN = (double) 0;
	private static final Double MAX = (double) 1;
	public List<Element> matrix;
	
	public DataMatrix(){
		Integer id;
		List<Element> matrix;
		List<Double> atributos;
		Double temp;
		String rawData;
		Scanner read = null;
		Scanner readRawData = null;
		
		atributos = new ArrayList<Double>();
		matrix = new ArrayList<Element>();
		
		try {
			read = new Scanner(new File(FILENAME));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		while(read.hasNextLine()){
			rawData = read.nextLine();
			readRawData = new Scanner(rawData);
			readRawData.useDelimiter(",");
			id = readRawData.nextInt();
			
			while(readRawData.hasNextDouble()){
				temp = readRawData.nextDouble();
				temp = (temp - MIN)/(MAX - MIN);
				atributos.add(temp);
			}
			
			matrix.add(new Element(id, atributos));
			
			atributos.clear();
		}
	}
}
