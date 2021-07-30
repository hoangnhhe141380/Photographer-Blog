package dal;

import db.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewCountDAO extends DBContext {

    /**
     * Get View which User access to the Website.<br>
     *
     * @return count the View.
     * @throws java.lang.Exception
     */
    public int getViewsCount() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM [View]";
        int count = 0;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(ViewCountDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return -1;
    }

    /**
     * Update View which User access to the Website.<br>
     *
     * @throws java.lang.Exception
     */
    public void updateViewsCount() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "UPDATE [View]\n"
                + "SET viewed = viewed + 1";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(ViewCountDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
