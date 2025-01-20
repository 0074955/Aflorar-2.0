package raspyberry.pi;

public abstract class Componentes implements Interface {
    
//ATRIBUTOS 
    
    private String tipo; //Analógico, digital, PWM etc.
    private String io; //Entrada ou saída

    public Componentes(String tipo, String io) {
        this.tipo = tipo;
        this.io = io;
    }

    @Override
    public String getStatus() {
        return ("Tipo:" + this.tipo + "Entrada ou saida:" + this.io);
    }
    
    
    
    
    
    

}
