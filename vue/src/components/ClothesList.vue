<template>
  <div id="closet">
    <h1>My Closet</h1>
    <div id="clothing-items">
      <div v-for="cloth in displayedClothes" v-bind:key="cloth.id">
        <ClothingItem v-bind:cloth="cloth" />
        <input type="file" v-on:change="selectFile" />
        <!-- <button v-on:click.prevent="uploadFile"></button> -->
        <i
          class="fa fa-trash-o"
          title="Delete"
          style="font-style: 24px"
          v-on:click.prevent="deleteClothingItem(cloth.id)"
        ></i>
        <!-- <p id="msg"></p> -->
      </div>
    </div>
  </div>
</template>

<script>
import ClothingItem from "@/components/ClothingItem";
import ClosetService from "@/services/ClosetService";
import {  storage } from "../main.js";

export default {
  data() {
    return {
      clothing: [],
      fileInput: {},
    };
  },

  components: {
    ClothingItem,
  },

  methods: {
    // uploadFile(file) {
    //   const storageRef = storage.ref();
    //   const fileRef = storageRef.child(file.name);
    //   return fileRef.put(file);
    // },
    // uploadFile() {
    //   console.log(this.fileInput);
    //const file = this.fileInput.files[0]
    //   const storageRef = storage.ref()
    //   console.log(storage.ref());
    //   const fileRef = storageRef.child(this.fileInput.name)
    //   fileRef.put(this.fileInput).then((response) => {
    //     response.catch( err => {
    //       console.error(err);
    //     })
    //     console.log('File uploaded successfully!')
    //   }).catch( err => {
    //     console.error(err);
    //   })
    // },
    selectFile(event) {
      console.log(event.target.files);
      let temp = event.target.files[0];

      const storageRef = storage().ref("fileInput/" + this.fileInput.name);

      storageRef.put(temp);
      console.log(this.fileInput);
    },
    getClothesList() {
      ClosetService.getClothingList()
        .then((response) => {
          this.clothing = response.data;
        })
        .catch((err) => {
          console.error(err);
        });
    },

    deleteClothingItem(itemId) {
      if (
        confirm(
          "Are you sure you want to delete this garment? It will also be removed from any saved otufits."
        ) == true
      ) {
        ClosetService.deleteClothingItem(itemId)
          .then((response) => {
            if (response.status == 200) {
              this.getClothesList();
            }
          })
          .catch((err) => console.error(err));
      }
    },
  },

  computed: {
    displayedClothes() {
      return this.clothing.filter((cloth) => {
        return cloth;
      });
    },
  },

  created() {
    this.getClothesList();
  },
};
</script>

<style>
#clothing-items {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
}
#closet {
  display: flex;
  flex-direction: column;
}
</style>