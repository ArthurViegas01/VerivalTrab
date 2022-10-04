package com.verivaltrab;

public class CentroDistribuicao {
    public enum SITUACAO {
        NORMAL, SOBRAVISO, EMERGENCIA
    }

    public enum TIPOPOSTO {
        COMUM, ESTRATEGICO
    }

    public static final int MAX_ADITIVO = 500;
    public static final int MAX_ALCOOL = 2500;
    public static final int MAX_GASOLINA = 10000;

    private double tAditivo;
    private double tAlcool2;
    private double tAlcool1;
    private double tGasolina;
    private SITUACAO situacao;
    private double total; // variável auxiliar | total de combustível requisitado

    public CentroDistribuicao(double tAditivo, double tGasolina, double tAlcool1, double tAlcool2)
            throws IllegalArgumentException {
        total = tAditivo + tGasolina + tAlcool1 + tAlcool2;
        // tratamento de valores menores ou iguais a zero
        if ((tAditivo <= 0) || (tGasolina <= 0) || (tAlcool1 <= 0) || (tAlcool2 <= 0)) {
            throw new IllegalArgumentException("Valor negativo ou zero não suportado");
        } else if (tAlcool1 != tAlcool2) { // tratamento de valores inválidos de alcool
            throw new IllegalArgumentException("Os valores de Alcool devem ser iguais");
        } else if (tAditivo != total * 0.05) {
            throw new IllegalArgumentException("Valor aditivo diferente do indicado");
        } else if ((tAlcool1 + tAlcool2) != total * 0.25) {
            throw new IllegalArgumentException("valores de alcool não podem ser diferentes de 25%");
        } else if (tGasolina != total * 0.7) {
            throw new IllegalArgumentException("valor de gasolina diferente de 70%");
        } else {
            this.tAditivo = tAditivo;
            this.tGasolina = tGasolina;
            this.tAlcool1 = tAlcool1;
            this.tAlcool2 = tAlcool2;
            this.situacao = SITUACAO.NORMAL;
        }
    }

    public void defineSituacao() {
        if ((tGasolina <= (MAX_GASOLINA / 2)) && (tGasolina >= (MAX_GASOLINA / 4))) {
            if ((tAlcool1 + tAlcool2 <= (MAX_ALCOOL / 2)) && (tAlcool1 + tAlcool2 <= (MAX_ALCOOL / 4))) {
                if ((tAditivo <= (MAX_ADITIVO / 2)) && (tAditivo <= (MAX_ADITIVO / 4))) {
                    situacao = SITUACAO.SOBRAVISO;
                }
            }
        }
        if (tGasolina <= (MAX_GASOLINA / 4)) {
            if (tAlcool1 + tAlcool2 <= (MAX_ALCOOL / 4)) {
                if (tAditivo <= (MAX_ADITIVO / 4)) {
                    situacao = SITUACAO.EMERGENCIA;
                }
            }
        }
        situacao = SITUACAO.NORMAL;

    }

    public SITUACAO getSituacao() {
        return situacao;
    }

    public double getGasolina() {
        return tGasolina;
    }

    public double getAditivo() {
        return tAditivo;
    }

    public double getAlcool1() {
        return tAlcool1;
    }

    public double getAlcool2() {
        return tAlcool2;
    }

    public int recebeAditivo(int qtdade) {
        if (getAditivo() < qtdade * 0.05) {
            return 0;
        } else

            return (int) (qtdade * 0.05);

    }

    public int recebeGasolina(int qtdade) {
        if (getGasolina() < qtdade * 0.70) {
            return 0;
        } else

            return (int) (qtdade * 0.70);

    }

    public int recebeAlcool(int qtdade) {
        // comentar validação. redundância com o construtor
        if (getAlcool1() != getAlcool2()) {
            return 0;
        }
        double alcool = 0;
        alcool = getAlcool1() + getAlcool2();
        if (alcool < qtdade * 0.25) {
            return 0;
        } else
            return (int) (qtdade * 0.25);

    }

