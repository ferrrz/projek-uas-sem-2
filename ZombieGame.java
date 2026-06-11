// ============================
// ZombieGame.java
// ============================

import java.util.ArrayList;
import java.util.List;

public class ZombieGame {

    private List<Person> suspects =
            new ArrayList<>();

    private int chances = 4;

    private int score = 100;

    // jumlah zombie
    private int zombiesLeft = 2;

    public ZombieGame() {

        suspects.add(new Human(
                "Vilya",
                "Tangannya penuh luka kecil... "
                        + "dia sering menghindari kontak mata."
        ));

        suspects.add(new Human(
                "Fera",
                "Wajahnya pucat... "
                        + "dia gemeteran... "
                        + "dan berkeringat dingin."
        ));

        // zombie 1
        suspects.add(new Zombie(
                "Idoy",
                "Matanya merah... "
                        + "kulitnya dingin... "
                        + "gerakannya kaku.",
                95
        ));

        suspects.add(new Human(
                "Huza",
                "Tatapannya kosong... "
                        + "dan napasnya terlalu cepat."
        ));

        suspects.add(new Human(
                "Rina",
                "Dia terus menatap lantai... "
                        + "dan tidak menjawab siapa pun."
        ));

        suspects.add(new Human(
                "Neneng",
                "langkahnya lambat dan tidak stabil. "
                        + "pakaiannya penuh noda darah."
        ));

        // zombie 2
        suspects.add(new Zombie(
                "Hilga",
                "Kulitnya pucat... "
                        + "darah menetes dari mulutnya.",
                80
        ));

        suspects.add(new Human(
                "Ditha",
                "Napasnya berat dan sedikit pucat... "
                        + "tangannya gemetar."
        ));

        suspects.add(new Human(
                "doni",
                "tidak banyak bergerak. "
                        + "hanya berdiri diam melihat kerumunan."
        ));

        suspects.add(new Human(
                "kimdan",
                "saat dipanggil. "
                        + "dia tidak merespon."
        ));
    }

    // ============================
    // EFEK TULISAN PERLAHAN
    // ============================

    public void slowPrint(String text) {

        for (char c : text.toCharArray()) {

            System.out.print(c);

            try {

                Thread.sleep(30);

            } catch (
                    InterruptedException e
            ) {

                Thread.currentThread()
                        .interrupt();
            }
        }

        System.out.println();
    }

    // ============================
    // NARASI AWAL
    // ============================

    public void introStory() {

        slowPrint(
                "====================================="
        );

        slowPrint(
                "     THE ZOMBIES AMONG HUMANS"
        );

        slowPrint(
                "=====================================\n"
        );

        slowPrint(
                "Kota menjadi kacau..."
        );

        slowPrint(
                "Orang-orang mulai berperilaku aneh...\n"
                        + "Mereka saling menyerang."
        );

        slowPrint(
                "Dan warga mulai panik..."
        );

        slowPrint(
                "Mereka terlihat seperti manusia..."
        );

        slowPrint(
                "Tetapi bukan manusia."
        );

        slowPrint(
                "Warga mulai mencurigai.... \n"
                        + "7 orang manusia."
        );

        slowPrint(
                "Di antara mereka "
                        + "sebenarnya bukan manusia..."
        );

        slowPrint(
                "Melainkan ada sesuatu...\n"
                        + "Yang mencurigakan."
        );

        slowPrint(
                "Diantara mereka...\n"
                        + "Tidak ada yang bisa dipercaya."

        );

        slowPrint(
                "Tugasmu hanya satu..."
        );

        slowPrint(
                "Temukan hal yang mencurigakan...\n"
                        + "Dan siapakah orang itu."
        );

        slowPrint(
                "Sebelum kota ini "
                        + "Menjadi semakin kacau.\n"
        );

        slowPrint(
                "Kesempatanmu hanya 4 kali untuk menebak siapa zombie itu..."

        );
    }

    // ============================
    // TAMPILKAN TERSANGKA
    // ============================

