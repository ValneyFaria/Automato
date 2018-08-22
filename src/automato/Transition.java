package automato;

public class Transition {
	private String Simbolo;
	private String EstadoOrigem;
	private String EstadoDestino;

	public String getEstadoOrigem() {
		return EstadoOrigem;
	}

	public void setEstadoOrigem(String estadoOrigem) {
		EstadoOrigem = estadoOrigem;
	}

	public String getEstadoDestino() {
		return EstadoDestino;
	}

	public void setEstadoDestino(String estadoDestino) {
		EstadoDestino = estadoDestino;
	}

	public String getSimbolo() {
		return Simbolo;
	}

	public void setSimbolo(String simbolo) {
		Simbolo = simbolo;
	}
}