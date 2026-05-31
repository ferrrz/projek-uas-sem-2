// ============================
// Main.java
// ============================

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc =
                new Scanner(System.in);

        ZombieGame game =
                new ZombieGame();

        boolean finished = false;

        // ============================
        // INTRO STORY
        // ============================

        game.introStory();

        // ============================
        // GAME LOOP
        // ============================

        while (
                game.getChances() > 0
                        && !finished
        ) {

            // tampilkan daftar tersangka
            game.showSuspects();

            System.out.print(
                    "\nMasukkan nomor tersangka: "
            );

            int guess =
                    sc.nextInt() - 1;

            sc.nextLine();

            try {

                // ============================
                // TAMPILKAN CLUE
                // ============================

                game.showClue(guess);

                // ============================
                // KONFIRMASI PLAYER
                // ============================

                System.out.print(
                        "\nApakah kamu yakin "
                                + "dia zombie? "
                                + "(iya/tidak): "
                );

                String answer =
                        sc.nextLine();

                // ============================
                // PROSES KEPUTUSAN
                // ============================

                finished =
                        game.makeDecision(
                                guess,
                                answer
                        );

                // ============================
                // JIKA SEMUA ZOMBIE MATI
                // ============================

                if (
                        finished
                                && game.getZombiesLeft() == 0
                ) {

                    System.out.println(
                            "\n================================"
                    );

                    System.out.println(
                            "         FINAL ENDING"
                    );

                    System.out.println(
                            "================================"
                    );

                    System.out.println(
                            "\nFINAL SCORE: "
                                    + game.getScore()
                    );

                    System.out.println(
                            "\nSirine mulai berhenti..."
                    );

                    System.out.println(
                            "Suasana kota perlahan tenang."
                    );

                    System.out.println(
                            "Warga mulai keluar "
                                    + "dari tempat persembunyian."
                    );

                    System.out.println(
                            "\nUntuk malam ini..."
                    );

                    System.out.println(
                            "umat manusia berhasil bertahan."
                    );

                    System.out.println(
                            "\n\"Tetapi ancaman itu..."
                    );

                    System.out.println(
                            "belum benar-benar hilang.\""
                    );

                    System.out.println(
                            "\n=========== THE END ==========="
                    );
                }

            }

            // ============================
            // JIKA SALAH MENEBak
            // ============================

            catch (
                    WrongGuessException e
            ) {

                System.out.println(
                        "\n" + e.getMessage()
                );

                System.out.println(
                        "\nKesempatan tersisa: "
                                + game.getChances()
                );

                // jika belum kalah
                if (
                        game.getChances() > 0
                ) {

                    System.out.println(
                            "\nSuasana semakin mencekam..."
                    );

                    System.out.println(
                            "Terdengar jeritan "
                                    + "dari kejauhan..."
                    );

                    System.out.println(
                            "Lampu kota mulai padam "
                                    + "satu per satu.\n"
                    );
                }
            }
        }

        // ============================
        // GAME OVER
        // ============================

        if (
                game.getChances() == 0
        ) {

            System.out.println(
                    "\n================================"
            );

            System.out.println(
                    "           GAME OVER"
            );

            System.out.println(
                    "================================"
            );

            System.out.println(
                    "\nZombie berhasil menyusup "
                            + "ke dalam kota..."
            );

            System.out.println(
                    "Orang-orang mulai berteriak..."
            );

            System.out.println(
                    "Suasana berubah menjadi kacau."
            );

            System.out.println(
                    "Satu per satu warga tumbang..."
            );

            System.out.println(
                    "\nTidak ada yang selamat."
            );

            System.out.println(
                    "\nFINAL SCORE: "
                            + game.getScore()
            );
        }

        // tutup scanner
        sc.close();
    }
}