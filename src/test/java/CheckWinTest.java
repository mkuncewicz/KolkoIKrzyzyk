import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CheckWinTest {


    @Test
    void flatWinTest(){
        //given
        Game game = new Game();
        char[][] tab1 = new char[3][3];
        char[][] tab2 = new char[3][3];
        char[][] tab3 = new char[3][3];

        tab1[0][0] = '1';
        tab1[0][1] = '1';
        tab1[0][2] = '1';

        tab2[1][0] = '2';
        tab2[1][1] = '2';
        tab2[1][2] = '2';

        tab3[2][0] = '3';
        tab3[2][1] = '3';
        tab3[2][2] = '3';

        //when
        game.setTab(tab1);
        boolean check1 = game.poziomCheckWin('1');
        game.setTab(tab2);
        boolean check2 = game.poziomCheckWin('2');
        game.setTab(tab3);
        boolean check3 = game.poziomCheckWin('3');
        //then
        Assertions.assertTrue(check1);
        Assertions.assertTrue(check2);
        Assertions.assertTrue(check3);
    }

    @Test
    void topWinTest(){
        //given
        Game game = new Game();
        char[][] tab1 = new char[3][3];
        char[][] tab2 = new char[3][3];
        char[][] tab3 = new char[3][3];

        tab1[0][0] = '1';
        tab1[1][0] = '1';
        tab1[2][0] = '1';

        tab2[0][1] = '2';
        tab2[1][1] = '2';
        tab2[2][1] = '2';

        tab3[0][2] = '3';
        tab3[1][2] = '3';
        tab3[2][2] = '3';

        //when
        game.setTab(tab1);
        boolean check1 = game.pionCheckWin('1');
        game.setTab(tab2);
        boolean check2 = game.pionCheckWin('2');
        game.setTab(tab3);
        boolean check3 = game.pionCheckWin('3');
        //then
        Assertions.assertTrue(check1);
        Assertions.assertTrue(check2);
        Assertions.assertTrue(check3);
    }

    @Test
    void crossWinTest(){
        //given
        Game game = new Game();

        char[][] tab1 = new char[3][3];
        char[][] tab2 = new char[3][3];

        tab1[0][0] = '1';
        tab1[1][1] = '1';
        tab1[2][2] = '1';

        tab2[0][2]= '2';
        tab2[1][1]= '2';
        tab2[2][0]= '2';

        //when
        game.setTab(tab1);
        boolean check1 = game.topDownCheckWin('1');
        game.setTab(tab2);
        boolean check2 = game.downTopCheckWin('2');

        //then
        Assertions.assertTrue(check1);
        Assertions.assertTrue(check2);
    }

}
