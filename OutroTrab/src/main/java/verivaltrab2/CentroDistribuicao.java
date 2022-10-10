package verivaltrab2;
public class CentroDistribuicao {

	// REVISAR
	// Revisar métodos de recebimento, para ver se a qtdAArmazenar é calculada corretamente
	// Revisar entregaNPorCento, para ver se casas decimais estão sendo tratadas corretamente

	public enum SITUACAO { NORMAL, SOBRAVISO, EMERGENCIA }
	public enum TIPOPOSTO { COMUM, ESTRATEGICO }
	
	public static final int MAX_ADITIVO = 500;
	public static final int MAX_ALCOOL = 2500;
	public static final int MAX_GASOLINA = 10000;
	
	private SITUACAO situacao;
	private int tAditivo = 0;
	private int tGasolina = 0;
	private int tAlcool1 = 0;
	private int tAlcool2 = 0;
	
	public CentroDistribuicao (int tAditivo, int tGasolina, int tAlcool1, int tAlcool2) {
		// Controlar valores de entrada
		if (tAlcool1 != tAlcool2
			|| tAditivo < 0
			|| tGasolina < 0
			|| tAlcool1 < 0	// não é necessário verificar as duas; para dar erro: ou as duas são iguais, e as duas são negativas; ou as duas são diferentes, não importando se são > 0 ou < 0
			|| tAlcool1 != tAlcool2)
			throw new ILLEGAL_ARGUMENT_EXCEPTION("Algum argumento fornecido é inválido (menor que 0)");
		this.tAditivo = tAditivo;
		this.tGasolina = tGasolina;
		this.tAlcool1 = tAlcool1;
		this.tAlcool2 = tAlcool2;
		defineSituacao();
	}
	public void defineSituacao(){
		if (this.tGasolina >= MAX_GASOLINA / 2
			&& this.tAditivo >= MAX_ADITIVO / 2
			&& this.tAlcool1 + this.tAlcool2 >= MAX_ALCOOL / 2)
			this.situacao = SITUACAO.NORMAL;
		else if (this.tGasolina >= MAX_GASOLINA / 4
			&& this.tAditivo >= MAX_ADITIVO / 4
			&& this.tAlcool1 + this.tAlcool2 >= MAX_ALCOOL / 4)
			this.situacao = SITUACAO.SOBRAVISO;
		else this.situacao = SITUACAO.EMERGENCIA;
	}
	public SITUACAO getSituacao(){
		return this.situacao;
	}
	public int gettGasolina(){
		return this.tGasolina;
	}
	public int gettAditivo(){
		return this.tAditivo;
	}
	public int gettAlcool1(){
		return this.tAlcool1;
	}
	public int gettAlcool2(){
		return this.tAlcool2;
	}
	public int recebeAditivo(int qtdade) {
		if (qtdade < 0) return -1;
		int qtdAArmazenar = this.tAditivo - (MAX_ADITIVO - qtdade);
		this.tAditivo += qtdAArmazenar;
		defineSituacao();
		return qtdAArmazenar;
	}
	public int recebeGasolina(int qtdade) {
		if (qtdade < 0) return -1;
		int qtdAArmazenar = this.tGasolina - (MAX_ADITIVO - qtdade);
		this.tGasolina += qtdAArmazenar;
		defineSituacao();
		return qtdAArmazenar;
	}
	public int recebeAlcool(int qtdade) {
		if (qtdade < 0) return -1;
		int qtdAArmazenar = (this.tAlcool1 + this.tAlcool2) - (MAX_ADITIVO - qtdade);
		this.tAlcool1 += qtdAArmazenar * 10 / 2 / 10;
		this.tAlcool2 += qtdAArmazenar * 10 / 2 / 10;
		defineSituacao();
		return qtdAArmazenar - (qtdAArmazenar % 2);
	}
	public int[] encomendaCombustivel(int qtdade, TIPOPOSTO tipoPosto) {
		int[] output = new int[4];
		if (qtdade < 0) { output[0] = -7; output[1] = 0; output[2] = 0; output[3] = 0; return output; }
		switch (getSituacao()){
			case NORMAL: return entregaNPorCento(qtdade, 100);
			case SOBRAVISO: {
				switch(tipoPosto){
					case COMUM: return entregaNPorCento(qtdade, 50);
					case ESTRATEGICO: return entregaNPorCento(qtdade, 100);
				}
			}
			case EMERGENCIA: {
				switch(tipoPosto){
					case COMUM: { output[0] = -14; output[1] = 0; output[2] = 0; output[3] = 0; }; return output;
					case ESTRATEGICO: return entregaNPorCento(qtdade, 50);
				}
			}
		}
		return output;
	}

	public int[] entregaNPorCento(int qtdade, int n){
		// REVISAR
		// revisar especialmente como se trata da divisão de alcool em 2, já que (25 / 2) tem uma casa decimal diferente de zero

		int[] auxAditivo = calculaPorcentagens(tAditivo, qtdade, 5 * 100);
		int[] auxGasolina = calculaPorcentagens(tGasolina, qtdade, 70 * 100);
		int[] auxAlcool1 = calculaPorcentagens(tAlcool1, qtdade, (int) 12.5 * 100);
		int[] auxAlcool2 = calculaPorcentagens(tAlcool2, qtdade, (int) 12.5 * 100);

		if (auxAditivo[0] >= 0
			&& auxGasolina[0] >= 0
			&& auxAlcool1[0] >= 0
			&& auxAlcool2[0] >= 0
		){
			this.tAditivo = auxAditivo[0];
			this.tGasolina = auxGasolina[0];
			this.tAlcool1 = auxAlcool1[0];
			this.tAlcool2 = auxAlcool2[0];
			defineSituacao();
			int[] output = {auxAditivo[1], auxGasolina[1], auxAlcool1[1], auxAlcool2[1]};
			return output;
		}
		defineSituacao();

		int[] output = { -21, 0, 0, 0 };
		return output;
	}

	public int[] calculaPorcentagens(int tanque, int qtdade, int porcentagem){ // devolve em [0] o restante no tanque (ou erro), e, em [1], o combustível tirado
		int quantidadeDesejada = qtdade * porcentagem / 100 / 100;
		if (tanque >= quantidadeDesejada){
			int[] output = {tanque - quantidadeDesejada, quantidadeDesejada};
			return output;
		}
		return null;
	}
}
