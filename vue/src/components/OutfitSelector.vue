<template>
  <div id="whole-selector-page">
    <div
      id="selector-area"
      @drop="onDeselectDrop($event)"
      @dragover.prevent
      @dragenter.prevent
    >
      <div class="each-type" v-for="type in types" :key="type.id">
        <p>{{ type }}</p>
        <div id="all-images-for-type">
          <div
            v-for="cloth in getItemsForType(type)"
            :key="cloth.id"
            id="each-image"
            draggable
            @dragstart="startDrag($event, cloth.id)"
          >
            <img :src="cloth.imgUrl" alt="" />
          </div>
        </div>
      </div>
    </div>

    <div
      id="selected-items-area"
      @drop="onSelectDrop($event)"
      @dragover.prevent
      @dragenter.prevent
    >
      <!-- <p>Selected Items:</p>
      <div v-for="item in selectedItems" :key="item.id" id="each-selected-item"
      draggable
      @dragstart="startDrag($event, item.id)">
        <img :src="item.imgUrl" alt="">
      </div> -->

      <p>Selected Items</p>
      <div
        class="selectedItemsDiv"
        v-for="type in types"
        :key="type.id"
        draggable
        @dragstart="startDrag($event, getSelectionForType(type).id)"
      >
        <SelectedItem :type="type" />
      </div>
      <i
        class="fa fa-save"
        title="Save"
        style="font-size: 24px"
        v-on:click.prevent="saveOutfits"
      ></i>
      <button @click="randomGenerator">Randomize Outfit</button>
    </div>
  </div>
</template>

<script>
import ClosetService from "@/services/ClosetService";
import OutfitService from "../services/OutfitService";
import SelectedItem from "../components/SelectedItem.vue";
export default {
  components: {
    SelectedItem,
  },
  methods: {
    refreshCloset() {
      ClosetService.getClothingList()
        .then((response) => {
          this.$store.commit("UPDATE_CLOSET", response.data);
        })
        .catch((err) => console.error(err));
    },
    getItemsForType(type) {
      return this.nonSelectedItems.filter((item) => {
        return item.type == type;
      });
    },
    getSelectionForType(type) {
      return this.selectedItems.find(item => {
        return item.type == type;
      })
    },
    makeSelectedItem(cloth) {
      this.$store.commit("SELECT_ITEM", cloth);
    },
    deselectItem(cloth) {
      this.$store.commit("DESELECT_ITEM", cloth);
    },
    startDrag(evt, clothId) {
      evt.dataTransfer.dropEffect = "move";
      evt.dataTransfer.effectAllowed = "move";
      evt.dataTransfer.setData("clothId", clothId);
    },
    onSelectDrop(evt) {
      const clothId = evt.dataTransfer.getData("clothId");
      const cloth = this.clothesList.find((item) => item.id == clothId);
      console.log(cloth);
      this.makeSelectedItem(cloth);
    },
    onDeselectDrop(evt) {
      const clothId = evt.dataTransfer.getData("clothId");
      const cloth = this.clothesList.find((item) => item.id == clothId);
      console.log(cloth);
      this.deselectItem(cloth);
    },
    saveOutfits() {
      OutfitService.addOutfit(this.cleanedUpList);
      this.$store.commit("CLEAR_SELECTION");
    },
    randomGenerator() {
      this.types.forEach((type) => {
        let allClothesOfType = this.getItemsForType(type);
        if (allClothesOfType.length > 0) {
          let randomIndex = Math.floor(Math.random() * allClothesOfType.length);
          this.$store.commit("SELECT_ITEM", allClothesOfType[randomIndex]);
        }
      });
    },
  },
  data() {
    return {
      types: [],
    };
  },
  computed: {
    selectedItems() {
      return this.$store.state.selectedItems;
    },
    clothesList() {
      this.refreshCloset();
      return this.$store.state.myCloset;
    },
    nonSelectedItems() {
      return this.clothesList.filter((cloth) => {
        let isSelected = false;
        this.selectedItems.forEach(item => {
          if (item.id == cloth.id){
            isSelected = true;
          }
        });
        return !isSelected;
      });
    },
    cleanedUpList() {
      return this.$store.state.selectedItems.filter((item) => {
        return item.id;
      });
    },
  },

  created() {
    this.refreshCloset;
    ClosetService.getTypes()
      .then((response) => {
        this.types = response.data;
      })
      .catch((err) => console.error(err));
  },
};
</script>

<style>
#whole-selector-page {
  display: flex;
  justify-content: space-between;
}
#all-images-for-type {
  display: flex;
  flex-wrap: wrap;
}
#selected-items-area {
  border: solid #1b3536;
  border-radius: 8px;
  padding-left: 5%;
  padding-right: 5%;
}
</style>