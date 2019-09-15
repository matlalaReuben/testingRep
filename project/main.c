

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
#include <sys/time.h>
#include <stdlib.h>


#include <float.h>
#include "function.h"
#include "Color.h"



int main( int argc, char ** argv ){

	// double start_time, end_time;
	struct timeval stop, start;

	gettimeofday( &start, NULL );
	double serial = runSerial( );
	gettimeofday( &stop, NULL );

	printf( "SERIAL : %f\n", (double) ( stop.tv_sec - start.tv_sec ) );

	gettimeofday( &start, NULL );
	double parallel = runParallel();
	gettimeofday( &start, NULL );

	printf( "PARALLEL : %f\n", (double) ( stop.tv_sec - start.tv_sec ) );

	return 0;
}
