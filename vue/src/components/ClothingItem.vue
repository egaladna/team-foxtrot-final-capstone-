<template>
  <div>
    <img v-bind:src="cloth.imgUrl" />
    <i
      class="fa fa-edit"
      title="Update Item"
      style="font-size: 20px"
      v-on:click.prevent="showItemEditor = true"
    ></i>
    <div id="itemEdit" v-if="showItemEditor">
      <div id="typeSelector">
        <label for="category">Click to Save</label>
        <div>
          Item Type:
          <select id="category" v-model="updatedType">
            <option v-for="type in types" v-bind:key="type" :value="type">
              {{ type }}
            </option>
          </select>
        </div>
        Item Color:
        <select id="category" v-model="updatedColor">
          <option v-for="color in colors" v-bind:key="color" :value="color">
            {{ color }}
          </option>
        </select>
      </div>
      <i
        class="fa fa-save"
        title="Save Changes"
        style="font-size: 24px"
        @click.prevent="updateClothingItem"
        ></i>
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
div img {
  height: auto;
  width: 100px;
}
</style>