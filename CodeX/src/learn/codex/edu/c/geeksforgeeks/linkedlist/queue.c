#include<stdio.h>
#include<stdlib.h>

struct node
{
    int data;
    struct node* next;
};

struct node* front;
struct node* rear;

void enqueue(int x)
{
    struct node* temp=(struct node*)malloc(sizeof(struct node));
    temp->data=x;
    temp->next=NULL;
    if(rear==NULL && front==NULL)
    {
        front=temp;
        rear=temp;
    }
    else
    {
        rear->next=temp;
        rear=temp;
    }
}

void dequeue()
{
    if(front!=NULL)
    {
        struct node* temp=front;
        front=front->next;
        printf("[%d] is deleted from queue",temp->data);
        free(temp);
    }
    else
        printf("Queue is empty");

}

void deleterear()
{
    struct node* temp=front;
    while(temp->next->next!=NULL)
    temp=temp->next;

    free(temp->next->next);
    temp->next=NULL;
}

void display()
{
    if(front!=NULL)
    {
        struct node* temp=front;
        printf("Queue is\n\t\t");
        while(temp!=NULL)
        {
            printf("%d  ",temp->data);
            temp=temp->next;
        }
        printf("\n");
    }
    else
        printf("Queue is empty");
}

int main(void)
{
    int i,x,ch;
    do
    {
        printf("\n1-Enqueue\n2-Dequeue\n3-Display\n4-Exit\n\n");
        ch=getch()-48;
        switch(ch)
        {
        case 1:
            printf("Enter element\n");
            scanf("%d",&x);
            enqueue(x);
            break;
        case 2:
            dequeue();
            break;
        case 3:
            display();
            break;
        default:
            if(ch!=4)
            printf("Invalid Choice\n");

        }
    }while(ch!=4);

    deleterear();
    display();
deleterear();
    display();

}
