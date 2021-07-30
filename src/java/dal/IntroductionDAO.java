package dal;

import db.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import entity.Introduction;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IntroductionDAO extends DBContext {

    /**
     * Get the Introduction of Manager to show on Contact.<br>
     *
     * @return the introduction.
     * @throws java.lang.Exception
     */
    public Introduction getIntroduction() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from Intro";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                Introduction intro = new Introduction(getImagePath() + rs.getString("image"),
                        rs.getString("entry"),
                        rs.getString("aboutme"));
                return intro;
            }
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(IntroductionDAO.class.getName()).log(Level.SEVERE, null, e);  
        }
        return null;
    }
}
