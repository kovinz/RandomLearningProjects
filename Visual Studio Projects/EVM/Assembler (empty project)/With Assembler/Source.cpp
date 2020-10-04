#include <iostream>

int main() {
	int counter = 0;
	int* massive = new int[10];
	for (int i = 0; i < 10; i++) {
		std::cin >> massive[i];
	}

	int n;
	std::cin >> n;

	_asm {
		mov ecx, 5; // counter for loop
		
		mov eax, massive; // address of the beggining of massive to eax

		mov ebx, massive;
		add ebx, type int; // address of the second element of massive to ebx

	Loops:	
						// swap elements
		mov edx, [eax]; // move eax to edx
		XCHG edx, [ebx]; // swap edx with ebx
		mov [eax], edx; // now ebx in edx and we move it to eax

		cmp edx, n; // compare first number with n
		jne Second; // if no then go to point Second
		inc counter; // if yes then increment counter

	Second: 
		mov edx, [ebx]; // move second number to edx
		cmp edx, n; // compare second number with n
		jne Next; // if no then go to point Next
		inc counter; // if yes then increment counter

	Next: 
		add eax, 2*type int; // go to next even number
		add ebx, 2*type int; // go to next odd number

		loop Loops; // if ecx != 0 then go to point Cycle
	}

	std::cout << std::endl;
	for (int i = 0; i < 10; i++) {
		std::cout << massive[i] << " ";
	}
	std::cout << std::endl << counter;

	system("pause");
}