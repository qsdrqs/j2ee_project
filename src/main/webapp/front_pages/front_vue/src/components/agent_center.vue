<template>
	<div class="form">
		<div class="seller_center">
      <h2>您好，{{ agentName }}!欢迎登入经纪人中心</h2>
      <div class="function_tab">
        <el-radio-group v-model="list_type" @change="getList">
          <el-radio-button label="1">我的房源</el-radio-button>
          <el-radio-button label="2">已完成</el-radio-button>
          <el-radio-button label="0">个人信息修改</el-radio-button>
          <!--<el-radio-button label="0">待接订单</el-radio-button>-->
        </el-radio-group>
      </div>

			<!-- 我的订单 -->
      <el-table v-loading="loading" :data="orderList" style="width: 100%; text-align: left;" stripe
                :hidden="list_type == 0" @cellclick="viewHouse" :cell-style="red_cell">
        <el-table-column prop="createTimeStr" label="发布日期">
        </el-table-column>
        <el-table-column prop="houseHead" label="房源标题">
        </el-table-column>
        <el-table-column prop="unitPrice" label="价格">
        </el-table-column>
        <!--				<el-table-column prop="buyer_name" label="买家姓名">-->
        <!--				</el-table-column>-->
        <!--				<el-table-column prop="buyer_phone" label="买家联系电话">-->
        <!--				</el-table-column>-->
        <el-table-column prop="userName" label="卖家姓名">
        </el-table-column>
        <el-table-column prop="userTelephone" label="卖家联系电话">
        </el-table-column>
        <el-table-column prop="status_text" label="房源类型" >
        </el-table-column>
        <el-table-column prop="operate" label="状态">
          <template slot-scope="scope">
            <el-button @click="viewHouse(scope.row)" type="text" size="small">查看</el-button>
            <el-button @click="alreadyView(scope.row)" type="text" size="small" 
                       :class="{ hidden: scope.row.status == 3 }">完成
            </el-button>
            <!--<el-button @click="feedbackHouse(scope.row)" type="text" size="small"-->
                       <!--:class="{ hidden: scope.row.status != 3 }">已完成-->
            <!--</el-button>-->
            <el-tag type="success" size="small" :class="{ hidden: scope.row.status != 3 }">已完成</el-tag>
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
      <el-form-item label="电话" prop="telephone">
        <el-input v-model="ruleForm.telephone"></el-input>
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input v-model="ruleForm.email"></el-input>
      </el-form-item>
       <el-form-item label="个人简介" prop="desc">
        <el-input type="textarea" v-model="ruleForm.desc"></el-input>
       </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm(ruleForm)">确定</el-button>
        <el-button @click="getAgentInfo()">重置</el-button>
      </el-form-item>
    </el-form>

	</div>
