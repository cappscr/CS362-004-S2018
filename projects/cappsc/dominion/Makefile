CFLAGS = -Wall -fpic -coverage -lm

rngs.o: rngs.h rngs.c
	gcc -c rngs.c -g  $(CFLAGS)

dominion.o: dominion.h dominion.c rngs.o
	gcc -c dominion.c -g  $(CFLAGS)

playdom: dominion.o playdom.c
	gcc -o playdom playdom.c -g dominion.o rngs.o $(CFLAGS)
#To run playdom you need to entere: ./playdom <any integer number> like ./playdom 10*/
testDrawCard: testDrawCard.c dominion.o rngs.o
	gcc  -o testDrawCard -g  testDrawCard.c dominion.o rngs.o $(CFLAGS)

testIsGameOver: unittest1.c dominion.o rngs.o
	gcc  -o testIsGameOver -g  unittest1.c dominion.o rngs.o $(CFLAGS)

testCompare: unittest2.c dominion.o rngs.o
	gcc  -o testCompare -g  unittest2.c dominion.o rngs.o $(CFLAGS)

testFullDeckCount: unittest3.c dominion.o rngs.o
	gcc  -o testFullDeckCount -g  unittest3.c dominion.o rngs.o $(CFLAGS)

testWhoseTurn: unittest4.c dominion.o rngs.o
	gcc  -o testWhoseTurn -g  unittest4.c dominion.o rngs.o $(CFLAGS)

testSmithyCard: cardtest1.c dominion.o rngs.o
	gcc  -o testSmithyCard -g  cardtest1.c dominion.o rngs.o $(CFLAGS)

testAdvCard: cardtest2.c dominion.o rngs.o
	gcc  -o testAdvCard -g  cardtest2.c dominion.o rngs.o $(CFLAGS)

testCouncilCard: cardtest3.c dominion.o rngs.o
	gcc  -o testCouncilCard -g  cardtest3.c dominion.o rngs.o $(CFLAGS)

testVillageCard: cardtest4.c dominion.o rngs.o
	gcc  -o testVillageCard -g  cardtest4.c dominion.o rngs.o $(CFLAGS)

badTestDrawCard: badTestDrawCard.c dominion.o rngs.o
	gcc -o badTestDrawCard -g  badTestDrawCard.c dominion.o rngs.o $(CFLAGS)

testBuyCard: testDrawCard.c dominion.o rngs.o
	gcc -o testDrawCard -g  testDrawCard.c dominion.o rngs.o $(CFLAGS)

testAll: dominion.o testSuite.c
	gcc -o testSuite testSuite.c -g  dominion.o rngs.o $(CFLAGS)

interface.o: interface.h interface.c
	gcc -c interface.c -g  $(CFLAGS)

unittestresults.out: testIsGameOver testCompare testFullDeckCount testWhoseTurn testSmithyCard testAdvCard testCouncilCard testVillageCard
	./testIsGameOver &> unittestresults.out
	./testCompare >> unittestresults.out
	./testFullDeckCount >> unittestresults.out
	./testWhoseTurn >> unittestresults.out
	./testSmithyCard >> unittestresults.out
	./testAdvCard >> unittestresults.out
	./testCouncilCard >> unittestresults.out
	./testVillageCard >> unittestresults.out
	gcov dominion.c >> unittestresults.out
	cat dominion.c.gcov >> unittestresults.out

player: player.c interface.o
	gcc -o player player.c -g  dominion.o rngs.o interface.o $(CFLAGS)

all: playdom player 

clean:
	rm -f *.o playdom.exe playdom player player.exe  *.gcov *.gcda *.gcno *.so *.out testDrawCard testDrawCard.exe testIsGameOver testIsGameOver.exe testCompare testCompare.exe testFullDeckCount testFullDeckCount.exe testWhoseTurn testWhoseTurn.exe testAdvCard testAdvCard.exe testSmithyCard testSmithyCard.exe testCouncilCard testCouncilCard.exe testVillageCard testVillageCard.exe
