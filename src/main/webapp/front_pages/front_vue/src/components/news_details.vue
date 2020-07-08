<template>
  
    <div class="news_details" >
        <el-container>
            <el-header>
                <h2>biaotii
                </h2>
            </el-header>
            <el-main>neirong
                <el-button :plain="true" @click="openHtml">shiyong</el-button>
            </el-main>
        </el-container>
    </div>
</template>

<script>
export default {
    name:"news_details",
    data(){
        
        return{
            id:this.$route.params.id,
            newinfo:{}
        };
    },
    methods:{
        getNewsDetails(){
            this.$http.get('api/getnew'+this.id).then(result => {
                if(result.body.status === 0){
                    this.newinfo=result.body.message[0];
                }else{
                    alert("shibai");
                }
            })
            
        }}

}
</script>

<style>
.el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
    margin-left: 15%;
    margin-right: 15%;
  }
  
  
  .el-main {
    background-color: #E9EEF3;
    padding: 6px 4px;
    color: #333;
    text-align: center;
    margin-left: 15.5%;
    margin-right: 15.5%;
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