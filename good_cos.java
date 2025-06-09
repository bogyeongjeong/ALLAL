import javax.swing.*;
import java.awt.*;

public class good_cos extends JFrame {
    public good_cos() {
        setTitle("잘맞았던 화장품");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("판매사 명"));
        JTextField sellerField = new JTextField();
        panel.add(sellerField);

        panel.add(new JLabel("제품 명"));
        JTextField productField = new JTextField();
        panel.add(productField);

        JButton submitBtn = new JButton("제출");
        panel.add(submitBtn);

        submitBtn.addActionListener(e -> {
            String seller = sellerField.getText();
            String product = productField.getText();

            DBHelper db = new DBHelper();
            db.insertCosmetic(product, seller, "", "good_cosmetic");

            JOptionPane.showMessageDialog(null, "저장 완료");
            dispose();
        });

        add(panel);
        setVisible(true);
    }
}
