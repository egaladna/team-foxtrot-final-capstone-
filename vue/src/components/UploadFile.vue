<template>
  <div>
    <button v-if="!showUpload" @click="showUpload = true">Add Clothes</button>
    <div v-if="showUpload" class="uploading-display">
      <div>
        <label for="category">Category:</label>
        <select id="category" v-model="selectedType">
          <option v-for="type in types" v-bind:key="type" :value="type">
            {{ type }}
          </option>
        </select>
      </div>

      <button @click="uploadFile">Select Files</button>
      <div v-if="urlsToUpload.length != 0" id="pendingimages">
        <div>
          <img v-for="url in urlsToUpload" :key="url.id" v-bind:src="url" />
        </div>
        <button @click.prevent="addClothesToDb">Add to Closet</button>
        <button @click.prevent="cancelAdd">Cancel</button>
      </div>
    </div>
  </div>
</template>

<script>
import ClosetService from "@/services/ClosetService";

export default {
  data() {
    return {
      types: [],
      urlsToUpload: [],
      selectedType: "TOP",
      showUpload: false,
    };
  },
  methods: {
    uploadFile() {
      console.log("My Name");
      window.cloudinary.createUploadWidget(
        {
          cropping: true,
          croppingAspectRatio: 3 / 4,
          croppingDefaultSelectionRatio: 1,
          croppingValidateDimensions: true,
          croppingShowDimensions: false,
          croppingCoordinatesMode: "custom",
          croppingShowBackButton: true,
          cloud_name: "dlnxljpbd",
          upload_preset: "pyfnga5z",
          resourceType: 'image'
        },
        (error, result) => {
          if (!error && result && result.event === "success") {
            this.urlsToUpload.push(result.info.secure_url);
          }
          console.log(this.urlsToUpload);
        }
      ).open();
    },
    addClothesToDb() {
      let cloth = {
        type: this.selectedType,
        imgUrl: "",
      };
      this.urlsToUpload.forEach((url) => {
        cloth.imgUrl = url;
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
      this.showUpload = false;
    },
    cancelAdd() {
      this.urlsToUpload = [];
      this.showUpload = false;
    },
  },
  created() {
    ClosetService.getTypes()
      .then((response) => {
        this.types = response.data;
      })
      .catch((err) => console.error(err));
  },
};
</script>


<style>
</style>