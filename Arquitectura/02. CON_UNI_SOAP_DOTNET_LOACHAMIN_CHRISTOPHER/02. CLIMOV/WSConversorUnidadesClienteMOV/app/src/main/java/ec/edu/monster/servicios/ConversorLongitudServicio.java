package ec.edu.monster.servicios;

import android.os.AsyncTask;
import android.util.Log;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.Marshal;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import ec.edu.monster.modelos.ConversorLongitudModelo;

public class ConversorLongitudServicio {

    public String convertirLongitud(ConversorLongitudModelo model) throws ExecutionException, InterruptedException {
        return new ConvertirLongitudTask().execute(model).get();
    }

    private static class ConvertirLongitudTask extends AsyncTask<ConversorLongitudModelo, Void, String> {

        // MarshalDouble maneja el tipo de dato double en SOAP
        public class MarshalDouble implements Marshal {
            public Object readInstance(XmlPullParser parser, String namespace, String name, PropertyInfo expected) throws IOException, XmlPullParserException {
                return Double.parseDouble(parser.nextText());
            }

            public void register(SoapSerializationEnvelope envelope) {
                envelope.addMapping(envelope.xsd, "double", Double.class, this);
            }

            public void writeInstance(XmlSerializer writer, Object obj) throws IOException {
                writer.text(obj.toString());
            }
        }

        @Override
        protected String doInBackground(ConversorLongitudModelo... params) {
            ConversorLongitudModelo model = params[0];
            Double valor = model.getValor();
            String unidadOrigen = model.getUnidadOrigen();
            String unidadDestino = model.getUnidadDestino();

            String NAMESPACE = "http://tempuri.org/";
            String METHOD_NAME = "ConvertirLongitud";
            String SOAP_ACTION ="http://tempuri.org/IConversorLongitudServicio/ConvertirLongitud";
            //Emulador
            //String URL = "http://10.0.2.2:42436/ConversorLongitudServicio.svc";

            //Emulador
            String URL = "http://10.40.17.136:42436/ConversorLongitudServicio.svc";
            //Equipo fisico
            //String URL = "http://192.168.100.35:8080/WS_ConUni_SOAPJAVA/WSConversorLongitud";
            //Equipo fisico
            //String URL = "http://10.40.18.76:8080/WS_ConUni_SOAPJAVA/WSConversorLongitud";

            Log.d("ConversorService", "Respuesta recibida: " + valor + unidadDestino +unidadOrigen);
            try {
                SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
                request.addProperty("valor", valor);
                request.addProperty("unidadOrigen", unidadOrigen);
                request.addProperty("unidadDestino", unidadDestino);

                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.dotNet = true;
                envelope.setOutputSoapObject(request);
                envelope.encodingStyle = SoapSerializationEnvelope.XSD;

                MarshalDouble md = new MarshalDouble();
                md.register(envelope);

                HttpTransportSE transport = new HttpTransportSE(URL);
                transport.call(SOAP_ACTION, envelope);

                SoapPrimitive resultString = (SoapPrimitive) envelope.getResponse();
                Log.d("ConversorService", "Respuesta recibida: " + resultString.toString());
                return "Resultado: " + resultString.toString();

            } catch (Exception e) {
                e.printStackTrace();
                return "Error: " + e.getMessage();
            }
        }
    }
}
