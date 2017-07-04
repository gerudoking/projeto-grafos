package projetoFinalGrafos;

import Jama.Matrix;
import java.lang.Math;

public class AffinityMatrix {
	public static final double SIGMA = 1;
	public int dataX, dataY;
	Matrix affinity;
	
	public AffinityMatrix(DataMatrix data){
		double[][] a;
		double sum = 0;
		double quadrado = 2;
		double sil, sjl;
		
		dataX = data.matrix.size();
		dataY = data.matrix.get(0).GetNumberAtributos();
		
		a = new double[dataX][dataY];
		for(int i = 0; i < dataX; i++){
			for(int j = 0; j < dataY; j++){
				for(int w = 0; w < data.matrix.get(0).GetNumberAtributos(); w++){
					sil = data.matrix.get(i).GetAtributos(w);
					sjl = data.matrix.get(j).GetAtributos(w);
					
					sum += (sil - sjl) * (sil - sjl);
				}
				
				a[i][j] = sum/(2*SIGMA*SIGMA);
				sum = 0;
			}
		}
		
		affinity = new Matrix(a);
	}
}
