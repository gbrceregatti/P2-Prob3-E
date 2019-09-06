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
        if(produto != null)
            this.produto = produto;
        else
            throw new IllegalArgumentException("Produto inválido");
    }

    protected int getQuantidade() {
        return quantidade;
    }

    protected void setQuantidade(int quantidade) {
        if(quantidade > 0)
            this.quantidade = quantidade;
        else
            throw new IllegalArgumentException("Quantidade inválida");
    }
    
    protected double getValorItem(){
        return produto.getValor() * this.getQuantidade();
    }
    
    protected double getPesoItem(){
        return produto.getPeso() * this.getQuantidade();
    }
}
