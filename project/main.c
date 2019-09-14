

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



int main( int argc, char ** argv ){

	double start_time, end_time;
	start_time = clock();
 	double serial = runSerial( );
	end_time = clock( );

 	printf( "%sSERIAL : %f | duration : %f%s\n", BRIGHT_MAGENTA, serial, (end_time - start_time), RESET );

	start_time = clock();
	double parallel = runParallel();
	end_time = clock( );
	printf( "%sPARALLEL : %f | DURATION : %f%s\n",BRIGHT_MAGENTA, parallel, ( end_time - start_time ), RESET );
	return 0;
}
