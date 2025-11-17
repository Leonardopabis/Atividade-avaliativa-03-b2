package fag;
import java.util.ArrayList;
import java.util.Scanner;

import fag.objetos.*;

public class Principal {
	static Scanner scan = new Scanner(System.in);
	static Construções construcao = new Construções();
	static Funcionários funcionario = new Funcionários();
	static ArrayList<Funcionários> listaFuncionarios = new ArrayList<>();
	static ArrayList<Construções> listaConstrucoes = new ArrayList<>();
	static int valor = 1000;
	public static void main(String[] args) {
		Construções constru1 = new Construções("Con1", "rua sete", "11/10/2025");
		Construções constru2 = new Construções("Con2", "rua jose", "18/05/2025");
		Construções constru3 = new Construções("Con3", "rua sla", "01/03/2025");
		Funcionários fun1 = new Funcionários("fun1", "pedreiro", 1500);
		Funcionários fun2 = new Funcionários("fun2", "pedreiro", 1500);
		listaFuncionarios.add(fun1);
		listaFuncionarios.add(fun2);
		listaConstrucoes.add(constru1);
		listaConstrucoes.add(constru2);
		listaConstrucoes.add(constru3);
		fun1.adicionarConstrucoes(constru1);
		fun1.adicionarConstrucoes(constru2);
		constru1.adicionarFuncionario(fun1);
		constru2.adicionarFuncionario(fun1);
		menuPrincipal();
		
	}
	
