#include<stdio.h>
int main(void)
{
	unsigned int a,b;
	printf("Enter two No.\n");
	scanf("%u%u",&a,&b);
	printf("%d",flipped(a,b));
}

int flipped(unsigned int x,unsigned int y)
{
	int count=0;
	x=x^y;
	while(x!=0)
	{
		if(x&1)
		count++;
		x=x>>1;
	}
	return count;
}
