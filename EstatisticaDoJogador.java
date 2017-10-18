

public class EstatisticaDoJogador {

	int gols;
	int quantCartaoAmarelo;
	int quantCartaoVermelho;
	int totalDeCartoes;
	int totalDeCartoesAmarelo;
	int totalDeCartoesVermelho;
	
	public int getTotalDeCartoes() {
		return totalDeCartoes;
	}
	public void setTotalDeCartoes(int totalDeCartoes) {
		this.totalDeCartoes = totalDeCartoes;
	}
	public int getTotalDeCartoesAmarelo() {
		return totalDeCartoesAmarelo;
	}
	public void setTotalDeCartoesAmarelo(int totalDeCartoesAmarelo) {
		this.totalDeCartoesAmarelo = totalDeCartoesAmarelo;
	}
	public int getTotalDeCartoesVermelho() {
		return totalDeCartoesVermelho;
	}
	public void setTotalDeCartoesVermelho(int totalDeCartoesVermelho) {
		this.totalDeCartoesVermelho = totalDeCartoesVermelho;
	}
	public EstatisticaDoJogador() {
		this.gols=0;
		this.quantCartaoAmarelo=0;
		this.quantCartaoVermelho=0;
		this.totalDeCartoes=0;
		this.totalDeCartoesAmarelo=0;
		this.totalDeCartoesVermelho=0;
	}
	public EstatisticaDoJogador(int gols, int quantCartaoAmarelo, int quantCartaoVermelho, int totalDeCartoes, int totalDeCartoesAmarelo, int totalDeCartoesVermelho) {
		this.gols = gols;
		this.quantCartaoAmarelo = quantCartaoAmarelo;
		this.quantCartaoVermelho = quantCartaoVermelho;
		this.totalDeCartoes=totalDeCartoes;
		this.totalDeCartoesAmarelo=totalDeCartoesAmarelo;
		this.totalDeCartoesVermelho=totalDeCartoesVermelho;
	}
	

	@Override
	public String toString() {
		return "Estatistica Do Jogador \nGol(s)=" + gols + "\nCartão(s) Amarelo(s)=" + totalDeCartoesAmarelo
				+ "\nCartão Vermelho=" + totalDeCartoesVermelho;
	}
	
	public int getGols() {
		return gols;
	}
	
	public void setGols(int gols) {
		this.gols = gols;
	}
	
	public int getQuantCartaoAmarelo() {
		return quantCartaoAmarelo;
	}
	
	public void setQuantCartaoAmarelo(int quantCartaoAmarelo) {
		this.quantCartaoAmarelo = quantCartaoAmarelo;
	}
	
	public int getQuantCartaoVermelho() {
		return quantCartaoVermelho;
	}
	
	public void setQuantCartaoVermelho(int quantCartaoVermelho) {
		this.quantCartaoVermelho = quantCartaoVermelho;
	}
    

	
	

}
