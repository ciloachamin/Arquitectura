/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.varios;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author leito
 */
public class Validar {

    private static final int NUM_PROVINCIAS = 24;

    public void validarLetras(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }

    //---------------------------------------------------------------
    public void validarNumeros(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '.') {
                    e.consume();
                }
            }
        });
    }

    public void validarNumerosComboBox(JComboBox campo) {
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && (c != '.' || c != ',')) {
                    e.consume();
                }
            }
        });
    }

    public void limitarCaracteres(JTextField campo, int cantidad) {
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                int tam = campo.getText().length();
                if (tam >= cantidad) {
                    e.consume();
                }
            }
        });
    }

    public void limitarCaracteresArea(JTextArea campo, int cantidad) {
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                int tam = campo.getText().length();
                if (tam >= cantidad) {
                    e.consume();
                }
            }
        });
    }

    public void crearCaracteres(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                int tam = campo.getText().length();
                if (tam == 3) {
                    campo.setText(campo.getText() + "-");
                } else if (tam == 7) {
                    campo.setText(campo.getText() + "-");
                }
            }
        });
    }

    public void caducaFecha(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                int tam = campo.getText().length();
                if (tam == 2) {
                    campo.setText(campo.getText() + "/");
                } else if (tam == 5) {
                    campo.setText(campo.getText() + "/");
                }
            }
        });
    }

    public boolean validacionCedula(String cedula) {
        int num_provincias = 24;
        //verifica que los dos primeros dígitos correspondan a un valor entre 1 y NUMERO_DE_PROVINCIAS
        int prov = Integer.parseInt(cedula.substring(0, 2));

        if (!((prov > 0) && (prov <= num_provincias))) {
            //addError("La cédula ingresada no es válida");
            System.out.println("Error: cedula incorrecta");
            return false;
        }

        //verifica que el último dígito de la cédula sea válido
        int[] d = new int[10];
        //Asignamos el string a un array
        for (int i = 0; i < d.length; i++) {
            d[i] = Integer.parseInt(cedula.charAt(i) + "");
        }

        int imp = 0;
        int par = 0;

        //sumamos los duplos de posición impar
        for (int i = 0; i < d.length; i += 2) {
            d[i] = ((d[i] * 2) > 9) ? ((d[i] * 2) - 9) : (d[i] * 2);
            imp += d[i];
        }

        //sumamos los digitos de posición par
        for (int i = 1; i < (d.length - 1); i += 2) {
            par += d[i];
        }

        //Sumamos los dos resultados
        int suma = imp + par;

        //Restamos de la decena superior
        int d10 = Integer.parseInt(String.valueOf(suma + 10).substring(0, 1)
                + "0") - suma;

        //Si es diez el décimo dígito es cero        
        d10 = (d10 == 10) ? 0 : d10;

        //si el décimo dígito calculado es igual al digitado la cédula es correcta
        if (d10 == d[9]) {
            return true;
        } else {
            //addError("La cédula ingresada no es válida");
            return false;
        }
    }

    //VALIDAR CEDULA CORRECTO---------------------------------------------------
    public boolean validadorDeCedula(String cedula) {
        boolean cedulaCorrecta = false;

        try {

            if (cedula.length() == 10) // ConstantesApp.LongitudCedula
            {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
                    // Coeficientes de validación cédula
                    // El decimo digito se lo considera dígito verificador
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            System.out.println("Una excepcion ocurrio en el proceso de validadcion");
            cedulaCorrecta = false;
        }

        if (!cedulaCorrecta) {
            System.out.println("La Cédula ingresada es Incorrecta");
            JOptionPane.showMessageDialog(null, "CEDULA INGRESADA ES INCORRECTA.");
        }
        return cedulaCorrecta;
    }

    //fin validador de cedula---------------------------------------------------
    //VALIDAR RUC
    public boolean validacionRUC(String cedula) {
        boolean isValid = false;
        try {
            if (cedula == null || cedula.length() != 10) {
                isValid = false;
            }
            final int prov = Integer.parseInt(cedula.substring(0, 2));
            if (!((prov > 0) && (prov <= NUM_PROVINCIAS))) {
                isValid = false;
            }
            int[] d = new int[10];
            for (int i = 0; i < d.length; i++) {
                d[i] = Integer.parseInt(cedula.charAt(i) + "");
            }
            int imp = 0;
            int par = 0;
            for (int i = 0; i < d.length; i += 2) {
                d[i] = ((d[i] * 2) > 9) ? ((d[i] * 2) - 9) : (d[i] * 2);
                imp += d[i];
            }
            for (int i = 1; i < (d.length - 1); i += 2) {
                par += d[i];
            }
            final int suma = imp + par;
            int d10 = Integer.parseInt(String.valueOf(suma + 10).substring(0, 1) + "0") - suma;
            d10 = (d10 == 10) ? 0 : d10;
            if (d10 == d[9]) {
                isValid = true;
            } else {
                System.out.println("La Cédula ingresada es Incorrecta");
                isValid = false;
            }
        } catch (NumberFormatException nfe) {
            System.out.println("La Cédula ingresada es Incorrecta12");
            isValid = false;
        }
        if (!isValid) {
            JOptionPane.showMessageDialog(null, "RUC INGRESADO ES INCORRECTA.");
        }
        return isValid;
    }

    //--------------------------------------------------------------------------
    //VALIDAR CORREO
    public boolean validarCorreo(String campo) {
        boolean emailCorrecto = false;
        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        // El email a validar
        String email = campo;
        Matcher mather = pattern.matcher(email);

        if (mather.find() == true) {
            emailCorrecto = true;
            System.out.println("El email ingresado es válido.");
        } else {
            emailCorrecto = false;
            System.out.println("El email ingresado es inválido.");
            JOptionPane.showMessageDialog(null, "CORREO INGRESADO ES INCORRECTO.");
        }
        return emailCorrecto;
    }

    //fin validar correo--------------------------------------------------------
    //validar hora--------------------------------------------------------------
    public Boolean validar_CampoHora(String Hora) {
        boolean b;
        //guardamos el valor
        char[] a = Hora.toString().toCharArray();
        //dividimos con el comando split
        String[] c = Hora.split(":");
        if ((a[0] == ' ') || (a[1] == ' ') || (a[2] == ' ') || (a[3] == ' ') || (a[4] == ' ') || (getInteger(c[0]) > 24) || (getInteger(c[1]) > 59)) {
            b = false;
        } else {
            b = true;
        }
        return b;
    }

    public int getInteger(String valor) {
        int integer = Integer.parseInt(valor);
        return integer;
    }
    //fin validar hora----------------------------------------------------------

    //VALIDAR CONTRASEÑA -------------------------------------------------------
    public String validarContra(String contra) {
        String valor = "OK";
        String may = "";
        String min = "";
        String num = "";
        char clave;
        byte contNumero = 0, contLetraMay = 0, contLetraMin = 0;
        for (byte i = 0; i < contra.length(); i++) {
            clave = contra.charAt(i);
            String passValue = String.valueOf(clave);
            if (passValue.matches("[A-Z]")) {
                contLetraMay++;
            } else if (passValue.matches("[a-z]")) {
                contLetraMin++;
            } else if (passValue.matches("[0-9]")) {
                contNumero++;
            }
        }
        System.out.println("Cantidad de letras mayusculas:" + contLetraMay);
        System.out.println("Cantidad de letras minusculas:" + contLetraMin);
        System.out.println("Cantidad de numeros:" + contNumero);
        if (contLetraMay == 0) {
            System.out.println("no tiene mayusculas");
            may = "MAYUSCULA";
            return may;
        }
        if (contLetraMin == 0) {
            System.out.println("no tiene minusculas");
            min = "MINUSCULA";
            return min;
        }
        if (contNumero == 0) {
            System.out.println("no tiene numeros");
            num = "NUMERO";
            return num;
        }
        return valor;
    }
    //VALIDAR CONTRASEÑA -------
}
