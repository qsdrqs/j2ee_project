
<template>
<nav class="navbar">
      <div class="container navbar-content">
        <a href="#">首页</a>
      </div>
    </nav>
    <div class="container">
      <h1>新闻发布系统</h1>
      <h4></h4>
 
      <div class="news-list">
        <div class="news-list-left">
          <div class="news-list-item">
            <div class="author-time">
              <span>某经纪人</span> 发表于 <span>2020-07-20 18:07:10</span>
            </div>
            <div class="news-des">
              <h3 class="news-title"><i></i><a href="#">标题</a></h3>
              <div class="news-content-des">
                   待完善
              </div>
            </div>
          </div>
 
          <div class="news-list-item">
            <div class="author-time">
              <span>经纪人2</span> 发表于 <span>2020-07-20 18:07:10</span>
            </div>
            <div class="news-des">
              <h3 class="news-title"><i></i><a href="#">标题</a></h3>
              <div class="news-content-des">
                  待完善
              </div>
            </div>
          </div>
 
          <div class="news-list-item">
            <div class="author-time">
              <span>经纪人3</span> 发表于 <span>2014-07-20 18:07:10</span>
            </div>
            <div class="news-des">
              <h3 class="news-title"><i></i><a href="#">标题3</a></h3>
              <div class="news-content-des">
                        待完善
              </div>
            </div>
          </div>
 
          <div class="news-list-item">
            <div class="author-time">
              <span>经纪人4</span> 发表于 <span>2014-07-20 18:07:10</span>
            </div>
            <div class="news-des">
              <h3 class="news-title"><i></i><a href="#">标题4</a></h3>
              <div class="news-content-des">
               待完善
              </div>
            </div>
          </div>
        </div>
 
        <div class="news-list-right">
          <div class="about">
            <h4>关于我们</h4>
            <div class="about-des">
              <p>感谢使用</p>
            </div>
          </div>
        </div>
 
        <footer class="copyright">
          Copyright &nbsp; 2016 DreamBoy All rights reserved.
        </footer>
      </div>
    </div>
</template>
<script>
export default {
  name: "News",
  data() {},
  methods: {}
};
</script>
<style scoped>
body {
	margin: 0;
	padding: 0;
	font-family:"Microsoft YaHei", "微软雅黑", "consolas";
}
a {
	text-decoration: none;
	color: #000;
}
 
.clearfix { 
  *zoom: 1; 
}
.clearfix:before, .clearfix:after { 
  display: table; 
  line-height: 0; 
  content: "";
}
.clearfix:after { 
  clear: both;
} 
 
.navbar {
    background: url(../images/index/header_shadow.png) no-repeat left top;
    background-size: 100% 54px;
}
.container {
	width: 1000px;
	margin: 0 auto;
}
.navbar .navbar-content a {
	color: #FFF;
	line-height: 54px;
	display: inline-block;
	width: 100px;
	text-align: center;
}
.navbar .navbar-content a:hover {
	color: #CCC;
}
 
.index-bg {
	width: 100%;
	height: 500px;
 
	position: absolute;
	top: -50px;
	z-index: -10;
}
 
.news-list {
	margin: 50px 0;
	background-color: #FFF;
	border-radius: 5px;
	border: 1px solid #DDD;
	padding: 30px 20px;
 
	min-height: 300px;
}
.news-list:hover {
	box-shadow: 0 0 5px 3px #CCC;
}
 
.about .about-des {
	border-left: 5px solid #CCC;
	margin-top: 15px;
}
 
.about .about-des p {
	padding-left: 10px;
	line-height: 28px;
	text-indent: 2em;
}
 
.news-list-left {
	float: left;
	width: 729px;
	margin-bottom: 50px;
}
 
.news-list-right {
	float: right;
	width: 229px;
}
 
.news-list-item {
	padding: 20px 30px;
}
 
.author-time {
	font-size: 14px;
}
.news-des {
	padding-bottom: 20px;
	border-bottom: 2px solid #CCC;
}
.news-title {
	font-size: 23px;
}
.news-title i {
	display: inline-block;
	width: 47px;
	height: 43px;
	margin-right: 10px;
	background: url('../images/index/news-icon.png') left center no-repeat;
	vertical-align: middle;
}
.news-title a {
	color: green;
}
.news-title a:hover {
	text-decoration: underline;
}
.news-content-des {
	line-height: 28px;
}
 
.copyright {
	clear: both;
	text-align: center;
	color: gray;
 
	border-top: 2px solid #CCC;
	margin-top: 50px;
	padding: 20px 0;
}
</style>


