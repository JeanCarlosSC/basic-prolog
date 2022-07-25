import java.awt.*;

public class PoligonoDibujable extends Dibujable {
    private final int[] xPoints;
    private final int[] yPoints;
    int sides;

    public PoligonoDibujable(Poligono poligono) {
        sides = poligono.getCantidadDeLados();
        xPoints = new int[sides];
        yPoints = new int[sides];
        double length = poligono.getLongitudDeLado();

        double angle = (2 * Math.PI) / sides;
        double radius = (length / 2) / Math.sin(angle / 2);

        for (var i = 1; i <= sides; i++) {
            xPoints[i-1] = (int) (Math.cos(angle * i) * radius) + 100;
            yPoints[i-1] = (int) (Math.sin(angle * i) * radius) + 100;
        }

        setSize((int) radius * 5 + 50, (int) radius * 5 + 50);
        setLocation(5, 5);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawPolygon(xPoints, yPoints, sides);
    }
}
