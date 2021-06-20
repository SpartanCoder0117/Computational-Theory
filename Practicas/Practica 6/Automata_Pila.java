/*
Autor: Mendoza Parra Sergio y Paz Sanchez Brandon.
Versión 1.0 (14 de Mayo del 2017).
Descripción: Hacer un programa que valide una palabra es aceptada o no dado su automata(ver en el reporte)

Se tiene que utilizar estructura de datos "Pila".

Compilación: Windows:	javac ExpresionRegular.java  

Ejecución: Windows:     java ExpresionRegular 
*/

//LIBRERIAS
import java.util.Scanner.*;
import java.util.*;
import java.util.Stack;


public class Automata_Pila{
	/*
	Boolean vacio(Stack <String> Pila)
	Descripción: Valida si la pila esta vacia o no y retorna falso o verdadero.
	Recibe: una pila(Referencia a los elementos que hay ingresados)
	*/
	public static boolean vacio(Stack <String> Pila){
		if(!Pila.empty())
			return false;
		else
			return true;
	}
	
	/*
	Void Automata(String cadena, Stack <String> Pila, int contador, String cadena2)
	Descripción: Esta funcion en la que lleva a cabo las  derivaciones por las que pasa el automata.
	Recibe: una cadena que es la palabra que se ingreso para evaluarla, tambien recibe una pila para ingresar elementos en ella
			un contador el cual nos sirve para ir recorriendo la palabra letra por letra e irla validando y por ultimo 
			una cadena que hace referencia a las transiciones que se hacen en el automata. 
	*/
	public static void Automata(String cadena, Stack <String> Pila, int contador, String cadena2){
		String aux1 = "=>1";
		String aux2 = "=>2";
		String aux3 = "=>3";
		String aux6 = "Aa|AA";
		String aux7 = "Ba|BA";
		String aux8 = "Ab|AB";
		String aux9 = "Bb|BB";
		String aux10 = "Zo|e";
		String aux11 = "Aa|e";
		String aux12 = "Bb|e";
		//Solo se valida si el contador no sobrepasa el tamaño de la palabra
		if(contador < cadena2.length()){
			if('a' == cadena2.charAt(contador)){
				//Si la Pila no está vacia.
				if(!vacio(Pila)){
					//Si en el tope de la pila hay una A se hace un pop de la misma
					if("A" == Pila.peek()){
						Pila.pop();
						contador++;
						Automata(cadena + aux2 + "  " + aux11, Pila, contador, cadena2);	
					}
					//Si en el tope de la pila hay una B se hace un push de A
					if("B" == Pila.peek()){
						Pila.push("A");
						contador++;
						Automata(cadena + aux1 + "  " + aux7, Pila, contador, cadena2);
					}
					//Si se quiere ingresar una letra pero solo hay un Zo en la pila la cadena no es aceptada
					if("Zo" == Pila.peek()){
						System.out.println(cadena + aux2);
						System.out.println("Cadena no aceptada");
						System.out.print("\n");
						System.out.println("Elementos de la Pila");	
						System.out.print("\n");
						//Se imprimen los elementos de la pila	
						while(!Pila.empty()){
							System.out.println(Pila.peek());
							Pila.pop();
						}
						System.exit(0);	
					}
				}
			}
			if('b' == cadena2.charAt(contador)){
				//Si la pila no está vacia
				if(!vacio(Pila)){
					//Si en el tope de la pila hay una A entonces se hace un push de B
					if("A" == Pila.peek()){
						Pila.push("B");
						contador++;
						Automata(cadena + aux1 + "  " + aux8, Pila, contador, cadena2);	
					}
					//Si en el tope de la pila hay una B entonces se hace un pop de la misma
					if("B" == Pila.peek()){
						Pila.pop();
						contador++;
						Automata(cadena + aux2 + "  " + aux12, Pila, contador, cadena2);
					}
					//Si se quiere ingresar una letra pero solo hay un Zo en la pila la cadena no es aceptada
					if("Zo" == Pila.peek()){
						System.out.println(cadena + aux2);
						System.out.println("Cadena no aceptada");
						System.out.print("\n");
						System.out.println("Elementos de la Pila");	
						System.out.print("\n");
						//Se imprimen los elementos de la pila	
						while(!Pila.empty()){
							System.out.println(Pila.peek());
							Pila.pop();
						}
						System.exit(0);	
					}
				}
			}
		}
		//Si el contador es igual al tamaño de la palabra
		if(contador == cadena2.length()){
			//Si solo quedó un Zo en la pila la cadena es aceptada
			if("Zo" == Pila.peek()){
				System.out.println(cadena + aux3 + "  " + aux10);
				System.out.println("\tcadena aceptada");
			}
			//Si en el tope no esta Zo la cadena no es aceptada
			if("Zo" != Pila.peek()){
				System.out.println(cadena);
				System.out.println("\tcadena no aceptada");
			}
			System.out.print("\n");
			System.out.println("Elementos de la Pila");	
			System.out.print("\n");	
			//Se imprimen los elementos de la pila
			while(!Pila.empty()){
				System.out.println(Pila.peek());
				Pila.pop();
			}
			System.exit(0);
		}
	}
	public static void main(String args[]){
		Stack <String> Pila = new Stack <String>();
		Scanner sr = new Scanner(System.in);
		String aux1 = "=>1";
		String aux4 = "Zoa|ZoA";
		String aux5 = "Zob|ZoB";
		String cadena;
		int contador = 0;
		String aux = "S";
		cadena = sr.nextLine();
		if(cadena.length() == 1){
			if('a' == cadena.charAt(contador)){
				Pila.push("Zo");
				Pila.push("A");
				System.out.println(aux + aux1 + "  " + aux4);
			}
			if('b' == cadena.charAt(contador)){
				Pila.push("Zo");
				Pila.push("B");
				System.out.println(aux + aux1 + "  " + aux5);
			}
			System.out.print("\n");
			System.out.println("Pila");
			System.out.print("\n");
			while(!Pila.empty()){
				System.out.println(Pila.peek());
				Pila.pop();
			}
		}
		if(cadena.length() >= 2){		
			if('a' == cadena.charAt(contador)){
				Pila.push("Zo");
				Pila.push("A");
				contador++;
				Automata(aux + aux1 + "  " + aux4, Pila, contador, cadena);
			}	
			if('b' == cadena.charAt(contador)){
				Pila.push("Zo");
				Pila.push("B");
				contador++;
				Automata(aux + aux1 + "  " + aux5, Pila, contador, cadena);
			}
		}				
	}
}