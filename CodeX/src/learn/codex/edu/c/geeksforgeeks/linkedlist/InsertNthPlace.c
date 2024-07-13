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

void insertAt(int x,int place)
{
    int i=2;
    if(front!=NULL)
    {
        if(place==1)
        {
            struct node* temp1=(struct node*)malloc(sizeof(struct node));
            temp1->data=x;
            temp1->next=front;
            front=temp1;
        }
        struct node* temp=front;
        while(temp!=NULL&&place>1)
        {
            if(i==place)
            break;
            temp=temp->next;
            printf("%d  ",temp->data);
            i++;
        }
        if(i==place)
        {
            struct node* temp1=(struct node*)malloc(sizeof(struct node));
            temp1->data=x;
            temp1->next=temp->next;
            temp->next=temp1;
        }
        else
            printf("\nInvalid Place");
    }
    else
        printf("Queue is Empty");
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
    int i,x,ch,place;
    do
    {
        printf("\n1-Enqueue\n2-Dequeue\n3-Insert at Nth place\n4-Display\n5-Exit\n\n");
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
            printf("Enter the place where you want to insert");
            scanf("%d",&place);
            printf("\nEnter element\n");
            scanf("%d",&x);
            insertAt(x,place);
            break;
        case 4:
            display();
            break;
        default:
            if(ch!=5)
            printf("Invalid Choice\n");

        }
    }while(ch!=5);

}
