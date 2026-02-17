package calculadora.dominio;

public class Calculadora {

	public double realizarCalculo(double number1, double number2, TipoOperador operador) {
		return switch (operador) {
		case SUMA -> number1 + number2;
		case RESTA -> number1 - number2;
		case MULTIPLICACION -> number1 * number2;
		case DIVISION -> {
			if (number2 == 0) {
				throw new ArithmeticException("No se puede dividir por cero");
			}
			yield number1 / number2;
		}
		// El default es por seguridad, aunque el Enum limite las opciones
		default -> throw new IllegalArgumentException("Operador no soportado");
		};
	}
}
