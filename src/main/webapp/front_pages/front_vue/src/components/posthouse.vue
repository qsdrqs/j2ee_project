<template>
	<div class="form">
		<h2>发布房源</h2>
		<br>
		<el-form ref="form" :model="form" label-width="80px">
			<el-form-item label="租售类型">
				<el-radio-group v-model="form.is_for_sell" style="width: 100%;">
					<el-radio label="1">出售</el-radio>
					<el-radio label="0">出租</el-radio>
				</el-radio-group>
			</el-form-item>
			<el-form-item label="房屋标题" prop="title">
				<el-input v-model="form.title"></el-input>
			</el-form-item>
			<el-form-item label="房屋描述" prop="description">
				<el-input v-model="form.description"></el-input>

			</el-form-item>
			<el-form-item label="小区名称" prop="properties">
			<baidu-map>
    		<bm-auto-complete >
				<el-input v-model="form.properties"></el-input>
    		</bm-auto-complete>
			</baidu-map>
			</el-form-item>

<!--			<el-form-item label="总价格" prop="price">-->
<!--				<el-input v-model="form.price" @change="countUnitPrice"></el-input>-->
<!--			</el-form-item>-->
			<el-form-item label="建筑面积" prop="area">
				<el-input v-model="form.area" @change="countUnitPrice"></el-input>
			</el-form-item>
<!--			<el-form-item label="套内面积" prop="inside_area">-->
<!--				<el-input v-model="form.inside_area"></el-input>-->
<!--			</el-form-item>-->
			<el-form-item label="单价" prop="unit_price">
				<el-input v-model="form.unit_price"></el-input>
			</el-form-item>
			<el-form-item label="房间数量" prop="room_num">
				<el-input v-model="form.room_num"></el-input>
			</el-form-item>
			<el-form-item label="厅数量" prop="livingroom_num">
				<el-input v-model="form.livingroom_num"></el-input>
			</el-form-item>
<!--			<el-form-item label="厨房数量" prop="kitchen_num">-->
<!--				<el-input v-model="form.kitchen_num"></el-input>-->
<!--			</el-form-item>-->
<!--			<el-form-item label="卫生间数" prop="bathroom_num">-->
<!--				<el-input v-model="form.bathroom_num"></el-input>-->
<!--			</el-form-item>-->
<!--			<el-form-item label="总楼层数" prop="total_floor">-->
<!--				<el-input v-model="form.total_floor"></el-input>-->
<!--			</el-form-item>-->
			<el-form-item label="所在楼层" prop="floor">
				<el-input v-model="form.floor"></el-input>
			</el-form-item>
<!--			<el-form-item label="建筑年份" prop="description">-->
<!--				<el-input v-model="form.build_year"></el-input>-->
<!--			</el-form-item>-->

<!--			<el-form-item label="可预约的看房时间" prop="view_time">-->
<!--				<el-input v-model="form.view_time"></el-input>-->
<!--			</el-form-item>-->
<!--			<el-form-item label="建筑结构" prop="construction_type">-->
<!--				<el-select v-model="form.construction_type" style="width: 100%" placeholder="请选择建筑结构">-->
<!--					<el-option label="砌体结构" value="砌体结构"></el-option>-->
<!--					<el-option label="钢筋混凝土结构" value="钢筋混凝土结构"></el-option>-->
<!--					<el-option label="钢结构" value="钢结构"></el-option>-->
<!--					<el-option label="木结构" value="木结构"></el-option>-->
<!--				</el-select>-->
<!--			</el-form-item>-->
<!--			<el-form-item label="房屋朝向" prop="direction">-->
<!--				<el-input v-model="form.direction"></el-input>-->
<!--			</el-form-item>-->
<!--			<el-form-item label="建筑类型" prop="type">-->
<!--				<el-select v-model="form.type" style="width: 100%" placeholder="请选择建筑类型">-->
<!--					<el-option label="塔楼" value="塔楼"></el-option>-->
<!--					<el-option label="板楼" value="板楼"></el-option>-->
<!--					<el-option label="板塔结合" value="板塔结合"></el-option>-->
<!--				</el-select>-->
<!--			</el-form-item>-->
			<el-form-item label="装修情况" prop="decoration">
				<el-select v-model="form.decoration" style="width: 100%" placeholder="请选择装修情况">
					<el-option label="精装" value="精装"></el-option>
					<el-option label="简装" value="简装"></el-option>
					<el-option label="毛胚房" value="毛胚房"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="电梯数量" prop="lift">
				<el-input v-model="form.lift"></el-input>
			</el-form-item>
