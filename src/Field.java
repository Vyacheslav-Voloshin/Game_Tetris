
/*
Клас відповідає за зберігання даних про поточні зайняті та вільні клітини на полі гри.
 */
public class Field {

    private int width; //ширина

    private int height;  //висота

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
}
