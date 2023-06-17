<%@page import="com.semi.product.model.vo.ProductDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	List<ProductDto> productlist = (List)request.getAttribute("productlist");
%>

<%@ include file="/views/common/header.jsp" %>
<link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
    />
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css"
    />
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
    />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"
    />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/productsearchchartpage.css" />
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.3.0/dist/chart.umd.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
	
	<section>
      <div id="wraperContainer">
        <div id="leftCategory">
          <div id="pdcContainer">
            <div class="pdcCategoryMain">
              <span
                id="categoryMain"
                data-toggle="collapse"
                href="#pddCategory"
                aria-expanded="false"
                aria-controls="pddCategory"
              >
                <b>카테고리</b>
                <i class="bi bi-caret-down-fill"></i>
              </span>
             <%--  <%if(categorylist.isEmpty()) {%>
                
                <%for(CategoryDto c : categorylist){%>
                	<li><a href=""><%=c.getCategoryname()%></a></li>
                <%} }%>  --%>
              <div class="collapse" id="pddCategory">
                <div id="pddContainer">
                  <ul>
                    <div class="pdcCategory">
                      <span>카테고리1</span>
                      <i
                        class="fa fa-plus-square"
                        data-toggle="collapse"
                        href="#pddCategory1"
                        aria-expanded="false"
                        aria-controls="pddCategory1"
                      ></i>

                      <div class="collapse" id="pddCategory1">
                        <ul>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                        </ul>
                      </div>
                    </div>
                    <div class="pdcCategory">
                      <span>카테고리2</span>
                      <i
                        class="fa fa-plus-square"
                        data-toggle="collapse"
                        href="#pddCategory2"
                        aria-expanded="false"
                        aria-controls="pddCategory2"
                      ></i>

                      <div class="collapse" id="pddCategory2">
                        <ul>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                        </ul>
                      </div>
                    </div>
                    <div class="pdcCategory">
                      <span>카테고리3</span>
                      <i
                        class="fa fa-plus-square"
                        data-toggle="collapse"
                        href="#pddCategory3"
                        aria-expanded="false"
                        aria-controls="pddCategory3"
                      ></i>

                      <div class="collapse" id="pddCategory3">
                        <ul>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                        </ul>
                      </div>
                    </div>
                    <div class="pdcCategory">
                      <span>카테고리4</span>
                      <i
                        class="fa fa-plus-square"
                        data-toggle="collapse"
                        href="#pddCategory4"
                        aria-expanded="false"
                        aria-controls="pddCategory4"
                      ></i>

                      <div class="collapse" id="pddCategory4">
                        <ul>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                        </ul>
                      </div>
                    </div>
                    <div class="pdcCategory">
                      <span>카테고리5</span>
                      <i
                        class="fa fa-plus-square"
                        data-toggle="collapse"
                        href="#pddCategory5"
                        aria-expanded="false"
                        aria-controls="pddCategory5"
                      ></i>

                      <div class="collapse" id="pddCategory5">
                        <ul>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                        </ul>
                      </div>
                    </div>
                    <div class="pdcCategory">
                      <span>카테고리6</span>
                      <i
                        class="fa fa-plus-square"
                        data-toggle="collapse"
                        href="#pddCategory6"
                        aria-expanded="false"
                        aria-controls="pddCategory6"
                      ></i>

                      <div class="collapse" id="pddCategory6">
                        <ul>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                        </ul>
                      </div>
                    </div>
                    <div class="pdcCategory">
                      <span>카테고리7</span>
                      <i
                        class="fa fa-plus-square"
                        data-toggle="collapse"
                        href="#pddCategory7"
                        aria-expanded="false"
                        aria-controls="pddCategory7"
                      ></i>

                      <div class="collapse" id="pddCategory7">
                        <ul>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                        </ul>
                      </div>
                    </div>
                    <div class="pdcCategory">
                      <span>카테고리8</span>
                      <i
                        class="fa fa-plus-square"
                        data-toggle="collapse"
                        href="#pddCategory8"
                        aria-expanded="false"
                        aria-controls="pddCategory8"
                      ></i>

                      <div class="collapse" id="pddCategory8">
                        <ul>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                        </ul>
                      </div>
                    </div>
                    <div class="pdcCategory">
                      <span>카테고리9</span>
                      <i
                        class="fa fa-plus-square"
                        data-toggle="collapse"
                        href="#pddCategory9"
                        aria-expanded="false"
                        aria-controls="pddCategory9"
                      ></i>

                      <div class="collapse" id="pddCategory9">
                        <ul>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                        </ul>
                      </div>
                    </div>
                    <div class="pdcCategory">
                      <span>카테고리10</span>
                      <i
                        class="fa fa-plus-square"
                        data-toggle="collapse"
                        href="#pddCategory10"
                        aria-expanded="false"
                        aria-controls="pddCategory5"
                      ></i>

                      <div class="collapse" id="pddCategory10">
                        <ul>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                          <li><a href="">세부카테고리</a></li>
                        </ul>
                      </div>
                    </div>
                  </ul>
                </div>
              </div>
              <hr />
            </div>
          </div>
          <div id="productCondition">
            <span
              id="categoryMain"
              data-toggle="collapse"
              href="#prdCategory"
              aria-expanded="false"
              aria-controls="prdCategory"
            >
              <b>상품상태</b>
              <i class="bi bi-caret-down-fill"></i>
            </span>

            <div class="collapse" id="prdCategory">
              <form>
                <label>
                  <input type="radio" name="radio" checked="" />
                  <span>전체</span>
                </label>
                <label>
                  <input type="radio" name="radio" />
                  <span>미개봉</span>
                </label>
                <!-- <label>
                  <input type="radio" name="radio" />
                  <span>거의새것</span>
                </label> -->
                <label>
                  <input type="radio" name="radio" />
                  <span>사용감 있음</span>
                </label>
              </form>
            </div>
            <hr />
          </div>
          <div id="priceWraper">
            <span
              id="categoryMain"
              data-toggle="collapse"
              href="#priceCategory"
              aria-expanded="false"
              aria-controls="priceCategory"
            >
              <b>가격</b>
              <i class="bi bi-caret-down-fill"></i>
            </span>
            <div class="collapse" id="priceCategory">
              <div class="radio-buttons">
                <label class="radio-button">
                  <input
                    value="option1"
                    name="option"
                    type="radio"
                    checked=""
                  />
                  <div class="radio-circle"></div>
                  <span class="radio-label">전체</span>
                </label>
              </div>
              <div class="radio-buttons">
                <label class="radio-button">
                  <input value="option1" name="option" type="radio" />
                  <div class="radio-circle"></div>
                  <span class="radio-label">10만원 이하</span>
                </label>
                <label class="radio-button">
                  <input value="option2" name="option" type="radio" />
                  <div class="radio-circle"></div>
                  <span class="radio-label">10~30만원</span>
                </label>
                <label class="radio-button">
                  <input value="option3" name="option" type="radio" />
                  <div class="radio-circle"></div>
                  <span class="radio-label">30~50만원</span>
                </label>
                <label class="radio-button">
                  <input value="option3" name="option" type="radio" />
                  <div class="radio-circle"></div>
                  <span class="radio-label">50~100만원</span>
                </label>
                <label class="radio-button">
                  <input value="option3" name="option" type="radio" />
                  <div class="radio-circle"></div>
                  <span class="radio-label">100만원 이상</span>
                </label>
              </div>
              <div id="prcContainer">
                <b>직접입력</b>
                <div class="prcSearch">
                  <input
                    type="text"
                    name="text"
                    class="prcinput"
                    placeholder="최소값"
                    maxlength="10"
                    onkeyup="inputNumberFormat(this);"
                  />
                  <div class="highlight"></div>
                </div>
                <div class="prcSearch">
                  <input
                    type="text"
                    name="text"
                    class="prcinput"
                    placeholder="최대값"
                    maxlength="10"
                    onkeyup="inputNumberFormat(this);"
                  />
                  <div class="highlight"></div>
                </div>
                <button id="prcBtn">검색</button>
              </div>
            </div>
            <hr />
          </div>
          <div id="localWraper">
            <span
              id="categoryMain"
              data-toggle="collapse"
              href="#localCategory"
              aria-expanded="false"
              aria-controls="localCategory"
            >
              <b>지역</b>
              <i class="bi bi-caret-down-fill"></i>
            </span>
            <div class="collapse" id="localCategory">
              <select name="sido1" id="sido1"></select>
              <select name="gugun1" id="gugun1"></select>
            </div>
          </div>
        </div>
        <div id="productContainer">
          <div id="selectCategory">
            <div id="categoryName">
              <h4>스마트폰 <span>(453)</span></h4>
            </div>
            <div id="categoryFunction">
              <span>최신순</span>
              <span>인기도순</span>
              <span>최고가순</span>
              <span>최저가순</span>
            </div>
          </div>
          <div id="test"></div>
          <div id="productImgContainer">
           <%if(productlist.isEmpty()){ %>
          
          <%}else{
        	  for(ProductDto p : productlist){%>
            <div id="pimgWraper" onclick="location.href='<%=request.getContextPath()%>/productpage?no=<%=p.getProductId()%>';">
              <div class="con-like">
                <input title="like" type="checkbox" class="like" />
                <div class="checkmark">
                  <svg
                    viewBox="0 0 24 24"
                    class="outline"
                    xmlns="http://www.w3.org/2000/svg"
                  >
                    <path
                      d="M17.5,1.917a6.4,6.4,0,0,0-5.5,3.3,6.4,6.4,0,0,0-5.5-3.3A6.8,6.8,0,0,0,0,8.967c0,4.547,4.786,9.513,8.8,12.88a4.974,4.974,0,0,0,6.4,0C19.214,18.48,24,13.514,24,8.967A6.8,6.8,0,0,0,17.5,1.917Zm-3.585,18.4a2.973,2.973,0,0,1-3.83,0C4.947,16.006,2,11.87,2,8.967a4.8,4.8,0,0,1,4.5-5.05A4.8,4.8,0,0,1,11,8.967a1,1,0,0,0,2,0,4.8,4.8,0,0,1,4.5-5.05A4.8,4.8,0,0,1,22,8.967C22,11.87,19.053,16.006,13.915,20.313Z"
                    ></path>
                  </svg>
                  <svg
                    viewBox="0 0 24 24"
                    class="filled"
                    xmlns="http://www.w3.org/2000/svg"
                  >
                    <path
                      d="M17.5,1.917a6.4,6.4,0,0,0-5.5,3.3,6.4,6.4,0,0,0-5.5-3.3A6.8,6.8,0,0,0,0,8.967c0,4.547,4.786,9.513,8.8,12.88a4.974,4.974,0,0,0,6.4,0C19.214,18.48,24,13.514,24,8.967A6.8,6.8,0,0,0,17.5,1.917Z"
                    ></path>
                  </svg>
                  <svg
                    class="celebrate"
                    width="100"
                    height="100"
                    xmlns="http://www.w3.org/2000/svg"
                  >
                    <polygon points="10,10 20,20" class="poly"></polygon>
                    <polygon points="10,50 20,50" class="poly"></polygon>
                    <polygon points="20,80 30,70" class="poly"></polygon>
                    <polygon points="90,10 80,20" class="poly"></polygon>
                    <polygon points="90,50 80,50" class="poly"></polygon>
                    <polygon points="80,80 70,70" class="poly"></polygon>
                  </svg>
                </div>
              </div>

             
                <div id="payBtn">
                  <span>하마페이</span>
                </div>
                <img
                  src="https://upload.wikimedia.org/wikipedia/ko/8/87/Kakaofriends.png"
                  alt=""
                />
                <p id="productName"><%=p.getProducttitle()%></p>
                <p id="productPrice"><%=p.getPrice()%>
                <span><%if(p.getElapsedtime() < 60){%>
               		<%=p.getElapsedtime()+ "초 전"%>
               	<%}else if(p.getElapsedtime() >= 60 && p.getElapsedtime() < 3600) {%>
               	<%=(p.getElapsedtime() / 60) + "분 전"%>
               	<%}else if(p.getElapsedtime() >= 3600 && p.getElapsedtime() < 86400) {%>
               		<%=(p.getElapsedtime() / 60) / 60  + "시간 전"%>
               	<%}else if(p.getElapsedtime() >= 86400 && p.getElapsedtime() < 2592000) {%>
               		<%=(p.getElapsedtime() / 60) / 60 / 24 + "일 전"%>
               	<%}else if(p.getElapsedtime() >= 2592000 && p.getElapsedtime() < 31536000) {%>
               		<%=(p.getElapsedtime() / 60) / 60 / 24 / 30 + "개월 전"%>
               	<%}else{%>
               		<%=(p.getElapsedtime() / 60) / 60 / 24 / 30 / 12 + "년 전"%>
               	<%} %></span></p>
                <p id="productPlace">
                  <i class="bi bi-geo-alt"></i>
                  <%=p.getGoonguareaid()%>
                </p>
              
            </div>
          <%}} %>
          </div>
          
          <div class="pageContainer">
            <ul class="page-list">
            	<%=request.getAttribute("pageBar")%>
            </ul>
          </div>
        </div>
      </div>

      <script></script>
    </section>
    <footer>
      <div id="footer">
        <div id="teamIntro">
          <img src="img/header/hifivefooter.png" alt="" />
        </div>
        <div id="memberIntro">
          <div class="member">
            <p>김찬은</p>
            <a href=""><p>본인페이지</p></a>
            <a href=""><p>본인페이지</p></a>
            <a href=""><p>본인페이지</p></a>
          </div>
          <div class="member">
            <p>김현영</p>
            <a href=""><p>본인페이지</p></a>
            <a href=""><p>본인페이지</p></a>
            <a href=""><p>본인페이지</p></a>
          </div>
          <div class="member">
            <p>이은지</p>
            <a href=""><p>본인페이지</p></a>
            <a href=""><p>본인페이지</p></a>
            <a href=""><p>본인페이지</p></a>
          </div>
          <div class="member">
            <p>최주영</p>
            <a href=""><p>본인페이지</p></a>
            <a href=""><p>본인페이지</p></a>
            <a href=""><p>본인페이지</p></a>
          </div>
          <div class="member">
            <p>허성현</p>
            <a href=""><p>본인페이지</p></a>
            <a href=""><p>본인페이지</p></a>
            <a href=""><p>본인페이지</p></a>
          </div>
        </div>
      </div>
    </footer>
    <!-- js호출 -->
    <script src="<%=request.getContextPath()%>/js/productsearchchartpage/test.js"></script>
  </body>
</html>



<%@ include file="/views/common/footer.jsp" %>