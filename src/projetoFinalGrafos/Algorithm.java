package projetoFinalGrafos;

import Jama.Matrix;
import Jama.EigenvalueDecomposition;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class Algorithm {
	public DataMatrix data;
	public AffinityMatrix A;
	public Matrix L;
	public Matrix X;
	private int numberOfClusters;
	private int numberOfPoints;
	
	public Algorithm(DataMatrix data){
		this.data = data;
		A = new AffinityMatrix(data);
	}
	
	public void SpectralClustering(){
		Matrix d = new Matrix(A.dataX, A.dataY);
		Matrix dRaiz = new Matrix(A.dataX, A.dataY);
		double aux = 0;
		EigenvalueDecomposition value;
		List<Double> yi = new ArrayList<Double>();
		
		for(int i = 0; i < A.dataX; i++){
			for(int j = 0; j < A.dataY; j++){
				aux += A.affinity.get(i, j);
			}
			
			d.set(i, i, aux);
			aux = 0;
		}
		
		for(int i = 0; i < A.dataX; i++){
			for(int j = 0; j < A.dataY; j++){
				dRaiz.set(i, j, Math.sqrt(d.get(i, j)));
			}
		}
		
		L = dRaiz.inverse().times(A.affinity.times(dRaiz.inverse()));
		value = L.eig();
		X = value.getV();
		
		for(int i = 0; i < A.dataX; i++){
			for(int j = 0; j < A.dataY; j++){
				yi.add(X.get(i, j));
			}
			
			
		}
	}
}
