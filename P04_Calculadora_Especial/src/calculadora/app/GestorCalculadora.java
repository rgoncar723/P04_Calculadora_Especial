package calculadora.app;

import java.util.ArrayList;
import java.util.List;
import calculadora.dominio.*;

public class GestorCalculadora {
	private List<Operacion> operaciones;
	private double ultimoResultado=0.0;
	private Calculadora calculadora;
	private Analizador analizador;
	public GestorCalculadora(Analizador analizador, Calculadora calculadora) {
		this.analizador=analizador;
		this.calculadora=calculadora;
		this.operaciones = new ArrayList<>(); 
	}
	public String ejecutar(String entrada) {
		ResultadoAnalisis res = analizador.analizar(entrada, ultimoResultado);
		return switch(res.comando()) {
		case ERROR -> "Error "+ res.mensajeError();
		case QUIT -> "SALIR";
		case LIST -> mostrarHistorial();
		case RESULT -> "Último resultado: " + ultimoResultado;
		case CALCULO -> procesarCalculo(res);
		case RESET -> resetear();
		default -> "";
		};
	}
	private String procesarCalculo(ResultadoAnalisis res) {
		List<Double> numeros = res.numeros();
		List<TipoOperador> operadores = res.operadores();
		double acumulado = numeros.get(0);
		Operacion op;
		try {
			for(int i=0; i<operadores.size();i++) {
				acumulado = calculadora.realizarCalculo(acumulado, numeros.get(i+1), operadores.get(i));
			}
			op = new Operacion(res.comando(), numeros, operadores, acumulado);
			operaciones.add(op);
			this.ultimoResultado=acumulado;
			return "Resultado = " + acumulado;
		}catch(ArithmeticException e) {
			return "Erros matematico: " + e.getMessage();
		}
	}
	private String mostrarHistorial() {
	    if (operaciones.isEmpty()) return "El historial está vacío.";
	    
	    StringBuilder sb = new StringBuilder("--- Historial ---\n");
	    for (int i = 0; i < operaciones.size(); i++) {
	      
	        sb.append((i + 1)).append(". ").append(operaciones.get(i).toString()).append("\n");
	    }
	    sb.append("-----------------\n");
	    sb.append("Último resultado actual: ").append(ultimoResultado);
	    return sb.toString();
	}
	private String resetear() {
        this.ultimoResultado = 0.0;
        this.operaciones.clear();
        return "Calculadora reiniciada (historial borrado).";
    }
}
