import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        //Eliges la palabra a adivinar, que en este caso es inteligencia↓
        String palabrasecreta = "inteligencia";
        int intentosMaximos = 10;
        int intentos = 0;
        boolean palabrasAdivinadas = false;

        char[] letrasAdivinadas = new char[palabrasecreta.length()];

        for(int i=0 ; i < letrasAdivinadas.length;i++){
            letrasAdivinadas[i] = '_';
        }
        
        while (!palabrasAdivinadas && intentos<intentosMaximos) {

            System.out.println("JUEGO ADIVINA LA PALABRA");
            System.out.println("Palabra a adivinar: "+ String.valueOf(letrasAdivinadas) + " (" + palabrasecreta.length() + " letras)");
            System.out.println("Introduce una letra, por favor");
            
            char letra = Character.toLowerCase(scanner.next().charAt(0));

            boolean letraCorrecta = false;

            for(int i=0; i < palabrasecreta.length();i++){

                if (palabrasecreta.charAt(i)==letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }
            if (!letraCorrecta) {
                intentos++;
                System.out.println("¡Incorrecto! Te quedan "+ (intentosMaximos-intentos)+ " intentos.");
            }
            if (String.valueOf(letrasAdivinadas).equals(palabrasecreta)) {
                palabrasAdivinadas = true;
                System.out.println("FELICIDADES HAS ADIVINADO");
            }
        }
        if (!palabrasAdivinadas) {
            System.out.println("QUE PENA TE HAS QUEDADO SIN INTENTOS");
        }
        scanner.close();
    }
}