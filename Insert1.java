import java.sql.*;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Insert1 {
    private String _user = "s13012";
    private String _pass = "password";
    private String _host = "172.16.40.4";
    private String _sid = "db11";

    public static void main(String[] args) {

        Insert1 select1 = new Insert1();
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
        String sql;
        Map<String, Object> empMap = new LinkedHashMap<String, Object>();
        String[] columnName = {"ename", "yomi", "job", "mgr", "hiredate", "sal", "comm", "deptno"};
        int empNoLast = 0;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@" + _host + ":1521:" + _sid, _user, _pass);

            sql = "SELECT empno FROM employees ORDER BY empno";

            prepare = conn.prepareStatement(sql);
            rs = prepare.executeQuery();

            while (rs.next()) {
                empNoLast = rs.getInt(1) + 1;
            }

            System.out.println("社員情報を入力してください。");
            for (int i = 0; i < columnName.length; i++) {
                System.out.print(columnName[i] + " = " );
                String newValue = new Scanner(System.in).nextLine();

                empMap.put(columnName[i], newValue);
            }

            sql = "INSERT INTO employees(empno, ename, yomi, job, mgr, hiredate, sal, comm, deptno)\n" +
                    "VALUES (" + empNoLast + ", ?, ?, ?, ?, ?, ?, ?, ?)";

            prepare = conn.prepareStatement(sql);

            for (int i = 1; i < columnName.length + 1; i++) {
                prepare.setObject(i, empMap.get(columnName[i - 1]));
            }

            try {
                prepare.executeQuery();
                System.out.println("\n▼ １行追加しました。 ▼");
                for (int i = 1; i <= empMap.size(); i++) {
                    String key = (String) empMap.get(columnName[i - 1]);
                    String result;

                    if (key.isEmpty()) {
                        result = columnName[i - 1] + ": null";
                    } else {
                        result = columnName[i - 1] + ": " + empMap.get(columnName[i - 1]);
                    }

                    System.out.println(result);
                }
            } catch (SQLIntegrityConstraintViolationException e) {
                System.err.println(e.getMessage());
            } catch (SQLDataException e) {
                System.err.println(e.getMessage());
            } catch (SQLSyntaxErrorException e) {
                System.err.println(e.getMessage());
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
