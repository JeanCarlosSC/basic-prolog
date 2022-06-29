public class Main {
    public static void main(String[] args) {
        Circulo circulo = new Circulo(200);
        Poligono poligono = new Poligono(6, 50);

        Ventana ventana = new Ventana(circulo, poligono);
    }

}