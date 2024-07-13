#include<stdio.h>
int main(void)
{
    int i=1,n=3;
    while(i>0)
    {
        if(((i*i)-1)%24==0)
        {
            printf("%d \t\t%d\n",i,n++);
        }

            i++;

    }
}
