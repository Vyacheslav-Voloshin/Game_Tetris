
/*
���� ������� �� ��������� ����� ��� ������ ������ �� ���� ������ �� ��� ���.
 */
public class Field {

    private int width; //������ x

    private int height;  //������ y

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

    //��'��� ���������� �� ����� ��� �������� ����
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

    //���� �������� � ������� ������� �������� ����� � ��������� �����, �� ����������� ���� ����� ����
    public void removeFullLines(){

    }

    //������� ��������, �� ����������� � ������� � ������������ x � y
    public Integer getValue(int x, int y){
        return null;
    }


    //���������� �������� �������� � ������ ������ (�������) � ������������ x, y
    public void setValue(int x, int y, int value){

    }
}
