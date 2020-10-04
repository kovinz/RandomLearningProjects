#include <stdio.h>
#include <stdlib.h>

typedef struct pair{
    unsigned char first : 4;
    unsigned char second : 4;
} pair;

typedef struct storage{
    int quantity;
    pair *numbers;
} storage;

void add(storage* pairs){
    int tmp = 0;
    pairs->quantity += 1;
    pairs->numbers = (pair*) realloc (pairs->numbers, pairs->quantity + 1);

    printf("print first number to add: ");
    scanf("%d", &tmp);
    pairs->numbers[pairs->quantity].first = tmp;

    printf("print second number to add: ");
    scanf("%d", &tmp);
    pairs->numbers[pairs->quantity].second = tmp;
}

int find(storage* pairs){
    int first = 0;
    int second = 0;
    int i = 0;

    printf("print first number to find: ");
    scanf("%d", &first);
    printf("print first number to find: ");
    scanf("%d", &second);

    for (i = 0; i <= pairs->quantity; i++){
        if ((first == pairs->numbers[i].first)&&(second == pairs->numbers[i].second)){
            return i;
        }
    }
    return -1;
}

void delete(storage* pairs){
    int index = 0;
    int i = 0;
    printf("print index of pair to delete: ");
    scanf("%d", &index);

    for(i = index; i < pairs->quantity; i++){
        pairs->numbers[i].first = pairs->numbers[i + 1].first;
        pairs->numbers[i].second = pairs->numbers[i + 1].second;
    }

    pairs->quantity--;
    pairs->numbers = (pair*) realloc (pairs->numbers, pairs->quantity + 1);
}

void write(storage* pairs){
    int i = 0;
    FILE *Fout;
    Fout = fopen("pairs.output.bin", "wb");

    fwrite(pairs->numbers, sizeof(char), pairs->quantity + 1, Fout);
}

storage* read(){
    FILE *Fin;
    Fin = fopen("pairs.input.bin", "rb");

    int N = 0;
    int number = 0;
    int i;
    fread(&N, sizeof(char), 1, Fin);
    storage* pairs;
    pairs = (storage*) malloc (sizeof(storage));
    pairs->quantity = N - 1;
    pairs->numbers = (pair*) malloc ((pairs->quantity + 1) * sizeof(pair));

    for (i = 0; i <= pairs->quantity; i++){
        fread(&number, sizeof(char), 1, Fin);
        pairs->numbers[i].first = number;
        pairs->numbers[i].second = number >> 4;
    }

    fclose(Fin);
    return pairs;
}

int main(){
    int tmp;

    storage* pairs;
    pairs = (storage*) malloc (sizeof(storage));

    pairs->numbers = (pair*) malloc (sizeof(pair));
    pairs->quantity = 0;

    printf("print first number: ");
    scanf("%d", &tmp);
    pairs->numbers->first = tmp;

    printf("print second number: ");
    scanf("%d", &tmp);
    pairs->numbers->second = tmp;

    add(pairs);
    add(pairs);
    add(pairs);
    write(pairs);

    return 0;
}