// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import Header from './components/_header'
import Footer from './components/_footer'
import axios from 'axios'
import BaiduMap from 'vue-baidu-map'
import VueResource from 'vue-resource';

import x2js from 'x2js'

//import VueRssFeed from "VueRssFeed.vue";

Vue.prototype.$x2js = new x2js()
Vue.prototype.$ajax = axios

Vue.config.productionTip = false

Vue.use(ElementUI)

Vue.use(VueResource)

Vue.use(BaiduMap, {
  /* Visit http://lbsyun.baidu.com/apiconsole/key for details about app key. */
  ak: 'Gi98dHHeD9ZTwAdEd9wTjLKMyVa9OGOf'
})


router.afterEach((to,from,next) => {
  window.scrollTo(0,0);
});

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})

new Vue({
  el: '#header',
  router,
  render: h => h(Header)
})

new Vue({
  el: '#footer',
  router,
  render: h => h(Footer)
})
