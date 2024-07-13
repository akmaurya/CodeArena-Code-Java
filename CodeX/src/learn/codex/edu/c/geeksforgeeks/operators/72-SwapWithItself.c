#include <stdio.h>
void swap(int *xp, int *yp)
{
    if (xp == yp) // Check if the two addresses are same
      return;
    *xp = *xp + *yp;
    *yp = *xp - *yp;
    *xp = *xp - *yp;
}
int main()
{
  int x = 10;
  swap(&x, &x);
  printf("After swap(&x, &x): x = %d", x);
  return 0;
}
/*
Output:

After swap(&x, &x): x = 10
*/
