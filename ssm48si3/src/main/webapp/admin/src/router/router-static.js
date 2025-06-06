import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import discussfangwuxinxi from '@/views/modules/discussfangwuxinxi/list'
    import fangwuxinxi from '@/views/modules/fangwuxinxi/list'
    import fangwuleixing from '@/views/modules/fangwuleixing/list'
    import zulinhetong from '@/views/modules/zulinhetong/list'
    import zujinxinxi from '@/views/modules/zujinxinxi/list'
    import zuke from '@/views/modules/zuke/list'
    import fangdong from '@/views/modules/fangdong/list'
    import storeup from '@/views/modules/storeup/list'
    import config from '@/views/modules/config/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/discussfangwuxinxi',
        name: '房屋信息评论',
        component: discussfangwuxinxi
      }
      ,{
	path: '/fangwuxinxi',
        name: '房屋信息',
        component: fangwuxinxi
      }
      ,{
	path: '/fangwuleixing',
        name: '房屋类型',
        component: fangwuleixing
      }
      ,{
	path: '/zulinhetong',
        name: '租赁合同',
        component: zulinhetong
      }
      ,{
	path: '/zujinxinxi',
        name: '租金信息',
        component: zujinxinxi
      }
      ,{
	path: '/zuke',
        name: '租客',
        component: zuke
      }
      ,{
	path: '/fangdong',
        name: '房东',
        component: fangdong
      }
      ,{
	path: '/storeup',
        name: '我的收藏管理',
        component: storeup
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
