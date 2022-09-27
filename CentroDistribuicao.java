
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

    public CentroDistribuicao (int tAditivo, int tGasolina, int tAlcool1, int tAlcool2) {
        this.tAditivo=tAditivo;
        this.tGasolina=tGasolina;
        this.tAlcool1=tAlcool1;
        this.tAlcool2=tAlcool2;
    }

    // public void defineSituacao(String situacao){
    //     SIUACAO(String situacao){this.siuacao=situacao}
    // }

    public SITUACAO getSituacao(){
        if(getGasolina()<=(MAX_GASOLINA/2)){
            if(getAlcool1()+getAlcool2()<=(MAX_ALCOOL/2)){
                if(tAditivo<=(MAX_ADITIVO/2)){
                    return SITUACAO.EMERGENCIA;
                }
            }
        }
        // if(getGasolina()<=(MAX_GASOLINA/2)){
        //     if(getAlcool1()+getAlcool2()<=(MAX_ALCOOL/2)){
        //         if(tAditivo<=(MAX_ADITIVO/2)){
        //             return SITUACAO.EMERGENCIA;
        //         }
        //     }
        // }
        return SITUACAO.NORMAL; 
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
