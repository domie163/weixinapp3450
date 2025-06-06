<template>
	<view class="container">
		<form>
			<view class="cu-form-group">
				<textarea :style='{"boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"rgba(255, 107, 19, 1)","borderRadius":"8rpx","color":"rgba(0, 0, 0, 1)","borderWidth":"2rpx","fontSize":"26rpx","borderStyle":"solid","height":"300rpx"}' v-model="contont" placeholder="回复"></textarea>
			</view>
			<button :style='{"boxShadow":"0 0 0px rgba(0,0,0,0) inset","backgroundColor":"rgba(255, 107, 19, 1)","borderColor":"#409EFF","borderRadius":"20rpx","color":"#fff","borderWidth":"0","width":"100%","fontSize":"32rpx","borderStyle":"solid","height":"88rpx"}' @tap="onReplyTap" class="bg-red margin-tb-sm">提交回复</button>
		</form>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				pid: '',
				content: '',
				username: '',
				user: {},
			}
		},
		async onLoad(options) {
			this.pid = options.pid;
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
									                                    if(table == `zuke`){
                this.username = this.user.yonghuming
            }
                                                                                                                                                                                                                                                						            						                                    if(table == `fangdong`){
                this.username = this.user.fangdongzhanghao
            }
                                                                                                                                                                                                                                                						            			            			            			            			            			            			            			            		},
		methods: {
			async onReplyTap() {
				await this.$api.save('forum',{
					parentid: this.pid,
					content: this.contont,
					username: this.username
				});
				this.$utils.msgBack('回复成功');
			}
		}
	}
</script>

<style>
	page {
		background-color: #fff;
	}
	
	.container {
		padding: 20upx;
	}
	
	.cu-form-group {
		padding: 0;
		background-color: transparent;
		min-height: inherit;
	}
	
	.cu-form-group uni-textarea {
		padding: 30upx;
		margin: 0;
	}
	
	.bg-red {
		line-height: 88rpx;
	}
</style>
