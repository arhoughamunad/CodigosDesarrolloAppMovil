import java.util.Scanner;

class Vehiculo {
    private String placa;
    private String tipoVehiculo;
    private int horas;
    private int minutosAdicionales;
    private int tarifaPorMinuto;

    public Vehiculo() {
    }

    // Método para capturar la información
    public void capturarInformacion(Scanner scanner) {
        // Capturar placa
        System.out.print("Ingrese la placa del vehículo: ");
        placa = scanner.nextLine();

        // Mostrar menú de tipos de vehículo y validar la entrada
        while (true) {
            System.out.println("Seleccione el tipo de vehículo:");
            System.out.println("1. Moto ($90/minuto)");
            System.out.println("2. Automóvil ($110/minuto)");
            System.out.println("3. Camioneta ($130/minuto)");
            System.out.print("Ingrese la opción (1-3): ");
            int opcion = scanner.nextInt();

            if (opcion == 1) {
                tipoVehiculo = "Moto";
                tarifaPorMinuto = 90;
                break;
            } else if (opcion == 2) {
                tipoVehiculo = "Automóvil";
                tarifaPorMinuto = 110;
                break;
            } else if (opcion == 3) {
                tipoVehiculo = "Camioneta";
                tarifaPorMinuto = 130;
                break;
            } else {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        // Capturar horas y validar que sea un número positivo
        while (true) {
            System.out.print("Ingrese la cantidad de horas: ");
            horas = scanner.nextInt();
            if (horas >= 0) {
                break;
            } else {
                System.out.println("Las horas no pueden ser negativas. Intente nuevamente.");
            }
        }

        // Capturar minutos adicionales y validar que sea un número entre 0 y 59
        while (true) {
            System.out.print("Ingrese los minutos adicionales (0-59): ");
            minutosAdicionales = scanner.nextInt();
            if (minutosAdicionales >= 0 && minutosAdicionales < 60) {
                break;
            } else {
                System.out.println("Los minutos adicionales deben estar entre 0 y 59. Intente nuevamente.");
            }
        }
        scanner.nextLine(); // Consumir la nueva línea sobrante
    }

    // Método para calcular la cantidad de minutos
    public int calcularTotalMinutos() {
        return horas * 60 + minutosAdicionales;
    }

    // Método para calcular el valor a pagar
    public int calcularValorPagar() {
        return calcularTotalMinutos() * tarifaPorMinuto;
    }

    // Método para mostrar la información
    public void mostrarInformacion() {
        System.out.println("Información del vehículo:");
        System.out.println("Placa: " + placa);
        System.out.println("Tipo de vehículo: " + tipoVehiculo);
        System.out.println("Tiempo estacionado: " + horas + " horas y " + minutosAdicionales + " minutos");
        System.out.println("Total de minutos: " + calcularTotalMinutos());
        System.out.println("Valor a pagar: $" + calcularValorPagar());
    }
}

public class Parqueadero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            Vehiculo vehiculo = new Vehiculo();
            vehiculo.capturarInformacion(scanner);
            vehiculo.mostrarInformacion();

            // Preguntar si se desea ingresar otro vehículo
            System.out.print("¿Desea ingresar otro vehículo? (s/n): ");
            char respuesta = scanner.next().toLowerCase().charAt(0);
            if (respuesta != 's') {
                continuar = false;
            }
        }

        // Cerrar el scanner al final del programa
        scanner.close();
        System.out.println("Gracias por usar el sistema del parqueadero Autoseguro.");
    }
}
