import java.util.ArrayList;
import java.util.List;

/*
���� ������� �� ��������� ����� ��� ������� ������ �� ����� ������ �� ��� ���.
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
        //��������� �����, ���� "������������" �������� ���� ���
        int[][] canvas = new int[height][width];

        //������� "������� ����" � �����
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                canvas[i][j] = matrix[i][j];
            }
        }

        //������� ������� � �����, ����� ��������� ������
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


        //������� "������������" �� �����, �� �������� � "������� �����".
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

    //���� �������� � ������� �������� ��������� ����� � ��������� �����, �� ����������� ���� ����� ����
    public void removeFullLines(){

       //��������� ������ ��������� ����
        List<int[]> list = new ArrayList<>();


        //������� �� ������� ���� �� ������.
        for (int y = 0; y < height; y++) {
            int count = 0;
            for (int x = 0; x < width; x++) {
                count+= matrix[y][x];
            }
            if (count!=width){
                list.add(matrix[y]);
            }
        }

        //������ �����, �� ��������, �� ������� ������.
        while (list.size()<height){
            list.add(0,new int[width]);
        }

        //����������� ������ ����� � �������
        matrix = list.toArray(new int[height][width]);

    }

    /**
     * ����� ������� ��������, �� �������� � ������� � ������������ (x, y)
     * ���� ���������� ���� �������, ����� ������� null.
     */
    public Integer getValue(int x, int y){
        if (x>=0 && x<width && y>=0 && y<height){
            return matrix[y][x];
        }
        return null;
    }


    /**
     * ����� ���������� �������� �������� (value) � ������ ������� � ������������ (x, y)
     */
    public void setValue(int x, int y, int value){
        if (x>=0 && x<width && y>=0 && y<height){
            matrix[y][x] = value;
        }
    }


}
