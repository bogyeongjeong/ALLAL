
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class head extends JFrame {
    public head() {
        setTitle("메뉴 ");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel searchPanel = new JPanel(new BorderLayout(5, 5));
        JTextField searchField = new JTextField("검색어를 입력하세요(판매사제품명순으로)");
        searchPanel.add(searchField, BorderLayout.CENTER);

        JLabel search = new JLabel("검색");
        search.setHorizontalAlignment(SwingConstants.CENTER);
        search.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        search.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                String value = searchField.getText().trim();
                WhoAreYou dialog = new WhoAreYou(null);
                if (dialog.iamuser) {
                    new Search_Cos(value, dialog.userId);
                    dispose();
                }
            }
        });

        searchPanel.add(search, BorderLayout.EAST);
        searchPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBorder(BorderFactory.createTitledBorder("MENU"));

        JLabel usermenu = new JLabel("개인 정보 수정");
        JLabel usermenudes = new JLabel("개인정보를 수정");
        usermenu.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        usermenudes.setFont(new Font("맑은 고딕", Font.ITALIC, 10));
        usermenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        usermenu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                WhoAreYou dialog = new WhoAreYou(null);
                if (dialog.iamuser) {
                    new user_info(dialog.userId, true);
                }
            }
        });

        menuPanel.add(usermenu);
        menuPanel.add(usermenudes);

        JLabel adminmenu = new JLabel("새로운 제품 등록");
        JLabel adminmenudes = new JLabel("새로운 제품을 등록 (관리자 전용)");
        adminmenu.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        adminmenudes.setFont(new Font("맑은 고딕", Font.ITALIC, 10));
        adminmenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        adminmenu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                AreyouAdmin dialog = new AreyouAdmin(null);
                if (dialog.isAdmin) {
                    new CosmeticInfo();
                }
            }
        });

        menuPanel.add(adminmenu);
        menuPanel.add(adminmenudes);

        JLabel adminmenu_1 = new JLabel("회원 관리");
        JLabel adminmenu_1des = new JLabel("회원 정보 관리 (관리자 전용)");
        adminmenu_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        adminmenu_1des.setFont(new Font("맑은 고딕", Font.ITALIC, 10));
        adminmenu_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        adminmenu_1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                AreyouAdmin dialog = new AreyouAdmin(null);
                if (dialog.isAdmin) {
                    new checkmem();
                }
            }
        });

        menuPanel.add(adminmenu_1);
        menuPanel.add(adminmenu_1des);

        JLabel logout = new JLabel("로그 아웃");
        logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logout.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new Login();
                dispose();
            }
        });

        menuPanel.add(logout);

        add(searchPanel, BorderLayout.NORTH);
        add(menuPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}
