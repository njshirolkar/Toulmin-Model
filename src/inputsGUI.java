import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * Main class
 */
public class inputsGUI extends JFrame {
    JFrame myFrame;
    CardLayout cards;
    JPanel cardPanel;

    // input text fields:
    private JTextField backIn;
    private JTextField warrIn;
    private JTextField qualIn;
    private JTextField claimIn;
    private JTextField groundsIn;
    private JTextField rebuttIn;

    // ouput text fields:

    /*private JTextField backOut;
    private JTextField warrOut;
    private JTextField qualOut;
    private JTextField claimOut;
    private JTextField groundsOut;
    private JTextField rebuttOut;*/

    private JTextArea backOut;
    private JTextArea warrOut;
    private JTextArea qualOut;
    private JTextArea claimOut;
    private JTextArea groundsOut;
    private JTextArea rebuttOut;

    // stored values
    private String back;
    private String warr;
    private String qual;
    private String claim;
    private String grounds;
    private String rebutt;

    // labels for lines
    private JLabel g;
    private JLabel q;
    private JLabel c;
    private JLabel w;
    private JLabel b;
    private JLabel r;

    // var used for switching cards
    private int count = 0;

    /**
     * Constructor sets up cardLayout
     */
    public inputsGUI() {
        myFrame = new JFrame();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setTitle("Toulmin Argument Visualizer");
        myFrame.setSize(700, 700);
        myFrame.setLocationRelativeTo(null);
        myFrame.setLayout(new BorderLayout());

        Border outline = BorderFactory.createLineBorder(Color.black);
        JPanel myPanel = new JPanel();
        myPanel.setBorder(outline);
        JButton mainButton = new JButton("Generate Model");
        mainButton.setActionCommand("Generate Model");

        mainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (count % 2 == 0) {
                    // We are going from INPUTS -> OUTPUTS


                    back = backIn.getText();
                    warr = warrIn.getText();
                    qual = qualIn.getText();
                    claim = claimIn.getText();
                    grounds = groundsIn.getText();
                    rebutt = rebuttIn.getText();

                    backOut.setText(back);
                    warrOut.setText(warr);
                    qualOut.setText(qual);
                    claimOut.setText(claim);
                    groundsOut.setText(grounds);
                    rebuttOut.setText(rebutt);


                    mainButton.setText("Back");
                } else {
                    // We are going from OUTPUTS -> INPUTS
                    // - wipe all fields, textArea/Fields

                    back = "";
                    warr = "";
                    qual = "";
                    claim = "";
                    grounds = "";
                    rebutt = "";

                    backIn.setText("");
                    warrIn.setText("");
                    qualIn.setText("");
                    claimIn.setText("");
                    groundsIn.setText("");
                    rebuttIn.setText("");

                    backOut.setText("");
                    warrOut.setText("");
                    qualOut.setText("");
                    claimOut.setText("");
                    groundsOut.setText("");
                    rebuttOut.setText("");


                    mainButton.setText("Generate Model");
                }

                count += 1;
                cards.next(cardPanel);
            }
        });


        myPanel.add(mainButton);
        //myFrame.add(myPanel,BorderLayout.SOUTH);

        cards = new CardLayout();
        cardPanel = new JPanel();
        cardPanel.setLayout(cards);

        // initially show inputs
        cards.show(cardPanel, "Inputs");
        JPanel inputsCard = new JPanel(new GridLayout(0, 2, 1, 1));
        inputsCard.setBackground(Color.LIGHT_GRAY);

        // instantiate the text fields
        backIn = new JTextField();
        warrIn = new JTextField();
        qualIn = new JTextField();
        claimIn = new JTextField();
        groundsIn = new JTextField();
        rebuttIn = new JTextField();

        // instantiate the other text fields

        /*
        backOut = new JTextField();
        warrOut = new JTextField();
        qualOut = new JTextField();
        claimOut = new JTextField();
        groundsOut = new JTextField();
        rebuttOut = new JTextField();*/
        backOut = new JTextArea();
        warrOut = new JTextArea();
        qualOut = new JTextArea();
        claimOut = new JTextArea();
        groundsOut = new JTextArea();
        rebuttOut = new JTextArea();

        JScrollPane scroll1 = new JScrollPane(backOut);
        JScrollPane scroll2 = new JScrollPane(warrOut);
        JScrollPane scroll3 = new JScrollPane(qualOut);
        JScrollPane scroll4 = new JScrollPane(claimOut);
        JScrollPane scroll5 = new JScrollPane(groundsOut);
        JScrollPane scroll6 = new JScrollPane(rebuttOut);

        // Add buttons and UI

        inputsCard.add(new JLabel("Grounds: "));
        inputsCard.add(groundsIn);

        inputsCard.add(new JLabel("Qualifier: "));
        inputsCard.add(qualIn);

        inputsCard.add(new JLabel("Claim: "));
        inputsCard.add(claimIn);

        inputsCard.add(new JLabel("Warrant: "));
        inputsCard.add(warrIn);

        inputsCard.add(new JLabel("Backing: "));
        inputsCard.add(backIn);

        inputsCard.add(new JLabel("Rebuttal: "));
        inputsCard.add(rebuttIn);


        // End Add buttons and UI

        outputPanel outputsCard = new outputPanel();
        /*JPanel outputsCard = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawLine(0,0, 20, 35);
            };*/


        outputsCard.setBackground(Color.LIGHT_GRAY);

        // Add buttons and UI
        outputsCard.setLayout(null);
        Font f;


        g = new JLabel("Grounds");
        f = g.getFont();
        g.setFont(f.deriveFont(f.getStyle() ^ Font.BOLD));
        g.setSize(100, 100);
        g.setLocation(50, 275);
        groundsOut.setSize(150, 150);
        groundsOut.setLocation(50, 350);


        q = new JLabel("Qualifier");
        q.setFont(f.deriveFont(f.getStyle() ^ Font.BOLD));
        q.setSize(100, 100);
        q.setLocation(300, 275);
        qualOut.setSize(150, 150);
        qualOut.setLocation(300, 350);

        c = new JLabel("Claim");
        c.setFont(f.deriveFont(f.getStyle() ^ Font.BOLD));
        c.setSize(100, 100);
        c.setLocation(500, 275);
        claimOut.setSize(100, 100);
        claimOut.setLocation(580, 290);

        r = new JLabel("Rebuttal");
        r.setFont(f.deriveFont(f.getStyle() ^ Font.BOLD));
        r.setSize(100, 100);
        r.setLocation(500, 450);
        rebuttOut.setSize(100, 100);
        rebuttOut.setLocation(580, 450);

        w = new JLabel("Warrant");
        w.setFont(f.deriveFont(f.getStyle() ^ Font.BOLD));
        w.setSize(100, 100);
        w.setLocation(250, 150);
        warrOut.setSize(200, 75);
        warrOut.setLocation(325, 150);

        b = new JLabel("Backing");
        b.setFont(f.deriveFont(f.getStyle() ^ Font.BOLD));
        b.setSize(100, 100);
        b.setLocation(250, 50);
        backOut.setSize(200, 75);
        backOut.setLocation(325, 55);


        outputsCard.add(g);
        outputsCard.add(q);
        outputsCard.add(c);
        outputsCard.add(r);
        outputsCard.add(w);
        outputsCard.add(b);

        backOut.setLineWrap(true);
        backOut.setWrapStyleWord(true);

        warrOut.setLineWrap(true);
        warrOut.setWrapStyleWord(true);

        qualOut.setLineWrap(true);
        qualOut.setWrapStyleWord(true);

        claimOut.setLineWrap(true);
        claimOut.setWrapStyleWord(true);

        groundsOut.setLineWrap(true);
        groundsOut.setWrapStyleWord(true);

        rebuttOut.setLineWrap(true);
        rebuttOut.setWrapStyleWord(true);

        outputsCard.add(backOut);
        outputsCard.add(warrOut);
        outputsCard.add(qualOut);
        outputsCard.add(claimOut);
        outputsCard.add(groundsOut);
        outputsCard.add(rebuttOut);

        outputsCard.add(scroll1);
        outputsCard.add(scroll2);
        outputsCard.add(scroll3);
        outputsCard.add(scroll4);
        outputsCard.add(scroll5);
        outputsCard.add(scroll6);

        // touch up labels
        JLabel t1 = new JLabel("since");
        t1.setSize(50, 50);
        t1.setLocation(w.getX() + 20, w.getY() + 75);

        JLabel t2 = new JLabel("because");
        t2.setSize(100, 50);
        t2.setLocation(g.getX() + 110, g.getY() + 10);

        JLabel t3 = new JLabel("therefore");
        t3.setSize(100, 50);
        t3.setLocation(g.getX() + 340, g.getY() + 10);

        JLabel t4 = new JLabel("on account of");
        t4.setSize(200, 50);
        t4.setLocation(w.getX() - 90, w.getY() - 30);

        JLabel t5 = new JLabel("in response to");
        t5.setSize(200, 50);
        t5.setLocation(r.getX() + 20, r.getY() - 50);

        outputsCard.add(t1);
        outputsCard.add(t2);
        outputsCard.add(t3);
        outputsCard.add(t4);
        outputsCard.add(t5);

        // End Add buttons and UI

        cardPanel.add(inputsCard, "Inputs");
        cardPanel.add(outputsCard, "Outputs");

        myFrame.add(myPanel, BorderLayout.SOUTH);
        myFrame.add(cardPanel, BorderLayout.CENTER);
        myFrame.setVisible(true);


    }

    private void addButton(Container parent, String name) {
        JButton but = new JButton(name);
        but.setActionCommand(name);
        parent.add(but);
    }

    /**
     * Main runner for this project
     *
     * @param args
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                inputsGUI x = new inputsGUI();
                x.setVisible(true);
            }
        });
    }

    /**
     * outPanel class extends JPanel and implements lines
     */
    public class outputPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics gr) {
            super.paintComponent(gr);
            int centQX = q.getX() - 10;
            int centQY = q.getY() + 50;
            // With manual adjustments
            // Grounds - Qual
            gr.drawLine(g.getX() + 75, g.getY() + 50, centQX, centQY);
            // Qual - Claim
            gr.drawLine(centQX + 75, centQY, c.getX() - 20, centQY);
            // Claim - Rebuttal
            gr.drawLine(c.getX() + 10, c.getY() + 75, r.getX() + 10, r.getY() + 25);
            // Backing - Warrant
            gr.drawLine(b.getX() + 10, b.getY() + 60, w.getX() + 10, w.getY() + 25);
            // Warrant - Qual
            gr.drawLine(w.getX() + 10, w.getY() + 75, w.getX() + 10, centQY - 10);

            // Warrant - Qual ARROW
            gr.drawLine(w.getX(), centQY - 20, w.getX() + 10, centQY - 10);
            gr.drawLine(w.getX() + 20, centQY - 20, w.getX() + 10, centQY - 10);

            // Backing - Warrant ARROW
            gr.drawLine(w.getX(), w.getY() + 15, w.getX() + 10, w.getY() + 25);
            gr.drawLine(w.getX() + 20, w.getY() + 15, w.getX() + 10, w.getY() + 25);

            // Claim - Rebuttal ARROW
            gr.drawLine(c.getX(), c.getY() + 85, c.getX() + 10, c.getY() + 75);
            gr.drawLine(c.getX() + 20, c.getY() + 85, c.getX() + 10, c.getY() + 75);

            // Grounds - Qual
            gr.drawLine(centQX - 10, centQY + 10, centQX, centQY);
            gr.drawLine(centQX - 10, centQY - 10, centQX, centQY);

            // Qual - Claim
            gr.drawLine(c.getX() - 30, centQY + 10, c.getX() - 20, centQY);
            gr.drawLine(c.getX() - 30, centQY - 10, c.getX() - 20, centQY);

        }

    }


}
