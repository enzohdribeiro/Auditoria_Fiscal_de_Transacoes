package controller;

import model.DocumentoFiscal;
import model.Tributavel;
import service.ProcessadorFiscal;

public class Impressora {
    public static void imprimeRelatorioFiscal(Tributavel doc){
        if(doc instanceof DocumentoFiscal){
            DocumentoFiscal dF = (DocumentoFiscal) doc;
            System.out.println("ID: "+dF.getNumero());
            System.out.println("Valor bruto: "+dF.getValorBruto());
            System.out.println("Imposto total: "+dF.calcularImpostoTotal());
            System.out.println("Status Fiscal: "+ dF);
            System.out.println("------------------------------------------------------");
        } else {
            System.out.println("Aviso: Documento analisado não é um documento fiscal válido.");
            System.out.println("------------------------------------------------------");
        }
    }
}
