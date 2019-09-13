package problema3.etapa2;

public class EncomendaEntregaLocal implements IEntrega{

    private static EncomendaEntregaLocal encomendaEntregaLocal;
    
    private EncomendaEntregaLocal(){
        
    }
    
    public static EncomendaEntregaLocal getInstance(){
        if(encomendaEntregaLocal == null){
            encomendaEntregaLocal = new EncomendaEntregaLocal();
        }
            return encomendaEntregaLocal;
    }
    
    @Override
    public double calcularValorEntrega(Pedido pedido) {
        return 0D;
    }
}
