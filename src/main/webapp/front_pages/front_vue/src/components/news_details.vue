<template>
  
    <div class="news_details" >
        <el-container >
            <el-aside>
                <el-button :plain="true" icon="el-icon-arrow-left" @click="backToList" style="color:#ffffff,background-color:#409EFF">返回</el-button>
            </el-aside>
            <el-header>
                <h2>{{newsList[newsid].title}}</h2>
            </el-header>
            <br>
            <el-main>
                <div>
                    <span v-html='newsList[newsid].description'></span>
                </div>
            </el-main>
             <br>
            
        </el-container>
    </div>
</template>

<script>
export default {
    name:"news_details",
    data(){
        
        return{
            newsList:['0'],
            title:"",
            pubDate:"",
            author:"",
            newsid:-1,
        };
    },
    methods:{
        getNewsList: function(){
          var that = this;
          var newsId=this.$route.params.id;
        this.$ajax.get('/api/politics.xml').then((res) => {
          var jsonObj = this.$x2js.xml2js(res.data);
          console.log(jsonObj.rss.channel.item);
          that.newsList= jsonObj.rss.channel.item;
          that.newsid=newsId;
        });
        },
        backToList(){
            this.$router.back(-1);
        }
    },
    created:function(){
        this.getNewsList();
    }
}
</script>

<style>
 .el-header, .el-footer {

    color: #333;
    text-align: center;
    line-height: 60px;
    margin-left: 15%;
    margin-right: 15%;
    font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
    box-lines: single；
  }
  
  
  .el-main {

    padding: 6px 4px;
    color: #333;
    text-align: left;
    margin-left: 15.5%;
    margin-right: 15.5%;
    font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
    font-size: large;
    letter-spacing: 1px;
    line-height: 40px;
  }
  
  body > .el-container {
    margin-bottom: 40px;
  }
  
  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }
  
  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  } 
</style>