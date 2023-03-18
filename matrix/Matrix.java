import java.util.Random;

public class Matrix implements Runnable {
    private int rows;
    private int cols;
    private float[][] matrix;
    private int numprocs;

    public Matrix(int rows, int cols) {
        this.cols = cols;
        this.rows = rows;
        this.matrix = new float[rows][cols];
        this.numprocs = Runtime.getRuntime().availableProcessors();
    }

    public void generate_matrix() {
        Random random = new Random();
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.cols; j++) {
                this.matrix[i][j] = random.nextFloat();
            }
        }
    }

    public void generate_matrix_multithread() {
        int currentThread = (int) Thread.currentThread().getId() % this.numprocs;
        Random random = new Random();
        for(int row = currentThread; row <= this.rows; row+=this.numprocs) {
            for(int col = currentThread; col <= this.cols; col+=this.numprocs) {
                this.matrix[row][col] = random.nextFloat();
            }
        }
    }

    public void print_matrix_structure() {
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.cols; j++) {
                if(j == this.cols-1) {
                    System.out.printf("[%2d, %d]\n", i, j);
                } else {
                    System.out.printf("[%2d, %d] ", i, j);
                }
            }
        }
    }

    public void run() {
        generate_matrix();
    }
}
