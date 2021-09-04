package model;

public interface IArbol <V extends Comparable<V>>{
	public Nodo<V> buscarNodo(Nodo<V> nodo, V valor);
	public boolean insertarNodo(V valor);
	public void borrarNodo(V valor);
	public String mostrarArbol();
}


