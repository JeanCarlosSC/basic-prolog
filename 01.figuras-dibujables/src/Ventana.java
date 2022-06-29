import javax.swing.*;
import java.awt.*;
class Ventana extends JFrame{
    private JButton btPoligono;
    private JButton btCirculo;
    private JScrollPane scroll;
    private Circulo circulo;
    private Poligono poligono;

    public Ventana(Circulo circulo, Poligono poligono){
        this.circulo = circulo;
        this.poligono = poligono;

        crearBotones();
        crearPanel();

        setSize(1000,700);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void crearPanel(){
        scroll = new JScrollPane();
        scroll.setBounds(32, 96, 500, 500);
        add(scroll);
    }

    public void crearBotones() {
        btPoligono = new JButton("Dibujar Poligono");
        btPoligono.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        btPoligono.setBounds(32, 32, 172, 23);
        btPoligono.addActionListener(e -> dibujarPoligono());
        add(btPoligono);

        btCirculo = new JButton("Dibujar circulo");
        btCirculo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        btCirculo.setBounds(224, 32, 172, 23);
        btCirculo.addActionListener(e -> dibujarCirculo());
        add(btCirculo);
    }

    public void dibujarCirculo() {
        Dibujable dibujo = new CirculoDibujable(circulo);
        scroll.removeAll();
        scroll.add(dibujo);
        scroll.repaint();
    }
    public void dibujarPoligono() {
        Dibujable dibujo = new PoligonoDibujable(poligono);
        scroll.removeAll();
        scroll.add(dibujo);
        scroll.repaint();
    }
}
