package appMain;

import java.util.Scanner;

public class oRelogio {
    private int horas;
    private int minutos;
    private int segundos;
    private String ultimaMensagem;

    public oRelogio() {
        horas = 0;
        minutos = 0;
        segundos = 0;
    }

    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public String getUltimaMensagem() {
        return ultimaMensagem;
    }

    public void definirHorario(int horas, int minutos, int segundos) {
        if (horas >= 0 && horas < 24 && minutos >= 0 && minutos < 60 && segundos >= 0 && segundos < 60) {
            this.horas = horas;
            this.minutos = minutos;
            this.segundos = segundos;
            System.out.println("Horário alterado com sucesso.");
        } else {
            System.out.println("Horário inválido.");
        }
    }

    public void reiniciarMeiaNoite() {
        horas = 0;
        minutos = 0;
        segundos = 0;
        System.out.println("Relógio reiniciado para meia-noite.");
    }

    public void marcarIntervalo(int horaInicio, int minutoInicio, int segundoInicio, int horaFim, int minutoFim, int segundoFim) {
        if (horaInicio >= 0 && horaInicio < 24 && minutoInicio >= 0 && minutoInicio < 60 && segundoInicio >= 0 && segundoInicio < 60 &&
                horaFim >= 0 && horaFim < 24 && minutoFim >= 0 && minutoFim < 60 && segundoFim >= 0 && segundoFim < 60) {
            long inicioEmSegundos = horaInicio * 3600 + minutoInicio * 60 + segundoInicio;
            long fimEmSegundos = horaFim * 3600 + minutoFim * 60 + segundoFim;
            long tempoDecorrido = fimEmSegundos - inicioEmSegundos;

            int horasDecorridas = (int) (tempoDecorrido / 3600);
            int minutosDecorridos = (int) ((tempoDecorrido % 3600) / 60);
            int segundosDecorridos = (int) (tempoDecorrido % 60);

            System.out.printf("Tempo decorrido: %02d:%02d:%02d%n", horasDecorridas, minutosDecorridos, segundosDecorridos);
            ultimaMensagem = "Tempo decorrido: " + horasDecorridas + ":" + minutosDecorridos + ":" + segundosDecorridos;
        } else {
            System.out.println("Intervalo de tempo inválido.");
            ultimaMensagem = "Intervalo de tempo inválido.";
        }
    }

    public String imprimirFormatoHorario(boolean formato24h) {
        if (formato24h) {
            System.out.printf("%02d:%02d:%02d%n", horas, minutos, segundos);
            return String.format("%02d:%02d:%02d", horas, minutos, segundos);
        } else {
            String periodo = (horas < 12) ? "AM" : "PM";
            int horaFormato12h = (horas == 0 || horas == 12) ? 12 : horas % 12;
            System.out.printf("%d:%02d:%02d %s%n", horaFormato12h, minutos, segundos, periodo);
            return String.format("%d:%02d:%02d %s", horaFormato12h, minutos, segundos, periodo);
        }
    }

    public static void main(String[] args) {
        oRelogio relogio = new oRelogio();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 - Definir Horário");
            System.out.println("2 - Reiniciar para Meia-Noite");
            System.out.println("3 - Marcar Intervalo de Tempo");
            System.out.println("4 - Imprimir Horário");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Digite a nova hora (0-23):");
                    int novaHora = scanner.nextInt();
                    System.out.println("Digite os novos minutos (0-59):");
                    int novosMinutos = scanner.nextInt();
                    System.out.println("Digite os novos segundos (0-59):");
                    int novosSegundos = scanner.nextInt();
                    relogio.definirHorario(novaHora, novosMinutos, novosSegundos);
                    break;
                case 2:
                    relogio.reiniciarMeiaNoite();
                    break;
                case 3:
                    System.out.println("Digite a hora de início (0-23):");
                    int horaInicio = scanner.nextInt();
                    System.out.println("Digite os minutos de início (0-59):");
                    int minutoInicio = scanner.nextInt();
                    System.out.println("Digite os segundos de início (0-59):");
                    int segundoInicio = scanner.nextInt();
                    System.out.println("Digite a hora de término (0-23):");
                    int horaFim = scanner.nextInt();
                    System.out.println("Digite os minutos de término (0-59):");
                    int minutoFim = scanner.nextInt();
                    System.out.println("Digite os segundos de término (0-59):");
                    int segundoFim = scanner.nextInt();
                    relogio.marcarIntervalo(horaInicio, minutoInicio, segundoInicio, horaFim, minutoFim, segundoFim);
                    break;
                case 4:
                    System.out.println("Escolha o formato de horário:");
                    System.out.println("1 - 24 Horas");
                    System.out.println("2 - AM/PM");
                    int formatoEscolhido = scanner.nextInt();
                    boolean formato24h = (formatoEscolhido == 1);
                    relogio.imprimirFormatoHorario(formato24h);
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
