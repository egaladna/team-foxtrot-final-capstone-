<template>
  <div>
    <!-- <UploadWidget /> -->
    <button @click="uploadFile">Upload Files</button>
    <div v-if="urlsToUpload.length != 0" id="pendingimages">
      <div>
        <img v-for="url in urlsToUpload" :key="url.id" v-bind:src="url" />
      </div>
      <button @click.prevent="addClothesToDb">Add to Closet</button>
      <button @click.prevent="cancelAdd">Cancel</button>
    </div>
  </div>
</template>

<script>
import ClosetService from "@/services/ClosetService";
export default {
  data() {
    return {
      urlsToUpload: [],
      selectedType: "TOP",
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
        imgUrl: "",
      };
      this.urlsToUpload.forEach((url) => {
        cloth.imgUrl = url;
        console.log(cloth);
        ClosetService.addClothingItem(cloth)
          .then((response) => {
            if (response.status == 200) {
              ClosetService.getClothingList()
                .then((response) => {
                  this.$store.commit("UPDATE_CLOSET", response.data);
                })
                .catch((err) => console.error(err));
            }
          })
          .then((err) => console.error(err));
      });
      this.urlsToUpload = [];
    },
    cancelAdd() {
      this.urlsToUpload = [];
    },
  },
};
</script>

<style>
</style>