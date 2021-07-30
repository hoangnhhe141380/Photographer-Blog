<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="./css/gallery.css" rel="stylesheet" type="text/css"/>
        <link href="./css/styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="wrapper">  
            <jsp:include page="header.jsp"/>
            <div class="content-wrap">
                <div class="left-area">
                    <div class="name">${gal.name}</div>
                    <div class="slide">
                        <h2>${message}</h2>
                        <c:forEach var="x" items="${imgs}">
                            <img class="gallery-big-image" src="${x.image}" style="width:100%">
                            <a id="toggleSlide" class="button" onclick="onToggleSlide()" onmouseout="onTouchend()"></a>
                        </c:forEach>
                    </div>
                    <div class="gallery-list-image">
                        <c:forEach var="x" items="${imgs}" varStatus="i" >
                            <div class="gallery-image">
                                <img id="choiceImage" 
                                     src="${x.image}" 
                                     onclick="showImageChoose(${i.index})">
                            </div>
                        </c:forEach>
                    </div>
                    <div class="paging">
                        <c:if test="${maxPage<1}">
                            <h3>Not Found !!</h3>
                        </c:if>
                        <c:if test="${maxPage>1}">
                            <c:forEach begin="1" end="${maxPage}" var="i">
                                <a class="${i==pageIndex?"active":""}" href="GalleryController?txtPage=${i}&id=${id}">${i}</a>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>
                <div class="right-area">
                    <jsp:include page="right.jsp"/>
                </div>
            </div>
            <jsp:include page="footer.jsp"/>
    </body>
    <script>

        // Window onload show image if clicked
        function showImageChoose(n) {
            //Get all image to array x
            var image = document.getElementsByClassName("gallery-big-image");

            for (var i = 0; i < image.length; i++) {
                // Displaying image will display none (hidden this image)
                image[i].style.display = "none";
            }
            // Image which choose will display block (show this image)
            image[n].style.display = "block";
        }
        //Start display first image at the beginning
        showImageChoose(0);

        // Index of the image
        var slideIndex = 0;

        // Slideshow
        function showSlides() {
            var slides = document.getElementsByClassName("gallery-big-image");

            for (var i = 0; i < slides.length; i++) {
                slides[i].style.display = "none";
            }
            slides[slideIndex].style.display = "block";

            // Move to next slide
            slideIndex++;
            // If the last slide, move to first
            if (slideIndex > slides.length - 1) {
                slideIndex = 0;
            }
        }

        // Auto move to next in 2s
        timer = setInterval(showSlides, 2000);

        // Default show the first slide
        showSlides(slideIndex);

        // Check play or pause
        var playing = true;

        // Pause slideshow
        function pause() {
            playing = false;
            clearInterval(timer);
        }

        // Play slideshow
        function play() {
            playing = true;
            timer = setInterval(showSlides, 2000);
        }

        // Choose the image
        var toggleSlide = document.getElementById("toggleSlide");

        // Change the icon if click the button on big image
        function onToggleSlide() {
            if (playing === true) {
                toggleSlide.classList.remove("paused");
                toggleSlide.classList.add("play");
                pause();
            } else {
                toggleSlide.classList.add("paused");
                toggleSlide.classList.remove("play");
                play();
            }
        }

        // When user move out the mouse
        function onTouchend() {
            if (playing === true) {
                toggleSlide.classList.remove("paused");
            } else {
                toggleSlide.classList.remove("play");
            }
        }
    </script>
</html>