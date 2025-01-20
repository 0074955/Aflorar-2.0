package raspyberry.pi;


public class SensorTemperatura extends Componentes implements Interface{
    
    //ATRIBUTOS
    private double valor;

    
    //CONSTRUTOR
    public SensorTemperatura(String tipo, String io){
        super(tipo, io);
    }
    
    
    //GETTERS E SETTERS
     public void setControleTemperatura(LED a) {
         double valor = Math.random() * 100; //sorteia um valor de 0.0 a 100.0
         
         this.valor = valor; 

         if (this.valor < 16 || this.valor > 26){
             a.acender();
             System.out.println("Alerta: temperatura menor que 16C e maior que 26C,");
         } else {
             System.out.println("LED apagado: temperatura dentro dos parâmetros requeridos! ");

         }        
    }
     
}
