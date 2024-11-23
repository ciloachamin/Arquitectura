using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WSConversorUnidadesClienteCON.Vistas
{
    public class ConsoleView
    {
        public void ShowLogin()
        {
            Console.WriteLine("Bienvenido al Conversor de Unidades");
            Console.WriteLine("=== Acceso ===");
        }

        public string GetUsername()
        {
            Console.Write("Usuario: ");
            return Console.ReadLine();
        }

        public string GetPassword()
        {
            Console.Write("Contraseña: ");
            string password = "";
            ConsoleKeyInfo key;

            do
            {
                key = Console.ReadKey(true); // true para no mostrar la tecla presionada

                // Si es una tecla de retroceso y hay caracteres
                if (key.Key == ConsoleKey.Backspace && password.Length > 0)
                {
                    // Borrar el último asterisco
                    Console.Write("\b \b");
                    password = password.Substring(0, password.Length - 1);
                }
                // Si es un carácter imprimible
                else if (!char.IsControl(key.KeyChar))
                {
                    // Mostrar asterisco y agregar carácter a la contraseña
                    Console.Write("*");
                    password += key.KeyChar;
                }
            } while (key.Key != ConsoleKey.Enter);

            Console.WriteLine(); // Salto de línea después de presionar Enter
            return password;
        }

        public void ShowLoginSuccess()
        {
            Console.WriteLine("Ingresado con Exito!\n\n");
        }

        public void ShowLoginError()
        {
            Console.WriteLine("Usuario o contraseña incorrecta");
            Thread.Sleep(1000);
            Console.Clear();
        }

        public void ShowConversionResult(double result)
        {
            Console.WriteLine($"Resultado: {result}");
            Console.WriteLine("Presiona enter o escribe 'salir' para salir.\n");

        }

        public double GetConversionValue()
        {
            Console.Write("Ingresa el valor a convertir: ");
            return double.Parse(Console.ReadLine());
        }

        public string GetConversionUnit(string prompt)
        {
            Console.Write($"{prompt} (e.g., metro, kilometro, milla): ");
            return Console.ReadLine();
        }
    }
}
