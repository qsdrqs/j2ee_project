<template>
	<div class="seller_center">
    <h2>您好，{{ userAccount }}!欢迎回家</h2>
    <div class="function_tab">
      <el-radio-group v-model="list_type" @change="getOrderList">
        <el-radio-button label="1">我的房源</el-radio-button>
        <el-radio-button label="2">已完成</el-radio-button>
        <el-radio-button label="0">用户信息修改</el-radio-button>
        <!--<el-radio-button label="0">待接订单</el-radio-button>-->
      </el-radio-group>
    </div>
		<!-- 我的订单表格 -->
		<el-table v-loading="loading" :data="order_list" style="width: 100%; text-align: left;" stripe
              :hidden="list_type!=1">
			<el-table-column prop="title" label="房源标题">
			</el-table-column>
			<el-table-column prop="create_time" label="发布时间">
			</el-table-column>

			<el-table-column prop="agentName" label="经纪人">

			</el-table-column>
			<el-table-column prop="tel" label="经纪人联系电话">
			</el-table-column>
      -->
			<el-table-column prop="status_text" label="状态">
<!--        <el-tag type="0" size="small" :class="{ hidden: scope.row.status != 0 }">已完成</el-tag>-->
<!--        <el-tag type="1" size="small" :class="{ hidden: scope.row.status != 1 }">已完成</el-tag>-->
<!--        <el-tag type="2" size="small" :class="{ hidden: scope.row.status != 2 }">已完成</el-tag>-->
<!--        <el-tag type="3" size="small" :class="{ hidden: scope.row.status != 3 }">已完成</el-tag>-->
      </el-table-column>
			<el-table-column prop="operate" label="操作">
				<template slot-scope="scope">
					<el-button @click="viewHouse(scope.row)" type="text" size="small">查看</el-button>
<!--					<el-button @click="wantHouse(scope.row)" type="text" size="small" :class="{ hidden: scope.row.status!=3 }">下订房源</el-button>-->
<!--					<el-button @click="alreadyGetHouse(scope.row)" type="text" size="small" :class="{ hidden: scope.row.status!=4&&scope.row.status!=5 }">确认收楼</el-button>-->
<!--					<el-button @click="cancelOrder(scope.row)" type="text" size="small" :class="{ hidden: scope.row.status==0 }">取消订单</el-button>-->
				</template>
			</el-table-column>
		</el-table>
    <!-- 我的订单表格 -->
    <el-table v-loading="loading" :data="order_list" style="width: 100%; text-align: left;" stripe
              :hidden="list_type!=2">
      <el-table-column prop="title" label="房源标题">
      </el-table-column>
      <el-table-column prop="create_time" label="发布时间">
      </el-table-column>
      <el-table-column prop="agentName" label="经纪人">
      </el-table-column>
      <el-table-column prop="tel" label="经纪人联系电话">
      </el-table-column>
      <el-table-column prop="status_text" label="状态">
        <!--        <el-tag type="0" size="small" :class="{ hidden: scope.row.status != 0 }">已完成</el-tag>-->
        <!--        <el-tag type="1" size="small" :class="{ hidden: scope.row.status != 1 }">已完成</el-tag>-->
        <!--        <el-tag type="2" size="small" :class="{ hidden: scope.row.status != 2 }">已完成</el-tag>-->
        <!--        <el-tag type="3" size="small" :class="{ hidden: scope.row.status != 3 }">已完成</el-tag>-->
      </el-table-column>
      <el-table-column prop="operate" label="操作">
        <template slot-scope="scope">
          <el-button @click="viewHouse(scope.row)" type="text" size="small">查看</el-button>
          <!--					<el-button @click="wantHouse(scope.row)" type="text" size="small" :class="{ hidden: scope.row.status!=3 }">下订房源</el-button>-->
          <!--					<el-button @click="alreadyGetHouse(scope.row)" type="text" size="small" :class="{ hidden: scope.row.status!=4&&scope.row.status!=5 }">确认收楼</el-button>-->
          <!--					<el-button @click="cancelOrder(scope.row)" type="text" size="small" :class="{ hidden: scope.row.status==0 }">取消订单</el-button>-->
        </template>
      </el-table-column>
    </el-table>

    <!-- 个人信息修改 -->
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" :hidden="list_type != 0" style="text-align: left">
      <el-form-item label="姓名" prop="name">
        <el-input v-model="ruleForm.name"></el-input>
      </el-form-item>
      <el-form-item label="性别" prop="sex">
        <el-select v-model="ruleForm.sex" type="flex" >
          <el-option label="女" value="female"></el-option>
          <el-option label="男" value="male"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input type="password" v-model="ruleForm.password" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="电话" prop="telephone">
        <el-input v-model="ruleForm.telephone"></el-input>
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input v-model="ruleForm.email"></el-input>
      </el-form-item>


      <el-form-item>
        <el-button type="primary" @click="submitForm(ruleForm)">确定</el-button>
        <el-button @click="getAgentInfo()">重置</el-button>
      </el-form-item>
    </el-form>

	</div>
