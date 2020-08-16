import java.util.HashMap;
import java.util.Map;

public class Day6_getHint {
    // 299. 猜数字游戏
    // https://leetcode-cn.com/problems/bulls-and-cows/
    public String getHint(String secret, String guess) {
        Map<Character, Integer> mapa = new HashMap<>();
        int a = 0;
        int b = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a++;
            }else if(mapa.containsKey(secret.charAt(i))){
                mapa.put(secret.charAt(i), mapa.get(secret.charAt(i))+1);
            } else {
                mapa.put(secret.charAt(i), 1);
            }
        }
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                continue;
            }
            if (mapa.containsKey(guess.charAt(i)) && mapa.get(guess.charAt(i)) >0) {
                b++;
                mapa.put(guess.charAt(i),mapa.get(guess.charAt(i))-1);
            }
        }
        return a + "A" + b + "B";
    }

    public String getHint2(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i<secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if (s == g) bulls++;
            else {
                //当前数小于 0, 说明之前在 guess 中出现过, 和 secret 当前的数匹配
                if (numbers[s] < 0) cows++;
                //当前数大于 0, 说明之前在 secret 中出现过, 和 guess 当前的数匹配
                if (numbers[g] > 0) cows++;
                //secret 中的数, 计数加 1
                numbers[s] ++;
                //guess 中的数, 计数减 1
                numbers[g] --;
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String args[]) {
        System.out.println(new Day6_getHint().getHint("1122", "2211"));

    }
}
