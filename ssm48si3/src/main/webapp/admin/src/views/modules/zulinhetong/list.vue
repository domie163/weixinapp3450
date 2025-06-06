<template>
  <div class="main-content">
    <!-- 列表页 -->
    <div v-if="showFlag">
      <el-form :inline="true" :model="searchForm" class="form-content">
        <el-row :gutter="20" class="slt" :style="{justifyContent:contents.searchBoxPosition=='1'?'flex-start':contents.searchBoxPosition=='2'?'center':'flex-end'}">
                <el-form-item :label="contents.inputTitle == 1 ? '房屋编号' : ''">
                  <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 1" prefix-icon="el-icon-search" v-model="searchForm.fangwubianhao" placeholder="房屋编号" clearable></el-input>
                  <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 2" suffix-icon="el-icon-search" v-model="searchForm.fangwubianhao" placeholder="房屋编号" clearable></el-input>
                  <el-input v-if="contents.inputIcon == 0" v-model="searchForm.fangwubianhao" placeholder="房屋编号" clearable></el-input>
                </el-form-item>
                <el-form-item :label="contents.inputTitle == 1 ? '身份证' : ''">
                  <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 1" prefix-icon="el-icon-search" v-model="searchForm.shenfenzheng" placeholder="身份证" clearable></el-input>
                  <el-input v-if="contents.inputIcon == 1 && contents.inputIconPosition == 2" suffix-icon="el-icon-search" v-model="searchForm.shenfenzheng" placeholder="身份证" clearable></el-input>
                  <el-input v-if="contents.inputIcon == 0" v-model="searchForm.shenfenzheng" placeholder="身份证" clearable></el-input>
                </el-form-item>
          <el-form-item>
            <el-button v-if="contents.searchBtnIcon == 1 && contents.searchBtnIconPosition == 1" icon="el-icon-search" type="success" @click="search()">{{ contents.searchBtnFont == 1?'查询':'' }}</el-button>
            <el-button v-if="contents.searchBtnIcon == 1 && contents.searchBtnIconPosition == 2" type="success" @click="search()">{{ contents.searchBtnFont == 1?'查询':'' }}<i class="el-icon-search el-icon--right"/></el-button>
            <el-button v-if="contents.searchBtnIcon == 0" type="success" @click="search()">{{ contents.searchBtnFont == 1?'查询':'' }}</el-button>
          </el-form-item>
        </el-row>
        <el-row class="ad" :style="{justifyContent:contents.btnAdAllBoxPosition=='1'?'flex-start':contents.btnAdAllBoxPosition=='2'?'center':'flex-end'}">
          <el-form-item>
            <el-button
              v-if="isAuth('zulinhetong','新增') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 1"
              type="success"
              icon="el-icon-plus"
              @click="addOrUpdateHandler()"
            >{{ contents.btnAdAllFont == 1?'新增':'' }}</el-button>
            <el-button
              v-if="isAuth('zulinhetong','新增') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 2"
              type="success"
              @click="addOrUpdateHandler()"
            >{{ contents.btnAdAllFont == 1?'新增':'' }}<i class="el-icon-plus el-icon--right" /></el-button>
            <el-button
              v-if="isAuth('zulinhetong','新增') && contents.btnAdAllIcon == 0"
              type="success"
              @click="addOrUpdateHandler()"
            >{{ contents.btnAdAllFont == 1?'新增':'' }}</el-button>
            <el-button
              v-if="isAuth('zulinhetong','删除') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 1 && contents.tableSelection"
              :disabled="dataListSelections.length <= 0"
              type="danger"
              icon="el-icon-delete"
              @click="deleteHandler()"
            >{{ contents.btnAdAllFont == 1?'删除':'' }}</el-button>
            <el-button
              v-if="isAuth('zulinhetong','删除') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 2 && contents.tableSelection"
              :disabled="dataListSelections.length <= 0"
              type="danger"
              @click="deleteHandler()"
            >{{ contents.btnAdAllFont == 1?'删除':'' }}<i class="el-icon-delete el-icon--right" /></el-button>
            <el-button
              v-if="isAuth('zulinhetong','删除') && contents.btnAdAllIcon == 0 && contents.tableSelection"
              :disabled="dataListSelections.length <= 0"
              type="danger"
              @click="deleteHandler()"
            >{{ contents.btnAdAllFont == 1?'删除':'' }}</el-button>

	    <download-excel v-if="isAuth('zulinhetong','导出')" class = "export-excel-wrapper" :data = "dataList" :fields = "json_fields" name = "租赁合同.xls">
		      <!-- 导出excel -->
            	<el-button
              	v-if="contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 1"
              	type="primary"
              	icon="el-icon-download"
            	>{{ contents.btnAdAllFont == 1?'导出':'' }}</el-button>
            	<el-button
              	v-if="contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 2"
              	type="primary"
            	>{{ contents.btnAdAllFont == 1?'导出':'' }}<i class="el-icon-download el-icon--right" /></el-button>
            	<el-button
              	v-if="contents.btnAdAllIcon == 0"
              	type="primary"
            	>{{ contents.btnAdAllFont == 1?'导出':'' }}</el-button>
       	    </download-excel>
            <el-button
              v-if="isAuth('zulinhetong','打印') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 1"
              type="success"
              icon="el-icon-printer"
              @click="printJson"
            >{{ contents.btnAdAllFont == 1?'打印':'' }}</el-button>
            <el-button
              v-if="isAuth('zulinhetong','打印') && contents.btnAdAllIcon == 1 && contents.btnAdAllIconPosition == 2"
              type="success"
              @click="printJson"
            >{{ contents.btnAdAllFont == 1?'打印':'' }}<i class="el-icon-printer el-icon--right" /></el-button>
            <el-button
              v-if="isAuth('zulinhetong','打印') && contents.btnAdAllIcon == 0"
              type="success"
              @click="printJson"
            >{{ contents.btnAdAllFont == 1?'打印':'' }}</el-button>

          </el-form-item>
        </el-row>
      </el-form>
      <div class="table-content">
        <el-table class="tables" :size="contents.tableSize" :show-header="contents.tableShowHeader"
            :header-row-style="headerRowStyle" :header-cell-style="headerCellStyle"
            :border="contents.tableBorder"
            :fit="contents.tableFit"
            :stripe="contents.tableStripe"
            :row-style="rowStyle"
            :cell-style="cellStyle"
            :style="{width: '100%',fontSize:contents.tableContentFontSize,color:contents.tableContentFontColor}"
            v-if="isAuth('zulinhetong','查看')"
            :data="dataList"
            v-loading="dataListLoading"
            @selection-change="selectionChangeHandler">
            <el-table-column  v-if="contents.tableSelection"
                type="selection"
                header-align="center"
                align="center"
                width="50">
            </el-table-column>
            <el-table-column label="索引" v-if="contents.tableIndex" type="index" width="50" />
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                    prop="fangwubianhao"
                    header-align="center"
		    label="房屋编号">
		     <template slot-scope="scope">
                       {{scope.row.fangwubianhao}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                    prop="fangwumingcheng"
                    header-align="center"
		    label="房屋名称">
		     <template slot-scope="scope">
                       {{scope.row.fangwumingcheng}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                    prop="zhuangtai"
                    header-align="center"
		    label="状态">
		     <template slot-scope="scope">
                       {{scope.row.zhuangtai}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                    prop="zujin"
                    header-align="center"
		    label="租金">
		     <template slot-scope="scope">
                       {{scope.row.zujin}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                    prop="xiangxidizhi"
                    header-align="center"
		    label="详细地址">
		     <template slot-scope="scope">
                       {{scope.row.xiangxidizhi}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                    prop="yonghuming"
                    header-align="center"
		    label="用户名">
		     <template slot-scope="scope">
                       {{scope.row.yonghuming}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                    prop="zukexingming"
                    header-align="center"
		    label="租客姓名">
		     <template slot-scope="scope">
                       {{scope.row.zukexingming}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                    prop="shouji"
                    header-align="center"
		    label="手机">
		     <template slot-scope="scope">
                       {{scope.row.shouji}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                    prop="shenfenzheng"
                    header-align="center"
		    label="身份证">
		     <template slot-scope="scope">
                       {{scope.row.shenfenzheng}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                    prop="fangdongzhanghao"
                    header-align="center"
		    label="房东账号">
		     <template slot-scope="scope">
                       {{scope.row.fangdongzhanghao}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                    prop="fangdongxingming"
                    header-align="center"
		    label="房东姓名">
		     <template slot-scope="scope">
                       {{scope.row.fangdongxingming}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                    prop="lianxishouji"
                    header-align="center"
		    label="联系手机">
		     <template slot-scope="scope">
                       {{scope.row.lianxishouji}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                    prop="zufangzhuangtai"
                    header-align="center"
		    label="租房状态">
		     <template slot-scope="scope">
                       {{scope.row.zufangzhuangtai}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                    prop="zulinriqi"
                    header-align="center"
		    label="租赁日期">
		     <template slot-scope="scope">
                       {{scope.row.zulinriqi}}
                     </template>
                </el-table-column>
                <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                    prop="qiandingshijian"
                    header-align="center"
		    label="签订时间">
		     <template slot-scope="scope">
                       {{scope.row.qiandingshijian}}
                     </template>
                </el-table-column>
                  <el-table-column :sortable="contents.tableSortable" :align="contents.tableAlign" prop="zulinpingzheng"
                    header-align="center"
                    width="200"
                    label="租赁凭证">
                    <template slot-scope="scope">
                      <div v-if="scope.row.zulinpingzheng">
                        <img :src="scope.row.zulinpingzheng.split(',')[0]" width="100" height="100">
                      </div>
                      <div v-else>无图片</div>
                    </template>
                  </el-table-column>
            <el-table-column width="300" :align="contents.tableAlign"
                header-align="center"
                label="操作">
                <template slot-scope="scope">
                <el-button v-if="isAuth('zulinhetong','查看') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1" type="success" icon="el-icon-tickets" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">{{ contents.tableBtnFont == 1?'详情':'' }}</el-button>
                <el-button v-if="isAuth('zulinhetong','查看') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2" type="success" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">{{ contents.tableBtnFont == 1?'详情':'' }}<i class="el-icon-tickets el-icon--right" /></el-button>
                <el-button v-if="isAuth('zulinhetong','查看') && contents.tableBtnIcon == 0" type="success" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">{{ contents.tableBtnFont == 1?'详情':'' }}</el-button>
                <el-button v-if="isAuth('zulinhetong','修改') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1" type="primary" icon="el-icon-edit" size="mini" @click="addOrUpdateHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'修改':'' }}</el-button>
                <el-button v-if="isAuth('zulinhetong','修改') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2" type="primary" size="mini" @click="addOrUpdateHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'修改':'' }}<i class="el-icon-edit el-icon--right" /></el-button>
                <el-button v-if="isAuth('zulinhetong','修改') && contents.tableBtnIcon == 0" type="primary" size="mini" @click="addOrUpdateHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'修改':'' }}</el-button>




                <el-button v-if="isAuth('zulinhetong','删除') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 1" type="danger" icon="el-icon-delete" size="mini" @click="deleteHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'删除':'' }}</el-button>
                <el-button v-if="isAuth('zulinhetong','删除') && contents.tableBtnIcon == 1 && contents.tableBtnIconPosition == 2" type="danger" size="mini" @click="deleteHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'删除':'' }}<i class="el-icon-delete el-icon--right" /></el-button>
                <el-button v-if="isAuth('zulinhetong','删除') && contents.tableBtnIcon == 0" type="danger" size="mini" @click="deleteHandler(scope.row.id)">{{ contents.tableBtnFont == 1?'删除':'' }}</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination
          clsss="pages"
          :layout="layouts"
          @size-change="sizeChangeHandle"
          @current-change="currentChangeHandle"
          :current-page="pageIndex"
          :page-sizes="[10, 20, 50, 100]"
          :page-size="Number(contents.pageEachNum)"
          :total="totalPage"
          :small="contents.pageStyle"
          class="pagination-content"
          :background="contents.pageBtnBG"
          :style="{textAlign:contents.pagePosition==1?'left':contents.pagePosition==2?'center':'right'}"
        ></el-pagination>
      </div>
    </div>
    <!-- 添加/修改页面  将父组件的search方法传递给子组件-->
    <add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>



  </div>
</template>
<script>
import AddOrUpdate from "./add-or-update";
export default {
  data() {
    return {
      searchForm: {
        key: ""
      },
      form:{},
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: true,
      sfshVisiable: false,
      shForm: {},
      chartVisiable: false,
      addOrUpdateFlag:false,
      contents:{"searchBtnFontColor":"#333","pagePosition":"1","inputFontSize":"14px","inputBorderRadius":"4px","tableBtnDelFontColor":"#333","tableBtnIconPosition":"1","searchBtnHeight":"40px","inputIconColor":"#C0C4CC","searchBtnBorderRadius":"4px","tableStripe":true,"btnAdAllWarnFontColor":"#333","tableBtnDelBgColor":"rgba(255, 90, 86, 1)","searchBtnIcon":"1","tableSize":"medium","searchBtnBorderStyle":"solid","tableSelection":true,"searchBtnBorderWidth":"1px","tableContentFontSize":"14px","searchBtnBgColor":"#fff","inputTitleSize":"14px","btnAdAllBorderColor":"#DCDFE6","pageJumper":true,"btnAdAllIconPosition":"1","searchBoxPosition":"1","tableBtnDetailFontColor":"#333","tableBtnHeight":"40px","pagePager":true,"searchBtnBorderColor":"#DCDFE6","tableHeaderFontColor":"#909399","inputTitle":"1","tableBtnBorderRadius":"4px","btnAdAllFont":"1","btnAdAllDelFontColor":"#333","tableBtnIcon":"1","btnAdAllHeight":"40px","btnAdAllWarnBgColor":"rgba(91, 192, 222, 1)","btnAdAllBorderWidth":"1px","tableStripeFontColor":"#606266","tableBtnBorderStyle":"solid","inputHeight":"40px","btnAdAllBorderRadius":"4px","btnAdAllDelBgColor":"rgba(255, 90, 86, 1)","pagePrevNext":true,"btnAdAllAddBgColor":"rgba(66, 139, 202, 1)","searchBtnFont":"1","tableIndex":true,"btnAdAllIcon":"1","tableSortable":false,"pageSizes":true,"tableFit":true,"pageBtnBG":true,"searchBtnFontSize":"14px","tableBtnEditBgColor":"rgba(91, 192, 222, 1)","inputBorderWidth":"1px","inputFontPosition":"1","inputFontColor":"#333","pageEachNum":10,"tableHeaderBgColor":"#fff","inputTitleColor":"#333","btnAdAllBoxPosition":"1","tableBtnDetailBgColor":"rgba(66, 139, 202, 1)","inputIcon":"1","searchBtnIconPosition":"1","btnAdAllFontSize":"14px","inputBorderStyle":"solid","inputBgColor":"#fff","pageStyle":false,"pageTotal":true,"btnAdAllAddFontColor":"#333","tableBtnFont":"1","tableContentFontColor":"#606266","inputBorderColor":"#DCDFE6","tableShowHeader":true,"tableBtnFontSize":"14px","tableBtnBorderColor":"#DCDFE6","inputIconPosition":"1","tableBorder":true,"btnAdAllBorderStyle":"solid","tableBtnBorderWidth":"1px","tableStripeBgColor":"#F5F7FA","tableBtnEditFontColor":"#333","tableAlign":"center"},
      layouts: '',

//导出excel
      json_fields: {
      "房屋编号": "fangwubianhao",    //常规字段
      "房屋名称": "fangwumingcheng",    //常规字段
      "状态": "zhuangtai",    //常规字段
      "租金": "zujin",    //常规字段
      "详细地址": "xiangxidizhi",    //常规字段
      "用户名": "yonghuming",    //常规字段
      "租客姓名": "zukexingming",    //常规字段
      "手机": "shouji",    //常规字段
      "身份证": "shenfenzheng",    //常规字段
      "房东账号": "fangdongzhanghao",    //常规字段
      "房东姓名": "fangdongxingming",    //常规字段
      "联系手机": "lianxishouji",    //常规字段
      "租房状态": "zufangzhuangtai",    //常规字段
      "租赁日期": "zulinriqi",    //常规字段
      "签订时间": "qiandingshijian",    //常规字段
      "租赁凭证": "zulinpingzheng",    //常规字段
      "用户id": "userid",    //常规字段
      },
      json_meta: [
        [
          {
            " key ": " charset ",
            " value ": " utf- 8 "
          }
        ]
      ]

    };
  },
  created() {
    this.init();
    this.getDataList();
    this.contentStyleChange()
  },
  mounted() {

  },
  filters: {
    htmlfilter: function (val) {
      return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
    }
  },
  components: {
    AddOrUpdate,
  },
  methods: {
    contentStyleChange() {
      this.contentSearchStyleChange()
      this.contentBtnAdAllStyleChange()
      this.contentSearchBtnStyleChange()
      this.contentTableBtnStyleChange()
      this.contentPageStyleChange()
    },
    contentSearchStyleChange() {
      this.$nextTick(()=>{
        document.querySelectorAll('.form-content .slt .el-input__inner').forEach(el=>{
          let textAlign = 'left'
          if(this.contents.inputFontPosition == 2) textAlign = 'center'
          if(this.contents.inputFontPosition == 3) textAlign = 'right'
          el.style.textAlign = textAlign
          el.style.height = this.contents.inputHeight
          el.style.lineHeight = this.contents.inputHeight
          el.style.color = this.contents.inputFontColor
          el.style.fontSize = this.contents.inputFontSize
          el.style.borderWidth = this.contents.inputBorderWidth
          el.style.borderStyle = this.contents.inputBorderStyle
          el.style.borderColor = this.contents.inputBorderColor
          el.style.borderRadius = this.contents.inputBorderRadius
          el.style.backgroundColor = this.contents.inputBgColor
        })
        if(this.contents.inputTitle) {
          document.querySelectorAll('.form-content .slt .el-form-item__label').forEach(el=>{
            el.style.color = this.contents.inputTitleColor
            el.style.fontSize = this.contents.inputTitleSize
            el.style.lineHeight = this.contents.inputHeight
          })
        }
        setTimeout(()=>{
          document.querySelectorAll('.form-content .slt .el-input__prefix').forEach(el=>{
            el.style.color = this.contents.inputIconColor
            el.style.lineHeight = this.contents.inputHeight
          })
          document.querySelectorAll('.form-content .slt .el-input__suffix').forEach(el=>{
            el.style.color = this.contents.inputIconColor
            el.style.lineHeight = this.contents.inputHeight
          })
          document.querySelectorAll('.form-content .slt .el-input__icon').forEach(el=>{
            el.style.lineHeight = this.contents.inputHeight
          })
        },10)

      })
    },
    // 搜索按钮
    contentSearchBtnStyleChange() {
      this.$nextTick(()=>{
        document.querySelectorAll('.form-content .slt .el-button--success').forEach(el=>{
          el.style.height = this.contents.searchBtnHeight
          el.style.color = this.contents.searchBtnFontColor
          el.style.fontSize = this.contents.searchBtnFontSize
          el.style.borderWidth = this.contents.searchBtnBorderWidth
          el.style.borderStyle = this.contents.searchBtnBorderStyle
          el.style.borderColor = this.contents.searchBtnBorderColor
          el.style.borderRadius = this.contents.searchBtnBorderRadius
          el.style.backgroundColor = this.contents.searchBtnBgColor
        })
      })
    },
    // 新增、批量删除
    contentBtnAdAllStyleChange() {
      this.$nextTick(()=>{
        document.querySelectorAll('.form-content .ad .el-button--success').forEach(el=>{
          el.style.height = this.contents.btnAdAllHeight
          el.style.color = this.contents.btnAdAllAddFontColor
          el.style.fontSize = this.contents.btnAdAllFontSize
          el.style.borderWidth = this.contents.btnAdAllBorderWidth
          el.style.borderStyle = this.contents.btnAdAllBorderStyle
          el.style.borderColor = this.contents.btnAdAllBorderColor
          el.style.borderRadius = this.contents.btnAdAllBorderRadius
          el.style.backgroundColor = this.contents.btnAdAllAddBgColor
        })
        document.querySelectorAll('.form-content .ad .el-button--danger').forEach(el=>{
          el.style.height = this.contents.btnAdAllHeight
          el.style.color = this.contents.btnAdAllDelFontColor
          el.style.fontSize = this.contents.btnAdAllFontSize
          el.style.borderWidth = this.contents.btnAdAllBorderWidth
          el.style.borderStyle = this.contents.btnAdAllBorderStyle
          el.style.borderColor = this.contents.btnAdAllBorderColor
          el.style.borderRadius = this.contents.btnAdAllBorderRadius
          el.style.backgroundColor = this.contents.btnAdAllDelBgColor
        })
        document.querySelectorAll('.form-content .ad .el-button--warning').forEach(el=>{
          el.style.height = this.contents.btnAdAllHeight
          el.style.color = this.contents.btnAdAllWarnFontColor
          el.style.fontSize = this.contents.btnAdAllFontSize
          el.style.borderWidth = this.contents.btnAdAllBorderWidth
          el.style.borderStyle = this.contents.btnAdAllBorderStyle
          el.style.borderColor = this.contents.btnAdAllBorderColor
          el.style.borderRadius = this.contents.btnAdAllBorderRadius
          el.style.backgroundColor = this.contents.btnAdAllWarnBgColor
        })
      })
    },
    // 表格
    rowStyle({ row, rowIndex}) {
      if (rowIndex % 2 == 1) {
        if(this.contents.tableStripe) {
          return {color:this.contents.tableStripeFontColor}
        }
      } else {
        return ''
      }
    },
    cellStyle({ row, rowIndex}){
      if (rowIndex % 2 == 1) {
        if(this.contents.tableStripe) {
          return {backgroundColor:this.contents.tableStripeBgColor}
        }
      } else {
        return ''
      }
    },
    headerRowStyle({ row, rowIndex}){
      return {color: this.contents.tableHeaderFontColor}
    },
    headerCellStyle({ row, rowIndex}){
      return {backgroundColor: this.contents.tableHeaderBgColor}
    },
    // 表格按钮
    contentTableBtnStyleChange(){
      // this.$nextTick(()=>{
      //   setTimeout(()=>{
      //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--success').forEach(el=>{
      //       el.style.height = this.contents.tableBtnHeight
      //       el.style.color = this.contents.tableBtnDetailFontColor
      //       el.style.fontSize = this.contents.tableBtnFontSize
      //       el.style.borderWidth = this.contents.tableBtnBorderWidth
      //       el.style.borderStyle = this.contents.tableBtnBorderStyle
      //       el.style.borderColor = this.contents.tableBtnBorderColor
      //       el.style.borderRadius = this.contents.tableBtnBorderRadius
      //       el.style.backgroundColor = this.contents.tableBtnDetailBgColor
      //     })
      //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--primary').forEach(el=>{
      //       el.style.height = this.contents.tableBtnHeight
      //       el.style.color = this.contents.tableBtnEditFontColor
      //       el.style.fontSize = this.contents.tableBtnFontSize
      //       el.style.borderWidth = this.contents.tableBtnBorderWidth
      //       el.style.borderStyle = this.contents.tableBtnBorderStyle
      //       el.style.borderColor = this.contents.tableBtnBorderColor
      //       el.style.borderRadius = this.contents.tableBtnBorderRadius
      //       el.style.backgroundColor = this.contents.tableBtnEditBgColor
      //     })
      //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--danger').forEach(el=>{
      //       el.style.height = this.contents.tableBtnHeight
      //       el.style.color = this.contents.tableBtnDelFontColor
      //       el.style.fontSize = this.contents.tableBtnFontSize
      //       el.style.borderWidth = this.contents.tableBtnBorderWidth
      //       el.style.borderStyle = this.contents.tableBtnBorderStyle
      //       el.style.borderColor = this.contents.tableBtnBorderColor
      //       el.style.borderRadius = this.contents.tableBtnBorderRadius
      //       el.style.backgroundColor = this.contents.tableBtnDelBgColor
      //     })

      //   }, 50)
      // })
    },
    // 分页
    contentPageStyleChange(){
      let arr = []

      if(this.contents.pageTotal) arr.push('total')
      if(this.contents.pageSizes) arr.push('sizes')
      if(this.contents.pagePrevNext){
        arr.push('prev')
        if(this.contents.pagePager) arr.push('pager')
        arr.push('next')
      }
      if(this.contents.pageJumper) arr.push('jumper')
      this.layouts = arr.join()
      this.contents.pageEachNum = 10
    },

    init () {
    },
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },
    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: 'id',
      }
          if(this.searchForm.fangwubianhao!='' && this.searchForm.fangwubianhao!=undefined){
            params['fangwubianhao'] = '%' + this.searchForm.fangwubianhao + '%'
          }
          if(this.searchForm.shenfenzheng!='' && this.searchForm.shenfenzheng!=undefined){
            params['shenfenzheng'] = '%' + this.searchForm.shenfenzheng + '%'
          }
      this.$http({
        url: "zulinhetong/page",
        method: "get",
        params: params
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.dataList = data.data.list;
          this.totalPage = data.data.total;
        } else {
          this.dataList = [];
          this.totalPage = 0;
        }
        this.dataListLoading = false;
      });
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // 添加/修改
    addOrUpdateHandler(id,type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if(type!='info'){
        type = 'else';
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id,type);
      });
    },
    // 查看评论
    // 下载
    download(file){
      window.open(`${file}`)
    },
    // 删除
    deleteHandler(id) {
      var ids = id
        ? [Number(id)]
        : this.dataListSelections.map(item => {
            return Number(item.id);
          });
      this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "zulinhetong/delete",
          method: "post",
          data: ids
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "操作成功",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.search();
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },
    async printJson() {
      //通过getdata调用后台接口获取数据封装到res
      this.list = this.dataList;
      let data = []
      for (let i=0; i < this.list.length; i++) {
          data.push({
          fangwubianhao: this.list[i].fangwubianhao,
          fangwumingcheng: this.list[i].fangwumingcheng,
          zhuangtai: this.list[i].zhuangtai,
          zujin: this.list[i].zujin,
          xiangxidizhi: this.list[i].xiangxidizhi,
          yonghuming: this.list[i].yonghuming,
          zukexingming: this.list[i].zukexingming,
          shouji: this.list[i].shouji,
          shenfenzheng: this.list[i].shenfenzheng,
          fangdongzhanghao: this.list[i].fangdongzhanghao,
          fangdongxingming: this.list[i].fangdongxingming,
          lianxishouji: this.list[i].lianxishouji,
          zufangzhuangtai: this.list[i].zufangzhuangtai,
          zulinriqi: this.list[i].zulinriqi,
          qiandingshijian: this.list[i].qiandingshijian,
          userid: this.list[i].userid,
        })
      }
      printJS({
        printable: data,
        properties: [
	  {
		field: 'fangwubianhao',
		displayName: '房屋编号',
		columnSize: 1
	  },
	  {
		field: 'fangwumingcheng',
		displayName: '房屋名称',
		columnSize: 1
	  },
	  {
		field: 'zhuangtai',
		displayName: '状态',
		columnSize: 1
	  },
	  {
		field: 'zujin',
		displayName: '租金',
		columnSize: 1
	  },
	  {
		field: 'xiangxidizhi',
		displayName: '详细地址',
		columnSize: 1
	  },
	  {
		field: 'yonghuming',
		displayName: '用户名',
		columnSize: 1
	  },
	  {
		field: 'zukexingming',
		displayName: '租客姓名',
		columnSize: 1
	  },
	  {
		field: 'shouji',
		displayName: '手机',
		columnSize: 1
	  },
	  {
		field: 'shenfenzheng',
		displayName: '身份证',
		columnSize: 1
	  },
	  {
		field: 'fangdongzhanghao',
		displayName: '房东账号',
		columnSize: 1
	  },
	  {
		field: 'fangdongxingming',
		displayName: '房东姓名',
		columnSize: 1
	  },
	  {
		field: 'lianxishouji',
		displayName: '联系手机',
		columnSize: 1
	  },
	  {
		field: 'zufangzhuangtai',
		displayName: '租房状态',
		columnSize: 1
	  },
	  {
		field: 'zulinriqi',
		displayName: '租赁日期',
		columnSize: 1
	  },
	  {
		field: 'qiandingshijian',
		displayName: '签订时间',
		columnSize: 1
	  },
	  {
		field: 'userid',
		displayName: '用户id',
		columnSize: 1
	  },
        ],
        type: 'json',
        header: '租赁合同',
        // 样式设置
        gridStyle: 'border: 2px solid #3971A5;',
        gridHeaderStyle: 'color: red;  border: 2px solid #3971A5;'
      })
    },
  }

};
</script>
<style lang="scss" scoped>
//导出excel
  .export-excel-wrapper{
    display: inline-block;
  }
  .slt {
    margin: 0 !important;
    display: flex;
  }

  .ad {
    margin: 0 !important;
    display: flex;
  }

  .pages {
    & /deep/ el-pagination__sizes{
      & /deep/ el-input__inner {
        height: 22px;
        line-height: 22px;
      }
    }
  }
  

  .el-button+.el-button {
    margin:0;
  } 

  .tables {
	& /deep/ .el-button--success {
		height: 40px;
		color: #333;
		font-size: 14px;
		border-width: 1px;
		border-style: solid;
		border-color: #DCDFE6;
		border-radius: 4px;
		background-color: rgba(66, 139, 202, 1);
	}
	
	& /deep/ .el-button--primary {
		height: 40px;
		color: #333;
		font-size: 14px;
		border-width: 1px;
		border-style: solid;
		border-color: #DCDFE6;
		border-radius: 4px;
		background-color: rgba(91, 192, 222, 1);
	}
	
	& /deep/ .el-button--danger {
		height: 40px;
		color: #333;
		font-size: 14px;
		border-width: 1px;
		border-style: solid;
		border-color: #DCDFE6;
		border-radius: 4px;
		background-color: rgba(255, 90, 86, 1);
	}

    & /deep/ .el-button {
      margin: 4px;
    }
  }

</style>
