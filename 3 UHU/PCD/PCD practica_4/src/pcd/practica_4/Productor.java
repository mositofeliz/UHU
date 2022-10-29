package pcd.practica_4;

import java.util.Random;

/**
 *
 * @author adri
 */
public class Productor extends Thread{
    private final ICola c;
    
    public Productor(ICola c){
        this.c = c;
    }
    
    public void producir(){
        Random nRandom = new Random();
        nRandom.setSeed(System.nanoTime());
        try{
            
            //introducir 15 elementos aleatorios
            //esperar 1,2 o 3 segundos
            
            for(int i = 0; i< 15; i++){
                Thread.sleep(1000 + Math.abs(nRandom.nextInt()) % 2000);
                int n = nRandom.nextInt() % 100;
                c.Acola(n);
                System.out.println("Hilo " + getId() + ", el productor acola: " + n);
            }
        } catch (InterruptedException ex){
            System.out.println("Hilo " + getId() + " productor interrumpido");
        } catch (Exception ex){
            System.out.println("Hilo " + getId() + " productor termina por no poder insertar");
        }
        System.out.println("El HILO " + getId() + " termina.");
    }
    
    @Override
    public void run() {
        producir();
    }
}
