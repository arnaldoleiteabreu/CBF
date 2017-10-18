import java.util.ArrayList;
import java.util.List;

public class SistemaList{
	List<Jogador> jogadores;
	List<ClubeFutebol> clubes;
	List<Jogador> jogadoresSuspenso;
	List<Jogador> jogadoresArtilheiro;
	
	
	public SistemaList() {
		this.jogadores= new ArrayList<Jogador>();
		this.clubes= new ArrayList<ClubeFutebol>();
		this.jogadoresSuspenso= new ArrayList<Jogador>();
		this.jogadoresArtilheiro= new ArrayList<Jogador>();
		
	}
	
	public void cadastraJogador(Jogador jog) throws JogadorJaExisteException{
		for(Jogador j: this.jogadores) {
			if(j.getRg().equals(jog.getRg())) {
				throw new JogadorJaExisteException("Já existe jogador com rg"+jog.getRg());
				
			}
		}
		this.jogadores.add(jog);
	}
	
	public void removeClube(String nomeClube) throws ClubeNaoExisteException{
		boolean opcao = true;
		for(int k=0; k<clubes.size(); k++) {
			if(clubes.get(k).getNomeClube().equals(nomeClube)) {
				this.clubes.remove(clubes.get(k));
				opcao= false;
			}
			if(opcao==true) {
				throw new ClubeNaoExisteException("Clube não existe ");
			}
		}
	}
	public void removeJogador(String rg) throws JogadorNaoExisteException{
		boolean opcao = true;
		for(int k=0; k<jogadores.size(); k++) {
			if(jogadores.get(k).getRg().equals(rg)) {
				this.jogadores.remove(jogadores.get(k));
				opcao= false;
			}
			if(opcao==true) {
				throw new JogadorNaoExisteException("Jogador não existe com o RG pesquisado ");
			}
		}
	}
	public List<Jogador> getListaDeJogadoresSuspenso(){
		return this.jogadoresSuspenso;
		
	}
	public List<Jogador> getListaDeJogadoresArtilheiros(){
		return this.jogadoresArtilheiro;
	}
	public String pesquisaJogadorPeloNumero2(String numero) throws JogadorNaoExisteException{
		String novo="";
		for(Jogador j: this.jogadores) {
			if(j.getNumero().equals(numero)) {
				novo=j.getNumero();
				
			}
				
			}
		return novo;
	}
	public String pesquisaJogadorPeloNome2(String nome) throws JogadorNaoExisteException{
		String novo="";
		for(Jogador j: this.jogadores) {
			if(j.getNome().equals(nome)) {
				novo=j.getNome();
				
			}
				
			}
		return novo;
	}
	public String pesquisaJogadorPelaDataDeNascimento2(String data) throws JogadorNaoExisteException{
		String novo="";
		for(Jogador j: this.jogadores) {
			if(j.getDataNascimento().equals(data)) {
				novo=j.getDataNascimento();
				
			}
				
			}
		return novo;
	}
	public String pesquisaJogadorPeloNacionalidade2(String nacionalidade) throws JogadorNaoExisteException{
		String novo="";
		for(Jogador j: this.jogadores) {
			if(j.getNacionalidade().equals(nacionalidade)) {
				novo=j.getNacionalidade();
				
			}
				
			}
		return novo;
	}
	public List<Jogador> pesquisaJogadorPeloNome (String nomeJogador)throws JogadorNaoExisteException{
		ArrayList<Jogador> lista= new ArrayList<Jogador>();
		for(Jogador j: this.jogadores) {
			if(j.getNome().equals(nomeJogador)) {
				lista.add(j);
			}
		}
		return lista;
	}
	
	public List<Jogador> pesquisaJogadorPeloNumero(String numero) throws JogadorNaoExisteException{
		ArrayList<Jogador> lista= new ArrayList<Jogador>();
		for(Jogador j: this.jogadores) {
			if(j.getNumero().equals(numero)) {
				lista.add(j);
			}
		}
		return lista;
	}
	public List<Jogador> pesquisaJogadorPeleDataNascimento(String dataNascimento)throws JogadorNaoExisteException{
		ArrayList<Jogador> lista= new ArrayList<Jogador>();
		for(Jogador j: this.jogadores) {
			if(j.getDataNascimento().equals(dataNascimento)) {
				lista.add(j);
			}
		}
		return lista;
	}
	
	public List<Jogador> pesquisaJogadorPelaNacionalidade(String nacionalidade)throws JogadorNaoExisteException{
		ArrayList<Jogador> lista= new ArrayList<Jogador>();
		for(Jogador j: this.jogadores) {
			if(j.getNacionalidade().equals(nacionalidade)) {
				lista.add(j);
			}
		}
		return lista;
	}
	 
