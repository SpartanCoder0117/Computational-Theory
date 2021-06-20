using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Text.RegularExpressions;

namespace Practica_3
{
    class Program
    {
        static void Main(string[] args)
        {
            while (true)
            {
                //Declaracion de la variable que contiene la expresion regular
                string pattern = "^(ab)+$";
                string cadena;
                Console.WriteLine("La expresion regular es: (ab)+");
                Console.WriteLine("Ingresa una cadena: ");
                cadena = Console.ReadLine();
                //Compara la cadena ingresada con la expresion regular
                bool resultado = Regex.IsMatch(cadena, pattern);
                //Si el resultado de la comparacion es true 
                //toma la cadena como valida
                if (resultado == true)
                {
                    Console.WriteLine("Cadena valida");
                    //Compara el primer caracter de la cadena con "a"
                    if (cadena.Substring(0,1) == "a")
                    {   
                        //Imprime las transiciones del automata 
                        Console.WriteLine("q0 ---> q1 ---> a");
                        for (int i = 1; i < cadena.Length; i++)
                        {
                            if (cadena.Substring(i,1) == "b")
                                Console.WriteLine("q1 ---> q2 ---> b");
                            else if (cadena.Substring(i,1) == "a")
                                Console.WriteLine("q2 ---> q1 ---> a");
                        }
                    }

                }
                //Si es false la cadena es invalida 
                else
                    Console.WriteLine("Cadena Invalida");
            }
            Console.ReadKey();
        }
    }
}
