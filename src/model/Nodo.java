package model;

public class Nodo <V extends Comparable<V>> implements Comparable<V>{

	 private V valor;
	 private Nodo<V> izq;
	 private Nodo<V> der;
	 private Nodo<V> padre;
	 
	 public Nodo(V valor) {
		 this.valor = valor; 
	 }

	public Nodo<V> getIzq() {
		return izq;
	}

	public void setIzq(Nodo<V> izq) {
		this.izq = izq;
	}

	public Nodo<V> getDer() {
		return der;
	}

	public void setDer(Nodo<V> der) {
		this.der = der;
	}

	public V getValor() {
		return valor;
	}

	@Override
	public int compareTo(V val) {
		return valor.compareTo(val);
	}

	public Nodo<V> getPadre() {
		return padre;
	}

	public void setPadre(Nodo<V> padre) {
		this.padre = padre;
	}

	public void setValor(V valor) {
		this.valor = valor;
	}
	
	public String toString() {
		return valor.toString();
	}
}
