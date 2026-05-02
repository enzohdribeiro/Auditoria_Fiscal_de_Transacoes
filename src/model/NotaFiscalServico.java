package model;

public class NotaFiscalServico extends DocumentoFiscal{
    public double getTaxaISS(){
        return 5;
    }

    public NotaFiscalServico(int numero, double valorBruto) {
        super(numero, valorBruto);
    }
}
