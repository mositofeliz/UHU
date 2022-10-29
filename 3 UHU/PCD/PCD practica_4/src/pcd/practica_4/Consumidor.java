package pcd.practica_4;

import java.util.Random;

/**
 *
 * @author adri
 */
public class Consumidor implements Runnable{
    private final ICola c;
    
    public Consumidor(ICola c){
        this.c = c;
    }
    
    private void consumir(){
        Random nRandom = new Random();
        nRandom.setSeed(System.nanoTime());
        try{
            for(int i = 0; i < 15; i++){
                Thread.sleep(1000 + Math.abs(nRandom.nextInt()) % 2000);
                System.out.println("Hilo " + Thread.currentThread().getId() + " el consumidor extrae: " + c.Desacola());
            }
        }catch(InterruptedException ex){
            System.out.println("Hilo "+Thread.currentThread().getId()+" consumidor interrumpido");
        } catch (Exception ex){
            System.out.println("Hilo "+Thread.currentThread().getId()+" consumidor termina. No poder extraer");
        }
        System.out.println("El HILO " + Thread.currentThread().getId() + " termina.");
    }
    
    @Override
    public void run() {
        consumir();
    }
}
