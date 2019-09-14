
#include <stdio.h>

#include "test.h"


void test_1();

void init_test(){
	// printf( "INIT TEST\n" );
	// double v = 0.01;
	// double per = 100*v;
	// int i = (int) per;
	// double value = 25/2;
	// printf( '"' );
	double v = 2;
	double value = -v;
	printf( "value : %2.2f\n", value );
	// printf( "v : %e\nper : %e\ni : %d\namespace", v, per, i );
	
	
	/* // float a = 12.67; 
    // printf("%f\n", a); 
    // printf("%e\n", a); */
	
}

int test( int argc, char ** argv ){
	
	init_test( );
	
	printf( "HELLO WORLD FOROM TEST\n" );
	return 0;
}

void test_1(){
	
}

