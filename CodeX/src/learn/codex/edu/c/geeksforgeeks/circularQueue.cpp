#include<stdio.h>
#include<iostream>
#include<conio.h>

using namespace std;
//void add_queue();
int front=-1, rear=-1,n[10];

void add_queue()
{
    int x;
	printf("Enter number\n");
	scanf("%d",&x);
	if((rear+1)%10==front)
        printf("\nQueue is full");
    else if(front==-1)
    {
        rear=front=0;
        n[rear]=x;
    }
    else
    {
        rear=(rear+1)%10;
        n[rear]=x;
    }
}

void display()
{
	int i=0;

	if(rear==-1)
        printf("\nQueue is empty");
    else if(front<=rear)
    {
        for(i=front;i<=rear;i++)
            printf("%d  ",n[i]);
    }
    else if(front>rear)
    {
        for(i=front;i<=9;i++)
            printf("%d  ",n[i]);
        for(i=0;i<=rear;i++)
            printf("%d  ",n[i]);
    }
}

void del()
{
	int i;
	if(front==-1)
	printf("\nQueue is empty");
	else if(rear==front)
    {
        printf("\nElement is deleted");
        rear=front=-1;
    }
    else
    {
        front=(front+1)%10;
        printf("\nElement is deleted");
    }

}

int main(void)
{
	int choice;
	do
	{
		printf("\n1-Add an element in queue\n2-Display all queue element\n3-Delete  an queue element\n4-Exit\n\t\tSelect your choice\n");
		scanf("%d",&choice);
		switch(choice)
		{
			case 1:
				add_queue();break;
			case 2:
				display();break;
			case 3:
				del();
		}
	}while(choice!=4);
	if(choice==4)
		printf("You are exit successfully\n");
}
