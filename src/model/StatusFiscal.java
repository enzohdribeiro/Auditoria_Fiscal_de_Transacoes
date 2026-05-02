package model;

public enum StatusFiscal {
    AUDITADO("Auditado"),
    PENDENTE("Pendente"),
    REJEITADO("Rejeitado");

    private final String status;

    StatusFiscal(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "" + status;
    }
}
