#include<stdio.h>
#include<stdlib.h>

struct node
{
    int data;
    struct node* next;
};

struct node* head;

void push(int x)
{
    struct node* temp=(struct node*)malloc(sizeof(struct node));
    temp->data=x;
    temp->next=head;
    head=temp;
}

int pop()
{
    if(head!=NULL)
    {
        struct node* temp=head;
        printf("[%d] is deleted.",head->data);
        head=head->next;
        free(temp);
    }
    else
        printf("\nStack in Underflow\n");

}

void display()
{
    struct node* temp=head;
    if(temp!=NULL)
    {
        printf("Stack is\n\t\t");
        while(temp!=NULL)
        {
            printf("%d   ",temp->data);
            temp=temp->next;
        }
    }
    else
        printf("Stack is Empty");

}

int main(void)
{
    int i,x,ch;
    do
    {
        printf("\n1-Push\n2-Pop\n3-Display\n4-Exit\n\n");
        ch=getch()-48;
        switch(ch)
        {
        case 1:
            printf("Enter element\n");
            scanf("%d",&x);
            push(x);
            break;
        case 2:
            pop();
            break;
        case 3:
            display();
            break;
        default:
            if(ch!=4)
            printf("Invalid Choice\n");

        }
    }while(ch!=4);

}
