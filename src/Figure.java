/*
��� ���� ����������� �������, �� ����
��� ������������ �� ���������� �� �����.
�� ���������� ������������� �� ����� x �� y.
�� ����� � �������. ���������� ����� 3?3, �� ���������� � ������� �� ����.
�������� �� ���������, �� ������ �, ����� - �� ���� �������
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

    //��� ������ ����
    public void left(){}

    //��� ������ ������
    public void right(){}

    //��� ������ ����
    public void down(){}

    //��� ������ �����
    public void up(){}

    // ������� ������� ������� ������� �������
    public void rotate(){}

    //������ ������� ���� �� ���
    public void downMaximum(){}

    /*
    �������� - �� ������� ���� ���� ������� � ������� �������.
    ��� ����� ���������� ��������� � true, ���� �� �� ���������� �����
     */
    public boolean isCurrentPositionAvailable(){
        return true;
    }

    //�����������, ���� ������� ������� ��� ��� �������� � ���� �������
    //�� �� ������ ������ ����� ����� �������� �� Field.
    public void landed(){}

}

