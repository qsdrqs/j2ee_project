<template>
  <div class="form">
    <h2>立即登录</h2>
    <br>
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="用戶名" prop="account">
        <el-input v-model="form.userAccount"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input type="password" v-model="form.userPasswordsha256"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit" :loading="isLoading">{{ isLoading ? '登陆中' : '立即登录' }}</el-button>
        <el-button @click="register">注册</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  data() {
    return {
      form: {
        account: '',
        password: ''
      },
      isLoading: false
    }
  }, 
  methods: {
    onSubmit() {
      this.isLoading = true;
      var formData=eval("("+JSON.stringify(this.form)+")");
      this.$ajax.post(
        'http://localhost:8080/user/userLogin', this.form).then((res) => {
          console.log(res);
        if (res.data != null && res.data != "") {
          sessionStorage.setItem('userId', res.data.userId);
          sessionStorage.setItem('userAccount', res.data.userAccount);
          window.location.href = '/#/customer_center';
        } else {
          this.$alert(res.data.msg, '账号或者密码错误', {
            confirmButtonText: '确定',
            callback: action => {
              if (action = 'confirm') {
                that.isLoading = false;
              }
            }
          });
        }
      })
    }, 
    register () {
      this.$router.push('/register');
    }
  }
}
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
