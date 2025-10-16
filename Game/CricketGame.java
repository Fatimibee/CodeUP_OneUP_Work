import java.util.*;

class Team {
    String name;
    int runs;
    int wickets;
    int oversPlayed;

    Team(String name) {
        this.name = name;
        this.runs = 0;
        this.wickets = 0;
        this.oversPlayed = 0;
    }
}

public class CricketGame {
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    static void playOver(Team team) {
        System.out.println("\n--- Over " + (team.oversPlayed + 1) + " ---");
        for (int ball = 1; ball <= 6; ball++) {
            if (team.wickets >= 10) {
                System.out.println("All wickets down!");
                return;
            }
            int outcome = rand.nextInt(8);
            switch (outcome) {
                case 0:
                    System.out.println("Ball " + ball + ": Dot ball.");
                    break;
                case 1: case 2: case 3:
                    team.runs += outcome;
                    System.out.println("Ball " + ball + ": " + outcome + " run(s).");
                    break;
                case 4:
                    team.runs += 4;
                    System.out.println("Ball " + ball + ": It's a FOUR!");
                    break;
                case 5:
                    team.runs += 1;
                    System.out.println("Ball " + ball + ": No ball! Free run awarded!");
                    break;
                case 6:
                    team.runs += 6;
                    System.out.println("Ball " + ball + ": SIX!!!");
                    break;
                case 7:
                    team.wickets++;
                    System.out.println("Ball " + ball + ": OUT!");
                    break;
            }
        }
        team.oversPlayed++;
    }

    static void playInnings(Team team, int totalOvers) {
        System.out.println("\n=== " + team.name + " is batting ===");
        while (team.oversPlayed < totalOvers && team.wickets < 10) {
            System.out.println("\nPress Enter to bowl next over...");
            sc.nextLine();
            playOver(team);
            System.out.println(team.name + ": " + team.runs + "/" + team.wickets);
        }
        System.out.println("\n" + team.name + " finished with " + team.runs + " runs and " + team.wickets + " wickets.");
    }

    static void declareResult(Team t1, Team t2) {
        System.out.println("\n=== Match Result ===");
        System.out.println(t1.name + ": " + t1.runs + "/" + t1.wickets);
        System.out.println(t2.name + ": " + t2.runs + "/" + t2.wickets);

        if (t1.runs > t2.runs) {
            System.out.println(t1.name + " wins by " + (t1.runs - t2.runs) + " runs!");
        } else if (t2.runs > t1.runs) {
            System.out.println(t2.name + " wins by " + (10 - t2.wickets) + " wickets!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    public static void startCricketGame() {
        System.out.println("🏏 Welcome to the Console Cricket Game!");
        System.out.print("Enter Team 1 name: ");
        String t1Name = sc.nextLine();
        System.out.print("Enter Team 2 name: ");
        String t2Name = sc.nextLine();

        Team team1 = new Team(t1Name);
        Team team2 = new Team(t2Name);

        System.out.print("Enter number of overs for the match: ");
        int overs = sc.nextInt();
        sc.nextLine();

        System.out.println("\nToss time! Type 'heads' or 'tails': ");
        String call = sc.nextLine().toLowerCase();
        String tossResult = rand.nextBoolean() ? "heads" : "tails";
        System.out.println("Coin shows: " + tossResult);

        boolean team1BatsFirst = call.equals(tossResult);
        System.out.println((team1BatsFirst ? team1.name : team2.name) + " won the toss and will bat first!");

        if (team1BatsFirst) {
            playInnings(team1, overs);
            System.out.println("\nTarget for " + team2.name + ": " + (team1.runs + 1) + " runs.");
            playInnings(team2, overs);
        } else {
            playInnings(team2, overs);
            System.out.println("\nTarget for " + team1.name + ": " + (team2.runs + 1) + " runs.");
            playInnings(team1, overs);
        }

        declareResult(team1, team2);
        System.out.println("\n🏆 Thank you for playing Cricket!");
    }
}
