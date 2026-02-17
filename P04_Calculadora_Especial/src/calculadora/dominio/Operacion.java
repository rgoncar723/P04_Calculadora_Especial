package calculadora.dominio;

import java.util.List;

public class Operacion {
	private TipoComando comando;
	private List<TipoOperador> operador;
	private List<Double> numeros;
	private double result;

	public Operacion(TipoComando comando, List<Double> numeros, List<TipoOperador> operador, double result) {
		this.comando = comando;
		this.numeros = numeros;
		this.operador = operador;
		this.result = result;
	}

	public List<TipoOperador> getOperador() {
		return operador;
	}

	@Override
	public String toString() {
		// Un toString que recorra las listas para mostrar: 5.0 + 3.0 = 8.0
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < operador.size(); i++) {
			sb.append(numeros.get(i)).append(" ").append(operador.get(i)).append(" ");
		}
		sb.append(numeros.get(numeros.size() - 1)).append(" = ").append(result);
		return sb.toString();
	}
}
