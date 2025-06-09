
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Search_Cos extends JFrame {
    public Search_Cos(String cosName, String userId) {
        setTitle("검색 결과: " + cosName);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        add(panel);

        JButton goback = new JButton("home");
        goback.addActionListener(e -> {
            new head(); // userId 제거
            dispose();
        });
        panel.add(goback, BorderLayout.SOUTH);

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:allal_user.db")) {
            String sql = "SELECT * FROM cosmetics WHERE name = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cosName);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String allergies = rs.getString("allergies");
                String notes = rs.getString("special_notes");

                ImageIcon icon = new ImageIcon("resource/" + cosName + ".png");
                JLabel imageLabel = new JLabel(icon);
                panel.add(imageLabel, BorderLayout.WEST);

                JButton moreInfo = new JButton("상품 정보 더보기");
                moreInfo.addActionListener(e -> new Cos_info_provider(cosName));
                panel.add(moreInfo, BorderLayout.EAST);

                boolean hasWarning = false;
                boolean hasRecommendation = false;

                List<String> productIngredients = parseCSV(allergies);

                hasWarning = hasMatch(conn, "bad_cos", userId, productIngredients);
                hasRecommendation = hasMatch(conn, "good_cos", userId, productIngredients);

                if (hasWarning) {
                    JButton warningBtn = new JButton("주의");
                    warningBtn.setForeground(Color.RED);
                    panel.add(warningBtn, BorderLayout.NORTH);
                    warningBtn.addActionListener(e -> new WarRec(userId).setVisible(true));
                }

                if (hasRecommendation) {
                    JButton recommendBtn = new JButton("추천");
                    recommendBtn.setForeground(Color.BLUE);
                    panel.add(recommendBtn, BorderLayout.CENTER);
                    recommendBtn.addActionListener(e -> new WarRec(userId).setVisible(true));
                }
            } else {
                JOptionPane.showMessageDialog(this, "해당 화장품을 찾을 수 없습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    private List<String> parseCSV(String input) {
        List<String> list = new ArrayList<>();
        if (input == null) return list;
        for (String s : input.split(",")) {
            list.add(s.trim());
        }
        return list;
    }

    private boolean hasMatch(Connection conn, String table, String userId, List<String> ingredients) {
        String sql = "SELECT ingredient FROM " + table + " WHERE user_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String ing = rs.getString("ingredient");
                for (String s : ingredients) {
                    if (s.contains(ing) || ing.contains(s)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("DB 오류 in " + table + ": " + e.getMessage());
        }
        return false;
    }
}
