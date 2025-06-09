import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class UserFileManager {


    public static void saveUserToFile(String id, String name, String phone, String password,
                                      List<String> skinTypes,
                                      List<String> allergies,
                                      List<String> badCosmetics,
                                      List<String> goodCosmetics) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(id + ".txt"));
            bw.write("이름:" + name + "\n");
            bw.write("전화번호:" + phone + "\n");
            bw.write("id:" + id + "\n");
            bw.write("password:" + password + "\n");
            bw.write("피부타입:" + (skinTypes != null && !skinTypes.isEmpty() ? String.join(", ", skinTypes) : "없음") + "\n");
            bw.write("알레르기:" + (allergies != null && !allergies.isEmpty() ? String.join(", ", allergies) : "없음") + "\n");
            bw.write("안맞았던 화장품:" + (badCosmetics != null && !badCosmetics.isEmpty() ? String.join(", ", badCosmetics) : "없음") + "\n");
            bw.write("잘맞았던 화장품:" + (goodCosmetics != null && !goodCosmetics.isEmpty() ? String.join(", ", goodCosmetics) : "없음") + "\n");
            bw.close();
            JOptionPane.showMessageDialog(null, "정보가 성공적으로 저장되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "파일 저장 중 오류가 발생했습니다.");
        }
    }

    // 사용자 정보 불러오기 메서드
    public static Map<String, String> loadUserFromFile(String id) {
        Map<String, String> userData = new HashMap<>();
        File file = new File(id + ".txt");

        if (!file.exists()) {
            JOptionPane.showMessageDialog(null, "사용자 정보 파일이 존재하지 않습니다.");
            return null;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":", 2);
                if (parts.length == 2) {
                    userData.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "파일 불러오기 중 오류가 발생했습니다.");
        }

        return userData;
    }
}
