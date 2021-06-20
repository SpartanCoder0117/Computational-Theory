using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Text.RegularExpressions;

namespace Practica_4
{
    class Program
    {
        //Variables globales para validar
        const int valido = 1;
        const int invalido = 0;

        static void Main(string[] args)
        {
            //Declaracion de variables a usar
            string cadena;
            int n;
            //int opcion = 0;
            char[] caracteres;
            string patron = "^([a-z]+|[2-9]+|[A-Z]+)$";

            Console.WriteLine("Expresion GLC");
            Console.ForegroundColor = ConsoleColor.Yellow;
            Console.WriteLine(" S --> 11|00|1S1|0S0");
            Console.ForegroundColor = ConsoleColor.Gray;

            while (true)
            {
                //Da color a las letras
                Console.ForegroundColor = ConsoleColor.Gray;
                //El programa pide una cadena
                Console.WriteLine("Ingresa una cadena: ");
                Console.ForegroundColor = ConsoleColor.DarkCyan;
                cadena = Console.ReadLine();

                caracteres = new char[cadena.Length];

                //Valida si la cadena es binaria
                bool validacion = Regex.IsMatch(cadena, patron);


                //En caso de ser falso hace la operacion para comprobar si es palindromo 
                if (validacion == false)
                {
                    caracteres = cadena.ToCharArray(0, cadena.Length);
                    if (verificar(0, caracteres, cadena.Length) == valido)
                    {
                        Console.ForegroundColor = ConsoleColor.Green;
                        Console.WriteLine("La cadena es valida");
                    }
                    else
                    {
                        Console.ForegroundColor = ConsoleColor.Red;
                        Console.WriteLine("La cadena es invalida");
                    }

                }
                //En caso contrario muestra un mensaje de error
                else
                {
                    Console.ForegroundColor = ConsoleColor.DarkRed;
                    Console.WriteLine("La cadena debe ser binaria");
                }
            }
            Console.ReadKey();
        }

        //Funcion que compara las letras de inicio a fin
        static int verificar(int pos, char[] palabra, int largo)
        {
            //Primera condición, si la palabra en su posición 0 es igual a la ultima
            if (palabra[pos] == palabra[largo - pos - 1])
            {
                //Aquí solo nos indica que si las pos es menor que largo - pos entra e incrementa pos
                //cuando llega al centro de la palabra, nos indica que es un palindrome
                if (pos < largo - pos)
                    return (verificar(++pos, palabra, largo));
                else
                    return (valido);
            }
            //Si no entra al if en donde se comaparan los caracteres
            return (invalido);
        }
    }
}
