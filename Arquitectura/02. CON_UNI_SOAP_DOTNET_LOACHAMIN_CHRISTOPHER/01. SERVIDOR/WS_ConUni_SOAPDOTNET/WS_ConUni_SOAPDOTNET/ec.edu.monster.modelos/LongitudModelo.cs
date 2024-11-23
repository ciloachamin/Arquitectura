using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace WS_ConUni_SOAPDOTNET.Modelos
{
    [DataContract]
    public class LongitudModelo
    {
        [DataMember]
        public double Valor { get; set; }

        [DataMember]
        public string UnidadOrigen { get; set; }

        [DataMember]
        public string UnidadDestino { get; set; }

        public LongitudModelo(double valor, string unidadOrigen, string unidadDestino)
        {
            Valor = valor;
            UnidadOrigen = unidadOrigen;
            UnidadDestino = unidadDestino;
        }
    }
}