import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CajeroAutomatico {
    private JFrame frame;
    private Cajero cajero;

    public CajeroAutomatico() {
        cajero = new Cajero(0); 
        initialize();
    }

 
    private void initialize() {
     
        frame = new JFrame("Cajero Automático");
        frame.setBounds(100, 100, 400, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());

        
        JButton btnConsultarSaldo = new JButton("Consultar Saldo");
        btnConsultarSaldo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarSaldo();
            }
        });
        frame.getContentPane().add(btnConsultarSaldo);

        
        JButton btnDepositar = new JButton("Depositar");
        btnDepositar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarDeposito();
            }
        });
        frame.getContentPane().add(btnDepositar);

       
        JButton btnRetirar = new JButton("Retirar");
        btnRetirar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarRetiro();
            }
        });
        frame.getContentPane().add(btnRetirar);

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.getContentPane().add(btnSalir);

      
        frame.setVisible(true);
    }

    
    private void mostrarSaldo() {
        JOptionPane.showMessageDialog(frame, "Tu saldo es: " + cajero.consultarSaldo(), 
                                      "Consultar Saldo", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarDeposito() {
        JTextField txtMonto = new JTextField(10);
        Object[] mensaje = {
            "Monto a depositar:", txtMonto
        };

        int opcion = JOptionPane.showConfirmDialog(frame, mensaje, "Depositar dinero", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            try {
                double monto = Double.parseDouble(txtMonto.getText());
                cajero.realizarDeposito(monto);
                JOptionPane.showMessageDialog(frame, "Depósito exitoso. Nuevo saldo: " + cajero.consultarSaldo());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Por favor ingresa un monto válido.", 
                                              "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

   
    private void mostrarRetiro() {
        JTextField txtMonto = new JTextField(10);
        Object[] mensaje = {
            "Monto a retirar:", txtMonto
        };

        int opcion = JOptionPane.showConfirmDialog(frame, mensaje, "Retirar dinero", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            try {
                double monto = Double.parseDouble(txtMonto.getText());
                if (cajero.retirar(monto)) {
                    JOptionPane.showMessageDialog(frame, "Retiro exitoso. Nuevo saldo: " + cajero.consultarSaldo());
                } else {
                    JOptionPane.showMessageDialog(frame, "Fondos insuficientes.", 
                                                  "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Por favor ingresa un monto válido.", 
                                              "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

 
    public static void main(String[] args) {
        new CajeroAutomatico();
    }
}
