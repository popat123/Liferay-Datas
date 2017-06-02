<%
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
String imgsPath = themeDisplay.getPathThemeImages();
%>

<h1>.yellow-header</h1>
<div class="portlet-boundary portlet-boundary_56_ portlet-journal-content yellow-header portlet-draggable yui3-dd-drop yui3-dd-draggable">
	<section class="portlet">
		<header class="portlet-topper">
			<h1 class="portlet-title">
				<span class="portlet-title-text portlet-title-editable">Browse the news letter</span>
			</h1>
		</header> 
		<div class="portlet-content">
			<div class=" portlet-content-container">
				<div class="portlet-body">
					<div class="journal-content-article"><div class="newsletter-list-component"><div class="newsletter-list-item"> Content here </div></div></div>
				</div>
			</div>
		</div>
	</section>
</div>

<h1>.blue-header</h1>
<div class="portlet-boundary portlet-boundary_56_ portlet-journal-content blue-header portlet-draggable yui3-dd-drop yui3-dd-draggable">
	<section class="portlet">
		<header class="portlet-topper">
			<h1 class="portlet-title">
				<span class="portlet-title-text portlet-title-editable">Browse the news letter</span>
			</h1>
		</header> 
		<div class="portlet-content">
			<div class=" portlet-content-container">
				<div class="portlet-body">
					<div class="journal-content-article"><div class="newsletter-list-component"><div class="newsletter-list-item"> Content here </div></div></div>
				</div>
			</div>
		</div>
	</section>
</div>

<h1>.gray-green-header</h1>
<div class="portlet-boundary portlet-boundary_56_ portlet-journal-content gray-green-header portlet-draggable yui3-dd-drop yui3-dd-draggable">
	<section class="portlet">
		<header class="portlet-topper">
			<h1 class="portlet-title">
				<span class="portlet-title-text portlet-title-editable">Browse the news letter</span>
			</h1>
		</header> 
		<div class="portlet-content">
			<div class=" portlet-content-container">
				<div class="portlet-body">
					<div class="journal-content-article"><div class="newsletter-list-component"><div class="newsletter-list-item"> Content here </div></div></div>
				</div>
			</div>
		</div>
	</section>
</div>

<h1>.lime-green</h1>
<div class="portlet-boundary portlet-boundary_56_ portlet-journal-content lime-green portlet-draggable yui3-dd-drop yui3-dd-draggable">
	<section class="portlet">
		<header class="portlet-topper">
			<h1 class="portlet-title">
				<span class="portlet-title-text portlet-title-editable">Browse the news letter</span>
			</h1>
		</header> 
		<div class="portlet-content">
			<div class=" portlet-content-container">
				<div class="portlet-body">
					<div class="journal-content-article"><div class="newsletter-list-component"><div class="newsletter-list-item"> Content here </div></div></div>
				</div>
			</div>
		</div>
	</section>
</div>

<h1>.gray-lime-green</h1>
<div class="portlet-boundary portlet-boundary_56_ portlet-journal-content gray-lime-green portlet-draggable yui3-dd-drop yui3-dd-draggable">
	<section class="portlet">
		<header class="portlet-topper">
			<h1 class="portlet-title">
				<span class="portlet-title-text portlet-title-editable">Browse the news letter</span>
			</h1>
		</header> 
		<div class="portlet-content">
			<div class=" portlet-content-container">
				<div class="portlet-body">
					<div class="journal-content-article"><div class="newsletter-list-component"><div class="newsletter-list-item"> Content here </div></div></div>
				</div>
			</div>
		</div>
	</section>
</div>
<h1>sapphire and emerand inner page</h1>
<div class="newswheel">
	<div class="newswheelitem gray-green clearfix">
		<a href="#">
			<img src="<%= imgsPath%>/common/small-thumbnail.jpg" alt="R-Health"></a>
			<h2><a href="#">R-Health</a></h2>
			<div class="userdetail">
				<div>
					<span class="contributer">Namrata Devan</span> , R-Apps </div> 
			</div>
	</div>
	<div class="newswheelitem gray-green clearfix">
		<a href="#">
			<img style="" src="<%= imgsPath%>/common/small-thumbnail.jpg">
		</a>
		<h2><a href="#">The Top 7 Leadership Qualities &amp; Attributes Of Great Leaders</a></h2>
		<div class="userdetail">
			<div>
				<span class="contributer">Brain Tracy</span> , IT </div>
		</div>
	</div>
