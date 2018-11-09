/*
 * MarsRover.cpp
 *
 *  Created on: Jan 19, 2014
 *      Author: fidipro
 */

#include "MarsRover.h"
#include <string>
#include <string.h>

#include <stdio.h>
#include <iostream>

static int width;
static int height;

#define HASHTBLSZ 31

static struct Obstacle *obstaclehash[HASHTBLSZ];

struct Obstacle {
	int x,y;
	Obstacle *nxt;
	Obstacle(int a, int b): x(a), y(b){
		int val=x*width+y;
		int pos=val%HASHTBLSZ;
		nxt=obstaclehash[pos];
		obstaclehash[pos]=this;
	}
	static bool find(int x, int y) {
		int val=x*width+y;
		int pos=val%HASHTBLSZ;
		Obstacle *o=obstaclehash[pos];
		while(o) {
			if(o->x==x && o->y==y)
				return true;
			o=o->nxt;
		}
		return false;
	}
};




MarsRover::MarsRover(int x, int y, string obstacles) {
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: (o1_x,o1_y)(o2_x,o2_y)...(on_x,on_y) with no white spaces.
	 *
	 Example use:
	 MarsRover rover = new MarsRover(100,100,(5,5)(7,8))  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
	 */
	width=x;
	height=y;
	char *s=strdup(obstacles.c_str());
	char *p=s;
    while(p) {
    	char *e=strchr(p, ')');
    	if(!e) {
    		break;
    	}
    	*e=0;
    	int o[2];
	    sscanf(p, "(%d,%d", &o[0], &o[1]);
	    cout<<"coords: "<<o[0]<<", "<<o[1]<<'\n';
	    new Obstacle(o[0], o[1]);
	    if(Obstacle::find(o[0], o[1])) {
	    	std::cout<<"obstacle found\n";
	    } else {
	    	std::cout<<"obstacle lost\n";
	    }
	    p=e+1;
    }

}

MarsRover::~MarsRover() {
	// TODO Auto-generated destructor stub
}

string MarsRover::executeCommand(string command) {
	int pos[2]={0};
	int dirtbl[][2]={{0,1},{1,0},{0,-1},{-1,0}};
	char comp[]={'N','E','S','W'};
	int dirix=0;
	const char *com=command.c_str();
	char oresp[256]={0};
	int l=strlen(com);
    for(int i=0;i<l;i++) {
    	int tok=com[i];
    	if(tok=='l') {
    		if(++dirix>3) {
    			dirix=0;
    		}
    	} else if(tok=='r') {
    		if(--dirix<0) {
    			dirix=3;
    		}
    	} else if(tok=='f' || tok=='b') {
    		if(tok=='b') {
    			dirix=(dirix+2)%4;
    		}
    		int aim[2];
    		aim[0]=pos[0]+dirtbl[dirix][0];
    		aim[1]=pos[1]+dirtbl[dirix][1];
    		if(Obstacle::find(aim[0], aim[1])) {
    			char obuf[32]={0};
    			snprintf(obuf, sizeof obuf, "(%d,%d)", aim[0], aim[1]);
    			strncat(oresp, obuf, sizeof oresp);
    			continue;
    		}
    		memcpy(pos, aim, sizeof pos);
    	}
    	std::cout<<'('<<pos[0]<<","<<pos[1]<<","<<comp[dirix]<<')'<<oresp<<'\n';
    }
	/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
	 * Example:
	 * The rover is on a 100x100 grid at location (0, 0) and facing NORTH. The rover is given the commands "ffrff" and should end up at (2, 2) facing East.

	 * The return string is in the format: (x,y,facing)(o1_x,o1_y)(o2_x,o2_y)..(on_x,on_y)
	 * Where x and y are the final coordinates, facing is the current direction the rover is pointing to (N,S,W,E).
	 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
	 */
   string ret0='('+pos[0]+","+pos[1]+","+comp[dirix]+')';
   string ret1=ret0+oresp;
   return ret1;
}
