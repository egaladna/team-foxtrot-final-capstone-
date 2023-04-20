<template>
  <div class="container">
    <img class="clothing-image" v-bind:src="cloth.imgUrl" />
    <div class="icons">
    <i
      class="fa fa-edit"
      title="Update Item"
      style="font-size: 20px"
      v-on:click.prevent="showItemEditor = true"
    ></i>
    
    <i
          class="fa fa-trash-o"
          title="Delete"
          style="font-style: 24px"
          v-on:click.prevent="deleteClothingItem(cloth.id)"
        ></i>
        </div>
    <div id="itemEdit" v-if="showItemEditor">
      <div id="typeSelector">
        <div class="item-type">
          Item Type:
          <select id="category" v-model="updatedType">
            <option v-for="type in types" v-bind:key="type" :value="type">
              {{ type }}
            </option>
          </select>
        </div>
        <div class="item-color">
        Item Color:
        <select id="category" v-model="updatedColor">
          <option v-for="color in colors" v-bind:key="color" :value="color">
            {{ color }}
          </option>
        </select>
        </div>
      </div>
      <div class="save">
      <i
        class="fa fa-save"
        title="Save Changes"
        style="font-size: 24px"
        @click.prevent="updateClothingItem"
        ></i>
      <div class="cancel">
      <i
        class="fa fa-window-close-o"
        title="Exit Changes"
        style="font-size: 24px"
        @click.prevent="cancelUpdate"
        ></i>
    </div>
      </div>
    </div>
  </div>
</template>

<script>
import ClosetService from "../services/ClosetService.js";

export default {
  data() {
    return {
      types: [],
      colors: [],
      showItemEditor: false,
      updatedColor: this.cloth.color,
      updatedType: this.cloth.type,
    };
  },
  name: "clothing-item",
  props: ["cloth"],
  methods: {
     refreshCloset() {
      ClosetService.getClothingList()
        .then((response) => {
          this.$store.commit("UPDATE_CLOSET", response.data);
        })
        .catch((err) => console.error(err));
    },
    updateClothingItem() {
      let updatedCloth = this.cloth;
      updatedCloth.color = this.updatedColor;
      updatedCloth.type = this.updatedType;
      ClosetService.updateClothingItem(updatedCloth)
        .then((response) => {
          if (response.status == 200) {
            console.log("Updated item");
          }
        })
        .catch((err) => console.error(err));
      this.showItemEditor = false;
    },
    cancelUpdate() {
      this.updatedColor = this.cloth.color;
      this.updatedType = this.cloth.type;
      this.showItemEditor = false;
    },
    deleteClothingItem(itemId) {
      if (
        confirm(
          "Are you sure you want to delete this garment? It will also be removed from any saved outfits."
        ) == true
      ) {
        ClosetService.deleteClothingItem(itemId)
          .then((response) => {
            if (response.status == 200) {
             this.refreshCloset();
            }
          })
          .catch((err) => console.error(err));
      }
    },
  },
  created() {
    ClosetService.getTypes()
      .then((response) => {
        this.types = response.data;
      })
      .catch((err) => console.error(err));

    ClosetService.getColors()
      .then((response) => {
        this.colors = response.data;
      })
      .catch((err) => console.error(err));
  },
};
</script>

<style scoped>
#itemEdit{
  display: flex;
  position: absolute;
  border: 1px solid black;
  background-color: #EBEFD1;
  z-index: 100;
}

::-webkit-scrollbar-thumb{
  height: 30px;
}


.clothing-image{
  width: 150px;
  height: 200px;
  

}
.container {
  padding-left: 20px;
  padding-right: 20px;
}
.item-type{
  display: flex;
  flex-direction: column;
}
.item-color{
  display: flex;
  flex-direction: column;
}
div img {
  height: auto;
  width: 100px;
}
</style>