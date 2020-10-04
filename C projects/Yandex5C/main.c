#include <stdio.h>

int main() {

    int k = 0;
    int m = 0;
    int d = 0;
    int quantity = 1;
    int flag = 0;
    int k_holidays = 0;

    FILE *Fin, *Fout;

    Fin = fopen("input.txt", "r");

    fscanf(Fin, "%d %d %d", &k, &m, &d);

    while(1){
        switch (d) {
            case 1:
            case 2:
            case 3:
            case 4:
                if(k >= quantity){
                    quantity++;
                    d++;
                }
                else if((k + m) >= quantity){
                    m -= (quantity - k);
                    quantity++;
                    d++;
                }
                else{
                    flag = 1;
                }
                break;

            case 5:
                k_holidays = k;
                if (k_holidays >= quantity){
                    d++;
                    k_holidays -= quantity;
                    quantity++;
                }
                else if((k_holidays + m) >= quantity){
                    m -= (quantity - k_holidays);
                    d++;
                    quantity++;
                    k_holidays = 0;
                }
                else{
                    flag = 1;
                }
                break;
            case 6:
            case 7:
                if (k_holidays >= quantity){
                    d++;
                    if(d == 8){
                        d = 1;
                    }
                    k_holidays -= quantity;
                    quantity++;
                }
                else if ((k_holidays + m) >= quantity){
                    m -= (quantity - k_holidays);
                    d++;
                    if(d == 8){
                        d = 1;
                    }
                    k_holidays = 0;
                    quantity++;
                }
                else{
                    flag = 1;
                }
                break;
            default:
                flag = 1;
                break;
        }
        if (flag == 1){
            break;
        }
    }
    Fout = fopen("output.txt", "w");
    fprintf(Fout, "%d", --quantity);

    return 0;
}