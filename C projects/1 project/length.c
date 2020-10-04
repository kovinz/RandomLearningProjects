#include "length.h"
#include <stdio.h>
#include <math.h>

Ring CreateRing(){

    Ring Lord;

    printf("Print x of center: ");
    scanf("%d", &Lord.x_center);
    printf("Print y of center: ");
    scanf("%d", &Lord.y_center);
    printf("Print x of one side: ");
    scanf("%d", &Lord.x_bigR);
    printf("Print y of one side: ");
    scanf("%d", &Lord.y_bigR);
    printf("Print x of another side: ");
    scanf("%d", &Lord.x_littleR);
    printf("Print y of another side: ");
    scanf("%d", &Lord.y_littleR);

    return Lord;
}

double CountArea(Ring Lord){

    double area;
    double firstR;
    double secondR;
    double tmp;

    firstR = sqrt(pow((double)Lord.x_center-Lord.x_bigR, 2)+pow((double)Lord.y_center-Lord.y_bigR, 2));
    secondR = sqrt(pow((double)Lord.x_center-Lord.x_littleR, 2)+pow((double)Lord.y_center-Lord.y_littleR, 2));

    if (secondR > firstR){
        tmp = secondR;
        secondR = firstR;
        firstR = tmp;
    }

    area = M_PI*((pow(firstR, 2)-pow(secondR, 2)));

    return area;
}

double CountLength(Ring Lord){

    double lenth;
    double firstR;
    double secondR;

    firstR = sqrt(pow((double)Lord.x_center-Lord.x_bigR, 2)+pow((double)Lord.y_center-Lord.y_bigR, 2));
    secondR = sqrt(pow((double)Lord.x_center-Lord.x_littleR, 2)+pow((double)Lord.y_center-Lord.y_littleR, 2));

    lenth = 2*M_PI*(firstR+secondR);

    return lenth;
}