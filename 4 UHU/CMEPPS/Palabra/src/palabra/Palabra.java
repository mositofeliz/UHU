package palabra;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author adri
 */
public class Palabra {

    private static Random azar = new Random();
    	private static final String[] PALABRAS = new String[] {
			"CAMION", "GALLETA", "CHARCO", "MERCEDES",
			"OBLICUO", "CIRIO", "VELETA", "BANDERA"
	};
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner teclado = new Scanner(System.in);
        int aciertos = 0;
        
        
        ArrayList<Integer> indices = new ArrayList<Integer>();
	for (int i = 0; i < PALABRAS.length; i++)
            indices.add(i);
        
        for (int i = 1; i <= 5; i++) {
            System.out.println("\n\tPALABRA #" + i);
            int indice = indices.remove(azar.nextInt(indices.size()));
            String palabra = PALABRAS[indice];
            desordena(palabra);
            System.out.print("\n¿Qué palabra es?: ");
            String respuesta = teclado.nextLine();
            if (respuesta.equalsIgnoreCase(palabra)) {
                    System.out.println("¡Correcto!");
                    aciertos++;
            }
            else
                    System.out.println("¡Incorrecto!");
            }
        
        System.out.println("\nAciertos: " + aciertos);
        System.out.println("\nAciertos: " + (5-aciertos));
        teclado.close();
    }
    
    private static void desordena(String palabra){
        ArrayList<Integer> indices = new ArrayList<Integer>();
	for (int i = 0; i < palabra.length(); i++)
            indices.add(i);
        
        while(!indices.isEmpty()){
            int indice = indices.remove(azar.nextInt(indices.size()));
            System.out.println(palabra.charAt(indice) + " ");
        }
    }
    
}
