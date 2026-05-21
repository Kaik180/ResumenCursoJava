package Ejercicios.Avanzado.SistemaBancario;

public class CuentaBancaria {
    private String titular;
    private double saldo;

    // Constructor
    public CuentaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    // Métodos de acceso (Getters)
    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    // Lógica de negocio
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("¡Depósito con éxito! Nuevo saldo: $" + saldo);
        } else {
            System.out.println("Error: La cantidad a depositar debe ser mayor a 0.");
        }
    }

    public void retirar(double cantidad) {
        if (cantidad > saldo) {
            System.out.println("Error: Saldo insuficiente. Tu saldo actual es de: $" + saldo);
        } else if (cantidad <= 0) {
            System.out.println("Error: Cantidad no válida.");
        } else {
            saldo -= cantidad;
            System.out.println("Retiro completado. Nuevo saldo: $" + saldo);
        }
    }
}