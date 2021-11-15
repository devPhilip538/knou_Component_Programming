package com.springbook.biz.common;

import java.sql.*;

public class JDBCUtil {
    /* 오승필/202184-010073 */
    public static Connection getConnection () {
        try {
            Class.forName("org.h2.Driver");
            return DriverManager.getConnection(
                    "jdbc:h2:tcp://localhost/~/test",
                    "sa",
                    "sa");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /* 오승필/202184-010073 */
    public static void close(PreparedStatement stmt, Connection conn) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch(Exception e) {
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch(Exception e) {
        }
    }
    /* 오승필/202184-010073 */
    public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch(Exception e) {

        } finally {
            rs = null;
        }
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch(Exception e) {

        } finally {
            stmt = null;
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch(Exception e) {

        } finally {
            conn = null;
        }
    }
}
