/*
Цей клас описуватиме фігурку, що падає
Нам знадобляться її координати та форма.
За координати відповідатимуть дві змінні x та y.
За форму – матриця. Двовимірний масив 3?3, що складається з одиниць та нулів.
Одиницею ми позначаємо, що клітина є, нулем - що вона порожня
 */
public class Figure {

    private int x;

    private int y;

    private int [][] matrix;

    public Figure(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    //рух фігури вліво
    public void left(){}

    //рух фігури вправо
    public void right(){}

    //рух фігури вниз
    public void down(){}

    //рух фігури вгору
    public void up(){}

    // поворот фігурки довкола головної діагоналі
    public void rotate(){}

    //падіння фігурки вниз до дна
    public void downMaximum(){}

    /*
    перевірка - чи фігурка може бути поміщена в поточну позицію.
    Для тесту захардкодь результат у true, поки ми не реалізували логіку
     */
    public boolean isCurrentPositionAvailable(){
        return true;
    }

    //викликається, коли фігурка досягла дна або вперлася в іншу фігурку
    //Всі її зайняті клітини тепер мають додатись до Field.
    public void landed(){}

}

