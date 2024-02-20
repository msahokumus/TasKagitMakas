import java.util.Scanner;
import java.util.Random;

public class TasKagitMakas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"taş", "kağıt", "makas"};

        System.out.println("Taş kağıt makas oyununa hoş geldiniz!");

        int playerScore = 0;
        int computerScore = 0;

        while (true) {
            System.out.println("\nSizin Skorunuz: " + playerScore);
            System.out.println("Bilgisayarın Skoru: " + computerScore);

            // Kullanıcının hamlesinin klavyeden alınması
            System.out.print("Lütfen hamlenizi seçin (taş, kağıt, makas - çıkmak için q): ");
            String playerMove = scanner.nextLine().toLowerCase();

            if (playerMove.equals("q")) {
                System.out.println("Oyundan çıkılıyor...");
                break;
            }

            if (!playerMove.equals("taş") && !playerMove.equals("kağıt") && !playerMove.equals("makas")) {
                System.out.println("Geçersiz hamle. Lütfen tekrar deneyin.");
                continue;
            }

            // Bilgisayarın rastgele hamle yapması
            int computerIndex = random.nextInt(3);
            String computerMove = moves[computerIndex];

            System.out.println("Bilgisayarın hamlesi: " + computerMove);

            if (playerMove.equals(computerMove)) {
                System.out.println("Berabere!");
            } else if ((playerMove.equals("taş") && computerMove.equals("makas")) ||
                    (playerMove.equals("kağıt") && computerMove.equals("taş")) ||
                    (playerMove.equals("makas") && computerMove.equals("kağıt"))) {
                System.out.println("Tebrikler, kazandınız!");
                playerScore++;
            } else {
                System.out.println("Maalesef, kaybettiniz!");
                computerScore++;
            }
        }

        System.out.println("\nOyun sona erdi!");
        System.out.println("Sonuçlar:");
        System.out.println("Sizin Skorunuz: " + playerScore);
        System.out.println("Bilgisayarın Skoru: " + computerScore);

        scanner.close();
    }
}
