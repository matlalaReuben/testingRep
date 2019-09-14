#################
#   variables   #
#################

# files
EXECUTABLE  = main
SOURCES  = main.c io.c function.c Color.c
OBJECTS  = $(SOURCES:.c=.o)

# compilation and linking
CC      = gcc
CFLAGS  = -fopenmp -std=c99 -ggdb3 -c
LDFLAGS = -fopenmp
WARN    = -Wall -Wextra -pedantic -Wno-unused-variable -Wno-unused-parameter
COMPILE.c = $(CC) $(CFLAGS) $(CPPFLAGS) $(WARN)
LINK.c    = $(CC)

#################
#     targets   #
#################

all: $(EXECUTABLE)

$(EXECUTABLE): $(OBJECTS)
	$(LINK.c) $^ $(LDFLAGS) -o $@ -lm

$(OBJECTS): %.o: %.c
	$(COMPILE.c) $< -o $@

# phony targets
.PHONY: clean

# remove object files, emacs temporaries
clean:
	rm -f *.o *~
