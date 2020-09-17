import javax.swing.*;

public class Login {
    public static void launch() {
        JFrame f = new JFrame();
        JButton b = new JButton("mensaje");
        JLabel l = new JLabel("nombre");
        JTextField tf = new JTextField("");
        
        b.setBounds(130, 100, 100, 40);
        l.setBounds(40, 40, 100, 40);
        tf.setBounds(90, 40, 100, 20);
        f.add(b);
        f.add(l);
        f.add(tf);
        l = new JLabel("apellido");
        JTextField ntf = new JTextField("");
        l.setBounds(40, 60, 100, 40);
        ntf.setBounds(90, 70, 100, 20);
        f.add(l);
        f.add(ntf);
        f.setSize(400, 500);
        f.setLayout(null);
        f.setVisible(true);
        b.addActionListener(e -> {
            Consultar c = new Consultar();
            if (c.validar(tf.getText(), ntf.getText())) {
                f.setVisible(false);
                Users u =new Users();
                u.launch();
            } else {
                JOptionPane.showMessageDialog(f, " no paso");
            }
        });

    }
}
