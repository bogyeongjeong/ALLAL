import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class CosmeticInfo extends JFrame {

    CosmeticInfo() {
        setTitle("화장품 정보 제출");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 600);
        setLocationRelativeTo(null);

        JPanel cosmeticpanel = new JPanel();
        cosmeticpanel.setLayout(new GridLayout(0, 1, 5, 5));


        JLabel seller = new JLabel("판매사 명");
        JTextField sellerfield = new JTextField(14);
        cosmeticpanel.add(seller);
        cosmeticpanel.add(sellerfield);

        JLabel product = new JLabel("제품명");
        JTextField productfield = new JTextField(14);
        cosmeticpanel.add(product);
        cosmeticpanel.add(productfield);

        JLabel allergycheck = new JLabel("알레르기 성질 유무");
        JButton checking = new JButton("알레르기 유무 선택 하 세요!");
        cosmeticpanel.add(allergycheck);
        cosmeticpanel.add(checking);
        checking.addActionListener(e -> new CheckAllForCos());

        JLabel special = new JLabel("특이사항 입력");
        JButton speciall = new JButton("특이사항이 있다면 눌러주세요!");
        cosmeticpanel.add(special);
        cosmeticpanel.add(speciall);
        speciall.addActionListener(e -> new Special());

        JLabel inform = new JLabel("제품 정보 입력");
        cosmeticpanel.add(inform);
        JTextArea inform2 = new JTextArea(5, 20);
        JScrollPane textScroller = new JScrollPane(inform2);
        cosmeticpanel.add(textScroller);

        JButton submit = new JButton("제출");
        cosmeticpanel.add(submit);


        JScrollPane mainScroll = new JScrollPane(cosmeticpanel);
        add(mainScroll);

        setVisible(true);

        submit.addActionListener(e -> {
            try {
                String Product_name = productfield.getText().trim();
                String Seller_name = sellerfield.getText().trim();
                BufferedWriter bw = new BufferedWriter(new FileWriter(Product_name + Seller_name + ".txt"));

                bw.write("판매사_제품명: "+ Product_name+"_" + Seller_name+ "\n");
                Main.cosmeticlist.add(Product_name+Seller_name);

                bw.write("제품 알레르기 정보: ");
                for (String alll : CheckAllForCos.Allergy_Check_C) {
                    bw.write(alll + " ");
                }
                bw.write("\n");
                bw.write("제품 특이사항 정보:\n");
                for (String spec : Special.specialthing) {
                    bw.write(spec + "\n");
                }

                bw.write("제품 정보:\n" + inform2.getText() + "\n");

                bw.close();
                JOptionPane.showMessageDialog(null, "정보가 저장되었습니다!");
                dispose();

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "저장 중 오류 발생");
            }
        });
    }


}
