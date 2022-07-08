import java.util.Scanner;

public class Elevador{

    Scanner in = new Scanner(System.in);

    int andares = 0;
    int passageiros = 0;
    int escolha = 0 ;

    public int andar; 
    public int totalAndar; 
    public int capacidade; 
    public int pessoas; 

    public void Escolha()
    {

        System.out.println("O elevador está no " + this.andar + "º");
        System.out.println("O elevador tem " + this.pessoas + " a bordo");

        System.out.print("Você quer subir ou descer ?, 0 para descer e 1 para subir: ");
        escolha = in.nextInt();

        while( escolha > 1 || escolha < 0  ){

            System.out.println("Número incorreto");

            System.out.print("Você quer subir ou descer ?, 0 para descer e 1 para subir: ");
            escolha = in.nextInt();
        }

        switch(escolha){

            case 0:
                Descer();
            break;

            case 1:
                Subir();
            break;
        }

    }

    public void Entrar()
    {
        System.out.print("Quantos passageiros entraram ? ");
        passageiros = in.nextInt();
        System.out.println("Entrando " + passageiros + " pessoas.");
        this.pessoas = this.pessoas + passageiros;

        if(this.pessoas > this.capacidade ){

            System.out.println("Elevador lotado !!");
            System.out.println( (this.pessoas - this.capacidade) + "Pessoas vão ficar do lado de fora ");

        }else{

            System.out.println("Elevador está com " + this.pessoas + " a bordo.");

        }

    }

    public void Sair()
    {

        System.out.print("Quantos passageiros sairam ? ");
        passageiros = in.nextInt();
        this.pessoas = this.pessoas - passageiros;

        if(this.pessoas == 0){

            System.out.println("Elevador vazio !!!");

        }else{

            System.out.println("Elevador está com " + this.pessoas + " a bordo.");
        }


    
    }

    public void Subir()
    {
        System.out.print("Vai subir até qual andar ? ");
        andares = in.nextInt();

        this.andar = this.andar + (andares - this.andar);

        if( this.andar >= this.totalAndar){

            this.andar = this.totalAndar;
            System.out.println("Estamos no último andar, " + this.andar + "º" );

        }else{

            System.out.println("Subindo até o " + this.andar);

        }

       

        //loop
        Sair();
        Entrar();
        Escolha();

        
    }

    public void Descer()
    {

        System.out.print("Vai descer até qual andar ? ");
        andares = in.nextInt();

        while( andares >= this.andar ){
            System.out.print("Andar inválido, Vai descer até qual andar ? ");
            andares = in.nextInt();
        }

        this.andar = (andares + this.andar) - this.andar ;
        
        if( this.andar <= 0 ){

            System.out.println("Descendo até o térreo");
            this.andar = 0;

        }else{
            System.out.println("Descendo até " + this.andar + "º");
        }

        //loop
        Sair();
        Entrar();
        Escolha();

    }

    

    public static void main(String[] args) {

   

        Elevador atrio = new Elevador();
        atrio.andar = 0;
        atrio.totalAndar = 10;
        atrio.capacidade = 15;
        atrio.pessoas = 9;

        
        atrio.Escolha();

    }

}
