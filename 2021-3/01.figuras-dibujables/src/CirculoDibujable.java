import java.awt.*;

class CirculoDibujable extends Dibujable {
    private Circulo circulo;

    public CirculoDibujable(Circulo circulo) {
        this.circulo = circulo;
        setSize((int)circulo.getRadio()*2+4, (int)circulo.getRadio()*2+4);
        setLocation(5,5);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawOval(0,0, 2*(int)circulo.getRadio(), 2*(int)circulo.getRadio());
    }
}
