package controller;

import dal.GalleryDAO;
import dal.ImageGalleryDAO;
import dal.ShareDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Gallery;
import entity.ImageGallery;
import entity.Share;

@WebServlet(name = "GalleryController", urlPatterns = {"/GalleryController"})
public class GalleryController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {           
            GalleryDAO galleryDAO = new GalleryDAO();

            // Get GalleryID
            int id;
            try {
                id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("id", id);
            } catch (NumberFormatException e) {
                id = -1;
            }

            // Get images
            ImageGalleryDAO imageGalleryDAO = new ImageGalleryDAO();

            // Begin of get txtSearch and pageRow
            String txtPage = request.getParameter("txtPage");
            int indexPage = 1;
            if (txtPage != null) {
                try {
                    indexPage = Integer.parseInt(txtPage);
                } catch (NumberFormatException e) {
                    indexPage = -1;
                }
            }
            // End of get txtSearch and pageRow
            int pageSize = 8;

            if (indexPage != -1 && id != -1) {
                Gallery gal = galleryDAO.getGalleryByID(id);
                gal.setImage(gal.getImage());
                int rowCount = imageGalleryDAO.numberOfResult(id);
                int maxPage = (int) Math.ceil((double) rowCount / pageSize);

                if (indexPage <= maxPage) {
                    List<ImageGallery> listImageGallary = imageGalleryDAO.pagging(indexPage, pageSize, id);
                    listImageGallary.forEach((g) -> {
                        g.setImage(g.getImage());
                    });
                    request.setAttribute("imgs", listImageGallary);
                    request.setAttribute("maxPage", maxPage);
                    request.setAttribute("pageIndex", indexPage);
                    request.setAttribute("gal", gal);
                } else {
                    request.setAttribute("error", "This page not found");
                    request.getRequestDispatcher("./views/error.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("error", "This page not found");
                request.getRequestDispatcher("./views/error.jsp").forward(request, response);
            }

            //Get Share
            ShareDAO shareDAO = new ShareDAO();
            List<Share> shs = shareDAO.getShare();
            if (shs.isEmpty()) {
                request.setAttribute("error", "Data share error");
                request.getRequestDispatcher("./views/error.jsp").forward(request, response);
            } else {
                //Set image for each share element
                shs.forEach((s) -> {
                    s.setIcon(s.getIcon());
                });
                request.setAttribute("shs", shs);
            }

            List<Gallery> listGalleries = galleryDAO.getTopGallery(3);

            if (listGalleries.isEmpty()) {
                request.setAttribute("error", "Data  Fail !!!");
                request.getRequestDispatcher("./views/error.jsp").forward(request, response);
            } else {
                request.setAttribute("galleries", listGalleries);
            }
            

            request.getRequestDispatcher("./views/gallery.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("./views/error.jsp").forward(request, response);
        }
    }
}
