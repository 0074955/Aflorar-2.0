package raspyberry.pi;

public class  Resistor extends Componentes implements Interface {

    //ATRIBUTOS
    private double vr;
    private double tolerancia; 

    
    //CONSTRUTOR

    public Resistor(double Vr, double porcentagem) {
        super("nada", "nada");
        this.vr = Vr;
        this.tolerancia = porcentagem;
    }

    
    //METODOS
    public String faixa1(int Dois) {
        double PrimeiroDigito = Dois / 10.0;
        int Um = (int) Math.floor(PrimeiroDigito); //Arredondando os dois primeiros dígitos
        return setUmeDois(Um);

    }

    public String faixa2(int Dois) {
        //System.out.println(Vr);
        Double PrimeiroDigito = vr / 10; //Subtraindo AB de A*10 para sobra o B
        int Um = (int) Math.floor(PrimeiroDigito); //Passando double para int

        Double SegundoDigito = vr - 10 * Um;
        int SegundaCasa = (int) Math.floor(SegundoDigito); //Passando double para int
        //System.out.println(Dois);
        //System.out.println(SegundoDigito); 

        return setUmeDois(SegundaCasa);

    }

    public String faixa3(int potencia) {
        String Cor[] = new String[10];
        int Dez[] = new int[10];

        if (-3 < potencia && potencia < 8) {

            Cor[0] = "Prata";
            Cor[1] = "Ouro";
            Cor[2] = "Preto";
            Cor[3] = "Marrom";
            Cor[4] = "Vermelho";
            Cor[5] = "Laranja";
            Cor[6] = "Amarelo";
            Cor[7] = "Verde";
            Cor[8] = "Azul";
            Cor[9] = "Violeta";

            return Cor[potencia + 2];

        }
        return "false";
    }
    
    
    //GETTERS E SETTERS
    
    public void getCores() {
        //System.out.println(Vr); sout de teste
        double qtNum = Math.log10(this.vr) + 1; //Ex: 10000, log10000 = 4, 4 +1 = 5 dígitos. A partir do numero descobir quual "10" usar
        int qt = (int) Math.floor(qtNum); //Arredondando valres de double para int

        //System.out.println(qt); sout de teste
        int elevado = qt - 2;
        double DoisDg = vr / (Math.pow(10, elevado));

        int Dois = (int) Math.floor(DoisDg); //Arredondando os dois primeiros dígitos

        String faixa1 = faixa1(Dois);
        String faixa2 = faixa2(Dois);
        String faixa3 = faixa3(qt - 2); //Número de dígitos menos dois vai ser a quantidade de 0´s, portanto a potência
        String faixa4 = getFaixa4();

        System.out.println("faixa1: " + faixa1 + ", faixa2: " + faixa2 + ", faixa3: " + faixa3 + " e faixa4: " + faixa4);
    }

    public String getFaixa4() {
        String Cor[] = new String[8];
        Double PorCem[] = new Double[8];

        Cor[0] = "Cinza";
        Cor[1] = "Violeta";
        Cor[2] = "Azul";
        Cor[3] = "Verde";
        Cor[4] = "Marrom";
        Cor[5] = "Vermelhi";
        Cor[6] = "Ouro";
        Cor[7] = "Prata";

        double a = 1.0;

        for (int i = 0; i < 8; i++) {
            PorCem[i] = 0.05 * a;

            if (i == 1 || i == 5) {
                a *= 2.5;
            } else {
                a *= 2.0;
            }

        }

        for (int j = 0; j < 8; j++) {
            if (this.tolerancia == PorCem[j]) {
                return Cor[j];
            }
        }

        return "false";
    }

    public String setUmeDois(int valor) {

        String Cor[] = new String[10];

        Cor[0] = "Preto";
        Cor[1] = "Marrom";
        Cor[2] = "Vermelho";
        Cor[3] = "Laranja";
        Cor[4] = "Amarelo";
        Cor[5] = "Verde";
        Cor[6] = "Azul";
        Cor[7] = "Violeta";
        Cor[8] = "Cinza";
        Cor[9] = "Branco";

        for (int i = 0; i < 10; i++) {
            if (valor == i) {
                return Cor[i];
            }

        }
        return "false";

    }

    @Override
    public String getStatus(){
        return ("Tipo: " + this.vr + ".Tolerancia: " + this.tolerancia);
    }
    
    
}
