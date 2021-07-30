package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import entity.Gallery;
import db.DBContext;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GalleryDAO extends DBContext{

    /**
     * Get Top Gallery.<br>
     *
     * @param topNumber the number of Gallery. It is a <code>int</code> primitive type
     * @return list top galleries.
     * @throws java.lang.Exception
     */
    public List<Gallery> getTopGallery(int topNumber) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "Select top (?) * from Gallery";
        List<Gallery> list = new ArrayList<>();

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, topNumber);
            rs = ps.executeQuery();
            while (rs.next()) {
                Gallery ga = new Gallery(rs.getInt("id"),
                                        rs.getString("name"),
                                        rs.getString("description"),
                                        getImagePath() + rs.getString("image"));
                list.add(ga);
            }
        } catch (Exception e) {
            Logger.getLogger(GalleryDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    /**
     * Paginate the pictures from Db.<br>
     *
     * @param pageIndex the index of page. It is a <code>int</code> primitive type
     * @param pageSize the size of page. It is a <code>int</code> primitive type
     * @return list pictures which need to paginate.
     * @throws java.lang.Exception
     */
    public List<Gallery> pagging(int pageIndex, int pageSize) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Gallery> list = new ArrayList<>();
        //get value between start to end
        int start = (pageIndex - 1) * pageSize + 1;
        int end = pageIndex * pageSize;
        String sql = "select * from (select ROW_NUMBER() over (order by id ASC) as No,\n"
                + " * from Gallery) as x where No between ? and ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, start);
            ps.setObject(2, end);
            rs = ps.executeQuery();
            while (rs.next()) {
                Gallery g = new Gallery(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        getImagePath() + rs.getString("image"));
                list.add(g);
            }
            return list;
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(GalleryDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     * Count Number Of Result Gallery by their id<br>
     *
     * @return count.
     * @throws java.lang.Exception
     */
    public int numberOfResult() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "Select count(id) from Gallery";
        int count = 0;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(GalleryDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        return count;
    }

    /**
     * Get Gallery By their ID.<br>
     *
     * @param id the id of Gallery. It is a <code>int</code> primitive type
     * @return get the gallery by id.
     * @throws java.lang.Exception
     */
    public Gallery getGalleryByID(int id) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from Gallery where id = ?";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Gallery ga = new Gallery(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("image"));

                return ga;
            }
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(GalleryDAO.class.getName()).log(Level.SEVERE, null, e);  
        }
        return null;
    }
}
