/*
광운대학교 18년도 2학기 공학수학2 HomeWork10
2014707073 김수환
NxN행렬의 역행렬 구하기 및 확인
*/
#include <stdio.h>
#include <time.h>
#include <stdlib.h>

time_t s1, s2;

void printMatrix(int** matrix, int size);
int det2(int** matrix);
int makeSMatrix(int **matrix, int size, int x, int y);
int determinant(int** matrix, int size);
int isOdd(int i, int j);
int adjoint(int** matrix, int size);
void makeInverseMatrix(float** inverseMatrix, int** matrix, int det, int size);
void printMatrixFloat(float** matrix, int size);
void checkMatrix(float** inverseMatrix, int** originMatrix, int size);
float mulMatrix(int** matrix, float** inverseMatrix, int size, int i, int j);
float mulInverseMatrix(int** matrix, float** inverseMatrix, int size, int i, int j);
void checkInverseMatrix(float** inverseMatrix, int** originMatrix, int size);
void inputMatrixValue(int** matrix, int size);
void makeInverseMatrixSize2(float** inverseMatrix, int** copyOriginMatrix, int det, int size);

void main() {
	time(&s1);
	int size = 0;
	int det;
	double takeTime = 0.0;
	int** originMatrix;	//	기존의 행렬
	float** inverseMatrix;	//	역행렬
	int** copyOriginMatrix;	//	기존행렬 복사
	int i = 0, j = 0;

	printf("행렬 크기 : ");
	scanf_s("%d", &size);

	/* 행렬들 동적할당 */

	originMatrix = (int**)malloc(sizeof(int*)*size);
	for (i = 0; i < size; i++) {
		originMatrix[i] = (int*)malloc(sizeof(int)*size);
	}

	inverseMatrix = (float**)malloc(sizeof(float*)*size);
	for (i = 0; i < size; i++) {
		inverseMatrix[i] = (float*)malloc(sizeof(float)*size);
	}
	/* 행렬들 동적할당 */


	inputMatrixValue(originMatrix, size);
	printf("## 기존 행렬\n\n");
	printMatrix(originMatrix, size);
	printf("## determinant : ");
	copyOriginMatrix = copyMatrix(originMatrix, size);
	det = determinant(originMatrix, size);
	printf("%d\n\n\n", det);

	if (determinant == 0) {
		printf("## 역행렬이 존재하지 않습니다!!\n");
		time(&s2);
		takeTime = difftime(s2, s1);
		printf("걸린 시간 : %f\n", takeTime);
		return;
	}
	else {
		if (size == 2) {
			makeInverseMatrixSize2(inverseMatrix, copyOriginMatrix, det, size);
		}
		else {
			copyOriginMatrix = adjoint(copyOriginMatrix, size);
			makeInverseMatrix(inverseMatrix, copyOriginMatrix, det, size);
		}
		printf("## 역행렬\n\n");
		printMatrixFloat(inverseMatrix, size);
		checkMatrix(inverseMatrix, originMatrix, size);
		checkInverseMatrix(inverseMatrix, originMatrix, size);
		time(&s2);
		takeTime = difftime(s2, s1);
		printf("걸린 시간 : %f\n", takeTime);
		return;
	}
}

/* 사이즈가 2일때의 역행렬 생성 */
void makeInverseMatrixSize2(float** inverseMatrix, int** copyOriginMatrix, int det, int size) {
	int i = 0, j = 0;

	inverseMatrix[0][0] = (float)copyOriginMatrix[1][1];
	inverseMatrix[0][1] = -(float)copyOriginMatrix[0][1];
	inverseMatrix[1][0] = -(float)copyOriginMatrix[1][0];
	inverseMatrix[1][1] = (float)copyOriginMatrix[0][0];

	for (i = 0; i < size; i++) {
		for (j = 0; j < size; j++) {
			inverseMatrix[i][j] = ((inverseMatrix[i][j]) / (float)det);
		}
	}

	return;
}

