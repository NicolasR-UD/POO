public class Cajero {
    // Atributo privado saldo
    private double saldo;

    // Constructor que inicializa el saldo
    public Cajero(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    // Getter para obtener el saldo
    public double getSaldo() {
        return saldo;
    }

    // Setter para establecer el saldo
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Método para consultar el saldo (utiliza el getter)
    public double consultarSaldo() {
        return getSaldo();
    }

    // Método para realizar un depósito con un límite de 10,000,000
    public void realizarDeposito(double cantidad) {
        // Usamos el setter para cambiar el saldo
        final double LIMITE_DEPOSITO = 10000000;

        if (cantidad > 0 && cantidad <= LIMITE_DEPOSITO) {
            setSaldo(getSaldo() + cantidad); // Usamos el getter y setter para cambiar el saldo
        } else {
            System.out.println("La cantidad a depositar debe ser positiva y no mayor a " + LIMITE_DEPOSITO);
        }
    }

    // Método para realizar un retiro
    public boolean retirar(double cantidad) {
        // Usamos el getter para obtener el saldo actual y el setter para actualizar el saldo
        if (cantidad > 0 && cantidad <= getSaldo()) {
            setSaldo(getSaldo() - cantidad); // Usamos el getter y setter para cambiar el saldo
            return true;
        } else {
            System.out.println("Fondos insuficientes o cantidad inválida.");
            return false;
        }
    }
}
