<template>
	<view class="content">
		<view class="logo" v-if="false">
			<image :style='{"boxShadow":"0 0 8rpx #ffaa33","borderColor":"#ccc","borderRadius":"40rpx","borderWidth":"0px","width":"160rpx","borderStyle":"solid","url":"http://codegen.caihongy.cn/20210327/a116aa442827428698066a8d90b2e692.png","isShow":false,"height":"160rpx"}' src='http://codegen.caihongy.cn/20210327/a116aa442827428698066a8d90b2e692.png' mode="aspectFill"></image>
		</view>
		<view v-if="tableName=='zuke'" class="uni-form-item uni-column">
			<input :style='{"borderColor":"rgba(255, 170, 51, 1)","backgroundColor":"#fff","borderRadius":"8rpx","color":"rgba(0, 0, 0, 1)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}' v-model="ruleForm.yonghuming" type="text" class="uni-input" name="" placeholder="用户名" />
		</view>
		<view v-if="tableName=='zuke'" class="uni-form-item uni-column">
			<input :style='{"borderColor":"rgba(255, 170, 51, 1)","backgroundColor":"#fff","borderRadius":"8rpx","color":"rgba(0, 0, 0, 1)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}' v-model="ruleForm.mima" type="text" class="uni-input" name="" placeholder="密码" />
		</view>
		<view v-if="tableName=='zuke'" class="uni-form-item uni-column">
			<input :style='{"borderColor":"rgba(255, 170, 51, 1)","backgroundColor":"#fff","borderRadius":"8rpx","color":"rgba(0, 0, 0, 1)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}' v-model="ruleForm.zukexingming" type="text" class="uni-input" name="" placeholder="租客姓名" />
		</view>
		<view v-if="tableName=='zuke'" class="uni-form-item uni-column">
                        <picker @change="zukexingbieChange" :value="zukexingbieIndex" :range="zukexingbieOptions">
                                <view :style='{"borderColor":"rgba(255, 170, 51, 1)","backgroundColor":"#fff","borderRadius":"8rpx","color":"rgba(0, 0, 0, 1)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
                        </picker>
                </view>
		<view v-if="tableName=='zuke'" class="uni-form-item uni-column">
			<input :style='{"borderColor":"rgba(255, 170, 51, 1)","backgroundColor":"#fff","borderRadius":"8rpx","color":"rgba(0, 0, 0, 1)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}' v-model="ruleForm.nianling" type="text" class="uni-input" name="" placeholder="年龄" />
		</view>
		<view v-if="tableName=='zuke'" class="uni-form-item uni-column">
			<input :style='{"borderColor":"rgba(255, 170, 51, 1)","backgroundColor":"#fff","borderRadius":"8rpx","color":"rgba(0, 0, 0, 1)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}' v-model="ruleForm.zhiye" type="text" class="uni-input" name="" placeholder="职业" />
		</view>
		<view v-if="tableName=='zuke'" class="uni-form-item uni-column">
			<input :style='{"borderColor":"rgba(255, 170, 51, 1)","backgroundColor":"#fff","borderRadius":"8rpx","color":"rgba(0, 0, 0, 1)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}' v-model="ruleForm.shenfenzheng" type="text" class="uni-input" name="" placeholder="身份证" />
		</view>
		<view v-if="tableName=='zuke'" class="uni-form-item uni-column">
			<input :style='{"borderColor":"rgba(255, 170, 51, 1)","backgroundColor":"#fff","borderRadius":"8rpx","color":"rgba(0, 0, 0, 1)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}' v-model="ruleForm.shouji" type="text" class="uni-input" name="" placeholder="手机" />
		</view>
		<view v-if="tableName=='zuke'" class="uni-form-item uni-column">
			<input :style='{"borderColor":"rgba(255, 170, 51, 1)","backgroundColor":"#fff","borderRadius":"8rpx","color":"rgba(0, 0, 0, 1)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}' v-model="ruleForm.jiatingdizhi" type="text" class="uni-input" name="" placeholder="家庭地址" />
		</view>
		<view v-if="tableName=='fangdong'" class="uni-form-item uni-column">
			<input :style='{"borderColor":"rgba(255, 170, 51, 1)","backgroundColor":"#fff","borderRadius":"8rpx","color":"rgba(0, 0, 0, 1)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}' v-model="ruleForm.fangdongzhanghao" type="text" class="uni-input" name="" placeholder="房东账号" />
		</view>
		<view v-if="tableName=='fangdong'" class="uni-form-item uni-column">
			<input :style='{"borderColor":"rgba(255, 170, 51, 1)","backgroundColor":"#fff","borderRadius":"8rpx","color":"rgba(0, 0, 0, 1)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}' v-model="ruleForm.mima" type="text" class="uni-input" name="" placeholder="密码" />
		</view>
		<view v-if="tableName=='fangdong'" class="uni-form-item uni-column">
			<input :style='{"borderColor":"rgba(255, 170, 51, 1)","backgroundColor":"#fff","borderRadius":"8rpx","color":"rgba(0, 0, 0, 1)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}' v-model="ruleForm.fangdongxingming" type="text" class="uni-input" name="" placeholder="房东姓名" />
		</view>
		<view v-if="tableName=='fangdong'" class="uni-form-item uni-column">
                        <picker @change="fangdongxingbieChange" :value="fangdongxingbieIndex" :range="fangdongxingbieOptions">
                                <view :style='{"borderColor":"rgba(255, 170, 51, 1)","backgroundColor":"#fff","borderRadius":"8rpx","color":"rgba(0, 0, 0, 1)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
                        </picker>
                </view>
		<view v-if="tableName=='fangdong'" class="uni-form-item uni-column">
			<input :style='{"borderColor":"rgba(255, 170, 51, 1)","backgroundColor":"#fff","borderRadius":"8rpx","color":"rgba(0, 0, 0, 1)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}' v-model="ruleForm.shenfenzheng" type="text" class="uni-input" name="" placeholder="身份证" />
		</view>
		<view v-if="tableName=='fangdong'" class="uni-form-item uni-column">
			<input :style='{"borderColor":"rgba(255, 170, 51, 1)","backgroundColor":"#fff","borderRadius":"8rpx","color":"rgba(0, 0, 0, 1)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}' v-model="ruleForm.lianxishouji" type="text" class="uni-input" name="" placeholder="联系手机" />
		</view>
		<view v-if="tableName=='fangdong'" class="uni-form-item uni-column">
			<input :style='{"borderColor":"rgba(255, 170, 51, 1)","backgroundColor":"#fff","borderRadius":"8rpx","color":"rgba(0, 0, 0, 1)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}' v-model="ruleForm.nianling" type="text" class="uni-input" name="" placeholder="年龄" />
		</view>
		<view>
			<button @tap="register" type="primary" :style='{"borderColor":"#ccc","backgroundColor":"rgba(255, 107, 19, 1)","borderRadius":"20rpx","color":"rgba(255, 255, 255, 1)","borderWidth":"0px","fontSize":"32rpx","borderStyle":"solid","height":"88rpx"}'>注册</button>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
                                zukexingbieOptions: [],
                                zukexingbieIndex: 0,
                                fangdongxingbieOptions: [],
                                fangdongxingbieIndex: 0,
				ruleForm: {
				},
				tableName:""
			}
		},
		async onLoad() {
			let res = [];
			let table = uni.getStorageSync("loginTable");
	    		this.tableName = table;

                        // 自定义下拉框值
			if(this.tableName=='zuke'){
                        	this.zukexingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.zukexingbieOptions[0]
			}
                        // 自定义下拉框值
			if(this.tableName=='fangdong'){
                        	this.fangdongxingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.fangdongxingbieOptions[0]
			}
			
			this.styleChange()
		},
		methods: {
                        // 下拉变化
                        zukexingbieChange(e) {
                                this.zukexingbieIndex = e.target.value
                                this.ruleForm.xingbie = this.zukexingbieOptions[this.zukexingbieIndex]
                        },
                        // 下拉变化
                        fangdongxingbieChange(e) {
                                this.fangdongxingbieIndex = e.target.value
                                this.ruleForm.xingbie = this.fangdongxingbieOptions[this.fangdongxingbieIndex]
                        },

			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.uni-input .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.registerFrom.content.input.backgroundColor
					// })
				})
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 注册
			async register() {
				if((!this.ruleForm.yonghuming) && `zuke` == this.tableName){
					this.$utils.msg(`用户名不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `zuke` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
				if(`zuke` == this.tableName && this.ruleForm.shenfenzheng&&(!this.$validate.checkIdCard(this.ruleForm.shenfenzheng))){
					this.$utils.msg(`身份证应输入身份证格式`);
					return
				}
				if(`zuke` == this.tableName && this.ruleForm.shouji&&(!this.$validate.isMobile(this.ruleForm.shouji))){
					this.$utils.msg(`手机应输入手机格式`);
					return
				}
				if((!this.ruleForm.fangdongzhanghao) && `fangdong` == this.tableName){
					this.$utils.msg(`房东账号不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `fangdong` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
				if(`fangdong` == this.tableName && this.ruleForm.shenfenzheng&&(!this.$validate.checkIdCard(this.ruleForm.shenfenzheng))){
					this.$utils.msg(`身份证应输入身份证格式`);
					return
				}
				if(`fangdong` == this.tableName && this.ruleForm.lianxishouji&&(!this.$validate.isMobile(this.ruleForm.lianxishouji))){
					this.$utils.msg(`联系手机应输入手机格式`);
					return
				}
				await this.$api.register(`${this.tableName}`, this.ruleForm);
				this.$utils.msgBack('注册成功');;
			}
		}
	}
</script>

<style lang="scss" scoped>
	$color-primary: #b49950;

	.content {
		padding: 100upx;
	}
	
	.content:after {
		position: fixed;
		top: 0;
		right: 0;
		left: 0;
		bottom: 0;
		content: '';
				background-attachment: fixed;
		background-size: cover;
		background-position: center;
	}

	.logo {
		text-align: center;

		image {
			height: 200upx;
			width: 200upx;
			margin: 0 0 60upx;
		}
	}

	.uni-form-item {
		margin-bottom: 40upx;
		padding: 0;

		.uni-input {
			font-size: 30upx;
			padding: 7px 0;
		}
	}

	button[type="primary"] {
		background-color: $color-primary;
		border-radius: 0;
		font-size: 34upx;
		margin-top: 60upx;
	}

	.links {
		text-align: center;
		margin-top: 40upx;
		font-size: 26upx;
		color: #999;

		view {
			display: inline-block;
			vertical-align: top;
			margin: 0 10upx;
		}

		.link-highlight {
			color: $color-primary
		}
	}
.picker-select-input {
	line-height: 80rpx;
}

</style>
