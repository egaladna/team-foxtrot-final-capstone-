<template>
  <div>
    <div  v-if="!showUpload" @click="showUpload = true" class="icon">
      
    <box-icon name='closet' animation='tada' ></box-icon>
    <p>ADD CLOTHES TO YOUR CLOSET</p>
    </div>
    <div v-if="showUpload" class="uploading-display">
      <div>
        <div class="instruction">
          <!-- instructions here possibly -->
        </div>
        <label for="category">Category:</label>
        <select id="category" v-model="selectedType">
          <option v-for="type in types" v-bind:key="type" :value="type">
            {{ type }}
          </option>
        </select>
      </div>
      <button  class="file" @click="uploadFile" style="font-size:24px">Select Files <i class="fa fa-upload"></i></button>
      <div v-if="urlsToUpload.length != 0" id="pendingimages">
        <div>
          <img v-for="url in urlsToUpload" :key="url.id" v-bind:src="url" />
        </div>

         <i class ="fa fa-plus" style="font-size:24px" title="Add to Closet" @click.prevent="addClothesToDb"></i>
         <i class ="fa fa-times" style="font-size:24px" title="Cancel" @click.prevent="cancelAdd"></i>
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


<style scoped>

.icon {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  padding-bottom: 20px;
  box-shadow: -1px 0 12px black;
  border: 3px solid rgba(255, 255, 255, 0.1);
  border-radius: 20px;
  border-left: -100px;
  border-right: -100px;  
}
.icon p{
  font-family: 'Junge';
  font-weight: 900;
  
}
img {
  width: 150px;
  height: 200px;
}

.file {
 display: flex;
 justify-content: center;
 align-items: center;
 color: black;
}

</style>