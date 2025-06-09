
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DBHelper {
    private static final String DB_URL = "jdbc:sqlite:allal_user.db";

    public static void initDatabase() {
        createUserTable();
        createCosmeticTable();
        createGoodCosTable();
        createBadCosTable();
    }

    private static Connection connect() throws Exception {
        return DriverManager.getConnection(DB_URL);
    }

    private static void createUserTable() {
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS user_info (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "user_id TEXT UNIQUE NOT NULL, " +
                    "password TEXT NOT NULL, " +
                    "name TEXT, " +
                    "gender TEXT, " +
                    "age INTEGER, " +
                    "allergy TEXT)";
            stmt.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createCosmeticTable() {
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS cosmetics (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT NOT NULL, " +
                    "seller TEXT NOT NULL, " +
                    "allergies TEXT, " +
                    "special_notes TEXT, " +
                    "UNIQUE(name, seller))";
            stmt.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createGoodCosTable() {
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS good_cos (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "user_id TEXT, " +
                    "ingredient TEXT)";
            stmt.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createBadCosTable() {
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS bad_cos (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "user_id TEXT, " +
                    "ingredient TEXT)";
            stmt.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertCosmetic(String name, String seller, String allergies, String notes) {
        String sql = "INSERT INTO cosmetics(name, seller, allergies, special_notes) VALUES (?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, seller);
            pstmt.setString(3, allergies);
            pstmt.setString(4, notes);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("화장품 등록 실패: " + e.getMessage());
        }
    }



}
