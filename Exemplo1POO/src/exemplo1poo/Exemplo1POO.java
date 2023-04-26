package exemplo1poo;

public class Exemplo1POO {

    public static void main(String[] args) {

        Circulo c1 = new Circulo();
        Ponto p1 = new Ponto();
        Ponto p2 = new Ponto();

        c1.x = 10;
        c1.y = 10;
        c1.raio = 5;

        p1.setPosition(10, 5);
        p2.setPosition(7, 7);

        System.out.println("X do p1: " + p1.getX());
        System.out.println("Y do p1: " + p1.getY());

        System.out.println("X do p2: " + p2.getX());
        System.out.println("Y do p2: " + p2.getY());

        System.out.println("Área do círculo: " + c1.calcularArea());

    }
}
