<template>
  <el-upload
    class="img-upload"
    ref="upload"
    action="http://localhost:8443/api/covers"
    accept="image/jpeg,image/gif,image/png"
    :on-preview="handlePreview"
    :on-remove="handleRemove"
    :before-remove="beforeRemove"
    :on-success="handleSuccess"
    :before-upload="beforeAvatarUpload"
    multiple
    :limit="1"
    :on-exceed="handleExceed"
    list-type="picture"
    :file-list="fileList">
    <el-button size="small" type="primary">点击上传</el-button>
    <div slot="tip" class="el-upload__tip">只能上传jpg/png/gif文件，且不超过2MB!</div>
  </el-upload>
</template>

<script>
  export default {
    name: 'ImgUpload',
    data () {
      return {
        fileList: [],
        url: '',
      }
    },
    methods: {
      handleRemove(file, fileList) {
        //console.log(file, fileList);
        this.$message.warning('移除成功')
      },
      handlePreview(file) {
        //console.log(file);
      },
      handleExceed (files, fileList) {
        this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`)
      },
      beforeRemove (file, fileList) {
        return this.$confirm(`确定移除 ${file.name}？`)
      },
      handleSuccess (response) {
        this.url = response
        this.$emit('onUpload')
        this.$message.warning('上传成功')
      },
      clear () {
        this.$refs.upload.clearFiles()
      },
      beforeAvatarUpload(file) {
      /*  const isJPG = file.type === 'image/jpeg';*/
        const isLt2M = file.size / 1024 / 1024 < 2;

       /* if (!isJPG) {
          this.$message.error('上传头像图片只能是 JPG 格式!');
        }*/
        if (!isLt2M) {
          this.$message.error('上传图片大小不能超过 2MB!');
        }
        return  isLt2M;
      },
    }
  }
</script>
