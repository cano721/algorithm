#include <stdio.h>

int main(void){
   
   int a = 5;
   int &b = a;
   func(b);
   printf("%d",a);
   return 0;
}

int func(int &x){
   x = 3;
}