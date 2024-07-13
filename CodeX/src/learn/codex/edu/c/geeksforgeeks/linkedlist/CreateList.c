#include<stdio.h>
#include<stdlib.h>


struct node
{
    int data;
    struct node* next;
};

struct node* head;

void insert(int x)
{
    struct node* temp=(struct node*)malloc(sizeof(struct node));

    temp->data=x;
    temp->next=head;
    head=temp;
}
void display()
{
    struct node* temp=head;
    printf("List is:\n\t\t");
    while(temp!=NULL)
    {
        printf("%d  ",temp->data);
        temp=temp->next;
    }
    printf("\n");
}
int main(void)
{
    struct node* temp;
    int value,n,i;
    printf("Enter No. of node:\n");
    scanf("%d",&n);
    for(i=0;i<n;i++)
    {
        printf("Enter no.\n");
        scanf("%d",&value);
        insert(value);
        display();
    }
}
