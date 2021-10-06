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
    public void regresionMultiple(double x1, double x2){
        double[][] xtx = MultiplicarMa(xt,x);
        double[][] Iverxtx = IversaMatrizGj(xtx);
        double[][] xty =  MultiplicarMa(xt,y);
        betas = MultiplicarMa(Iverxtx, xty);
        System.out.println("\n\nMLR-----------");
        System.out.println("y = "+betas[0][0] + " + " + betas[1][0] +"("+x1+") + " + betas[2][0] +"("+x2+ ") " );
        System.out.println("y = "+  (betas[0][0]+betas[1][0]*x1+betas[2][0]*x2));


    }
    private static double[][] identidad(int n){
        double[][] identidad = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                identidad[i][j]=0;
            }
            identidad[i][i]=1;
        }
        return identidad;
    }
    private static double[][] IversaMatrizGj(double[][] matriz){
        double[][] identidad = identidad(matriz.length);
        double linea;
        double operacion;
        for (int i = 0; i <matriz.length ; i++) {
            linea = matriz[i][i];
            for (int j = 0; j < matriz.length; j++) { //renglones
                matriz[i][j] = matriz[i][j] / linea;
                identidad[i][j] = identidad[i][j] / linea;
            }
            for (int j = 0; j <matriz.length ; j++) {   //filas
                if (i!=j){
                    operacion = matriz[j][i];
                    for (int k = 0; k < matriz.length; k++) {
                        matriz[j][k] = matriz[j][k] -operacion*matriz[i][k];
                        identidad[j][k] = identidad[j][k] - operacion*identidad[i][k];
                    }
                }
            }
        }
        return identidad;
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
            y[i][0]= matriz[i][(matriz[0].length-1)];
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
