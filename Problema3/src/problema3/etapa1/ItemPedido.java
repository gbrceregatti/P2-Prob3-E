package problema3.etapa1;

public class ItemPedido {
 
    private Produto produto;
    private int quantidade;
    
    protected ItemPedido(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
    }

    protected Produto getProduto() {
        return produto;
    }

    protected void setProduto(Produto produto) {
        this.produto = produto;
    }

    protected int getQuantidade() {
        return quantidade;
    }

    protected void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    protected double getValorItem(){
        return produto.getValor();
    }
}
