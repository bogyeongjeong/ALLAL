import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    Login() {
        setTitle("Login");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        // 패널 만들기
        JPanel Loginpanel = new JPanel();
        Loginpanel.setLayout(new GridLayout(0, 1));

        ImageIcon allal = new ImageIcon("resource/allal-표지.jpg");
        Image scaledImage = allal.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(resizedIcon);
        Loginpanel.add(imageLabel);


        // 구성 요소 추가
        Loginpanel.add(new JLabel("ID"));
        JTextField id = new JTextField(5);
        Loginpanel.add(id);


        Loginpanel.add(new JLabel("Password"));
        JPasswordField password = new JPasswordField(5);
        Loginpanel.add(password);

        JButton LoginButton = new JButton("Login");
        Loginpanel.add(LoginButton);

        JScrollPane scroller = new JScrollPane(Loginpanel);
        add(scroller);

        JButton first=new JButton("처음 오셨나요?" );
        first.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new user_info();
            }
        });
        Loginpanel.add(first);

        setVisible(true);

        LoginButton.addActionListener(e -> {
            String enteredId = id.getText().trim();
            String enteredPw = new String(password.getPassword()).trim();

            boolean idFound = false;
            boolean loginSuccess = false;

            for (checkmem.ContactNode<String, String> acc : checkmem.registeredAccounts) {
                if (acc.Key.equals(enteredId)) {
                    idFound = true;
                    if (acc.Value.equals(enteredPw)) {
                        loginSuccess = true;
                        break;
                    }
                }
            }

            if (!idFound) {
                JOptionPane.showMessageDialog(null, "존재하지 않는 ID입니다.", "로그인 실패", JOptionPane.ERROR_MESSAGE);
            } else if (!loginSuccess) {
                JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.", "로그인 실패", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "로그인 성공!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
                new head();
                dispose();
            }
        });

    }


}
