import java.util.Scanner;

public class Main {

    public static boolean validarNumero (String texto){
        try {
            Integer.parseInt(texto);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static boolean validarNumeroMedia (String texto){
        try {
            Double.parseDouble(texto);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static int getNumber(){

        String  valorInserido;
        boolean validacao;
        int numeroDeAlgarismos = 0;

        Scanner entrada = new Scanner(System.in);

        do{
            valorInserido = entrada.nextLine();
            validacao = validarNumero(valorInserido);

            if (!validacao){
                System.out.print("VALOR INSERIDO INVALIDO. INSIRA UM NUMERO NATURAL. ");
            } else {
                numeroDeAlgarismos = Integer.parseInt(valorInserido);
            }

            if(numeroDeAlgarismos <= 0){
                System.out.print("O NUMERO DIGITADO DEVE SER MAIOR QUE ZERO: ");
            }

        }while (!validacao || numeroDeAlgarismos <= 0);
        return numeroDeAlgarismos;
    }

    public static double getNumberMedia(){

        Scanner input = new Scanner(System.in);

        String valorInseridoMedia;
        boolean validacaoMedia;
        double valorInseridoNaMedia = 0;

        do{
            valorInseridoMedia = input.nextLine();
            validacaoMedia = validarNumeroMedia(valorInseridoMedia);

            if(!validacaoMedia){
                System.out.print("VALOR INSERIDO INVALIDO. INSIRA UM NUMERO INTEIRO: ");
            } else {
                valorInseridoNaMedia = Double.parseDouble(valorInseridoMedia);
            }
        }while (!validacaoMedia);
        return  valorInseridoNaMedia;
    }

    public static String getTipoMedia(){

        Scanner inputTipoMedia = new Scanner(System.in);
        String tipoMedia;
        String mediaUpper;

        do{
            tipoMedia = inputTipoMedia.nextLine();
            mediaUpper = tipoMedia.toUpperCase();

            if(!mediaUpper.equals("HARMONICA") && !mediaUpper.equals("ARITMETICA")){
                System.out.print("INSERIDO UM TIPO DE MEDIA INVALIDO. INSIRA  HARMONICA OU ARITMETICA. ");
            }
        }while (!mediaUpper.equals("HARMONICA") && !mediaUpper.equals("ARITMETICA"));
        return mediaUpper;
    }


    public static void main(String[] args) {

        int numerosDigitados = 0;

        System.out.println("CALCULO DA MEDIA E MEDIA HARMONICA.");

        System.out.print("DIGITE O NUMERO DE ALGARISMOS A SEREM ANALISADOS: ");
        numerosDigitados = getNumber();
        //System.out.printf("%d",numerosDigitados);

        double[] numerosAnalisados = new double[numerosDigitados];

        for (int i = 0; i < numerosDigitados; i++) {
            System.out.printf("DIGITE O %do NUMERO: ", i+1);
            numerosAnalisados[i] = getNumberMedia();
        }

        System.out.print("DIGITE O MODELO DE MEDIA DESEJADA: HARMONICA OU ARITMETICA: ");

        String tipoDeMedia;
        tipoDeMedia = getTipoMedia();


        if(tipoDeMedia.equals("ARITMETICA")){

            double soma = 0;
            int count = 0;

            for (int i = 0; i < numerosDigitados; i++) {

                soma += numerosAnalisados[i];
                count ++;
            }

            double mediaAritmetica = soma/count;

            System.out.println("\nRELATORIO FINAL.");
            System.out.printf("FOI ESCOLHIDA A MEDIA %s\n",tipoDeMedia);
            System.out.print("OS VALORES INSERIDOS FORAM: ");
            for (int i = 0; i < numerosDigitados; i++) {
                System.out.print(" " + numerosAnalisados[i]);
            }

            System.out.printf("\nO VALOR DA MEDIA ARITMETICA EH: %.2f", mediaAritmetica);
        }

        if(tipoDeMedia.equals("HARMONICA")){

            double somaHarmonica = 0;
            int countHarmonica = 0;


            for (int i = 0; i < numerosDigitados; i++) {

                if(numerosAnalisados[i] == 0){
                    continue;
                }
                somaHarmonica += 1.0/numerosAnalisados[i];
                countHarmonica ++;
            }

            double mediaHarmonica = (double) countHarmonica/somaHarmonica;

            System.out.println("\nRELATORIO FINAL.");
            System.out.println("OBS: CASO UM DOS NUMEROS INSERIDOS SEJA 0, ELE SERA IGNORADO DA MEDIA HARMONICA E O CALCULO SERA FEITO SOMENTE COM OS DEMAIS");
            System.out.printf("FOI ESCOLHIDA A MEDIA %s\n",tipoDeMedia);
            System.out.print("OS VALORES INSERIDOS FORAM: ");
            for (int i = 0; i < numerosDigitados; i++) {
                System.out.print(" " + numerosAnalisados[i]);

            }
                System.out.printf("\nO VALOR DA MEDIA HARMONICA EH: %.2f", mediaHarmonica);
        }
    }
}