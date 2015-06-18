/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found at http://www.is2t.com/open-source-bsd-license/.
 */

package com.is2t.examples.numeric.linear;

import ej.numeric.DoubleMatrix;
import ej.numeric.linear.Eigen;
import ej.numeric.linear.Factorization;
import ej.numeric.linear.Solve;

/**
 * This example show how to solve a linear equation, compute eigen values and decompose a matrix.
 */
public class LinearExample {
	
	public static void main(String[] args) {
		solve();
		eigen();
		factorization();
	}
	
	/*
	 * Solve a linear equation
	 */
	private static void solve () {
		System.out.println("=========  Solve ===========");
		DoubleMatrix A = new DoubleMatrix(3, 3, new double []{1,1,1, 0,2,5, 2,5,-1});
		DoubleMatrix B = new DoubleMatrix(new double [] {6, -4, 27});
		DoubleMatrix X = Solve.solve(A, B); // A * X = B
		System.out.println(A);
		System.out.println(X);
		System.out.println(B);
	}
	
	/*
	 * Compute eigen values. 
	 */
	private static void eigen () {
		System.out.println("=========  Eigen ===========");
		DoubleMatrix A = new DoubleMatrix(2, 2, new double []{1,-2, 3,-4});
		DoubleMatrix B = Eigen.eigenvalues(A).toDoubleMatrix();
		System.out.println(A);
		System.out.println(B);
	}
	
	/*
	 * Matrix factorization.
	 */
	private static void factorization () {
		System.out.println("=========  Factorization ===========");
		DoubleMatrix A = new DoubleMatrix(3, 3, new double []{1,1,1, 0,2,5, 2,5,-1});
		System.out.println(A);
		
		System.out.println("Determinant " + Factorization.getDeterminant(A));
		System.out.println("Inverse\n" + Factorization.getInverse(A));
		System.out.println("Hessenberg\n" + Factorization.hessenberg(A));
		
		//decomposition lu
		DoubleMatrix [] lu = Factorization.lu(A);
		System.out.println("Decomposition LU (L)\n" + lu[0]);
		System.out.println("Decomposition LU (U)\n" + lu[1]);
		
		//decomposition lup
		DoubleMatrix [] lup = Factorization.lup(A);
		System.out.println("Decomposition LUP (L)\n" + lup[0]);
		System.out.println("Decomposition LUP (U)\n" + lup[1]);
		System.out.println("Decomposition LUP (P)\n" + lup[2]);
	}
}
