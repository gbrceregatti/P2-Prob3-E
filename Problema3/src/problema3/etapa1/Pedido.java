package problema3.etapa1;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {

    private int numero;
    private String nomeCliente;
    private Date data;
    private String endereco;
    private ArrayList<ItemPedido> itensPedido;
    private TipoEntrega tipoEntrega;

    public Pedido() {
        itensPedido = new ArrayList();
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

    public double getValorPedido() {
        double valorTotal = 0;
        for (ItemPedido item : itensPedido) {
            valorTotal += item.getProduto().getValor();
        }
        return valorTotal;
    }

    public TipoEntrega getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(TipoEntrega tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public void incluirItem(Produto produto, int quantidade) {
        ItemPedido novo = new ItemPedido(produto, quantidade);
        itensPedido.add(novo);
    }
}
