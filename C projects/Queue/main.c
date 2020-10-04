#include <stdio.h>
#include <stdlib.h>

#define QUEUE_OVERFLOW 100
#define QUEUE_UNDERFLOW 200
#define OUT_OF_MEMORY 300
#define CANT_OPEN_FILE 400

typedef struct Queue {
    int * data; // pointer to dynamic array
    size_t size; // max size of stack
    size_t top; // index of top element
    size_t bottom; // index of bottom element
} queue_type;

/**
 * write parameter value to the top element of queue and increment index of top
 */
void push(queue_type *queue, const int value) {
    if (queue->top >= queue->size) {
        exit(QUEUE_OVERFLOW);
    }
    queue->data[queue->top] = value;
    queue->top++;
}

/**
 * increment index of bottom
 * @return value of the bottom-1 element of queue (because we incremented it before)
 */
int pop(queue_type *queue) {
    if (queue->bottom > queue->top) {
        exit(QUEUE_UNDERFLOW);
    }
    queue->bottom++;
    return queue->data[queue->bottom-1];
}

/**
 * create struct stack and create there dynamic array with max_size
 * @return pointer to the created stack
 */
queue_type* createQueue(size_t max_size) {
    queue_type *queue = NULL;
    queue = (queue_type*) malloc (sizeof(queue_type));
    if (queue == NULL) {
        exit(OUT_OF_MEMORY);
    }
    queue->size = max_size;
    queue->data = (int*) malloc (queue->size * sizeof(int));
    if (queue->data == NULL) {
        free(queue);
        exit(OUT_OF_MEMORY);
    }
    queue->top = 0;
    queue->bottom = 0;
    return queue;
}


/*
 * clear memory
 */
void deleteQueue(queue_type *queue) {
    free(queue->data);
    free(queue);
    queue = NULL;
}

int main() {

    FILE *Fin = NULL, *Fout = NULL; // open file to read
    Fin = fopen("queue.in", "r");
    if (Fin == NULL){
        exit(CANT_OPEN_FILE);
    }

    size_t M;
    fscanf(Fin, "%d\n", &M); // scan size of queue and create queue
    queue_type * queue;
    queue = createQueue(M);

    int value = 0; // variable to read value
    char sign = 0; // variable to read - or +
    int i; // counter

    Fout = fopen("queue.out", "w"); // open file to write
    if (Fout == NULL){
        exit(CANT_OPEN_FILE);
    }

    for(i = 0; i < M; i++){
        fscanf(Fin, "%c ", &sign); // read sign
        if(sign == '-'){
            fprintf(Fout, "%d\n", pop(queue)); // if - then write top number to the output file
        }
        if(sign=='+'){ // if + then read value from input file and add it to the top
            fscanf(Fin, "%d\n", &value);
            push(queue, value);
        }
    }

    fclose(Fin); // close files and clear memory
    fclose(Fout);
    deleteQueue(queue);

    return 0;
}