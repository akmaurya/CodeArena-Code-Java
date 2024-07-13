#include<iostream>
#include<stack>
#include<stdio.h>
#include<string.h>
using namespace std;

void rev(char *ch,int len)
{
    int i;
    stack<char> s;
    for(i=0;i<len;i++)
        s.push(ch[i]);
    for(i=0;i<=len+1;i++)
    {
        ch[i]=s.top();
        s.pop();
    }

}

int main(void)
{
    char str[40];
    int len;
    printf("Enter any String\n");
    gets(str);
    rev(str,strlen(str));
    printf("Reverse is\n  %s",str);
}
