
public class Jogador {
	String nome;
	String numero;
	String dataNascimento;
	String rg;
	String nacionalidade;
	EstatisticaDoJogador estatisticaDoJogador;
	
	public Jogador() {
		this("","","","","", new EstatisticaDoJogador());
		
	}
	public Jogador(String nome, String numero, String dataNascimento, String rg, String nacionalidade,EstatisticaDoJogador estatisticadojogador) {
		this.nome = nome;
		this.numero = numero;
		this.dataNascimento = dataNascimento;
		this.rg = rg;
		this.nacionalidade= nacionalidade;
		this.estatisticaDoJogador=estatisticadojogador;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String toString() {
		return "Nome: "+this.nome + "\nNumero: "+ numero + "\nDataNascimento: "+ dataNascimento+ "\nRG: "+ rg + "\nDados: "+"\nNacionalidade: "+ nacionalidade+ this.estatisticaDoJogador.toString();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public EstatisticaDoJogador getEstatisticaDoJogador() {
		return estatisticaDoJogador;
	}

	public void setEstatisticaDoJogador(EstatisticaDoJogador estatisticaDoJogador) {
		this.estatisticaDoJogador=estatisticaDoJogador;
	}


}
