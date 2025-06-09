
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class checkmem extends JFrame {

    public static List<ContactNode<String, String>> pendingMembers = new ArrayList<>();
    public static List<ContactNode<String, String>> registeredAccounts = new ArrayList<>();

    static {
        registeredAccounts.add(new ContactNode<>("first11", "1234567"));
    }

    public static class ContactNode<K, V> {
        public K Key;
        public V Value;

        public ContactNode(K key, V value) {
            this.Key = key;
            this.Value = value;
        }
    }

    public checkmem() {
        setTitle("멤버 관리");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        JPanel panel = new JPanel(new GridLayout(0, 1));

        JButton checkNew = new JButton("새 요청 보기");
        checkNew.addActionListener(e -> {
            for (int i = 0; i < pendingMembers.size(); i++) {
                ContactNode<String, String> user = pendingMembers.get(i);
                ContactNode<String, String> idpw = user_info.idPwList.get(i);
                new newvisitor(user.Key, idpw.Value); // fixed to use String args
            }
        });

        panel.add(checkNew);
        add(panel);
        setVisible(true);
    }
}
