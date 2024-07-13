#include<stdio.h>
#include<stdlib.h>
 int main(void)
 {
     int a;
     char *p;
     p=(char*)malloc(sizeof(int));
     *p=10;
     printf("%d",p);
 }
