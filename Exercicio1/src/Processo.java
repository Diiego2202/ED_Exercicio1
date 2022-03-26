import javax.swing.JOptionPane;

public class Processo {
	static Lista<Conta> lista = new Lista<Conta>();
	
	public static void abrirConta() {
		String nome = JOptionPane.showInputDialog("Nome: ");
		String cpf = JOptionPane.showInputDialog("CPF: ");
		Conta conta =  new Conta(nome, cpf);
		if(lista.pesquisar(conta) == null) {
			lista.inserirFinal(conta);
		} else {
			JOptionPane.showMessageDialog(null, "ERRO! CPF duplicado!");
		}
			
	}
	
	public static void sacar() {
		double valor;
		No<Conta> n = pesquisar();
		
		if(n == null) {
			JOptionPane.showMessageDialog(null, "ERRO! CPF não encontrado!");
		} else {
			valor = Double.parseDouble(JOptionPane.showInputDialog("Valor do saque: R$"));
			if(valor > n.dado.saldo) {
				JOptionPane.showMessageDialog(null, "ERRO! Saldo insuficiente!");
			} else {
				n.dado.saldo -= valor;
			}
		}
		
		
		
	}
	
	public static void depositar() {
		double valor;
		No<Conta> n = pesquisar();
		
		if(n == null) {
			JOptionPane.showMessageDialog(null, "ERRO! CPF não encontrado!");
		} else {
			valor = Double.parseDouble(JOptionPane.showInputDialog("Valor do depósito: R$"));
			if(valor < 0) {
				JOptionPane.showMessageDialog(null, "ERRO! Valor inválido!");
			} else {
				n.dado.saldo += valor;
			}
		}
		
	}
	
	public static No<Conta> pesquisar() {
		String cpf = JOptionPane.showInputDialog("Insira o CPF da conta: ");
		Conta aux = new Conta("", cpf);
		No<Conta> n = lista.pesquisar(aux);
		return n;
	}
	
	public static void imprimirConta() {
		No<Conta> n = pesquisar();
		if(n == null) {
			JOptionPane.showMessageDialog(null, "ERRO! CPF não encontrado!");
		} else {
			JOptionPane.showMessageDialog(null, "Nome: " + n.dado.nome + "\nCPF: " + n.dado.cpf + "\nSaldo: R$" + n.dado.saldo);
		}
		
	}
	
	public static void removerConta() {
		String cpf = JOptionPane.showInputDialog("Insira o CPF da conta: ");
		Conta aux = new Conta("", cpf);
		lista.remover(aux);
		JOptionPane.showMessageDialog(null, "Conta encerrada!");
	}
}
