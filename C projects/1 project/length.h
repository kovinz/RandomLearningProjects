#ifndef INC_1_PROJECT_LENGTH_H
#define INC_1_PROJECT_LENGTH_H

#endif //INC_1_PROJECT_LENGTH_H

typedef struct{
    int x_center;
    int y_center;
    int x_bigR;
    int y_bigR;
    int x_littleR;
    int y_littleR;
} Ring;

Ring CreateRing();

double CountArea(Ring);

double CountLength(Ring);