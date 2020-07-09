<template>

<div class="newlist">
      <div class="grid-content bg-purple-light post_details" style="margin-right: 15%; margin-left: 15%;">
      <el-table :data="newsList"  border style="width:100%"  @row-click="newsDetails" >
        <el-table-column prop="pubDate" label="发布时间" width="110">
        </el-table-column>
        <el-table-column prop="author" label="新闻作者" width="140">
        </el-table-column>
        <el-table-column prop="title" label="新闻标题" >
        </el-table-column>
      </el-table>
      </div>
</div>


</template>

<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script>
export default {

    name:"newslist",
    data(){
        return{
            newsList:[],
            index:0,
            title:"",
            pubDate:"",
            author:"",
        };
    },
    methods:{
        getNewsList: function(){
          var that = this;
          
        this.$ajax.get('/api/politics.xml').then((res) => {
          var jsonObj = this.$x2js.xml2js(res.data);
          console.log(jsonObj.rss.channel.item);
          that.newsList= jsonObj.rss.channel.item;

        });
        },
        changePage: function (val) {
        this.currentPage = val;
        this.getNewsList();
        },
        newsDetails(row,event,column) {
        // console.log("row:" );
        // console.log(row);
        // console.log(row.description)
        // console.log("event: ");
        // console.log(event);
        // console.log("column: ");
        // console.log(column);
      console.log(this.newsList.indexOf(row));
        //window.location.href=row.link;
        this.$router.push(
        "/news_details/" + this.newsList.indexOf(row)
      );
      }
    } ,
    created: function(){
          console.log("Hello World!");
            this.getNewsList();
        }
        
}


</script>

<style>
.index {
  width: 100%;
  height: 100%;
}

.index_inner {
  width: 1000px;
  margin: auto;
}

.swiper_img {
  width: 1000px;
  height: 400px;
}

.post_details {
  margin: 5px;
  padding: 5px;
  border: 1px solid lightgray;
  border-radius: 5px;
  text-align: left;
}

.post_details_title {
  text-align: center;
  height: 40px;
  line-height: 40px;
  font-size: 18px;
}

.el-table .cell {
  white-space: nowrap;
}

.fr {
  float: right;
}

.cell {
  cursor: pointer;
}
</style>