package verivaltrab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import verivaltrab.CentroDistribuicao.SITUACAO;

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

    CentroDistribuicao centroDistribuicao7 = new CentroDistribuicao(50, 50, 50, 50);


    @Test
    public void verificaGetCentroDistribuicao(){
        Assertions.assertEquals(SITUACAO.NORMAL,centroDistribuicao4.getSituacao());
        Assertions.assertEquals(SITUACAO.SOBRAVISO,centroDistribuicao5.getSituacao());
        Assertions.assertEquals(SITUACAO.EMERGENCIA ,centroDistribuicao6.getSituacao());
        //Assertions.assertEquals(SITUACAO.NORMAL ,centroDistribuicao7.getSituacao());

        

    }
}
