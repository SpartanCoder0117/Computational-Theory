/*
Autor: Mendoza Parra Sergio, Josue Macias Castillo.
Versi�n 1.0 (4 de Junio del 2017).
Descripci�n: Hacer un Programa que simule una maquina de turing
			, el automata ya esta definido(ver reporte).
			
	Con la validacion de la cadena de caracteres se tiene que ver si:
		
	1) Si es cadena Valida
	2) Escribir una letra si es aceptada.
	3) Imprimir el arbol de derivaciones
	4) En caso de que no sea valida imprimir en donde se qued� la cadena
	
Compilaci�n: Windows:	g++ -o practica1 practica1.cpp  
			 Ubuntu:	g++ -o practica1 practica1.cpp 
Ejecuci�n: Windows practica1.exe  &  Linux ./practica1.out
*/

//LIBRERIAS
#include <iostream>
#include <string>
#include <stdlib.h>

using namespace std;

//Declaracion de funciones.
//Funciones que hacen el paso de la cadena por cada estado
void Estado_0(string cadena, int contador, string cadena2);
void Estado_1(string cadena, int contador, string cadena2);
void Estado_2(string cadena, int contador, string cadena2);
void Estado_3(string cadena, int contador, string cadena2);

/*
void Estado_3(string cadena, int contador, string cadena2);
Descripci�n: La funcion da como resultado si una cadena es valida o no
			 en dado caso de que sea valida tenemos que escribir una B.	
Recibe: string cadena y string cadena2 (el primero lleva el arbol de derivaciones de la cadena,
		el segundo hace referencia a la cadena que ser� validada por la MT).
*/
void Estado_3(string cadena, int contador, string cadena2){
	char letra[1];
	//Si en el estado 3 todavia hay un 1 o un 0, cadena no valida
	if(cadena[contador] == '1' | cadena[contador] == '0'){
		cout << cadena2;
		cout << "\nCadena no Valida";
		exit(0);
	}
	//Si en el estado 3 hay una Y, entonces se vuelve a llamar a la funcion Estado_3
	if(cadena[contador] == 'Y'){
		contador++;
		Estado_3(cadena, contador, cadena2+cadena+"  q3=>");
	}
	//Si el contador es igual al tama�o de la cadena, entonces es cadena valida
	if(contador == cadena.size()){
		cin >> letra;
		cout << cadena2+cadena+letra+"  q4";
		cout << "\n\ncadena valida\n";
		exit(0);		
	}
}

/*
void Estado_2(string cadena, int contador, string cadena2);
Descripci�n: La funcion da como resultado si una cadena es valida o no
			 en dado caso de que sea valida tenemos que escribir una B.	
Recibe: string cadena y string cadena2 (el primero lleva el arbol de derivaciones de la cadena,
		el segundo hace referencia a la cadena que ser� validada por la MT).
*/
void Estado_2(string cadena, int contador, string cadena2){
	//Si en el estado 2 hay un 0 entonces se vuelve a llamar a la funcion y se hace un decremento
	if(cadena[contador] == '0'){
		contador--;
		Estado_2(cadena, contador, cadena2+cadena+"  q2=>");
	}
	//Si en la cadena hay una X se pasa al estado 0
	if(cadena[contador] == 'X'){
		contador++;
		Estado_0(cadena, contador, cadena2+cadena+"  q0=>");
	}
	//Si en la cadena hay una Y se pasa al estado 2 
	if(cadena[contador] == 'Y'){
		contador--;
		Estado_2(cadena, contador, cadena2+cadena+"  q2=>");
	}
}

/*void Estado_1(string cadena, int contador, string cadena2);
Descripci�n: La funcion da como resultado si una cadena es valida o no
			 en dado caso de que sea valida tenemos que escribir una B.	
Recibe: string cadena y string cadena2 (el primero lleva el arbol de derivaciones de la cadena,
		el segundo hace referencia a la cadena que ser� validada por la MT).
*/
void Estado_1(string cadena, int contador, string cadena2){
	//Si en la cadena hay un 0 entonces se pasa al estado 1
	if(cadena[contador] == '0'){
		contador++;
		Estado_1(cadena, contador, cadena2+cadena+"  q1=>");
	}
	//Su hay un 1 en la cadena entonces se remplaza por una Y
	if(cadena[contador] == '1'){
		cadena[contador] = 'Y';
		contador--;
		Estado_2(cadena, contador, cadena2+cadena+"  q2=>");
	}
	//Si hay una Y en la cadena entonces se pasa al estado 1
	if(cadena[contador] == 'Y'){
		contador++;
		Estado_1(cadena, contador, cadena2+cadena+"  q1=>");
	}
	//Si esta en el estado 1 y el contador es igual que el tama�o de la cadena, entonces no es valida
	if(contador >= cadena.size()){
		cout << cadena2;
		cout << "\nCadena no Valida";
		exit(0);
	}
}

/*void Estado_0(string cadena, int contador, string cadena2);
Descripci�n: La funcion da como resultado si una cadena es valida o no
			 en dado caso de que sea valida tenemos que escribir una B.	
Recibe: string cadena y string cadena2 (el primero lleva el arbol de derivaciones de la cadena,
		el segundo hace referencia a la cadena que ser� validada por la MT).
*/
void Estado_0(string cadena, int contador, string cadena2){
	//Si en la cadena todavia hay un 1, entonces la cadena no es valida
	if(cadena[contador] == '1'){
		cout << "\nCadena no Valida";
		exit(0);
	}
	//Si en la cadena hay un 0, entonces se pasa al estado 1
	if(cadena[contador] == '0'){
		cadena[contador] = 'X';	
		contador++;
		Estado_1(cadena, contador, cadena2+cadena+"  q1=>");	
	}
	//Si en la cadena hay una X entonces se pasa al estado 0
	if(cadena[contador] == 'X'){
		contador++;
		Estado_0(cadena, contador, cadena2+cadena+"  q0=>");
	}	
	//Si en la cadena hay una Y, entonces se pasa al estado 3 
	if(cadena[contador] == 'Y'){
		contador++;
		Estado_3(cadena, contador, cadena2+cadena+"  q3=>");
	}
}

int main(){
	string cadena;
	int contador = 0;
	cin >> cadena;
	//Si la cadena es vacia no es valida, tiene que ser mayor a 1
	if(cadena[contador] == 'e' | cadena[contador] == 'E'){
		cout << "\nCadena no Valida";
		exit(0);
	}
	//Si la cadena es de tama�o 1 entonces no es valida
	if(cadena.size() == 1){
		cout << "\nCadena no Valida";
		exit(0);
	}
	//Si la cadena es mayor o igaul a 2 en tama�o, entonces se pasa al estado 0, para evaluar
	if(cadena.size() >= 2){
		Estado_0(cadena, contador, "S=>"+cadena+"  q0=>");
	}			
}