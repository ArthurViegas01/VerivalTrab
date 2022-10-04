package com.verivaltrab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.verivaltrab.CentroDistribuicao.SITUACAO;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    CentroDistribuicao centroDistribuicao4 = new CentroDistribuicao(300, 6000, 700, 700);
    //Tem que estar normal

    CentroDistribuicao centroDistribuicao5 = new CentroDistribuicao(200, 4000, 600, 600);
    //Tem que estar sobraviso

    CentroDistribuicao centroDistribuicao6 = new CentroDistribuicao(120, 2000, 300, 300);
    //Tem que estar emergencia

    @Test
    public void verificaGetCentroDistribuicao(){
        centroDistribuicao4.getSituacao();
        Assertions.assertEquals(SITUACAO.NORMAL,centroDistribuicao4.getSituacao());
    }
}
