#include<stdio.h>
#include<stdlib.h>
#include<queue.h>

struct node
{
    int data;
    struct node* left;
    struct node* right;
};

struct node* newNode(int x)
{
    struct node* temp=(struct node*)malloc(sizeof(struct node));
    temp->data=x;
    temp->left=NULL;
    temp->right=NULL;
    return temp;
}

struct node* insert(struct node* root,int x)
{
    if(root==NULL)
    {
        root=newNode(x);
    }
    else if(root->data>x)
    {
        root->left=insert(root->left,x);
    }
    else
    {
        root->right=insert(root->right,x);
    }
    return root;
}

int search(struct node* root,int x)
{
    if(root==NULL)
        return 0;
    else if(root->data==x)
        return 1;
    else if(x<=root->data)
        return search(root->left,x);
    else
        return search(root->right,x);
}

int min(struct node* root)
{
    if(root==NULL)
        return -1;
    else if(root->left==NULL)
        return root->data;
    else
        return(min(root->left));
}

int max(struct node* root)
{
    if(root==NULL)
        return -1;
    else if(root->right==NULL)
        return root->data;
    else
        return(max(root->right));
}

void levelTraverse(struct node* root)
{
    if(root==NULL)return;
    queue<struct node*> q;
    q.push(root);
    while(!q.empty())
    {
        struct node* temp=q.front();
        printf("%d  ",temp->data);
        if(temp->left!=NULL)
        q.push(temp->left);
        if(temp->right!=NULL)
        q.push(temp->right);
        q.pop();
    }
}

int main(void)
{
    struct node* root=NULL;
    int x,mn,mx,choice;
    do
    {
        printf("\n1-Add an element in BST\n2-Search\n3-Find minimum element\n4-Find maximum element\n5-Level Order Traversal\n6-Exit\n\t\tSelect your choice\n");
        scanf("%d",&choice);
        switch(choice)
        {
            case 1:
                printf("\nEnter node value\n");
                scanf("%d",&x);
                root=insert(root,x);break;
            case 2:
                printf("Enter element to be searched  : ");
                scanf("%d",&x);
                if(search(root,x)==1)
                    printf("Element is found\n");
                else
                    printf("Not found\n");
                break;
            case 3:
                printf("\nMinimum element is  %d",min(root));
                break;
            case 4:
                printf("\nMaximum element is  %d",max(root));
                break;
            case 5:
                levelTraverse(root);
            default:
                if(choice!=6)
                    printf("\nWrong choice\n");
        }
    }while(choice!=6);
    if(choice==6)
        printf("You are exit successfully\n");
}
