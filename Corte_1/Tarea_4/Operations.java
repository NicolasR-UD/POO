public class Operations {

    // Método para sumar dos números
    public int sumar(int a, int b) {
        return a + b;
    }

    // Método para restar dos números
    public int restar(int a, int b) {
        return a - b;
    }

    // Método para multiplicar dos números
    public int multiplicacion(int a, int b) {
        return a * b;
    }

    // Método para calcular la potencia
    public int potencia(int base, int exponente) {
        return exponente == 0 ? 1 : base * potencia(base, exponente - 1);
    }
}
