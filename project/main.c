

#define _POSIX_SOURCE
#define _XOPEN_SOURCE 2
#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <stdlib.h>
#include <linux/limits.h>

#include <omp.h>
// #include <limits.h>
#include <math.h>
#include <float.h>
#include "function.h"
#include "Color.h"

double error = 0.01;
// static int n = 100;


double get_abs_error(double actual_value, double value){
	double res = fabs( actual_value - value );
	return res;	
}

double get_relative_error( double actual_value, double value ){
	double res = get_abs_error( actual_value, value )/actual_value;
	return res;
}

double get_integral(double start_x, double end_x , int n){
	double step = (double) abs( end_x - start_x )/ n;
	double sum = 0;
	double x, y;
	double area;
	double i;
	
	for( i= 1; i < n && x < end_x ; i++ ){
		x = ( i * step ) + start_x;
		y = getValueAt( x );
		area = step * y;
		sum += area;
	}
	return sum;
}

int main(int argc, char ** argv){
	static double start_x = 1.5;
	static double end_x = 20;
	int n = 100;
	double integral = 0;
	const float e = 2.71828182845904523536;
	double actual_value =  (-1*( end_x*pow( M_E, ( (-1) * end_x ) )) - (-(start_x*pow(M_E,((-1)*start_x)))) ) - ( (pow(M_E,((-1)*end_x))) - (pow(M_E,(-1)*start_x))) ;
	// integral = get_integral(,start_x, end_x );
	// double err = get_relative_error(actual_value, integral );
	double err;// = get_relative_error(actual_value, integral );
	/* 
	while( err >	 error ){
		n+=10;
		integral = get_integral( );
		err = get_relative_error(actual_value, integral );
	}
	 */
	
	double numThreads = 2;
	double subRange = fabs( end_x -  start_x ) / numThreads;
	
	do{
		integral = 0;
		setColor( BRIGHT_YELLOW );
		#pragma omp for
		{
			for( int i = 0; i < numThreads; i++ ){
				integral += get_integral( start_x + subRange*i, start_x * ( i + 1), n/numThreads );
			}
		}
		printf( "INTEGRAL :%f\n", integral );
		err = get_relative_error( actual_value, integral );
		
	}while( err > error );
	resetColor( );	
	
	printf( "integral : %f\n", integral );
	return 0;
}