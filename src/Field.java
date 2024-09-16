
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
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (matrix[y][x] == 0){
                    System.out.print(".");
                } else {
                    System.out.print("X");
                }
            }
            System.out.println();
        }

    }

    //буде видаляти з матриці повністю заповнені рядки і зрушувати рядки, які знаходяться вище рядка вниз
    public void removeFullLines(){

    }

    //повертає значення, що знаходиться в матриці з координатами x і y
    public Integer getValue(int x, int y){
        return null;
    }


    //встановлює передане значення у комірку масиву (матриці) з координатами x, y
    public void setValue(int x, int y, int value){

    }
}
