import java.util.Scanner;

public class FNG{
	public static void main(String[] ar){
		String A,B,C,D,aux1,aux2,aux3;
		String opB = "B";
		String opC = "C";
		String opD = "D";
		int b,c,d;
		Scanner sr = new Scanner(System.in);
		//System.out.println("\tLimpiador de GLC\n\tNOTA: Se deen de incluir 4 producciones");
		System.out.println("\tIngrese la primera produccion (A)");
		A = sr.nextLine();
		System.out.println("\tIngrese la segunda produccion (B)");		
		B = sr.nextLine();
		System.out.println("\tIngrese la tercera produccion (C)");
		C = sr.nextLine();
		System.out.println("\tIngrese la cuarta produccion (D)");
		D = sr.nextLine();
		//Se verifica el tamaño del string para saber si se contiene un terminal o llama a otros no terminales
		b = B.length();
		c = C.length();
		d = D.length();
		if(d>1){
			//Dividimos a la produccion para luego concatenar mas facil
			aux1 = D.substring(0,2);
			aux2 = D.substring(2,5);
			aux3 = D.substring(5,7);
			//Verificar con que inician las producciones para luego cambiarlas
			if('C'==aux1.charAt(0)){
				aux1 = aux1.replace("C",C);
				aux2 = aux2.replace("B",B);
			}
			else{
				aux1 = aux1.replace("B",B);
				aux2 = aux2.replace("C",C);
			}
			//Se modifica la produccion original ya con los nuevos datos
			D = aux1 + aux2 + aux3;
			//Verificamos cual sera la produccion que salvaremos
			if('C'==A.charAt(1)){
				aux1 = aux1 + opC;
				aux2 = aux2 + opC;
				A = aux1 + aux2;
				b=0;
			}
			else{
				aux1 = aux1 + opB;
				aux2 = aux2 + opB;
				A = aux1 + aux2;
				c=0;
			}
		}
		if(c>1){
			//Dividimos a la produccion para luego concatenar mas facil
			aux1 = C.substring(0,2);
			aux2 = C.substring(2,5);
			aux3 = C.substring(5,7);
			//Verificar con que inician las producciones para luego cambiarlas
			if('B'==aux1.charAt(0)){
				aux1 = aux1.replace("B",B);
				aux2 = aux2.replace("D",D);
			}
			else{
				aux1 = aux1.replace("D",D);
				aux2 = aux2.replace("B",B);
			}
			//Se modifica la produccion original ya con los nuevos datos
			C = aux1 + aux2 + aux3;
			//Verificamos cual sera la produccion que salvaremos
			if('B'==A.charAt(1)){
				aux1 = aux1 + opB;
				aux2 = aux2 + opB;
				A = aux1 + aux2;
				d=0;
			}
			else{
				aux1 = aux1 + opD;
				aux2 = aux2 + opD;
				A = aux1 + aux2;
				b=0;
			}
		}
		if(b>1){
			//Dividimos a la produccion para luego concatenar mas facil
			aux1 = B.substring(0,2);
			aux2 = B.substring(2,5);
			aux3 = B.substring(5,7);
			//Verificar con que inician las producciones para luego cambiarlas
			if('C'==aux1.charAt(0)){
				aux1 = aux1.replace("C",C);
				aux2 = aux2.replace("D",D);
			}
			else{
				aux1 = aux1.replace("D",D);
				aux2 = aux2.replace("C",C);
			}
			//Se modifica la produccion original ya con los nuevos datos
			B = aux1 + aux2 + aux3;
			//Verificamos cual sera la produccion que salvaremos
			if('C'==A.charAt(1)){
				aux1 = aux1 + opC;
				aux2 = aux2 + opC;
				A = aux1 + aux2;
				d=0;
			}
			else{
				aux1 = aux1 + opD;
				aux2 = aux2 + opD;
				A = aux1 + aux2;
				c=0;
			}
		}
		//Pruebas arriba de esta linea :3 ^^^
		//Imprimir resultados
		if(b==0){
			System.out.println("La GLC en formato de FNG es:\nA -> "+A+"\nC -> "+C+"\nD -> "+D);
		}
		if(c==0){
			System.out.println("La GLC en formato de FNG es:\nA -> "+A+"\nB -> "+B+"\nD -> "+D);
		}
		if(d==0){
			System.out.println("La GLC en formato de FNG es:\nA -> "+A+"\nB -> "+B+"\nC -> "+C);
		}
	}
}
