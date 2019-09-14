

#include <omp.h>
#define _POSIX_SOURCE
#define _XOPEN_SOURCE 2
#include <stdio.h>
#include <math.h>
// #include "test.h"
#include "Color.h"
#include <time.h>
#include <unistd.h>
#include <sys/types.h>
#include <stdlib.h>


#include <float.h>
#include "function.h"
#include "Color.h"

double error = 0.01;
// static int n = 100;


// void test_3(){
//
// 	#pragma omp parallel
// 	{
// 		// setColor( BRIGHT_RED );
// 		printf( "HELLO WORLD\n" );
// 		// resetColor();
// 	}
//
// 	// size_t count = 6;
// 	// #pragma omp for
// 	// for(size_t i = 0; i < count; i++) {
// 	// 	printf( "HELLO WORLD_%zu\n", i );
// 	// }
//
// }

double get_abs_error(double actual_value, double value){
	double res = fabs( actual_value - value );
	return res;
}

double get_relative_error( double actual_value, double value ){
	double res = get_abs_error( actual_value, value )/actual_value;
	return res;
}

double get_integral(double start_x, double end_x , int n){
	setColor( BRIGHT_RED ) ;
	printf( "get_integral (start_x : %f | end_x : %f | n : %d)\n", start_x, end_x, n );
	resetColor();
	double step = (double) abs( end_x - start_x )/ n;
	double sum = 0;
	double x, y;
	double area;
	double i;

	for( i= 1; i < n && x <= end_x ; i++ ){
		x = ( i * step ) + start_x;
		y = getValueAt( x );
		area = step * y;
		sum += area;
	}
	return sum;
}
	// integral = get_integral(,start_x, end_x );
	// double err = get_relative_error(actual_value, integral );

int main(int argc, char ** argv){


	// if( 1 ){
	// 	int a = 2;
	// 	int b = 4;	// integral = get_integral(,start_x, end_x );
	// // double err = get_relative_error(actual_value, integral );
	//
	// 	double c = powf( a, b );
	// 	printf( "THE VALUE OF C :%f\n", c );
	// 	return 1;
	// }



	// integral = get_integral(,start_x, end_x );
	// double err = get_relative_error(actual_value, integral );



	setColor( BRIGHT_YELLOW );
	printf( "THIS LINE MUST BE INVISIBLE\n" );
	resetColor( );
	static double start_x = 1.5;
	static double end_x = 20;
	int n = 100;
	double integral = 0;
	const double e = 2.7182818284590452353;
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
	int counter = 0;
		do{
			n+=10;
			++counter;
			integral = 0;
			setColor( BRIGHT_YELLOW );

			#pragma omp for
			for( int i = 0; i < (int) numThreads; i++ ){
				integral += get_integral( start_x + subRange*i, start_x + subRange * ( i + 1), n/numThreads );
			}
			printf( "INTEGRAL : %f\n", integral );
			err = get_relative_error( actual_value, integral );
			printf( "==================================================\n" );
	}while( err > error && counter < 10000 );

	// double err = get_relative_error(actual_value, integral );
	resetColor( );

	printf( "integral : %f\n", integral );

	return 0;
}
