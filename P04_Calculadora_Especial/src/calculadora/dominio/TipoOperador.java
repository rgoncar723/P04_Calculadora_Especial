package calculadora.dominio;

public enum TipoOperador {
SUMA('+'), RESTA('-'), MULTIPLICACION('*'), DIVISION('/');
	private final char symbol;
	
	TipoOperador(char symbol){
		this.symbol=symbol;
	}
	
	public char getSymbol() {
		return symbol;
	}
}