</template>
<script>
export default {
  name: "customer_center",
  data() {
    return {
      ruleForm:{
        account: "",
        name: '',
        sex: 'male',
        telephone: '',
        email: '',
        password:""
      },
      userAccount: sessionStorage.getItem("userAccount"),
      order_list: [],
      currentPage: 1,
      loading: false,
      list_type:1,
      rules: {
        name: [
          { required: true, message: '名字不能为空', trigger: 'blur' },
          { min: 1,max: 20, message: '名字别太长！', trigger: 'blur' }
        ],
        telephone: [
          { required: true, message: '电话不能为空', trigger: 'blur' },
          { min: 5,max: 13, message: '电话号码不正确', trigger: 'blur' }
        ],
        email: [
          { required: true, message: '邮箱不能为空', trigger: 'blur' },
        ]

      },
    };
  },
  methods: {
    submitForm(form){
      var numpatt=new RegExp("[^0-9]");
      if(numpatt.test(form.telephone)){
        this.$message({
          message: "电话必须为数字！",
          type: 'error'
        })
        return;
      }
      var emailpatt=new RegExp(".@.*\.")
      if(!emailpatt.test(form.email)){
        this.$message({
          message: "邮箱格式不正确！",
          type: 'error'
        })
        return;
      }
      var url = "http://localhost:8080/user/updateUser";
      form.id=sessionStorage.getItem("userId");
      this.$ajax.post(url, form).then(res => {
        if (res.status == 200) {
          console.log("OK!");
          this.$message({
            message: '更新成功',
            type: 'success'
          })
        }
      });
    },
    getCostomerInfo(){
      var that = this;
      var id = sessionStorage.getItem("userId");
      var url =
        "http://localhost:8080/user/getUserInfo?id=" + id;
      this.$ajax.get(url).then(res => {
        console.log("用户信息"+res);
        if (res.data.userSex == 0) {
          that.ruleForm.sex = "女";
        }
        else{
          that.ruleForm.sex = "男";
        }
        that.ruleForm.account=res.data.userAccount;
        that.ruleForm.name=res.data.userName;
        that.ruleForm.telephone = res.data.userTelephone;
        that.ruleForm.email = res.data.userMail;
        that.ruleForm.desc = res.data.agentProfile;
        that.ruleForm.password=res.data.userPasswordsha256;
      })

    },
    getOrderList() {
      this.getCostomerInfo();
      var that = this;
      this.loading = true;
      var queryString ="http://localhost:8080/house/getHouseByUid?id=" + sessionStorage.getItem("userId")+"&type=" +
      this.list_type;
      console.log("列表类型"+this.list_type);
      this.$ajax
        .get(
          queryString
        )
        .then(function(res) {
          that.loading = false;
          console.log(res.data);
          that.order_list = res.data;
          for (var i = 0; i < res.data.length; i++) {
            switch (res.data[i].status) {
              case 0:
                that.order_list[i].status_text = "审核中";
                break;
              case 1:
                that.order_list[i].status_text = "审核通过";
                break;
              case 2:
                that.order_list[i].status_text = "审核不通过";
                break;
              case 3:
                that.order_list[i].status_text = "已出售";
                break;
              default:
                that.order_list[i].status_text = "订单状态未知";
                break;
            }
            that.order_list[i].create_time = res.data[i].createTimeStr;
            that.order_list[i].title = res.data[i].houseHead;
          }
        });
    },
    viewHouse(object) {
			this.$router.push("/house_details/" + object.houseId);
    },
    wantHouse(object) {
			//下定房源
      var that = this;
      this.$confirm(
        "房源: " + object.title + "，价格：" + object.price / 10000 + "万。",
        "您确定下订本房源吗？",
        {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          callback: action => {
            if (action == "confirm") {
              that.$ajax
                .get(
                  "http://localhost:3333/house/orderHouse?o_id=" +
                    object.order_id
                )
                .then(function(res) {
                  if (res.data.code == 200) {
                    that.$message(
                      "您已成功下订本房源，稍后经纪人将为您安排交易，谢谢！"
                    );
                    that.getOrderList();
                  }
                });
            }
          }
        }
      );
    },
    alreadyGetHouse(object) {
      var that = this;
      this.$confirm("您确定已经收楼了吗？", "确认", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        callback: action => {
          if (action == "confirm") {
            that.$ajax
              .get(
                "http://localhost:3333/house/alreadyGetHouse?o_id=" +
                  object.order_id
              )
              .then(function(res) {
                if (res.data.code == 200) {
                  that.$message("您已成功收楼，感谢您的使用！");
                  that.getOrderList();
                }
              });
          }
        }
      });
    },
    cancelOrder(object) {
      var that = this;
      this.$confirm("您确定要取消本订单吗？", "确认", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        callback: action => {
          /* this.$alert('您已取消本订单', '成功', {
              confirmButtonText: "确定"
          }) */
          if (action == "confirm") {
            that.$ajax
              .get(
                "http://localhost:3333/house/cancelOrder?o_id=" +
                  object.order_id
              )
              .then(res => {
                if (res.data.code == 200) {
                  that.$message("您已成功取消本订单，期待您的再次使用！");
                  that.getOrderList();
                } else {
                  that.$message("订单取消失败，请稍后重试！");
                  that.getOrderList();
                }
              });
          }
        }
      });
    }
  },
  created: function() {
    this.getOrderList();
  }
};
</script>
<style scoped>
h2 {
  text-align: left;
  border-bottom: 1px solid #f6f6f6;
}

.seller_center {
  width: 1000px;
  margin: 20px auto;
}

.function_tab {
  margin: 20px;
}
</style>

