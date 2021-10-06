package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AgentGUI extends JFrame {

    private Main myAgent;
    private JTextField Textx1, Textx2, Textx3;;

    AgentGUI(Main a) {
        super(a.getLocalName());

        myAgent = a;

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(9, 1));
        p.add(new JLabel("The Normal equation"));
        Textx1 = new JTextField(5);
        p.add(new JLabel("X1"));
        p.add(Textx1);
        Textx2 = new JTextField(5);
        p.add(new JLabel("X2"));
        p.add(Textx2);
        p.add(new JLabel("Gradient"));
        Textx3 = new JTextField(5);
        p.add(new JLabel("X1"));
        p.add(Textx3);
        getContentPane().add(p, BorderLayout.CENTER);


        JButton addButton = new JButton("Calcular MLR");
        addButton.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    double x1 = Double.parseDouble(Textx1.getText());
                    double x2 = Double.parseDouble(Textx2.getText());
                    myAgent.getNormalE(x1,x2);
                    Textx1.setText("");
                    Textx2.setText("");
                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog(AgentGUI.this, "Invalid values. "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } );
        JButton addButton2 = new JButton("Calcular Gradient");
        addButton2.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {

                    double x = Double.parseDouble((Textx3.getText()));
                    myAgent.getGradient(x);
                    Textx3.setText("");

                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog(AgentGUI.this, "Invalid values. "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } );

        p = new JPanel();
        p.add(addButton);
        p.add(addButton2);
        getContentPane().add(p, BorderLayout.SOUTH);


        addWindowListener(new    WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                myAgent.doDelete();
            }
        } );

    }

    public void showGui() {
        pack();
        this.setSize(new Dimension(390,315));
        setLocationRelativeTo(null);

        super.setVisible(true);
    }


}
