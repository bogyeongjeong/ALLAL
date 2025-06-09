import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Special extends JFrame {
    public static ArrayList<String> specialthing = new ArrayList<>();

    public Special() {
        setTitle("Special");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 600);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        JScrollPane scroller = new JScrollPane(panel);
        add(scroller);

        //pa
        JLabel PA = new JLabel("PA");
        panel.add(PA);
        JTextField pa = new JTextField(12);
        panel.add(pa);

        // 기능성
        JLabel Cosmedic = new JLabel("기능성");
        panel.add(Cosmedic);
        JTextField cosmedic = new JTextField(12);
        panel.add(cosmedic);

        // 타입
        JLabel type = new JLabel("타입");
        panel.add(type);
        JTextField type1 = new JTextField(12);
        panel.add(type1);

        // 비건
        JLabel vegan = new JLabel("비건 인증");
        panel.add(vegan);
        JCheckBox veganok = new JCheckBox("비건제품이면 체크하세요");
        panel.add(veganok);

        // 향
        JLabel perf = new JLabel("향");
        panel.add(perf);
        JTextField perf1 = new JTextField(12);
        panel.add(perf1);

        // 의약외품
        JLabel medical = new JLabel("의약외품 여부");
        panel.add(medical);
        JCheckBox medicalok = new JCheckBox("의약외품이면 체크하세요.");
        panel.add(medicalok);

        // pH
        JLabel PH = new JLabel("PH 수치");
        panel.add(PH);
        JTextField ph1 = new JTextField(12);
        panel.add(ph1);

        // 논코메도제닉
        JLabel Noncomedogenic = new JLabel("논코메도제닉");
        panel.add(Noncomedogenic);
        JCheckBox Noncomedogenicok = new JCheckBox("논코메도제닉 제품이면 체크하세요");
        panel.add(Noncomedogenicok);

        // 흡수력
        JLabel absorp = new JLabel("흡수력");
        panel.add(absorp);

        final String[] absorption = {""};

        JButton fast = new JButton("젤타입-Fast");
        fast.addActionListener(e -> absorption[0] = "Fast");
        panel.add(fast);

        JButton normal = new JButton("로션-Normal");
        normal.addActionListener(e -> absorption[0] = "Normal");
        panel.add(normal);

        JButton slow = new JButton("크림-Slow");
        slow.addActionListener(e -> absorption[0] = "Slow");
        panel.add(slow);

        JButton deep = new JButton("오일-Deep");
        deep.addActionListener(e -> absorption[0] = "Deep");
        panel.add(deep);

        // Renewal
        JLabel renewal = new JLabel("Renewal 여부");
        panel.add(renewal);
        JCheckBox renew = new JCheckBox("Renewal이 됐으면 체크하세요.");
        panel.add(renew);

        // 호수
        JLabel color = new JLabel("호수");
        panel.add(color);
        JTextField color1 = new JTextField(12);
        panel.add(color1);

        // 완료 버튼
        JButton done = new JButton("완료");
        panel.add(done);

        done.addActionListener(e -> {
            String PAlevel = pa.getText().trim();
            String cosmediclevel = cosmedic.getText().trim();
            String costype = type1.getText().trim();
            String perftype = perf1.getText().trim();
            String phlevel = ph1.getText().trim();
            String colortype = color1.getText().trim();

            String veganism = veganok.isSelected() ? "비건 제품" : "비건 제품 아님";
            String medicalism = medicalok.isSelected() ? "의약외품" : "의약외품 아님";
            String noncomedogenic = Noncomedogenicok.isSelected() ? "논코메도제닉임" : "논코메도제닉아님";
            String renewok = renew.isSelected() ? "Renewal 됨" : "Renewal 아님";

            specialthing.clear();
            specialthing.add(PAlevel);
            specialthing.add(cosmediclevel);
            specialthing.add(costype);
            specialthing.add(veganism);
            specialthing.add(perftype);
            specialthing.add(medicalism);
            specialthing.add(phlevel);
            specialthing.add(noncomedogenic);
            specialthing.add(absorption[0]);
            specialthing.add(renewok);
            specialthing.add(colortype);

            JOptionPane.showMessageDialog(null, "입력 완료! 총 " + specialthing.size() + "개의 항목이 저장되었습니다.");
            dispose();
        });

        setVisible(true);
    }


}
