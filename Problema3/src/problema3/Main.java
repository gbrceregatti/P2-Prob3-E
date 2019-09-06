package problema3;

import java.util.Date;
import problema3.etapa1.Pedido;
import problema3.etapa1.Produto;
import problema3.etapa1.TipoEntrega;
import problema3.etapa1.TipoEntregaInvalido;

public class Main {

    public static void main(String[] args) {

        Pedido pedido1 = new Pedido();
        Produto produto = new Produto("Produto1", 1, 1000);
        pedido1.incluirItem(produto, 1);
        Produto produto2 = new Produto("Produto2", 1, 1000);
        pedido1.incluirItem(produto2, 1);
        Produto produto3 = new Produto("Produto3", 1, 1000);
        pedido1.incluirItem(produto3, 1);
        Produto produto4 = new Produto("Produto4", 1, 1000);
        pedido1.incluirItem(produto4, 1);
        Produto produto5 = new Produto("Produto5", 1, 1000);
        pedido1.incluirItem(produto5, 1);

        pedido1.setData(new Date());
        pedido1.setEndereco("Rua Antônio da Veiga, 140");
        pedido1.setNomeCliente("Fulano");
        pedido1.setNumero(1);
        pedido1.setTipoEntrega(TipoEntrega.SEDEX);
        double valor1 = pedido1.getValorEntrega();
        // Teste 1
        mensagem("Teste 1: Sucesso");
        mensagem("Entrega com SEDEX");
        mensagem(valor1);

        // Teste 2
        pedido1.setTipoEntrega(TipoEntrega.RETIRADA_LOCAL);
        double valor2 = pedido1.getValorEntrega();
        mensagem("Teste 2: Sucesso");
        mensagem("Entrega com Retirada Local");
        mensagem(valor2);
                
        // Teste 3
        Produto produto6 = new Produto("Produto5", 1, 1000);
        pedido1.incluirItem(produto6, 1);
        pedido1.setTipoEntrega(TipoEntrega.ENCOMENDA_PAC);
        try {
            mensagem("Teste 3: Lança excessão");
            mensagem("Entrega com PAC");
            double valor3 = pedido1.getValorEntrega();
            mensagem(valor3);
        }
        catch(TipoEntregaInvalido ex){
            mensagem("Lancei excessão");
        }
    }

    public static void mensagem(Object mensagem) {
        System.out.println(mensagem);
    }
}
