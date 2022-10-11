package verivaltrab2;

import java.beans.Transient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import verivaltrab.CentroDistribuicao.SITUACAO;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    public CentroDistribuicao centroDistribuicao1 = new CentroDistribuicao(5000, 7000, 1250, 1250);
    
    // @Test
    // public void verificaGetCentroDistribuicao(){
       
    //     Assertions.assertEquals(NORMAL.getSituacao(),centroDistribuicao1.getSituacao());
    // }
   
    //T1
    // gasolina ==50% de seu estoque, o resto em 60%
    @Test
    public void verificaSituacao(){
        int combustível=1000;
       centroDistribuicao1.encomendaCombustivel(500,SITUACAO.COMUM);

       Assertions.assertEquals(5000-350,centroDistribuicao1.gettGasolina());
    }
    //T2
    //gasolina ==49% de seu tanque, o resto em 80%
    //resultado esperado SITUACAO AVISO

    //T3
    // gasolina ==25% de seu tanque, o resto em 50%
    //resultado esperado SITUACAO AVISO



    //T4
    // gasolina ==24%, o resto em 50%
    //resultado esperado SITUACAO EMERGENCIA
    

    //T5
    //adivito ==49% de seu tanque, o resto em 80%
    //resultado esperado SITUACAO AVISO

    //T6
    //aditivo ==25% de seu tanque, o resto em 50%
    //resultado esperado SITUACAO AVISO



    //T7
    // aditivo ==24%, o resto em 50%
    //resultado esperado SITUACAO EMERGENCIA

     
    //T8
    // gasolina ==50% de seu estoque, o resto em 60%

    //T9
    //alcool ==49% de seu tanque, o resto em 80%
    //resultado esperado SITUACAO AVISO

    //T10
    //alcool ==25% de seu tanque, o resto em 50%
    //resultado esperado SITUACAO AVISO



    //11
    // alcool ==24%, o resto em 50%
    //resultado esperado SITUACAO EMERGENCIA

     
    //12
    // alcool ==50% de seu estoque, o resto em 60%
    //resultado esperado SITUACAO NORMAL

    //13
    //centro distribuicao inicializado com valores diferentes nos tanques
    //alcool1 != alcool2
    //resultado esperado problema no sistema



}
