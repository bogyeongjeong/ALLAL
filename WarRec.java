
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class WarRec extends JFrame {
    private JTextArea textArea;

    public WarRec(String userId) {
        setTitle("피부 전쟁 기록");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        loadWarnings(userId);
    }

    private void loadWarnings(String userId) {
        String sql = "SELECT ingredient FROM bad_cos WHERE user_id = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:allal_user.db");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();

            StringBuilder sb = new StringBuilder("⚠ 사용자 알레르기 성분 목록:\n\n");
            while (rs.next()) {
                sb.append("- ").append(rs.getString("ingredient")).append("\n");
            }

            if (sb.toString().endsWith("목록:\n\n")) {
                textArea.setText("등록된 알레르기 성분이 없습니다.");
            } else {
                textArea.setText(sb.toString());
            }

        } catch (SQLException e) {
            textArea.setText("DB 오류: " + e.getMessage());
        }
    }


}
