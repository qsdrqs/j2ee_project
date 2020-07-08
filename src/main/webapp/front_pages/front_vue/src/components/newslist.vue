<template>
<div class="newlist">
      <div class="grid-content bg-purple-light post_details" style="margin-right: 15%; margin-left: 15%;">
                <el-table :data="newsInfo" style="width: 100%" @cell-click="openNews">
                    <el-table-column prop="newsinfo" label="日期" width="100"></el-table-column>
                    <el-table-column prop="title" label="新闻标题"></el-table-column>
                </el-table>
        </div>
      <div class="page_block">
      <el-pagination layout="prev, pager, next" :total="total" @current-change="changePage">
      </el-pagination>
    </div>
</div>

</template>

<script>
export default {
    name:"newslist",
    data(){
        return{
            newsInfo:"",
            title:"",
            currentPage: 1,
            total: 0,
            pageSize:10,
        };
    },
    methods:{
        getNewsList: function(){
          var that = this;
          
          this.$axios
        .get('https://rsshub.app/bilibili/ranking/0/3?limit=10.atom')
        .then(function (res) {
          console.log(res);
          that.newsInfo = res.data.channel.title;
        });
        },
        // changePage: function (val) {
        // this.currentPage = val;
        // this.getNewsList();
        // },
        // openNews(row,column,cell,evebt){
        //     this.$router.push('/news_details/'+row.id)
        // },
        created: function(){
          console.log("Hello World!");
            this.getNewsList();
        }
    }
};
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