</div>
</template>
<script>
export default {
  name: "AgentCenter",
  data() {
    return {
      ruleForm:{
        name: '',
        sex: 'male',
        telephone: '',
        email: '',
        desc: ''
      },
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
      agentName: sessionStorage.getItem("agentName"),
      list_type: 1,
      loading: false,
      orderList: [],
      housePrice: "￥0"
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
      var url = "http://localhost:8080/agent/updateAgent";
      form.id=sessionStorage.getItem("agentId");
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
    red_cell({ row, column, rowIndex, columnIndex }) {
      if (column.label == "房源类型") {
        return "color:red";
      }
    },
    getList() {
      var that = this;
      this.getAgentInfo();
      var id = sessionStorage.getItem("agentId");
      console.log(id);
      console.log(this.list_type);
      var url =
        "http://localhost:8080/houseAgent/findHouseByAgent?agentId=" +
        id +
        "&type=" +
        this.list_type;
      this.$ajax.get(url).then(res => {
        console.log(res);
        that.orderList = res.data;
        for (var i = 0; i < res.data.length; i++) {
          // if(res.data[i].type=0){
          //   that.housePrice = "￥"+(res.data[i].unitPrice)*(res.data[i].area)+"万";
          //
          // }else{
          //   that.housePrice = "￥"+(res.data[i].unitPrice)+"/月";
          // }
          console.log("type=" + res.data[i].type);
          if (res.data[i].type == 0) {
            res.data[i].unitPrice =
              "￥" + res.data[i].unitPrice * res.data[i].area / 10000 + "万";
          } else {
            res.data[i].unitPrice = "￥" + res.data[i].unitPrice + "/月";
          }
          console.log("价格=" + res.data[i].unitPrice);


          // switch (res.data[i].status) {
          //   case 0:
          //     that.orderList[i].status_text = "订单已关闭";
          //     break;
          //   case 1:
          //     that.orderList[i].status_text = "等待经纪人接单";
          //     break;
          //   case 2:
          //     that.orderList[i].status_text = "您已接单";
          //     break;
          //   case 3:
          //     that.orderList[i].status_text = "已带看房源";
          //     break;
          //   case 4:
          //     that.orderList[i].status_text = "请协商交易";
          //     break;
          //   case 5:
          //     that.orderList[i].status_text = "卖家已收款";
          //     break;
          //   case 6:
          //     that.orderList[i].status_text = "买家已收楼";
          //     break;
          //   case 7:
          //     that.orderList[i].status_text = "交易已完成";
          //     break;
          //   default:
          //     that.orderList[i].status_text = "订单状态未知";
          //     break;
          // }
          switch (res.data[i].type) {
            case 0:
              that.orderList[i].status_text = "售卖";
              break;
            case 1:
              that.orderList[i].status_text = "出租";
              break;
            default:
              that.orderList[i].status_text = "未知";

              break;
          }
        }
      });
    },
    //查看房子详情
    viewHouse(object) {
      this.$router.push("/house_details/" + object.houseId);
		},
    //接单
    getOrder(object) {
      var that = this;
      this.$confirm("确定接手本订单吗（" + object.title + "）？", "确认", {
        confirmButtonText: "确定",
        cancelButtonText: "取消"
      }).then(action => {
        if (action == "confirm") {
          that.$ajax
            .get(
              "http://localhost:3333/house/getOrder?order=" +
                object.order_id +
                "&agent_id=" +
                sessionStorage.getItem("agent_id") +
                "&agent_name=" +
                that.agent_name
            )
            .then(res => {
              if (res.data.code == 200) {
                this.$message("操作成功！");
                that.getList();
              } else {
                this.$message("操作失败，请稍后重试！");
              }
            });
        }
      });
    },
    //将订单状态改为已经售出房源
    alreadyView(object) {
      var that = this;
      this.$confirm(
        "已经完成了此卖家（" + object.userName + "）的订单？",
        "确认",
        {
          confirmButtonText: "我已完成",
          cancelButtonText: "还没完成"
        }
      ).then(action => {
        if (action == "confirm") {
          that.$ajax
            .get("http://localhost:8080/house/soldout?houseId=" + object.houseId)
            .then(res => {
              console.log(res);
              if (res.data == "OK!") {
                this.$message("操作成功！");
                that.getList();
              } else {
                this.$message("操作失败，请稍后重试！");
              }
            });
        }
      });
    },
    getAgentInfo(){
      var that = this;
      that.ruleForm.name = sessionStorage.getItem("agentName");
      var id = sessionStorage.getItem("agentId");
      var url =
        "http://localhost:8080/agent/AgentInfo?id=" + id;
      this.$ajax.get(url).then(res => {
        console.log(res);
        if (res.data.agentSex == 0) {
          that.ruleForm.sex = "女";
        }
        else{
          that.ruleForm.sex = "男";
        }
        that.ruleForm.telephone = res.data.agentTel;
        that.ruleForm.email = res.data.agentEmail;
        that.ruleForm.desc = res.data.agentProfile;
      })

    },
    //评论房子
    feedbackHouse(object) {
      var that = this;
      var form = {
        house_id: object.house_id,
        agent_id: sessionStorage.getItem("agentId"),
        agent_name: sessionStorage.getItem("agentName"),
        content: ""
      };
      this.$prompt("请输入评价内容", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消"
      }).then(({ value }) => {
        form.content = value;
        this.$ajax
          .post("http://localhost:3333/house/feedback", form)
          .then(res => {
            if (res.data.code == 200) {
              that.$alert("评论成功！", "提示", {
                confirmButtonText: "确定",
                callback: action => {
                  that.getList();
                }
              });
            } else {
              that.$alert("评论失败，请稍后重试", "抱歉", {
                confirmButtonText: "确定",
                callback: action => {
                  that.getList();
                }
              });
            }
          });
      });
    }
  },
  created() {
    this.getList();
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
