package controller;

import dal.GalleryDAO;
import dal.IntroductionDAO;
import dal.ShareDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Gallery;
import entity.Introduction;
import entity.Share;

@WebServlet(name = "HomeController", urlPatterns = {"/HomeController"})
public class HomeController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");         
        try {
            GalleryDAO galleryDAO = new GalleryDAO();

            //Get index page
            String page = request.getParameter("page");
            int indexPage = 1;
            if (page != null) {
                try {
                    indexPage = Integer.parseInt(page);
                } catch (NumberFormatException e) {
                    indexPage = -1;
                }
            }

            //Number of item in a page
            int pageSize = 3;
            if (indexPage != -1) {
                //Number of items
                int rowCount = galleryDAO.numberOfResult();
                //Maximum of page
                int maxPage = rowCount / pageSize + (rowCount % pageSize > 0 ? 1 : 0);

                if (indexPage <= maxPage) {
                    List<Gallery> listGalleries = galleryDAO.pagging(indexPage, pageSize);
                    listGalleries.forEach((g) -> {
                        g.setImage(g.getImage());
                    });
                    request.setAttribute("galleries", listGalleries);
                    request.setAttribute("maxPage", maxPage);
                    request.setAttribute("pageIndex", indexPage);
                } else {
                    request.setAttribute("error", "Data not found! Because index page is out of rage");
                    request.getRequestDispatcher("./views/error.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("error", "Data not found! Because index page is character");
                request.getRequestDispatcher("./views/error.jsp").forward(request, response);
            }

            // Get Intro
            IntroductionDAO introductionDAO = new IntroductionDAO();
            Introduction intro = introductionDAO.getIntroduction();
            if (intro == null) {
                request.setAttribute("error", "Data Intro error!");
                request.getRequestDispatcher("./views/error.jsp").forward(request, response);
            } else {
                //Set image for intro element
                intro.setImage(intro.getImage());
                request.setAttribute("intro", intro);
            }

            //Get Share
            ShareDAO shareDAO = new ShareDAO();
            List<Share> share = shareDAO.getShare();
            if (share.isEmpty()) {
                request.setAttribute("error", "Data share error");
                request.getRequestDispatcher("./views/error.jsp").forward(request, response);
            } else {
                //Set image for each share element
                share.forEach((s) -> {
                    s.setIcon(s.getIcon());
                });
                request.setAttribute("shs", share);
            }
            //Set hight light when we stay home page
            request.setAttribute("clickedHome", true);

            request.getRequestDispatcher("./views/home.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("./views/error.jsp").forward(request, response);
        }
    }
}
