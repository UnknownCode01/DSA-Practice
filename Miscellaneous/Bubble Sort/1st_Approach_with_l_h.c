#include <stdio.h>
void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

void bs(int a[], int l, int h)
{
	int i;
    for (i = l; i < h; i++){
    int j;
        for (j = l; j < h; j++)
        {
            if (a[j] > a[j + 1])
                swap(&a[j], &a[j + 1]);
        }
    }
}
int main()
{
    int a[] = {9, 8, 7, 6, 5, 4, 3, 2, 1};
    int n = 9;
    int l = 5, h = 8;
    bs(a, l, h);
    int i;
    for (i = 0; i < n; i++)
        printf("%d ", a[i]);
    return 0;
}
