#include <iostream>



int main(){
	int* arr = new int[10];
	for (int i = 0; i < 10; i++)
		std::cin >> arr[i];

	int counter = 0, n;
	std::cin >> n;

	_asm{
		mov eax, arr; //перемещение адреса начала массива в аккумулятор
		mov ecx, 5; //счетчик
		
		mov ebx, arr;
		add ebx, type int; //перенос адреса конца массива в регистр базы

		Cycle :
		//swap
		mov edx, [eax];// помещаем в регистр данных значение аккумулятора
		XCHG edx, [ebx]; //меняем значение регистра данных и регистра базы
		mov [eax], edx; //делаем значение аккумулятора равным значению регистра данных 

		cmp edx, n; //проверка на равенство значения аккумулятора (хранится в edx) и числа n
		jne Second; //если не равны, е число в регистре проверяем второе число в регистре базы
		inc counter; //если равны уменьшаем счётчик

		Second : //такие же операции для второго
		mov edx, [ebx];
		cmp edx, n;
		jne Index;
		inc counter;

		Index : //изменяем значение индексов
		add eax, type int;
		add ebx, type int;

		loop Cycle; //если счётчик не закончился переходим к метке Cycle

	}

	for (int i = 0; i < 10; i++) {
		std::cout << arr[i] << " ";
	}
	std::cout << std::endl << counter;

	system("pause");
}