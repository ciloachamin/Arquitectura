
using Microsoft.AspNetCore.Mvc;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using WS_ConUni_RESTFulDOTNET.ec.edu.monster.controladores;
using WS_ConUni_RESTFulDOTNET.ec.edu.monster.modelos;



namespace WS_ConUni_RESTFulDOTNET.ec.edu.monster.pruebas
{
    [TestClass]
    public class ConversorUnidadesControladorPrueba
    {
        [TestMethod]
        public void Convertir_DePulgadasACentimetros_DebeRetornarValorCorrecto()
        {
            // Arrange
            var controlador = new ConversorUnidadesControlador();
            var valor = 10.0;
            var unidadOrigen = "pulgadas";
            var unidadDestino = "centimetros";
            var expectedResultado = 25.4;

            // Act
            var resultado = controlador.Convertir(valor, unidadOrigen, unidadDestino) as ActionResult<ConversionUnidades>;

            // Assert
            Assert.IsNotNull(resultado);
            Assert.AreEqual(expectedResultado, resultado.Value.Resultado);
        }

        [TestMethod]
        public void Convertir_DeCentimetrosAPulgadas_DebeRetornarValorCorrecto()
        {
            // Arrange
            var controlador = new ConversorUnidadesControlador();
            var valor = 25.4;
            var unidadOrigen = "centimetros";
            var unidadDestino = "pulgadas";
            var expectedResultado = 10.0;

            // Act
            var resultado = controlador.Convertir(valor, unidadOrigen, unidadDestino) as ActionResult<ConversionUnidades>;

            // Assert
            Assert.IsNotNull(resultado);
            Assert.AreEqual(expectedResultado, resultado.Value.Resultado);
        }
    }
}
