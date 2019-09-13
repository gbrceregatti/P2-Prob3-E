package problema3.etapa2;
import java.util.ArrayList;
import java.util.Date;
import problema3.etapa1.Produto;

public class Pedido {
    
    private int numero;
    private String nomeCliente;
    private Date data;
    private String endereco;
    private ArrayList<ItemPedido> itensPedido;
    private IEntrega entrega;

    public Pedido() {
        itensPedido = new ArrayList();
    }

    public IEntrega getEntrega() {
        return entrega;
    }

    public void setEntrega(IEntrega entrega) {
        this.entrega = entrega;
    }
    
    public double getValorPedido() {
        double valorTotal = 0;
        for (ItemPedido item : itensPedido) {
            valorTotal += item.getValorItem();
        }
        return valorTotal;
    }
    
    public int getItensPedido(){
        return this.itensPedido.size();
    }
    
    public double getValorEntrega() {
        int pesoTotal = this.getPesoTotal();
        return entrega.calcularValorEntrega(this);
    }
    
    public double getValorTotal() {
        return getValorPedido() + getValorEntrega();
    }
    
    public int getPesoTotal() {
        int pesoTotal = 0;
        for (ItemPedido item: itensPedido) {
            pesoTotal += item.getPesoItem();
        }
        return pesoTotal;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if (numero > 0) {
            this.numero = numero;
        } else {
            throw new IllegalArgumentException("Número inválido");
        }
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        if (!nomeCliente.isEmpty()) {
            this.nomeCliente = nomeCliente;
        } else {
            throw new IllegalArgumentException("Nome do cliente inválido");
        }
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (!endereco.isEmpty()) {
            this.endereco = endereco;
        } else {
            throw new IllegalArgumentException("Endereço inválido");
        }
    }

    public void incluirItem(Produto produto, int quantidade) {
        ItemPedido novo = new ItemPedido(produto, quantidade);
        itensPedido.add(novo);
    }
}
