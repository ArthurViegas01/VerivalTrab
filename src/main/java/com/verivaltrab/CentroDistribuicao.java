
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

    public CentroDistribuicao (double tAditivo, double tGasolina, double tAlcool1, double tAlcool2) {
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

    public double getGasolina(){
        return tGasolina;
    }

    public double getAditivo(){
        return tAditivo;
    }

    public double getAlcool1(){
        return tAlcool1;
    }

    public double getAlcool2(){
        return tAlcool2;
    }

    public int recebeAditivo(int qtdade) {
        if(getAditivo()<qtdade*0.05){
            return 0;
        }
        else 
        
        return (int)(qtdade*0.05);
        
    }

    public int recebeGasolina(int qtdade) {
        if(getGasolina()<qtdade*0.70){
            return 0;
        }
        else
        
        return (int)(qtdade*0.70);

    }

    public int recebeAlcool(int qtdade) {
        
        if(getAlcool1()!=getAlcool2()){
            return 0;
        }
        double alcool=0;
        alcool=getAlcool1()+getAlcool2();
        if(alcool<qtdade*0.25){
            return 0;
        }
        else
        return (int)(qtdade*0.25);

    }

    public int[] encomendaCombustivel(int qtdade, TIPOPOSTO tipoPosto) {
        
        if(tipoPosto==TIPOPOSTO.COMUM){
            if( getSituacao()==situacao){
                
            }
            if(getSituacao()==situacao){
              // return (int) (qtdade*0.25);
            }
            if(getSituacao()==situacao){
             //  return (qtdade*0);
            }
        }
        else if(tipoPosto==TIPOPOSTO.ESTRATEGICO){
            if( getSituacao()==situacao){
               // return qtdade;
             }
             if(getSituacao()==situacao){
               // return qtdade;
            }
            if(getSituacao()==situacao){
               // return (int) (qtdade*0.25);
            }
        }
     //   return 0;
        return null;

    }

    @Override
    public String toString() {
        return "Aditivo = "+tAditivo+"\nGasolina = " + tGasolina + "\nAlcool1 = " + tAlcool1 + "\nAlcool2 = " + tAlcool2+ "\nSituação do posto = " + situacao;
    }
}


