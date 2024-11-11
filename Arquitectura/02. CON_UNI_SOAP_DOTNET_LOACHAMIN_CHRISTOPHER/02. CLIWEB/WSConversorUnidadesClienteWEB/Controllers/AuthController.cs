using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace WSConversorUnidadesClienteWEB.Controllers
{
    public class AuthController : Controller
    {
        // Acción para mostrar la vista de login
        public ActionResult Login()
        {
            return View();
        }

        // Acción para procesar el login
        [HttpPost]
        public ActionResult Login(string username, string password)
        {
            // Datos quemados para autenticación
            const string validUsername = "admin";
            const string validPassword = "123456";

            if (username == validUsername && password == validPassword)
            {
                // Crear una sesión para el usuario autenticado
                Session["Username"] = username;
                return RedirectToAction("Convertir", "ConversorLongitud");
            }

            // Mensaje de error si la autenticación falla
            ViewBag.Error = "Nombre de usuario o contraseña incorrectos";
            return View();
        }

        // Acción para cerrar sesión
        public ActionResult Logout()
        {
            Session.Clear(); // Limpiar la sesión
            return RedirectToAction("Login");
        }
    }
}
