<template>
    <div class="index">
        <div class="index_inner">
            <div class="block">
                <el-carousel height="400px" :autoplay="true">
                    <el-carousel-item v-for="(item,index) in swiper" :key="index">
                        <img :src="item" class="swiper_img">
                    </el-carousel-item>
                </el-carousel>
            </div>
            <el-row>
                <el-col :span="12">
                    <div class="grid-content bg-purple-light post_details" style="margin-right: 0;">
                        <div class="post_details_title">
                            <span>鏂伴椈</span>
                            <el-button type="text" class="fr" @click="viewMoreNews">鏇村</el-button>
                        </div>
                        <el-table :data="hotApartment" style="width: 100%" stripe @cell-click="openNews">
                            <el-table-column prop="time" label="鏃ユ湡" width="100"></el-table-column>
                            <el-table-column prop="title" label="鏂伴椈鏍囬"></el-table-column>
                        </el-table>
                    </div>
                </el-col>
              <el-col :span="12">
                <div class="grid-content bg-purple post_details" style="margin-left: 0;">
                  <div class="post_details_title">
                    <span>鏈�鏂版埧灞嬩俊鎭�</span>
                    <el-button type="text" class="fr" @click="viewMoreHouse">鏇村</el-button>
                  </div>
                  <el-table :data="newApartment" style="width: 100%" stripe @cell-click="openNewApartment">
                    <el-table-column prop="time" label="鍙戝竷鏃ユ湡" width="100"></el-table-column>
                    <el-table-column prop="title" label="鎴垮眿淇℃伅"></el-table-column>
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
      swiper: [
        "/static/img/home0.jpg",
        "/static/img/home1.jpg",
        "/static/img/home2.jpg"
      ],
      newApartment: [],
      hotApartment: []
    };
  },
  methods: {
    getList() {
      var that = this;//TODO:淇敼鎴愭柊闂荤殑瀹㈡埛绔垪琛�,澧炲姞鏂伴椈璇︽儏椤甸潰
      this.$ajax.get("http://localhost:3333/house/index").then(res => {
        that.hotApartment = res.data[0];
        that.newApartment = res.data[1];
        for (var i = 0; i < that.hotApartment.length; i++) {
            that.hotApartment[i].time = that.hotApartment[i].post_time.slice(0, 10);
            that.hotApartment[i].title = (that.hotApartment[i].is_for_sell ? '[鍑哄敭]' : '[鍑虹]') + that.hotApartment[i].title;
        }
        for (var i = 0; i < that.newApartment.length; i++) {
            that.newApartment[i].time = that.newApartment[i].post_time.slice(0, 10);
            that.newApartment[i].title = (that.newApartment[i].is_for_sell ? '[鍑哄敭]' : '[鍑虹]') + that.newApartment[i].title;
        }
        for(var i=0;i < that.swiper.length;i++) {
          var patt=/*.jpg/;
          swiper[]=swiper.match(patt);
      });
    },
    openNewApartment(row, column, cell, event) {
        this.$router.push('/house_details/' + row.id);
    },
    openNews(row, column, cell, event) {
        this.$router.push('/news_details/' + row.id);
    },
    viewMoreHouse() {
        this.$router.push('/house_list/1');
    },
    viewMoreNews(){
      this.$router.push('/newslist')
    }
  },
  created() {
    this.getList();
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
