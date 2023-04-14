<template>
  <div>
    <!-- <UploadWidget /> -->
    <button @click="uploadFile">Upload Files</button>
    <span v-if="urlsToUpload" id="pendingimages">
        <img v-for="url in urlsToUpload" :key="url.id" v-bind:src="url" alt="">
    </span>
    <button @click.prevent="addClothesToDb">Add to Closet</button>
    <button @click.prevent="cancelAdd">Cancel</button>
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
    addClothesToDb() {
        let cloth = {
            type: this.selectedType,
            imgUrl: ''
        }
        this.urlsToUpload.forEach(url => {
            cloth.imgUrl = url;
            console.log(cloth);
            ClosetService.addClothingItem(cloth).then(response => {
                if(response.status == 200) {
                    console.log("added to db");
                }
            }).then(err => console.error(err));
        })
        this.urlsToUpload = [];
        this.$router.go();
    },
    cancelAdd() {
        this.urlsToUpload = [];
    }
  },
};
</script>

<style>
</style>