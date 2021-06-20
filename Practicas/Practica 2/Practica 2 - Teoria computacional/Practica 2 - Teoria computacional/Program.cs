/*
AUTOR: Josue Macias Castillo (C) Marzo 2016, 2CM1
VERSIÓN: 1.0

DESCRIPCIÓN: Programa que valida una cadena numerica con ayuda de expresiones regulares

OBSERVACIONES:
No acepta cadenas de puros ceros
*/

//LIBRERIAS
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Text.RegularExpressions;


namespace Practica2_Teoria
{
    //CLASE PRINCIPAL
    class Program
    {
        //PROGRAMA PRINCIPAL MAIN
        static void Main(string[] args)
        {
            //DECLARACION DE VAARIABLES
            //Expresion regular para validar cadena
            string patron = "^([0-9]{4,12})$";
            //Expresion regular para verificar que todos los caracteres sean diferentes de cero
            string patron2 = "^(0)*$";
            string numero;

            //Ciclo infinito para que el usuario pruebe muchas respuestas a la vez
            while (true)
            {
                //Ingreso y lectura de datos
                Console.WriteLine("Ingresa el numero de empleado del IPN: ");
                numero = Console.ReadLine();

                //Verifica si la cadena ingresada en todos sus caracteres es 0
                bool distinto_ceros = Regex.IsMatch(numero, patron2);

                //Si no contiene ceros entra al if en caso contrario al else
                if (distinto_ceros == false)
                {
                    //compara la cadena con la expresion regular
                    bool resultado = Regex.IsMatch(numero, patron);

                    if (resultado == true)
                        Console.WriteLine("El numero de empleado es valido");
                    else if (resultado == false)
                        Console.WriteLine("El numero de empleado no es valido");

                    Console.WriteLine(" ");
                }
                else
                    Console.WriteLine("El empleado no existe ");


            }
            Console.ReadKey();
        }
    }
}