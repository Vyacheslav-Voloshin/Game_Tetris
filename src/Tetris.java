public class Tetris {

    private Field field;

    private Figure figure;

    public static Tetris game;

    public Field getField() {
        return field;
    }

    public Figure getFigure() {
        return figure;
    }

    // метод який відповідає за всю гру
    public void run(){}

    //метод який за один крок у грі
    public void step(){}

    public static void main(String[] args) {
         game = new Tetris();
         game.run();
    }
}
