package raspyberry.pi;

public class SensorUmidade extends Componentes{
    
     //ATRIBUTOS
    private double valor;

    
    
    public SensorUmidade(String tipo, String io){
        super(tipo, io);
    }

     public double getSortearValor(){
        double valor = Math.random()*100;
        
        int e = (int) Math.floor(valor);
        return e;
    }

    
    public void setControleUmidade(LED a) {
        double valor = Math.random() * 100; //sorteia um valor de 0 a 100

        this.valor = valor;
        
        if (this.valor < 40.0) {
            a.acender();
            System.out.println("Alerta: umidade abaixo de 40 (na escala).");
        } else {
            System.out.println("LED apagado: umidade dentro dos parâmetros requeridos.");

        }
    }

    
}
