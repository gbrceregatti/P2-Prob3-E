package problema3.etapa2;

public class Produto {
    
    private String descricao;
    private double valor;
    private int peso;

    public Produto(String descricao, double valor, int peso) {
        this.descricao = descricao;
        this.valor = valor;
        this.peso = peso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if(!descricao.isEmpty())
            this.descricao = descricao;
        else
            throw new IllegalArgumentException("Descrição inválida");
        
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if(valor > 0)
            this.valor = valor;
        else
            throw new IllegalArgumentException("Valor inválido");
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        if(peso > 0)
            this.peso = peso;
        else
            throw new IllegalArgumentException("Peso inválido");
    }
    
}
