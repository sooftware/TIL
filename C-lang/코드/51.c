#include <stdio.h>
#include "getch.h"

#define ENTER 10

void main(void)
{
 int ch;

 printf("press the key to translate to ascii\n");
 printf("Enter - program will be exit\n");

 do 
 {
	ch=getch();

	printf("c :(%c), ascii : (%d) \n", ch, ch);
 }while(ch!=ENTER);

}
