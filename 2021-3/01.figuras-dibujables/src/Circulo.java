import java.lang.Math;

public class Circulo extends Figura {

    private double radio;

    public Circulo(double radio) {
        setRadio(radio);
    }

    public void setRadio(double radio){
        this.radio = radio;
    }

    public double getRadio(){
        return radio;
    }

    @Override
    public double calcularArea() {
        area = Math.pow(radio, 2) * Math.PI;
        return area;
    }

    @Override
    public double calcularPerimetro() {
        perimetro = 2 * Math.PI * radio;
        return perimetro;
    }
}
