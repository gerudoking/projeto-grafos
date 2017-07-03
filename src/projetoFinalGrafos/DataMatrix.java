package projetoFinalGrafos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataMatrix {
	private static final String FILENAME = "plantas.txt";
	public List<Element> matrix;
	
	public DataMatrix(){
		String rawData;
		String name;
		String temp;
		List<String> states;
		Scanner read = null;
		Scanner readRawData = null;
		
		states = new ArrayList<String>();
		
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
			name = readRawData.next();
			
			while(readRawData.hasNext()){
				temp = readRawData.next();
				states.add(temp);
			}
			
			matrix.add(new Element(name, states));
		}
	}
}
