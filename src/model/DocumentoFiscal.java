package model;

public abstract class DocumentoFiscal implements Tributavel{
    private final int numero;
    protected double valorBruto;
    protected double impostoBase = 0.02;
    protected StatusFiscal statusFiscal = StatusFiscal.PENDENTE;

    public DocumentoFiscal(int numero, double valorBruto) {
        this.numero = numero;
        this.valorBruto = valorBruto;
    }
    @Override
    public String toString() {
        return "" + statusFiscal;
    }

    @Override
    public double calcularImpostoTotal() {
        return impostoBase * valorBruto;
    }

    public double getValorBruto() {
        return valorBruto;
    }

    public void setStatusFiscal(StatusFiscal statusFiscal) {
        this.statusFiscal = statusFiscal;
    }

    public int getNumero() {
        return numero;
    }

}
