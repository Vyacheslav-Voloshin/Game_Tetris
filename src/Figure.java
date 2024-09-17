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

    /**
     * Рухаємо фігурку вліво.
     * Перевіряємо, чи не вилізла вона за кордон поля і/або не залізла на зайняті клітини.
     */
    public void left(){
        x--;
        if(!isCurrentPositionAvailable()){
            x++;
        }
    }

    /**
     * Рухаємо фігурку вправо.
     * Перевіряємо, чи не вилізла вона за кордон поля і/або не залізла на зайняті клітини.
     */
    public void right(){
        x++;
        if(!isCurrentPositionAvailable()){
            x--;
        }
    }

    /**
     * Рухаємо фігурку вниз.
     * Використовується, якщо фігурка залізла на зайняті клітини.
     */
    public void down(){
        y++;
    }

    /**
     * Рухаємо фігурку вгору.
     * Використовується, якщо фігурка залізла на зайняті клітини.
     */
    public void up(){
        y--;
    }

    // поворот фігурки довкола головної діагоналі
    public void rotate(){}

    /**
     * Рухаємо фігурку вниз доти, поки не заліземо на когось.
     */
    public void downMaximum(){
        while (isCurrentPositionAvailable()){
            y++;
        }
        y--;
    }

    /**
     * Перевіряємо - чи може фігурка знаходиться на поточній позиції:
     * а) чи не виходить вона за межі поля
     * б) чи не заходить вона на зайняті клітини
     */
    public boolean isCurrentPositionAvailable(){
        Field field = Tetris.game.getField();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == 1) {
                    if (y + i >= field.getHeight())
                        return false;

                    Integer value = field.getValue(x + j, y + i);
                    if (value == null || value == 1)
                        return false;
                }
            }
        }

        return true;
    }

    /**
     * Приземляємо фігурку - додаємо всі її непорожні клітини до клітин поля.
     */
    public void landed(){
        Field field = Tetris.game.getField();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == 1)
                    field.setValue(x + j, y + i, 1);
            }
        }
    }

}

