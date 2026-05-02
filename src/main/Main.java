package main;

import controller.Impressora;
import model.FaturaExportacao;
import model.NotaFiscalServico;
import service.ProcessadorFiscal;

public class Main {
    public static void main(String[] args) {

    NotaFiscalServico nfs = new NotaFiscalServico(123,150);
    FaturaExportacao fe = new FaturaExportacao(556,260);
        Impressora.imprimeRelatorioFiscal(nfs);
        Impressora.imprimeRelatorioFiscal(fe);
        ProcessadorFiscal.processar(nfs);
        ProcessadorFiscal.processar(fe);
        Impressora.imprimeRelatorioFiscal(nfs);
        Impressora.imprimeRelatorioFiscal(fe);
    }
}
