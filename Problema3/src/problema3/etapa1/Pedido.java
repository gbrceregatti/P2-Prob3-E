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

    public double getValorPedido() {
        double valorTotal = 0;
        for (ItemPedido item : itensPedido) {
            valorTotal += item.getValorItem();
        }
        return valorTotal;
    }
    
    public double getValorEntrega() {
        int pesoTotal = this.getPesoTotal();
        
        switch (tipoEntrega) {
            case RETIRADA_LOCAL:
                return 0D;
                
            case ENCOMENDA_PAC:
                if (pesoTotal <= 1000) {
                    return 10D;
                }
                if (pesoTotal <= 2000) {
                    return 15D;
                }
                if (pesoTotal <= 3000) {
                    return 20D;
                }
                if (pesoTotal <= 5000) {
                    return 30D;
                }
                throw new TipoEntregaInvalido();
                
            case SEDEX:
                if (pesoTotal <= 500) {
                    return 12.50D;
                }
                if (pesoTotal <= 750) {
                    return 20D;
                }
                if (pesoTotal <= 1200) {
                    return 30D;
                }
                if (pesoTotal <= 2000) {
                    return 45D;
                }
                double valorTotal = 45D;
                pesoTotal -= 2000;
                return valorTotal + (Math.ceil(pesoTotal / 100) * 1.5);
        }
        return 0D;
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
