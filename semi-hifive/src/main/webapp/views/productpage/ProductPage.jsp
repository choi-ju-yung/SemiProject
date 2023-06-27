<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@ page
	import="com.semi.product.model.vo.Product,com.semi.product.model.vo.ProductFile,com.semi.productpage.model.vo.ProductUser,com.semi.productpage.model.vo.ProductCategory,com.semi.productpage.model.vo.ProductCommentUser,com.semi.productpage.model.vo.WishListCount,java.util.List,java.text.DecimalFormat"%>
<%
ProductCategory p = (ProductCategory) request.getAttribute("product");
List<WishListCount> w=(List) request.getAttribute("wishListCount");
List<ProductFile> files = (List) request.getAttribute("files");
List<ProductUser> users = (List) request.getAttribute("users");
List<ProductCommentUser> comments = (List) request.getAttribute("comments");
%>
<script>sessionStorage.setItem("commentCount",<%=comments.size()>0?comments.get(0).getCount():"0"%>);</script>
<script>
	sessionStorage.setItem("userId",'<%=p!=null?p.getProduct().getUserId():""%>');
</script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous">
	</script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/productpage/productPage.css" />
<section>

	<%if(p!=null) {%>{
	<div class="product">
		<div id="carouselExampleIndicators" class="carousel slide">
		
		
			<div class="carousel-indicators">
			<%for(int i=0;i<files.size();i++) {%>
				<%if(i==0) {%>
				<button type="button" data-bs-target="#carouselExampleIndicators"
					data-bs-slide-to="0" class="active" aria-current="true"
					aria-label="Slide 1"></button>
				<%}else{%>				
				<button type="button" data-bs-target="#carouselExampleIndicators"
					data-bs-slide-to="<%=i%>" aria-label="Slide <%=i+1%>"></button>
			<%} }%>		
			</div>
			<div class="carousel-inner">
				<%for(ProductFile pf:files){
				if(pf.getMainImageYn()=='Y'){ %>
				<div class="carousel-item active">
					<img src="<%=request.getContextPath()%>/upload/productRegist/<%=pf.getImageName() %>"
						class="d-block w-100" alt="…" />
				</div>
				<%}}				
				for(ProductFile pf:files){ 
				if(pf.getMainImageYn()!='Y'){%>
				<div class="carousel-item">
					<img
						src="<%=request.getContextPath()%>/upload/productRegist/<%=pf.getImageName() %>"
						class="d-block w-100" alt="…" />
				</div>
				<%}}%>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>

		<div class="productInfo">
			<input type="hidden" name="ajaxProductId"
				value="<%=p.getProduct().getProductId()%>">
			<div id="productCategory">
				<a href="">홈</a>
				<ion-icon name="chevron-forward-sharp"></ion-icon>
				<a href=""> <%=p.getCategory().getCategoryName()%></a>
				<ion-icon name="chevron-forward-sharp"></ion-icon>
				<a href=""> <%=p.getProduct().getSubCategoryName()%></a>
			</div>
			<h2 id="productName">
				<%=p.getProduct().getTitle()%><span id="productStatus"><p><%=p.getProduct().getSellStatus()%></p></span>
			</h2>

			<h2 id="productPrice"><%=p.getProduct().getPrice()%>원
			</h2>
			<hr width="695px" color="#eeeeee" noshade />
			<div class="productIcon">
				<div id="normalIcon">
					<ion-icon name="heart"></ion-icon>
					<b id="heartCount">
					<%if(w.size()>0){ %>
					 <%=w.get(0).getCount()%>
					 <%}else{ %>
					 0
					 <%} %>
					 </b>
					<ion-icon name="eye"></ion-icon>
					<b> <%=p.getProduct().getViewCount()%></b>
					<ion-icon name="time"></ion-icon>
					<b> <%=p.getProduct().getRegistTime()%></b>
				</div>
				<div id="ban">
					<a href=""><ion-icon name="ban"></ion-icon> <b> 신고하기</b> </a>
				</div>
			</div>
			<div class="productDetail">
				<table>
					<tr>
						<td>
							<ul class="productClass">
								<li>상품상태</li>
								<li>바로결제</li>
								<li>거래방식</li>
								<li>거래지역</li>
							</ul>
						</td>
						<td>
							<ul class="productId">
								<li><%=p.getProduct().getProductStatus()%></li>
								<li>가능</li>
								<li style="color: #20c997">직거래</li>
								<li><%=p.getProduct().getAreaName()%></li>
							</ul>
						</td>
					</tr>
				</table>
			</div>
			<div class="productBtn">
				<div id="heartBtn">
					<button>
						<ion-icon name="heart"></ion-icon>
						<b>찜하기</b>
						
						<%if(w.size()>0){
						for(WishListCount wc:w){ 
							String a=wc.getWishlist().getWishUserId();
						if(loginMember!=null&&loginMember.equals(a)){%>
						<input type="hidden" value="heartOn">
						<%}}} %>
					</button>
				</div>
				<div id="talkBtn">
					<button>
						<ion-icon name="chatbubbles"></ion-icon>
						<b> 바로결제</b>
					</button>
				</div>
				<div id="fraudBtn">
					<button>
						<ion-icon name="call"></ion-icon>
						<b> 사기조회</b>
					</button>
				</div>
			</div>
		</div>
	</div>
	<hr style="margin-top: 40px" color="#afafaf" noshade />
	<div class="productIntro">
		<div class="introContainer">
			<h3>상품정보</h3>
			<div id="explanation">
				<pre>
		<%=p.getProduct().getExplanation()%>
            </pre>
			</div>
			<div id="introTag">
				<div class="introBox">
					<ion-icon name="map-sharp"></ion-icon>
					<span>거래지역</span>
					<p><%=p.getProduct().getAreaName()%></p>
				</div>
				<div class="introBox">
					<ion-icon name="apps-sharp"></ion-icon>
					<span>카테고리</span>
					<p>
						<a href=""><%=p.getProduct().getSubCategoryName()%></a>
					</p>
				</div>
				<div class="introBox">
					<ion-icon name="pricetag-sharp"></ion-icon>
					<span>상품태그</span> <br>
					<p></p>
					<div>
					<%if(p.getProduct().getKeyword()!=null) {%>
					<%String keywordArr[]=(p.getProduct().getKeyword()).split(","); 
						for(int i=0;i<keywordArr.length;i++){%>
					<a href="">
						<%=keywordArr[i] %>
					</a>						
				<%}} else{ %>
					<p>없음</p>			
						<%} %>
					</div>
				</div>
			</div>
		</div>
		<div class="shopInfo">
			<h3>상점정보</h3>
			<div class="shopProfile">
				<div id="profile">
					<a href=""><img
						src="<%=request.getContextPath()%>/upload/profileImg/<%=users.get(0).getMember().getProfileImg() %>"
						alt="" /></a>
				</div>
				<div id="userInfo">
					<a id="userName" href=""><p><%=users.get(0).getMember().getNickName()%></p></a> <a
						id="userProduct" href=""><p>상품 <%=users.get(0).getCount() %></p></a>
				</div>
				<div id="userManner">
					<ion-icon name="thermometer-outline"></ion-icon>
					<b><%=users.get(0).getMember().getTemperature() %>℃</b>
				</div>
			</div>
			<div id="otherProduct">
				<div id="opContent">
					<p>
						<%=users.get(0).getMember().getNickName()%>님의 판매 상품 <strong style="color: #20c997"><%=users.get(0).getCount() %></strong>
					</p>
					<a href="">더보기 <ion-icon name="chevron-forward-sharp"></ion-icon>
					</a>
				</div>
				<div id="opContainer">
					<%for(int i=0;i<3;i++){ %>
					<div class="opProduct">
						<a href=""> <img
							src="<%=request.getContextPath()%>/upload/productregist/<%=users.get(i).getFile().getImageName() %>"
							alt="" />							

							<p class="opPrice"><%=String.valueOf(users.get(i).getProduct().getPrice()).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",")%>원</p>
							<%String a=(users.get(i).getProduct().getTitle()).substring(0,6); String b="….."; %>
							<p class="opName"><%= a+b %></p>
						</a>
					</div>
					<%} %>
				</div>
			</div>
		</div>
	</div>
	<div id="comment">
		<h4>
			댓글 <span class="commentCount"><%=comments.size()>0?comments.get(0).getCount():0%></span>
		</h4>
		<%
		if (loginMember != null) {
		%>
		<form class="cmtForm">
			<div class="textContainer">
				<textarea id="cmtText" placeholder="댓글을 입력하세요" name="content"></textarea>
				<input type="hidden" name="productId" value="<%=p.getProduct().getProductId()%>">
				<input type="hidden" name="userId" value="<%=loginMember.getUserId()%>"> 
				<input type="hidden"name="level" value="1">
				 <input type="hidden"name="nickName" value="<%=loginMember.getNickName()%>">
				 <input type="hidden" name="commentRef" value="0">
				<div class="tcBtn">
					<button type="button" class="cancelBtn">취소</button>
					<button type="button" class="cmtBtn">등록</button>
				</div>
			</div>
			<hr color="#eeeeee" noshade />
		</form>
		<%
				}
		%>
		<hr>

		<%
				if (comments.size()>0) {
			for (ProductCommentUser pc : comments) {
				if (pc.getProductComment().getCommentLevel() == 1) {
		%>
		<div class="cmtContainer">
			<div class="cmtProfile">
				<a href=""> <img name="userProfile"
					src="<%=request.getContextPath()%>/images/productpage/comment1.jpg"
					alt="" />
				</a> <input type="hidden" name="pUserId" value="<%=p.getProduct().getUserId()%>">
				<a href="" class="cmtUser" name="userId" id="tagName"> <%=pc.getMember().getNickName()%>
					<% if (pc.getProduct().getUserId().equals(p.getProduct().getUserId())) {%> <span
					id="rcmtWriter">작성자</span> <% }%>
				</a>
			</div>
			<p class="cmt" name="content"><%=pc.getProductComment().getContent()%>
			</p>
			<span class="time" name="enrollDate"><%=pc.getProductComment().getEnrollDate()%></span>
			<%
			if (loginMember != null) {
			%>
			<button class="writeCmt" value="<%=pc.getProductComment().getCommentNo()%>">답글쓰기</button>
			<%
			if (loginMember.getUserId().equals(pc.getProductComment().getUserId())) {
			%>
			<button class="changeCmt">수정하기</button>
			<button class="deleteCmt">삭제하기</button>

			<%
			}
			%>
			<%
			}
			%>
			<input type="hidden" name="commentNo" value=<%=pc.getProductComment().getCommentNo()%>>
			<input type="hidden" name="commentRef2" value=<%=pc.getProductComment().getCommentRef()%>>
			<hr color="#eeeeee" noshade />
		</div>
		<%
		} else {
		%>
		<div id="arrow"></div>
		<div class="reComment">
			<div class="cmtProfile">
				<a href=""> <img
					src="<%=request.getContextPath()%>/images/productpage/profile.jpg"
					alt="" />
				</a> <a href="" class="cmtUser"><%=pc.getMember().getNickName()%> <% if (pc.getProductComment().getUserId().equals(p.getProduct().getUserId())) {%>
					<span id="rcmtWriter">작성자</span> <% }%> </a>
			</div>
			<p class="cmtx" id="reTagName"></p>
			<p class="cmt"><%=pc.getProductComment().getContent()%></p>
			<span class="time"><%=pc.getProductComment().getEnrollDate()%></span>
			<%
			if (loginMember != null) {
			%>
			<button class="writeCmt" value="<%=pc.getProductComment().getCommentNo()%>">답글쓰기</button>
			<%
			if (loginMember.getUserId().equals(pc.getProductComment().getUserId())) {
			%>
			<button class="changeCmt">수정하기</button>
			<button class="deleteCmt">삭제하기</button>

			<%
			}
			%>
			<%
			}
			%>
			<input type="hidden" name="commentNo" value=<%=pc.getProductComment().getCommentNo()%>>
			<input type="hidden" name="commentRef2" value=<%=pc.getProductComment().getCommentRef()%>>
			<hr color="#eeeeee" noshade />
		</div>
		<%
		}
		}
		%>
		<%
		}
		%>


	</div>
	<div id="relateProduct">
		<h2>연관상품</h2>
		<div id="rpContainer">
			<div class="rProduct">
				<a href=""><img
					src="<%=request.getContextPath()%>/images/productpage/연관1.jpg"
					alt="" />
					<p>갤럭시23</p></a>
			</div>
			<div class="rProduct">
				<a href=""><img
					src="<%=request.getContextPath()%>/images/productpage/연관2.jpg"
					alt="" />
					<p>중고폰매입 파손폰매입…</p></a>
			</div>
			<div class="rProduct">
				<a href=""><img
					src="<%=request.getContextPath()%>/images/productpage/연관3.jpg"
					alt="" />
					<p>아이폰 12프로맥스 128기…</p></a>
			</div>
			<div class="rProduct">
				<a href=""><img
					src="<%=request.getContextPath()%>/images/productpage/연관4.jpg"
					alt="" />
					<p>파손폰매입 중고폰매입…</p></a>
			</div>
			<div class="rProduct">
				<a href=""><img
					src="<%=request.getContextPath()%>/images/productpage/연관5.jpg"
					alt="" />
					<p>아이폰14pro 128기가</p></a>
			</div>
			<div class="rProduct">
            <a href=""><img src="./img/연관6.jpg" alt="" />
              <p>중고폰매입 파손폰매입…</p></a>
          </div>
		</div>
	</div>
	<%} else{%>
		<div id="notProduct">
	<h2>존재하지 않는 상품입니다.</h2>
		</div>
		
	<%} %>
</section>
<script
	src="<%=request.getContextPath()%>/js/productpage/productPage.js?v=<%=System.currentTimeMillis()%>"></script>
<%@ include file="/views/common/footer.jsp"%>