import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		int opcao;
		
		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(menu()));
			if(opcao < 1 || opcao > 6) {
				JOptionPane.showMessageDialog(null, "Op��o inv�lida");
			} else {
				switch(opcao) {
					case 1:
						Processo.abrirConta();
						break;
					case 2:
						Processo.sacar();
						break;
					case 3:
						Processo.depositar();
						break;
					case 4: 
						Processo.imprimirConta();
						break;
					case 5:
						Processo.removerConta();
						break;
						
				}
			}
			
		} while(opcao != 6);
		
		
	}
	
	public static String menu() {
		String aux = "1. Abrir conta\n";
		aux += "2. Realizar saque\n";
		aux += "3. Realizar dep�sito\n";
		aux += "4. Relat�rio de contas\n";
		aux += "5. Encerrar conta\n";
		aux += "6. Encerrar aplica��o";
		return aux;
	}
	
	
}
