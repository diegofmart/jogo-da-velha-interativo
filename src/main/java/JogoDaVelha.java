import java.util.Random;
import java.util.Scanner;

class JogoDaVelha {
    
private JogoDaVelha(Jogador jogador1, Jogador jogador2, Tabuleiro tabuleiro)
{
    this.jogador1 = jogador1;
    this.jogador2 = jogador2;
    this.tabuleiro = tabuleiro;
}

    private void iniciar () {
           Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Escolha seu símbolo (X ou O): ");
        char simboloHumano = sc.next().toUpperCase().charAt(0);

        char simboloMaquina = (simboloHumano == 'X') ? 'O' : 'X';

        Jogador jogador1 = new Jogador(simboloHumano, "Humano");
        Jogador jogador2 = new Jogador(simboloMaquina, "Máquina");

        Tabuleiro tabuleiro = new Tabuleiro();

        int linha, coluna;
        boolean vezHumano = true;

        while (!tabuleiro.acabouOJogo()) {

            if (vezHumano) {
                System.out.println("\nVez do " + jogador1.getNome());

                while (true) {
                    System.out.print("Linha (0-2): ");
                    linha = sc.nextInt();

                    System.out.print("Coluna (0-2): ");
                    coluna = sc.nextInt();

                    if (tabuleiro.jogar(jogador1.getSimbolo(), linha, coluna)) {
                        break;
                    } else {
                        System.out.println("Posição ocupada! Tenta de novo.");
                    }
                }

            } else {
                System.out.println("\nVez da " + jogador2.getNome());

                do {
                    linha = random.nextInt(3);
                    coluna = random.nextInt(3);
                } while (!tabuleiro.jogar(jogador2.getSimbolo(), linha, coluna));
            }

            tabuleiro.mostrar();
            vezHumano = !vezHumano;
        }

        if (tabuleiro.haUmVencedor()) {
            if (!vezHumano) {
                System.out.println("O jogador 1 ganhou");
            } else {
                System.out.println("O jogador 2 ganhou");
            }
        } else {
            System.out.println("O jogo terminou empatado.");
        }
        System.out.println(" Feito por DIego F.");
    }
    
}

}

     
