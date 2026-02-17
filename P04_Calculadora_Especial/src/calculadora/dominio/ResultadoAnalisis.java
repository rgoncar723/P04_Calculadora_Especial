package calculadora.dominio;
import java.util.List;
public record ResultadoAnalisis(
		TipoComando comando,
		List<Double>numeros,
		List<TipoOperador>operadores,
		String mensajeError) {

}
