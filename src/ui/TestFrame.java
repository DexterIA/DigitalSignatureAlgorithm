package ui;

import javax.swing.*;
import java.awt.*;

public class TestFrame extends JFrame {

    public TestFrame() {

        super("Digital signature algorithm");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Verdana", Font.PLAIN, 10);
        final JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(font);

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());

        JPanel buttons = new JPanel();
        content.add(buttons, BorderLayout.NORTH);
        JPanel signTab = new JPanel();
        JPanel verifyTab = new JPanel();
        tabbedPane.addTab("Sign", signTab);
        tabbedPane.addTab("Verify", verifyTab);
        content.add(tabbedPane, BorderLayout.CENTER);

        signTab.setLayout(null);
        verifyTab.setLayout(null);

        JLabel signMessageLabel = new JLabel("Message to sing");
        JLabel verifyMessageLabel = new JLabel("Message to verify");

        JTextField signTextFieldMessage = new JTextField(60);
        JTextField verifyTextFieldMessage = new JTextField(60);

        JButton signButton = new JButton("Generate keys");
        JButton verifyButton = new JButton("Check signature");

        JLabel signLabelKeyQ = new JLabel("Global key Q");
        JLabel signLabelKeyP = new JLabel("Global key P");
        JLabel signLabelKeyG = new JLabel("Global key G");

        JLabel verifyLabelKeyQ = new JLabel("Global key Q");
        JLabel verifyLabelKeyP = new JLabel("Global key P");
        JLabel verifyLabelKeyG = new JLabel("Global key G");

        JTextField signKeyQTextField = new JTextField(70);
        JTextField signKeyPTextField = new JTextField(70);
        JTextField signKeyGTextField = new JTextField(70);

        JTextField verifyKeyQTextField = new JTextField(70);
        JTextField verifyKeyPTextField = new JTextField(70);
        JTextField verifyKeyGTextField = new JTextField(70);

        signTab.add(signMessageLabel);
        verifyTab.add(verifyMessageLabel);

        signTab.add(signTextFieldMessage);
        verifyTab.add(verifyTextFieldMessage);

        signTab.add(signButton);
        verifyTab.add(verifyButton);

        signTab.add(signLabelKeyG);
        signTab.add(signLabelKeyP);
        signTab.add(signLabelKeyQ);

        verifyTab.add(verifyLabelKeyG);
        verifyTab.add(verifyLabelKeyP);
        verifyTab.add(verifyLabelKeyQ);

        signTab.add(signKeyGTextField);
        signTab.add(signKeyQTextField);
        signTab.add(signKeyPTextField);

        verifyTab.add(verifyKeyGTextField);
        verifyTab.add(verifyKeyQTextField);
        verifyTab.add(verifyKeyPTextField);

        Insets insetsSign = signTab.getInsets();
        Insets insetsVerify = verifyTab.getInsets();

        Dimension size = signMessageLabel.getPreferredSize();
        signMessageLabel.setBounds(20 + insetsSign.left, 20 + insetsSign.top, size.width, size.height);

        size = verifyMessageLabel.getPreferredSize();
        verifyMessageLabel.setBounds(20 + insetsVerify.left, 20 + insetsVerify.top, size.width, size.height);

        size = signTextFieldMessage.getPreferredSize();
        signTextFieldMessage.setBounds(120 + insetsSign.left, 20 + insetsSign.top, size.width, size.height + 5);

        size = verifyTextFieldMessage.getPreferredSize();
        verifyTextFieldMessage.setBounds(125 + insetsVerify.left, 20 + insetsVerify.top, size.width, size.height + 5);

        size = signButton.getPreferredSize();
        signButton.setBounds(800 + insetsSign.left, 20 + insetsSign.top, size.width, size.height);

        size = verifyButton.getPreferredSize();
        verifyButton.setBounds(800 + insetsVerify.left, 20 + insetsVerify.top, size.width, size.height);

        size = signLabelKeyQ.getPreferredSize();
        signLabelKeyQ.setBounds(20 + insetsSign.left, 60 + insetsSign.top, size.width, size.height);

        size = signLabelKeyP.getPreferredSize();
        signLabelKeyP.setBounds(20 + insetsSign.left, 120 + insetsSign.top, size.width, size.height);

        size = signLabelKeyQ.getPreferredSize();
        signLabelKeyG.setBounds(20 + insetsSign.left, 180 + insetsSign.top, size.width, size.height);

        getContentPane().add(content);
        setResizable(false);
        setPreferredSize(new Dimension(1100, 650));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                new TestFrame();
            }
        });
    }
}