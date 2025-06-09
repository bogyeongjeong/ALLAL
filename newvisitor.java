
import javax.swing.*;
import java.awt.*;

public class newvisitor extends JFrame {

    public newvisitor(String userId, String password) {
        setTitle("신규 사용자 승인");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 1));
        JLabel infoLabel = new JLabel("ID: " + userId + " / PW: " + password);
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton approveButton = new JButton("승인");
        approveButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "사용자 " + userId + " 승인 완료");
            dispose();
        });

        JButton rejectButton = new JButton("거절");
        rejectButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "사용자 " + userId + " 거절됨");
            dispose();
        });

        panel.add(infoLabel);
        panel.add(approveButton);
        panel.add(rejectButton);

        add(panel);
        setVisible(true);
    }
}
