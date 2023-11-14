package Student_Grade_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class GradeCalcGUI extends JFrame {

    private JTextField[] subjFields;
    private JLabel totalMarksLbl, avgPercentageLbl, gradeLbl;

    public GradeCalcGUI() {
        super("Grade Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(0, 2));

        JLabel[] subjLbls = new JLabel[5];
        subjFields = new JTextField[5];
        for (int i = 0; i < 5; i++) {
            subjLbls[i] = new JLabel("Subj " + (i + 1) + " Marks:");
            subjFields[i] = new JTextField();
            add(subjLbls[i]);
            add(subjFields[i]);
        }

        JButton calcBtn = new JButton("Calculate");
        calcBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                computeResults();
            }
        });

        totalMarksLbl = new JLabel("Total Marks: ");
        avgPercentageLbl = new JLabel("Average %: ");
        gradeLbl = new JLabel("Grade: ");

        add(calcBtn);
        add(new JLabel());
        add(totalMarksLbl);
        add(avgPercentageLbl);
        add(gradeLbl);

        setVisible(true);
    }

    private void computeResults() {
        int totalMarks = 0;
        int totalSubjs = subjFields.length;

        for (int i = 0; i < totalSubjs; i++) {
            try {
                int marks = Integer.parseInt(subjFields[i].getText());
                totalMarks += marks;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid marks for all subjects.");
                return;
            }
        }

        double avgPercentage = (double) totalMarks / totalSubjs;

        String grade;
        if (avgPercentage >= 90) {
            grade = "A";
        } else if (avgPercentage >= 80) {
            grade = "B";
        } else if (avgPercentage >= 70) {
            grade = "C";
        } else if (avgPercentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        totalMarksLbl.setText("Total Marks: " + totalMarks);
        avgPercentageLbl.setText("Average %: " + String.format("%.2f%%", avgPercentage));
        gradeLbl.setText("Grade: " + grade);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GradeCalcGUI();
            }
        });
    }
}

