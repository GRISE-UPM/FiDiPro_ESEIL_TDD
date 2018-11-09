#include "../src/Frame.h"
#include "../src/BowlingGame.h"

#define BOOST_TEST_MAIN
#include <boost/test/included/unit_test.hpp>

BOOST_AUTO_TEST_SUITE (Bowling_suite)

BOOST_AUTO_TEST_CASE( frame0 ) {
	int a[2]={0,0};
	Frame f(a);
	BOOST_CHECK_EQUAL( f.score(), 0 );
}

BOOST_AUTO_TEST_CASE( frame1 ) {
	int b[2]={10,10};
	Frame f(b);
	BOOST_CHECK_EQUAL( f.score(), -1 );
}

int series0[][2]=
{
		{1,5},
		{3,6},
		{7,2},
		{3,6},
		{4,4},
		{5,3},
		{3,3},
		{4,5},
		{8,1},
		{2,6}
};

BOOST_AUTO_TEST_CASE( game0 ) {
	Frame f(10,5);
	BOOST_CHECK_EQUAL( f.score(), -1 );
}

BOOST_AUTO_TEST_CASE( fullgame0 ) {
	BowlingGame bg;
	for(int i=0;i<10;i++) {
		bg.addFrame(series0[i]);
	}
	BOOST_CHECK_EQUAL( bg.nrFrames(), 10 );
}

BOOST_AUTO_TEST_CASE( fullgame1 ) {
	BowlingGame bg;
	for(int i=0;i<10;i++) {
		bg.addFrame(series0[i]);
	}
	BOOST_CHECK_EQUAL( bg.score(), 81);
}
int series1[][2]=
{
		{10,0},
		{3,6},
		{7,2},
		{3,6},
		{4,4},
		{5,3},
		{3,3},
		{4,5},
		{8,1},
		{2,6}
};

BOOST_AUTO_TEST_CASE( fullgame2 ) {
	BowlingGame bg;
	for(int i=0;i<10;i++) {
		bg.addFrame(series1[i]);
	}
	BOOST_CHECK_EQUAL( bg.score(), 94);
}

int series2[][2]=
{
		{1,9},
		{3,6},
		{7,2},
		{3,6},
		{4,4},
		{5,3},
		{3,3},
		{4,5},
		{8,1},
		{2,6}
};

BOOST_AUTO_TEST_CASE( fullgame3 ) {
	BowlingGame bg;
	for(int i=0;i<10;i++) {
		bg.addFrame(series2[i]);
	}
	BOOST_CHECK_EQUAL( bg.score(), 88);
}


int series3[][2]=
{
		{10,0},
		{4,6},
		{7,2},
		{3,6},
		{4,4},
		{5,3},
		{3,3},
		{4,5},
		{8,1},
		{2,6}
};

BOOST_AUTO_TEST_CASE( fullgame4 ) {
	BowlingGame bg;
	for(int i=0;i<10;i++) {
		bg.addFrame(series3[i]);
	}
	BOOST_CHECK_EQUAL( bg.score(), 103);
}

int series8[][2]=
{
		{10,0},
		{10,0},
		{7,2},
		{3,6},
		{4,4},
		{5,3},
		{3,3},
		{4,5},
		{8,1},
		{2,6}
};

BOOST_AUTO_TEST_CASE( fullgame8 ) {
	BowlingGame bg;
	for(int i=0;i<10;i++) {
		bg.addFrame(series8[i]);
	}
	BOOST_CHECK_EQUAL( bg.score(), 112);
}

int series9[][2]=
{
		{8,2},
		{5,5},
		{7,2},
		{3,6},
		{4,4},
		{5,3},
		{3,3},
		{4,5},
		{8,1},
		{2,6}
};

BOOST_AUTO_TEST_CASE( fullgame9 ) {
	BowlingGame bg;
	for(int i=0;i<10;i++) {
		bg.addFrame(series9[i]);
	}
	BOOST_CHECK_EQUAL( bg.score(), 98);
}

int series10[][2]=
{
		{1,5},
		{3,6},
		{7,2},
		{3,6},
		{4,4},
		{5,3},
		{3,3},
		{4,5},
		{8,1},
		{2,8}
};

BOOST_AUTO_TEST_CASE( fullgame10 ) {
	BowlingGame bg;
	for(int i=0;i<10;i++) {
		bg.addFrame(series10[i]);
	}
	bg.addBonus(7);
	BOOST_CHECK_EQUAL( bg.score(), 90);
}

int series11[][2]=
{
		{1,5},
		{3,6},
		{7,2},
		{3,6},
		{4,4},
		{5,3},
		{3,3},
		{4,5},
		{8,1},
		{10,0}
};

BOOST_AUTO_TEST_CASE( fullgame11 ) {
	BowlingGame bg;
	for(int i=0;i<10;i++) {
		bg.addFrame(series11[i]);
	}
	bg.addBonus(7,2);
	BOOST_CHECK_EQUAL( bg.score(), 92);
}

int series12[][2]=
{
		{1,5},
		{3,6},
		{7,2},
		{3,6},
		{4,4},
		{5,3},
		{3,3},
		{4,5},
		{8,1},
		{10,0}
};

BOOST_AUTO_TEST_CASE( fullgame12 ) {
	BowlingGame bg;
	for(int i=0;i<10;i++) {
		bg.addFrame(series12[i]);
	}
	bg.addBonus(10);
	BOOST_CHECK_EQUAL( bg.score(), 93);
}

int series13[][2]=
{
		{10,0},
		{10,0},
		{10,0},
		{10,0},
		{10,0},
		{10,0},
		{10,0},
		{10,0},
		{10,0},
		{10,0}
};

BOOST_AUTO_TEST_CASE( fullgame13 ) {
	BowlingGame bg;
	for(int i=0;i<10;i++) {
		bg.addFrame(series13[i]);
	}
	bg.addBonus(10);
	BOOST_CHECK_EQUAL( bg.score(), 300);
}



BOOST_AUTO_TEST_SUITE_END()

