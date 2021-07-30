package dal;

import db.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import entity.Information;
import dal.InformationDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InformationDAO extends DBContext{

    /**
     * Get Information of the Manager to show on Contact.<br>
     *
     * @return the information.
     * @throws java.lang.Exception
     */
    public Information getInformation() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from Information";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                Information info = new Information(rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("country"),
                        rs.getString("tel"),
                        rs.getString("email"),
                        getImagePath() + rs.getString("image"));

                return info;
            }

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(InformationDAO.class.getName()).log(Level.SEVERE, null, e);  
        }
        return null;
    }
}
