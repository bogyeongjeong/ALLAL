import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CheckAllForUser extends JFrame {
    public static ArrayList<String> Allergy_Check=new ArrayList<String>();
    CheckAllForUser(){
        setTitle("allergy check_for user");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 500);
        setLocationRelativeTo(null);
        JPanel checkPanel = new JPanel();
        JScrollPane Scrolll = new JScrollPane(checkPanel);
        add(Scrolll);
        setVisible(true);
        checkPanel.setLayout(new GridLayout(0,1));
        JCheckBox Allergy = new JCheckBox("없음");
        checkPanel.add(Allergy);
        JCheckBox checkBox1 = new JCheckBox("아밀신남알");
        checkPanel.add(checkBox1);
        JCheckBox checkBox2 = new JCheckBox("벤질알코올");
        checkPanel.add(checkBox2);
        JCheckBox checkBox3 = new JCheckBox("신나밀알코올");
        checkPanel.add(checkBox3);
        JCheckBox checkBox4 = new JCheckBox("시트랄");
        checkPanel.add(checkBox4);
        JCheckBox checkBox5 = new JCheckBox("유제놀");
        checkPanel.add(checkBox5);
        JCheckBox checkBox6 = new JCheckBox("하이드록시시트로넬알");
        checkPanel.add(checkBox6);
        JCheckBox checkBox7=new JCheckBox("아이소유제놀");
        checkPanel.add(checkBox7);
        JCheckBox checkBox8= new JCheckBox("아밀신나밀알코올");
        checkPanel.add(checkBox8);
        JCheckBox checkBox9=new JCheckBox("벤질살리실레이트");
        checkPanel.add(checkBox9);
        JCheckBox checkBox10=new JCheckBox("신남알");
        checkPanel.add(checkBox10);
        JCheckBox checkBox11=new JCheckBox("쿠마린");
        checkPanel.add(checkBox11);
        JCheckBox checkBox12=new JCheckBox("제라니올");
        checkPanel.add(checkBox12);
        JCheckBox checkBox13=new JCheckBox("아니스알코올");
        checkPanel.add(checkBox13);
        JCheckBox checkBox14=new JCheckBox("벤질신나메이트");
        checkPanel.add(checkBox14);
        JCheckBox checkBox15=new JCheckBox("파네솔");
        checkPanel.add(checkBox15);
        JCheckBox checkBox16=new JCheckBox("부틸페닐메틸프로피오날");
        checkPanel.add(checkBox16);
        JCheckBox checkBox17=new JCheckBox("리날룰");
        checkPanel.add(checkBox17);
        JCheckBox checkBox18=new JCheckBox("벤질벤조에이트");
        checkPanel.add(checkBox18);
        JCheckBox checkBox19=new JCheckBox("시트로넬올");
        checkPanel.add(checkBox19);
        JCheckBox checkBox20=new JCheckBox("헥실신남알");
        checkPanel.add(checkBox20);
        JCheckBox checkBox21=new JCheckBox("리모넨");
        checkPanel.add(checkBox21);
        JCheckBox checkBox22=new JCheckBox("메틸2-옥티노에이트");
        checkPanel.add(checkBox22);
        JCheckBox checkBox23=new JCheckBox("알파-아이소메틸아이오논");
        checkPanel.add(checkBox23);
        JCheckBox checkBox24=new JCheckBox("참나무 이끼 추출물(아트라놀)");
        checkPanel.add(checkBox24);
        JCheckBox checkBox25=new JCheckBox("나무이끼추출물(클로로아트라놀");
        checkPanel.add(checkBox25);
        JCheckBox checkBox26=new JCheckBox("하이드록시이소헥실 3-사이클로헥센카복스알데히드(HICC)");
        checkPanel.add(checkBox26);

        JButton submitt=new JButton("제출");
        checkPanel.add(submitt);

        submitt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Allergy.isSelected()){Allergy_Check.add("없음");}
                if(checkBox1.isSelected()){Allergy_Check.add("아밀신남알");}
                if(checkBox2.isSelected()){Allergy_Check.add("벤질알코올");}
                if(checkBox3.isSelected()){Allergy_Check.add("신나밀알코올");}
                if(checkBox4.isSelected()){Allergy_Check.add("시트랄");}
                if(checkBox5.isSelected()){Allergy_Check.add("유제놀");}
                if(checkBox6.isSelected()){Allergy_Check.add("하이드록시시트로넬알");}
                if(checkBox7.isSelected()){Allergy_Check.add("아이소유제놀");}
                if(checkBox8.isSelected()){Allergy_Check.add("아밀신나밀알코올");}
                if(checkBox9.isSelected()){Allergy_Check.add("벤질살리레이트");}
                if(checkBox10.isSelected()){Allergy_Check.add("신남알");}
                if(checkBox11.isSelected()){Allergy_Check.add("쿠마린");}
                if(checkBox12.isSelected()){Allergy_Check.add("제라니올");}
                if(checkBox13.isSelected()){Allergy_Check.add("아니스알코올");}
                if(checkBox14.isSelected()){Allergy_Check.add("벤질신나메이트");}
                if(checkBox15.isSelected()){Allergy_Check.add("파네솔");}
                if(checkBox16.isSelected()){Allergy_Check.add("부틸페닐메틸프로피오날");}
                if(checkBox17.isSelected()){Allergy_Check.add("리날룰");}
                if(checkBox18.isSelected()){Allergy_Check.add("벤질벤조에이트");}
                if(checkBox19.isSelected()){Allergy_Check.add("시트로넬올");}
                if(checkBox20.isSelected()){Allergy_Check.add("헥실신남알");}
                if(checkBox21.isSelected()){Allergy_Check.add("리모넨");}
                if(checkBox22.isSelected()){Allergy_Check.add("메틸2-옥티노에이트");}
                if(checkBox23.isSelected()){Allergy_Check.add("알파-아이소메틸아이오논");}
                if(checkBox24.isSelected()){Allergy_Check.add("참나무이끼추출물(=아트라놀)");}
                if(checkBox25.isSelected()){Allergy_Check.add("나무이끼추출물(=클로로아트라놀)");}
                if(checkBox26.isSelected()){Allergy_Check.add("하이드록시이헥실 3-사이클로헥센카복스알데히드(HICC)");}

                JOptionPane.showMessageDialog(null, "정보가 저장되었습니다!");
                dispose();


            }
        });






    }
}
