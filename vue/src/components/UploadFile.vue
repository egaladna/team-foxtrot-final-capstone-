<template>
  <div>
    <!-- <UploadWidget /> -->
    <button @click="uploadFile">Add To Closet</button>
    <span v-for="url in urlsToUploadclass" :key="url.id" id="pendingimages">
        <img src="url" alt="">
    </span>
  </div>
</template>

<script>
import ClosetService from '@/services/ClosetService';
export default {
  data() {
    return {
      urlsToUpload: [],
      selectedType: 'TOP'
    };
  },

  methods: {
    uploadFile() {
      console.log("My Name");
      window.cloudinary
        .createUploadWidget(
          {
            cloud_name: "dlnxljpbd",
            upload_preset: "isitiv64",
          },
          (error, result) => {
            if (!error && result && result.event === "success") {
              this.urlsToUpload.push(result.info.secure_url);
              console.log(this.urlsToUpload);
            }
            console.log("done with method: ");
            console.log(this.urlsToUpload);

          }
          
        )
        .open();
    },
    addClothesToDb(resultsList) {
        let cloth = {
            imgUrl: '',
            type: this.selectedType
        }
        resultsList.forEach(result => {
            cloth.imgUrl = result.info.secure_url;
            ClosetService.addClothesToDb(cloth).then(response => {
                if(response.status == 200) {
                    console.log("added to db");
                }
            }).then(err => console.error(err));
        })
        this.$router.go();
    }
  },
};
</script>

<style>
</style>