	public static void menuPrincipal() {
			while (valor != 0) {
				System.out.println("\nMenu Principal\n");
				System.out.println("1 - Menu de funcionários");
				System.out.println("2 - Menu de Construções");
				System.out.println("0 - Sair");
				System.out.println("\nDigite o número desejado:");
				valor = scan.nextInt();
				scan.nextLine();
				if (valor == 1) {
					menuFuncionario();
				}else if(valor == 2) {
					menuConstrucao();
				}else if (valor == 0) {
					sair();
				}else {
					System.out.println("Escolha uma opção válida");
				}
			}
	}
	public static void sair() {
		System.out.println("\nSistema finalizado\n");
	}
	public static void menuFuncionario() {
		int escolha = 1000;
		while (escolha != 0) {
			System.out.println("\nMenu de funcionários\n");
			System.out.println("1 - Cadastrar funcionário");
			System.out.println("2 - Consultar funcionários");
			System.out.println("3 - Atualizar funcionário");
			System.out.println("0 - Voltar");
			System.out.println("\nDigite o número desejado:");
			escolha = scan.nextInt();
			scan.nextLine();
			if (escolha == 1) {
				cadastrarFuncionario();
			}else if (escolha == 2) {
				consultarFuncionarios();
			}else if (escolha == 3) {
				atualizarFuncionario();
			}else if (escolha == 0) {
				menuPrincipal();
			}else {
				System.out.println("Digite uma opção válida:");
			}
		}
	}
	public static void cadastrarFuncionario() {
		Funcionários funcionario = new Funcionários();
		System.out.println("Digite o nome do funcionário");
		String nome = scan.nextLine();
		funcionario.setNome(nome);
		System.out.println("Digite o cargo do funcionário");
		String cargo = scan.nextLine();
		funcionario.setCargo(cargo);
		System.out.println("Digite o salário do funcionário");
		Double salario = scan.nextDouble();
		scan.nextLine();
		funcionario.setSalario(salario);
		listaFuncionarios.add(funcionario);
		System.out.println("\nFuncionario cadastrado com sucesso\n");
		System.out.println("Aperte enter para voltar ao menu");
		scan.nextLine();
		menuFuncionario();
	}
	public static void consultarFuncionarios() {
		for (int i = 0; i < listaFuncionarios.size(); i++) {
			System.out.println(i+1+" - "+listaFuncionarios.get(i).Listar());
		}
		System.out.println("Aperte enter para voltar ao menu");
		scan.nextLine();
		menuFuncionario();
	}
	public static void atualizarFuncionario() {
		for (int i = 0; i < listaFuncionarios.size(); i++) {
			System.out.println(i+1+" - "+listaFuncionarios.get(i).Listar());
		}
		System.out.println("Digite o número do funcionário para atualizar ou aperte 0 para voltar");
		int escolha = 0;
		while (escolha >= 0) {
			escolha = scan.nextInt();
			scan.nextLine();
			if (escolha > 0 && escolha <= listaFuncionarios.size()) {
				System.out.println("\n1 - Funcionário: "+listaFuncionarios.get(escolha-1).getNome());
				System.out.println("2 - Cargo: "+listaFuncionarios.get(escolha-1).getCargo());
				System.out.println("3 - Salário: "+listaFuncionarios.get(escolha-1).getSalario());
				System.out.println("4 - Construções: "+listaFuncionarios.get(escolha-1).listarConstrucoes());
				System.out.println("5 - Excluir Funcionário");
				System.out.println("0 - Voltar");
				System.out.println("\nEscolha uma opção: ");
				int opcao = scan.nextInt();
				scan.nextLine();
				subAtualizarFuncionario(opcao, escolha);
			}else if (escolha == 0) {
				menuFuncionario();
			}else {
				System.out.println("Digite uma opção válida");
			}
		}
	}
	public static void subAtualizarFuncionario(int opcao, int escolha) {
		while (opcao != -1) {
			if (opcao == 1) {
				System.out.println("Digite o novo nome do Funcionário");
				String nome = scan.nextLine();
				listaFuncionarios.get(escolha-1).setNome(nome);
				System.out.println("Pressione enter para voltar");
				scan.nextLine();
				atualizarFuncionario();
			}else if (opcao == 2) {
				System.out.println("Digite o novo cargo do Funcionário");
				String cargo = scan.nextLine();
				listaFuncionarios.get(escolha-1).setCargo(cargo);
				System.out.println("Pressione enter para voltar");
				scan.nextLine();
				atualizarFuncionario();
			}else if (opcao == 3){
				System.out.println("Digite o novo salário do Funcionário");
				Double salario = scan.nextDouble();
				scan.nextLine();
				listaFuncionarios.get(escolha-1).setSalario(salario);
				System.out.println("Pressione enter para voltar");
				scan.nextLine();
				atualizarFuncionario();
			}else if (opcao == 4) {
				System.out.println("\n1 - Adicionar construção em que trabalha\n2 - Remover construção");
				int a = scan.nextInt();
				scan.nextLine();
				if (a == 1) {
					for (int i = 0; i < listaConstrucoes.size();i++) {
						System.out.println(i+1+" - "+listaConstrucoes.get(i).getNomeObra());
					}
					int esc = 1000;
					while (esc != 0) {
						System.out.println("Escolha qual construção adicionar:");
						esc = scan.nextInt();
						scan.nextLine();
						if (listaFuncionarios.get(escolha-1).listarConstrucoes().contains(listaConstrucoes.get(esc-1).getNomeObra())) {
							System.out.println("Já está nessa construção");
						}else {
							System.out.println("Construção adicionada ao funcionário");
							listaConstrucoes.get(esc-1).adicionarFuncionario(listaFuncionarios.get(escolha-1));
							listaFuncionarios.get(escolha-1).adicionarConstrucoes(listaConstrucoes.get(esc-1));;
							System.out.println("Pressione enter para voltar");
							scan.nextLine();
							atualizarFuncionario();
						}
					}
				}else if (a == 2) {
					for (int i = 0; i < listaConstrucoes.size();i++) {
						System.out.println(i+1+" - "+listaConstrucoes.get(i).getNomeObra());
					}
					int esc = 1000;
					while (esc != 0) {
						System.out.println("Escolha qual construção remover:");
						esc = scan.nextInt();
						scan.nextLine();
						if (listaFuncionarios.get(escolha-1).listarConstrucoes().contains(listaConstrucoes.get(esc-1).getNomeObra())) {
							System.out.println("Construção removida");
							listaFuncionarios.get(escolha-1).removerConstrucao(listaConstrucoes.get(esc-1));
							listaConstrucoes.get(escolha-1).removerFuncionario(listaFuncionarios.get(esc-1));
							System.out.println("Pressione enter para voltar");
							scan.nextLine();
							atualizarFuncionario();
						}else {
							System.out.println("Não está nessa construção");
						}
					}
				}
			}else if (opcao == 5) {
				for (int i = 0; i < listaConstrucoes.size(); i++) {
					listaConstrucoes.get(i).removerFuncionario(listaFuncionarios.get(escolha-1));
				}
				listaFuncionarios.remove(escolha-1);
				System.out.println("Funcionário excluído");
				System.out.println("Pressione enter para voltar");
				scan.nextLine();
				atualizarFuncionario();
			}else if (opcao == 0) {
				atualizarFuncionario();
			}else {
				System.out.println("Escolha uma opção válida:");
				opcao = scan.nextInt();
				scan.nextLine();
				}
		}
	}
	
	
	public static void menuConstrucao() {
		System.out.println("\nMenu de Construções\n");
		System.out.println("1 - Cadastrar Construção");
		System.out.println("2 - Consultar Construções");
		System.out.println("3 - Atualizar Construção");
		System.out.println("0 - Voltar");
		System.out.println("\nDigite o número desejado:");
		int numero = 0;
		while (numero != -1) {
			numero = scan.nextInt();
			scan.nextLine();
			if (numero == 1) {
				cadastrarConstrucao();
			}else if (numero == 2) {
				consultarConstrucoes();
			}else if (numero == 3) {
				atualizarConstrucao();
			}else if (numero == 0) {
				menuPrincipal();
			}else {
				System.out.println("Digite um número válido:");
			}
		}
	}
	public static void cadastrarConstrucao() {
		Construções construcao = new Construções();
		System.out.println("Digite o nome da construção");
		String nome = scan.nextLine();
		construcao.setNomeObra(nome);
		System.out.println("Digite o endereço da obra");
		String endereco = scan.nextLine();
		construcao.setEndereco(endereco);;
		System.out.println("Digite a data de início: (dd/mm/aaaa)");
		String data = scan.nextLine();
		construcao.setData(data);
		listaConstrucoes.add(construcao);
		System.out.println("\nConstrução cadastrada com sucesso\n");
		System.out.println("Aperte enter para voltar ao menu");
		scan.nextLine();
		menuConstrucao();
	}
	public static void consultarConstrucoes() {
		for (int i = 0; i < listaConstrucoes.size(); i++) {
			System.out.println(i+1+" - "+listaConstrucoes.get(i).Listar());
		}
		System.out.println("Aperte enter para voltar ao menu");
		scan.nextLine();
		menuConstrucao();
	}
	public static void atualizarConstrucao() {
		for (int i = 0; i < listaConstrucoes.size(); i++) {
			System.out.println(i+1+" - "+listaConstrucoes.get(i).Listar());
		}
		System.out.println("Digite o número da construção para atualizar ou aperte 0 para voltar");
		int escolha = 0;
		while (escolha >= 0) {
			escolha = scan.nextInt();
			scan.nextLine();
			if (escolha > 0 && escolha <= listaConstrucoes.size()) {
				System.out.println("\n1 - Construção: "+listaConstrucoes.get(escolha-1).getNomeObra());
				System.out.println("2 - Endereço: "+listaConstrucoes.get(escolha-1).getEndereco());
				System.out.println("3 - Data de início: "+listaConstrucoes.get(escolha-1).getData());
				System.out.println("4 - Funcionários: "+listaConstrucoes.get(escolha-1).listarFuncionarios());
				System.out.println("5 - Excluir construção");
				System.out.println("0 - Voltar");
				System.out.println("\nEscolha uma opção: ");
				int opcao = scan.nextInt();
				scan.nextLine();
				subAtualizarConstrucao(opcao, escolha);
			}else if (escolha == 0) {
				menuConstrucao();
			}else {
				System.out.println("Digite uma opção válida");
			}
		}
	}
	public static void subAtualizarConstrucao(int opcao, int escolha) {
		while (opcao != -1) {
			if (opcao == 1) {
				System.out.println("Digite o novo nome da Construção");
				String nome = scan.nextLine();
				listaConstrucoes.get(escolha-1).setNomeObra(nome);
				System.out.println("Pressione enter para voltar");
				scan.nextLine();
				atualizarConstrucao();
			}else if (opcao == 2) {
				System.out.println("Digite o novo endereço da obra");
				String endereco = scan.nextLine();
				listaConstrucoes.get(escolha-1).setEndereco(endereco);
				System.out.println("Pressione enter para voltar");
				scan.nextLine();
				atualizarConstrucao();
			}else if (opcao == 3){
				System.out.println("Digite a nova data de início da obra (dd/mm/aaaa)");
				String data = scan.nextLine();
				listaConstrucoes.get(escolha-1).setData(data);
				System.out.println("Pressione enter para voltar");
				scan.nextLine();
				atualizarConstrucao();
			}else if (opcao == 4) {
				System.out.println("\n1 - Adicionar Funcionário à construção\n2 - Remover Funcionário");
				int a = scan.nextInt();
				scan.nextLine();
				if (a == 1) {
					for (int i = 0; i < listaFuncionarios.size();i++) {
						System.out.println(i+1+" - "+listaFuncionarios.get(i).getNome());
					}
					int esc = 1000;
					while (esc != 0) {
						System.out.println("Escolha qual Funcionário adicionar:");
						esc = scan.nextInt();
						scan.nextLine();
						if (listaConstrucoes.get(escolha-1).listarFuncionarios().contains(listaFuncionarios.get(esc-1).getNome())) {
							System.out.println("Já está nessa construção");
						}else {
							System.out.println("Funcionário adicionado à construção");
							listaConstrucoes.get(escolha-1).adicionarFuncionario(listaFuncionarios.get(esc-1));;
							listaFuncionarios.get(escolha-1).adicionarConstrucoes(listaConstrucoes.get(esc-1));;
							System.out.println("Pressione enter para voltar");
							scan.nextLine();
							atualizarConstrucao();
						}
					}
				}else if (a == 2) {
					for (int i = 0; i < listaFuncionarios.size();i++) {
						System.out.println(i+1+" - "+listaFuncionarios.get(i).getNome());
					}
					int esc = 1000;
					while (esc != 0) {
						System.out.println("Escolha qual Funcionário remover:");
						esc = scan.nextInt();
						scan.nextLine();
						if (listaConstrucoes.get(escolha-1).listarFuncionarios().contains(listaFuncionarios.get(esc-1).getNome())) {
							System.out.println("Funcionário removido");
							listaConstrucoes.get(escolha-1).removerFuncionario(listaFuncionarios.get(esc-1));
							listaFuncionarios.get(escolha-1).removerConstrucao(listaConstrucoes.get(esc-1));;
							System.out.println("Pressione enter para voltar");
							scan.nextLine();
							atualizarConstrucao();
						}else {
							System.out.println("Não está nessa construção");
						}
					}
				}
			}else if (opcao == 5) {
				for (int i = 0; i < listaFuncionarios.size(); i++) {
					listaFuncionarios.get(i).removerConstrucao(listaConstrucoes.get(escolha-1));
				}
				listaConstrucoes.remove(escolha-1);
				System.out.println("Construção excluída");
				System.out.println("Pressione enter para voltar");
				scan.nextLine();
				atualizarConstrucao();
			}else if (opcao == 0) {
				atualizarConstrucao();
			}else {
				System.out.println("Escolha uma opção válida:");
				opcao = scan.nextInt();
				scan.nextLine();
				}
		}
	}
}
