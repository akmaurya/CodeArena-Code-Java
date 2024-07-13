#include<stdio.h>
#include<stdlib.h>

struct node
{
    int data;
    struct node* next;
};

struct node* head;

void Push(int x)
{
    struct node* temp=(struct node*)malloc(sizeof(struct node));
    temp->data=x;
    temp->next=head;
    head=temp;
}

void Pop()
{
    struct node* temp=head;
    if(head==NULL)
        printf("\nStack is underflow");
    else
    {
        printf("[%d] is pop from stack\n");
        head=head->next;
        free(temp);
    }

}

void Display()
{
    struct node* temp=head;
    if(head==NULL)
        printf("\nStack is underflow");
    else
    {
        printf("Stack is\n");
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
        printf("\n1-Push\n2-Pop\n3-Display\n4-Exit\n");
        ch=getch()-48;
        switch(ch)
        {
            case 1:
                printf("Enter element\n");
                scanf("%d",&x);
                Push(x);
                break;
            case 2:
                Pop();
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
