
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class GravadorDeJogador {
	public static List<Jogador> recuperaJogador(){
		List<Jogador> j= new ArrayList<Jogador>();
		List<String> lista= new ArrayList<String>();
		try {
			lista= recuperaTextoDeArquivo("Jogador.txt");
			
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao ler arquivo");
		}
		for(int k=0;k<lista.size();k++) {
			String nome= lista.get(k);
			k++;
			String numero=lista.get(k);
			k++;
			String dataNascimento= lista.get(k);
			k++;
			String rg= lista.get(k);
			k++;
			String nacionalidade= lista.get(k);
			k++;
			int gols= Integer.parseInt(lista.get(k));
			k++;
			int quantCartaoAmarelo = Integer.parseInt(lista.get(k));
			k++;
			int quantCartaoVermelho= Integer.parseInt(lista.get(k));
			k++;
			int totalDeCartoes= Integer.parseInt(lista.get(k));
			k++;
			int totalDeCartoesAmarelo= Integer.parseInt(lista.get(k));
			k++;
			int totalDeCartoesVermelho= Integer.parseInt(lista.get(k));
			k++;
			EstatisticaDoJogador estatistica= new EstatisticaDoJogador(gols, quantCartaoAmarelo, quantCartaoVermelho, totalDeCartoes,totalDeCartoesAmarelo,totalDeCartoesVermelho);
			Jogador joga= new Jogador(nome, numero, dataNascimento, rg, nacionalidade, estatistica);
			j.add(joga);
		}
		return j;
	}
	
	public static void gravaJogador(List<Jogador>lista) {
		List<String> j= new ArrayList<String>();
		for(Jogador k: lista) {
			j.add(k.getNome());
			j.add(k.getNumero());
			j.add(k.getDataNascimento());
			j.add(k.getRg());
			j.add(k.getNacionalidade());
			j.add(""+k.getEstatisticaDoJogador().gols);
			j.add(""+k.getEstatisticaDoJogador().quantCartaoAmarelo);
			j.add(""+k.getEstatisticaDoJogador().quantCartaoVermelho);
			j.add(""+k.getEstatisticaDoJogador().totalDeCartoes);
			j.add(""+k.getEstatisticaDoJogador().totalDeCartoesAmarelo);
			j.add(""+k.getEstatisticaDoJogador().totalDeCartoesVermelho);
			
		}
		try {
			gravaTextoEmArquivo(j, "Jogador.txt");
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Erro!");
		}
		
	}
	

	public static List<String> recuperaTextoDeArquivo(String nomeArquivo)
			throws IOException {
		BufferedReader leitor = null;
        List<String> textoLido = new ArrayList<String>();
		try {
			leitor = new BufferedReader(new FileReader(nomeArquivo));
			String texto = null;
			do {
				texto = leitor.readLine(); // lê a próxima linha do arquivo
				if (texto != null){
                                       textoLido.add(texto);
                                }
			} while(texto != null); //vai ser null quando chegar no fim do arquivo
		} finally {
			if (leitor!=null){
				leitor.close(); //fecha o stream(fluxo) de leitura
			}
		}
		return textoLido;
	}
	
	public static void gravaTextoEmArquivo(List<String> texto, String nomeArquivo)
			throws IOException {
		BufferedWriter gravador = null;
		try {
			gravador = new BufferedWriter(new FileWriter(nomeArquivo));
                        for (String s: texto){
                              gravador.write(s+"\n");
                        }
		} finally {
			if (gravador!=null){
				gravador.close(); //fecha o stream(fluxo) de escrita
			}
		}
	}

}
