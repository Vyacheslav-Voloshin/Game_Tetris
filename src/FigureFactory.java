/*
Клас за допомогою якого, ми створюватимемо фігури різних форм
 */
public class FigureFactory {

    /**
     * Набір з шести шаблонів  фігурок
     */

    public static final int[][][] BRICKS = {{
            {1, 1, 0},                          //   X X
            {0, 1, 1},                          //     X X
            {0, 0, 0}}, {                       //

            {1, 0, 0},                          //   X
            {1, 1, 0},                          //   X X
            {0, 1, 0}}, {                       //     X

            {0, 1, 0},                          //   X
            {0, 1, 0},                          //   X
            {0, 1, 0}}, {                       //   X

            {1, 1, 0},                          //   X X
            {1, 1, 0},                          //   X X
            {0, 0, 0}}, {                       //

            {1, 1, 1},                          //   X X X
            {0, 1, 0},                          //     X
            {0, 0, 0}}, {                       //

            {1, 1, 1},                          //   X X X
            {1, 1, 1},                          //   X X X
            {0, 0, 0}}                          //
    };


    public static Figure createRandomFigure(int x,int y){
        return null;
    }
}