void inputMatrixValue(int** matrix, int size) {
	int n = 0;
	int i = 0, j = 0;
	for (i = 0; i < size; i++) {
		for (j = 0; j < size; j++) {
			printf("%d행 %d열의 원소를 입력해주세요 : ", i + 1, j + 1);
			scanf_s("%d", &n);
			matrix[i][j] = n;
		}
	}


	return;
}

void printMatrix(int** matrix, int size) {
	int i = 0, j = 0;
	for (i = 0; i < size; i++) {
		for (j = 0; j < size; j++) {
			printf("%d\t", matrix[i][j]);
		}
		printf("\n");
	}
	printf("\n");
}

void printMatrixFloat(float** matrix, int size) {
	int i = 0, j = 0;
	for (i = 0; i < size; i++) {
		for (j = 0; j < size; j++) {
			printf("%f\t", matrix[i][j]);
		}
		printf("\n");
	}
	printf("\n");
}

int copyMatrix(int** originMatrix, int size) {
	int** copyOriginMatrix;
	int i = 0, j = 0;

	copyOriginMatrix = (int**)malloc(sizeof(int*)*size);
	for (i = 0; i < size; i++) {
		copyOriginMatrix[i] = (int*)malloc(sizeof(int)*size);
	}


	for (i = 0; i < size; i++) {
		for (j = 0; j < size; j++) {
			copyOriginMatrix[i][j] = originMatrix[i][j];
		}
	}

	return copyOriginMatrix;
}

int det2(int** matrix) {
	int det;

	det = matrix[1][1] * matrix[0][0] - matrix[1][0] * matrix[0][1];	//	ad-bc

	return det;
}

int makeSMatrix(int **matrix, int size, int x, int y) {
	int** sMatrix;
	int i = 0, j = 0, newI = 0, newJ = 0;
	/*
	제외해줄 x,y 행과 열을 입력인자로 받으면
	새로운 배열은 기존 행렬 size보다 행과열이 하나씩 작아야 하므로 동적할당으로 size-1로 설정해준다.
	그리고 matrix의 원소들을 newMatrix의 원소로 넣어주는데 제외해주는 x,y줄에 해당한다면 그냥 넘어가도록 해준다
	*/

	sMatrix = (int**)malloc(sizeof(int*)*(size - 1));
	for (i = 0; i < size - 1; i++) {
		sMatrix[i] = (int*)malloc(sizeof(int)*(size - 1));
	}

	for (i = 0, newI = 0; i < size; i++) {
		if (i == x) {
			continue;
		}
		for (j = 0, newJ = 0; j < size; j++) {
			if (j == y) {
				continue;
			}
			else {
				sMatrix[newI][newJ] = matrix[i][j];
				newJ++;
			}
		}
		newI++;
	}
	return sMatrix;
}

int determinant(int** matrix, int size) {
	int det = 0;
	int i = 0, j = 0;

	for (i = 0; i < size; i++) {
		if (isOdd(0, i)) {
			if (size == 3) {
				det -= matrix[0][i] * det2(makeSMatrix(matrix, size, 0, i));
			}
			else if (size == 2) {
				det = det2(matrix);
			}
			else {
				det -= matrix[0][i] * determinant(makeSMatrix(matrix, size, 0, i), size - 1);
			}
		}
		else {
			if (size == 3) {
				det += matrix[0][i] * det2(makeSMatrix(matrix, size, 0, i));
			}
			else if (size == 2) {
				det = det2(matrix);
			}
			else {
				det += matrix[0][i] * determinant(makeSMatrix(matrix, size, 0, i), size - 1);
			}
		}
	}

	return det;
}

int isOdd(int i, int j) {
	if ((i + j) % 2) return 1;
	else return 0;
}