</div>


<h1>Color buttons</h1>
<div class="row">
	<div class="span4 text-center">
		<a class="btn btn-block btn-lime-green" href="#">GROW SELF</a>
	</div>
	<div class="span4 text-center">
		<a class="btn btn-block btn-cyan" href="#">KNOW SELF</a>
	</div>
	<div class="span4 text-center">
		<a class="btn btn-block btn-yellow" href="#">BE SELF</a>
	</div>
</div>

<!-- START -->
<h1>About us</h1>
<div class="para-container">
	<p class="inner-para">In the paragraph below, the image will float to the right. A dotted black border is added to the image. 
	We have also added margins to the image to push the text away from the image:
	0 px margin on the top and right side, 15 px margin on the bottom, and 20 px margin on the left side of the image.
	</p>

	<p class="inner-para">
		<img class="inner-para-img" src="<%= imgsPath%>/common/small-thumbnail02.jpg">
		<h2 class="inner-title">title comes here</h2>
		This is some text. This is some text. This is some text.
		This is some text. This is some text. This is some text.
		This is some text. This is some text. This is some text.
		This is some text. This is some text. This is some text.
		This is some text. This is some text. This is some text.
		This is some text. This is some text. This is some text.
		This is some text. This is some text. This is some text.
		This is some text. This is some text. This is some text.
		This is some text. This is some text. This is some text.
		This is some text. This is some text. This is some text.
		This is some text. This is some text. This is some text.
		This is some text. This is some text. This is some text.
		This is some text. This is some text. This is some text.
	</p>
</div>

<div class="clearfix"></div>
<!-- END -->


<!-- START -->
<h1>Profile Section</h1>
<div class="profile-sec-container">
<div class="row">
	<div class="span2">
		<div class="profile-container">
			<img src="<%= imgsPath%>/user.png">
			<h4 class="title detail-title">
				Carol Roth
			</h4>
			<div class="details">
				<p>Author</p>
				<p>(Mumbai, India)</p>
			</div>
		</div>
	</div>
	<div class="span10 margin-left-0">
		<h4 class="title detail-title">
			Know about me
			<a class="btn btn-mini pull-right edit-btn" href="#"><i class="icon-pencil"></i> Edit</a>
		</h4>
		<p>In the paragraph below, the image will float to the right. A dotted black border is added to the image. 
			We have also added margins to the image to push the text away from the image:
			0 px margin on the top and right side, 15 px margin on the bottom, and 20 px margin on the left side of the image.
		</p>
	</div>
</div>
</div>
<!-- END -->

<!-- START -->
<h1>Doc list</h1>
<div class="row">
	<div class="span6">
		<div class="detail-list">
			<ul class="list-group">
				<li class="pdf">
					<a href="#" target="_blank" class="list-group-item">Title goes here</a>
				</li>
				<li class="word">
					<a href="#" target="_blank" class="list-group-item">Title goes here</a>
				</li>
			</ul>
		</div>
	</div>
	
	<div class="span6">
		<div class="detail-list">
			<ul class="list-group">
				<li class="pdf">
					<a href="#" target="_blank" class="list-group-item">Title goes here</a>
				</li>
				<li class="word">
					<a href="#" target="_blank" class="list-group-item">Title goes here</a>
				</li>
			</ul>
		</div>
	</div>
	
</div>
<!-- END -->

<!-- START -->
<h1>Panels</h1>
<div class="accordion" id="accordion2">
	<div class="accordion-group">
	  <div class="accordion-heading">
		<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
		  Collapsible Group Item #1
		  <i class="accordian-icon icon-chevron-up pull-right"></i>
		</a>
	  </div>
	  <div id="collapseOne" class="accordion-body in collapse" style="height: auto;">
		<div class="accordion-inner">
		  Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod.
		</div>
	  </div>
	</div>
	<div class="accordion-group">
	  <div class="accordion-heading">
		<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">
		  Collapsible Group Item #2
		  <i class="accordian-icon icon-chevron-down pull-right"></i>
		</a>
	  </div>
	  <div id="collapseTwo" class="accordion-body collapse" style="height: 0px;">
		<div class="accordion-inner">
		  Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod.
		</div>
	  </div>
	</div>
</div>
<!-- END -->

