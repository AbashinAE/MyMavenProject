import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AppParadox {
    private static final List<Boolean> changeChoice;

    private static final List<Boolean> notChangeChoice;

    private static final Random random;


    static {
        changeChoice = new ArrayList<>();
        notChangeChoice = new ArrayList<>();
        random = new Random();
    }

    private static void paradoxGame() {
        boolean[] game = new boolean[3];
        int prizeDoor = random.nextInt(3);
        game[prizeDoor] = true;
        int choice = random.nextInt(game.length);
        boolean changed = random.nextInt(2) == 1;
        if (changed) {
            int nextChoice;
            do {
                nextChoice = random.nextInt(game.length);
            }
            while (nextChoice == choice);
            changeChoice.add(game[nextChoice]);
        }
        else {
            notChangeChoice.add(game[choice]);
        }
    }

    public static void paradoxApp() {
        for (int i = 0; i < 1000; i++) {
            paradoxGame();
        }
        finalScore();
    }

    private static void finalScore() {
        System.out.println("Игрок изменил выбор: " + changeChoice.stream().filter(choice -> choice).count());
        System.out.println("Игрок не менял выбор: " + notChangeChoice.stream().filter(choice -> choice).count());
    }
}
