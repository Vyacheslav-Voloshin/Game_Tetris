import java.awt.event.KeyEvent;

public class Tetris {

    private Field field;     // Поле з клітинками

    private Figure figure;   // Фігурка

    private boolean isGameOver; //Гру закінчено?

    public Tetris(int width, int height) {
        field = new Field(width, height);
        figure = null;
    }

    public static Tetris game;

    public Field getField() {
        return field;
    }

    public Figure getFigure() {
        return figure;
    }

    /**
     * Основний цикл програми
     * Тут відбуваються всі важливі дії
     */
    public void run() throws Exception {
        //Створюємо обєкт "спостерігач за клавіатурой" и стартуєм з нього
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        //виставляємо початкове значення змінної "гра закінчена" в брехня
        isGameOver = false;
        //створюємо першу фігурку посередині зверху: x – половина ширини, y – 0.
        figure = FigureFactory.createRandomFigure(field.getWidth() / 2, 0);

        //поки гра не закінчена
        while (!isGameOver) {
            //"Спостерігач" містить події про натискання клавіш?
            if (keyboardObserver.hasKeyEvents()) {
                //отримати першу подію з черги
                KeyEvent event = keyboardObserver.getEventFromTop();
                //Якщо дорівнює символу 'q' - вийти із гри.
                if (event.getKeyChar() == 'q') return;
                //Якщо "стрілка вліво" - зрушити фігурку вліво
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    figure.left();
                    //Якщо "стрілка вправо" - зрушити фігурку вправо
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    figure.right();
                    //Якщо код клавіші дорівнює 12 ("цифра 5 на дод. Клавіатурі") - повернути фігурку
                else if (event.getKeyCode() == 12)
                    figure.rotate();
                    //Якщо "пробіл" - фігурка падає вниз на максимум
                else if (event.getKeyCode() == KeyEvent.VK_SPACE)
                    figure.downMaximum();
            }

            step();             //робимо черговий крок
            field.print();      //друкуємо стан "поля"
            Thread.sleep(300);  //пауза 300 мілісекунд – 1/3 секунди
        }

        //Виводимо повідомлення "Game Over"
        System.out.println("Game Over");
    }

    /**
     * Один крок гри
     */
    public void step() {
        //опускаємо фігурку вниз
        figure.down();

        //якщо розмістити фігурку на поточному місці неможливо
        if (!figure.isCurrentPositionAvailable()) {
            figure.up(); // Піднімаємо назад
            figure.landed(); //Приземляємо
            field.removeFullLines(); //видаляємо заповнені лінії
            figure = FigureFactory.createRandomFigure(field.getWidth() / 2, 0); //Створюємо нову фігурку
        }      //опускати фігурку вниз
    }

    /**
     * Сеттер для figure
     */
    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    /**
     * Сеттер для field
     */
    public void setField(Field field) {
        this.field = field;
    }


    public static void main(String[] args) throws Exception {
         game = new Tetris(10,20);
         game.run();
    }
}
