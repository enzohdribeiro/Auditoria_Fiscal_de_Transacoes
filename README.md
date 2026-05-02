# Auditor Fiscal

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![OOP](https://img.shields.io/badge/OOP-Principles-blue?style=for-the-badge)

## Sobre
Este projeto simula uma auditoria fiscal. 
O foco é aplicar de forma efetiva e inteligente a arquitetura orientada a objetos, especificamente o uso de **Interfaces**, **Classes Abstratas**, **Polimorfismo** 
e a aplicação estratégica de **Downcasting**.

O sistema processa diferentes tipos de documentos tributáveis, identificando particularidades em tempo de execução para aplicar taxas ou descontos específicos 
e atualizar o estado do documento no fluxo de auditoria (pendente,auditado ou rejeitado).

## Conceitos de OOP Implementados

*   **Abstração e Contratos:** Uso da interface `Tributavel` para definir um comportamento obrigatório sem juntar a lógica ao tipo do objeto.
*   **Herança:** A classe `DocumentoFiscal` centraliza atributos comuns (`numero`, `valorBruto`, `status`), servindo de molde para classes filhas.
*   **Polimorfismo:** Métodos que recebem a interface `Tributavel` e conseguem processar qualquer subclasse de forma transparente.
*   **Downcasting & RTTI (Run-Time Type Information):** Uso de `instanceof` para verificar o tipo real do objeto e realizar o casting seguro, permitindo acessar métodos que não existem na superclasse (como regras de ISS ou descontos alfandegários).
*   **Encapsulamento de Estado:** Gerenciamento do ciclo de vida do documento através de um `Enum` (`StatusFiscal`).

## Arquitetura
`
src/
 ┣ controller/
 ┃ ┗ Impressora.java          # Saída de dados com verificação de tipo
 ┣ model/
 ┃ ┣ Tributavel.java          # Interface (O Contrato)
 ┃ ┣ DocumentoFiscal.java     # Classe Abstrata (O Molde)
 ┃ ┣ StatusFiscal.java        # Enum (Os Estados)
 ┃ ┣ NotaFiscalServico.java   # Classe Concreta (Especialização)
 ┃ ┗ FaturaExportacao.java    # Classe Concreta (Especialização)
 ┣ service/
 ┃ ┗ ProcessadorFiscal.java   # Motor de Regras e Casting
 ┗ main/
   ┗ Main.java                # Setup e execução do cenário `
   
## Exemplo de funcionamento:
```
--- ESTADO INICIAL ---
ID: 123 | Valor Bruto: 150.0 | Status: Pendente
ID: 556 | Valor Bruto: 260.0 | Status: Pendente

--- PROCESSANDO ---
Taxa ISS aplicada via Casting.
Status fiscal alterado com sucesso para Auditado via Casting
Valor Final: 158.0  (150 + 3.0 [base] + 5.0 [ISS])

Desconto alfândega aplicado via Casting.
Status fiscal alterado com sucesso para Auditado via Casting
Valor Final: 256.2  (260 + 5.2 [base] - 9.0 [alfândega])

--- ESTADO PÓS-PROCESSAMENTO ---
ID: 123 | Valor Bruto: 150.0 | Status: Auditado
ID: 556 | Valor Bruto: 260.0 | Status: Auditado 
```
## Aplicação de casting e instanceof:
```
public static void processar(Tributavel t) {
    // Polimorfismo: chama o método do contrato
    double valorFinal = t.calcularImpostoTotal();

    // Downcasting: recupera o tipo específico para aplicar regra exclusiva
    if (t instanceof NotaFiscalServico) {
        NotaFiscalServico nfs = (NotaFiscalServico) t;
        valorFinal += nfs.getTaxaISS() + nfs.getValorBruto();
    }

    // Casting para Superclasse Abstrata: permite alterar o estado (Enum)
    if (t instanceof DocumentoFiscal) {
        ((DocumentoFiscal) t).setStatusFiscal(StatusFiscal.AUDITADO);
    }
}
```
