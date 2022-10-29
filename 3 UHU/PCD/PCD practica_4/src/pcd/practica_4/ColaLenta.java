package pcd.practica_4;

/**
 *
 * @author adri
 */
public class ColaLenta implements ICola{

    private int head, tail, numelementos;
    private final int capacidad;
    private final Object[] datos;
    private final ColaCanvas canvas;
    
    public ColaLenta(int capacidad, ColaCanvas canvas){
        this.capacidad = capacidad;
        this.datos = new Object[capacidad];
        this.numelementos = this.head = this.tail = 0;
        this.canvas = canvas;
    }
    
    @Override
    public int getNum() {
        return numelementos;
    }

    @Override
    public synchronized void Acola(Object elemento) throws Exception {
        int intento = 0;
        while(colallena()){
            if(intento >= 3){
                canvas.mensajeDeAviso("COLA LLENA");
                throw new Exception("No hay espacio en la cola");
            }
            System.out.println("Hilo " + Thread.currentThread().getId() + " esta esperando para meterse");
            intento++;
            wait();
        }
        datos[tail] = elemento;
        Thread.sleep(100);
        tail = (tail + 1) % capacidad;
        Thread.sleep(100);
        numelementos++;
        canvas.representa(datos, head, tail, numelementos);
        notifyAll();
    }

    @Override
    public synchronized Object Desacola() throws Exception {
        int intento = 0;
        while (colavacia()) {
            if (intento >= 3) {
                canvas.mensajeDeAviso("COLA VACIA");
                throw new Exception("No hay elementos en la cola");
            }
            System.out.println("Hilo "+Thread.currentThread().getId()+" esperando para irse");
            intento++;
            wait();
        }
        Object elemento = datos[head];
        datos[head] = null;
        Thread.sleep(100);
        head = (head + 1) % capacidad;
        Thread.sleep(100);
        numelementos--;
        canvas.representa(datos, head, tail, numelementos);
        notifyAll();
        return elemento;
    }

    @Override
    public Object Primero() throws Exception {
        if(colavacia()){
            throw new Exception("No hay elementos en la cola");
        }
        return datos[head];
    }
    
    private boolean colavacia() {
        return numelementos == 0;
    }
    
    private boolean colallena() {
        return numelementos == capacidad;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numelementos; i++) {
            sb.append(datos[(head + i) % capacidad]).append(" ");
        }
        return sb.toString();
    }
    
    
}
