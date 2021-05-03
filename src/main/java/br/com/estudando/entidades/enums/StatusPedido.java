package br.com.estudando.entidades.enums;

public enum StatusPedido {

	AGUARDANDOPAGAMENTO(1), PAGO(2), ENVIADO(3), ENTREGUE(4), CANCELADO(5);

	private int code;

	private StatusPedido(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static StatusPedido transformarStatusPedidoPorCode(int code) {
		for (StatusPedido statusPedidoEncontrado : StatusPedido.values()) {
			if (statusPedidoEncontrado.getCode() == code) {
				return statusPedidoEncontrado;
			}

		}
		throw new IllegalArgumentException("Codigo não encontrado");
	}

}
