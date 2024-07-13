#include <stdio.h>
int main(void)
{
    int i = 10;  
    int j = 20;
    const int *ptr = &i;    /* ptr is pointer to constant */
  
    printf("ptr: %d\n", *ptr);
    *ptr = 100;        /* error: object pointed cannot be modified
                     using the pointer ptr */
  
    ptr = &j;          /* valid */
    printf("ptr: %d\n", *ptr);
  
    return 0;
}
/*
Output:

 error: assignment of read-only location ‘*ptr’

*/
