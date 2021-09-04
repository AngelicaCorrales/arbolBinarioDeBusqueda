package model;

public class Arbol<V extends Comparable<V>> implements IArbol<V> {

	private Nodo<V> raiz;
	private String arbolStr;

	//CrearArbol
	public Arbol() {

	}

	public Nodo<V> getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo<V> raiz) {
		this.raiz = raiz;
	}

	public String buscarNodoString(V valor) {
		Nodo<V> buscar = buscarNodo(raiz,valor);
		String nodoStr = "null";
		if(buscar!=null) {
			nodoStr = buscar.toString();
		}
		return nodoStr;
	}

	@Override
	public Nodo<V> buscarNodo(Nodo<V> nodo, V valor) {
		if(nodo==null || nodo.compareTo(valor)==0) {
			return nodo;
		}else {
			if(nodo.compareTo(valor)>=0) {
				return buscarNodo(nodo.getIzq(), valor);
			}else{
				return buscarNodo(nodo.getDer(), valor);
			}
		}
	}

	@Override
	public boolean insertarNodo(V valor) {
		Nodo<V> nuevo = new Nodo<V>(valor);
		boolean insertado = false;
		if(raiz==null) {
			raiz = nuevo;
		}else {
			insertarNodoR(raiz, nuevo);
			insertado = true;
		}
		return insertado;
	}

	private void insertarNodoR(Nodo<V> nodo, Nodo<V> nuevo) {
		if(nuevo.compareTo(nodo.getValor())<0){
			if(nodo.getIzq()==null){
				nodo.setIzq(nuevo);
				nuevo.setPadre(nodo);
			}else{
				insertarNodoR(nodo.getIzq(),nuevo);
			}
		}else{
			if(nodo.getDer()==null){
				nodo.setDer(nuevo);
				nuevo.setPadre(nodo);
			}else{
				insertarNodoR(nodo.getDer(),nuevo);
			}	
		}
	}

	@Override
	public void borrarNodo(V valor){
		Nodo<V> nodo = buscarNodo(raiz,valor);
		borrarNodoR(nodo);
	}
	
	private void borrarNodoR(Nodo<V> nodo) {
		if(nodo!=null) {
				//caso 1, nodo es una hoja
				if(nodo.getIzq()==null && nodo.getDer()==null){
					if(nodo==raiz){
						raiz=null;
					}else if(nodo==nodo.getPadre().getIzq()){
						nodo.getPadre().setIzq(null);		
					}else{
						nodo.getPadre().setDer(null);;
					}
					nodo.setPadre(null);
				}else if(nodo.getIzq()==null || nodo.getDer()==null){
					//caso 2, nodo tiene un hijo
					Nodo<V> hijoUnico;
					if(nodo.getIzq()!=null){
						hijoUnico=nodo.getIzq();
						nodo.setIzq(null);;
					}else{
						hijoUnico=nodo.getDer();
						nodo.setDer(null);
					}
					hijoUnico.setPadre(nodo.getPadre());
					if(nodo==raiz){
						raiz=hijoUnico;
					}else if(nodo==nodo.getPadre().getIzq()){
						nodo.getPadre().setIzq(hijoUnico);	
					}else{
						nodo.getPadre().setDer(hijoUnico);
					}
					nodo.setPadre(null);
				}else{ 
					//caso 3, nodo tiene dos hijos
					Nodo<V> sucesor =min(nodo.getDer());
					nodo.setValor(sucesor.getValor());
					borrarNodoR(sucesor);
				}
			}
	}

	private Nodo<V> min(Nodo<V> nodo){
		if(nodo.getIzq()!=null){
			return min(nodo.getIzq());
		}else{
			return nodo;
		}
	}

	@Override
	public String mostrarArbol() {
		arbolStr = "";
		if(raiz!=null) {
			recorrerArbolInorder(raiz);
		}
		return arbolStr;
	}

	private void recorrerArbolInorder(Nodo<V> nodo) {
		if(nodo!=null) {
			recorrerArbolInorder(nodo.getIzq());
			arbolStr+=nodo.toString()+" ";
			recorrerArbolInorder(nodo.getDer());
		}
	}
}