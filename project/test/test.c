

#include <omp.h>
#define _POSIX_SOURCE
#define _XOPEN_SOURCE 2
#include <stdio.h>
#include <math.h>
#include "test.h"
#include "Color.h"
#include <time.h>
#include <unistd.h>


void test_1(), test_2(), test_3();

void init_test(){

	double start_time, end_time;
	start_time = clock();
	printf( "SLEEPING FOR 5\n" );
	sleep(5);
	end_time = clock();
	printf( "START_TIME : %f | END-TIME : %f | DURATION : %f\n", start_time, end_time, ( end_time - start_time ) );
	printf( "IN SECONDS : %f\n", ( ( double ) ( end_time - start_time ) )/ CLOCKS_PER_SEC );
	//
	// double a = 2;
	// double b = 4;
	// double c = powf(a, b);
	// printf( "THE VALUE OF C : %f\n", c );

	// printf( "INIT TEST\n" );
	// double v = 0.01;
	// double per = 100*v;
	// int i = (int) per;
	// double value = 25/2;
	// printf( '"' );
	// double v = 2;
	// double value = -v;
	// printf( "value : %2.2f\n", value );
	// printf( "v : %e\nper : %e\ni : %d\namespace", v, per, i );


	/* // float a = 12.67;
    // printf("%f\n", a);
    // printf("%e\n", a); */

}

int test( int argc, char ** argv ){

	init_test( );

	// test_1( );
	// test_2( );
	// test_3( );
	printf( "HELLO WORLD FOROM TEST\n" );
	return 0;
}

void test_1(){

	setColor( BRIGHT_YELLOW );
	printf( "TEST_1\n	" );
	resetColor();

	#pragma omp parallel

	printf("Hello, world.\n");
  // return 0
}

void test_2(){
	time_t start, end;
	// clock_t start, end;
	double duration;

	start = time( NULL );
	// start = clock();
	printf( "%sSTART TIME : %ld\n", BRIGHT_GREEN, start	 );
	resetColor();
	setColor( BRIGHT_RED );
	printf( "TEST_2\n" );
	setColor ( BRIGHT_MAGENTA );
	printf ( "SLEEPING FOR 5 SECONDS\n" );
	sleep( 5 );
	resetColor();

	// end = clock( );
	end = time( NULL );
	setColor( BRIGHT_GREEN );
	printf( "END TIME : %ld | end : %ld\n", start, end );
	resetColor( );

	// double time_taken = ((double)t)/CLOCKS_PER_SEC;
	// duration = ( (double)( end - start ) ) / CLOCKS_PER_SEC;
	double diff = end - start;
	printf( "%sDIFFERENCE : %f\n", BRIGHT_RED, diff );
	// printf( "%sDURATION : %f\n", BRIGHT_WHITE, duration );
	resetColor();

}

void test_3(){
	//
	// #pragma omp parallel
	// {
	// 	// setColor( BRIGHT_RED );
	// 	printf( "HELLO WORLD\n" );
	// 	// resetColor();
	// }

	size_t count = 6;
	#pragma omp for
	for(size_t i = 0; i < count; i++) {
		printf( "HELLO WORLD_%zu\n", i );
	}

}
