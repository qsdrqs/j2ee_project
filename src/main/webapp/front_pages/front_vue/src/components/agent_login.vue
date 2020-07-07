<template>
	<div class="form">
		<h2>经纪人登录</h2>
		<br>
		<el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="用户名" prop="email_address">
        <el-input v-model="form.agentAccount"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input type="password" v-model="form.agentPassword"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit" :loading="isLoading">{{ isLoading ? '登陆中' : '立即登录' }}</el-button>
      </el-form-item>
    </el-form>
	</div>
</template>
<script>
export default {
  name: "AgentLogin",
  data() {
    return {
      form: {
        agentAccount: "",
        agentPassword: ""
      },
      isLoading: false
    };
	},
	methods: {
		onSubmit() {
      var that = this;
      this.isLoading = true;
      console.log(this.form)
      this.$ajax.get(
        'http://localhost:8080/agent/Agentlogin?agentAccount=' + this.form.agentAccount + '&agentPassword=' + this.form.agentPassword).then((res) => {
        console.log(res);
        if (res.status == 200) {
          sessionStorage.setItem('agentId', res.data.agentAccount);
          sessionStorage.setItem('agentName', res.data.agentName);
          window.location.href = '/#/agent_center';
        } else {
          this.$alert(res.data.msg, '抱歉', {
            confirmButtonText: '确定',
            callback: action => {
              if (action = 'confirm') {
                that.isLoading = false;
              }
            }
          });
        }
      })
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
