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
    //quantidade 200, situacao normal
    //posto comum 
    //resultado esperado voltar 100%
    //140 70% de gasolina testada
   
    @Test
    public void verificaCombustivel10(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(350,6000,750,750);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.ESTRATEGICO);
        Assertions.assertEquals(6000-140,centroDistribuicao0.gettGasolina());
    }
// alcool com problema 
    @Test
    public void verificaCombustivel11(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(350,6000,750,750);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.ESTRATEGICO);
        Assertions.assertEquals(750-25,centroDistribuicao0.gettAlcool1());
        Assertions.assertEquals(750-25,centroDistribuicao0.gettAlcool2());
    }

    @Test
    public void verificaCombustivel12(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(350,6000,750,750);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.ESTRATEGICO);
        Assertions.assertEquals(350-10,centroDistribuicao0.gettAditivo());
       
    }


    //quantidade 200, situacao sobaviso
    //posto comum 
    //resultado esperado voltar 50% do total solicitado
    //70 litros 70% de gasolina 

    @Test
    public void verificaCombustivel100(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(248,4000,618,618);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.ESTRATEGICO);
        Assertions.assertEquals(4000-140,centroDistribuicao0.gettGasolina());
    }
// alcool com problema 
    @Test
    public void verificaCombustivel101(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(248,4000,618,618);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.ESTRATEGICO);
        Assertions.assertEquals(618-25,centroDistribuicao0.gettAlcool1());
        Assertions.assertEquals(618-25,centroDistribuicao0.gettAlcool2());
    }

    @Test
    public void verificaCombustivel102(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(248,4000,618,618);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.ESTRATEGICO);
        Assertions.assertEquals(248-10,centroDistribuicao0.gettAditivo());
       
    }
    //quantidade 200, situacao emergencia
    //posto comum
    //resultado esperado voltar 0 do total solicitado
    @Test
    public void verificaCombustivel121(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(100,2000,340,340);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.ESTRATEGICO);
        Assertions.assertEquals(2000-140,centroDistribuicao0.gettGasolina());
    }
    @Test
    public void verificaCombustivel131(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(100,2000,340,340);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.ESTRATEGICO);
        Assertions.assertEquals(340-25,centroDistribuicao0.gettAlcool1());
        Assertions.assertEquals(340-25,centroDistribuicao0.gettAlcool2());
    }
    @Test
    public void verificaCombustivel132(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(100,2000,340,340);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.ESTRATEGICO);
        Assertions.assertEquals(100-0,centroDistribuicao0.gettAditivo());
    }


     //quantidade 200, situacao normal
    //posto comum 
    //resultado esperado voltar 100%
    //140 70% de gasolina testada
    @Test
    public void verificaCombustivel0(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(350,6000,750,750);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.ESTRATEGICO);
        Assertions.assertEquals(6000-140,centroDistribuicao0.gettGasolina());
    }
// alcool com problema 
    @Test
    public void verificaCombustivel1(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(350,6000,750,750);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.ESTRATEGICO);
        Assertions.assertEquals(750-25,centroDistribuicao0.gettAlcool1());
        Assertions.assertEquals(750-25,centroDistribuicao0.gettAlcool2());
    }

    @Test
    public void verificaCombustivel2(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(350,6000,750,750);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.ESTRATEGICO);
        Assertions.assertEquals(350-10,centroDistribuicao0.gettAditivo());
       
    }


    //quantidade 200, situacao sobaviso
    //posto estrategico
    //resultado esperado voltar 50% do total solicitado
     

    @Test
    public void verificaCombustivel00(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(248,4000,618,618);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.ESTRATEGICO);
        Assertions.assertEquals(4000-140,centroDistribuicao0.gettGasolina());
    }
// alcool com problema 
    @Test
    public void verificaCombustivel01(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(248,4000,618,618);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.ESTRATEGICO);
        Assertions.assertEquals(618-25,centroDistribuicao0.gettAlcool1());
        Assertions.assertEquals(618-25,centroDistribuicao0.gettAlcool2());
    }

    @Test
    public void verificaCombustivel02(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(248,4000,618,618);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.ESTRATEGICO);
        Assertions.assertEquals(248-10,centroDistribuicao0.gettAditivo());
       
    }
    //quantidade 200, situacao emergencia
    //posto estrategico
    //resultado esperado voltar 50% do total solicitado
    @Test
    public void verificaCombustivel000(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(100,2000,340,340);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.ESTRATEGICO);
        Assertions.assertEquals(2000-140,centroDistribuicao0.gettGasolina());
    }
    @Test
    public void verificaCombustivel001(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(100,2000,340,340);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.ESTRATEGICO);
        Assertions.assertEquals(340-25,centroDistribuicao0.gettAlcool1());
        Assertions.assertEquals(340-25,centroDistribuicao0.gettAlcool2());
    }
    @Test
    public void verificaCombustivel002(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(100,2000,340,340);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.ESTRATEGICO);
        Assertions.assertEquals(100-5,centroDistribuicao0.gettAditivo());
    }

}

