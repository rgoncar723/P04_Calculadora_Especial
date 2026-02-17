package calculadora.app;

import calculadora.dominio.Calculadora;

public class Main {
	public void show() {
		Consola consola = new Consola();
		Analizador analizador = new Analizador();
		Calculadora calculadora = new Calculadora();
		GestorCalculadora gestor = new GestorCalculadora(analizador, calculadora);
		
		consola.escribir("CALCULADORA\n-----------------");
		while (true) {
            consola.escribir("\n > ");
            String entrada = consola.leerTexto("");;
            String respuesta = gestor.ejecutar(entrada);
            
            if (respuesta.equals("SALIR")) {
                consola.escribir("¡Adiós!");;
                
            }
            
            consola.escribir(respuesta);
        }
	}

	public static void main(String[] args) {
		new Main().show();

	}

}
