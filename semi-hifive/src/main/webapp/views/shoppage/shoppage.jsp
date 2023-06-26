<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/shoppage/shopPage.css" />
<section>
      <div id="shopProfile">
        <div
          id="shopProfileLeft"
          style="background-image: url(img/shopPage/댓글1.jpg)"
        >
          <div id="blurImg"></div>
          <div id="userProfile">
            <img src="img/shopPage/댓글1.jpg" alt="" />
            <p>user01</p>
            <b>상품 6 </b>
            <b> 매너온도 43℃</b>
          </div>
        </div>
        <div id="shopProfileRight">
          <p>user01</p>
          <div id="shopDetail">
            <ion-icon name="storefront-outline" class="storeIcon"></ion-icon>
            <span>상점개설일</span>
            <b>154일전</b>
            <ion-icon name="bag-handle"></ion-icon>
            <span>상품수</span>
            <b>6</b>
            <ion-icon name="thermometer-outline"></ion-icon>
            <span>매너온도</span>
            <b>43℃</b>
            <ion-icon name="server-outline"></ion-icon>
            <span>거래횟수</span>
            <b>15</b>
          </div>
          <div id="shopIntro">
            <pre>
자기소개
입니다.

            </pre>
          </div>
        </div>
      </div>
      <div id="shopMain">
        <div id="shopBtn">
          <div class="radio-input">
            <label>
              <input
                type="radio"
                id="value-1"
                name="value-radio"
                value="value-1"
                checked
              />
              <span>상품 6</span>
            </label>
            <label>
              <input
                type="radio"
                id="value-2"
                name="value-radio"
                value="value-2"
              />
              <span>상점후기 15</span>
            </label>

            <span class="selection"></span>
          </div>
        </div>
        <hr width="1280px" color="#eeeeee" noshade />
        <div id="shopProductContainer">
          <div id="selectCategory">
            <div id="categoryName">
              <h4>전체 <span>(6)</span></h4>
            </div>
            <div id="categoryFunction">
              <span>최신순</span>
              <span>인기도순</span>
              <span>최고가순</span>
              <span>최저가순</span>
            </div>
          </div>
          <div id="productImgContainer">
            <div id="pimgWraper">
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
              <a href=""
                ><img
                  src="https://upload.wikimedia.org/wikipedia/ko/8/87/Kakaofriends.png"
                  alt=""
                />
                <p id="productName">상품</p>
                <p id="productPrice">1,000,000원 <span>2시간전</span></p>
                <p id="productPlace">
                  <i class="bi bi-geo-alt"></i>
                  ㅁㅁ시 ㅁㅁ구 ㅁㅁ동
                </p>
              </a>
            </div>
            <div id="pimgWraper">
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
              <a href=""
                ><img
                  src="https://upload.wikimedia.org/wikipedia/ko/8/87/Kakaofriends.png"
                  alt=""
                />
                <p id="productName">상품</p>
                <p id="productPrice">1,000,000원 <span>2시간전</span></p>
                <p id="productPlace">
                  <i class="bi bi-geo-alt"></i>
                  ㅁㅁ시 ㅁㅁ구 ㅁㅁ동
                </p>
              </a>
            </div>
            <div id="pimgWraper">
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
              <a href=""
                ><img
                  src="https://upload.wikimedia.org/wikipedia/ko/8/87/Kakaofriends.png"
                  alt=""
                />
                <p id="productName">상품</p>
                <p id="productPrice">1,000,000원 <span>2시간전</span></p>
                <p id="productPlace">
                  <i class="bi bi-geo-alt"></i>
                  ㅁㅁ시 ㅁㅁ구 ㅁㅁ동
                </p>
              </a>
            </div>
            <div id="pimgWraper">
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
              <a href=""
                ><img
                  src="https://upload.wikimedia.org/wikipedia/ko/8/87/Kakaofriends.png"
                  alt=""
                />
                <p id="productName">상품</p>
                <p id="productPrice">1,000,000원 <span>2시간전</span></p>
                <p id="productPlace">
                  <i class="bi bi-geo-alt"></i>
                  ㅁㅁ시 ㅁㅁ구 ㅁㅁ동
                </p>
              </a>
            </div>
            <div id="pimgWraper">
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
              <a href=""
                ><img
                  src="https://upload.wikimedia.org/wikipedia/ko/8/87/Kakaofriends.png"
                  alt=""
                />
                <p id="productName">상품</p>
                <p id="productPrice">1,000,000원 <span>2시간전</span></p>
                <p id="productPlace">
                  <i class="bi bi-geo-alt"></i>
                  ㅁㅁ시 ㅁㅁ구 ㅁㅁ동
                </p>
              </a>
            </div>
            <div id="pimgWraper">
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
              <a href=""
                ><img
                  src="https://upload.wikimedia.org/wikipedia/ko/8/87/Kakaofriends.png"
                  alt=""
                />
                <p id="productName">상품</p>
                <p id="productPrice">1,000,000원 <span>2시간전</span></p>
                <p id="productPlace">
                  <i class="bi bi-geo-alt"></i>
                  ㅁㅁ시 ㅁㅁ구 ㅁㅁ동
                </p>
              </a>
            </div>
          </div>
        </div>
        <div id="reviewContainer">
          <div id="reviewCount">
            <h4>상점후기 <span>(15)</span></h4>
          </div>
          <div class="shopReview">
            <div class="srProfile">
              <a href="">
                <img src="img/shopPage/댓글1.jpg" alt="" />
              </a>
              <a href="" class="srUser"><p>user02</p></a>
            </div>
            <p class="sr">친절하세요~</p>
            <span class="time">2023.05.15 15:25</span>
            <hr color="#eeeeee" noshade />
          </div>
          <div class="shopReview">
            <div class="srProfile">
              <a href="">
                <img src="img/shopPage/댓글1.jpg" alt="" />
              </a>
              <a href="" class="srUser"><p>user02</p></a>
            </div>
            <p class="sr">친절하세요~</p>
            <span class="time">2023.05.15 15:25</span>
            <hr color="#eeeeee" noshade />
          </div>
        </div>
      </div>
    </section>
<script
	src="<%=request.getContextPath()%>/js/shoppage/shopPage.js?v=<%=System.currentTimeMillis()%>"></script>
<%@ include file="/views/common/footer.jsp"%>