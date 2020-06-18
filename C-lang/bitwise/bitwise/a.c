#include <stdio.h>

void main()
{
	int num = 0;

	printf("INPUT DECIMAL NUMBER : ");
	scanf("%d", &num);

	for (int i = 7; i >= 0; i--) {
		if (num & (1 << i)) {
			num += 1 << i;
		}
	}

	printf("%d", num);

	return;
}