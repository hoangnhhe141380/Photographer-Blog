package dal;

import db.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import entity.Share;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShareDAO extends DBContext {

    /**
     * Get icon from database to introduce the table Share to social Network.<br>
     *
     * @return the share.
     * @throws java.lang.Exception
     */
    public List<Share> getShare() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from Share";
        List<Share> list = new ArrayList<>();

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Share sh = new Share(getImagePath() + rs.getString("icon"),
                        rs.getString("social_network"), rs.getString("url"));

                list.add(sh);
            }
        } catch (Exception e) {
            Logger.getLogger(ShareDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }
}
