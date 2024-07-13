#include <stdio.h>
  
int main(void)
{
   int i = 10;
   int j = 20;
   int *const ptr = &i;    /* constant pointer to integer */
  
   printf("ptr: %d\n", *ptr);
  
   *ptr = 100;    /* valid */
   printf("ptr: %d\n", *ptr);
  
   ptr = &j;        /* error */
   return 0;
}
/*
Output:

 error: assignment of read-only variable ‘ptr’


*/
