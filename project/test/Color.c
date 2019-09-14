

#include <stdio.h>
#include "Color.h"

void setColor( const char * color );
void resetColor();

void setColor( const char *color ){
	printf( "%s", color );	
}

void resetColor( ){
	printf( "%s", RESET );
}


void deleteLine( ){
	printf("\33[2K\r");
}

// void moveToPrevLine(){
	// printf(  );
// }