<!-- START -->
<h1>Constellation Page</h1>
<br/>
<div class="row margin-left-0">
	<div class="span3 text-center">
		<a href="#"><img class="margin-bottom-15" src="<%= imgsPath%>/delivers-outcomes.png" alt=""></a>
	</div>
	<div class="span3 text-center">
		<a href="#"><img class="margin-bottom-15" src="<%= imgsPath%>/delivers-outcomes.png" alt=""></a>
	</div>
	<div class="span3 text-center">
		<a href="#"><img class="margin-bottom-15" src="<%= imgsPath%>/delivers-outcomes.png" alt=""></a>
	</div>
	<div class="span3 text-center">
		<a href="#"><img class="margin-bottom-15" src="<%= imgsPath%>/delivers-outcomes.png" alt=""></a>
	</div>
</div>
<div class="row margin-left-0">
	<div class="span3 text-center">
		<a href="#"><img class="margin-bottom-15" src="<%= imgsPath%>/delivers-outcomes.png" alt=""></a>
	</div>
	<div class="span3 text-center">
		<a href="#"><img class="margin-bottom-15" src="<%= imgsPath%>/delivers-outcomes.png" alt=""></a>
	</div>
	<div class="span3 text-center">
		<a href="#"><img class="margin-bottom-15" src="<%= imgsPath%>/delivers-outcomes.png" alt=""></a>
	</div>
	<div class="span3 text-center">
		<a href="#"><img class="margin-bottom-15" src="<%= imgsPath%>/delivers-outcomes.png" alt=""></a>
	</div>
</div>
<!-- END -->

<!-- START -->
<div class="portlet-boundary portlet-boundary_56_ portlet-journal-content blue-header portlet-draggable yui3-dd-drop yui3-dd-draggable">
	<section class="portlet">
		<header class="portlet-topper">
			<h1 class="portlet-title">
				<span class="portlet-title-text portlet-title-editable">Contact Us</span>
			</h1>
		</header> 
		<div class="portlet-content">
			<div class=" portlet-content-container">
				<div class="portlet-body">
					<div class="journal-content-article">
						<div class="padding-15 contact-box">
							<br/>
							<div class="blue-title margin-bottom-15">Reach out to us</div>
							<br/>
							<div class="row margin-left-0">
								<div class="span6">
									<div class="contact-container clearfix">
										<div class="img-container">
											<img src="<%= imgsPath%>/common/contact-us_03.jpg" alt="">
										</div>
										<div class="detail-container">
											<div class="text">For other queries</div>
											<div class="email"><a href="#">john.doe@mail.com</a></div>
										</div>
									</div>	
								</div>
								
								<div class="span6">
									<div class="contact-container clearfix">
										<div class="img-container">
											<img src="<%= imgsPath%>/common/contact-us_03.jpg" alt="">
										</div>
										<div class="detail-container">
											<div class="text">For other queries</div>
											<div class="email"><a href="#">john.doe@mail.com</a></div>
										</div>
									</div>	
								</div>
							</div>
							
							<hr>
							<div class="blue-title margin-bottom-15">LE News</div>
							<div class="row margin-left-0">
								<div class="span4">
									<div class="board-contact-container clearfix">
										<div class="img-container">
											<img src="<%= imgsPath%>/common/contact-us_03.jpg" alt="">
										</div>
										<div class="detail-container">
											<div class="text">For other queries</div>
											<div class="sub-text">Designation: xyz</div>
										</div>
									</div>	
								</div>
								
								<div class="span4">
									<div class="board-contact-container clearfix">
										<div class="img-container">
											<img src="<%= imgsPath%>/common/contact-us_03.jpg" alt="">
										</div>
										<div class="detail-container">
											<div class="text">For other queries</div>
											<div class="sub-text">Designation: xyz</div>
										</div>
									</div>	
								</div>
								
								<div class="span4">
									<div class="board-contact-container clearfix">
										<div class="img-container">
											<img src="<%= imgsPath%>/common/contact-us_03.jpg" alt="">
										</div>
										<div class="detail-container">
											<div class="text">For other queries</div>
											<div class="sub-text">Designation: xyz</div>
										</div>
									</div>	
								</div>
							</div>
							
							<br/><br/>
							<div class="contact-text-container max-width-200">
								
								<div class="detail-container text-center">
									<div class="text">Contact At:</div>
									<div class="email"><a href="#">john.doe@mail.com</a></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>
<!-- END -->

<!-- START -->


<!-- END -->
