package pcd.practica_4;

/**
 *
 * @author adri
 */
public interface ICola {
    
    public int getNum();
    
    /**
     * Inserta un elemento en la cola
     * @param elemento
     * @throws Exception 
     */
    public void Acola(Object elemento) throws Exception;
    
    /**
     * Extrae un elemento de la cola
     * @return
     * @throws Exception 
     */
    public Object Desacola() throws Exception;
    
    public Object Primero() throws Exception;
}
