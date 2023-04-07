package br.com.aula.jdbc;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.aula.dao.VeiculoDAO;
import br.com.aula.model.Veiculo;

public class Teste {

	public static void main(String[] args) {
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		Veiculo carro;
		
		int id = 0;
		String modelo = "", marca = "", placa = "";
		double valor = 0.0;
		
		int opcao = 0;
		String resposta;
		
		String menu = "Gestão de veículos - Escolha uma das seguintes opções:";
		menu += "\n 1- Cadastrar veículo.";
		menu += "\n 2- Editar veículo.";
		menu += "\n 3- Deletar veículo.";
		menu += "\n 4- Pesquisar veículo por placa.";
		menu += "\n 5- Listar veículos.";
		menu += "\n 0- Sair.";
		
		do {
			resposta = JOptionPane.showInputDialog(menu);
			opcao = Integer.parseInt(resposta);
			
			switch(opcao) {
				case 1: {
					modelo = JOptionPane.showInputDialog("Informe o modelo");
					marca = JOptionPane.showInputDialog("Informe a marca");
					placa = JOptionPane.showInputDialog("Informe a placa");
					valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor"));
					
					carro = new Veiculo(id, modelo, marca, placa, valor);
					veiculoDAO.salvar(carro);
					
					break;
				}
				case 2: {
					id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID"));
					modelo = JOptionPane.showInputDialog("Informe o modelo");
					marca = JOptionPane.showInputDialog("Informe a marca");
					placa = JOptionPane.showInputDialog("Informe a placa");
					valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor"));
					
					carro = new Veiculo(id, modelo, marca, placa, valor);
					veiculoDAO.editar(carro);
					
					break;
				}
				case 3: {
					id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID"));
					
					carro = new Veiculo(id, modelo, marca, placa, valor);
					veiculoDAO.excluir(carro);
					
					break;
				}
				case 4: {
					placa = JOptionPane.showInputDialog("Informe a placa");
					
					carro = new Veiculo(id, modelo, marca, placa, valor);
					
					Veiculo carroBusca = veiculoDAO.pesquisar(carro);
					
					System.out.println("Carro ["+placa+"]: "+carroBusca.toString());
					
					break;
				}
				case 5: {
					List<Veiculo> veiculosLista = veiculoDAO.listar();
					
					for (Veiculo obj : veiculosLista) {
						System.out.println( obj.toString() );
					}
					
					break;
				}
				default: {
					System.out.println("Saindo...");
				}
			}
			
		} while(opcao>0 && opcao<6);
		
	}

}
