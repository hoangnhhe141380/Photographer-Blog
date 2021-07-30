package controller;

import dal.GalleryDAO;
import dal.InformationDAO;
import dal.ShareDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Gallery;
import entity.Information;
import entity.Share;

@WebServlet(name = "ContactController", urlPatterns = {"/ContactController"})
public class ContactController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {

            GalleryDAO galleryDAO = new GalleryDAO();

            // Get Contact
            InformationDAO informationDAO = new InformationDAO();
            Information info = informationDAO.getInformation();
            info.setImage(info.getImage());
            request.setAttribute("info", info);

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
                request.setAttribute("error", "Data Fail !!!");
                request.getRequestDispatcher("./views/error.jsp").forward(request, response);
            } else {
                request.setAttribute("galleries", listGalleries);
            }

            //Set hight light when we stay contact page
            request.setAttribute("clickedContact", true);
            request.getRequestDispatcher("./views/contact.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("./views/error.jsp").forward(request, response);
        }
    }
}
