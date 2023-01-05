package app;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;

public class Database {
    private int random;      //랜덤숫자 저장객체
    private ArrayList<Integer> diff = new ArrayList<>();    //오차 저장 객체
    private ArrayList<Integer> trysave = new ArrayList<>();    //시도를 저장할 객체

    public int getRandom() {
        return random;
    }

    public void setRandom(int random) {
        this.random = random;
    }

    public ArrayList<Integer> getDiff() {
        return diff;
    }

    public ArrayList<Integer> getTrysave() {
        return trysave;
    }

    // 랜덤한 숫자를 생성하여 랜덤 인스턴스 변수에 저장
    public void generateGuessNumber() {
        setRandom((int) (Math.random()*90+10));
        System.out.println("[System] 랜덤 숫자 생성을 완료했습니다");
        System.out.println("-".repeat(60));
    }

    public void addToinputList(int number) { trysave.add(number);}

    public void addToDiffList(int number) { diff.add(number);}
}
