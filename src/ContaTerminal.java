import java.util.Scanner;

public class ContaTerminal {

    public static Scanner scanner = new Scanner(System.in);

    public static String conta;
    public static String agencia, nome;
    public static double valor;

    public static void main(String[] args) {
        getAccountInfo();

    }

    public static void getAccountInfo() {
        String confirmar = "";

        while (confirmar != "confirmar") {
            getConta();
            getAgencia();

            System.out.println("Digite o nome do titular da conta");
            nome = scanner.nextLine();
            System.out.println("# Nome definido #");

            checkValor();
            printAllValues();

            scanner.nextLine();

            while (confirmar != "confirmar" || confirmar != "cancelar") {

                System.out.println("Digite CONFIRMAR para confirmar ou CANCELAR para recomeçar.");
                confirmar = scanner.nextLine();
                if (confirmar.toLowerCase() == "confirmar") {

                    System.out.println("Transferência realizada! Obrigado por utilizar nossos serviços.");
                    scanner.close();
                } else if (confirmar.toLowerCase() == "cancelar") {
                    System.out.println("Transferência cancelada! Insira os dados novamente.");
                }

                else {
                    System.out.println("Opção inválida! Digite CONFIRMAR ou CANCELAR");
                }
            }

        }
    }

    public static void getConta() {
        System.out.println("Digite o número da sua conta de 4 digitos: Ex. 0102");
        conta = scanner.nextLine();
        boolean contaOnlyNumbers = false;

        try {
            Integer.parseInt(conta);
            contaOnlyNumbers = true;
        } catch (Exception e) {
            contaOnlyNumbers = false;
        }

        while (conta.length() != 4 || !contaOnlyNumbers) {

            try {
                Integer.parseInt(conta);
                contaOnlyNumbers = true;
            } catch (Exception e) {
                contaOnlyNumbers = false;
            }

            if (!contaOnlyNumbers) {
                System.out.println("Tente novamente. A conta só pode ter números.");
            } else {
                System.out.println("Tente novamente. A conta precisa ter 4 dígitos");
            }

            conta = scanner.nextLine();

            try {
                Integer.parseInt(conta);
                contaOnlyNumbers = true;
            } catch (Exception e) {
                contaOnlyNumbers = false;
            }

        }

        System.out.println("# Conta definida #");
    }

    public static void getAgencia() {
        System.out.println("Digite o número da sua agencia de 5 digitos: Ex. 0102-0");
        agencia = scanner.nextLine();
        agencia = agencia.replace("-", "");
        boolean agenciaOnlyNumbers = false;

        try {
            Integer.parseInt(agencia);
            agenciaOnlyNumbers = true;
        } catch (Exception e) {
            agenciaOnlyNumbers = false;
        }

        while (agencia.length() != 5 || !agenciaOnlyNumbers) {
            agencia = agencia.replace("-", "");
            try {
                Integer.parseInt(agencia);
                agenciaOnlyNumbers = true;
            } catch (Exception e) {
                agenciaOnlyNumbers = false;
            }

            if (!agenciaOnlyNumbers) {
                System.out.println("\nTente novamente. A agência só pode ter números.");
            } else {
                System.out.println("\nTente novamente. A agência precisa ter 4 dígitos");
            }

            agencia = scanner.nextLine();
            agencia = agencia.replace("-", "");

            try {
                Integer.parseInt(agencia);
                agenciaOnlyNumbers = true;
            } catch (Exception e) {
                agenciaOnlyNumbers = false;
            }

        }

        System.out.println("# Agência definida #");
    }

    public static void checkValor() {
        System.out.println("Quanto deseja depositar?");
        boolean valorOnlyNumbers = false;
        try {
            valor = scanner.nextDouble();
            valorOnlyNumbers = true;
        } catch (Exception e) {
            valorOnlyNumbers = false;
        }

        while (!valorOnlyNumbers) {
            System.out.println("Tente novamente. O valor não pode conter letras nem simbolos");
            try {
                valor = scanner.nextDouble();
                valorOnlyNumbers = true;
            } catch (Exception e) {
                valorOnlyNumbers = false;
                scanner.nextLine();
            }

        }

        System.out.println("# Valor definido #");

    }

    public static void printAllValues() {
        System.out.println("#########################");
        System.out.println("#Confirme as informações#");
        System.out.println("#########################\n");
        System.out.printf("Conta: %s\n", conta);
        System.out.printf("Agência: %s\n", agencia);
        System.out.printf("Nome do recebedor: %s\n", nome);
        System.out.printf("Valor: %.2f\n", valor);
    }

}