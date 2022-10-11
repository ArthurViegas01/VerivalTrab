package verivaltrab2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import verivaltrab2.CentroDistribuicao.SITUACAO;
import verivaltrab2.CentroDistribuicao.TIPOPOSTO;

/**
 * Unit test for simple App.
 */
public class AppTest 
{   

    private static final Object ILLEGAL_ARGUMENT_EXCEPTION = null;

    //T1
    //Gasolina em 50% e o resto em 60% 
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
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(249, 2499, 624, 624);
     

       Assertions.assertEquals(SITUACAO.EMERGENCIA,centroDistribuicao1.getSituacao());
    }

    //T5
    //adivito ==50% de seu tanque, o resto em 60%
    //resultado esperado SITUACAO NORMAL
    @Test
    public void verificaSituacao5(){
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(250, 6000, 750, 750);
     

        Assertions.assertEquals(SITUACAO.NORMAL,centroDistribuicao1.getSituacao());
    }
    //T6
    //aditivo ==49% de seu tanque, o resto em 60%
    //resultado esperado SITUACAO AVISO

    @Test
    public void verificaSituacao6(){
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(249, 6000, 750, 750);
     

        Assertions.assertEquals(SITUACAO.SOBRAVISO,centroDistribuicao1.getSituacao());
    }

    //T7
    // aditivo ==25%, o resto em 49%
    //resultado esperado SITUACAO SOBRAVISO
    @Test
    public void verificaSituacao7(){
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(125, 4999, 611, 611);
     

        Assertions.assertEquals(SITUACAO.SOBRAVISO,centroDistribuicao1.getSituacao());
    }
     
    //T8
    //adivito ==24% de seu tanque, o resto em 49%
    //resultado esperado SITUACAO EMERGENCIA
    @Test
    public void verificaSituacao8(){
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(124, 4000, 611, 611);
     

        Assertions.assertEquals(SITUACAO.EMERGENCIA,centroDistribuicao1.getSituacao());
    }
     
    //9
    // alcool ==50% de seu estoque, o resto em 60%
    //resultado esperado SITUACAO NORMAL
    @Test
    public void verificaSituacao9(){
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(320, 6000, 650, 650);
     

        Assertions.assertEquals(SITUACAO.NORMAL,centroDistribuicao1.getSituacao());
    }
    //T10
    //alcool ==49% de seu tanque, o resto em 60%
    //resultado esperado SITUACAO AVISO
    @Test
    public void verificaSituacao10(){
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(320, 6000, 612, 612);

        Assertions.assertEquals(SITUACAO.SOBRAVISO,centroDistribuicao1.getSituacao());
    }
    //T11
    //alcool ==25% de seu tanque, o resto em 49%
    //resultado esperado SITUACAO AVISO
    @Test
    public void verificaSituacao11(){
        CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(250, 4999, 313, 313);
     

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
    //posto estrategico
    //resultado esperado voltar 100%
    //140 70% de gasolina testada
    @Test
    public void ververificaCombustivelNormalG(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(350,6000,750,750);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.COMUM);
        Assertions.assertEquals(6000-140,centroDistribuicao0.gettGasolina());
    }

    // alcool com problema 
    @Test
    public void verificaCombustivelNormalAL(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(350,6000,750,750);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.COMUM);
        Assertions.assertEquals(750-25,centroDistribuicao0.gettAlcool1());
        Assertions.assertEquals(750-25,centroDistribuicao0.gettAlcool2());
    }

    @Test
    public void verificaCombustivelNormalAD(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(350,6000,750,750);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.COMUM);
        Assertions.assertEquals(350-10,centroDistribuicao0.gettAditivo());
       
    }


    //quantidade 200, situacao sobaviso
    //posto comum 
    //resultado esperado voltar 50% do total solicitado

    //Em postos comuns e em situação de sobraviso, o posto deve retornar apenas 50% da gasolina encomendada
    //porém o programa não estava fazendo o desconto
    @Test
    public void verificaCombustivelComumGS(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(248,4000,618,618);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.COMUM);
        Assertions.assertEquals(4000-70,centroDistribuicao0.gettGasolina());
    }

    @Test
    public void verificaCombustivelComumALS(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(248,4000,618,618);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.COMUM);
        Assertions.assertEquals(618-12.5,centroDistribuicao0.gettAlcool1());
        Assertions.assertEquals(618-12.5,centroDistribuicao0.gettAlcool2());
    }

    @Test
    public void verificaCombustivelComumADS(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(248,4000,618,618);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.COMUM);
        Assertions.assertEquals(248-5,centroDistribuicao0.gettAditivo());
       
    }
    //quantidade 200, situacao emergencia
    //posto comum
    //resultado esperado voltar 0 do total solicitado
    @Test
    public void verificaCombustivelComumGE(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(100,2000,340,340);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.COMUM);
        Assertions.assertEquals(2000-0,centroDistribuicao0.gettGasolina());
    }
    @Test
    public void verificaCombustivelComumALE(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(100,2000,340,340);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.COMUM);
        Assertions.assertEquals(340-0,centroDistribuicao0.gettAlcool1());
        Assertions.assertEquals(340-0,centroDistribuicao0.gettAlcool2());
    }
    @Test
    public void verificaCombustivelComumADE(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(100,2000,340,340);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.COMUM);
        Assertions.assertEquals(100-0,centroDistribuicao0.gettAditivo());
    }


     //quantidade 200, situacao normal
    //posto estrategico 
    //resultado esperado voltar 100%
    
    @Test
    public void verificaCombustivelEstrategicoCG(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(350,6000,750,750);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.ESTRATEGICO);
        Assertions.assertEquals(6000-140,centroDistribuicao0.gettGasolina());
    }
