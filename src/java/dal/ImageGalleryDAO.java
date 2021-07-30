package dal;

import db.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import entity.ImageGallery;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImageGalleryDAO extends DBContext{

    /**
     * get Image from Gallery by Gallery Id<br>
     *
     * @param id the id image of Gallery. It is a <code>int</code> primitive type
     * @return all image of a gallery .
     * @throws java.lang.Exception
     */
    public List<ImageGallery> getImageByGallery(int id) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from ImageGallery where gallery_id = ?";
        List<ImageGallery> list = new ArrayList<>();

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                ImageGallery ig = new ImageGallery(getImagePath() + rs.getString("image"), rs.getInt("gallery_id"));
                list.add(ig);
            }
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(ImageGalleryDAO.class.getName()).log(Level.SEVERE, null, e); 
        }

        return list;
    }

    /**
     * Pagination with pageIndex, pageSize by Gallery and GalleryID.<br>
     *
     * @param pageIndex the index of page. It is a <code>int</code> primitive type
     * @param pageSize the size of page. It is a <code>int</code> primitive type
     * @param galleryId the id of a Gallery. It is a <code>int</code> primitive type
     * @return list pictures which need to paginate.
     * @throws java.lang.Exception
     */
    public List<ImageGallery> pagging(int pageIndex, int pageSize, int galleryId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<ImageGallery> list = new ArrayList<>();
        //get value between start to end
        int start = (pageIndex - 1) * pageSize + 1;
        int end = pageIndex * pageSize;
        String sql = "select * from (select ROW_NUMBER() over (order by gallery_id ASC) as No,\n"
                + "                * from ImageGallery where gallery_id = ?) as x where No between ? and ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, galleryId);
            ps.setObject(2, start);
            ps.setObject(3, end);
            rs = ps.executeQuery();
            while (rs.next()) {
                ImageGallery g = new ImageGallery(getImagePath() + rs.getString("image"),
                        rs.getInt("gallery_id"));
                list.add(g);
            }
            return list;
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(ImageGalleryDAO.class.getName()).log(Level.SEVERE, null, e); 
        }
        return null;
    }

    /**
     * Get Number Of Image Gallery by GalleryId to count image<br>
     *
     * @param galleryId the id of a Gallery. It is a <code>java.lang.Integer</code> primitive type
     * @return count.
     * @throws java.lang.Exception
     */
    public int numberOfResult(int galleryId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "Select count(gallery_id) from ImageGallery where gallery_id = ?";
        int count = 0;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, galleryId);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(ImageGalleryDAO.class.getName()).log(Level.SEVERE, null, e); 
        }
        return count;
    }
    
    
}
