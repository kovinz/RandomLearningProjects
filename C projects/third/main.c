#include <stdio.h>
#include <stdlib.h>

void merge(int[], int, int, int, long long*);
void mergeSort(int array[], int first, int last, long long*);

void mergeSort(int array[], int first, int last, long long* count){ // recursive algorithm to sort the array

    int middle;

    if (first < last) {

        middle = (first + last) / 2; // find index of the middle element

        mergeSort(array, first, middle, count); // goes the algorithm for the first half

        mergeSort(array, middle, last, count); // for the second

        merge(array, first, middle, last, count); // sort array
    }
}

void merge(int array[], int first, int middle, int last, long long* count){

    int* sorted = (int*) malloc ((last - first) * sizeof(int)); // malloc array for the partly sorted one

    int i = 0;
    int j = 0;
    int k = 0;

    while (((first + i) < middle) && ((middle + j) < last)) //compare two elements and write the least one to sorted array
    {
        if (array[first + i] < array[middle + j]){

            sorted[i + j] = array[first + i];
            i++;
        }

        else {

            sorted[i + j] = array[middle + j];
            j++;
            *count += 1; // increase the number of inversion
        }
    }

    while (first + i < middle){ // write the remaining elements of the first half to sorted array

        sorted[i + j] = array[first + i];
        i++;
    }

    while (middle + j < last){ // of the second one

        sorted[i + j] = array[middle + j];
        j++;
    }

    for (k; k < (i + j); k++){ // write sorted array to the initial one
        array[first + k] = sorted[k];
    }
    free(sorted);
}

int main()
{
    FILE *Fin, *Fout;

    int quan;
    int i;
    int *array;
    long long count;

    Fin = fopen("sort.in.txt", "r");

    fscanf(Fin, "%d\n", &quan); // read how many elements in the file

    array = (int*) malloc (quan * sizeof(int)); // malloc array to read elements

    for(i = 0; i < quan; i++) { // read elements
        fscanf(Fin, "%d ", &array[i]);
    }

    fclose(Fin);

    mergeSort(array, 0, quan, &count); // sort array

    Fout = fopen("sort.out.txt", "w");

    fprintf(Fout, "%lli", count);

    fclose(Fout);

    free(array);

    return 0;
}