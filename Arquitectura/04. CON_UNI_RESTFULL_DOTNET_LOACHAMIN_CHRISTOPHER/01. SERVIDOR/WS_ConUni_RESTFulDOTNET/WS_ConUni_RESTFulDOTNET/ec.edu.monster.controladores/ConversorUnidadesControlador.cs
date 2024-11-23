using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using WS_ConUni_RESTFulDOTNET.ec.edu.monster.modelos;

namespace WS_ConUni_RESTFulDOTNET.ec.edu.monster.controladores
{
    [Route("api/[controller]")]
    [ApiController]
    public class ConversorUnidadesControlador : ControllerBase
    {
        [HttpGet]
        public ActionResult<ConversionUnidades> Convertir(double valor, string unidadOrigen, string unidadDestino)
        {
            var conversion = new ConversionUnidades { Valor = valor, UnidadOrigen = unidadOrigen, UnidadDestino = unidadDestino };

            if (conversion.UnidadOrigen == "pulgadas" && conversion.UnidadDestino == "centimetros")
            {
                conversion.Resultado = conversion.Valor * 2.54;
            }
            else if (conversion.UnidadOrigen == "centimetros" && conversion.UnidadDestino == "pulgadas")
            {
                conversion.Resultado = conversion.Valor / 2.54;
            }
            else
            {
                return BadRequest("Las unidades especificadas no son válidas.");
            }

            return conversion;
        }
    }
}
