package model;

public class FaturaExportacao extends DocumentoFiscal{
    public double getDescontoAfandega(){
        return 9;
    }

    public FaturaExportacao(int numero, double valorBruto) {
        super(numero, valorBruto);
    }
}
