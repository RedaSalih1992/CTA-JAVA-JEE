<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="App">
<head>
        <title>Annuaire des Hébergements en ligne</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge"> 
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <link href="css/font-awesome.css" rel="stylesheet">
        <link href="css/simple-line-icons.css" rel="stylesheet">
        <link href="css/jquery-ui.css" rel="stylesheet">
        <link href="css/datepicker.css" rel="stylesheet">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/app.css" rel="stylesheet">
        
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
  </script>  
  <script src="https://apis.google.com/js/client.js?onload=init"></script>  
</head>
<body d="main" class="notransition" ng-controller="HebergementController">

<!-- Header -->

	<div id="header">
	    <div class="logo">
	        <a href="#/">
	            <span class="fa fa-home marker"></span>
	            <span class="logoText">Engine App</span>
	        </a>
	    </div>
	    <a href="#" class="navHandler"><span class="fa fa-bars"></span></a>
	    <div class="search">
	        <span class="searchIcon icon-magnifier"></span>
	        <input type="text" placeholder="Recherche ..." ng-model="recherche">
	    </div>
	    <div class="clearfix"></div>
	</div>
	<!-- Left Side Navigation -->

        <div id="leftSide">
            <nav class="leftNav scrollable">
                <div class="search">
                    <span class="searchIcon icon-magnifier"></span>
                    <input type="text" placeholder="Recherche ..." ng-model="rechercheTxt">
                    {{rechercheTxt}}
                    <div class="clearfix"></div>
                </div>
                <ul>
                    <li><a href="#/"><span class="navIcon icon-home"></span><span class="navLabel">Accueil</span></a></li>
                    <li><a href="#/map" ng-click="getMapList()"><span class="navIcon icon-map"></span><span class="navLabel">Map</span></a></li>
                    <li><a href="#/about"><span class="navIcon icon-info"></span><span class="navLabel">About</span></a></li>
                </ul>
            </nav>
        </div>
        <div class="closeLeftSide"></div>
        
        <!-- Content -->

        <div id="wrapper" >
        	<div id="content" ng-view class="mob-max"></div>
        </div>




	<script src="js/jquery-2.1.1.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/jquery-ui-touch-punch.js"></script>
    <script src="js/jquery.placeholder.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/jquery.touchSwipe.min.js"></script>
    <script src="js/jquery.slimscroll.min.js"></script>
    <script src="js/jquery.visible.js"></script>
    <script src="http://maps.googleapis.com/maps/api/js?sensor=true&amp;libraries=geometry&amp;libraries=places" type="text/javascript"></script>
    <script src="js/infobox.js"></script>
    <script src="js/jquery.tagsinput.min.js"></script>
    <script src="js/bootstrap-datepicker.js"></script>
    <script src="js/app.js" type="text/javascript"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>
    <script src="js/angular-route.min.js"></script>
    <script src="js/dirPagination.js"></script>
    <script src='js/lodash.min.js'></script>
<script src='js/angular-google-maps.min.js'></script>
    <script src="js/AppAngular.js"></script>
    <script src="js/gmaps.js"></script>
</body>

</html>