<!--			<el-form-item label="每层房数" prop="house_per_floor">-->
<!--				<el-input v-model="form.house_per_floor"></el-input>-->
<!--			</el-form-item>-->
<!--			<el-form-item label="上次交易" prop="last_trade">-->
<!--				<el-input v-model="form.last_trade"></el-input>-->
<!--			</el-form-item>-->
<!--			<el-form-item label="交易权属" prop="trading_right">-->
<!--				<el-input v-model="form.trading_right"></el-input>-->
<!--			</el-form-item>-->
<!--			<el-form-item label="房屋用途" prop="house_usage">-->
<!--				<el-select v-model="form.house_usage" style="width: 100%" placeholder="请选择房屋用途">-->
<!--					<el-option label="普通住宅" value="1"></el-option>-->
<!--					<el-option label="别墅" value="2"></el-option>-->
<!--					<el-option label="商用" value="3"></el-option>-->
<!--					<el-option label="商住两用" value="4"></el-option>-->
<!--					<el-option label="四合院" value="5"></el-option>-->
<!--				</el-select>-->
<!--			</el-form-item>-->
<!--			<el-form-item label="产权年限" prop="age_limit">-->
<!--				<el-input v-model="form.age_limit"></el-input>-->
<!--			</el-form-item>-->
<!--			<el-form-item label="房屋年龄" prop="house_age">-->
<!--				<el-input v-model="form.house_age"></el-input>-->
<!--			</el-form-item>-->
<!--			<el-form-item label="抵押信息" prop="mortgage">-->
<!--				<el-input v-model="form.mortgage"></el-input>-->
<!--			</el-form-item>-->
<!--			<el-form-item label="产权所属" prop="house_right">-->
<!--				<el-input v-model="form.house_right"></el-input>-->
<!--			</el-form-item>-->
<!--			<el-form-item label="房屋标签" prop="house_label">-->
<!--				<el-input v-model="form.house_label"></el-input>-->
<!--			</el-form-item>-->
			<el-form-item label="装修描述" prop="decoration_desc">
				<el-input v-model="form.decoration_desc"></el-input>
			</el-form-item>
			<el-form-item label="主要卖点" prop="main_sellpoint">
				<el-input v-model="form.main_sellpoint"></el-input>
			</el-form-item>
<!--			<el-form-item label="周边配套" prop="facility">-->
<!--				<el-input v-model="form.facility"></el-input>-->
<!--			</el-form-item>-->
			<el-form-item label="交通出行" prop="traffic">
				<el-input v-model="form.traffic"></el-input>
			</el-form-item>
			<el-form-item label="图片上传">
				<el-upload
          class="upload-demo"
          action="/api/picture/upload"

          ref="/upload"
          name="picture"
          :limit="1"
          :on-exceed="onExceed"
          :before-upload="beforeUpload"


          :on-preview="handlePreview"
          :on-remove="handleRemove"
          :file-list="form.fileList"
          :on-success="handleSuccess"
          list-type="picture-card">
					<el-button size="small" type="primary">点击上传</el-button>
					<div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
				</el-upload>
			</el-form-item>

<!--      <el-table :data="picture">-->
<!--        <el-table-column label="图片" width="130">-->
<!--          <template scope="scope">-->
<!--            <img :src="scope.row.picture" class="picture"/>-->
<!--          </template>-->
<!--        </el-table-column>-->
<!--        <el-table-column-->
<!--          label="运行状态"-->
<!--          width="80"-->
<!--          prop="operatingStatus">-->
<!--        </el-table-column>-->
<!--      </el-table>-->


