public class Poligono extends Figura{
    private int cantidadDeLados;
    private double longitudDeLado;

    public Poligono(int cantidadDeLados, double longitudDeLado) {
        this.cantidadDeLados = cantidadDeLados;
        this.longitudDeLado = longitudDeLado;
    }

    public int getCantidadDeLados() {
        return cantidadDeLados;
    }

    public double getLongitudDeLado() {
        return longitudDeLado;
    }

    @Override
    public double calcularArea() {
        area = calcularPerimetro()*calcularApotema()/2.0;
        return area;
    }

    @Override
    public double calcularPerimetro() {
        perimetro = cantidadDeLados*longitudDeLado;
        return perimetro;
    }

    private double calcularApotema() {
        return longitudDeLado/2*Math.tan(Math.PI*(cantidadDeLados-2)/(2*cantidadDeLados));
    }
}