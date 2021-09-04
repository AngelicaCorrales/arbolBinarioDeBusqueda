package ui;

import model.Arbol;

public class Main {

	public static void main(String[] args) {
		Arbol<Integer> intArbol = new Arbol<>();
		intArbol.insertarNodo(17);
		System.out.println(intArbol.mostrarArbol());
		intArbol.insertarNodo(5);
		System.out.println(intArbol.mostrarArbol());
		intArbol.insertarNodo(50);
		System.out.println(intArbol.mostrarArbol());
		intArbol.insertarNodo(20);
		System.out.println(intArbol.mostrarArbol());
		intArbol.insertarNodo(8);
		System.out.println(intArbol.mostrarArbol());
		System.out.println(intArbol.buscarNodoString(20));
		System.out.println(intArbol.buscarNodoString(10));
		intArbol.borrarNodo(20);
		System.out.println(intArbol.mostrarArbol());
		intArbol.borrarNodo(10);
		System.out.println(intArbol.mostrarArbol());
		intArbol.borrarNodo(5);
		System.out.println(intArbol.mostrarArbol());
		intArbol.borrarNodo(17);
		System.out.println(intArbol.mostrarArbol());
		
		Arbol<String> strArbol = new Arbol<>();
		strArbol.insertarNodo("Juana");
		System.out.println(strArbol.mostrarArbol());
		strArbol.insertarNodo("Maria");
		System.out.println(strArbol.mostrarArbol());
		strArbol.insertarNodo("Ana");
		System.out.println(strArbol.mostrarArbol());
		strArbol.insertarNodo("Caro");
		System.out.println(strArbol.mostrarArbol());
		strArbol.insertarNodo("Juan");
		System.out.println(strArbol.mostrarArbol());
		System.out.println(strArbol.buscarNodoString("Keren"));
		System.out.println(strArbol.buscarNodoString("Ana"));
		strArbol.borrarNodo("Caro");
		System.out.println(strArbol.mostrarArbol());
		strArbol.borrarNodo("Keren");
		System.out.println(strArbol.mostrarArbol());
		strArbol.borrarNodo("Maria");
		System.out.println(strArbol.mostrarArbol());
		strArbol.borrarNodo("Juan");
		System.out.println(strArbol.mostrarArbol());
	}

}
