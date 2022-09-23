/*Programa criado por

Arthur Viegas
Israel Garcia
Pedro Fonseca

*/

public class App{

    /*
        Tipos de Componentes:
            Aditivo(TAD):500 lts
            Gasolina Pura(TG1): 10000 lts
            Alcool(TA1): 1250 lts
            Alcool(TA2): 1250 lts

        Tipos de postos:
            Comuns: atendem a população geral
            Estratégicos: atendem ambulâncias e carro de policia


        Regras:
            Se houver falta de qualquer um dos componentes na quantidade adequada a encomenda não pode ser entregue.

            Os tanques de álcool devem ter sempre a mesma quantidade de combustível de maneira a manter o equilíbrio da estrutura devido a forma como foram construídos. Isso vale tanto para o armazenamento como para a retirada.

            Até 50% = Modo Normal
            Entre 50% e 25% = Modo Sobraviso
            Menos de 25% = Modo Emergência

            Normal: Não muda nada

            Sobraviso{
                Entrega 50% do pedido para Postos Comuns e 100% para postos Estratégicos
            }

            Emergência{
                Não entrega para postos comuns e enterga 50% para postos estratégicos
            }

        CentroDistribuicao(Recebe Quantidades de gasolinas nos tanques e ajusta situacao)
      
    */
    public static void main(String args[]){

    }
}