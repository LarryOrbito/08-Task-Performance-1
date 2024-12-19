import java.util.Scanner;

interface GameMode {
    void selectMode();
    void startGame();
}

interface Gameplay {
    void displayIntro();
    void playGame();
    void displayOutro();
}

interface Character {
    void createCharacter(String name);
    void showCharacterInfo();
}

class Game implements GameMode, Gameplay, Character {
    private String playerName;
    private String gameMode;

    @Override
    public void createCharacter(String name) {
        this.playerName = name;
        System.out.println("Character " + name + " has been created!");
    }

    @Override
    public void showCharacterInfo() {
        System.out.println("Player Name: " + playerName);
    }

    @Override
    public void displayIntro() {
        System.out.println("****************************");
        System.out.println("* Welcome to the Adventure *");
        System.out.println("****************************");
        System.out.println("  ___   _   _  ____  ____ ");
        System.out.println(" | _ \\ | | | |/ __||  _ \\ ");
        System.out.println(" |  _/ | |_| | |__ |   /  ");
        System.out.println(" |_|   |_\\___||___||__\\   ");
        System.out.println("****************************");
        System.out.println("Get ready for your adventure!");
    }

    @Override
    public void displayOutro() {
        System.out.println("****************************");
        System.out.println("    Game Over. Thank you!    ");
        System.out.println("****************************");
        System.out.println("  ___   _  ____    ____   ");
        System.out.println(" | _ \\ | |/ __|  |  _ \\ ");
        System.out.println(" |  _/ | | |__   |   /  ");
        System.out.println(" |_|   |_\\___|  |__\\_\\  ");
        System.out.println("****************************");
    }

    @Override
    public void selectMode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        createCharacter(name);

        System.out.println("Press 1 for Story mode or 2 for Survival mode:");
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            gameMode = "Story";
        } else if (choice.equals("2")) {
            gameMode = "Survival";
        } else {
            System.out.println("Invalid selection, exiting...");
            scanner.close();
            System.exit(0);
        }

        startGame();
        scanner.close();
    }

    @Override
    public void startGame() {
        System.out.println("Starting " + gameMode + " mode...");
        displayIntro();
        playGame();
        displayOutro();
    }

    @Override
    public void playGame() {
        System.out.println("Playing in " + gameMode + " mode...");
        System.out.println("Adventure in progress...");
    }
}

public class GameApp {
    public static void main(String[] args) {
        Game game = new Game();
        game.selectMode();
    }
}
