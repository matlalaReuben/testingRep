#ifndef  _COLOR_H_
#define _COLOR_H_

static const char * RESET = "\x1B[m";

static const char * BLACK  = "\x1B[30m";
static const char * RED = "\x1B[31m";
static const char * GREEN = "\x1B[32m";
static const char * YELLOW = "\x1B[33m";
static const char * BLUE = "\x1B[34m";
static const char * PURPLE = "\x1B[35m";
static const char * CYAN  = "\x1B[36m";
static const char * WHITE  = "\x1B[37m";

static const char * BRIGHT_RED  = "\x1B[91m";
static const char * BRIGHT_GREEN  = "\x1B[92m";
static const char * BRIGHT_YELLOW  = "\x1B[93m";
static const char * BRIGHT_BLUE  = "\x1B[94m";
static const char * BRIGHT_MAGENTA  = "\x1B[95m";
static const char * BRIGHT_CYAN  = "\x1B[96m";
static const char * BRIGHT_WHITE  = "\x1B[97m";

static const char * BLACK_BACKGROUND  = "\x1B[40m";
static const char * RED_BACKGROUND = "\x1B[41m";
static const char * GREEN_BACKGROUND = "\x1B[42m";
static const char * YELLOW_BACKGROUND = "\x1B[43m";
static const char * BLUE_BACKGROUND = "\x1B[44m";
static const char * PURPLE_BACKGROUND = "\x1B[45m";
static const char * CYAN_BACKGROUND  = "\x1B[46m";
static const char * WHITE_BACKGROUND  = "\x1B[47m";

static const char * BRIGHT_RED_BACKGROUND  = "\x1B[101m";
static const char * BRIGHT_GREEN_BACKGROUND  = "\x1B[102m";
static const char * BRIGHT_YELLOW_BACKGROUND  = "\x1B[103m";
static const char * BRIGHT_BLUE_BACKGROUND  = "\x1B[104m";
static const char * BRIGHT_MAGENTA_BACKGROUND  = "\x1B[105m";
static const char * BRIGHT_CYAN_BACKGROUND  = "\x1B[106m";
static const char * BRIGHT_WHITE_BACKGROUND  = "\x1B[107m";


void setColor( const char * color );
void resetColor( );
void deleteLine();


	

#endif