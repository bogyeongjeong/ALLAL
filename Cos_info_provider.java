import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cos_info_provider extends JFrame {
    public Cos_info_provider(String productname) {
        super("설명 더보기");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1,5,5));

        JLabel jepoom = new JLabel("제품 설명 더보기");
        jepoom.setFont(new Font("맑은고딕", Font.PLAIN, 20));
        jepoom.setForeground(Color.BLACK);
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textArea);
        panel.add(jepoom);
        panel.add(scroll);

        try{

            BufferedReader fr=new BufferedReader(new FileReader(productname+".txt"));
            String line;

            while((line=fr.readLine())!=null){
                textArea.append(line+"\n");
            }
            fr.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,"파일을 불러오는 데 실패했습니다");
        }
        JButton okay=new JButton("확인");
        okay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(panel);
        setVisible(true);

    }





}
