package com.company;

public class NormalEquation {
    private double[][] dataset;
    private double[][] x;
    private double[][] xt;
    private double[][] y;
    private double[][] betas;

    public NormalEquation(double[][] dataset) {
        this.dataset = dataset;
        x = getX(dataset);
        xt =TranspuestaMa(x);
        y = getY(dataset);
    }
    public void regresionMultiple(){
        double[][] xtx = MultiplicarMa(xt,x);
        double[][] Iverxtx = IversaMa(xtx);
        double[][] xty =  MultiplicarMa(xt,y);
        betas = MultiplicarMa(Iverxtx, xty);
        System.out.println("b0 = "+betas[0][0]);
        System.out.println("b1 = "+betas[1][0]);
        System.out.println("b2 = "+betas[2][0]);
    }
    private static double[][] Cofactor(double[][] matriz, int fila, int columna){
        double[][] resutado = new double[matriz.length-1][matriz[0].length-1];
        int f=0, c=0;
        for (int i = 0; i <matriz.length ; i++) {
            if (i != fila) {
                c=0;
                for (int j = 0; j < matriz[0].length; j++) {
                    if (j!=columna){
                        resutado[f][c]= matriz[i][j];
                        c++;
                    }
                }
                f++;
            }
        }
        return resutado;
    }
    private static double[][] IversaMa(double[][] matriz){
        double[][] resutado = new double[matriz.length][matriz[0].length];
        double determinate = determinante(matriz);
        double signo  =1;
        for (int i = 0; i < matriz.length; i++) { //filas
            for (int j = 0; j < matriz[0].length ; j++) { //columnas
                double[][] temp = Cofactor(matriz, i, j);
                resutado[i][j]= (((temp[0][0]* temp[1][1]) -(temp[1][0]* temp[0][1]))/determinate) *signo;
                signo = signo *-1;
            }
        }
        return resutado;
    }
    private static double determinante(double[][] matriz){
        return (matriz[0][0] * matriz[1][1] * matriz[2][2] + matriz[2][0] * matriz[0][1] * matriz[1][2] +matriz[0][2] * matriz[1][0] * matriz[2][1])
                - (matriz[2][0] * matriz[1][1]* matriz[0][2] + matriz[0][0]* matriz[1][2]*matriz[2][1] + matriz[0][1]*matriz[1][0]*matriz[2][2]);
    }
    private static double[][] MultiplicarMa(double[][] matriz1, double[][] matriz2){
        double[][] resutado = new double[matriz1.length][matriz2[1].length];

        for (int i = 0; i <matriz1.length ; i++) { //filas

            for (int j = 0; j <matriz2[0].length ; j++) { //columnas
                double aux=0;
                for (int k = 0; k <matriz1[0].length ; k++) {
                    aux += matriz1[i][k] * matriz2[k][j];
                }
                resutado[i][j] = aux;
            }
        }
        return resutado;
    }

    private static double[][] getY(double[][] matriz){
        double[][] y= new double[matriz.length][1];
        for (int i = 0; i < matriz.length; i++) {
            y[i][0]= matriz[i][3];
        }
        return y;
    }
    private static double[][] getX(double[][] matriz){
        double[][] resutado = new double[matriz.length][matriz[0].length-1];
        for (int i = 0; i < matriz.length; i++) { //filas
            for (int j = 0; j < matriz[0].length-1 ; j++) { //columnas
                if (j == 0) {
                    resutado[i][j]=1;
                }else
                    resutado[i][j] = matriz[i][j];
            }
        }
        return resutado;
    }
    private static double[][] TranspuestaMa(double[][] matriz){
        double[][] resutado = new double[matriz[0].length][matriz.length];
        for (int i = 0; i <matriz.length ; i++) {
            for (int j = 0; j <matriz[0].length ; j++) {
                resutado[j][i] = matriz[i][j];
            }
        }
        return resutado;
    }

}