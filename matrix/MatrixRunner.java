public class MatrixRunner {
    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("Erro");
            System.exit(1);
        } else {
            Matrix matrix = new Matrix(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            matrix.generate_matrix_multithread();
            //matrix.print_matrix_structure();
        }
    }
}
