package lab2.matrix;

import lab2.exceptions.DivisionByZeroException;

import java.io.FileWriter;
import java.io.IOException;

public class RandomSquareMatrix {
    private final double[][] array;

    public RandomSquareMatrix(int size) {
        array = new double[size][size];
    }

    public void fillRandom() {
        int length = array.length;
        for (int i=0 ; i < length ; i++) {
            for (int j=0 ; j < length ; j++) {
                 array[i][j] = Math.random()*2*length-length;
            }
        }
    }

    public void print(FileWriter writer) throws IOException {
        int length = array.length;
        for (int i=0 ; i < length ; i++) {
            for (int j=0 ; j < length ; j++) {
                writer.write(array[i][j] + " ");
            }
            writer.write('\n');
        }
    }

    public void rotateBy90degrees() {
        int length = array.length;
        for (int i=0; i < length; i++) {
            for (int j=i; j < length; j++) {
                double tmp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = tmp;
            }
        }
        for (int i=0; i < length; i++) {
            for (int j=0; j < length / 2; j++) {
                double tmp = array[i][j];
                array[i][j] = array[i][length-j-1];
                array[i][length-j-1] = tmp;
            }
        }
    }

    public void divideIntoNearestElements() throws DivisionByZeroException {
        int length = array.length;
        double sum = 0;
        for (int i=0; i < length; i++) {
            for (int j=0; j < length; j++) {
                if (i - 1 >= 0) {
                    sum += array[i-1][j];
                }
                if (i + 1 < length) {
                    sum += array[i+1][j];
                }
                if (sum == 0) {
                    throw new DivisionByZeroException();
                }
                array[i][j] /= sum;
                sum = 0;
            }
        }
    }
}

