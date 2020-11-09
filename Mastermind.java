import java.util.HashSet;
import java.util.Random;

public class Mastermind {
    public String answer;
    HashSet<String> ansColors;
    private int attempts;
    private int numresult;

    // function for creating answer
    // function for checking a guess
    // functions for loss/win
    
    private String[] COLORS = {"P", "R", "Y", "G", "B", "O", "T"};
    private int MIN_result = 4;
    private int MAX_result = 7;

    Mastermind () {
        this.numresult = 5;
        this.attempts = 10;
        ansColors = new HashSet<String>();
        this.answer = createAnswer();
    }

    Mastermind (int result) {
        if (MIN_result <= result && result <= MAX_result){
            this.numresult = result;
        } else {
            throw new Error("numresult out of bounds");
        }
        this.attempts = 10 + (numresult - 5);
        ansColors = new HashSet<String>();
        this.answer = createAnswer();
    }

    private String createAnswer(){
        Random generator = new Random();
        String ans = "";

        int idx;
        HashSet<Integer> used = new HashSet<Integer>();

        for (int i = 0; i < numresult; i++){
            idx = generator.nextInt(COLORS.length);
            while (!used.add(idx)){
                idx = generator.nextInt(COLORS.length);
            }
            ans += COLORS[idx];
            ansColors.add(COLORS[idx]);
        }

        return ans;
    }

    // check guess

    public String checkAnswer(String s){
        // check attempts

        String[] check = s.split("");
        String[] ans = this.answer.split("");

        if (check.length != ans.length) throw new Error("Answer is wrong length");

        int black = 0;
        int white = 0;
        int slash = 0;

        for (int i = 0; i < check.length; i++){
            if (check[i].equals(ans[i])){
                black++;
            } else if (ansColors.contains(check[i])){
                white++;
            } else {
                slash++;
            }
        }

        String result = "";
        for (int i = 0; i < black; i++){
            result += "B";
        }
        for (int i = 0; i < white; i++){
            result += "W";
        }
        for (int i = 0; i < slash; i++){
            result += "/";
        }

        return result;

        // win or lose here?
    }

    
}
