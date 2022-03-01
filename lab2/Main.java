package lab2;

import lab2.exceptions.*;
import lab2.matrix.RandomSquareMatrix;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String inputPath = "src/lab2/inputFile.txt";
        String outputPath = "src/lab2/outputFile.txt";
        int size;
        try (FileReader fileReader = new FileReader(inputPath);
             FileWriter writer = new FileWriter(outputPath, false);
             Scanner in = new Scanner(fileReader);) {
            size = in.nextInt();
            if (size > 1000000) {
                throw new BigMatrixSizeException();
            }
            RandomSquareMatrix matrix = new RandomSquareMatrix(size);
            matrix.fillRandom();
            for (int i = 0; i < 3; i++)
            {
                matrix.rotateBy90degrees();
                matrix.divideIntoNearestElements();
                matrix.print(writer);
                writer.write('\n');
            }
        } catch (FileNotFoundException e) {
            try {
                throw new FileIsNotFoundException();
            } catch(FileIsNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        }catch (BigMatrixSizeException | DivisionByZeroException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException |  NegativeArraySizeException | IOException e) {
            System.out.println( "We caught "+e.getClass());
        }
    }
}