// alcool com problema 
    @Test
    public void verificaCombustivelEstrategicoCAL(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(350,6000,750,750);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.ESTRATEGICO);
        Assertions.assertEquals(750-25,centroDistribuicao0.gettAlcool1());
        Assertions.assertEquals(750-25,centroDistribuicao0.gettAlcool2());
    }

    @Test
    public void verificaCombustivelEstrategicoCAD(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(350,6000,750,750);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.ESTRATEGICO);
        Assertions.assertEquals(350-10,centroDistribuicao0.gettAditivo());
       
    }


    //quantidade 200, situacao sobaviso
    //posto estrategico
    //resultado esperado voltar 100% do total solicitado
     

    @Test
    public void verificaCombustivelEstrategicoSG(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(248,4000,618,618);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.ESTRATEGICO);
        Assertions.assertEquals(4000-140,centroDistribuicao0.gettGasolina());
    }
// alcool com problema 
    @Test
    public void verificaCombustivelEstrategicoSAL(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(248,4000,618,618);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.ESTRATEGICO);
        Assertions.assertEquals(618-25,centroDistribuicao0.gettAlcool1());
        Assertions.assertEquals(618-25,centroDistribuicao0.gettAlcool2());
    }

    @Test
    public void verificaCombustivelEstrategicoSAD(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(248,4000,618,618);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.ESTRATEGICO);
        Assertions.assertEquals(248-10,centroDistribuicao0.gettAditivo());
       
    }
    //Em postos estratégicos, quando a situação for de emergencia o posto deve entregar
    //apenas 50% da gasolina encomendada, porém o programa não faz o desconto na situação de emergência
    @Test
    public void verificaCombustivelEstrategicoEG(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(100,2000,340,340);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.ESTRATEGICO);
        Assertions.assertEquals(2000-70,centroDistribuicao0.gettGasolina());
    }
    @Test
    public void verificaCombustivelEstrategicoEAL(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(100,2000,340,340);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.ESTRATEGICO);
        Assertions.assertEquals(340-12.5,centroDistribuicao0.gettAlcool1());
        Assertions.assertEquals(340-12.5,centroDistribuicao0.gettAlcool2());
    }
    @Test
    public void verificaCombustivelEstrategicoEAD(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(100,2000,340,340);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.ESTRATEGICO);
        Assertions.assertEquals(100-5,centroDistribuicao0.gettAditivo());
    }

    //acima do limite pertitido de capacidade dos tanques
    @Test 
    public void verificaCapacidadeMaxima(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(600, 11000, 1251, 1251);
        Assertions.assertEquals(ILLEGAL_ARGUMENT_EXCEPTION,centroDistribuicao0.getSituacao());
    } 
    
    @Test
    public void verificaPedidoAcimaCapacidade(){
        CentroDistribuicao centroDistribuicao0 = new CentroDistribuicao(4,2000, 320, 320);
        centroDistribuicao0.encomendaCombustivel(200,TIPOPOSTO.ESTRATEGICO); 
        Assertions.assertEquals(4-5,centroDistribuicao0.gettAditivo());
    }



}

