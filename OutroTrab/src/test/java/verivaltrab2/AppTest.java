package verivaltrab2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import verivaltrab2.CentroDistribuicao.SITUACAO;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
   
    //T1
    // gasolina ==50% de seu estoque, o resto em 60% 
    @Test
    public void verificaSituacao1(){
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(320, 5000, 750, 750);

       Assertions.assertEquals(SITUACAO.NORMAL,centroDistribuicao1.getSituacao());
    }
    //T2
    //gasolina ==49% de seu tanque, o resto em 60%
    //resultado esperado SITUACAO AVISO
    @Test
    public void verificaSituacao2(){
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(320, 4999, 750, 750);
     

       Assertions.assertEquals(SITUACAO.SOBRAVISO,centroDistribuicao1.getSituacao());
    }

    //T3
    // gasolina ==25% de seu tanque, o resto em 49%
    //resultado esperado SITUACAO AVISO
    @Test
    public void verificaSituacao3(){
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(249, 2500, 624, 624);
     

        Assertions.assertEquals(SITUACAO.SOBRAVISO,centroDistribuicao1.getSituacao());
    }


    //T4
    // gasolina ==24%, o resto em 49%
    //resultado esperado SITUACAO EMERGENCIA
    @Test
    public void verificaSituacao4(){
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(249, 2499, 1249, 1249);
     

       Assertions.assertEquals(SITUACAO.EMERGENCIA,centroDistribuicao1.getSituacao());
    }

    //T5
    //adivito ==50% de seu tanque, o resto em 60%
    //resultado esperado SITUACAO NORMAL
    @Test
    public void verificaSituacao5(){
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(250, 6000, 1500, 1500);
     

        Assertions.assertEquals(SITUACAO.NORMAL,centroDistribuicao1.getSituacao());
    }
    //T6
    //aditivo ==49% de seu tanque, o resto em 60%
    //resultado esperado SITUACAO AVISO

    @Test
    public void verificaSituacao6(){
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(249, 6000, 1500, 1500);
     

        Assertions.assertEquals(SITUACAO.SOBRAVISO,centroDistribuicao1.getSituacao());
    }

    //T7
    // aditivo ==25%, o resto em 49%
    //resultado esperado SITUACAO SOBRAVISO
    @Test
    public void verificaSituacao7(){
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(125, 2501, 1249, 1249);
     

        Assertions.assertEquals(SITUACAO.SOBRAVISO,centroDistribuicao1.getSituacao());
    }
     
    //T8
    //adivito ==24% de seu tanque, o resto em 40%
    //resultado esperado SITUACAO EMERGENCIA
    @Test
    public void verificaSituacao8(){
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(124, 4000, 1000, 1000);
     

        Assertions.assertEquals(SITUACAO.EMERGENCIA,centroDistribuicao1.getSituacao());
    }
     
    //9
    // alcool ==50% de seu estoque, o resto em 60%
    //resultado esperado SITUACAO NORMAL
    @Test
    public void verificaSituacao9(){
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(320, 6000, 750, 750);
     

        Assertions.assertEquals(SITUACAO.NORMAL,centroDistribuicao1.getSituacao());
    }
    //T10
    //alcool ==49% de seu tanque, o resto em 60%
    //resultado esperado SITUACAO AVISO
    @Test
    public void verificaSituacao10(){
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(320, 6000, 624, 624);
     

        Assertions.assertEquals(SITUACAO.SOBRAVISO,centroDistribuicao1.getSituacao());
    }
    //T11
    //alcool ==25% de seu tanque, o resto em 49%
    //resultado esperado SITUACAO AVISO
    @Test
    public void verificaSituacao11(){
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(249, 4999, 313, 313);
     

        Assertions.assertEquals(SITUACAO.SOBRAVISO,centroDistribuicao1.getSituacao());
    }


    //12
    // alcool ==24%, o resto em 49%
    //resultado esperado SITUACAO EMERGENCIA
    @Test
    public void verificaSituacao12(){
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(249, 4999, 312, 312);
     

        Assertions.assertEquals(SITUACAO.EMERGENCIA,centroDistribuicao1.getSituacao());
    }
    //13
    //centro distribuicao inicializado com valores diferentes nos tanques
    //alcool1 != alcool2
    //resultado esperado problema no sistema
    // @Test
    // public void verificaSituacao13(){
    //     CentroDistribuicao centroDistribuicao = new CentroDistribuicao(249, 2499, 1289, 1249);
     

       
    // }


}