import java.sql.*;

public class Select1 {
    private String _user = "s13012";
    private String _pass = "password";
    private String _host = "172.16.40.4";
    private String _sid = "db11";

    public static void main(String[] args) {

        Select1 select1 = new Select1();
        try {
            select1.select();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void select() throws Exception {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement prepare = null;
        boolean empIsExists = false;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@" + _host + ":1521:" + _sid, _user, _pass);


            String sql = "SELECT emp.empno, emp.ename, emp.job, mgr.ename, dept.dname, dept.loc\n" +
                    "FROM employees emp LEFT JOIN employees mgr\n" +
                    "ON (emp.mgr = mgr.empno)\n" +
                    "LEFT JOIN departments dept\n" +
                    "ON (emp.deptno = dept.deptno)";

            prepare = conn.prepareStatement(sql);
            rs = prepare.executeQuery();

            while (rs.next()) {
                empIsExists = true;
                int emp_no = rs.getInt(1);
                String ename = rs.getString(2);
                String job = rs.getString(3);
                String mgr_name = rs.getString(4);
                String dname = rs.getString(5);
                String loc = rs.getString(6);

                System.out.printf("社員番号： %s\t社員名： %s\t職種： %s\t上司の名前： %s\t部署名： %s\t場所： %s\n",
                        emp_no, ename, job, mgr_name, dname, loc);
            }

            if (!empIsExists) {
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

            if (st != null) {
                st.close();
                st = null;
            }

            if (conn != null) {
                conn.close();
            }
        }
    }
}
