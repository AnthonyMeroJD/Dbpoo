import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.MouseListener;

public class Users {
    private int uid;
    private    Consultar c=new Consultar();
    public void launch(){
        JFrame f = new JFrame();
        JPanel panelTabla=new JPanel();
        JPanel panelInferior=new JPanel(new FlowLayout());
        JButton actualizar=new JButton("actualizar");
        f.setSize(400, 500);
        JTable jt=treaerTabla();
        JScrollPane sp=new JScrollPane(jt);
        f.setLayout(new BorderLayout());
        panelTabla.add(sp);
        JTextField tfNombre=new JTextField(15);
        JTextField tfContra=new JTextField(15);
        panelInferior.add(new JLabel("nombre"));
        panelInferior.add(tfNombre);
        panelInferior.add(new JLabel("contraseña"));
        panelInferior.add(tfContra);
        panelInferior.add(actualizar);
        panelInferior.setBackground(Color.cyan);
        f.getContentPane().add(panelTabla,BorderLayout.CENTER);
        f.getContentPane().add(panelInferior,BorderLayout.SOUTH);
        menu(f);
        actualizar.addActionListener(e->{
            if (uid!=0){
                if (c.actualizarDatos("usuario",tfNombre.getText(), String.valueOf(uid))){
                    JOptionPane.showMessageDialog(f,"Se actualizo los datos");
                    JScrollPane spa=new JScrollPane(treaerTabla());
                    panelTabla.add(spa);
                    f.remove(panelTabla);
                    f.add(panelTabla);
                    f.revalidate();
                    f.repaint() ;

                }else {
                    JOptionPane.showMessageDialog(f,"No se actualizo los datos");
                }

            }
        });
        f.setVisible(true);
        selectRow(jt,tfNombre,tfContra);
    }
    private JTable treaerTabla(){

        String data[][]=c.consultarUser();
        String column[]={"User","Contraseña"};
        JTable jt=new JTable(data,column);
        jt.setBounds(30,70,100,100);
        return jt;
    }
    private void selectRow(JTable jt,JTextField nombre,JTextField contra){
        jt.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && jt.getSelectedRow() != -1){
                uid=jt.getSelectedRow()+1;
                nombre.setText( jt.getValueAt(jt.getSelectedRow(),0).toString());
                contra.setText(jt.getValueAt(jt.getSelectedRow(),1).toString());
            }
        });
    }
    private  void menu(JFrame f){
        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("menu1");
        JMenuItem sub = new JMenuItem("submenu1");
        JMenu menu1 = new JMenu("menu2");
        JMenuItem sub1 = new JMenuItem("submenu1");
        JMenuItem sub2 = new JMenuItem("submenu2");
        JMenuItem sub3 = new JMenuItem("submenu3");
        menu1.add(sub1);
        menu1.add(sub2);
        menu1.add(sub3);
        menu.add(sub);
        menubar.add(menu);
        menubar.add(menu1);
        f.setJMenuBar(menubar);

    }
}
