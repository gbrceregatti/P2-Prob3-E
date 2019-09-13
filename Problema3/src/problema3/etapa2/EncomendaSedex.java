package problema3.etapa2;

public class EncomendaSedex implements IEntrega {

    private static EncomendaSedex encomendaSedex;
    
    private EncomendaSedex(){
        
    }
    
    public static EncomendaSedex getInstance(){
        if(encomendaSedex == null)
            encomendaSedex = new EncomendaSedex();
        return encomendaSedex;
    }
    
    @Override
    public double calcularValorEntrega(Pedido pedido) {
        if (pedido.getPesoTotal() <= 500) {
            return 12.50D;
        }
        if (pedido.getPesoTotal() <= 750) {
            return 20D;
        }
        if (pedido.getPesoTotal() <= 1200) {
            return 30D;
        }
        if (pedido.getPesoTotal() <= 2000) {
            return 45D;
        }
        double valorTotal = 45D;
        int pesoTotal = pedido.getPesoTotal() - 2000;
        return valorTotal + (Math.ceil(pesoTotal / 100) * 1.5);
    }
}
