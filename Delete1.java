import java.sql.*;
import java.util.Scanner;

public class Delete1 {
    private String _user = "s13012";
    private String _pass = "password";
    private String _host = "172.16.40.4";
    private String _sid = "db11";

    public static void main(String[] args) {

        Delete1 select1 = new Delete1();
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

            sql = "SELECT empno, ename FROM emp_copy WHERE empno = ?";

            prepare = conn.prepareStatement(sql);
            prepare.setInt(1, empNo);
            rs = prepare.executeQuery();

            while (rs.next()) {
                System.out.println("▼　従業員　▼");
                employeesExists = true;
                int emp_no = rs.getInt(1);
                String ename = rs.getString(2);

                System.out.printf("社員番号： %s\t社員名： %s\n",
                        emp_no, ename);
            }

            if (employeesExists) {
                System.out.println("▼　部下　▼");
            } else {
                System.out.println("レコードがありません。");
            }

            sql = "SELECT ename FROM emp_copy WHERE mgr = ?";

            prepare = conn.prepareStatement(sql);
            prepare.setInt(1, empNo);
            rs = prepare.executeQuery();


            while (rs.next()) {
                subordinateIsExists = true;
                String ename = rs.getString(1);

                System.out.printf("社員名： %s\n", ename);
            }

            if (employeesExists && !subordinateIsExists) {
                System.out.println("部下はいません。");
            }

            if (employeesExists) {
                System.out.print("この従業員のレコードを削除しますか? (yes/no): ");
                String deleteConfirm = new Scanner(System.in).next();

                if (deleteConfirm.equals("yes")) {
                    if (subordinateIsExists) {
                        System.out.println("部下が存在する為、レコードを削除できませんでした。");
                    } else {
                        sql = "DELETE FROM emp_copy WHERE empno = ?";
                        prepare = conn.prepareStatement(sql);
                        prepare.setInt(1, empNo);
                        prepare.executeQuery();

                        System.out.println("レコードを削除しました。");
                    }
                } else if (!deleteConfirm.equals("no")) {
                    System.out.println("入力された値が不正です。");
                }
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
