package com.company;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class Main extends Agent {

    private AgentGUI myGUI;
    protected void setup() {
        myGUI=new AgentGUI(this);
        myGUI.showGui();
    }
    public void getNormalE(final double x1, final double x2 ) {
        addBehaviour(new OneShotBehaviour() {
            public void action() {
                double[][] dataset= new double[][]{
                        {1,41.9,29.1,251.3},
                        {2,43.4,29.3,251.3},
                        {3,43.9,29.5,248.3},
                        {4,44.50,29.7,267.5},
                        {5,47.3,29.9,273},
                        {6,47.50,30.3,276.5},
                        {7,47.9,30.5,270.3},
                        {8,50.2,30.7,274.9},
                        {9,52.8,30.8,285},
                        {10,53.2,30.9,290},
                        {11,56.7,31.5,297},
                        {12,57,31.7,302.5},
                        {13,63.5,31.9,304.5},
                        {14,65.3,32,309.5},
                        {15,71.1,32.1,321.7},
                        {16,77,32.5,330.7},
                        {17,77.8,32.9,349}};
                NormalEquation noc = new NormalEquation(dataset);
                noc.regresionMultiple(x1, x2);

            }
        } );
    }
    public void getGradient(final double x ) {
        addBehaviour(new OneShotBehaviour() {
            public void action() {
                double[][] dtbenet = new  double[][]{{651,23},{762,26},{856,30},{1063,34},{1190,43},{1298,48},{1421,52},{1440,57},{1518,58}};
                GradientDescent noc2 = new GradientDescent(dtbenet);
                noc2.getGradinte(x);

            }
        } );
    }


}
