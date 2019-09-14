#define _POSIX_SOURCE
#define _XOPEN_SOURCE 2

#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <time.h>
#include "Color.h"
#include "function.h"

double getValueAt( double x ),runParallel(  ), runSerial( ), get_integral( double start_x, double end_x, int n ),
get_abs_error( double actual_value, double value ), get_relative_error( double actual_value, double value );

static double start_x = 1.5;
static double end_x = 20;
static int n = 100;
const double e = 2.71828182845904523536;
double actual_value = 0.557824;
double start_time, end_time;
double error = 0.01;

double getValueAt( double x ){
	double x_ = -x;
	double res = x * ( pow( M_E, x_ ) );
	return res;
}


double runParallel( ){
	double integral = 0;
	double numThreads = 2;
	double err = 0;
	double subRange = fabs( end_x -  start_x ) / numThreads;
	int counter = 0;
		do{
			n+=10;
			++counter;
			integral = 0;
			setColor( BRIGHT_YELLOW );

			//SETTING START TIME
			start_time = clock();
			#pragma omp for
			for( int i = 0; i < (int) numThreads; i++ ){
				integral += get_integral( start_x + subRange*i, start_x + subRange * ( i + 1), n/numThreads );
			}
			end_time = clock( );
			printf( "INTEGRAL : %f\n", integral );
			err = get_relative_error( actual_value, integral );
			printf( "==================================================\n" );
	}while( err > error && counter < 10000 );

	return integral;
}

double runSerial( ){
	double err = 0;
	double integral;
	do{
		n+=10;
		integral = get_integral( start_x , end_x, n);
		err = get_relative_error(actual_value, integral );
	}
	while( err > error );
	return integral;
}

double get_abs_error(double actual_value, double value){
	double res = fabs( actual_value - value );
	return res;const double e = 2.7182818284590452353;
}

double get_relative_error( double actual_value, double value ){
	double res = get_abs_error( actual_value, value )/actual_value;
	return res;
}

double get_integral(double start_x, double end_x , int n){
	// printf( "get_integral\n" );
	double step = (double) abs( end_x - start_x )/ n;
	double x, y;
	double area;
	double sum = 0;
	double i;

	for( i= 1; i < n && x <= end_x ; i++ ){
		x = ( i * step ) + start_x;
		y = getValueAt( x );
		area = step * y;
		sum += area;
	}
	setColor( BRIGHT_RED ) ;
	printf( "get_integral (start_x : %f | end_x : %f | n : %d | integral : %f\n", start_x, end_x, n	, sum );
	resetColor();
	return sum;
}


double getStartTime(){
	return start_time;
}

double getEndTime(){
	return end_time;
}
