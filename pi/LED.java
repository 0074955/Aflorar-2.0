package raspyberry.pi;

public class LED extends Componentes{

    //Resistor a = new Resistor(Vr e porcentagem);
    //ATRIBUTOS
    private String cor;
    private double corrente;
    private double fonteBateria;
    
    
    //CONSTRUTOR
    public LED(String cor, double corrente, double fonteBateria, String tipo, String IO) {
        super(tipo, IO);
        this.cor = cor;
        this.corrente = corrente;
        this.fonteBateria = fonteBateria;
    
    }

    
    //METODOS
    public void enviaSinal() {
        //resolver
    }
    
    public void acender() {
        //resolver
        System.out.println("Led acende");
    }
    
    
    //GETTERS E SETTERS
    public double getCalcula() {
        double Vr;
        double Vi = getTensaoOperacao();
        double Vb = this.fonteBateria;

        Vr = (Vb - Vi) / corrente;
        return Vr;
    }

    public double getTensaoOperacao() {
        double Volt[] = new double[6]; //são sei tipos de LED
        String Cor[] = new String[6];

        Cor[0] = "Vermelho";
        Cor[1] = "Laranja";
        Cor[2] = "Amarelo";
        Cor[3] = "Verde";
        Cor[4] = "Azul";
        Cor[5] = "Branco";

        for (int i = 0; i < 6; i++) {
            Volt[i] = 2.0 + i * 0.2;
        }

        for (int i = 0; i < 6; i++) {
            if (Cor[i] == this.cor) {
                return Volt[i];
            }
        }

        return 0.0;
    }

    @Override
    public String getStatus() {
     return ("Cor: " + this.cor  + ".Corrente: " + this.corrente + ".Fonte Bateria: " + this.fonteBateria);
       
    }
} 

    

 