<!--			<h2>请填写您的联系方式</h2>-->
<!--			<el-form-item label="真实姓名" prop="user_name">-->
<!--				<el-input v-model="form.user_name"></el-input>-->
<!--			</el-form-item>-->
<!--			<el-form-item label="联系电话" prop="user_phone">-->
<!--				<el-input v-model="form.user_phone"></el-input>-->
<!--			</el-form-item>-->
			<el-form-item>
				<el-button type="primary" @click="onSubmit" :loading="isLoading">{{ isLoading ? '发布中' : '发布房源' }}</el-button>
				<el-button @click="back">返回</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>
<script>
export default {
  data() {
    return {
      form: {
        is_for_sell: this.$route.params.ifs,
        user: sessionStorage.getItem("id"),
        title: "",
        description: "",
        // price: "",
        unit_price: "",
        room_num: "",
        livingroom_num: "",
        // kitchen_num: "",
        // bathroom_num: "",
        // total_floor: "",
        floor: "",
        // build_year: "",
        properties: "",
        // address:"",
        // view_time: "",
        area: "",
        // inside_area: "",
        // direction: "",
        lift: "",
        // house_per_floor: "",
        // last_trade: "",
        // trading_right: "",
        // house_age: "",
        // age_limit: "",
        // mortgage: "",
        // house_right: "",
        // house_label: "",
        decoration:"",
        decoration_desc: "",
        main_sellpoint: "",
        facility: "",
        traffic: "",
        picture:"",
        // house_usage: "",
        // fileList: [],
        // user_name: "",
        // user_phone: ""
      },
      isLoading: false,
      dialogImageUrl: "",
      dialogVisible: false
    };
  },
  methods: {
    onSubmit() {
      var that = this;
      this.isLoading = true;
      var formData=eval("("+JSON.stringify(this.form)+")");
      this.$ajax
        .post("/api/house/newHouse", formData)
        .then(function(res) {
          if (res.data.code == 200) {
            that.$message("发布成功");
            setTimeout(function() {
              that.$router.push("/");
            }, 3000);
          } else {
            that.$message("发布失败，请重试！");
            that.isLoading = false;
          }
        });
    },
    back() {
      this.$router.push("/");
    },
    // handleRemove(file, fileList) {
    //   console.log(file, fileList);
    // },
    handlePreview(file) {
      console.log(file);
    },
    uploadSuccess(res, file, fileList) {
      console.log("Sucess!");
      this.form.fileList.push(res.url);
    },
    countUnitPrice() {
      if (this.form.price && this.form.area) {
        this.form.unit_price =
          parseInt(this.form.price) / parseInt(this.form.area);
      }
    },


    //文件上传成功的钩子函数
    handleSuccess(res, file) {
      this.$message({
        type: 'info',
        message: '图片上传成功',
        duration: 6000
      });
      if (file.response.success) {
        this.form.picture = file.response.message; //将返回的文件储存路径赋值picture字段
      }
    },
    //删除文件之前的钩子函数
    handleRemove(file, fileList) {
      this.$message({
        type: 'info',
        message: '已删除原有图片',
        duration: 6000
      });
    },
    //点击列表中已上传的文件事的钩子函数
    // handlePreview(file) {
    // },
    //上传的文件个数超出设定时触发的函数
    onExceed(files, fileList) {
      this.$message({
        type: 'info',
        message: '最多只能上传一个图片',
        duration: 6000
      });
    },
    //文件上传前的前的钩子函数
    //参数是上传的文件，若返回false，或返回Primary且被reject，则停止上传
    beforeUpload(file) {
      const isJPG = file.type === 'image/jpeg';
      const isGIF = file.type === 'image/gif';
      const isPNG = file.type === 'image/png';
      const isBMP = file.type === 'image/bmp';
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG && !isGIF && !isPNG && !isBMP) {
        this.$message.error('上传图片必须是JPG/GIF/PNG/BMP 格式!');
      }
      if (!isLt2M) {
        this.$message.error('上传图片大小不能超过 2MB!');
      }
      return (isJPG || isBMP || isGIF || isPNG) && isLt2M;
    }
  }
};


</script>
<style scoped>
h2 {
  text-align: left;
}

.form {
  width: 350px;
  margin: 20px auto;
}
</style>


