package problema3.etapa2;

import problema3.etapa1.TipoEntregaInvalido;

public class EncomendaPac implements IEntrega {

    private static EncomendaPac encomendaPac;

    private EncomendaPac() {

    }

    public static EncomendaPac getInstance() {
        if (encomendaPac == null) {
            encomendaPac = new EncomendaPac();
        }
        return encomendaPac;
    }

    @Override
    public double calcularValorEntrega(Pedido pedido) {
        if (pedido.getPesoTotal() <= 1000) {
            return 10D;
        }
        if (pedido.getPesoTotal() <= 2000) {
            return 15D;
        }
        if (pedido.getPesoTotal() <= 3000) {
            return 20D;
        }
        if (pedido.getPesoTotal() <= 5000) {
            return 30D;
        }
        throw new TipoEntregaInvalido();
    }
}
