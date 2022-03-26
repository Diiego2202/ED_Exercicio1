
public class Lista<T> {
	No<T> inicio, fim;
	int tamanho=0;
	
	public void inserirFinal(T dado) {
		No<T> aux = new No<T>(dado);
		
		if(tamanho == 0) {
			inicio = aux;
		} else {
			aux.esq = fim;
			fim.dir = aux;
		}
		 
		fim = aux;
		tamanho++;
		
	}
	
	public No<T> pesquisar(T dado){
		No<T> aux = inicio;
		boolean achou = false;
		while(aux != null && achou == false) {
			if(aux.dado.equals(dado)) {
				achou = true;
				break;
			}
			aux = aux.dir;
		}
		
		return aux;
	}
	
	public void remover(T dado) {
		No<T> aux = pesquisar(dado);
		
		if(aux == null) {
			System.out.println("ERRO! Não foi encontado o valor informado!");
		} else {
			if(tamanho == 1) {
				inicio = fim = null; 
			} else {
				if(aux == inicio) { 
					aux.dir.esq = null;
					inicio = aux.dir;
					aux.dir = null;
				} else if(aux == fim) {
					fim = aux.esq;
					aux.esq = null;
					aux.esq.dir = null;
				} else {
					aux.esq.dir = aux.dir;
					aux.dir.esq = aux.esq;
					aux.esq = aux.dir = null;
				}
			}
			tamanho--;
		}
	}
	
	public void imprimir(T dado) {
		No<T> aux = inicio;
		aux = inicio;
		while(aux != null) {
			System.out.println(aux);
			aux = aux.dir;
		}
	}
}

