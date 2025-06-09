import javax.swing.*;
import java.awt.*;

public class AreyouAdmin extends JDialog {

    public boolean isAdmin = false;

    public AreyouAdmin(JFrame parent) {
        super(parent, "관리자인가요?", true);  // true → 모달 창
        setSize(300, 150);
        setLocationRelativeTo(parent);

        JPanel panel = new JPanel(new BorderLayout());

        JLabel label = new JLabel("관리자 번호를 입력하세요");
        JPasswordField passwordField = new JPasswordField();
        JButton confirmBtn = new JButton("확인");

        panel.add(label, BorderLayout.NORTH);
        panel.add(passwordField, BorderLayout.CENTER);
        panel.add(confirmBtn, BorderLayout.SOUTH);

        confirmBtn.addActionListener(e -> {
            String input = new String(passwordField.getPassword());
            if (input.equals("IAMADMIN0321")) {
                isAdmin = true;
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "관리자 비밀번호가 틀렸습니다.");
            }
        });

        add(panel);
        setVisible(true);  // 여기서 모달 대기!
    }
}