    public void showSuspects() {

        slowPrint(
                "\n===== DAFTAR TERSANGKA =====\n"
        );

        for (
                int i = 0;
                i < suspects.size();
                i++
        ) {

            System.out.println(
                    (i + 1)
                            + ". "
                            + suspects.get(i)
                            .getName()
            );

            try {

                Thread.sleep(500);

            } catch (
                    InterruptedException e
            ) {

                Thread.currentThread()
                        .interrupt();
            }
        }
    }

    // ============================
    // TAMPILKAN CLUE
    // ============================

    public void showClue(int index)
            throws WrongGuessException {

        if (
                index < 0
                        || index >= suspects.size()
        ) {

            throw new WrongGuessException(
                    "Pilihan tidak ada!"
            );
        }

        Person chosen =
                suspects.get(index);

        slowPrint(
                "\nKamu mulai mendekati "
                        + chosen.getName()
                        + "..."
        );

        slowPrint(
                "Mengamati gerak-geriknya..."
        );

        slowPrint(
                "dan melihat tingkah lakunya...\n"
        );

        slowPrint("PETUNJUK:");

        slowPrint(
                chosen.getClue()
        );
    }

    // ============================
    // KEPUTUSAN PLAYER
    // ============================

    public boolean makeDecision(
            int index,
            String answer
    ) throws WrongGuessException {

        Person chosen =
                suspects.get(index);

        // jika tidak yakin
        if (
                answer.equalsIgnoreCase(
                        "tidak"
                )
        ) {

            slowPrint(
                    "\nKamu masih ragu..."
                        + "dengan pilihan mu."
            );

            slowPrint(
                    "Masih terlalu berbahaya "
                            + "untuk mengambil keputusan.\n"
            );

            return false;
        }

        // jika yakin
        if (
                answer.equalsIgnoreCase(
                        "iya"
                )
        ) {

            // jika benar zombie
            if (chosen.isZombie()) {

                Zombie z =
                        (Zombie) chosen;

                slowPrint(
                        "\n☠ Dia tersenyum miring..."
                );

                slowPrint(
                        "Matanya menatap tajam..."
                );

                slowPrint(
                        "Mulutnya terbuka perlahan..."
                                + "dan mengeluarkan darah.\n"
                );

                slowPrint(
                        "Warga segera menembak ke arahnya.\n"
                );

                slowPrint(
                        "☠☠☠ ZOMBIE DITEMUKAN ☠☠☠\n"
                );

                slowPrint(
                        chosen.getName()
                                + " adalah ZOMBIE!"
                );

                slowPrint(
                        "Level infeksi: "
                                + z.getInfectionLevel()
                );

                // kurangi zombie
                zombiesLeft--;

                // hapus zombie dari list
                suspects.remove(index);

                // jika masih ada zombie
                if (zombiesLeft > 0) {

                    slowPrint(
                            "\n⚠ Ternyata masih ada zombie lain "
                                    + "di dalam kota!"
                    );

                    slowPrint(
                            "Temukan sebelum terlambat...\n"
                    );

                    return false;
                }

                // semua zombie ditemukan
                slowPrint(
                        "\nSEMUA ZOMBIE "
                                + "BERHASIL DIMUSNAHKAN!"
                );

                slowPrint(
                        "Kota berhasil diselamatkan!"
                );

                return true;

            } else {

                slowPrint(
                        "\nDia menangis ketakutan...\n"
                );

                slowPrint(
                        "Tubuhnya mulai bergemetar...\n"

                );

                slowPrint(
                        "Warga segera menembak ke arahnya.\n"
                );

                slowPrint(
                        chosen.getName()
                                + " ternyata dia manusia biasa!"
                );

                 slowPrint(
                        "Dia kehilangan nyawa."
                );

                chances--;

                score -= 25;

                // hapus manusia
                suspects.remove(index);

                throw new WrongGuessException(
                        "Kamu memilih orang yang salah!"
                );
            }
        }

        slowPrint(
                "\nJawaban tidak dikenali."
        );

        return false;
    }

    // ============================
    // GETTER
    // ============================

    public int getChances() {

        return chances;
    }

    public int getScore() {

        return score;
    }

    public int getZombiesLeft() {

        return zombiesLeft;
    }
}