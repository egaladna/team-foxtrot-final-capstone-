<template>
<section class="clear-wrapper">
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
            <i
              class="fa fa-random"
              aria-hidden="true"
              style="font-size: 24px"
              v-if="getItemsForType(type).length > 1"
              @click="randomGeneratorForType(type)"
            ></i>
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

      <p>Mix & Match</p>
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
       <i
        class="fa fa-random"
        aria-hidden="true"
        style="font-size: 24px"
        @click="randomGeneratorAll"
      ></i>
    </div>
  </div>
  </section>
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
      return this.selectedItems.find((item) => {
        return item.type == type;
      });
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
    randomGeneratorAll() {


      this.types.forEach((type) => {
          this.randomGeneratorForType(type);
      });
          const topBottomOrFull = Math.floor(Math.random() * 2);
          const selectedTop = this.selectedItems.find(item => item.type=='TOP');
          const selectedBottom = this.selectedItems.find(item => item.type=='BOTTOM');
          const selectedFullBody = this.selectedItems.find(item => item.type=='FULLBODY');
          if(topBottomOrFull == 1) {
            this.deselectItem(selectedTop);
            this.deselectItem(selectedBottom);
          }
          else {
            this.deselectItem(selectedFullBody);
          }

    },
    randomGeneratorForType(type) {
      let allClothesOfType = this.getItemsForType(type);
      if (allClothesOfType.length > 0) {
        let randomIndex = Math.floor(Math.random() * allClothesOfType.length);
        this.$store.commit("SELECT_ITEM", allClothesOfType[randomIndex]);
      }
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
        this.selectedItems.forEach((item) => {
          if (item.id == cloth.id) {
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

<style scoped>
.clear-wrapper{
  display: flex;
  justify-content: center ;
  position: absolute;
  top: 120px;
  bottom: 30px;
  left: 140px;
  right: 140px;
  box-shadow: -1px 0 10px rgba(0, 0, 0, 0.6);
  border: 2px solid rgba(255, 255, 255, 0.1);
  border-radius: 25px;
  backdrop-filter: blur(15px);
}

.each-type p{
  font-size: 25px;
  color: black;
  padding-bottom: 20px;
  padding-top: 20px;
  font-weight: 600px;

}
.each-type p:hover{
  color: #1b3536;
  cursor: copy;
}
#selector-area{
  padding-right: 200px;
  overflow: auto;

}
#whole-selector-page {
  display: flex;
  justify-content: space-between;
  margin: 0 auto;
  max-width: 800px; 
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
  overflow: auto;
  box-shadow: -1px 0 10px rgba(0, 0, 0, 0.7);
  border: 2px solid rgba(255, 255, 255, 0.5);
  backdrop-filter: blur(20px);
  top: 90px;
  border-radius: 25px;
  
}
#selected-items-area p{
  font-size: 25px;
  color: black;
  padding-bottom: 20px;
  padding-top: 20px;
}
#selected-items-area p:hover {
  color: #1b3536;
  cursor: copy;
}

img{
  width: 125px;
  height: 155px;
  margin: 3px;
}
</style>