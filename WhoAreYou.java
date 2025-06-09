import javax.swing.*;
import java.awt.*;

public class WhoAreYou extends JDialog {
    public boolean iamuser = false;
    public String userId = "";

    public WhoAreYou(JFrame parent) {
        super(parent, "id와 비밀번호를 입력하세요", true);
        setSize(300, 200);
        setLocationRelativeTo(parent);

        JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5));
        JLabel label = new JLabel("ID 입력하세요");
        JTextField idField = new JTextField();
        panel.add(label);
        panel.add(idField);

        JLabel passLabel = new JLabel("비밀번호 입력하세요");
        JPasswordField passField = new JPasswordField();
        panel.add(passLabel);
        panel.add(passField);

        JButton confirmBtn = new JButton("확인");
        panel.add(confirmBtn);
        add(panel);

        confirmBtn.addActionListener(e -> {
            String inputId = idField.getText().trim();
            String inputPw = new String(passField.getPassword());

            for (checkmem.ContactNode<String, String> node : checkmem.registeredAccounts) {
                if (node.Key.equals(inputId) && node.Value.equals(inputPw)) {
                    iamuser = true;
                    userId = inputId;
                    dispose();
                    return;
                }
            }

            JOptionPane.showMessageDialog(this, "ID 또는 비밀번호가 틀렸습니다.");
        });

        setVisible(true);
    }
}
