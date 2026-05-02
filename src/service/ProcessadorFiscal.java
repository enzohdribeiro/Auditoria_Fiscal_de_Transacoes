package service;

import model.*;

public class ProcessadorFiscal {


    public static void processar(Tributavel t){
        double valorFinal = 0;
        valorFinal +=  + t.calcularImpostoTotal();
        System.out.println("-----------Processando-----------");
        if(t instanceof NotaFiscalServico){
            NotaFiscalServico nfs = (NotaFiscalServico) t;
            valorFinal += nfs.getTaxaISS()+ nfs.getValorBruto();
            System.out.println("Taxa ISS aplicada via Casting.");
        }
        if(t instanceof FaturaExportacao){
            FaturaExportacao fe = (FaturaExportacao) t;
            valorFinal -= fe.getDescontoAfandega();
            valorFinal += fe.getValorBruto();
            System.out.println("Desconto alfândega aplicado via Casting.");
        }
        if (t instanceof DocumentoFiscal){
            DocumentoFiscal df = (DocumentoFiscal) t;
            df.setStatusFiscal(StatusFiscal.AUDITADO);
            System.out.println("Status fiscal alterado com sucesso para Auditado via Casting");
            System.out.println("--------------------------------------------------");
        }
        System.out.println("Valor Final: "+valorFinal);
    }
}
