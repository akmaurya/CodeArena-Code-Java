#include<stdio.h>
#include<stdlib.h>

struct node
{
    int data;
    struct node* next;
};

struct node* head;
struct node* rear;

void append(int x)
{
    struct node* temp=(struct node*)malloc(sizeof(struct node));
    temp->data=x;
    temp->next=NULL;
    if(head==NULL)
    head=temp;
    else
    rear->next=temp;
    rear=temp;
}

void display()
{
    struct node* temp=head;
    printf("List are\n\t\t");
    while(temp!=NULL)
    {
        printf("%d  ",temp->data);
        temp=temp->next;
    }
    printf("\n");
}

int main(void)
{
    int n,i,x;
    printf("Enter the no. of list\n");
    scanf("%d",&n);
    for(i=0;i<n;i++)
    {
        printf("Enter element\n");
        scanf("%d",&x);
        append(x);
        display();
    }
}
