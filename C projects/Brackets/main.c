#include <stdio.h>
#include <stdlib.h>

#define STACK_OVERFLOW 100
#define STACK_UNDERFLOW 200
#define OUT_OF_MEMORY 300
#define CANT_OPEN_FILE 400

#define STACK_MAX_SIZE 10000

typedef struct Stack {
    char * data; // pointer to dynamic array
    size_t top; // index of top element
} stack_type;

/**
 * write parameter value to the top element of stack and increment index of top
 */
void push(stack_type *stack, const char value) {
    if(stack->top>=STACK_MAX_SIZE){
        exit(STACK_OVERFLOW);
    }
    stack->data[stack->top] = value;
    stack->top++;
}

/**
 * decrement index of top
 * @return value of the top element of stack
 */
char pop(stack_type *stack) {
    if (stack->top == 0) {
    }
    stack->top--;
    return stack->data[stack->top];
}

/**
 * create struct stack and create there dynamic array with max_size
 * @return pointer to the created stack
 */
stack_type* createStack() {
    stack_type *stack = NULL;
    stack = (stack_type*) malloc (sizeof(stack_type));
    if (stack == NULL) {
        exit(OUT_OF_MEMORY);
    }
    stack->data = (char*) malloc (STACK_MAX_SIZE * sizeof(char));
    if (stack->data == NULL) {
        free(stack);
        exit(OUT_OF_MEMORY);
    }
    stack->top = 0;
    return stack;
}

/*
 * clear memory
 */
void deleteStack(stack_type *stack) {
    free(stack->data);
    free(stack);
    stack = NULL;
}

int main() {

    FILE *Fin = NULL, *Fout = NULL; // open file to read
    Fin = fopen("brackets.in.txt", "r");
    if (Fin == NULL){
        exit(CANT_OPEN_FILE);
    }

    stack_type * stack;
    stack = createStack();

    char bracket = 0; // variable to read bracket

    Fout = fopen("brackets.out.txt", "w"); // open file to write
    if (Fout == NULL){
        exit(CANT_OPEN_FILE);
    }

    fscanf(Fin, "%c", &bracket); // read bracket

    int flag;

    while(bracket != '\0'){

        flag = 0;

        while((bracket != '\n')&&(bracket != '\0')) {

            char check;

            fscanf(Fin, "%c", &bracket); // read bracket

            if ((bracket == '(') || (bracket == '[')) {
                push(stack, bracket);
                continue;
            }

            if ((bracket == ')') || (bracket == ']')) {
                if(stack->top==0){
                    flag = 1;
                    break;
                }
                check = pop(stack);
                if ((check == '[') && (bracket == ')') || (check == '(') && (bracket == ']')) {
                    flag = 1;
                    break;
                }
            }
        }

        if((flag==0)&&(stack->top==0)){
            fprintf(Fout, "YES\n");
        }
        else{
            fprintf(Fout, "NO\n");
        }

        stack->top = 0;
    }

    fclose(Fin); // close files and clear memory
    fclose(Fout);
    deleteStack(stack);

    return 0;
}