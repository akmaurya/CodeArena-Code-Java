/* A simple scanset example */
#include <stdio.h>

int main(void)
{
    char str[128];

    printf("Enter a string: ");
    scanf("%[A-Z]s", str);

    printf("You entered: %s\n", str);

    return 0;
}
/*
  [root@centos-6 C]# ./scan-set 
  Enter a string: GEEKs_for_geeks
  You entered: GEEK
*/
