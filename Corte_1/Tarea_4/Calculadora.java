import javax.swing.*;

public class Calculadora extends JFrame {

    private Operations operations; // Usamos la clase Operations

    // Constructor para la interfaz
    public Calculadora() {
        operations = new Operations(); // Instanciamos la clase Operations

        // Configuración de la ventana principal
        setTitle("Operaciones Matemáticas");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Realizamos los cálculos después de que los números sean ingresados
        realizarOperaciones();
    }

    // Método que realiza el cálculo y muestra los resultados en una sola ventana
    private void realizarOperaciones() {
        try {
            // Ventana para ingresar el primer número (A)
            String inputA = JOptionPane.showInputDialog(this, "Ingresa el primer número (A):");
            int a = Integer.parseInt(inputA); // Convertimos el valor ingresado a entero

            // Ventana para ingresar el segundo número (B)
            String inputB = JOptionPane.showInputDialog(this, "Ingresa el segundo número (B):");
            int b = Integer.parseInt(inputB); // Convertimos el valor ingresado a entero

            // Mostrar los números ingresados
            StringBuilder resultados = new StringBuilder();
            resultados.append("El número A es: ").append(a).append("\n");
            resultados.append("El número B es: ").append(b).append("\n");

            // Realizar las operaciones
            int resultadoSuma = operations.sumar(a, b);
            int resultadoResta = operations.restar(a, b);
            int resultadoMultiplicacion = operations.multiplicacion(a, b);
            int resultadoPotencia = operations.potencia(a, b);

            // Concatenar los resultados en un solo mensaje
            resultados.append("\nResultado de la Suma: ").append(resultadoSuma).append("\n");
            resultados.append("Resultado de la Resta: ").append(resultadoResta).append("\n");
            resultados.append("Resultado de la Multiplicación: ").append(resultadoMultiplicacion).append("\n");
            resultados.append("Resultado de la Potenciación: ").append(resultadoPotencia).append("\n");

            // Mostrar todos los resultados en una sola ventana emergente
            JOptionPane.showMessageDialog(this, resultados.toString(), "Resultados de las Operaciones", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
           
        }
    }

    // Método main para ejecutar la aplicación
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Crear e iniciar la interfaz gráfica
                Calculadora gui = new Calculadora();
                gui.setVisible(true);
            }
        });
    }
}