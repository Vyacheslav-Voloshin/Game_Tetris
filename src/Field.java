import java.util.ArrayList;
import java.util.List;

/*
Клас відповідає за зберігання даних про поточні зайняті та вільні клітини на полі гри.
 */
public class Field {

    private int width; //ширина x

    private int height;  //висота y

    private int[][] matrix;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new int[height][width];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    //об'єкт малюватиме на екран свій поточний стан
    public void print(){
        //Створюємо масив, куди "малюватимемо" поточний стан гри
        int[][] canvas = new int[height][width];

        //Копіюємо "матрицю поля" в масив
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                canvas[i][j] = matrix[i][j];
            }
        }

        //Копіюємо фігурку в масив, тільки непорожні клітини
        int left = Tetris.game.getFigure().getX();
        int top = Tetris.game.getFigure().getY();
        int[][] brickMatrix = Tetris.game.getFigure().getMatrix();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (top + i >= height || left + j >= width) continue;
                if (brickMatrix[i][j] == 1)
                    canvas[top + i][left + j] = 2;
            }
        }


        //Выводим "нарисованное" на экран, но начинаем с "границы кадра".
        System.out.println("---------------------------------------------------------------------------\n");

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int index = canvas[i][j];
                if (index == 0)
                    System.out.print(" . ");
                else if (index == 1)
                    System.out.print(" X ");
                else if (index == 2)
                    System.out.print(" X ");
                else
                    System.out.print("???");
            }
            System.out.println();
        }


        System.out.println();
        System.out.println();

    }

    //буде видаляти з матриці повністю заповнені рядки і зрушувати рядки, які знаходяться вище рядка вниз
    public void removeFullLines(){

       //Створюємо список зберігання ліній
        List<int[]> list = new ArrayList<>();


        //Копіюємо всі неповні лінії до списку.
        for (int y = 0; y < height; y++) {
            int count = 0;
            for (int x = 0; x < width; x++) {
                count+= matrix[y][x];
            }
            if (count!=width){
                list.add(matrix[y]);
            }
        }

        //Додаємо рядки, що бракують, на початок списку.
        while (list.size()<height){
            list.add(0,new int[width]);
        }

        //Перетворимо список назад у матрицю
        matrix = list.toArray(new int[height][width]);

    }

    /**
     * Метод повертає значення, що міститься в матриці з координатами (x, y)
     * Якщо координати поза матриці, метод повертає null.
     */
    public Integer getValue(int x, int y){
        if (x>=0 && x<width && y>=0 && y<height){
            return matrix[y][x];
        }
        return null;
    }


    /**
     * Метод встановлює передане значення (value) у комірку матриці з координатами (x, y)
     */
    public void setValue(int x, int y, int value){
        if (x>=0 && x<width && y>=0 && y<height){
            matrix[y][x] = value;
        }
    }


}
