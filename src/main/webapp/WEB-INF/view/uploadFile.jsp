<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false" %>

<!doctype html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>JavaDevelop</title>
    <link rel="shortcut icon" href="<c:url value="/assets/favicon.ico" />">
    <link rel="stylesheet" href="<c:url value="/assets/bootstrap.min.css" />">
    <link rel="stylesheet" href="<c:url value="/assets/bootstrap-icons.css" />">
    <link rel="stylesheet" href="<c:url value="/assets/styles.css" />">
</head>

<body>

    <%@ include file="./_headerNavbar.jsp" %>

    <main>
        <div class="container workspace">
            <form action="upload_file" method="post" enctype="multipart/form-data">
                <label>ファイル 画像：</label>
                <input type="file" name="img" />
                <br/>
                <label>ファイル 音声：</label>
                <input type="file" name="audio" />
                <br/>
                <label>ファイル 動画：</label>
                <input type="file" name="video" />
                <br/>
                <input type="submit" />
            </form>
            <hr/>
            <div class="upload">
                <p>アップロードファイル：画像</p>
                <c:if test="${!empty resultDto.imgPath}">
                    <div class="spinner-border d-none uploadFileLoading"></div>
                    <img class="uploadFile" src="<c:url value="${resultDto.imgPath}" />" />
                </c:if>
            </div>
            <hr/>
            <div class="upload">
                <p>アップロードファイル：音声</p>
                <c:if test="${!empty resultDto.audioPath}">
                    <div class="spinner-border d-none uploadFileLoading"></div>
                    <audio class="uploadFile" src="<c:url value="${resultDto.audioPath}" />" controls></audio>
                </c:if>
            </div>
            <hr/>
            <div class="upload">
                <p>アップロードファイル：動画</p>
                <c:if test="${!empty resultDto.videoPath}">
                    <div class="spinner-border d-none uploadFileLoading"></div>
                    <video class="uploadFile" src="<c:url value="${resultDto.videoPath}" />" controls></video>
                </c:if>
            </div>
            <hr/>
        </div>
    </main>

    <footer class="footer mt-auto fixed-bottom py-3 bg-secondary"></footer>

    <script src="<c:url value="/assets/bootstrap.bundle.min.js" />"></script>
    <script src="<c:url value="/assets/script.js" />"></script>
</body>

</html>