	public Jogador pesquisaJogador(String rg) throws JogadorNaoExisteException{
		for(Jogador j: this.jogadores) {
			if(j.getRg().equals(rg)){
				return j;
			}
		}
		throw new JogadorNaoExisteException("Não existe jogador com esse rg");
		
	}
	public void increveJogadorNoClube(String rg, String nomeTime)throws JogadorNaoExisteException, ClubeNaoExisteException{
		boolean opcao= true;
		boolean opcao2= true;
		for(Jogador j: this.jogadores) {
			if(j.getRg().equals(rg)) {
				opcao= false;
				for(ClubeFutebol c: this.clubes) {
					if(c.getNomeClube().equals(nomeTime)) {
						c.adiciona(j);
						opcao2= false;
					}
				}
			}
		}
		if(opcao==true) {
			throw new JogadorNaoExisteException("Não existe jogador com esse rg");
		}
		if(opcao2==true) {
			throw new ClubeNaoExisteException("Não existe clube com esse nome");
		}
	}
	
	public List<Jogador> getListaTotalDeJogadores(){
		return this.jogadores;
	}
	
	public List<Jogador> getJogadoresDoClube(String nomeClube) throws ClubeNaoExisteException{
		for(ClubeFutebol c: this.clubes) {
			if(c.getNomeClube().equals(nomeClube)) {
				return c.getJogadores();
			}
			throw new ClubeNaoExisteException("Não existe clube com esse nome");
		}
		return null;
	}
	
	public void cadastraClube(ClubeFutebol c) throws ClubeJaExisteException{
		for(ClubeFutebol f: this.clubes) {
			if(f.equals(c)) {
				throw new ClubeJaExisteException("Já existe esse clube: ");
			}
			
		}
		this.clubes.add(c);
	}
	public void adicionaCartao(String cartao, String jogadorNome){
		int totalCartoesAmarelos=3;
		int zerarCartoes=0;
		for(Jogador j: this.jogadores) {
			if(j.getNome().equals(jogadorNome)) {
				if(cartao.equals("vermelho")) {
					this.jogadoresSuspenso.add(j);
					j.getEstatisticaDoJogador().setQuantCartaoAmarelo(zerarCartoes);
					j.getEstatisticaDoJogador().totalDeCartoesVermelho+=1;
				}else {
					j.getEstatisticaDoJogador().setQuantCartaoAmarelo(j.getEstatisticaDoJogador().getQuantCartaoAmarelo()+1);
					if(j.getEstatisticaDoJogador().getQuantCartaoAmarelo()==totalCartoesAmarelos) {
						this.jogadoresSuspenso.add(j);
						//j.getEstatisticaDoJogador().setQuantCartaoAmarelo(zerarCartoes);;
						j.getEstatisticaDoJogador().totalDeCartoesAmarelo+=1;

					}
					
				}
			}
		}	
	}
	public int mostraTotalDeCartoes(String nomeJogador) {
		int x=0;
		int y=0;
		for(Jogador j: this.jogadores) {
			x=j.getEstatisticaDoJogador().getTotalDeCartoesVermelho();
			y=x+j.getEstatisticaDoJogador().getTotalDeCartoesAmarelo();
		}
		return y;
		
	}
	
	public void adicionaGol(String nomeJogador, int quantGols) {
		for(Jogador j: this.jogadores) {
			if(j.getNome().equals(nomeJogador)) {
				j.getEstatisticaDoJogador().setGols(j.getEstatisticaDoJogador().getGols()+quantGols);
				boolean x=true;
				for(int k=0; k<jogadoresArtilheiro.size();k++) {
					if(jogadoresArtilheiro.get(k).equals(j)) {
						jogadoresArtilheiro.set(k, j);
						x=false;
					}
				}
				
				if(x) {
					this.jogadoresArtilheiro.add(j);
				}
			}
		}
	}
	
	public List<Jogador> getListaDeArtilheiro(){
		for(int k=0;k<this.jogadoresArtilheiro.size();k++) {
			int index=k;
			for(int j=k+1; j<this.jogadoresArtilheiro.size(); j++) {
				if(this.jogadoresArtilheiro.get(index).getEstatisticaDoJogador().getGols()<this.jogadoresArtilheiro.get(j).getEstatisticaDoJogador().getGols()) {
					index=j;
				}
			}
			if(index!=k) {
				Jogador x=this.jogadoresArtilheiro.get(k);
				this.jogadoresArtilheiro.set(k, this.jogadoresArtilheiro.get(index));
				this.jogadoresArtilheiro.set(index,x);
			}
		}
		return this.jogadoresArtilheiro;
		
	}
	public List<Jogador> pesquisaClube(String nomeTime) throws ClubeNaoExisteException{
		for(ClubeFutebol c: this.clubes) {
			if(c.getNomeClube().equals(nomeTime)) {
				return c.jogadores;
			}
		}
		throw new ClubeNaoExisteException("Não existe clube com esse nome");
	}

}
