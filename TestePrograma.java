import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestePrograma {
	SistemaList sistema= new SistemaList();
	EstatisticaDoJogador estatistica= new EstatisticaDoJogador(0,0,0,0,0,0);
	Jogador j= new Jogador("Arnaldo","10","18/12/1997","19989","Brasileiro", estatistica);
	Jogador k= new Jogador("Fernando","10", "20/10/1997","10000", "Brasileiro", estatistica);

	@Before
	public void before() throws JogadorJaExisteException{
		sistema.cadastraJogador(j);
		sistema.cadastraJogador(k);
	}
	@Test
	public void test() throws JogadorJaExisteException {
	
		assertTrue(sistema.jogadores.size()==2);	
		
	}
	@Test public void test2() {
		
		try {
			String a= sistema.pesquisaJogadorPeloNome2("Arnaldo");
			assertTrue(a.equals("Arnaldo"));
		} catch (JogadorNaoExisteException e) {
			e.printStackTrace();
		}
	}
	
		
	
	@Test
	public void teste3() {
		try {
			sistema.removeJogador("19989");
		} catch (JogadorNaoExisteException e) {
			e.printStackTrace();
		}
		assertTrue(sistema.jogadores.size()==1);
		
	}
	@Test
	public void test4() {
		try {
			String b=sistema.pesquisaJogadorPeloNumero2("10");
			assertTrue(b.equals("10"));
		}catch(JogadorNaoExisteException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test5() {
		try {
			String b=sistema.pesquisaJogadorPeloNacionalidade2("Brasileiro");
			assertTrue(b.equals("Brasileiro"));
		}catch(JogadorNaoExisteException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test6() {
		try {
			String b=sistema.pesquisaJogadorPelaDataDeNascimento2("18/12/1997");
			assertTrue(b.equals("18/12/1997"));
		}catch(JogadorNaoExisteException e) {
			e.printStackTrace();
		}
	}

	
}
