/** unittest2.c
 * Author: Christopher Capps
 * Date: April 22, 2018
 * Description: Unit tests for the function in dominion.c compare
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

int main() 
{
    printf("TESTING compare ...\n\n");
    int test1, test2, test3, test4, test5;
    test1 = 0;
    test2 = 1;
    test3 = -1;
    test4 = 1000;
    test5 = -1000;
    
    printf("Testing whether 1 > 0. ");
    asserttrue(compare(&test2, &test1) == 1);

    printf("Testing whether 0 = 0. ");
    asserttrue(compare(&test1, &test1) == 0);

    printf("Testing whether -1 < 0. ");
    asserttrue(compare(&test3, &test1) == -1);

    printf("Testing whether negative number < positive number. ");
    asserttrue(compare(&test5, &test4) == -1);

    printf("Testing whether positive number > negative number. ");
    asserttrue(compare(&test4, &test5) == 1);

    printf("Testing the same positive value. ");
    asserttrue(compare(&test3, &test3) == 0);

    printf("Testing the same negative value. ");
    asserttrue(compare(&test2, &test2) == 0);
}