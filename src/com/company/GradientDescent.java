package com.company;

public class GradientDescent {
    private double[][] matriz;


    public GradientDescent(double[][] matriz) {
        this.matriz = matriz;

    }
    public void getGradinte(){
        double b0 = 0, b1 = 0, a = 0.0005, error = 0;
        for (int i = 0; i <150000 ; i++) {
            double[] aux = Calcular(b0,b1);
            b0 = (b0 - a*aux[0]);
            b1 = (b1 - a*aux[1]);
            error = aux[2];
        }
        System.out.println("error: "+error);
        System.out.println("b0= "+b0);
        System.out.println("b1= "+b1);


    }
    private double[] Calcular(double b0, double b1){
        double[] resultado= new double[3];
        double aux = 0;
        for (int i = 0; i < matriz.length; i++) {
            aux = matriz[i][0] -(b0+b1*matriz[i][1]);
            resultado[0] += aux;
            resultado[1] +=matriz[i][1]*aux;
            resultado[2] +=aux;
        }
        resultado[0] = -2*(resultado[0])/ matriz.length;
        resultado[1] = -2*(resultado[1])/ matriz.length;
        resultado[2] = (resultado[2]*resultado[2])* 1/matriz.length;
        return resultado;
    }






}
