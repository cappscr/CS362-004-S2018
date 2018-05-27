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

badTestDrawCard: badTestDrawCard.c dominion.o rngs.o
	gcc -o badTestDrawCard -g  badTestDrawCard.c dominion.o rngs.o $(CFLAGS)

testBuyCard: testDrawCard.c dominion.o rngs.o
	gcc -o testDrawCard -g  testDrawCard.c dominion.o rngs.o $(CFLAGS)

testAll: dominion.o testSuite.c
	gcc -o testSuite testSuite.c -g  dominion.o rngs.o $(CFLAGS)

interface.o: interface.h interface.c
	gcc -c interface.c -g  $(CFLAGS)

runtests: testDrawCard 
	./testDrawCard &> unittestresult.out
	gcov dominion.c >> unittestresult.out
	cat dominion.c.gcov >> unittestresult.out
	
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

randTestAdvCard: randomtestadventurer.c dominion.o rngs.o
	gcc  -o randTestAdvCard -g  randomtestadventurer.c dominion.o rngs.o $(CFLAGS)

randTestSmithyCard: randomtestcard1.c dominion.o rngs.o
	gcc  -o randTestSmithyCard -g  randomtestcard1.c dominion.o rngs.o $(CFLAGS)

randTestVillageCard: randomtestcard2.c dominion.o rngs.o
	gcc  -o randTestVillageCard -g  randomtestcard2.c dominion.o rngs.o $(CFLAGS)

randomtestcard1.out: randTestSmithyCard
	./randTestSmithyCard >> randomtestcard1.out
	gcov dominion.c >> randomtestcard1.out
	cat dominion.c.gcov >> randomtestcard1.out

randomtestcard2.out: randTestVillageCard
	./randTestVillageCard >> randomtestcard2.out
	gcov dominion.c >> randomtestcard2.out
	cat dominion.c.gcov >> randomtestcard2.out

randomtestadventurer.out: randTestAdvCard
	./randTestAdvCard &> randomtestadventurer.out
	gcov dominion.c >> randomtestadventurer.out
	cat dominion.c.gcov >> randomtestadventurer.out

randtestresults.out: randTestAdvCard randTestSmithyCard randTestVillageCard
	./randTestAdvCard &> randtestresults.out
	./randTestSmithyCard >> randtestresults.out
	./randTestVillageCard >> randtestresults.out
	gcov dominion.c >> randtestresults.out
	cat dominion.c.gcov >> randtestresults.out

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

testresults.out: randTestAdvCard randTestSmithyCard randTestVillageCard testIsGameOver testCompare testFullDeckCount testWhoseTurn testSmithyCard testAdvCard testCouncilCard testVillageCard
	./testIsGameOver &> testresults.out
	./testCompare >> testresults.out
	./testFullDeckCount >> testresults.out
	./testWhoseTurn >> testresults.out
	./testSmithyCard >> testresults.out
	./testAdvCard >> testresults.out
	./testCouncilCard >> testresults.out
	./testVillageCard >> testresults.out
	./randTestAdvCard &> testresults.out
	./randTestSmithyCard >> testresults.out
	./randTestVillageCard >> testresults.out
	gcov dominion.c >> testresults.out
	cat dominion.c.gcov >> testresults.out

player: player.c interface.o
	gcc -o player player.c -g  dominion.o rngs.o interface.o $(CFLAGS)

all: playdom player 

clean:
	rm -f *.o playdom.exe playdom player player.exe  *.gcov *.gcda *.gcno *.so *.out testDrawCard testDrawCard.exe
