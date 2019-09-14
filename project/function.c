#define _POSIX_SOURCE
#define _XOPEN_SOURCE 2

#include <stdio.h>

// #include <string.h>
// #include <math.h>

#include <math.h>
#include "function.h"

const float e = 2.71828182845904523536;

double getValueAt( double x ){
	double x_ = -x;
	double res = x * ( pow( M_E, x_ ) );
	return res;	
}
