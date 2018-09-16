import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OXTest {

    private String Player;

    @Test
    void getTableString(){
        OX ox = new OX();
        assertEquals("  0 1 2\n" +
                "0 - - -\n" +
                "1 - - -\n" +
                "2 - - -\n",ox.getTableString());
    }
    @Test
    void getCurrentPlayer(){
        OX ox = new OX();
        assertEquals(" X", ox.getCurrentPlayer() );
    }
    @Test
    public void Over() {
        OX ox = new OX();

        assertFalse(ox.put(0,-1));
        assertFalse(ox.put(0,3));
        assertFalse(ox.put(3,-1));
        assertFalse(ox.put(-1,3));
    }
    @Test
    public void getOver() {
        OX ox = new OX();
        assertNull(ox.get(0,-1));
        assertNull(ox.get(0,3));
        assertNull(ox.get(3,-1));
        assertNull(ox.get(-1,3));
    }
    @Test
    public void switchPlayer(){
        OX ox = new OX();
        ox.switchPlayer();
        assertEquals(" O",ox.getCurrentPlayer());

        ox.switchPlayer();
        assertEquals(" X",ox.getCurrentPlayer());

    }
    @Test
    void putAt0_0() {
        OX ox = new OX();
        ox.put(0,0);
        assertEquals("  0 1 2\n" +
                "0 X - -\n" +
                "1 - - -\n" +
                "2 - - -\n",ox.getTableString());
    }
    @Test
    void putAt0_0Twice() {
        OX ox = new OX();
        assertTrue(ox.put(0,0));
        assertFalse(ox.put(0,0));
    }
    @Test
    void putOverTable() {
        OX ox = new OX();
        assertFalse(ox.put(0,-1));
        assertFalse(ox.put(0,3));
        assertFalse(ox.put(3,-1));
        assertFalse(ox.put(-1,3));
    }
    @Test
    void getAt0_0() {
        OX ox = new OX();
        ox.put(0,0);
        assertEquals("  0 1 2\n" +
                "0 X - -\n" +
                "1 - - -\n" +
                "2 - - -\n",ox.getTableString());
        assertEquals(" X", ox.get(0,0));
    }

    @Test
    void putAtTwice() {
        OX ox = new OX();
        assertTrue(ox.put(0,0));
        assertFalse(ox.put(0,0));
    }


    @Test
    public void getAt() {
        OX ox = new OX();
        ox.put(0,0);
        assertEquals("  0 1 2\n0 X - -\n1 - - -\n2 - - -\n",ox.getTableString());
        assertEquals(" X",ox.get(0,0));
    }


    @Test
    public void checkWinCol0(){
        OX ox = new OX();

        ox.put(0,0);
        ox.put(0,1);
        ox.put(0,2);

        assertTrue(ox.checkWin(0, 0));
        assertTrue(ox.checkWin(0, 1));
        assertTrue(ox.checkWin(0, 2));



    }
    @Test
    public void checkWinCol1(){
        OX ox = new OX();

        ox.put(1,0);
        ox.put(1,1);
        ox.put(1,2);

        assertTrue(ox.checkWin(1, 0));
        assertTrue(ox.checkWin(1,1));
        assertTrue(ox.checkWin(1, 2));

    }
    @Test
    public void checkWinCol2(){
        OX ox = new OX();

        ox.put(2,0);
        ox.put(2,1);
        ox.put(2,2);

        assertEquals(true,ox.checkWin(2,0));
        assertEquals(true,ox.checkWin(2,1));
        assertEquals(true,ox.checkWin(2,2));

    }
    @Test
    public void checkWinRow(){
        OX ox = new OX();

        ox.put(0,0);
        ox.put(1,0);
        ox.put(2,0);

        assertEquals(true,ox.checkWin(0,0));
        assertEquals(true,ox.checkWin(1,0));
        assertEquals(true,ox.checkWin(2,0));

    }
    @Test
    public void checkWinRow1(){
        OX ox = new OX();

        ox.put(0,1);
        ox.put(1,1);
        ox.put(2,1);

        assertEquals(true,ox.checkWin(0,1));
        assertEquals(true,ox.checkWin(1,1));
        assertEquals(true,ox.checkWin(2,1));


    }
    @Test
    public void checkWinRow2(){
        OX ox = new OX();

        ox.put(0,2);
        ox.put(1,2);
        ox.put(2,2);

        assertEquals(true,ox.checkWin(0,2));
        assertEquals(true,ox.checkWin(1,2));
        assertEquals(true,ox.checkWin(2,2));


    }
    @Test
    public void checkWinES(){
        OX ox = new OX();

        ox.put(0,0);
        ox.put(1,1);
        ox.put(2,2);

        assertEquals(true,ox.checkWin(0,0));
        assertEquals(true,ox.checkWin(1,1));
        assertEquals(true,ox.checkWin(2,2));

    }
    @Test
    public void checkWinSS(){
        OX ox = new OX();

        ox.put(2,0);
        ox.put(1,1);
        ox.put(0,2);

        assertEquals(true,ox.checkWin(2,0));
        assertEquals(true,ox.checkWin(1,1));
        assertEquals(true,ox.checkWin(0,2));

    }
    @Test
    public void reset() {
        OX ox = new OX();
        ox.put(2,0);
        ox.put(1,1);
        ox.put(0,2);
        ox.reset();
        assertEquals("  0 1 2\n0 - - -\n1 - - -\n2 - - -\n",ox.getTableString());
        assertEquals(" X", ox.getCurrentPlayer());
        assertEquals(0, ox.getTurn());
    }

    @Test
    void getTurn() {
        OX ox = new OX();
        assertEquals(0, ox.getTurn());
        ox.put(0,0);
        assertEquals(1, ox.getTurn());
    }

    @Test
    public void Draw() {
        OX ox = new OX();
        ox.put(0,0);
        ox.put(0,1);
        ox.put(0,2);
        assertFalse(ox.Draw());

        ox.put(1,0);
        ox.put(1,1);
        ox.put(1,2);
        assertFalse(ox.Draw());

        ox.put(2,0);
        ox.put(2,1);
        ox.put(2,2);
        assertTrue(ox.Draw());
    }
    @Test
    void getScoreX() {
        OX ox = new OX();
        assertEquals(0, ox.getCountX());
        ox.put(0,0);
        ox.put(0,1);
        ox.put(0,2);
        assertEquals(1, ox.getCountX());
    }

    @Test
    void getScoreO() {
        OX ox = new OX();
        ox.switchPlayer();
        assertEquals(0, ox.getCountO());
        ox.put(0,0);
        ox.put(1,1);
        ox.put(2,2);
        assertEquals(1, ox.getCountO());
    }

    @Test
    void getScoreDraw() {
        OX ox = new OX();
        assertEquals(0, ox.getCountDraw());
        ox.put(0,0);
        ox.put(0,1);
        ox.put(0,2);
        assertFalse(ox.Draw());
        ox.put(1,0);
        ox.put(1,1);
        ox.put(1,2);
        assertFalse(ox.Draw());
        ox.put(2,0);
        ox.put(2,1);
        ox.put(2,2);
        assertTrue(ox.Draw());
        assertEquals(1, ox.getCountDraw());
    }


}