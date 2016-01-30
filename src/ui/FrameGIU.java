package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameGIU extends JFrame {

    public JTextField signTextFieldMessage, verifyTextFieldMessage, signKeyQTextField, signKeyPTextField,
            signKeyGTextField, signTextFieldPrivateX, signTextFieldPrivateY, signTextFieldSignatureR, signTextFieldSignatureS,
            verifyKeyQTextField, verifyKeyGTextField, verifyKeyPTextField, verifyTextFieldPrivateY, verifyTextFieldSignatureR, verifyTextFieldSignatureS;
    public JButton signButton;

    public FrameGIU() {

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

        JLabel signMessageLabel = new JLabel("Message to sign");
        JLabel verifyMessageLabel = new JLabel("Message to verify");

        signTextFieldMessage = new JTextField(60);
        verifyTextFieldMessage = new JTextField(60);

        signButton = new JButton("Generate keys");
        final boolean btnEnabled = true;
        signButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signButton.setEnabled(false);
                signButton.setText("Please wait...");
            }
        });
        JButton verifyButton = new JButton("Check signature");

        JLabel signLabelKeyQ = new JLabel("Global key Q");
        JLabel signLabelKeyP = new JLabel("Global key P");
        JLabel signLabelKeyG = new JLabel("Global key G");
        JLabel signLabelPrivateX = new JLabel("Private key X");
        JLabel signLabelPrivateY = new JLabel("Private key Y");
        JLabel signLabelSignatureR = new JLabel("Signature key R");
        JLabel signLabelSignatureS = new JLabel("Signature key S");

        JLabel verifyLabelKeyQ = new JLabel("Global key Q");
        JLabel verifyLabelKeyP = new JLabel("Global key P");
        JLabel verifyLabelKeyG = new JLabel("Global key G");
        JLabel verifyLabelPrivateY = new JLabel("Private key Y");
        JLabel verifyLabelSignatureR = new JLabel("Signature key R");
        JLabel verifyLabelSignatureS = new JLabel("Signature key S");

        signKeyQTextField = new JTextField(85);
        signKeyPTextField = new JTextField(85);
        signKeyGTextField = new JTextField(85);
        signTextFieldPrivateX = new JTextField(85);
        signTextFieldPrivateY = new JTextField(85);
        signTextFieldSignatureR = new JTextField(85);
        signTextFieldSignatureS = new JTextField(85);

        verifyKeyQTextField = new JTextField(85);
        verifyKeyPTextField = new JTextField(85);
        verifyKeyGTextField = new JTextField(85);
        verifyTextFieldPrivateY = new JTextField(85);
        verifyTextFieldSignatureR = new JTextField(85);
        verifyTextFieldSignatureS = new JTextField(85);

        signTab.add(signMessageLabel);
        verifyTab.add(verifyMessageLabel);

        signTab.add(signTextFieldMessage);
        verifyTab.add(verifyTextFieldMessage);

        signTab.add(signButton);
        verifyTab.add(verifyButton);

        // Sing Labels
        signTab.add(signLabelKeyG);
        signTab.add(signLabelKeyP);
        signTab.add(signLabelKeyQ);
        signTab.add(signLabelPrivateX);
        signTab.add(signLabelPrivateY);
        signTab.add(signLabelSignatureR);
        signTab.add(signLabelSignatureS);

        // Sign TextFields
        signTab.add(signKeyGTextField);
        signTab.add(signKeyQTextField);
        signTab.add(signKeyPTextField);
        signTab.add(signTextFieldPrivateX);
        signTab.add(signTextFieldPrivateY);
        signTab.add(signTextFieldSignatureR);
        signTab.add(signTextFieldSignatureS);

        // Verify labels
        verifyTab.add(verifyLabelKeyG);
        verifyTab.add(verifyLabelKeyP);
        verifyTab.add(verifyLabelKeyQ);
        verifyTab.add(verifyLabelPrivateY);
        verifyTab.add(verifyLabelSignatureR);
        verifyTab.add(verifyLabelSignatureS);

        // Verify TextFields
        verifyTab.add(verifyKeyGTextField);
        verifyTab.add(verifyKeyQTextField);
        verifyTab.add(verifyKeyPTextField);
        verifyTab.add(verifyTextFieldPrivateY);
        verifyTab.add(verifyTextFieldSignatureR);
        verifyTab.add(verifyTextFieldSignatureS);

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
        signLabelKeyQ.setBounds(20 + insetsSign.left, 70 + insetsSign.top, size.width, size.height);

        size = signLabelKeyP.getPreferredSize();
        signLabelKeyP.setBounds(20 + insetsSign.left, 120 + insetsSign.top, size.width, size.height);

        size = signLabelKeyQ.getPreferredSize();
        signLabelKeyG.setBounds(20 + insetsSign.left, 170 + insetsSign.top, size.width, size.height);

        size = verifyLabelKeyQ.getPreferredSize();
        verifyLabelKeyQ.setBounds(20 + insetsVerify.left, 70 + insetsVerify.top, size.width, size.height);

        size = verifyLabelKeyP.getPreferredSize();
        verifyLabelKeyP.setBounds(20 + insetsVerify.left, 120 + insetsVerify.top, size.width, size.height);

        size = verifyLabelKeyQ.getPreferredSize();
        verifyLabelKeyG.setBounds(20 + insetsVerify.left, 170 + insetsVerify.top, size.width, size.height);


        size = signLabelPrivateX.getPreferredSize();
        signLabelPrivateX.setBounds(20 + insetsSign.left, 220 + insetsSign.top, size.width, size.height);

        size = signLabelPrivateY.getPreferredSize();
        signLabelPrivateY.setBounds(20 + insetsSign.left, 270 + insetsSign.top, size.width, size.height);

        size = signLabelSignatureR.getPreferredSize();
        signLabelSignatureR.setBounds(20 + insetsSign.left, 320 + insetsSign.top, size.width, size.height);

        size = signLabelSignatureS.getPreferredSize();
        signLabelSignatureS.setBounds(20 + insetsSign.left, 370 + insetsSign.top, size.width, size.height);


        size = verifyLabelPrivateY.getPreferredSize();
        verifyLabelPrivateY.setBounds(20 + insetsVerify.left, 220 + insetsVerify.top, size.width, size.height);

        size = verifyLabelSignatureR.getPreferredSize();
        verifyLabelSignatureR.setBounds(20 + insetsVerify.left, 270 + insetsVerify.top, size.width, size.height);

        size = verifyLabelSignatureS.getPreferredSize();
        verifyLabelSignatureS.setBounds(20 + insetsVerify.left, 320 + insetsVerify.top, size.width, size.height);



        size = signKeyQTextField.getPreferredSize();
        signKeyQTextField.setBounds(115 + insetsSign.left, 70 + insetsSign.top, size.width, size.height);

        size = signKeyPTextField.getPreferredSize();
        signKeyPTextField.setBounds(115 + insetsSign.left, 120 + insetsSign.top, size.width, size.height);

        size = signKeyQTextField.getPreferredSize();
        signKeyGTextField.setBounds(115 + insetsSign.left, 170 + insetsSign.top, size.width, size.height);

        size = signTextFieldPrivateX.getPreferredSize();
        signTextFieldPrivateX.setBounds(115 + insetsSign.left, 220 + insetsSign.top, size.width, size.height);

        size = signTextFieldPrivateY.getPreferredSize();
        signTextFieldPrivateY.setBounds(115 + insetsSign.left, 270 + insetsSign.top, size.width, size.height);

        size = signTextFieldSignatureR.getPreferredSize();
        signTextFieldSignatureR.setBounds(115 + insetsSign.left, 320 + insetsSign.top, size.width, size.height);

        size = signTextFieldSignatureS.getPreferredSize();
        signTextFieldSignatureS.setBounds(115 + insetsSign.left, 370 + insetsSign.top, size.width, size.height);

        size = verifyKeyQTextField.getPreferredSize();
        verifyKeyQTextField.setBounds(115 + insetsVerify.left, 70 + insetsVerify.top, size.width, size.height);

        size = verifyKeyPTextField.getPreferredSize();
        verifyKeyPTextField.setBounds(115 + insetsVerify.left, 120 + insetsVerify.top, size.width, size.height);

        size = verifyKeyQTextField.getPreferredSize();
        verifyKeyGTextField.setBounds(115 + insetsVerify.left, 170 + insetsVerify.top, size.width, size.height);

        size = verifyTextFieldPrivateY.getPreferredSize();
        verifyTextFieldPrivateY.setBounds(115 + insetsVerify.left, 220 + insetsVerify.top, size.width, size.height);

        size = verifyTextFieldSignatureR.getPreferredSize();
        verifyTextFieldSignatureR.setBounds(115 + insetsVerify.left, 270 + insetsVerify.top, size.width, size.height);

        size = verifyTextFieldSignatureS.getPreferredSize();
        verifyTextFieldSignatureS.setBounds(115 + insetsVerify.left, 320 + insetsVerify.top, size.width, size.height);

        getContentPane().add(content);
        setResizable(false);
        setPreferredSize(new Dimension(1100, 500));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                new FrameGIU();
            }
        });
    }
}