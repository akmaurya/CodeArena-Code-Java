#include<stdio.h>
#include<stdlib.h>

struct node
{
    int data;
    struct node* next;
};

struct node *front, *rear;

void Enqueue(int x)
{
    struct node* temp=(struct node*)malloc(sizeof(struct node));
    temp->data=x;
    temp->next=NULL;
    if(front==NULL)
    {
        front=rear=temp;
    }
    else
    {
        rear->next=temp;
        rear=temp;
    }
}

void Dequeue()
{
    struct node* temp=front;
    if(front==NULL)
        printf("\nQueue is Empty\n");
    else
    {
        printf("[%d] is deleted from queue\n",front->data);
        front=front->next;
        free(temp);
    }
}

void Display()
{
    struct node* temp=front;
    if(front==NULL)
        printf("Queue is empty\n");
    else
    {
        while(temp!=NULL)
        {
            printf("%d  ",temp->data);
            temp=temp->next;
        }
    }
}

int main(void)
{
    int i,ch,x;
    do
    {
        printf("\n1-Enqueue\n2-Dequeue\n3-Display\n4-Exit\n");
        ch=getch()-48;
        switch(ch)
        {
            case 1:
                printf("Enter element\n");
                scanf("%d",&x);
                Enqueue(x);
                break;
            case 2:
                Dequeue();
                break;
            case 3:
                Display();
                break;
            default:
                if(ch!=4)
                    printf("Wrong Choice\n");
        }
    }while(ch!=4);
}
