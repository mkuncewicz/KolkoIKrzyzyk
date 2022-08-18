import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CheckWinTest {


    @Test
    void flatWinTest(){
        //given
        Game game = new Game();
        char[][] tab1 = new char[3][3];
        tab1[0][0] = 'O';
        tab1[0][1] = 'O';
        tab1[0][2] = 'O';
        //when
        game.setTab(tab1);

        //then

    }

}
