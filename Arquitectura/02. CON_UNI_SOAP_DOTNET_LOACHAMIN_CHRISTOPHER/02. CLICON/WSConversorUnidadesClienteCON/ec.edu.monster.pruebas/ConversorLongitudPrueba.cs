using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Threading.Tasks;
using WSConversorUnidadesClienteCON.Vistas;
using WSConversorUnidadesClienteCON.Controladores;
using Moq;
using ConversorLongitudServicioReferencia;

namespace WSConversorUnidadesClienteCON.ec.edu.monster.pruebas
{
    [TestClass]
    public class ConversionLongitudPrueba
    {
        private Mock<ConsoleView> _mockView;
        private Mock<ConversorLongitudServicioClient> _mockService;
        private ConversionController _conversionController;

        [TestInitialize]
        public void SetUp()
        {
            _mockView = new Mock<ConsoleView>();
            _mockService = new Mock<ConversorLongitudServicioClient>();
            _conversionController = new ConversionController(_mockView.Object, _mockService.Object);
        }

        [TestMethod]
        public async Task ConvertLength_ValidRequest_DisplaysResult()
        {
            // Arrange
            double value = 10.0;
            string unitFrom = "meter";
            string unitTo = "kilometer";
            double expectedResult = 0.01;

            _mockView.Setup(v => v.GetConversionValue()).Returns(value);
            _mockView.Setup(v => v.GetConversionUnit("From unit")).Returns(unitFrom);
            _mockView.Setup(v => v.GetConversionUnit("To unit")).Returns(unitTo);
            _mockService
                .Setup(s => s.ConvertirLongitud(It.IsAny<ConvertirLongitudRequest>()))
                .Returns(new ConvertirLongitudResponse { ConvertirLongitudResult = expectedResult });

            // Act
            await _conversionController.ConvertLength();

            // Assert
            _mockView.Verify(v => v.ShowConversionResult(expectedResult), Times.Once);
        }

        [TestMethod]
        public async Task ConvertLength_InvalidRequest_ShowsError()
        {
            // Arrange
            _mockView.Setup(v => v.GetConversionUnit("From unit")).Returns("unknown");
            _mockView.Setup(v => v.GetConversionUnit("To unit")).Returns("unknown");

            _mockService
                .Setup(s => s.ConvertirLongitud(It.IsAny<ConvertirLongitudRequest>()))
                .Throws(new Exception("Invalid units"));

            // Act
            await _conversionController.ConvertLength();

            // Assert
            _mockView.Verify(v => v.ShowConversionResult(It.IsAny<double>()), Times.Never);
        }
    }

}


