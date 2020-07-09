<template>
<div class="joboffer">
  <el-container>
      <el-main>
          <el-collapse class="collapse" v-model="activeNames" @change="handleChange" style="box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)
          text-align:center">
              <el-collapse-item title="房产经纪人" name="0" style="margin-left:50px">
                  <div style="padding-left: 50px">
                  <el-tag >房产经纪人招聘要求</el-tag>
                  </div>
                  <div style="text-indent:40px">
                  <div>要求有较好的抗压能力，口才出众，买过房子多于十套者优先</div>
                  <div>每月底薪加提成，具体薪资面谈</div>
                  </div>
              </el-collapse-item>
                <el-collapse-item title="后台管理" name="1" style="margin-left:50px">
                     <div style="padding-left: 50px">
                    <el-tag type="success">后台管理招聘要求</el-tag>
                     </div>
                    <div style="text-indent:40px">
                  <div>计算机相关专业，具有相关经验者优先</div>
                  <div>薪资极具市场竞争力</div>
                    </div>
              </el-collapse-item>
                    <el-collapse-item title="系统维护" name="2" style="margin-left:50px">
                    <div style="padding-left: 50px">
                    <el-tag type="warning">后台管理招聘要求</el-tag>
                     </div>
                     <div style="text-indent:40px">
                    <div>计算机相关专业，具有相关经验者优先</div>
                    <div>薪资极具市场竞争力</div>
                     </div>
              </el-collapse-item>
              </el-collapse>
      </el-main>
  </el-container>
</div>
</template>

<script>
export default {
    name:"joboffer",
    data() {
        return {
            activeNames:['-1']
        };
    },
    methods: {
        handleChange(val){
            console.log(val);
        }
    },

}
</script>

<style>
.el-main {
    padding: 6px 4px;
    color: #333;
    text-align:start;
    margin-left: 15.5%;
    margin-right: 15.5%;
    
    font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
  }
</style>