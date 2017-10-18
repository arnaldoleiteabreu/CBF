import java.util.List;

public interface SistemaListInterface {
	public void cadastraJogador(Jogador jogador)throws JogadorJaExisteException;
	public void RemoveJogador(String nomeRemove) throws JogadorNaoExisteException;
	public List<Jogador> pesquisaJogadorPeloTime(String nomeTime);
	public void removeClube(String nomeClube) throws ClubeNaoExisteException;
	public List<Jogador> getListaDeJogadoresSuspenso();
	public List<Jogador> getListaDeJogadoresArtilheiros();
	public List<Jogador> pesquisaJogadorPeloNome (String nomeJogador)throws JogadorNaoExisteException;
	public List<Jogador> pesquisaJogadorPeloNumero(String numero) throws JogadorNaoExisteException;
	public List<Jogador> pesquisaJogadorPeleDataNascimento(String dataNascimento)throws JogadorNaoExisteException;
	public List<Jogador> pesquisaJogadorPelaNacionalidade(String nacionalidade)throws JogadorNaoExisteException;
	public Jogador pesquisaJogador(String rg) throws JogadorNaoExisteException;
	public void increveJogadorNoClube(String rg, String nomeTime)throws JogadorNaoExisteException, ClubeNaoExisteException;
	public List<Jogador> getListaTotalDeJogadores();
	public List<Jogador> getJogadoresDoClube(String nomeClube) throws ClubeNaoExisteException;
	public void cadastraClube(ClubeFutebol c) throws ClubeJaExisteException;
	public void adicionaCartao(String cartao, String jogadorNome);
	public int mostraTotalDeCartoes(String nomeJogador);
	public void adicionaGol(String nomeJogador, int quantGols);
	public List<Jogador> getListaDeArtilheiro();
	public List<Jogador> pesquisaClube(String nomeTime) throws ClubeNaoExisteException;


}
