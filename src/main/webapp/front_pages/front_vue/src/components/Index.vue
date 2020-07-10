<template>
    <div class="index">
        <div class="index_inner">
            <div class="block">
                <el-carousel height="400px" :autoplay="true">
                    <el-carousel-item v-for="(item,index) in swiper" :key="index">
                        <img :src="item.imgUrl" class="swiper_img">
                    </el-carousel-item>
                </el-carousel>
            </div>
            <el-row>
                <el-col :span="12">
                    <div class="grid-content bg-purple-light post_details" style="margin-right: 0;">
                        <div class="post_details_title">
                            <span>新闻</span>
                            <el-button type="text" class="fr" @click="viewMoreNews">更多</el-button>
                        </div>
                        <el-table :data="newsList.slice(0,4)" style="width: 100%" stripe @row-click="newsDetails" max-height="250px" >
                            <el-table-column prop="pubDate" label="日期" width="100"></el-table-column>
                            <el-table-column prop="title" label="新闻标题"></el-table-column>
                        </el-table>
                    </div>
                </el-col>
              <el-col :span="12">
                <div class="grid-content bg-purple post_details" style="margin-left: 0;">
                  <div class="post_details_title">
                    <span>最新房屋信息</span>
                    <el-button type="text" class="fr" @click="viewMoreHouse">更多</el-button>
                  </div>
                  <el-table :data="newApartment" style="width: 100%" stripe @cell-click="openNewApartment">
                    <el-table-column prop="housetime" label="发布日期" width="100"></el-table-column>
                    <el-table-column prop="housetitle" label="房屋信息"></el-table-column>
                  </el-table>
                </div>
              </el-col>
            </el-row>
        </div>
    </div>
</template>

<script>
export default {
  name: "Index",
  data() {
    return {
      swiper: [{
        id:0,
        imgUrl:""
      },
      {
        id:1,
        imgUrl:""
      },
      {
        id:2,
        imgUrl:""
      }

      ],
      newApartment: [],
      newsList: [5],
      title:"",
      pubDate:"",
      currentPaage:1,
      pageSize:5
    };
  },
  methods: {
    getNewsList: function(){
          var that = this;
          
        this.$ajax.get('/api/politics.xml').then((res) => {
          var jsonObj = this.$x2js.xml2js(res.data);
          console.log(jsonObj.rss.channel.item);
          that.newsList= jsonObj.rss.channel.item;
          })
          },
     getList() {
       var that = this;
       this.$ajax.get("http://localhost:8080/house/findAllBypages?p=1").then(res => {
         
         that.newApartment = res.data[1];
         for (var i = 0; i < that.newApartment.length; i++) {
             that.newApartment[i].time = that.newApartment[i].post_time.slice(0, 10);
             that.newApartment[i].title = (that.newApartment[i].is_for_sell ? '[出售]' : '[出租]') + that.newApartment[i].title;
         }
          });
      },
  getImage() { 
    
for (var i = 0; i < 3; i++) {
  console.log(i)
            this.swiper[i].imgUrl ="/static/img/"+i+".jpg";
        }}
 ,    
    openNewApartment(row, column, cell, event) {
        this.$router.push('/house_details/' + row.id);
    },
    viewMoreHouse() {
        this.$router.push('/house_list/1');
    },
    viewMoreNews(){
      this.$router.push('/newslist')
    },
    newsDetails(row,event,column) {
        console.log("row:" );
        console.log(row);
        console.log(row.description)
        console.log("event: ");
        console.log(event);
        console.log("column: ");
        console.log(column);
        this.$router.push(
        "/news_details/" + this.newsList.indexOf(row)
      );
      }
  },
  created() {
    // this.getList();
    this.getImage();
    this.getNewsList();
  },
  mounted(){
    //this.getImage()
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
