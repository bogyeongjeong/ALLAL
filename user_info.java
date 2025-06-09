import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;

import java.util.Map;

public class user_info extends JFrame {
    public static List<checkmem.ContactNode<String, String>> idPwList = new ArrayList<>();
    public static List<String> skintypes = new ArrayList<>();

    private String userId;
    private boolean isEditMode = false;

    public user_info(String id, boolean isEditMode) {
        this();
        this.userId = id;
        this.isEditMode = isEditMode;
        UserFileManager.loadUserFromFile(id);
    }

    public user_info() {
        setTitle("User Information");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,1,5,5));

        panel.add(new JLabel("사용자 이름"));
        JTextField username = new JTextField(15);
        panel.add(username);

        panel.add(new JLabel(" 사용자 전화번호"));
        JTextField phonenum = new JTextField(15);
        panel.add(phonenum);

        panel.add(new JLabel("사용자 피부 상태"));
        JCheckBox Oily = new JCheckBox("지성");
        JCheckBox Dry = new JCheckBox("건성");
        JCheckBox Acne = new JCheckBox("여드름성");
        JCheckBox Sensitive = new JCheckBox("민감성");
        JCheckBox DryButOily = new JCheckBox("수분 부족형 지성");

        panel.add(Oily);
        panel.add(Dry);
        panel.add(Acne);
        panel.add(Sensitive);
        panel.add(DryButOily);

        panel.add(new JLabel("알레르기 유무"));
        JButton allergy = new JButton("없으면 없음을 눌러주세요! ");
        panel.add(allergy);
        allergy.addActionListener(e -> new CheckAllForUser());

        JButton bad_coss = new JButton("안맞았던 화장품이 있었나요?");
        panel.add(bad_coss);
        bad_coss.addActionListener(e -> new bad_cos());

        JButton good_coss = new JButton("잘맞았던 화장품이 있었나요?");
        panel.add(good_coss);
        good_coss.addActionListener(e -> new good_cos());

        panel.add(new JLabel("ID/PASSWORD"));
        JTextField Id = new JTextField("아이디를 입력하세요", 15);
        panel.add(Id);
        JPasswordField password = new JPasswordField(15);
        panel.add(password);

        JButton WanttoJoin = new JButton("승인 요청");
        panel.add(WanttoJoin);

        WanttoJoin.addActionListener(e -> {
            try {
                String Username = username.getText().trim();
                String phonenumber = phonenum.getText().trim();
                String id = Id.getText().trim();
                String Password = new String(password.getPassword()).trim();

                skintypes.clear();
                if (Oily.isSelected()) skintypes.add("지성");
                if (Dry.isSelected()) skintypes.add("건성");
                if (Acne.isSelected()) skintypes.add("여드름성");
                if (Sensitive.isSelected()) skintypes.add("민감성");
                if (DryButOily.isSelected()) skintypes.add("수분 부족형 지성");

                if (!isEditMode) {
                    for (checkmem.ContactNode<String, String> acc : checkmem.registeredAccounts) {
                        if (acc.Key.equals(id)) {
                            JOptionPane.showMessageDialog(null, "이미 사용 중인 ID입니다. 다른 ID를 입력해주세요.", "중복된 ID", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                    checkmem.ContactNode<String, String> userNode = new checkmem.ContactNode<>(Username, phonenumber);
                    checkmem.ContactNode<String, String> idpwNode = new checkmem.ContactNode<>(id, Password);
                    checkmem.pendingMembers.add(userNode);
                    idPwList.add(idpwNode);
                    JOptionPane.showMessageDialog(null, "가입 요청이 저장되었습니다.");
                } else {
                    // 수정 모드일 때: 기존 정보 업데이트
                    JOptionPane.showMessageDialog(null, "정보가 수정되었습니다.");
                    // 필요 시 저장 로직 추가
                }

                dispose();

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "오류 발생");
            }
        });

        JScrollPane pane = new JScrollPane(panel);
        add(pane);
        setVisible(true);
    }
}