int adjoint(int** matrix, int size) {
	int** copyOriginMatrix;
	int i = 0, j = 0;
	copyOriginMatrix = copyMatrix(matrix, size);	//	기본 행렬 카피
	/*
	adjoint행렬을 만들기 위해서는
	① 행렬안의 원소의 행과 열을 제외한 sMatrix함수를 만들어 해당 sMatrix함수에대하여 determinant를 한다.
	② determinant를 한 값들에 대하여 행과 열의 합이 짝수라면 양의값, 홀수라면 음수값으로 바꿔준다.
	③ ②에서 나온 행렬들에 대하여 transpose해준다.
	*/

	/* ① 행렬안의 원소의 행과 열을 제외한 sMatrix함수를 만들어 해당 sMatrix함수에대하여 determinant를 한다. */
	for (i = 0; i < size; i++) {
		for (j = 0; j < size; j++) {
			if (size == 3) {	//	성공
				copyOriginMatrix[i][j] = det2(makeSMatrix(matrix, size, i, j));
			}
			else {
				copyOriginMatrix[i][j] = determinant(makeSMatrix(matrix, size, i, j), size - 1);
			}
		}
	}

	/* ② determinant를 한 값들에 대하여 행과 열의 합이 짝수라면 양의값, 홀수라면 음수값으로 바꿔준다. */
	for (i = 0; i < size; i++) {
		for (j = 0; j < size; j++) {
			if (isOdd(i, j)) {
				copyOriginMatrix[i][j] = (-copyOriginMatrix[i][j]);
			}
		}
	}

	/* ③ ②에서 나온 행렬들에 대하여 transpose해준다. */
	for (i = 0; i < size; i++) {
		for (j = 0; j < size; j++) {
			matrix[i][j] = copyOriginMatrix[j][i];
		}
	}

	return matrix;
}

void makeInverseMatrix(float** inverseMatrix, int** matrix, int det, int size) {
	int i = 0, j = 0;
	for (i = 0; i < size; i++) {
		for (j = 0; j < size; j++) {
			inverseMatrix[i][j] = ((float)matrix[i][j] / (float)det);
		}
	}

	return;
}

void checkMatrix(float** inverseMatrix, int** originMatrix, int size) {
	float** resultMatrix;
	int i = 0, j = 0;
	resultMatrix = (float**)malloc(sizeof(float*)*size);
	for (i = 0; i < size; i++) {
		resultMatrix[i] = (float*)malloc(sizeof(float)*size);
	}

	printf("## 곱하기\n\n");
	for (i = 0; i < size; i++) {
		for (j = 0; j < size; j++) {
			resultMatrix[i][j] = mulMatrix(originMatrix, inverseMatrix, size, i, j);
		}
	}

	printMatrixFloat(resultMatrix, size);
}

float mulMatrix(int** matrix, float** inverseMatrix, int size, int i, int j) {
	float result = 0;
	int k = 0;
	for (k = 0; k < size; k++) {
		result += (matrix[i][k] * inverseMatrix[k][j]);
	}

	return result;
}

float mulInverseMatrix(int** matrix, float** inverseMatrix, int size, int i, int j) {
	float result = 0;
	int k = 0;
	for (k = 0; k < size; k++) {
		result += (inverseMatrix[k][j] * matrix[i][k]);
	}

	return result;
}

void checkInverseMatrix(float** inverseMatrix, int** originMatrix, int size) {
	float** resultMatrix;
	int i = 0, j = 0;
	resultMatrix = (float**)malloc(sizeof(float*)*size);
	for (i = 0; i < size; i++) {
		resultMatrix[i] = (float*)malloc(sizeof(float)*size);
	}

	printf("## 반대로곱하기\n\n");
	for (i = 0; i < size; i++) {
		for (j = 0; j < size; j++) {
			resultMatrix[i][j] = mulInverseMatrix(originMatrix, inverseMatrix, size, i, j);
		}
	}

	printMatrixFloat(resultMatrix, size);
}