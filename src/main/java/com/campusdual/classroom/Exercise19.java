package com.campusdual.classroom;

public class Exercise19 {

    private static String getTridimensionalString(int[][][] intArrayTri, int[][] flatMatrix) {
        int rows = intArrayTri[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append(stringFlatMatrixRow(flatMatrix, i));
            sb.append("   →   ");
            sb.append(stringTriMatrixRow(intArrayTri, i));
            sb.append("\n");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    private static String stringTriMatrixRow(int[][][] intArrayTri, int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayTri.length - 1; i++) {
            sb.append(getUnidimensionalString(intArrayTri[i][row]));
            sb.append("   ");
        }
        sb.append(getUnidimensionalString(intArrayTri[intArrayTri.length - 1][row]));

        return sb.toString();
    }

    private static String stringFlatMatrixRow(int[][] flatMatrix, int row) {
        return getUnidimensionalString(flatMatrix[row]);
    }

    public static String getTridimensionalString(int[][][] intArrayTri) {
        int[][] flatMatrix = flatTridimensionalArray(intArrayTri);
        return getTridimensionalString(intArrayTri, flatMatrix);
    }

    public static int[][] flatTridimensionalArray(int[][][] intArrayTri) {
        int rows = intArrayTri[0].length;
        int cols = intArrayTri[0][0].length;
        int[][] flatArray = new int[rows][cols];

        for (int i = 0; i < intArrayTri.length; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < cols; k++) {
                    flatArray[j][k] = intArrayTri[i][j][k]+flatArray[j][k];
                }
            }
        }
        return flatArray;
    }

    public static String getBidimensionalString(int[][] intArrayBi) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : intArrayBi) {
            sb.append(getUnidimensionalString(row));
            sb.append("\n");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    public static String getUnidimensionalString(int[] uniArray) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < uniArray.length; i++) {
            sb.append(uniArray[i]);
            if (i < uniArray.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static int[] createAndPopulateUnidimensionalArray(int columns) {
        int[] unidimensional = new int[columns];
        for (int i = 0; i < columns; i++) {
            unidimensional[i] = i + 1;
        }
        return unidimensional;
    }

    public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {
        int[][] bidimensinal = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                bidimensinal[i][j] = i * columns + j + 1;
            }
        }
        return bidimensinal;
    }

    public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {
        int[][][] tridimensional = new int[depth][rows][columns];
        int counter = 1;
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {
                    tridimensional[i][j][k] = counter++;
                }
            }
        }
        return tridimensional;
    }

    public static void main(String[] args) {
        int[] uniArray = createAndPopulateUnidimensionalArray(5);
        System.out.println("Array unidimensional:\n" + getUnidimensionalString(uniArray));
        System.out.println("===================");

        int[][] intArrayBi = createAndPopulateBidimensionalArray(3, 3);
        System.out.println("Bidimensional:\n" + getBidimensionalString(intArrayBi));
        System.out.println("===================");

        int[][][] intArrayTri = createAndPopulateTridimensionalArray(3, 3, 3);
        System.out.println("Tridimensional:\n" + getTridimensionalString(intArrayTri));
    }
}
