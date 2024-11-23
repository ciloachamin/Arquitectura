using System;
using System.Web.Mvc;
using WSConversorUnidadesClienteWEB.LoginServicioReferencia;


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
            try
            {
                // Crear una instancia del cliente del servicio
                using (var loginServiceClient = new LoginServicioClient())
                {
                    // Llamar al método de autenticación del servicio
                    bool isAuthenticated = loginServiceClient.Login(username, password);

                    if (isAuthenticated)
                    {
                        // Crear una sesión para el usuario autenticado
                        Session["Username"] = username;
                        return RedirectToAction("Convertir", "ConversorLongitud");
                    }
                }

                // Mensaje de error si la autenticación falla
                ViewBag.Error = "Nombre de usuario o contraseña incorrectos";
            }
            catch (Exception ex)
            {
                // Manejar errores del servicio
                ViewBag.Error = $"Ocurrió un error al intentar autenticarse: {ex.Message}";
            }

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
