#include<stdio.h>
#include<stdlib.h>
#include<queue>
using namespace std;
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

void preTraverse(struct node* root)
{
    if(root==NULL)
        return;
        printf("%d  ",root->data);
    preTraverse(root->left);
    preTraverse(root->right);
}

void inTraverse(struct node* root)
{
    if(root==NULL)
        return;
    inTraverse(root->left);
    printf("%d  ",root->data);
    inTraverse(root->right);
}

void postTraverse(struct node* root)
{
    if(root==NULL)
        return;
    postTraverse(root->left);
    postTraverse(root->right);
    printf("%d  ",root->data);
}

int max(int h1,int h2)
{
    if(h1>h2)
        return h1;
    else
        return h2;
}

int height(struct node* root)
{
    if(root==NULL)
        return -1;
    return  max(height(root->left),height(root->right))+1;
}

int main(void)
{
    struct node* root=NULL;
    int x,mn,mx,choice;
    do
    {
        printf("\n1-Add an element in BST\t\t2-Search\t\t\t3-Find minimum element\n");
        printf("\n4-Find maximum element\t\t5-Level Order Traversal\t\t6-Pre Order Traversal\n");
        printf("\n7-In Order Traversal\t\t8-Post Order Traversal\t\t9-Height of Tree\n\n10-Exit\n\n\tSelect your choice\n");
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
                break;
            case 6:
                preTraverse(root);
                break;
            case 7:
                inTraverse(root);
                break;
            case 8:
                postTraverse(root);
                break;
            case 9:
                x=height(root);
                printf("Height of Tree is = %d",x);
                break;
            default:
                if(choice!=10)
                    printf("\nWrong choice\n");
        }
    }while(choice!=10);
    if(choice==10)
        printf("You are exit successfully\n");
}
