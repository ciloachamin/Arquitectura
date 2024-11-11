using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using WSConversorUnidadesClienteWEB.ConversorLongitudServicioReferencia;

namespace WSConversorUnidadesClienteWEB.Controllers
{
    public class ConversorLongitudController : Controller
    {
        public ActionResult Convertir()

        {
            // Validar si el usuario está autenticado
            if (Session["Username"] == null)
            {
                return RedirectToAction("Login", "Auth");
            }

            // Pasar un valor inicial de 0 cuando se cargue la vista por primera vez
            return View(0.0);
        }

        [HttpPost]
        public ActionResult Convertir(double valor, string unidadOrigen, string unidadDestino)
        {
            if (Session["Username"] == null)
            {
                return RedirectToAction("Login", "Auth");
            }

            double resultado = 0;

            using (var cliente = new ConversorLongitudServicioClient())
            {
                resultado = cliente.ConvertirLongitud(valor, unidadOrigen, unidadDestino);
            }
            

            ViewBag.Resultado = resultado;
            return View();
        }


    }
}
