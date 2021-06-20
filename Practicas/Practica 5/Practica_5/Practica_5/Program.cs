using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Practica_5
{
    class Program
    {
        static void Main(string[] args)
        {
            string S, A, B, C, auxiliar1, auxiliar2, auxiliar3;
            string OpcionA = "A";
            string OpcionB = "B";
            string OpcionC = "C";
            int n, m, p;

            Console.WriteLine("Ingrese la produccion inicial S: ");
            S = Console.ReadLine();
            Console.WriteLine("Ingrese la segunda produccion A: ");
            A = Console.ReadLine();
            Console.WriteLine("Ingrese la tercera produccion B: ");
            B = Console.ReadLine();
            Console.WriteLine("Ingrese la cuarta produccion C: ");
            C = Console.ReadLine();

            n = A.Length;
            m = B.Length;
            p = C.Length;

            if (p > 1) 
            {
                auxiliar1 = C.Substring(0, 2);
                auxiliar2 = C.Substring(2, 5);
                auxiliar3 = C.Substring(5, 7);

                if('B' == auxiliar1[0])
                {
                    auxiliar1 = auxiliar1.Replace("B", B);
                    auxiliar2 = auxiliar2.Replace("A", A);
                }
                else
                {
                    auxiliar1 = auxiliar1.Replace("A", A);
                    auxiliar2 = auxiliar2.Replace("B", B);
                }
                C = auxiliar1 + auxiliar2 + auxiliar3;

                if('B' == S[0])
                {
                    auxiliar1 = auxiliar1 + OpcionB;
                    auxiliar2 = auxiliar2 + OpcionB;
                    S = auxiliar1 + auxiliar2;
                    n = 0;
                }
                else
                {
                    auxiliar1 = auxiliar1 + OpcionA;
                    auxiliar1 = auxiliar1 + OpcionA;
                    S = auxiliar1 + auxiliar2;
                    m = 0;
                }
            }

            if (m > 1)
            {
                auxiliar1 = B.Substring(0, 2);
                auxiliar2 = B.Substring(2, 5);
                auxiliar3 = B.Substring(5, 7);

                if ('A' == auxiliar1[0]) 
                {
                    auxiliar1 = auxiliar1.Replace("A", A);
                    auxiliar2 = auxiliar2.Replace("C", C);
                }
                else
                {
                    auxiliar1 = auxiliar1.Replace("C", C);
                    auxiliar2 = auxiliar2.Replace("A", A);
                }
                B = auxiliar1 + auxiliar2 + auxiliar3;

                if ('A' == S[1]) 
                {
                    auxiliar1 = auxiliar1 + OpcionA;
                    auxiliar2 = auxiliar2 + OpcionA;
                    S = auxiliar1 + auxiliar2;
                    p = 0;
                }
                else
                {
                    auxiliar1 = auxiliar1 + OpcionC;
                    auxiliar2 = auxiliar2 + OpcionC;
                    S = auxiliar1 + auxiliar2;
                    n = 0;
                }
            }

            if (n > 1)
            {
                auxiliar1 = A.Substring(0, 2);
                auxiliar2 = A.Substring(2, 5);
                auxiliar3 = A.Substring(5, 7);

                if ('B' == auxiliar1[0]) 
                {
                    auxiliar1 = auxiliar1.Replace("B", B);
                    auxiliar2 = auxiliar2.Replace("C", C);
                }
                else
                {
                    auxiliar1 = auxiliar1.Replace("C", C);
                    auxiliar2 = auxiliar2.Replace("B", B);
                }
                A = auxiliar1 + auxiliar2 + auxiliar3;

                if ('B' == S[1])
                {
                    auxiliar1 = auxiliar1 + OpcionB;
                    auxiliar2 = auxiliar2 + OpcionB;
                    S = auxiliar1 + auxiliar2;
                    p = 0;
                }
                else
                {
                    auxiliar1 = auxiliar1 + OpcionC;
                    auxiliar2 = auxiliar2 + OpcionC;
                    S = auxiliar1 + auxiliar2;
                    m = 0;
                }
            }

            if (n == 0)
                Console.WriteLine("La conversion FNG es: \nS --> {0} \nB --> {1} \nC --> {2}", S, B, C);

            if (m == 0)
                Console.WriteLine("La conversion FNG es: \nS --> {0} \nA --> {1} \nC --> {2}", S, A, C);

            if (p == 0)
                Console.WriteLine("La conversion FNG es: \nS --> {0} \nA --> {1} \nB --> {2}", S, A, B);

            Console.ReadKey();
        }
    }
}
