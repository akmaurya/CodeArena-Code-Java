#include <stdio.h>
 
int main(void)
{ 
    int const i = 10;    /* i is stored in read only area*/
    int j = 20;
 
    int const *ptr = &i;        /* pointer to integer constant. Here i
                                 is of type "const int", and &i is of
                                 type "const int *".  And p is of type                           
                                "const int", types are matching no issue */
 
    printf("ptr: %d\n", *ptr);
 
    *ptr = 100;        /* error */
 
    ptr = &j;          /* valid. We call it as up qualification. In
                         C/C++, the type of "int *" is allowed to up
                         qualify to the type "const int *". The type of
                         &j is "int *" and is implicitly up qualified by
                         the compiler to "cons tint *" */
 
    printf("ptr: %d\n", *ptr);
 
    return 0;
}
