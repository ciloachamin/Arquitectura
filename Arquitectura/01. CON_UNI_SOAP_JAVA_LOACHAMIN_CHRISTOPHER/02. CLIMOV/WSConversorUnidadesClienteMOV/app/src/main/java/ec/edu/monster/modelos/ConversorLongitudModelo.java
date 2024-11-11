package ec.edu.monster.modelos;

public class ConversorLongitudModelo {
    private double valor;
    private String unidadOrigen;
    private String unidadDestino;

    public ConversorLongitudModelo(double valor, String unidadOrigen, String unidadDestino) {
        this.valor = valor;
        this.unidadOrigen = unidadOrigen;
        this.unidadDestino = unidadDestino;
    }

    public double getValor() { return valor; }
    public String getUnidadOrigen() { return unidadOrigen; }
    public String getUnidadDestino() { return unidadDestino; }
}