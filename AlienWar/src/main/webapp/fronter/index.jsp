<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Architect Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> 
		addEventListener("load", function() { 
			setTimeout(hideURLbar, 0); 
		}, false
		); 
		function hideURLbar(){ window.scrollTo(0,1); 
		} 
</script>
<link href="<c:url value="/resource/css/bootstrap.css"/>" rel='stylesheet' type='text/css' />
<link href="<c:url value="/resource/css/style.css"/>" rel='stylesheet' type='text/css' />
<script src="<c:url value="/resource/js/jquery-1.11.0.min.js"/>"></script>
<!---- start-smoth-scrolling---->
<script type="text/javascript" src="<c:url value="/resource/js/move-top.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resource/js/easing.js"/>"></script>
<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
				});
			});
		</script>
<!--start-smoth-scrolling-->
</head>
<body>
    <!-- header -->
	<%@ include file="/fronter/header.jsp" %>
	
	<!--search-scripts-->
					<script src="<c:url value="/resource/js/classie.js"/>"></script>
					<script src="<c:url value="/resource/js/uisearch.js"/>"></script>
						<script>
							new UISearch( document.getElementById( 'sb-search' ) );
						</script>
	<!--//search-scripts-->
	<!--banner-->
    <div class="copyrights">Collect from <a href="" >免费模板</a></div>
	<div class="banner">
		<div class="container">
			<div class="banner-top">
				<h1>THE LATEST NEWS ON DESIGN & ARCHITECTURE</h1>
				<ul>
				 	<li><a class="sub" href="#">Subscribe Now</a></li>
					<li><a class="art" href="#">Best Articles</a></li>
			    </ul>
			</div>	
		</div>
	</div>
	<!--banner-->
	<!--slide-->
	<div class="gallery-cursual">
		<!-- requried-jsfiles-for owl -->
		<link href="<c:url value="/resource/css/owl.carousel.css"/>" rel="stylesheet">
			<script>
				$(document).ready(function() {
					$("#owl-demo").owlCarousel({
						items : 5,
						lazyLoad : true,
						autoPlay : true,
						pagination : false,
					});
				});
			</script>
		<!-- //requried-jsfiles-for owl -->
		<!-- start content_slider -->
		<div id="owl-demo" class="owl-carousel text-center">
			<div class="item g1 popup-with-zoom-anim" href="#small-dialog">
				<img class="lazyOwl" data-src="<c:url value="/resource/images/slide-1.jpg"/>" alt="name">
				<div class="caption">
					<h3>Vanglo House by LWPAC in canada</h3>
					<div class="s-btn">
						<a href="#">READ MORE</a>
					</div>
				</div>
			</div>
			<div class="item g1 popup-with-zoom-anim" href="#small-dialog1">
				<img class="lazyOwl" data-src="<c:url value="/resource/images/slide-2.jpg"/>" alt="name">
				<div class="caption">
					<h3>Vanglo House by LWPAC in canada</h3>
					<div class="s-btn">
						<a href="#">READ MORE</a>
					</div>
				</div>
			</div>
			<div class="item g1 popup-with-zoom-anim" href="#small-dialog2">
				<img class="lazyOwl" data-src="<c:url value="/resource/images/slide-3.jpg"/>" alt="name">
				<div class="caption">
					<h3>Vanglo House by LWPAC in canada</h3>
					<div class="s-btn">
						<a href="#">READ MORE</a>
					</div>
				</div>
			</div>
			<div class="item g1 popup-with-zoom-anim" href="#small-dialog3">
				<img class="lazyOwl" data-src="<c:url value="/resource/images/slide-4.jpg"/>" alt="name">
				<div class="caption">
					<h3>Vanglo House by LWPAC in canada</h3>
					<div class="s-btn">
						<a href="#">READ MORE</a>
					</div>
				</div>
			</div>
			<div class="item g1 popup-with-zoom-anim" href="#small-dialog4">
				<img class="lazyOwl" data-src="<c:url value="/resource/images/slide-5.jpg"/>" alt="name">
				<div class="caption">
					<h3>Vanglo House by LWPAC in canada</h3>
					<div class="s-btn">
						<a href="#">READ MORE</a>
					</div>
				</div>
			</div>
			<div class="item g1 popup-with-zoom-anim" href="#small-dialog5">
				<img class="lazyOwl" data-src="<c:url value="/resource/images/slide-6.jpg"/>" alt="name">
				<div class="caption">
					<h3>Vanglo House by LWPAC in canada</h3>
					<div class="s-btn">
						<a href="#">READ MORE</a>
					</div>
				</div>
			</div>
			<div class="item g1 popup-with-zoom-anim" href="#small-dialog6">
				<img class="lazyOwl" data-src="<c:url value="/resource/images/slide-7.jpg"/>" alt="name">
				<div class="caption">
					<h3>Vanglo House by LWPAC in canada</h3>
					<div class="s-btn">
						<a href="#">READ MORE</a>
					</div>
				</div>
			</div>
			<div class="item g1 popup-with-zoom-anim" href="#small-dialog">
				<img class="lazyOwl" data-src="<c:url value="/resource/images/slide-1.jpg"/>" alt="name">
				<div class="caption">
					<h3>Vanglo House by LWPAC in canada</h3>
					<div class="s-btn">
						<a href="#">READ MORE</a>
					</div>
				</div>
			</div>
			<div class="item g1 popup-with-zoom-anim" href="#small-dialog">
				<img class="lazyOwl" data-src="<c:url value="/resource/images/slide-2.jpg"/>" alt="name">
				<div class="caption">
					<h3>Vanglo House by LWPAC in canada</h3>
					<div class="s-btn">
						<a href="#">READ MORE</a>
					</div>
				</div>
			</div>
		</div>
		<!--//sreen-gallery-cursual---->
		<!-- caption-popup -->
		<div class="caption-popup">
				<div id="small-dialog" class="mfp-hide innercontent">
					<h4>Vanglo House by LWPAC in canada</h4>
					<img class="img-responsive cap" src="<c:url value="/resource/images/slide-1.jpg"/>" title="postname" />
					<p>elit. Etiam sit amet nunc nec magna accumsan ultricies eget a leo. Praesent nec libero aliquet, malesuada nibh et, tincidunt arcu. Aenean porta faucibus nisl. Fusce ultrices nec purus eget consequat. Phasellus pharetra dignissim lacus id rhoncus. In malesuada et mi non mollis. </p>
					<a class="morebtn" href="#">ReadMore</a>
				</div>						  
		</div>
		<div class="caption-popup">
				<div id="small-dialog1" class="mfp-hide innercontent">
					<h4>Vanglo House by LWPAC in canada</h4>
					<img class="img-responsive cap" src="<c:url value="/resource/images/slide-2.jpg"/>" title="postname" />
					<p>elit. Etiam sit amet nunc nec magna accumsan ultricies eget a leo. Praesent nec libero aliquet, malesuada nibh et, tincidunt arcu. Aenean porta faucibus nisl. Fusce ultrices nec purus eget consequat. Phasellus pharetra dignissim lacus id rhoncus. In malesuada et mi non mollis. </p>
					<a class="morebtn" href="#">ReadMore</a>
				</div>						  
		</div>
		<div class="caption-popup">
				<div id="small-dialog2" class="mfp-hide innercontent">
					<h4>Vanglo House by LWPAC in canada</h4>
					<img class="img-responsive cap" src="<c:url value="/resource/images/slide-3.jpg"/>" title="postname" />
					<p>elit. Etiam sit amet nunc nec magna accumsan ultricies eget a leo. Praesent nec libero aliquet, malesuada nibh et, tincidunt arcu. Aenean porta faucibus nisl. Fusce ultrices nec purus eget consequat. Phasellus pharetra dignissim lacus id rhoncus. In malesuada et mi non mollis. </p>
					<a class="morebtn" href="#">ReadMore</a>
				</div>						  
		</div>
		<div class="caption-popup">
				<div id="small-dialog3" class="mfp-hide innercontent">
					<h4>Vanglo House by LWPAC in canada</h4>
					<img class="img-responsive cap" src="<c:url value="/resource/images/slide-4.jpg"/>" title="postname" />
					<p>elit. Etiam sit amet nunc nec magna accumsan ultricies eget a leo. Praesent nec libero aliquet, malesuada nibh et, tincidunt arcu. Aenean porta faucibus nisl. Fusce ultrices nec purus eget consequat. Phasellus pharetra dignissim lacus id rhoncus. In malesuada et mi non mollis. </p>
					<a class="morebtn" href="#">ReadMore</a>
				</div>						  
		</div>
		<div class="caption-popup">
				<div id="small-dialog4" class="mfp-hide innercontent">
					<h4>Vanglo House by LWPAC in canada</h4>
					<img class="img-responsive cap" src="<c:url value="/resource/images/slide-5.jpg"/>" title="postname" />
					<p>elit. Etiam sit amet nunc nec magna accumsan ultricies eget a leo. Praesent nec libero aliquet, malesuada nibh et, tincidunt arcu. Aenean porta faucibus nisl. Fusce ultrices nec purus eget consequat. Phasellus pharetra dignissim lacus id rhoncus. In malesuada et mi non mollis. </p>
					<a class="morebtn" href="#">ReadMore</a>
				</div>						  
		</div>
		<div class="caption-popup">
				<div id="small-dialog5" class="mfp-hide innercontent">
					<h4>Vanglo House by LWPAC in canada</h4>
					<img class="img-responsive cap" src="<c:url value="/resource/images/slide-6.jpg"/>" title="postname" />
					<p>elit. Etiam sit amet nunc nec magna accumsan ultricies eget a leo. Praesent nec libero aliquet, malesuada nibh et, tincidunt arcu. Aenean porta faucibus nisl. Fusce ultrices nec purus eget consequat. Phasellus pharetra dignissim lacus id rhoncus. In malesuada et mi non mollis. </p>
					<a class="morebtn" href="#">ReadMore</a>
				</div>						  
		</div>
		<div class="caption-popup">
				<div id="small-dialog6" class="mfp-hide innercontent">
					<h4>Vanglo House by LWPAC in canada</h4>
					<img class="img-responsive cap" src="<c:url value="/resource/images/slide-7.jpg"/>" title="postname" />
					<p>elit. Etiam sit amet nunc nec magna accumsan ultricies eget a leo. Praesent nec libero aliquet, malesuada nibh et, tincidunt arcu. Aenean porta faucibus nisl. Fusce ultrices nec purus eget consequat. Phasellus pharetra dignissim lacus id rhoncus. In malesuada et mi non mollis. </p>
					<a class="morebtn" href="#">ReadMore</a>
				</div>						  
		</div>
			<!----//fea-video---->
			<script>
						$(document).ready(function() {
						$('.popup-with-zoom-anim').magnificPopup({
							type: 'inline',
							fixedContentPos: false,
							fixedBgPos: true,
							overflowY: 'auto',
							closeBtnInside: true,
							preloader: false,
							midClick: true,
							removalDelay: 300,
							mainClass: 'my-mfp-zoom-in'
						});
																						
						});
				</script>	
		</div>
		<!-- /caption-popup -->
		<!---pop-up-box---->
				<link href="<c:url value="/resource/css/popuo-box.css"/>" rel="stylesheet" type="text/css" media="all"/>
				<script src="<c:url value="/resource/js/jquery.magnific-popup.js"/>" type="text/javascript"></script>
				<script src="<c:url value="/resource/js/owl.carousel.js"/>"></script>
		<!---//pop-up-box---->
	<!--slide-->
	<!--address-->
	<div class="address">
		<div class="container">
			<div class="address-top">
				<p>Leave your Ads Here</p>
			</div>
		</div>
	</div>
	<!--address-->
	<!--articles-->
	<div class="articles">
		<div class="container">
			<div class="articles-top">
				<div class="col-md-4 articles-left">
					<div class="art-one">
						<a href="single.html"><img src="<c:url value="/resource/images/art-1.jpg"/>" alt="" /></a>
						<div class="art-btm">
							<a href="single.html"><h3>Vanglo House By LWPAC in Canda</h3></a>
							<p>Amazing Gabion Ideas for Outdoors A Gabion is a cage box or cylinder filled with rocks, concrete, or sometimes sand and soil and It is a great way to decorate your outdoor</p>
							<ul>
								<li><a href="#"><span class="fb"> </span></a><label>21</label></li>
								<li><a href="#"><span class="twit"> </span></a><label>12</label></li>
								<li><a href="#"><span class="g"> </span></a><label>37</label></li>
								<li><a href="#"><span class="p"> </span></a><label>22</label></li>
							</ul>
						</div>
					</div>
					<div class="art-one sponser">
						<a href="single.html"><img src="<c:url value="/resource/images/art-3.jpg"/>" alt="" /></a>
						<div class="art-btm">
							<a href="single.html"><h3>Vanglo House By LWPAC in Canda</h3></a>
							<p>Amazing Gabion Ideas for Outdoors A Gabion is a cage box or cylinder filled with rocks, concrete, or sometimes sand and soil and It is a great way to decorate your outdoor</p>
							<ul>
								<li><a href="#"><span class="fb"> </span></a><label>21</label></li>
								<li><a href="#"><span class="twit"> </span></a><label>12</label></li>
								<li><a href="#"><span class="g"> </span></a><label>37</label></li>
								<li><a href="#"><span class="p"> </span></a><label>22</label></li>
							</ul>
							<h6>Sponsered</h6>
						</div>
					</div>
					<div class="art-one">
						<a href="single.html"><img src="<c:url value="/resource/images/art-5.jpg"/>" alt="" /></a>
						<div class="art-btm">
							<a href="single.html"><h3>Vanglo House By LWPAC in Canda</h3></a>
							<p>Amazing Gabion Ideas for Outdoors A Gabion is a cage box or cylinder filled with rocks, concrete, or sometimes sand and soil and It is a great way to decorate your outdoor</p>
							<ul>
								<li><a href="#"><span class="fb"> </span></a><label>21</label></li>
								<li><a href="#"><span class="twit"> </span></a><label>12</label></li>
								<li><a href="#"><span class="g"> </span></a><label>37</label></li>
								<li><a href="#"><span class="p"> </span></a><label>22</label></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-md-4 articles-left">
					<div class="art-one">
						<a href="single.html"><img src="<c:url value="/resource/images/art-2.jpg"/>" alt="" /></a>
						<div class="art-btm">
							<a href="single.html"><h3>Vanglo House By LWPAC in Canda</h3></a>
							<p>Amazing Gabion Ideas for Outdoors A Gabion is a cage box or cylinder filled with rocks,</p>
							<ul>
								<li><a href="#"><span class="fb"> </span></a><label>21</label></li>
								<li><a href="#"><span class="twit"> </span></a><label>12</label></li>
								<li><a href="#"><span class="g"> </span></a><label>37</label></li>
								<li><a href="#"><span class="p"> </span></a><label>22</label></li>
							</ul>
						</div>
					</div>
					<div class="art-one">
						<a href="single.html"><img src="<c:url value="/resource/images/art-4.jpg"/>" alt="" /></a>
						<div class="art-btm">
							<a href="single.html"><h3>Vanglo House By LWPAC in Canda</h3></a>
							<p>Amazing Gabion Ideas for Outdoors A Gabion is a cage box or cylinder filled with rocks, concrete, or sometimes sand and soil and It is a</p>
							<ul>
								<li><a href="#"><span class="fb"> </span></a><label>21</label></li>
								<li><a href="#"><span class="twit"> </span></a><label>12</label></li>
								<li><a href="#"><span class="g"> </span></a><label>37</label></li>
								<li><a href="#"><span class="p"> </span></a><label>22</label></li>
							</ul>
						</div>
					</div>
					<div class="art-one">
						<a href="single.html"><img src="<c:url value="/resource/images/art-6.jpg"/>" alt="" /></a>
						<div class="art-btm">
							<a href="single.html"><h3>Vanglo House By LWPAC in Canda</h3></a>
							<p>Amazing Gabion Ideas for Outdoors A Gabion is a cage box or cylinder filled with rocks, concrete, or sometimes sand and soil and It is a great way to decorate your outdoor</p>
							<ul>
								<li><a href="#"><span class="fb"> </span></a><label>21</label></li>
								<li><a href="#"><span class="twit"> </span></a><label>12</label></li>
								<li><a href="#"><span class="g"> </span></a><label>37</label></li>
								<li><a href="#"><span class="p"> </span></a><label>22</label></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-md-4 articles-left">
					<h4>THIS WEEKS COLLECTION</h4>
					<div class="week">
						<div class="col-md-6 week-left">
							<div class="portfolio app mix_all" data-cat="app" style="display: inline-block; opacity: 1;">
								<div class="portfolio-wrapper">		
									<a href="images/week-1.jpg" class="b-link-stripe b-animate-go   swipebox"  title="Image Title">
								     <img src=<c:url value="/resource/images/week-1.jpg"/> /><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 ">
								     	<span></span>
								     	</h2>
								  	 </div></a>
		                			</div>
								</div>
						</div>
						<div class="col-md-6 week-left">
							<div class="portfolio app mix_all" data-cat="app" style="display: inline-block; opacity: 1;">
								<div class="portfolio-wrapper">		
									<a href="images/week-2.jpg" class="b-link-stripe b-animate-go   swipebox"  title="Image Title">
								     <img src="<c:url value="/resource/images/week-2.jpg"/>" /><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 ">
								     	<span></span>
								     	</h2>
								  	 </div></a>
		                			</div>
								</div>
						</div>
						<div class="clearfix"></div>
					<div class="week-btm">
						<div class="col-md-4 week-btm-left">
							<div class="portfolio app mix_all" data-cat="app" style="display: inline-block; opacity: 1;">
								<div class="portfolio-wrapper">		
									<a href="images/week-3.jpg" class="b-link-stripe b-animate-go   swipebox"  title="Image Title">
								     <img src="<c:url value="/resource/images/week-3.jpg"/>" /><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 ">
								     	<span class="one"></span>
								     	</h2>
								  	 </div></a>
		                			</div>
								</div>
						</div>
						<div class="col-md-4 week-btm-left">
							<div class="portfolio app mix_all" data-cat="app" style="display: inline-block; opacity: 1;">
								<div class="portfolio-wrapper">		
									<a href="images/week-4.jpg" class="b-link-stripe b-animate-go   swipebox"  title="Image Title">
								     <img src="<c:url value="/resource/images/week-4.jpg"/>" /><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 ">
								     	<span class="one"></span>
								     	</h2>
								  	 </div></a>
		                			</div>
								</div>
						</div>
						<div class="col-md-4 week-btm-left">
							<div class="portfolio app mix_all" data-cat="app" style="display: inline-block; opacity: 1;">
								<div class="portfolio-wrapper">		
									<a href="images/week-5.jpg" class="b-link-stripe b-animate-go   swipebox"  title="Image Title">
								     <img src="<c:url value="/resource/images/week-5.jpg"/>" /><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 ">
								     	<span class="one"></span>
								     	</h2>
								  	 </div></a>
		                			</div>
								</div>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="week-btm">
						<div class="col-md-4 week-btm-left">
							<div class="portfolio app mix_all" data-cat="app" style="display: inline-block; opacity: 1;">
								<div class="portfolio-wrapper">		
									<a href="images/week-6.jpg" class="b-link-stripe b-animate-go   swipebox"  title="Image Title">
								     <img src="<c:url value="/resource/images/week-6.jpg"/>" /><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 ">
								     	<span class="one"></span>
								     	</h2>
								  	 </div></a>
		                			</div>
								</div>
						</div>
						<div class="col-md-4 week-btm-left">
							<div class="portfolio app mix_all" data-cat="app" style="display: inline-block; opacity: 1;">
								<div class="portfolio-wrapper">		
									<a href="images/week-7.jpg" class="b-link-stripe b-animate-go   swipebox"  title="Image Title">
								     <img src="<c:url value="/resource/images/week-7.jpg"/>" /><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 ">
								     	<span class="one"></span>
								     	</h2>
								  	 </div></a>
		                			</div>
								</div>
						</div>
						<div class="col-md-4 week-btm-left">
							<div class="portfolio app mix_all" data-cat="app" style="display: inline-block; opacity: 1;">
								<div class="portfolio-wrapper">		
									<a href="images/week-8.jpg" class="b-link-stripe b-animate-go   swipebox"  title="Image Title">
								     <img src="<c:url value="/resource/images/week-8.jpg"/>" /><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 ">
								     	<span class="one"></span>
								     	</h2>
								  	 </div></a>
		                			</div>
								</div>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="week-btm">
						<div class="col-md-4 week-btm-left">
							<div class="portfolio app mix_all" data-cat="app" style="display: inline-block; opacity: 1;">
								<div class="portfolio-wrapper">		
									<a href="images/week-9.jpg" class="b-link-stripe b-animate-go   swipebox"  title="Image Title">
								     <img src="<c:url value="/resource/images/week-9.jpg"/>" /><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 ">
								     	<span class="one"></span>
								     	</h2>
								  	 </div></a>
		                			</div>
								</div>
						</div>
						<div class="col-md-4 week-btm-left">
							<div class="portfolio app mix_all" data-cat="app" style="display: inline-block; opacity: 1;">
								<div class="portfolio-wrapper">		
									<a href="images/week-10.jpg" class="b-link-stripe b-animate-go   swipebox"  title="Image Title">
								     <img src="<c:url value="/resource/images/week-10.jpg"/>" /><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 ">
								     	<span class="one"></span>
								     	</h2>
								  	 </div></a>
		                			</div>
								</div>
						</div>
						<div class="col-md-4 week-btm-left">
							<div class="portfolio app mix_all" data-cat="app" style="display: inline-block; opacity: 1;">
								<div class="portfolio-wrapper">		
									<a href="images/week-11.jpg" class="b-link-stripe b-animate-go   swipebox"  title="Image Title">
								     <img src="<c:url value="/resource/images/week-11.jpg"/>" /><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 ">
								     	<span class="one"></span>
								     	</h2>
								  	 </div></a>
		                			</div>
								</div>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="art-one">
						<a href="single.html"><img src="<c:url value="/resource/images/week-12.jpg"/>" alt="" /></a>
						<div class="art-btm">
							<a href="single.html"><h3>Vanglo House By LWPAC in Canda</h3></a>
							<p>Amazing Gabion Ideas for Outdoors A Gabion is a cage box or cylinder filled with rocks, concrete, or sometimes sand and soil and It is a </p>
							<ul>
								<li><a href="#"><span class="fb"> </span></a><label>21</label></li>
								<li><a href="#"><span class="twit"> </span></a><label>12</label></li>
								<li><a href="#"><span class="g"> </span></a><label>37</label></li>
								<li><a href="#"><span class="p"> </span></a><label>22</label></li>
							</ul>						
						</div>
					</div>
					<div class="art-one">
						<a href="single.html"><img src="<c:url value="/resource/images/week-13.jpg"/>" alt="" /></a>
						<div class="art-btm">
							<a href="single.html"><h3>Vanglo House By LWPAC in Canda</h3></a>
							<p>Amazing Gabion Ideas for Outdoors A Gabion is a cage box or cylinder filled with rocks, concrete, or sometimes sand and soil and It is a great way to decorate your outdoor</p>
							<ul>
								<li><a href="#"><span class="fb"> </span></a><label>21</label></li>
								<li><a href="#"><span class="twit"> </span></a><label>12</label></li>
								<li><a href="#"><span class="g"> </span></a><label>37</label></li>
								<li><a href="#"><span class="p"> </span></a><label>22</label></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
			<div class="load">
				<a href="#" class="hvr-shutter-out-horizontal">Load More Articles</a>
			</div>
		</div>
	</div>
	</div>
	<!--articles-->
	<link rel="stylesheet" href="<c:url value="/resource/css/swipebox.css"/>">
	<script src="<c:url value="/resource/js/jquery.swipebox.min.js"/>"></script> 
	    <script type="text/javascript">
			jQuery(function($) {
				$(".swipebox").swipebox();
			});
		</script>
	<!-- Portfolio Ends Here -->
	<script type="text/javascript" src="<c:url value="/resource/js/jquery.mixitup.min.js"/>"></script>
