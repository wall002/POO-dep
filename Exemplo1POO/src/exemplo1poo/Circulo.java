package exemplo1poo;

public class Circulo {
    
    int x;
    int y;
    int raio;
    
    public double calcularArea(){
    
        double area = Math.PI * Math.pow(raio, 2.0);
        return area;
        
    }
    
}
