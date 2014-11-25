import java.sql.*;
import java.util.Scanner;

public class Update1 {
    private String _user = "s13012";
    private String _pass = "password";
    private String _host = "172.16.40.4";
    private String _sid = "db11";

    public static void main(String[] args) {

        Update1 select1 = new Update1();
        try {
            select1.select();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void select() throws Exception {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement prepare = null;
        boolean employeesExists = false;
        boolean subordinateIsExists = false;
        String sql;


        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@" + _host + ":1521:" + _sid, _user, _pass);

            System.out.print("社員番号を入力してください: ");
            int empNo = new Scanner(System.in).nextInt();

            sql = "SELECT empno, ename FROM employees WHERE empno = ?";

            prepare = conn.prepareStatement(sql);
            prepare.setInt(1, empNo);
            rs = prepare.executeQuery();

            while (rs.next()) {
                employeesExists = true;
                int emp_no = rs.getInt(1);
                String ename = rs.getString(2);

            }

            if (!employeesExists) {
                System.out.println("レコードがありません。");
            }

        } catch (ClassNotFoundException e) {
            throw e;
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
                rs = null;
            }

            if (prepare != null) {
                prepare.close();
                prepare = null;
            }

            if (conn != null) {
                conn.close();
            }
        }
    }
}
