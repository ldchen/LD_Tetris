package models;

public class Shapes {
    enum Tetromino {
        No_shape, Square, Stick, T_shape, Z_shape, Z_inverse, L_shape, L_inverse
    }

    private Tetromino tetroShape;
    // Each coordinate pair {x, y} is a block
    private int[][] coordinates;
    public int abc = 0;

    public Shapes(){
        tetroShape = Tetromino.No_shape;
        coordinates = new int[][] {{0, 0}, {0, 0}, {0, 0}, {0, 0}};
    }

    public Shapes(Tetromino shape){
        tetroShape = shape;
        switch (shape){
            case Square:
                coordinates = new int[][] {{0, 0}, {1, 0}, {0, -1}, {1, -1}};
                break;
            case Stick:
                coordinates = new int[][] {{0, 1}, {0, 0}, {0, -1}, {0, -2}};
                break;
            case T_shape:
                coordinates = new int[][] {{-1, 0}, {0, 0}, {1, 0}, {0, -1}};
                break;
            case Z_shape:
                coordinates = new int[][] {{-1, 0}, {0, 0}, {0, -1}, {1, -1}};
                break;
            case Z_inverse:
                coordinates = new int[][] {{1, 0}, {0, 0}, {0, -1}, {-1, -1}};
            case L_shape:
                coordinates = new int[][] {{0, 1}, {0, 0}, {0, -1}, {1, -1}};
                break;
            case L_inverse:
                coordinates = new int[][] {{0, 1}, {0, 0}, {0, -1}, {-1, -1}};
                break;
            case No_shape:
                coordinates = new int[][] {{0, 0}, {0, 0}, {0, 0}, {0, 0}};
        }
    }


    // rotate left for n times
    public void leftRotate(int n){
        n = n % 4;
        for (int i = 0; i < n; ++i){
            oneLeftRotate();
        }
    }



    //Left Rotation is the same as map {x, y} to {-y, x}
    private void oneLeftRotate(){
        if (tetroShape == Tetromino.Square) {
            return;
        }
        for (int i = 0; i < 4; ++i){
            int y = coordinates[i][1];
            coordinates[i][1] = coordinates[i][0];
            coordinates[i][0] = -y;
        }
    }

    public int[][] getCoordinates(){
        return coordinates;
    }



}
