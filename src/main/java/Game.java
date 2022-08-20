import java.util.Random;
import java.util.Scanner;

public class Game {

    private char[][] tab = new char[3][3];
    private int numberOfTurn = 0;
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    public char[][] getTab() {
        return tab;
    }


    public void setTab(char[][] tab) {
        this.tab = tab;
    }

    public void startGame(){
        boolean end = false;
        char znak;

        while (!end){
            Message.menu();
            znak = scanner.next().charAt(0);
            switch (znak){
                case '1': playVsComputer();
                    break;
                case '2': playVsPlayer();
                    break;
                case 'x':
                case 'X':    end = true;
                    break;
                default:
            }
        }
    }

    private void playVsComputer(){

        while (true){
            showTab();

            turnUser('O');
            if(checkWin('O')){
                showTab();
                System.out.println("Wygrales ! :D");
                tab = new char[3][3];
                break;
            }

            if(checkDraw()){
                showTab();
                System.out.println("Remis!");
                tab = new char[3][3];
                break;
            }
            turnComputer('X');
            if(checkWin('X')){
                showTab();
                System.out.println("LOSE :/");
                tab = new char[3][3];
                break;
            }
            if(checkDraw()){
                showTab();
                System.out.println("Remis! :o");
                tab = new char[3][3];
                break;
            }
            System.out.println();
            System.out.println();
        }
    }
    private void playVsPlayer(){
        while (true){
            showTab();
            turnUser('O');
            if(checkWin('O')){
                showTab();
                System.out.println("Wygralo O! :D");
                tab = new char[3][3];
                break;
            }
            if(checkDraw()){
                showTab();
                System.out.println("Remis! :o");
                tab = new char[3][3];
                break;
            }
            showTab();
            turnUser('X');
            if(checkWin('X')){
                showTab();
                System.out.println("Wygral X! :D");
                tab = new char[3][3];
                break;
            }
            if(checkDraw()){
                showTab();
                System.out.println("Remis! :o");
                tab = new char[3][3];
                break;
            }
            System.out.println();
            System.out.println();
        }
    }
    private void showTab(){
        for (int i = 0; i < 3; i++){
            for (int y = 0; y < 3; y++){
                System.out.print(tab[i][y] + " \t");
            }
            System.out.println();
        }
    }

    private int pickNumber(){
        boolean end = false;
        int x = 0;
        while (!end){
            try {

                String line = scanner.nextLine();
                x = Integer.parseInt(line);
                end = true;
            }catch (Exception e){

            }
        }
        return x;
    }

    private void turnUser(char sign){
            int x = pickNumber();
            int y = pickNumber();
        char result = tab[x][y];
        if(result != 'O' && result != 'X') {
            numberOfTurn++;
            tab[x][y] = sign;
        }else {
            System.out.println("Wybierz inne pole");
            turnUser(sign);
        }
    }

    private void turnComputer(char sign){
        int x = random.nextInt(3);
        int y = random.nextInt(3);
        char result = tab[x][y];
        if(result != 'O' && result != 'X') {
            numberOfTurn++;
            tab[x][y] = sign;
        }else {
            turnComputer(sign);
        }
    }

    private boolean checkDraw(){
        if (numberOfTurn == 9){
            numberOfTurn = 0;
            return true;
        }else {
            return false;
        }
    }
    private boolean checkWin(char sign){
        if(poziomCheckWin(sign) || pionCheckWin(sign) || topDownCheckWin(sign) || downTopCheckWin(sign)){
            numberOfTurn = 0;
            return true;
        }else {
            return false;
        }
    }


    public boolean poziomCheckWin(char sign){
        int check = 0;
        for(int i = 0; i < 3; i++){
            for (int y = 0; y < 3; y++){
                char znak = tab[i][y];
                if (znak == sign){
                    check++;
                }
            }
                if(check == 3){
                    return true;
                }
                check = 0;
        }
        return false;
    }
    public boolean pionCheckWin(char sign){
        int check = 0;
        for(int i = 0; i < 3; i++){
            for (int y = 0; y < 3; y++){
                char znak = tab[y][i];
                if (znak == sign){
                    check++;
                }
            }
                if(check == 3){
                    return true;
                }
                check = 0;
        }
        return false;
    }

    public boolean topDownCheckWin(char sign) {
        for (int i = 0; i < 3; i++) {
            char znak = tab[i][i];
            if (znak != sign) {
                return false;
            }
        }
        return true;
    }

    public boolean downTopCheckWin(char sign){
        int x = 2;
        int y = 0;
        for (int i = 0; i <= 2; i++){
            char znak = tab[x][y];
            if (sign != znak){
                return false;
            }
            x--;
            y++;
        }
            return true;
    }
    }

