using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WS_ConUni_SOAPDOTNET.ec.edu.monster.modelos
{
    public class Usuario
    {
        public string Username { get; set; }
        public string PasswordHash { get; set; }

        // Constructor para inicializar usuario
        public Usuario(string username, string password)
        {
            Username = username;
            PasswordHash = HashPassword(password);
        }

        // Método para encriptar contraseñas usando SHA256
        private string HashPassword(string password)
        {
            using (var sha256 = System.Security.Cryptography.SHA256.Create())
            {
                byte[] bytes = sha256.ComputeHash(System.Text.Encoding.UTF8.GetBytes(password));
                return BitConverter.ToString(bytes).Replace("-", "").ToLower();
            }
        }

        // Método para validar una contraseña contra el hash almacenado
        public bool ValidatePassword(string password)
        {
            return HashPassword(password).Equals(PasswordHash, StringComparison.OrdinalIgnoreCase);
        }
    }
}