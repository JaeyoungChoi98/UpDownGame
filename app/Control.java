package app;

import java.util.Scanner;

public class Control {
    private int guessNumber;  //맞춰야 할 숫자 필드에 선언

    private int inputNumber; //사용자가 입력한 숫자 필드에 선언

    Database database; // database 클래스 선언

    public Control(Database database) {
        this.database = database;
    }

    public void playgame() {


        database.generateGuessNumber();        //database에서 랜던한 숫자 생성
        guessNumber = database.getRandom();    //생선된 랜덤 숫자 guessNumber에 저장

        Scanner scanner = new Scanner(System.in);

        compareNumber(scanner); // scanner 객체를 비교 메소드에 보냄

        // 지금까지 입력한 숫자를 정답과의 오차와 함께 순서대로 출력
        System.out.println(database.getTrysave());
        System.out.println(database.getDiff());
    }

    private void compareNumber(Scanner scanner) {
        input10To99(scanner);                   // 숫자 입력 하는 메소드로 보냄

        int diff = guessNumber - inputNumber;               //diff 에 정답과 입력값을 뺌
        database.addToinputList(inputNumber);               //database에 보내서 입력값 배열에 추가
        database.addToDiffList(Math.abs(inputNumber-guessNumber)); //database에 보내서 오차 추가

        if (diff == 0) {                                //정답 조건문
            System.out.println("맞췄습니다.");
            return;
        }

        if (diff > 0) {                             //사용자에게 힌트 제공 조건문
            System.out.println("입력한 값이 정답보다 큽니다");
        } else {
            System.out.println("입력한 값이 정답보다 작습니다");
        }
        compareNumber(scanner);                     //재귀하여 다시 처음부터 진행
    }

    private void input10To99(Scanner scanner) {
        System.out.println("10~99사이의 숫자를 입력해주세요");

        try {
            inputNumber = Integer.parseInt(scanner.nextLine());    //사용자 입력값 저장
        } catch (Exception E) {
            System.out.println("숫자를 입력하세요 : ");
            System.out.println("-".repeat(60));
            input10To99(scanner);                               // 런타임 에러시 재귀
        }
    }


}
