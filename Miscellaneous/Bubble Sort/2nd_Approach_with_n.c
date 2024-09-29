#include <stdio.h>
void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

void bs(int a[], int n)
{
	int i;
    for (i = 0; i < n - 1; i++){
    int j;
        for (j = 0; j < n - i - 1; j++)
        {
            if (a[j] > a[j + 1])
                swap(&a[j], &a[j + 1]);
        }
    }
}
int main()
{
    int a[] = {5, 4, 3, 2, 1};
    int n = 5;
    bs(a, n);
    int i;
    for (i = 0; i < n; i++)
        printf("%d ", a[i]);
    return 0;
}
