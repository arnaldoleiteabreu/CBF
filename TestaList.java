import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class TestaList {

	public static void main(String[] args) throws ClubeNaoExisteException {
		
		SistemaList sistema = new SistemaList();
		boolean sair= false;
		while(sair== false) {
			int opcao= Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar \n2 - Pesquisar \n3 - Adicionar cartão ou gol \n4 - Remover jogador \n5 - Lista de jogadores \n6 - Recuperar jogador \n7 - Sair"));
			switch(opcao) {
			case 1:
				int opcao3= Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar jogador \n2 - Cadastrar time \n3 - Cadastra jogador no clube \n4 - Sair"));
				if(opcao3==1) {
					String nomeJogador= JOptionPane.showInputDialog("Digite o nome do jogador: ");
					String numeroDoJogador= JOptionPane.showInputDialog("Digite o a numeração do jogador: ");
					String dataNascimentoDoJogador= JOptionPane.showInputDialog("Digite a data de nascimento do jogador: ");
					String rgJogador= JOptionPane.showInputDialog("Digite o rg do jogador: ");
					String nacionalidade= JOptionPane.showInputDialog("Digite a nacionalidade do jogador: ");
					EstatisticaDoJogador estatistica= new EstatisticaDoJogador(0,0,0,0,0,0);
					Jogador jogador= new Jogador(nomeJogador, numeroDoJogador, dataNascimentoDoJogador, rgJogador,nacionalidade,estatistica);
					try {
						sistema.cadastraJogador(jogador);
						JOptionPane.showMessageDialog(null, "Cadastrado");
					}catch(JogadorJaExisteException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					
				}
				
				else if(opcao3==2) {
					String nomeTimeParaCadastrar= JOptionPane.showInputDialog("Digite o nome do clube para cadastrar: ");
					ClubeFutebol clubecadastra= new ClubeFutebol(nomeTimeParaCadastrar, 30);
					try {
						sistema.cadastraClube(clubecadastra);
					}catch(ClubeJaExisteException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}
				else if(opcao3==3) {
					String rgJogador2 = JOptionPane.showInputDialog("Digite o RG do jogador para cadastrar ");
					String nomeTime2 = JOptionPane.showInputDialog("Digite o nome do clube para cadastrar o jogador ");
					try {
						sistema.increveJogadorNoClube(rgJogador2, nomeTime2);
					}catch(JogadorNaoExisteException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());	
					}catch(ClubeNaoExisteException m) {
						JOptionPane.showMessageDialog(null, m.getMessage());
					}
					
				}
				else if(opcao3==4){
					break;
				}
				else {
					JOptionPane.showMessageDialog(null, "Opção inválida!");
				}
			break;
			case 2:
				int opcao2= Integer.parseInt(JOptionPane.showInputDialog("1 - Pesquisar jogador pelo nome \n2 - Pesquisar jogador pelo RG \n3 - Pesquisar jogador pelo clube \n4 - Pesquisar jogador pelo número \n5 - Pesquisar jogador pela nacionalidade \n6 - Sair"));
				
				if(opcao2==1) {
					String nomeJogador3= JOptionPane.showInputDialog("Digite o nome do jogador para pesquisar: ");
					List<Jogador>lista3= new ArrayList<Jogador>();
					try {
						lista3 = sistema.pesquisaJogadorPeloNome(nomeJogador3);
					} catch (JogadorNaoExisteException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
				
					}
					for(Jogador j: lista3) {
						JOptionPane.showMessageDialog(null, j.toString());
					}
					
				}
				
				else if(opcao2==2){
					String rg1 = JOptionPane.showInputDialog("Digite o RG do jogador para pesquisar: ");
					try {
						Jogador jogadorParaPesquisar=(Jogador)sistema.pesquisaJogador(rg1);
						JOptionPane.showMessageDialog(null, jogadorParaPesquisar);
					}catch (JogadorNaoExisteException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				
				}
				
				else if(opcao2==3) {
					String nomeTime= JOptionPane.showInputDialog("Digite o nome do time para pesquisar: ");
					List<Jogador> lista3= new ArrayList<Jogador>();
					try {
						lista3 = sistema.pesquisaClube(nomeTime);
					} catch (ClubeNaoExisteException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					for(Jogador j: lista3) {
						JOptionPane.showMessageDialog(null, j.toString());
					}
				}
				
				else if(opcao2==4) {
					String numero = JOptionPane.showInputDialog("Digite o número do jogador para pesquisar: ");
					try {
						Jogador jogadorParaPesquisar=(Jogador)sistema.pesquisaJogadorPeloNumero(numero);
						JOptionPane.showMessageDialog(null, jogadorParaPesquisar);
					}catch (JogadorNaoExisteException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}
				else if(opcao2==5) {
					String nacionalidade2 = JOptionPane.showInputDialog("Digite a nacionalidade do jogador para pesquisar: ");
					try {
						Jogador jogadorParaPesquisar=(Jogador)sistema.pesquisaJogadorPelaNacionalidade(nacionalidade2);
						JOptionPane.showMessageDialog(null, jogadorParaPesquisar);
					}catch (JogadorNaoExisteException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}else if(opcao2==6){
					break;
				}
				else {
					JOptionPane.showMessageDialog(null, "Opção inválida!");
				}
			
			break;	
			case 3:
				int opcao4= Integer.parseInt(JOptionPane.showInputDialog("1 - Adicionar gol \n2 - Adicionar cartão \n3 - Sair"));
				if(opcao4==1) {
					String nomeDoJogador= JOptionPane.showInputDialog("nome");
					int quant= Integer.parseInt(JOptionPane.showInputDialog("gol"));
					sistema.adicionaGol(nomeDoJogador, quant);
					GravadorDeJogador.gravaJogador(sistema.getListaTotalDeJogadores());
				}
				else if(opcao4==2) {
					String cartao1= JOptionPane.showInputDialog("Qual cartão para adicionar ao jogador: ");
					String nomeJogador1= JOptionPane.showInputDialog("Qual o nome do jogador!");
					sistema.adicionaCartao(cartao1, nomeJogador1);
					GravadorDeJogador.gravaJogador(sistema.getListaTotalDeJogadores());
				}
				else if(opcao4==3){
					break;
				}
				else {
					JOptionPane.showMessageDialog(null, "Opção inválida!");
					
				}
			break;
			case 4:
				int opcao5= Integer.parseInt(JOptionPane.showInputDialog("1 - Remover jogador \n2 - Remover Clube \n3 - Sair"));
				if(opcao5==1) {
					String rg= JOptionPane.showInputDialog("Digite o RG do jogador para remover");
					try {
						sistema.removeJogador(rg);
						JOptionPane.showMessageDialog(null, "Jogador removido!");
					}catch(JogadorNaoExisteException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
						
					}
				}
				
				else if(opcao5==2) {
					String nomeTime= JOptionPane.showInputDialog("Digite o nome do clube para remover");
					try {
						sistema.removeClube(nomeTime);
						JOptionPane.showMessageDialog(null, "Clube removido!");
					}catch(ClubeNaoExisteException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
						
					}

					
				}
				else if(opcao5==3){
					break;
				}
				else {
					JOptionPane.showMessageDialog(null, "Opção inválida!");
					
				}
			break;
			
			case 5:
				int opcao6=Integer.parseInt(JOptionPane.showInputDialog("1 - Lista de artilheiro\n2 - Lista de suspenso \n3 - Lista de todos os jogadores \n4 - Sair"));
				if(opcao6==1) {
					JOptionPane.showMessageDialog(null, sistema.getListaDeArtilheiro());
				}
				else if(opcao6==2) {
					JOptionPane.showMessageDialog(null, sistema.getListaDeJogadoresSuspenso());
				}
				else if(opcao6==3) {
					JOptionPane.showMessageDialog(null, sistema.getListaTotalDeJogadores());
				}
				else if(opcao6==4){
					break;
				}else {
					JOptionPane.showMessageDialog(null, "Opção inválida!");
				}
			break;
			
			case 6:
				int opcao7=Integer.parseInt(JOptionPane.showInputDialog("1 - Recuperar \n2 - Salvar \n3 - Sair"));
				if(opcao7==1) {
					List<Jogador> lista4= GravadorDeJogador.recuperaJogador();
					for(Jogador j:lista4) {
						try {
							sistema.cadastraJogador(j);
						}catch (JogadorJaExisteException e) {
							
						}
					}
				}
				else if(opcao7==2) {
					GravadorDeJogador.gravaJogador(sistema.getListaTotalDeJogadores());
				}
				else if(opcao7==3) {
					break;
				}
				else {
					JOptionPane.showMessageDialog(null, "Opção inválida!");
				}
						
					
			break;
			
			case 7:
				sair= true;
				JOptionPane.showMessageDialog(null, "O programa será finalizado");
			break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida");
				break;
				
			
			}
		
		}

	}
	
	

}
