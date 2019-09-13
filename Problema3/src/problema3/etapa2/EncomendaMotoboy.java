package problema3.etapa2;

public class EncomendaMotoboy implements IEntrega {

    private static EncomendaMotoboy encomendaMotoboy;

    private EncomendaMotoboy() {

    }

    public static EncomendaMotoboy getInstance() {
        if (encomendaMotoboy == null) {
            encomendaMotoboy = new EncomendaMotoboy();
        }
        return encomendaMotoboy;
    }

    @Override
    public double calcularValorEntrega(Pedido pedido) {
        if (pedido.getPesoTotal() > 25 || pedido.getItensPedido() > 30) {
            throw new TipoEntregaInvalido();
        } else {
            return 7;
        }
    }
}