<script type="text/javascript">
$(function () {
	
	var filterList = {
	
		init: function () {
		
			// MixItUp plugin
		// 
		$('#portfoliolist').mixitup({
			targetSelector: '.portfolio',
			filterSelector: '.filter',
			effects: ['fade'],
			easing: 'snap',
			// call the hover effect
			onMixEnd: filterList.hoverEffect()
		});				
	
	},
	
	hoverEffect: function () {
	
		// Simple parallax effect
		$('#portfoliolist .portfolio').hover(
			function () {
				$(this).find('.label').stop().animate({bottom: 0}, 200, 'easeOutQuad');
				$(this).find('img').stop().animate({top: -30}, 500, 'easeOutQuad');				
			},
			function () {
				$(this).find('.label').stop().animate({bottom: -40}, 200, 'easeInQuad');
				$(this).find('img').stop().animate({top: 0}, 300, 'easeOutQuad');								
			}		
		);				
	
	}

};

// Run the show!
	filterList.init();
	
});	
</script>
	<!--advertisement-->
	<div class="add">
		<div class="container">
			<div class="add-top">
				<div class="col-md-10 add-left">
					<p>Leave your Ads Here</p>
				</div>
				<div class="col-md-2 add-right">
					<img src="<c:url value="/resource/images/add.png"/>" alt="" />
					<h3>Advertisement</h3>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--advertisement-->
	<!--read-->
	<div class="read">
		<div class="container">
			<div class="read-main">
				<div class="col-md-5 read-left">
					<h3>Site Map</h3>
					<div class="read-btm">
						<div class="col-md-4 rd-left">
							<ul>
								<li><a href="index.html">Home</a></li>
								<li><a href="#">Archive</a></li>
								<li><a href="#">Drsign Posts</a></li>
								<li><a href="#">Latest News</a></li>
								<li><a href="#">Footer Demo</a></li>
								<li><a href="#">Just a link</a></li>
								<li><a href="#">Links Demo</a></li>
								<li><a href="#">Advertisement</a></li>
							</ul>
						</div>
						<div class="col-md-4 rd-left">
							<ul>
								<li><a href="#">Privcey</a></li>
								<li><a href="#">Design Articles</a></li>
								<li><a href="#">Drsign Posts</a></li>
								<li><a href="#">Latest News</a></li>
								<li><a href="#">Footer Demo</a></li>
								<li><a href="#">Just a link</a></li>
								<li><a href="#">Links Demo</a></li>
								<li><a href="#">Advertisement</a></li>
							</ul>
						</div>
						<div class="col-md-4 rd-left">
							<ul>
								<li><a href="magazine.html">Magazine</a></li>
								<li><a href="#">Drsign Posts</a></li>
								<li><a href="#">Latest News</a></li>
								<li><a href="#">Footer Demo</a></li>
								<li><a href="#">Just a link</a></li>
								<li><a href="#">Links Demo</a></li>
								<li><a href="#">Advertisement</a></li>
							</ul>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
				<div class="col-md-5 read-left">
					<h3>Dont Miss Read</h3>
					<div class="read-btm">
						<div class="read-one">
							<div class="col-md-3 read-bottom-left">
								<img src="<c:url value="/resource/images/read-1.jpg"/>" alt="" />
							</div>
							<div class="col-md-9 read-bottom-right">
								<h4>Captivating Spanish Villa in Port d’Andratx Boasting Exceptional Views</h4>
								<p>Posted on August 14, 2013</p>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="read-one">
							<div class="col-md-3 read-bottom-left">
								<img src="<c:url value="/resource/images/read-1.jpg"/>" alt="" />
							</div>
							<div class="col-md-9 read-bottom-right">
								<h4>Captivating Spanish Villa in Port d’Andratx Boasting Exceptional Views</h4>
								<p>Posted on August 14, 2013</p>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<div class="col-md-2 read-left">
					<h3>Follow Us Here</h3>
					<div class="read-btm follow">
						<ul>
							<li><a href="#" class="twit">423.3k Followers</a></li>
							<li><a href="#" class="fb">6.8m Likes</a></li>
							<li><a href="#" class="d">423k Followers</a></li>
							<li><a href="#" class="p">423k Followers</a></li>
						</ul>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--read-->
	
	<!-- footer -->
	<%@ include file="/fronter/footer.jsp" %>
</body>
</html>