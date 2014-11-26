import java.sql.*;
import java.util.*;

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
        boolean isUpdated = false;
        boolean isMismatch = false;
        String sql;
        ResultSetMetaData metaData = null;
        Map<Object, Object> empMap = new LinkedHashMap<Object, Object>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@" + _host + ":1521:" + _sid, _user, _pass);

            int empNo = 0;
            System.out.print("社員番号を入力してください: ");
            try {
                empNo = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.err.println("社員番号の値が不正です。");
                isMismatch = true;
            }

            if (!isMismatch) {
                sql = "SELECT ename, yomi, job, mgr, hiredate, sal, comm, deptno\n" +
                        "FROM employees WHERE empno = ?";

                prepare = conn.prepareStatement(sql);
                prepare.setInt(1, empNo);
                rs = prepare.executeQuery();
                metaData = rs.getMetaData();

                int counter = 0;
                while (rs.next()) {
                    employeesExists = true;
                    empMap.put(metaData.getColumnName(++counter), rs.getObject(counter));
                    empMap.put(metaData.getColumnName(++counter), rs.getObject(counter));
                    empMap.put(metaData.getColumnName(++counter), rs.getObject(counter));
                    empMap.put(metaData.getColumnName(++counter), rs.getObject(counter));
                    empMap.put(metaData.getColumnName(++counter), rs.getDate(counter));
                    empMap.put(metaData.getColumnName(++counter), rs.getObject(counter));
                    empMap.put(metaData.getColumnName(++counter), rs.getObject(counter));
                    empMap.put(metaData.getColumnName(++counter), rs.getObject(counter));
                }

                if (employeesExists) {
                    for (int i = 1; i <= empMap.size(); i++) {
                        String column = metaData.getColumnName(i);
                        Object field = empMap.get(metaData.getColumnName(i));
                        System.out.println(column + ": " + field);

                        System.out.print("変更しますか? (yes/no): ");

                        String updateConfirm = new Scanner(System.in).nextLine();
                        if (updateConfirm.equals("yes")) {
                            System.out.print(column + " = ");
                            Object newValue = new Scanner(System.in).nextLine();
                            empMap.put(column, newValue);
                            isUpdated = true;
                        }
                    }

                    if (isUpdated) {
                        sql = "UPDATE employees\n" +
                                "SET ename = ?, yomi = ?, job = ?, mgr = ?, hiredate = ?, sal = ?," +
                                "comm = ?, deptno = ?\n" +
                                "WHERE empno = " + empNo;

                        prepare = conn.prepareStatement(sql);

                        for (int i = 1; i <= empMap.size(); i++) {
                            Object newField = metaData.getColumnName(i);
                            prepare.setObject(i, empMap.get(newField));
                        }

                        try {
                            prepare.executeQuery();
                        } catch (SQLIntegrityConstraintViolationException e) {
                            System.err.println(e.getMessage());
                            isUpdated = false;
                        } catch (SQLDataException e) {
                            isUpdated = false;
                            System.err.println(e.getMessage());
                        } catch (SQLSyntaxErrorException e) {
                            isUpdated = false;
                            System.err.println(e.getMessage());
                        }

                        if (isUpdated) {
                            System.out.println("\n▼ 社員番号" + empNo + "を以下のように更新しました。 ▼");
                            for (int i = 1; i <= empMap.size(); i++) {
                                String column = metaData.getColumnName(i);
                                Object field = empMap.get(metaData.getColumnName(i));
                                System.out.println(column + ": " + field);
                            }
                        }
                    }
                } else {
                    System.out.println("レコードがありません。");
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
