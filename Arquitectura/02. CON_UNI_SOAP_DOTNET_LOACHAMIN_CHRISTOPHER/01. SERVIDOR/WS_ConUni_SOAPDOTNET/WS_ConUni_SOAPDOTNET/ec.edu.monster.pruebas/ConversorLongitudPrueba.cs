using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using WS_ConUni_SOAPDOTNET.Modelos;

namespace WS_ConUni_SOAPDOTNET.Tests
{
    [TestClass]
    public class ConversorLongitudPrueba
    {
        private ConversorLongitudServicio _servicio;

        [TestInitialize]
        public void Setup()
        {
            _servicio = new ConversorLongitudServicio();
        }

        [TestMethod]
        public void ConvertirLongitud_MetroAKilometro_RetornaValorCorrecto()
        {
            // Arrange
            double valor = 1000;
            string unidadOrigen = "metro";
            string unidadDestino = "kilometro";
            double esperado = 1.0;

            // Act
            double resultado = _servicio.ConvertirLongitud(valor, unidadOrigen, unidadDestino);

            // Assert
            Assert.AreEqual(esperado, resultado, 0.0001);
        }

        [TestMethod]
        public void ConvertirLongitud_KilometroAMetro_RetornaValorCorrecto()
        {
            // Arrange
            double valor = 1;
            string unidadOrigen = "kilometro";
            string unidadDestino = "metro";
            double esperado = 1000.0;

            // Act
            double resultado = _servicio.ConvertirLongitud(valor, unidadOrigen, unidadDestino);

            // Assert
            Assert.AreEqual(esperado, resultado, 0.0001);
        }

        [TestMethod]
        public void ConvertirLongitud_CentimetroAMetro_RetornaValorCorrecto()
        {
            // Arrange
            double valor = 100;
            string unidadOrigen = "centimetro";
            string unidadDestino = "metro";
            double esperado = 1.0;

            // Act
            double resultado = _servicio.ConvertirLongitud(valor, unidadOrigen, unidadDestino);

            // Assert
            Assert.AreEqual(esperado, resultado, 0.0001);
        }

        [TestMethod]
        public void ConvertirLongitud_MillaAKilometro_RetornaValorCorrecto()
        {
            // Arrange
            double valor = 1;
            string unidadOrigen = "milla";
            string unidadDestino = "kilometro";
            double esperado = 1.60934;

            // Act
            double resultado = _servicio.ConvertirLongitud(valor, unidadOrigen, unidadDestino);

            // Assert
            Assert.AreEqual(esperado, resultado, 0.0001);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void ConvertirLongitud_UnidadOrigenInvalida_LanzaExcepcion()
        {
            // Arrange
            double valor = 100;
            string unidadOrigen = "unidadInvalida";
            string unidadDestino = "metro";

            // Act
            _servicio.ConvertirLongitud(valor, unidadOrigen, unidadDestino);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void ConvertirLongitud_UnidadDestinoInvalida_LanzaExcepcion()
        {
            // Arrange
            double valor = 100;
            string unidadOrigen = "metro";
            string unidadDestino = "unidadInvalida";

            // Act
            _servicio.ConvertirLongitud(valor, unidadOrigen, unidadDestino);
        }
    }

    [TestClass]
    public class LongitudModeloTests
    {
        [TestMethod]
        public void Constructor_InicializaCorrectamente()
        {
            // Arrange
            double valor = 100;
            string unidadOrigen = "metro";
            string unidadDestino = "kilometro";

            // Act
            var modelo = new LongitudModelo(valor, unidadOrigen, unidadDestino);

            // Assert
            Assert.AreEqual(valor, modelo.Valor);
            Assert.AreEqual(unidadOrigen, modelo.UnidadOrigen);
            Assert.AreEqual(unidadDestino, modelo.UnidadDestino);
        }

        [TestMethod]
        public void Propiedades_ModificanValoresCorrectamente()
        {
            // Arrange
            var modelo = new LongitudModelo(100, "metro", "kilometro");

            // Act
            modelo.Valor = 200;
            modelo.UnidadOrigen = "milla";
            modelo.UnidadDestino = "centimetro";

            // Assert
            Assert.AreEqual(200, modelo.Valor);
            Assert.AreEqual("milla", modelo.UnidadOrigen);
            Assert.AreEqual("centimetro", modelo.UnidadDestino);
        }
    }
}