/** unittest1.c
 * Author: Christopher Capps
 * Date: April 22, 2018
 * Description: Unit tests for the function in dominion.c isGameOver
 * */

#include "dominion.h"
#include "dominion_helpers.h"
#include "rngs.h"
#include <stdio.h>
#include <math.h>
#include <stdlib.h>

void asserttrue(int expression)
{
    if (expression == 0)
        printf("TEST FAILED\n");
    else
        printf("TEST SUCCESSFULLY COMPLETED\n");
}

int main() {
    struct gameState g;
    g.supplyCount[3] = 0;
    printf("\n\nTESTING isGameOver ...\n\n");
    printf("When there are no province cards left game should be over. ");
    asserttrue(isGameOver(&g) == 1);

    int i;
    for (i = 0; i < 28; i++)
    {
        // Give each type of card a count of 5
        g.supplyCount[i] = 5;
    }
    printf("When there are cards left in every supply pile the game should NOT be over. ");
    asserttrue(isGameOver(&g) == 0);

    g.supplyCount[0] = 0;
    printf("When one card supply pile is empty the game should NOT be over. ");
    asserttrue(isGameOver(&g) == 0);

    g.supplyCount[1] = 0;
    printf("When two card supply piles are empty the game should NOT be over. ");
    asserttrue(isGameOver(&g) == 0);

    g.supplyCount[2] = 0;
    printf("When three card supply piles are empty the game should be over. ");
    asserttrue(isGameOver(&g) == 1);
}