    public int[] encomendaCombustivel(int qtdade, TIPOPOSTO tipoPosto) {
        // int qtdade = total de gasolina | mistura
        int[] gasosa = { 0, 0, 0 }; // | gasolina | aditivo | alcool |

        if (tipoPosto == TIPOPOSTO.COMUM) { // tipo de posto
            if (getSituacao() == situacao.NORMAL) {// situações diversas
                gasosa[0] = (int) (qtdade * 0.70); // valores de gasolina aditivo e alcool encomendados.
                tGasolina = tGasolina - (qtdade * 0.70);
                gasosa[1] = (int) (qtdade * 0.05);
                tAditivo = tAditivo - (qtdade * 0.05);
                gasosa[2] = (int) (qtdade * 0.25);
                tAlcool1 = tAlcool1 - ((qtdade * 0.25) / 2);
                tAlcool2 = tAlcool2 - ((qtdade * 0.25) / 2);
                return gasosa;
            }
            if (getSituacao() == situacao.SOBRAVISO) { // 50% off
                gasosa[0] = (int) ((qtdade * 0.70) / 2); // valores de gasolina aditivo e alcool encomendados.
                tGasolina = tGasolina - ((qtdade * 0.70) / 2);
                gasosa[1] = (int) ((qtdade * 0.05) / 2);
                tAditivo = tAditivo - ((qtdade * 0.05) / 2);
                gasosa[2] = (int) ((qtdade * 0.25) / 2);
                tAlcool1 = tAlcool1 - ((qtdade * 0.25) / 4);
                tAlcool2 = tAlcool2 - ((qtdade * 0.25) / 4);
                return gasosa;
            }
            if (getSituacao() == situacao.EMERGENCIA) {
                return gasosa;
            }
        } else if (tipoPosto == TIPOPOSTO.ESTRATEGICO) {
            if (getSituacao() == situacao.NORMAL) {// situações diversas
                gasosa[0] = (int) (qtdade * 0.70); // valores de gasolina aditivo e alcool encomendados.
                tGasolina = tGasolina - (qtdade * 0.70);
                gasosa[1] = (int) (qtdade * 0.05);
                tAditivo = tAditivo - (qtdade * 0.05);
                gasosa[2] = (int) (qtdade * 0.25);
                tAlcool1 = tAlcool1 - ((qtdade * 0.25) / 2);
                tAlcool2 = tAlcool2 - ((qtdade * 0.25) / 2);
                return gasosa;
            }
            if (getSituacao() == situacao.SOBRAVISO) { // 50% off
                gasosa[0] = (int) ((qtdade * 0.70)); // valores de gasolina aditivo e alcool encomendados.
                tGasolina = tGasolina - ((qtdade * 0.70));
                gasosa[1] = (int) ((qtdade * 0.05));
                tAditivo = tAditivo - ((qtdade * 0.05));
                gasosa[2] = (int) ((qtdade * 0.25));
                tAlcool1 = tAlcool1 - ((qtdade * 0.25) / 2);
                tAlcool2 = tAlcool2 - ((qtdade * 0.25) / 2);
                return gasosa;
            }
            if (getSituacao() == situacao.EMERGENCIA) {
                gasosa[0] = (int) ((qtdade * 0.70) / 2); // valores de gasolina aditivo e alcool encomendados.
                tGasolina = tGasolina - ((qtdade * 0.70) / 2);
                gasosa[1] = (int) ((qtdade * 0.05) / 2);
                tAditivo = tAditivo - ((qtdade * 0.05) / 2);
                gasosa[2] = (int) ((qtdade * 0.25) / 2);
                tAlcool1 = tAlcool1 - ((qtdade * 0.25) / 4);
                tAlcool2 = tAlcool2 - ((qtdade * 0.25) / 4);
                return gasosa;
            }
        }
        return gasosa;

    }

    @Override
    public String toString() {
        return "Aditivo = " + tAditivo + "\nGasolina = " + tGasolina + "\nAlcool1 = " + tAlcool1 + "\nAlcool2 = "
                + tAlcool2 + "\nSituação do posto = " + situacao;
    }
}
