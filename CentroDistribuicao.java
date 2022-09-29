
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

    private int tAditivo;
    private int tAlcool2;
    private int tAlcool1;
    private int tGasolina;
    private SITUACAO situacao;

    public CentroDistribuicao (int tAditivo, int tGasolina, int tAlcool1, int tAlcool2) {
        this.tAditivo = tAditivo;
        this.tGasolina = tGasolina;
        this.tAlcool1 = tAlcool1;
        this.tAlcool2 = tAlcool2;
        this.situacao = SITUACAO.SOBRAVISO;
    }

    public void defineSituacao() {
        if( (tGasolina <= (MAX_GASOLINA/2)) && (tGasolina >= (MAX_GASOLINA/4)) ) {
            if((tAlcool1 + tAlcool2 <= (MAX_ALCOOL/2)) && (tAlcool1 + tAlcool2 <= (MAX_ALCOOL/4))) {
                if((tAditivo <= (MAX_ADITIVO/2))&&(tAditivo <= (MAX_ADITIVO/4))) {
                    situacao = SITUACAO.SOBRAVISO;
                }
            }
        }
        if(tGasolina <= (MAX_GASOLINA/4)){
            if(tAlcool1+tAlcool2 <= (MAX_ALCOOL/4)){
                if(tAditivo <= (MAX_ADITIVO/4)){
                    situacao = SITUACAO.EMERGENCIA;
                }
            }
        }
        situacao = SITUACAO.NORMAL; 


    }

    public SITUACAO getSituacao(){
        return situacao;
    }

    public int getGasolina(){
        return tGasolina;
    }

    public int getAditivo(){
        return tAditivo;
    }

    public int getAlcool1(){
        return  tAlcool1;
    }

    public int getAlcool2(){
        return tAlcool2;
    }

    public int recebeAditivo(int qtdade) {
        return qtdade;
        
    }

    public int recebeGasolina(int qtdade) {
        return qtdade;

    }

    public int recebeAlcool(int qtdade) {
        return qtdade;

    }

    public int[] encomendaCombustivel(int qtdade, TIPOPOSTO tipoPosto) {
        return null;

    }
}
