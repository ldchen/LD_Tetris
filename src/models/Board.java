package models;

import java.util.Arrays;


public class Board {
    private int boardHeight = 22;
    private int boardWidth = 11;
    // Shape of the piece that is currently falling
    private Shapes currentShape = new Shapes();
    // coorX and coorY are used to control the movement of the Shape.
    private int coorX = boardWidth / 2;
    private int coorY = boardHeight;
    private boolean[] isFilled;

    public Board(){
        isFilled = new boolean[boardWidth * boardHeight];
        Arrays.fill(isFilled,false);
    }


    public boolean checkFilled(int x, int y){
        return isFilled[y * boardWidth + x];
    }

    // moveX < 0 means moving left, otherwise right;
    // moveY < 0 means moving down, otherwise up;
    // return false if the movement can't be made
    private boolean makeMove(int moveX, int moveY){
        int newCoorX = coorX + moveX;
        int newCoorY = coorY + moveY;
        int[][] coor = currentShape.getCoordinates();

        for (int i = 0; i < 4; ++i){
            // check if the position is filled already
            if (checkFilled(coor[i][0] + newCoorX, coor[i][1] + newCoorY)){
                return false;
            }
            // check if it hits the wall
            if (moveX != 0 && (coor[i][0] + newCoorX > boardWidth - 1 || coor[i][0] + newCoorX < 0)){
                return false;
            }
            // check if it hits the bottom
            if (newCoorY + coor[i][1] < 0){
                return false;
            }
        }

        coorX = newCoorX;
        coorY = newCoorY;
        return true;
    }

    public boolean moveLeft(){
        return makeMove(-1, 0);
    }

    public boolean moveRight(){
        return makeMove(1, 0);
    }

    public boolean moveDown(){
        return makeMove(0, -1);
    }

    public boolean leftRoate(){
        Shapes currentShapeCopy = currentShape;
        currentShapeCopy.leftRotate(1);
        int[][] newCoords = currentShapeCopy.getCoordinates();
        for (int i = 0; i < 4; ++i){
            if (checkFilled(newCoords[i][0] + coorX, newCoords[i][1] + coorY)){
                return false;
            }
            if (newCoords[i][0] + coorX > boardWidth - 1 || newCoords[i][0] + coorX < 0){
                return false;
            }
            if (newCoords[i][1] + coorY < 0){
                return false;
            }
        }
        currentShape = currentShapeCopy;
        return true;
    }













}
