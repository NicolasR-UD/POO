public class Cajero {

    private double saldo;

    public Cajero(double saldoInicial) {
        this.saldo = saldoInicial;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double consultarSaldo() {
        return getSaldo();
    }

    public void realizarDeposito(double cantidad) {
        if (cantidad > 0) {
            setSaldo(getSaldo() + cantidad); // Usamos el getter y setter para cambiar el saldo
        } else {
            System.out.println("La cantidad a depositar debe ser positiva.");
        }
    }

    public boolean retirar(double cantidad) {
       
        if (cantidad > 0 && cantidad <= getSaldo ()) {
            setSaldo(getSaldo() - cantidad); // Usamos el getter y setter para cambiar el saldo
            return true;
        } else {
            System.out.println("Fondos insuficientes o cantidad inválida.");
            return false;
        }
    }
}
