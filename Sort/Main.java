import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        int[][] teams = {
                {45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
                {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},
                {51, 30, 10, 9, 8, 7, 6, 5, 2, 1}
        };

        int[] nationalTeam = mergeAll(teams);
        System.out.println(Arrays.toString(nationalTeam)); // [51, 45, 31, 31, 30, 24, 22, 20, 18, 17]
    }

    /**
     * Метод для слияния всех команд в одну национальную
     */
    public static int[] mergeAll(int[][] teams) {
        int n = teams.length - 1;
        int[][] team = new int[n][10];
        if (n == 0) {
            return teams[0];
        }
        team[0] = merge(teams[0], teams[1]);
        for (int i = 1; i < n; i++) {
            team[i] = teams[i + 1];
        }
        return mergeAll(team);

    }

    /**
     * Метод для слияния двух команд в одну
     */
    public static int[] merge(int[] teamA, int[] teamB) {
        int[] teamAB = new int[10];
        int i = 0, j = 0, k = 0;
        while (i < teamA.length) {
            while (j < teamB.length) {
                if (k == 10) {
                    return teamAB;
                }
                if (teamA[i] >= teamB[j]) {
                    teamAB[k] = teamA[i];
                    i++;
                } else {
                    teamAB[k] = teamB[j];
                    j++;
                }
                k++;
            }
        }
        return teamAB;

    }
}
